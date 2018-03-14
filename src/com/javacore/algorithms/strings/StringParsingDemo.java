package com.javacore.algorithms.strings;

import java.io.StringReader;
import java.util.Scanner;

public class StringParsingDemo {
    public static void main(String[] args) {
        String data = "John;    McDouglas; 34; Texas Instrument;Senior Engineer";
//
//        for (String line: data.split("[;]+"))
//        {
//            System.out.println(line.trim());
//        }
        try(StringReader strReader = new StringReader(data);
            Scanner in = new Scanner(strReader);)
        {
            in.useDelimiter("[;]+");
            while (in.hasNext())
            {
                System.out.println(in.next().trim());
            }
        }

//        StringReader strReader = null;
//        try
//        {
//            strReader = new StringReader(data);
//        }catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//        finally {
//            if (strReader != null)
//                try{
//                    strReader.close();
//                }catch (Exception e)
//                {
//
//                }
//        }
    }
}
