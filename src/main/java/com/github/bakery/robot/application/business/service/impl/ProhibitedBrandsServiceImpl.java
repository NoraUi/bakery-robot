/**
 * BakeryRobot generated free by NoraUi Organization https://github.com/NoraUi
 * BakeryRobot is licensed under the license BSD.
 * CAUTION: Id2sRobot use NoraUi library. This project is licensed under the license GNU AFFERO GENERAL PUBLIC LICENSE
 *
 * @author Nicolas HALLOUIN
 * @author Stéphane GRILLON
 */
package com.github.bakery.robot.application.business.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;

import com.github.bakery.robot.application.business.service.ProhibitedBrandsService;
import com.github.noraui.log.annotation.Loggable;
import com.google.inject.Singleton;

@Loggable
@Singleton
public class ProhibitedBrandsServiceImpl implements ProhibitedBrandsService {

    public static Logger log;

    // Tabaco
    private static final String MARLBORO = "Marlboro";
    private static final String CAMEL = "Camel";
    private static final String PHILIPPE_MORRIS = "philippe morris";

    // Alcool
    private static final String HEINEKEN = "heineken";
    private static final String ZUBROWKA = "zubrowka";
    private static final String JACK_DANIELS = "jack daniels";

    private List<String> tabaco = new ArrayList<>(Arrays.asList(MARLBORO, CAMEL, PHILIPPE_MORRIS));
    private List<String> alcool = new ArrayList<>(Arrays.asList(HEINEKEN, ZUBROWKA, JACK_DANIELS));

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getTabaco() {
        return tabaco;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getAlcool() {
        return alcool;
    }
    
}
