/**
 * BakeryRobot generated free by NoraUi Organization https://github.com/NoraUi
 * BakeryRobot is licensed under the license BSD.
 * CAUTION: Id2sRobot use NoraUi library. This project is licensed under the license GNU AFFERO GENERAL PUBLIC LICENSE
 *
 * @author Nicolas HALLOUIN
 * @author Stéphane GRILLON
 */
package com.github.bakery.robot.cucumber.injector;

import java.util.stream.Stream;

import org.slf4j.Logger;

import com.github.bakery.robot.cucumber.module.BakeryRobotModule;
import com.github.noraui.cucumber.injector.NoraUiInjector;
import com.github.noraui.cucumber.injector.NoraUiInjectorSource;
import com.github.noraui.exception.TechnicalException;
import com.github.noraui.log.annotation.Loggable;
import com.google.inject.Guice;
import com.google.inject.Injector;

@Loggable
public class BakeryRobotInjectorSource extends NoraUiInjectorSource {

    static Logger log;

    /**
     * {@inheritDoc}
     */
    @Override
    public Injector getInjector() {
        Injector injector = Guice.createInjector(super.stage, () -> Stream.concat(super.noraUiModules.stream(), Stream.of(new BakeryRobotModule())).iterator());
        try {
            NoraUiInjector.createInjector(injector);
        } catch (TechnicalException e) {
            log.error("Id2sInjectorSource.getInjector()", e);
        }
        return injector;
    }
    
}
