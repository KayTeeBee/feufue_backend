package de.feufue.model.objects;

public class FireDepartment {

    private static final String FIRE_DEPARTMENT_PREFIX = "FF";

    private final String locationNumber;
    private final String name;
    private final MapLocation location;

    public FireDepartment(String locationNumber, String name, MapLocation location) {
        this.locationNumber = locationNumber;
        this.name = name;
        this.location = location;
    }

    public String getLocationNumber() {
        return locationNumber;
    }

    public String getName() {
        return FIRE_DEPARTMENT_PREFIX + " " + name;
    }

    public MapLocation getLocation() {
        return location;
    }

}
