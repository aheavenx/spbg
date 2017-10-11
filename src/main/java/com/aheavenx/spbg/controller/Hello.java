package com.aheavenx.spbg.controller;

import java.math.BigInteger;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author Skovorodnikov
 *         Created on 5/31/2017 5:34 PM
 */
public class Hello {
    public static void main(String[] args) {
        try {
            Function<BigInteger, ?> bigIntegerObjectFunction = ((var) -> {
                final BiFunction<BiFunction, BigInteger, ?> fnb = (bfn, bint) -> {
                    String s = new String(new char[]{(char) Integer.parseInt(bint.mod(BigInteger.valueOf(256)).toString())});
                    System.out.println(s);
                    Object apply = bfn.apply(bfn, bint.divide(BigInteger.valueOf(256)));
                    return bint.equals(BigInteger.ZERO) ? "" : s + apply;
                };
                return fnb.apply(fnb, var);
            });

//            Class.forName(
//                    Stream.of(
//                            ((Function<byte[], Byte[]>)
//                                    ($ -> { Byte[] $$ = new Byte[$.length]; Arrays.setAll($$, $$$ -> $[$$$]); return $$; }))
//                                    .apply(new BigInteger(
//                                            Long.toString(0x6b6277622f6d626fL, 16) +
//                                                    Long.toString(0x682f547a7475666eL, 16), 16)
//                                            .toByteArray())
//                    )
//                            .map($ -> $ - 1)
//                            .map($ -> ((char) $.shortValue()))
//                            .collect(StringWriter::new, StringWriter::write, ($, $$) -> $.write($$.toString()))
//                            .toString()
//            )
//                    .getDeclaredField("out")
//                    .getType()
//                    .getDeclaredMethod("print", String.class)
//                    .invoke(
//                            Class.forName(
//                                    Stream.of(
//                                            ((Function<byte[], Byte[]>)
//                                                    ($ -> { Byte[] $$ = new Byte[$.length]; Arrays.setAll($$, $$$ -> $[$$$]); return $$; }))
//                                                    .apply(new BigInteger(
//                                                            Long.toString(0x6e657a6532706572L, 16) +
//                                                                    Long.toString(0x6b32577d77786971L, 16), 16)
//                                                            .toByteArray())
//                                    )
//                                            .map($ -> $ - 4)
//                                            .map($ -> ((char) $.shortValue()))
//                                            .collect(StringWriter::new, StringWriter::write, ($, $$) -> $.write($$.toString()))
//                                            .toString()
//                            ).getDeclaredField("out").get(null),
//                            "Hello world"
            System.out.println(bigIntegerObjectFunction.apply(
                                    BigInteger.valueOf(8026160351752501L)
                                            .multiply(BigInteger.valueOf(100000000000000L))
                                            .add(BigInteger.valueOf(24568770929992L))
                            )
                            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
    }
}
