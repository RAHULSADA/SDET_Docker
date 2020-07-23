package com.rahul;

import com.rahul.Utilities.Constants;
import com.rahul.Utilities.Utilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ChromeNodesTest1 {

    DockerOperations dockerOperations = new DockerOperations();

    @BeforeTest
    public void startDocker() throws IOException, InterruptedException {
        Utilities.deleteFile(Constants.DOCKERLOGS);
        dockerOperations.dockerUp();
    }

    @AfterTest
    public void stopDocker() throws IOException, InterruptedException {
        dockerOperations.dockerDown();
    }

    @Test
    public void test1() throws MalformedURLException {
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        URL url = new URL("http://localhost:4444/wd/hub");
        RemoteWebDriver driver = new RemoteWebDriver(url, cap);
        driver.get("http://www.google.com");
        System.out.println(driver.getTitle());
    }

}
