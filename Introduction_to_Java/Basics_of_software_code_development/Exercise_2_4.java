// Заданы размеры А, В прямоугольного отверстия и размеры х, у, z кирпича.
//Определить, пройдет ли кирпич через отверстие.

public class Exercise_2_4 {

    public static void main(String[] args){
        int holeLength = 120;
        int holeWidth = 70;
        int brickDim1 = 65;
        int brickDim2 = 250;
        int brickDim3 = 120;

        System.out.println(isFit(holeLength, holeWidth, brickDim1, brickDim2, brickDim3));
    }

    public static boolean isFit(int holeDim1, int holeDim2, int brickDim1, int brickDim2, int brickDim3){
        int maxHoleDim;
        int minHoleDim;
        int minBrickDim;
        int midBrickDim;

        if (holeDim1 >= holeDim2) {     //
            maxHoleDim = holeDim1;      //
            minHoleDim = holeDim2;      //detect min and max
        } else {                        //dimension of hole
            maxHoleDim = holeDim2;      //
            minHoleDim = holeDim1;      //
        }

        if (brickDim1 >= brickDim2){            //
            minBrickDim = brickDim2;            //
            midBrickDim = brickDim1;            //
        } else {                                //
            minBrickDim = brickDim1;            //
            midBrickDim = brickDim2;            // detect min and mid
        }                                       // dimention of brick
        if (brickDim3 < minBrickDim ){          //
            midBrickDim = minBrickDim;          //
            minBrickDim = brickDim3;            //
        } else if (brickDim3 < midBrickDim) {   //
            midBrickDim = brickDim3;            //
        }

        //System.out.println(brickDim1 + " " + brickDim2 + " " + brickDim3);
        //System.out.println("min = " + minBrickDim + "  mid=" + midBrickDim);

        return (minBrickDim <= minHoleDim) && (midBrickDim <= maxHoleDim);
    }

}
