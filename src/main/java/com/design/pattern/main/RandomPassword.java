package com.design.pattern.main;

import org.apache.commons.lang3.RandomStringUtils;

import java.security.SecureRandom;
import java.util.Random;

/**
 * @author DAO TUAN ANH (DENNIS).
 * @created on 6/1/18.
 */
public class RandomPassword {

    public static void main(String[] args) {
        System.out.println(RandomStringUtils.randomAscii(16));
        final String genPass = generateRandomePassword(16);
        System.out.println(genPass);
        System.out.println(genPass.getBytes().length);
    }

    private static String generateRandomePassword(int len) {
        char[] ch = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
                'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
                'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
                'w', 'x', 'y', 'z', '!', '@', '#', '$', '%', '^', '&', '*',
                '(', ')', '?', '<', '>', ';', ':', '\'', '"'};

        char[] c=new char[len];
        Random random = new SecureRandom();
        for (int re = 0; re < 100; re++) {
            for (int i = 0; i < len; i++) {
                c[i]=ch[random.nextInt(ch.length)];
            }
        }
        return new String(c);
    }
}
