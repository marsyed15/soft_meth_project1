package vaccine_service;

/**
 Represents locations where vaccine services are being offered. Can check whether
 location is a valid location, i.e if vaccines are offered there.
 @author nabihah, maryam
 */
public enum Location {
    SOMERSET ("08807", "Bridgewater"),
    MIDDLESEX ("08854", "Piscataway"),
    MERCER ("08542", "Princeton"),
    MORRIS ("07960", "Morristown"),
    UNION ("07083", "Union");

    private final String zipCode;
    private final String cityName;

    /**
     Creates Location object with the specified zipCode and cityName
     @param zipCode,cityName string with zipcode and string with cityName
     */
    Location(String zipCode, String cityName) {
        this.zipCode = zipCode;
        this.cityName = cityName;
    }
    /**
     Gets cityName from location
     @return A string object representing the cityName in the location object
     */
    public String getCityName() {
        return this.cityName;
    }

    /**
     Gets zipCode from location
     @return A string object representing the zipCode in the location object
     */
    public String getZipCode() {
        return this.zipCode;
    }
    /**
     Checks if given countyName is valid vaccine location
     @param countyName countyName as String object
     @return true if countyName is valid location, false otherwise
     */
    public static Boolean locationExists(String countyName) {
        Location[] locations = Location.values();
        countyName = countyName.toUpperCase();
        for(Location location: locations) {
            if(location.toString().equals(countyName))
                return true;
        }
        return false;
    }
}
