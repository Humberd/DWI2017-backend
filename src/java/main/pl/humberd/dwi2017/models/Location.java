package pl.humberd.dwi2017.models;

public class Location {
    private String locationId;
    private String name;

    public Location(String locationId, String name) {
        this.locationId = locationId;
        this.name = name;
    }

    public String getLocationId() {
        return locationId;
    }

    public Location setLocationId(String locationId) {
        this.locationId = locationId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Location setName(String name) {
        this.name = name;
        return this;
    }
}
