package de.feufue.service;

import java.util.Comparator;
import java.util.Set;

import de.feufue.model.objects.Group;
import de.feufue.model.objects.MapLocation;
import de.feufue.model.objects.Station;
import de.feufue.model.properties.StationState;
import de.feufue.util.GroupUtils;
import de.feufue.util.MapLocationUtils;

public class RoutingService {
    
    private static RoutingService instance;

    private final Set<Station> allStations;

    private RoutingService(Set<Station> allStations) {
        this.allStations = allStations;
    }

    public static RoutingService getInstance(Set<Station> allStations) {
        if (instance == null) {
            instance = new RoutingService(allStations);
        }
        return instance;
    }

    public Station findNextStation(Group group) {
        MapLocation currentPosition = GroupUtils.getCurrentPosition(group);
        return allStations.stream()
                .filter(station -> isValid(station, group))
                .min(Comparator.comparingDouble(station ->
                        MapLocationUtils.calculateUTMDistance(currentPosition, station.getLocation())))
                .orElse(null);
    }

    private boolean isValid(Station station, Group group) {
        StationState stationState = station.getStationState();
        return ((stationState == StationState.AVAILABLE) || (stationState == StationState.WAITING))
                && !group.hasVisitedStation(station);
    }

}
