package cl_obj.library;

public enum Transportation {
    AIR("самолет"),
    BUS("автобус"),
    TRAIN("ж.д. транспорт"),
    SHIP("морской транспорт");
    private String rusName;

    Transportation(String rusName) {
        this.rusName = rusName;
    }

    public String getRusName() {
        return rusName;
    }
}
