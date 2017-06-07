package pl.humberd.dwi2017.services;

import org.springframework.stereotype.Service;
import pl.humberd.dwi2017.models.Location;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class LocationDB {
    private final List<Location> list = new ArrayList<>();

    public LocationDB() {
        list.addAll(Arrays.asList(
                new Location("1", "Białystok"),
                new Location("2", "Warszawa"),
                new Location("3","Pcim"),
                new Location("4", "Kraków"),
                new Location("5", "Wrocław")
        ));
    }

    public List<Location> getList() {
        return list;
    }
}
