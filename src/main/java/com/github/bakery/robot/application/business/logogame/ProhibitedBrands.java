/**
 * BakeryRobot generated free by NoraUi Organization https://github.com/NoraUi
 * BakeryRobot is licensed under the license BSD.
 * CAUTION: BakeryRobot use NoraUi library. This project is licensed under the license GNU AFFERO GENERAL PUBLIC LICENSE
 * 
 * @author Nicolas HALLOUIN
 * @author Stéphane GRILLON
 */
package com.github.bakery.robot.application.business.logogame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProhibitedBrands {

    // Tabaco
    private static final String MARLBORO = "Marlboro";
    private static final String CAMEL = "Camel";
    private static final String PHILIPPE_MORRIS = "philippe morris";

    // Alcool
    private static final String HEINEKEN = "heineken";
    private static final String ZUBROWKA = "zubrowka";
    private static final String JACK_DANIELS = "jack daniels";
    
    private List<String> tabaco = new ArrayList<>(Arrays.asList(MARLBORO,CAMEL,PHILIPPE_MORRIS));
    private List<String> alcool = new ArrayList<>(Arrays.asList(HEINEKEN,ZUBROWKA,JACK_DANIELS));

    public List<String> getTabaco() {
        return tabaco;
    }

    public List<String> getAlcool() {
        return alcool;
    }

}
