package by.epam.programming_with_classes.state.state;

import java.util.Arrays;
import java.util.Objects;

public class Region {

    private String name;
    private City capital;
    public District[] districts;

    public Region(String name, City capital) {
        this.name = name;
        this.capital = capital;
        this.districts = new District[0];
    }

    public Region() {
        this.districts = new District[0];
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

    public District[] getDistricts() {
        return districts;
    }

    public District getDistrict(int index) {
        return districts[index];
    }

    public void setDistricts(District[] districts) {
        this.districts = districts;
    }

    public void setDistrict(District district, int index) {
        this.districts[index] = district;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return Objects.equals(name, region.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Region{" +
                "name='" + name + '\'' +
                '}';
    }
}
