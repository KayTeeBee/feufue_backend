package de.feufue.model.objects;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import de.feufue.model.properties.GroupState;

public class Group {
    
    private final String uid;
    private final String groupName;
    private final BOSNumber bosNumber;
    private final VehicleOccupancy vehicleOccupancy;
    
    private GroupState groupState;
    private Station currentStation;
    private Set<Station> visitedStations;

    public Group(String groupName, BOSNumber bosNumber, VehicleOccupancy vehicleOccupancy) {
        this.uid = UUID.randomUUID().toString();
        this.groupName = groupName;
        this.groupState = GroupState.INITIAL_WAITING;
        this.bosNumber = bosNumber;
        this.vehicleOccupancy = vehicleOccupancy;
        this.visitedStations = new HashSet<>();
    }

    public String getUid() {
        return uid;
    }

    public String getGroupName() {
        return groupName;
    }

    public GroupState getGroupState() {
        return groupState;
    }

    public Group setOnWay() {
        if (groupState == GroupState.ON_WAY || groupState == GroupState.FINISHED) {
            throw new IllegalStateException("Group cannot be set to ON_WAY if it is currently ON_WAY or FINISHED");
        }
        this.groupState = GroupState.ON_WAY;
        return this;
    }

    public Group setFinished() {
        this.groupState = GroupState.FINISHED;
        return this;
    }

    public Group setAtStation() {
        if (groupState != GroupState.ON_WAY) {
            throw new IllegalStateException("Group cannot be set to AT_STATION if it is currently ON_WAY");
        }
        this.groupState = GroupState.AT_STATION;
        return this;
    }

    public BOSNumber getBosNumber() {
        return bosNumber;
    }

    public VehicleOccupancy getVehicleOccupancy() {
        return vehicleOccupancy;
    }

    public Station getCurrentStation() {
        return currentStation;
    }

    public Group setNewStation(Station currentStation) {
        this.currentStation = currentStation;
        return this;
    }

    public Group completeCurrentStation(){
        if (currentStation != null) {
            visitedStations.add(currentStation);
        }
        return this;
    }

    public Set<Station> getVisitedStations() {
        return visitedStations;
    }

    public boolean hasVisitedStation(Station station) {
        return visitedStations.contains(station);
    }

}
