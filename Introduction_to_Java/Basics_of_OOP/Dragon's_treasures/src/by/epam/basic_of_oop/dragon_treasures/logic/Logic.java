package by.epam.basic_of_oop.dragon_treasures.logic;

import by.epam.basic_of_oop.dragon_treasures.tresure.Treasure;
import by.epam.basic_of_oop.dragon_treasures.tresure.Treasures;

import java.io.*;

public class Logic {

    public Treasures readFromDataFile() {

        Treasures treasures = new Treasures();
        String name;
        int cost;
        String description;
        Treasure tempTreasure;

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("src\\by\\epam\\basic_of_oop" +
                    "\\dragon_treasures\\data\\treasures.dat"));
            String tmp = "";
            while ((tmp = br.readLine()) != null) {

                    String[] s = tmp.split("/");
                    try {
                        name = s[0];
                        cost = Integer.parseInt(s[1]);
                        description = s[2];
                        treasures.add(new Treasure(name, cost, description));
                    } catch (Exception e) {}
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return treasures;
    }

    public Treasures cheapTreasures(Treasures treasures, int maxCost){

        Treasures cheapTreasures = new Treasures();

        if (treasures != null) {
            for (Treasure tr : treasures.getTreasures()) {

                if (tr.getCost() <= maxCost) {
                    cheapTreasures.add(tr);
                }
            }
        }

        return cheapTreasures;
    }

    public Treasure mostExpensiveTreasure(Treasures treasures){

        Treasure treasure = null;

        if (treasures != null && treasures.getTreasures().length > 0){

            treasure = treasures.getTreasures(0);

            for (Treasure tr : treasures.getTreasures()) {

                treasure = (tr.getCost() > treasure.getCost()) ? tr : treasure;
            }
        }

        return treasure;
    }


}
