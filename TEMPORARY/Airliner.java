public enum Airliner {
    A220("Airbus A220"),
    A320("Airbus A320 family"),
    B737300("Boeing 737-300"),
    B737500("Boeing 737-500"),
    B737800("Boeing 737-800"),
    B737M8("Boeing 737 MAX 8"),
    B7767300("Boeing 767-300ER"),
    CRJ100("Bombardier CRJ 100ER"),
    CRJ200("Bombardier CRJ 200ER"),
    E175("Embraer 175"),
    E195("Embraer 195");

    public String longName;

    Airliner(String longName){
        this.longName = longName;
    }

    @Override
    public String toString() {
        return longName;
    }
}
