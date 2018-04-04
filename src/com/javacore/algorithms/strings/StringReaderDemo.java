package com.javacore.algorithms.strings;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.util.Scanner;

public class StringReaderDemo {
    public static void main(String[] args)
    {
        String fileName = "res/ddd.ddd";
        try(Scanner in = new Scanner(new File(fileName)))
        {
            while(in.hasNextLine())
            {
                String line = in.nextLine().trim();
                if (line == null || line.isEmpty())
                {
                    continue;
                }
                try(Scanner reader = new Scanner(new StringReader(line)))
                {
                    reader.useDelimiter("[\\s+,?!.–-]+");
                    while(reader.hasNext())
                    {
                        System.out.println("==>" + reader.next());
                    }
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
