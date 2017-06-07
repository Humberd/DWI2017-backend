package pl.humberd.dwi2017.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.humberd.dwi2017.models.Location;
import pl.humberd.dwi2017.services.LocationDB;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/")
public class LocationController {
    private final LocationDB locationDB;

    @Autowired
    public LocationController(LocationDB locationDB) {
        this.locationDB = locationDB;
    }

    @GetMapping("/locations")
    public ResponseEntity<List<Location>> getLocationsList() {
        return ResponseEntity.ok(this.locationDB.getList());
    }

    @GetMapping("/locations/{locationId}")
    public ResponseEntity<Location> getLocation(@PathVariable String locationId) {
        Location result = Flux.fromIterable(this.locationDB.getList())
                .filter(location -> Objects.equals(location.getLocationId(), locationId))
                .blockFirst();
        if (result == null) {
            return ResponseEntity.status(404).build();
        } else {
            return ResponseEntity.ok(result);
        }
    }
}
