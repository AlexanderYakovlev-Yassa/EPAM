import java.util.Arrays;

public class State {
    private String name;
    private City capital;
    private City[] cities;
    private Region[] regions;

    public State(String name, City capital) {
        this.name = name;
        this.cities = new City[1];
        this.cities[0] = capital;
        this.capital = capital;
        this.regions = new Region[0];
    }

    public State() {
        this.cities = new City[0];
        this.regions = new Region[0];
    }

    /*
     * Gets the city name
     * if such city is exist in the state's cities returns it
     * if such city isn't exist in the state's cities
     * create new city, add it to the state's cities and returns it
     * */
    public City addCity(String cityName){
        City c = getCityByName(cityName);
        if (c == null) {
            c = new City(cityName);
            cities = Arrays.copyOf(cities, cities.length + 1);
            cities[cities.length - 1] = c;
        }
        return c;
    }

    /*
     * Adds district to this.districts
     * returns:
     * 0 - district successful added
     * 1 - such district is already exist in districts
     * */
    public int addRegion(Region region){
        int res = 2;
        for (int i = 0; i < regions.length; i++) {
            if (region.equals(regions[i])){
                res = 1;
                break;
            }
        }
        if (res == 2) {
            regions = Arrays.copyOf(regions, regions.length + 1);
            regions[regions.length - 1] = region;
            res = 0;
        }
        return res;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCapital() {
        return capital;
    }

    public Region[] getRegions() {
        return regions;
    }

    /*
     * returns detail information about the state
     * */
    public String getDetailedInfo(){
    StringBuilder res = new StringBuilder();
        System.out.println(this);
        for (Region reg : this.getRegions()){
            System.out.println("\t" + reg);
            for (District dist: reg.getDistricts()){
                System.out.println("\t\t" + dist);
            }
        }
    return res.toString();
    }

    /*
    * returns city from the state's cities by the city name
    * if such city isn't exist in the state's cities returns null
    * */
    public City getCityByName(String name){
        City res = null;
        for(City c : cities) {
            if (name.equals(c.getName())){
                res = c;
                break;
            }
        }
        return res;
    }

    /*
     * returns region from the state's regions by the region name
     * if such region isn't exist in the state's regions returns null
     * */
    public Region getRegionByName(String name){
        Region res = null;
        for(Region r : regions) {
            if (name.equals(r.getName())){
                res = r;
                break;
            }
        }
        return res;
    }

    /*
    * returns numbers of regions
    * */
    public int getRegionsCount(){
        return regions.length;
    }

    /*
     * returns area of the state
     * */
    public double getArea(){
        double area = 0;
        for (Region r : regions){
            area += r.getArea();
        }
        return area;
    }

    /*
     * returns capitals of the state regions
     * */
    public City[] getRegionCapitals(){
        City[] rCapitals = new City[getRegionsCount()];
        for (int i = 0; i < rCapitals.length; i++) {
            rCapitals[i] = regions[i].getCapital();
        }
        return rCapitals;
    }

    public void setRegions(Region[] regions) {
        this.regions = regions;
    }

    public void setCapital(City capital) {
        this.capital = capital;
    }

    @Override
    public String toString() {
        String res = String.format("Государство %s, столица г. %s", name, capital);
        return res;
    }
}
