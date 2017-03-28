package com.company.qa.Helper;

import java.util.Random;

public class NameGenerator {

    private static String[] Beginning = { "Kro", "Car", "Raa", "Mro", "Cru",
            "Ray", "Bre", "Zed", "Dra", "Mor", "Jag", "Mer", "Jar", "Mol",
            "Zor", "Mad", "Cry", "Zur", "Cre", "Aza", "Azu", "Rei", "Cro",
            "Mar", "Luk" };
    private static String[] Middle = { "air", "ira", "mia", "sor", "mee", "clo",
            "red", "cra", "ark", "arc", "mir", "lor", "cre", "mur", "zer",
            "mar", "zor", "sla", "sal", "urk" };
    private static String[] End = { "dee", "edd", "ark", "arc", "ess", "err", "der",
            "ron", "med", "ure", "zur", "red", "mur" };

    private static Random rand = new Random();

    public static String generateName() {

        return Beginning[rand.nextInt(Beginning.length)]
                + Middle[rand.nextInt(Middle.length)]
                + End[rand.nextInt(End.length)];
    }
}
