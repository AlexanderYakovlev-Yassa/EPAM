package by.epam.programming_with_classes.state.state;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCapital() {
        return capital;
    }

    public void setCapital(City capital) {
        this.capital = capital;
    }

    public Region[] getRegions() {
        return regions;
    }

    public Region getRegion(int index) {
        return regions[index];
    }

    public void setRegions(Region[] regions) {
        this.regions = regions;
    }

    public void setRegion(Region region, int index) {
        this.regions[index] = region;
    }

    public City[] getCities() {
        return cities;
    }

    public City getCity(int index) {
        return cities[index];
    }

    public void setCities(City[] cities) {
        this.cities = cities;
    }

    public void setCity(City city, int index) {
        this.cities[index] = city;
    }

    @Override
    public String toString() {
        String res = String.format("Государство %s, столица г. %s", name, capital);
        return res;
    }
}
