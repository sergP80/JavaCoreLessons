package com.javacore.algorithms.strings;

import java.util.Arrays;

public class StringParseDemo {

    public static void main(String[] args) {
        String src[] = {
                "John Mu; 40; 123.05",
                "Lue Mayers; 30; 150.25",
                "Nick Jo; 27; 200.35"
        };
        int minAge = -1, idx = -1;
        for (int j = 0; j < src.length; ++j) {
            String items[] = src[j].split("[;]+");
            for (int i = 1; i < items.length; ++i) {
                try {
                    int age = Integer.parseInt(items[1].trim());
                    if (minAge < 0 || age < minAge) {
                        minAge = age;
                        idx = j;
                    }
                } catch (Exception e) {
                }

            }

        }
        if (idx >=0 )
        {
            System.out.printf(
                    "The youngest employee [%s]", src[idx]
            );
        }
    }

}
