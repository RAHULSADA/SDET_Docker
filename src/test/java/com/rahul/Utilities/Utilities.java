package com.rahul.Utilities;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Utilities {

//    Returns true if text is present in file
    public static Boolean checkFile(String logs) {
        try {
            File file = new File(Constants.DOCKERLOGS);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                if (scanner.nextLine().contains(logs))
                    return true;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
        return false;
    }

    public static void runBatchFile(String cmd) throws IOException, InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        runtime.exec(cmd);
        Thread.sleep(Constants.BATCHSTARTTIME);
    }

    public static void deleteFile(String fileName) {
        File file = new File(fileName);
        file.delete();
        System.out.println("File deleted: " + fileName);
    }
}
