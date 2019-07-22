package com.github.bakery.robot.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.Assert;
import org.junit.Test;

import com.github.bakery.robot.utils.BakeryRobotMessages;

public class BakeryRobotMessagesUT {

    @Test
    public void testConstructorIsPrivate() throws Exception {
        Constructor<BakeryRobotMessages> constructor = BakeryRobotMessages.class.getDeclaredConstructor();
        Assert.assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        constructor.setAccessible(true);
        constructor.newInstance();
    }

}
