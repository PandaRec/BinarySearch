package com.company;

import java.io.*;
import java.util.ArrayList;

public class WorkInFile {
    private static int a = 41;
    private static int c = 11119;
    private static int m = 11113;
    private static int seed = 1;

    public void write(){
        try(FileWriter writer = new FileWriter("notes.txt", false))
        {
            ArrayList<Integer> arr = generateValues();

            for(int i=0;i<arr.size();i++){
                writer.append(arr.get(i).toString());
                writer.append(" ");
            }

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

    private  ArrayList<Integer> generateValues(){

        ArrayList<Integer> result = new ArrayList<>();
        for(int i =0; i<10000000;i++){
            result.add(getNextRandom());
        }
        return result;
    }

    private int getNextRandom()
    {
        seed = (a * seed + c) % m;
        return seed;
    }

    public ArrayList<Integer> ReadFile(){
        ArrayList<Integer> arr = new ArrayList<>();
        try {
            File file = new File("notes.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                //System.out.println(line);

                String[] strings = line.split(" ");
                for(int i=0;i<strings.length;i++){
                    arr.add(Integer.parseInt(strings[i]));
                }

                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
}
}
