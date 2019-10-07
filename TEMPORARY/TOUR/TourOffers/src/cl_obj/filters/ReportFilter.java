package cl_obj.filters;

public class ReportFilter {
    private boolean id;
    private boolean name;
    private boolean type;
    private boolean transportation;
    private boolean hotel;
    private boolean food;
    private boolean days;

    public ReportFilter() {
        this.id = true;
        this.name = true;
        this.type = true;
        this.transportation = true;
        this.hotel = true;
        this.food = true;
        this.days = true;
    }

    public boolean isId() {
        return id;
    }

    public void setId(boolean id) {
        this.id = id;
    }

    public boolean isName() {
        return name;
    }

    public void setName(boolean name) {
        this.name = name;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public boolean isTransportation() {
        return transportation;
    }

    public void setTransportation(boolean transportation) {
        this.transportation = transportation;
    }

    public boolean isHotel() {
        return hotel;
    }

    public void setHotel(boolean hotel) {
        this.hotel = hotel;
    }

    public boolean isFilterFood() {
        return food;
    }

    public void setFilterFood(boolean filterFood) {
        this.food = filterFood;
    }

    public boolean isDays() {
        return days;
    }

    public void setDays(boolean days) {
        this.days = days;
    }
}
