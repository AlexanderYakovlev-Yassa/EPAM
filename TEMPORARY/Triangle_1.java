import java.lang.Math;

public class Triangle_1 {
    private double xA;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;
    private boolean exist;

    public Triangle_1(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.xA = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.exist = isTriangleExist(x1, y1, x2, y2, x3, y3);
    }

    public static void main(String[] args) {
        double x = Double.MAX_VALUE;//
        double y = Double.MAX_VALUE;//0;
        //Triangle_1 t = new Triangle_1(0,a,0,100,100,100);
        System.out.println(lineLength(x, 0, y, 0));
    }

    private static boolean isEachPointsExist(double x1, double y1, double x2, double y2, double x3, double y3) {//checked
        return (!Double.isNaN(x1) && !Double.isInfinite(x1)) && (!Double.isNaN(y1) && !Double.isInfinite(y1)) &&
                (!Double.isNaN(x2) && !Double.isInfinite(x2)) && (!Double.isNaN(y2) && !Double.isInfinite(y2)) &&
                (!Double.isNaN(x3) && !Double.isInfinite(x3)) && (!Double.isNaN(y3) && !Double.isInfinite(y3));
    }

    private static boolean isEachPointUnique(double x1, double y1, double x2, double y2, double x3, double y3) {//checked
        return !((x1 == x2) && (y1 == y2)) &&
                !((x1 == x3) && (y1 == y3)) &&
                !((x2 == x3) && (y2 == y3));
    }

    private static boolean isPointsNotInSameLine(double x1, double y1, double x2, double y2, double x3, double y3) {//checked
        double tgAB = (y1 - y2) / (x1 - x2);
        double tgAC = (y1 - y3) / (x1 - x3);
        return tgAB != tgAC;
    }

    private static boolean isTriangleExist(double x1, double y1, double x2, double y2, double x3, double y3) {//checked
        return isEachPointsExist(x1, y1, x2, y2, x3, y3) &&
                isEachPointUnique(x1, y1, x2, y2, x3, y3) &&
                isPointsNotInSameLine(x1, y1, x2, y2, x3, y3);
    }

    public double getX1() {
        return xA;
    }

    public double getY1() {
        return y1;
    }

    public double getX2() {
        return x2;
    }

    public double getY2() {
        return y2;
    }

    public double getX3() {
        return x3;
    }

    public double getY3() {
        return y3;
    }

    public boolean isExist() {
        return exist;
    }

    private static double lineLength(double x1, double y1, double x2, double y2) {
        double dX = x1 - x2;
        double dY = y1 - y2;
        double lineLength = Math.sqrt(dX * dX + dY * dY);
        return lineLength;
    }

    private double perimeter(){
        if(exist){
            double lengthAB = lineLength(xA,y1,x2,y2);
        }
    }

    // private boolean checkTriangleCoordinates(double x1, double y1, double x2, double y2, double x3, double y3){

    //}

}
