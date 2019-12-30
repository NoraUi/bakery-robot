/**
 * BakeryRobot generated free by NoraUi Organization https://github.com/NoraUi
 * BakeryRobot is licensed under the license BSD.
 * CAUTION: Id2sRobot use NoraUi library. This project is licensed under the license GNU AFFERO GENERAL PUBLIC LICENSE
 *
 * @author Nicolas HALLOUIN
 * @author Stéphane GRILLON
 */
package com.github.bakery.robot.cucumber.module;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.bakery.robot.application.business.service.ProhibitedBrandsService;
import com.github.bakery.robot.application.business.service.impl.ProhibitedBrandsServiceImpl;
import com.google.inject.Binder;
import com.google.inject.Module;

public class BakeryRobotModule implements Module {

    private static final Logger LOGGER = LoggerFactory.getLogger(BakeryRobotModule.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public void configure(Binder binder) {
        LOGGER.debug("BakeryRobot interceptors binding");
        binder.bind(ProhibitedBrandsService.class).to(ProhibitedBrandsServiceImpl.class).asEagerSingleton();
    }
    
}
