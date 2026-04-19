package de.feufue.util;

import de.feufue.model.objects.MapLocation;

public class MapLocationUtils {
    
    public static double calculateUTMDistance(MapLocation location1, MapLocation location2) {
        if (!location1.isUTMLocation() || !location2.isUTMLocation()) {
            throw new IllegalArgumentException("Both locations must have valid UTM coordinates.");
        }

        int utmXDiff = location2.getUtmX() - location1.getUtmX();
        int utmYDiff = location2.getUtmY() - location1.getUtmY();
        return Math.sqrt(Math.pow(utmXDiff, 2) + Math.pow(utmYDiff, 2));
    }

}
