package de.feufue.model.objects;

public class MapLocation {
    
    private final Integer utmX;
    private final Integer utmY;
    private final double globalLatitude;
    private final double globalLongitude;

    public MapLocation(double globalLatitude, double globalLongitude) {
        this(null, null, globalLatitude, globalLongitude);
    }

    public MapLocation(Integer utmX, Integer utmY, double globalLatitude, double globalLongitude) {
        this.utmX = utmX;
        this.utmY = utmY;
        this.globalLatitude = globalLatitude;
        this.globalLongitude = globalLongitude;
    }

    public int getUtmX() {
        return utmX.intValue();
    }

    public int getUtmY() {
        return utmY.intValue();
    }

    public double getGlobalLatitude() {
        return globalLatitude;
    }

    public double getGlobalLongitude() {
        return globalLongitude;
    }

    public boolean isUTMLocation() {
        return (utmX != null) && (utmY != null);
    }

}
