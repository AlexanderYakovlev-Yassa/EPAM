public enum Transportation {
    AIR("самолет"),
    BUS("автобус"),
    TRAIN("ж.д. транспорт"),
    SHIP("морской транспорт");
    String rusName;

    Transportation(String rusName) {
        this.rusName = rusName;
    }
}
