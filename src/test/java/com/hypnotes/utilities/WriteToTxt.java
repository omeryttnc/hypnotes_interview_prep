package com.hypnotes.utilities;


import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriteToTxt {



      public static void saveTitle(String fileName, String title){
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter writer  = new BufferedWriter( fileWriter);
                writer.append(title);
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
