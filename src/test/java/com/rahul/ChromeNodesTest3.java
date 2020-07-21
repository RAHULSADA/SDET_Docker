package com.rahul;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeNodesTest3 {

    @Test
    public void test3() throws MalformedURLException {
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        URL url = new URL("http://localhost:4444/wd/hub");
        RemoteWebDriver driver = new RemoteWebDriver(url, cap);
        driver.get("http://hotmail.com");
        System.out.println(driver.getTitle());
    }

}
