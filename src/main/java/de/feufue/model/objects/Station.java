package de.feufue.model.objects;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

import de.feufue.model.properties.StationState;

public class Station {
    
    private final String uid;
    private final String name;
    private final MapLocation location;
    private final Queue<Group> waitingGroups;
    private final Map<String, Integer> groupIdToTimeAtStation;
    
    private StationState stationState;
    private int averageTimeAtStation;

    public Station(String name, MapLocation location) {
        this.uid = UUID.randomUUID().toString();
        this.name = name;
        this.location = location;
        this.stationState = StationState.AVAILABLE;
        averageTimeAtStation = 0;
        waitingGroups = new ConcurrentLinkedQueue<>();
        groupIdToTimeAtStation = new HashMap<>();
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

    public int getAverageTimeAtStation() {
        return averageTimeAtStation;
    }

    public Station setAverageTimeAtStation(int averageTimeAtStation) {
        this.averageTimeAtStation = averageTimeAtStation;
        return this;
    }

    public Queue<Group> getWaitingGroups() {
        return waitingGroups;
    }

    public Station addWaitingGroup(Group group) {
        waitingGroups.add(group);
        return this;
    }

    public Station removeWaitingGroup(Group group) {
        waitingGroups.remove(group);
        return this;
    }

    public int getNumWaitingGroups() {
        return waitingGroups.size();
    }

}
