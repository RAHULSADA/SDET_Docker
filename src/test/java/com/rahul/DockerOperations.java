package com.rahul;

import com.rahul.Utilities.Constants;
import com.rahul.Utilities.Utilities;

import java.io.IOException;
import java.time.LocalDateTime;

public class DockerOperations {

    public void dockerUp() throws IOException, InterruptedException {
        Utilities.runBatchFile(Constants.DOCKERUP);
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime secs = localDateTime.plusSeconds(60);
        Boolean dockerUp = false;
        while (LocalDateTime.now().isBefore(secs)) {
            if (Utilities.checkFile(Constants.DOCKERUPTEXT)) {
                System.out.println("Docker started!!");
                dockerUp = true;
                break;
            }
        }
        Utilities.runBatchFile(Constants.DOCKERSCALE);
        Thread.sleep(Constants.DOCKERSCALETIME);
        if (!dockerUp)
            System.out.println("Docker not started");

    }

    public void dockerDown() throws IOException, InterruptedException {
        Utilities.runBatchFile(Constants.DOCKERDOWN);
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime secs = localDateTime.plusSeconds(30);
        while (LocalDateTime.now().isBefore(secs)) {
            if (Utilities.checkFile(Constants.DOCKERDOWNTEXT)) {
                System.out.println("Docker shutdown!!");
                break;
            }
        }
    }
}
