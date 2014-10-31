package com.github.valentinaesposito.mostra.utils;

/**
 * Created by Peppe on 30/10/2014.
 */
public class Properties {

    public static final String DB_USERNAME = "DB_USERNAME";
    public static final String DB_PASSWORD = "DB_PASSWORD";
    public static final String DB_URL = "DB_URL";
    public static final String TEST_ENV = "TEST_ENV";

    public static String get(String variable) {
        return System.getenv(variable);
    }

}
