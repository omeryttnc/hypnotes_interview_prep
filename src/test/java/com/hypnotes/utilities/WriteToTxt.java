package com.hypnotes.utilities;


import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriteToTxt {



      public static void saveTitle(String fileName, String title,boolean append){
        try {
            FileWriter fileWriter = new FileWriter(fileName, append);
            BufferedWriter writer  = new BufferedWriter( fileWriter);
                writer.append(title);
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
      public static void saveTitle(String fileName, int title,boolean append){
        try {
            FileWriter fileWriter = new FileWriter(fileName, append);
            BufferedWriter writer  = new BufferedWriter( fileWriter);
                writer.append(String.valueOf(title));
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
