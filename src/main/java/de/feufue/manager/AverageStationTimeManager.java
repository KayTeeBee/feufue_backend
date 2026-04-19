package de.feufue.manager;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import de.feufue.model.objects.Group;
import de.feufue.model.objects.Station;

public class AverageStationTimeManager {
    
    private static AverageStationTimeManager instance;

    private final Map<Station, Map<String, Timer>> stationToGroupTimes;
    
    private AverageStationTimeManager() {
        this.stationToGroupTimes = new HashMap<>();
    }

    public static AverageStationTimeManager getInstance() {
        if (instance == null) {
            instance = new AverageStationTimeManager();
        }
        return instance;
    }

    public AverageStationTimeManager registerGroupAtStation(Group group, Station station) throws Exception {

        stationToGroupTimes.putIfAbsent(station, new HashMap<>());
        Map<String, Timer> groupIdToTimes = stationToGroupTimes.get(station);
        if (groupIdToTimes.containsKey(group.getUid())) {
            throw new Exception("Group is already registered at this station");
        }
        
        
        return this;
    }

}
