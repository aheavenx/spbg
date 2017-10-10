package com.aheavenx.spbg.controller;

import java.io.PrintStream;
import java.io.StringWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author Skovorodnikov
 *         Created on 5/31/2017 5:34 PM
 */
public class Hello {
    public static void main(String[] args) {
        try {
            Class.forName(
                    Stream.of(
                            ((Function<byte[], Byte[]>)
                                    ($ -> { Byte[] $$ = new Byte[$.length]; Arrays.setAll($$, $$$ -> $[$$$]); return $$; }))
                                    .apply(new BigInteger(
                                            Long.toString(0x6b6277622f6d626fL, 16) +
                                                    Long.toString(0x682f547a7475666eL, 16), 16)
                                            .toByteArray())
                    )
                            .map($ -> $ - 1)
                            .map($ -> ((char) $.shortValue()))
                            .collect(StringWriter::new, StringWriter::write, ($, $$) -> $.write($$.toString()))
                            .toString()
            )
                    .getDeclaredField("out")
                    .getType()
                    .getDeclaredMethod("print", String.class)
                    .invoke(
                            Class.forName(
                                    Stream.of(
                                            ((Function<byte[], Byte[]>)
                                                    ($ -> { Byte[] $$ = new Byte[$.length]; Arrays.setAll($$, $$$ -> $[$$$]); return $$; }))
                                                    .apply(new BigInteger(
                                                            Long.toString(0x6e657a6532706572L, 16) +
                                                                    Long.toString(0x6b32577d77786971L, 16), 16)
                                                            .toByteArray())
                                    )
                                            .map($ -> $ - 4)
                                            .map($ -> ((char) $.shortValue()))
                                            .collect(StringWriter::new, StringWriter::write, ($, $$) -> $.write($$.toString()))
                                            .toString()
                            ).getDeclaredField("out").get(null),
                            "Hello world"
                            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
    }
}
