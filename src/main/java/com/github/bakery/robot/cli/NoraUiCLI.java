/**
 * BakeryRobot generated free by NoraUi Organization https://github.com/NoraUi
 * BakeryRobot is licensed under the license BSD.
 * 
 * CAUTION: BakeryRobot use NoraUi library. This project is licensed under the license GNU AFFERO GENERAL PUBLIC LICENSE
 */
package com.github.bakery.robot.cli;

import com.github.noraui.cli.NoraUiCommandLineInterface;
import com.github.noraui.exception.TechnicalException;
import com.github.bakery.robot.indus.Counter;
import com.github.bakery.robot.utils.BakeryRobotContext;

public class NoraUiCLI {
    
    /**
     * Java sample:
     * cd target\classes
     * java -cp . com.github.bakery.robot.cli.NoarUiCLI -h
     * Maven sample:
     * mvn exec:java -Dexec.mainClass="com.github.bakery.robot.cli.NoarUiCLI" -Dexec.args="-h"
     * 
     * @param args
     *            is list of args (-h, --verbose, --interactiveMode, -f, -s, -u, -d, -k, -a, -m, -fi and -re (optional))
     * @throws TechnicalException
	 *            is throws if you have a technical error (NoSuchAlgorithmException | NoSuchPaddingException |
     *            InvalidKeyException | IllegalBlockSizeException | BadPaddingException | IOException,
     *            ...) in NoraUi.
     */
    public static void main(String[] args) throws TechnicalException {
        new NoraUiCommandLineInterface().runCli(BakeryRobotContext.class, Counter.class, args);
    }

}
