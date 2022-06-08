package com.strobogrammatic_numbers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Strobogrammatic {
    /**
     * this list store series of Strogrammtic numnber for 1 digit.
     */
    private final List<String> singleDigitList =
            new ArrayList<>(Arrays.asList("0", "1", "8"));
    /**
     * for storing digit pair before and after rotation.
     */
    private final char[][] digitPair =
            {{'0', '0'}, {'1', '1'}, {'8', '8'}, {'6', '9'}, {'9', '6'}};

    /**
     * for finding out strobogrammatic number series according to digit.
     * @param stobogrammaticDigit it takes strobogrammatic digit.
     * @return it returns list of strobogrammatic numbers.
     */
    public List<String> findStrobogrammatic(final int stobogrammaticDigit) {
        return helperRecursive(stobogrammaticDigit, stobogrammaticDigit);
    }

    /**
     * for to perform recursive call for get all possible combination.
     * @param stobogrammaticDigit .
     * @param stobogrammaticDigitLength .
     * @return return series of strobogrammatic numbers.
     */
    public List<String> helperRecursive(final int stobogrammaticDigit,
                                        final int stobogrammaticDigitLength) {
        if (stobogrammaticDigit <= 0) {
            return new ArrayList<>(List.of(""));
        } else if (stobogrammaticDigit == 1) {
            return singleDigitList;
        }
        List<String> subListOfStobogrammaticNumber =
                helperRecursive(stobogrammaticDigit - 2,
                        stobogrammaticDigitLength);
        List<String> stobogrammaticNumberlist = new ArrayList<>();
        for (String middleOfStrobogrammaticNumber
                : subListOfStobogrammaticNumber) {
            if (stobogrammaticDigit != stobogrammaticDigitLength) {
                stobogrammaticNumberlist.add(
                        "0" + middleOfStrobogrammaticNumber + "0");
            }
            for (int index = 1; index < digitPair.length; index++) {
                stobogrammaticNumberlist.add(
                        digitPair[index][0] + middleOfStrobogrammaticNumber
                                + digitPair[index][1]);
            }
        }
        return stobogrammaticNumberlist;
    }
}
