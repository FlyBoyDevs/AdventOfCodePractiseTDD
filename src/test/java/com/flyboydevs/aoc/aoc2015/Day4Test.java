package com.flyboydevs.aoc.aoc2015;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day4Test {

    Day4 cut;

    @BeforeEach
    void setUp() {
        cut = new Day4();
    }

    @Test
    void part1_example1()
            throws NoSuchAlgorithmException {
        assertEquals("609043", cut.part1("abcdef", "00000"));
    }

    @Test
    void part1_example2()
            throws NoSuchAlgorithmException {
        assertEquals("1048970", cut.part1("pqrstuv", "00000"));
    }

    @Test
    void part1_example3()
            throws NoSuchAlgorithmException {
        assertEquals("254575", cut.part1("bgvyzdsv", "00000"));
    }


    @Test
    void part2_example1()
            throws NoSuchAlgorithmException {
        assertEquals("6742839", cut.part1("abcdef", "000000"));
    }

    @Test
    void part2_example2()
            throws NoSuchAlgorithmException {
        assertEquals("5714438", cut.part1("pqrstuv", "000000"));
    }

    @Test
    void part2_example3()
            throws NoSuchAlgorithmException {
        assertEquals("1038736", cut.part1("bgvyzdsv", "000000"));
    }


//    @Test
//    public void givenPassword_whenHashing_thenVerifying()
//            throws NoSuchAlgorithmException {
//        String hash = "35454B055CC325EA1AF2126E27707052";
//        String password = "ILoveJava";
//
//        MessageDigest md = MessageDigest.getInstance("MD5");
//        md.update(password.getBytes());
//        byte[] digest = md.digest();
//        String myHash = DatatypeConverter
//                .printHexBinary(digest).toUpperCase();
//        assertTrue(myHash.equals(hash));
//    }

}
