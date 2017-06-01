package com.aheavenx.spbg.controller;

import java.io.PrintStream;

/**
 * @author Skovorodnikov
 *         Created on 5/31/2017 5:34 PM
 */
public class Hello {
    public static void main(String[] args) {
        try {
            Class.forName("java.lang.System")
                    .getDeclaredField("out")
                    .getType()
                    .getDeclaredMethod("print", String.class)
                    .invoke(
                            Class.forName("java.lang.System").getDeclaredField("out").get(null),
                            "Hello world"
                            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
    }
}
