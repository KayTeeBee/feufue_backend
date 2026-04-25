package de.feufue.model.properties;

import java.util.List;

public enum VehicleType {
    
    PKW("PKW", "Personenkraftwagen", List.of("17")),
    MTW("MTW", "Mannschaftstransportwagen", List.of("18")),
    TLF_10("TLF 10", "Tanklöschfahrzeug 10", List.of("20", "21")),
    TLF_20("TLF 20", "Tanklöschfahrzeug 20", List.of("22", "23", "24", "25", "26")),
    DL("DL", "Drehleiter", List.of("30", "31", "32")),
    HAB("HAB", "Hubarbeitsbühne", List.of("34", "35", "36")),
    FWK("FwK", "Feuerwehrkran", List.of("38")),
    LF_10("LF 10", "Löschfahrzeug 10", List.of("40", "41", "42", "43", "44", "45")),
    LF_20("LF 20", "Löschfahrzeug 20", List.of("46", "47", "48")),
    RW("RW", "Rüstungswagen", List.of("50", "51")),
    GW("GW", "Gerätewagen", List.of("54", "55", "56", "57", "58")),
    SW("SW", "Schlauchwagen", List.of("60", "61")),
    WLF("WLF", "Wechselladerfahrzeug", List.of("62", "63", "64")),
    LKW("LKW", "Lastkraftwagen", List.of("65", "66", "67", "68")),
    ITW("ITW", "Itensivtransportwagen", List.of("80")),
    NEF("NEF", "Notarzteinsatzfahrzeug", List.of("82")),
    RTW("RTW", "Rettungswagen", List.of("83")),
    KTW("KTW", "Krankentransportwagen", List.of("85"));


    private final String displayedName;
    private final String vehicleName;
    private final List<String> numbers;

    private VehicleType(String displayedName, String vehicleName, List<String> numbers) {
        this.displayedName = displayedName;
        this.vehicleName = vehicleName;
        this.numbers = numbers;
    }

    public String getDisplayedName() {
        return displayedName;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public List<String> getNumbers() {
        return numbers;
    }

    public VehicleType getVehicleTypeByVehicleName(String vehicleName) {
        VehicleType[] vehicleTypes = values();
        for (VehicleType vt : vehicleTypes) {
            if (vt.getVehicleName().equals(vehicleName)) {
                return vt;
            }
        }
        throw new IllegalArgumentException("No VehicleType with vehicle name " + vehicleName + " found.");
    }

    public VehicleType getVehicleTypeByDisplayedName(String displayedName) {
        VehicleType[] vehicleTypes = values();
        for (VehicleType vt : vehicleTypes) {
            if (vt.getDisplayedName().equals(displayedName)) {
                return vt;
            }
        }
        throw new IllegalArgumentException("No VehicleType with displayed name " + displayedName + " found.");
    }

    public VehicleType getVehicleTypeByNumber(String number) {
        VehicleType[] vehicleTypes = values();
        for (VehicleType vt : vehicleTypes) {
            if (vt.getNumbers().contains(number)) {
                return vt;
            }
        }
        throw new IllegalArgumentException("No VehicleType with number " + number + " found.");
    }

    public VehicleType getVehicleTypeByNumber(int number) {
        return getVehicleTypeByNumber(String.format("%02d", number));
    }
}
