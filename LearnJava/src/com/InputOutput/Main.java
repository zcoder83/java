package com.InputOutput;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String[] names = {"yeon", "mie", "chen"};
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            writer.write("hell world");
            writer.write("\nthis is second line");
            for (String name : names) {
                writer.write("\n" + name);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
