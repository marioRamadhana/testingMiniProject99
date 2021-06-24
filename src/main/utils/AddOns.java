package main.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class AddOns {
    public String randomestring(int lenght)
    {
        String generatedstring= RandomStringUtils.randomAlphabetic(lenght);
        return(generatedstring + "Test");
    }

    public static String randomeNum(int lenght) {
        return (RandomStringUtils.randomNumeric(lenght));
    }
}
