package com.flyboydevs.aoc.aoc2015;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

public class Day4 {

    public String part1(String passphrase, String hashBeginsWith) throws NoSuchAlgorithmException {
        String phraseThatPays = "";
        String result="";
        int counter = 0;
        MessageDigest m = MessageDigest.getInstance("MD5");
        do {
            phraseThatPays = passphrase + counter;
            m.reset();
            m.update(phraseThatPays.getBytes());
            result = DatatypeConverter.printHexBinary(m.digest());
            counter++;
        } while (!result.startsWith(hashBeginsWith));

        System.out.println(result);
        System.out.println(phraseThatPays);
        return phraseThatPays.replace(passphrase,"");
    }

}
