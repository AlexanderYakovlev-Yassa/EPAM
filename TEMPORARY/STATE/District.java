import java.util.Objects;

public class District {
    private String name;
    private City center;
    private int population;
    private double area;

    public District(String name, City center, int population, double area) {
        this.name = name;
        this.center = center;
        this.population = population;
        this.area = area;
    }

    public District() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCenter() {
        return center;
    }

    public void setCenter(City center) {
        this.center = center;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        District district = (District) o;
        return Objects.equals(name, district.name);
    }

    @Override
    public String toString() {
        String res = String.format("%s район, районный центр г. %s, площадь %s кв.км, населене %s человек.", name, center, area, population);
        return res;
    }
}
