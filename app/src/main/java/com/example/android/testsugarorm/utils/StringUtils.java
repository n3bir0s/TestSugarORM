package com.example.android.testsugarorm.utils;

/**
 * Project: TestORM
 *
 * @package: com.example.android.testsugarorm.utils
 * <p>
 * Created by Sven on 10.11.2016..
 * DwS-Solutions.com - All rights reserved  - Copyright (c) 2016
 */
public class StringUtils {

   // public StringUtils(){}

    /**
     * Returns first characters from string ( it can be sentence too)
     * @param text
     * @return firstLetters - first letters of word/s
     */
    public static String getFirstLetters(String text)
    {
        String firstLetters = "";
        for(String s : text.split(" "))
        {
            firstLetters += s.charAt(0);
        }
        return firstLetters;
    }
}
