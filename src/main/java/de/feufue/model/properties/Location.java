package de.feufue.model.properties;

public enum Location {
    
    FKWZ_RENDSBURG("Kreisfeuerwehrzentrale Rendsburg", "01"),
    KREIS_RD_ECK("Kreis Rendsburg-Eckernförde", "02"),
    RENDSBURG("Rendsburg", "10"),
    ECKERNFÖRDE("Eckernförde", "11"),
    NORTORF("Nortorf", "12"),
    ALTENHOLZ("Altenholz", "20"),
    BORDESHOLM("Bordesholm", "21"),
    BUEDELSDORF("Büdelsdorf", "22"),
    HOHENWESTEDT("Hohenwestedt", "23"),
    KRONSHAGEN("Kronshagen", "24"),
    SCHACHT_AUDORF("Schacht-Audorf", "25"),
    WESTERROENFELD("Westerrönfeld", "26"),
    AMT_ACHTERWEHR("Amt Achterwehr", "30"),
    AMT_AUKRUG("Amt Aukrug", "31"),
    AMT_BORDESHOLM_LAND("Amt Bordesholm-Land", "32"),
    AMT_DAENISCHENHAGEN("Amt Dänischenhagen", "33"),
    AMT_DAENISCHER_WOHLD("Amt Dänischer Wohld", "34"),
    AMT_FLINTBEK("Amt Flintbek", "35"),
    AMT_FOCKBEK("Amt Fockbek", "36"),
    GETTORF("Gettorf", "37"),
    AMT_HANERAU_HADEMARSCHEN("Amt Hanerau-Hademarschen", "38"),
    AMT_HOHENWESTEDT_LAND("Amt Hohenwestedt-Land", "39"),
    AMT_HOHNER_HARDE("Amt Hohner Harde", "40"),
    AMT_HUETTEN("Amt Hütten", "41"),
    AMT_JEVENSTEDT("Amt Jevenstedt", "42"),
    AMT_MOLFSEE("Amt Molfsee", "43"),
    AMT_NORTORF_LAND("Amt Nortorf-Land", "44"),
    AMT_OSTERROENFELD("Amt Osterrönfeld", "45"),
    AMT_SCHLEI("Amt Schlei", "46"),
    AMT_SCHWANSEN("Amt Schwansen", "47"),
    AMT_WINDEBY("Amt Windeby", "48"),
    AMT_WITTENSEE("Amt Wittensee", "49"),
    LZG_RENDSBURG("LZG Rendsburg", "50"),
    FLUGPLATZ_HOHN("Flugplatz Hohn", "60");

    private final String location;
    private final String number;

    private Location(String location, String number) {
        this.location = location;
        this.number = number;
    }

    public String getLocation() {
        return location;
    }

    public String getNumber() {
        return number;
    }

    public Location getLocationByNumber(String number) {
        Location[] locations = values();
        for (Location loc : locations) {
            if (loc.getNumber().equals(number)) {
                return loc;
            }
        }
        throw new IllegalArgumentException("No location found for number: " + number);
    }

    public Location getLocationByName(String name) {
        Location[] locations = values();
        for (Location loc : locations) {
            if (loc.getLocation().equalsIgnoreCase(name)) {
                return loc;
            }
        }
        throw new IllegalArgumentException("No location found for name: " + name);
    }

    public Location getLocationByNumber(int number) {
        return getLocationByNumber(String.format("%02d", number));
    }

}
