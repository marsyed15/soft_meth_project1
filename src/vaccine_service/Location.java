package vaccine_service;

import java.util.Locale;

public enum Location {
    // You must use an enum class to define the 5 locations available for vaccination appointments. Use the
    //county names as the constant names and define the zip codes and city names as the properties accordingly.
    SOMERSET ("08807", "Bridgewater"),
    MIDDLESEX ("08854", "Piscataway"),
    MERCER ("08542", "Princeton"),
    MORRIS ("07960", "Morristown"),
    UNION ("07083", "Union");

    private final String zipCode;
    private final String cityName;

    Location(String zipCode, String cityName) {
        this.zipCode = zipCode;
        this.cityName = cityName;
    }

    public String getCityName() {
        return this.cityName;
    }
    public String getZipCode() {
        return this.zipCode;
    }

    public static Boolean locationExists(String countyName) {
        Location[] locations = Location.values();
        for(Location location: locations) {
            if(locations.equals(countyName.toUpperCase()) == true)
                return true;
        }
        return false;
    }
}
