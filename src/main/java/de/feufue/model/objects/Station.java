package de.feufue.model.objects;

import java.util.UUID;

import de.feufue.model.properties.StationState;

public class Station {
    
    private final String uid;
    private final String name;
    private final MapLocation location;
    private StationState stationState;

    public Station(String name, MapLocation location) {
        this.uid = UUID.randomUUID().toString();
        this.name = name;
        this.location = location;
        this.stationState = StationState.AVAILABLE;
    }

    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public MapLocation getLocation() {
        return location;
    }

    public StationState getStationState() {
        return stationState;
    }

    public void setStationState(StationState stationState) {
        this.stationState = stationState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;   
        }
        if (o instanceof Station station) {
            return uid.equals(station.getUid());
        }
        return false;
    }

    @Override
    public String toString() {
        return "Station[" +
               "uid='" + uid + '\'' +
               ", name='" + name + '\'' +
               ", location=" + location +
               ", stationState=" + stationState +
              ']';
    }

    @Override
    public int hashCode() {
        return uid.hashCode();
    }

}
