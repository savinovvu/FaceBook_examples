package ru.inbox.savinov_vu.main;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static void main(String[] args) {
        String authUrl = "https://www.facebook.com/?sk=h_chr";
        ChromeDriverManager.getInstance().setup();

        WebDriver driver = new ChromeDriver();
        driver.get(authUrl);
        while (true) {

            if (driver.getCurrentUrl().contains("sk=h_nor")) {
                driver.get(authUrl);
            }
        }



    }
}
