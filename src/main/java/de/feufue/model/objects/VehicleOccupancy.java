package de.feufue.model.objects;

public class VehicleOccupancy {
    
    private static final String OCCUPANCY_SEPARATOR = "-";

    private final int numFirefighters;
    private final int numMachinists;

    public VehicleOccupancy(int numFirefighters, int numMachinists) {
        this.numFirefighters = numFirefighters;
        this.numMachinists = numMachinists;
    }

    public int getNumFirefighters() {
        return numFirefighters;
    }

    public int getNumMachinists() {
        return numMachinists;
    }

    public String getFullOccupancy() {
        return numFirefighters + OCCUPANCY_SEPARATOR + numMachinists;
    }

}
