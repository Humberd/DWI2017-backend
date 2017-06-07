package pl.humberd.dwi2017.models;

public class Author {
    private String authorId;
    private String name;
    private String surname;
    private String locationId;

    public Author(String authorId, String name, String surname, String locationId) {
        this.authorId = authorId;
        this.name = name;
        this.surname = surname;
        this.locationId = locationId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public Author setAuthorId(String authorId) {
        this.authorId = authorId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Author setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public Author setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getLocationId() {
        return locationId;
    }

    public Author setLocationId(String locationId) {
        this.locationId = locationId;
        return this;
    }
}
