package de.feufue.model.objects;

public class BOSNumber {
    
    private static final String BOS_NUMBER_SEPARATOR = "-";

    private final String locationNumber;
    private final String vehicleNumber;
    private final String countNumber;

    public BOSNumber(String locationNumber, String vehicleNumber, String countNumber) {
        this.locationNumber = locationNumber;
        this.vehicleNumber = vehicleNumber;
        this.countNumber = countNumber;
    }

    public String getLocationNumber() {
        return locationNumber;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getCountNumber() {
        return countNumber;
    }

    public String getFullNumber() {
        return locationNumber + BOS_NUMBER_SEPARATOR + vehicleNumber + BOS_NUMBER_SEPARATOR + countNumber;
    }

}
