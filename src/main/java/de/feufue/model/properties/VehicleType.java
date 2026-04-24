package de.feufue.model.properties;

public enum VehicleType {
    
    WACHE("Wache", "00"),
    LANDESLEITUNG("Landesleitung", "01"),
    AMTSLEITUNG("Amtsleitung", "02"),
    GEMEINDELEITUNG("Gemeindeleitung", "03")
    ORTSLEITUNG("Ortsleitung", "04"),
    EINSATZABSCHNITTSLEITUNG("Einsatzabschnittsleitung", "05"),
    EINHEITSFUEHRUNG("Einheitsführung", "06"),
    FERNMELDEBETRIEBSDIENST("Fernmeldebetriebsdienst", "07"),
    FACHBERATUNG("Fachberatung", "08"),
    FF("Führungsfahrzeug", "10"),
    ELW_FUEHRUNG("ELW Führung", "11"),
    ELW_STABSFUEHRUNG("ELW Stabsführung", "12"),
    F_TECH("Fahrzeug zur technischen Unterstüzung", "13"),
    F_ORGA("Fahrzeug zur organisatorischen Unterstüzung", "14"),
    KR("Kraftrad", "15"),
    LB("Luftbeobachter", "16"),
    PKW("PKW", "17"),
    MTW("MTW", "18"),
    TLF_10_25("TLF 10/25", "20"),
    TLF_10_25_SONDERLOESCHMITTEL("TLF 10/25 mit Sonderlöschmittel", "21"),
    TLF_20_35("TLF 20/35", "22"),
    TLF_20_35_SONDERLOESCHMITTEL("TLF 20/35 mit Sonderlöschmittel", "23"),
    TLF_20_50("TLF 20/50", "24"),
    TLF_20_50_SONDERLOESCHMITTEL("TLF 20/50 mit Sonderlöschmittel", "25"),
    TLF_20_U50("TLF 20/Ü50", "26"),
    FZ_SONDERLOESCHMITTEL("Fahrzeug mit Sonderlöschmittel", "27"),
    SONSTIGE_TLF("Sonstige TLF", "29"),
    DLK_K18_12("DLK K18/12", "30"),
    DLK_18_12("DLK 18/12", "31"),
    DLK_23_12("DLK 23/12", "32"),
    HAB_K18_12("HAB K18/12", "34"),
    HAB_18_12("HAB 18/12", "35"),
    HAB_23_12("HAB 23/12", "36"),
    FWK("FWK", "37"),
    LF_10("LF 10", "40"),
    LF_10_05("LF 10/05", "41"),
    LGF_10("LGF 10", "42"),
    LGF_10_05("LGF 10/05", "43"),
    LGF_10_05_PFPN("LGF 10/05 mit PFPN", "44"),
    LGF_10_05_TH("LGF 10/05 TH", "45"),
    LGF_20_10("LGF 20/10", "46"),
    LGF_20_10_PFPN("LGF 20/10 mit PFPN", "47"),
    LGF_20_10_TH("LGF 20/10 TH", "48"),
    SONSTIGE_LF("Sonstige LF", "49");

    private final String displayedName;
    private final String number;

    private VehicleType(String displayedName, String number) {
        this.displayedName = displayedName;
        this.number = number;
    }

    public String getDisplayedName() {
        return displayedName;
    }

    public String getNumber() {
        return number;
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
            if (vt.getNumber().equals(number)) {
                return vt;
            }
        }
        throw new IllegalArgumentException("No VehicleType with number " + number + " found.");
    }

    public VehicleType getVehicleTypeByNumber(int number) {
        return getVehicleTypeByNumber(String.format("%02d", number));
    }
}
