package com.first_chat_SBT;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Readfile {
    static ArrayList<String> ANSWERS = new ArrayList<String>();
    public static void readFile(String fileName) throws FileNotFoundException {
        File source = new File(fileName);
        Scanner s = new Scanner(source);
        while (s.hasNext()) {
            String nextLine = s.nextLine();
            ANSWERS.add(nextLine);
        }
        s.close();
    }

}
