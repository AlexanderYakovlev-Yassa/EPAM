package by.epam.programming_with_classes.state.logic;

import by.epam.programming_with_classes.state.state.City;
import by.epam.programming_with_classes.state.state.District;
import by.epam.programming_with_classes.state.state.Region;
import by.epam.programming_with_classes.state.state.State;

import java.util.Arrays;

public class Logic {

    public double regionArea(Region region) {

        double area = 0;

        if (region != null) {
            for (District d : region.getDistricts()) {
                area += d.getArea();
            }
        }

        return area;
    }

    public double stateArea(State state){

        double area = 0;

        if (state != null){

            for (Region r : state.getRegions()){

                area += regionArea(r);
            }
        }

        return area;
    }

    public District districtByName(Region region, String name){

        District res = null;

        if(region != null && name != null) {

            for (District d : region.getDistricts()) {
                if (name.equals(d.getName())) {
                    res = d;
                    break;
                }
            }
        }

        return res;
    }

    public City addCity(State state, String cityName){

        Logic logic = new Logic();
        City c = logic.CityByName(state, cityName);

        if(state != null && cityName != null) {

            if (c == null) {

                c = new City(cityName);
                state.setCities(Arrays.copyOf(state.getCities(), state.getCities().length + 1));
                state.setCity(c, state.getCities().length - 1);
            }
        }

        return c;
    }

    public int addRegion(State state, Region region){

        int res = 2;

        if(state != null && region != null) {
            for (int i = 0; i < state.getRegions().length; i++) {
                if (region.equals(state.getRegion(i))) {
                    res = 1;
                    break;
                }
            }

            if (res == 2) {
                state.setRegions(Arrays.copyOf(state.getRegions(), state.getRegions().length + 1));
                state.setRegion(region, state.getRegions().length - 1);
                res = 0;
            }
        }

        return res;
    }

    public int addDistrict(Region region, District district) {

        int res = 2;

        if(region != null && district != null) {

            for (int i = 0; i < region.getDistricts().length; i++) {
                if (district.equals(region.getDistricts()[i])) {
                    res = 1;
                    break;
                }
            }

            if (res == 2) {

                region.setDistricts(Arrays.copyOf(region.getDistricts(), region.getDistricts().length + 1));
                region.setDistrict(district, region.getDistricts().length - 1);
                res = 0;
            }
        }

        return res;
    }

    public Region regionByName(State state, String name){

        Region res = null;

        if(state != null && name != null) {

            for (Region r : state.getRegions()) {

                if (name.equals(r.getName())) {
                    res = r;
                    break;
                }
            }
        }

        return res;
    }

    public City CityByName(State state, String name){

        City res = null;

        if(state != null && name != null) {

            for (City c : state.getCities()) {

                if (name.equals(c.getName())) {
                    res = c;
                    break;
                }
            }
        }

        return res;
    }
}
