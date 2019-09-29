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

    /*
     * Adds district to this.districts
     * returns:
     * 0 - district successful added
     * 1 - such district is already exist in districts
     * */
    public int addDistrict(District district) {
        int res = 2;
        for (int i = 0; i < districts.length; i++) {
            if (district.equals(districts[i])) {
                res = 1;
                break;
            }
        }
        if (res == 2) {
            districts = Arrays.copyOf(districts, districts.length + 1);
            districts[districts.length - 1] = district;
            res = 0;
        }
        return res;
    }

    public String printDistricts() {
        StringBuilder res = new StringBuilder();
        for (District d : districts) {
            res.append(d + "\n");
        }
        res.append("\b");
        return res.toString();
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

    public void setDistricts(District[] districts) {
        this.districts = districts;
    }

    /*
     * returns district from the region's districts by the district name
     * if such district isn't exist in the region's district returns null
     * */
    public District getDistrictByName(String name){
        District res = null;
        for(District d : districts) {
            if (name.equals(d.getName())){
                res = d;
                break;
            }
        }
        return res;
    }

    public double getArea(){
        double area = 0.0;
        for (District d : districts){
            area += d.getArea();
        }
        return area;
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
        String res = String.format("%s область, обл. центр г. %s", name, capital);
        return res;
    }
}
