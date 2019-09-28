public class Test {
    public static void main(String[] args) {
        City s1 = new City("Минск");
        District d1 = new District("Минский", s1,5000, 500.23);
        City s2 = new City("Могилев");
        District d2 = new District("Могилевский", s2,3000, 600.0);
        City s3 = new City("Осиповичи");
        District d3 = new District("Осиповичский", s3,1000, 200.0);
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);

        Region r1 = new Region("Минская", s1);
        r1.addDistrict(d1);
        r1.addDistrict(d2);
        r1.addDistrict(d3);
        System.out.println(r1.addDistrict(d2));

        System.out.println(r1);
        System.out.println(r1.printDistricts());

        State bel = new State("Беларусь", s1);
        System.out.println(bel.addRegion(r1));
        System.out.println(bel);
        System.out.println("");
       // bel.getStateFromFle();
    }
}
