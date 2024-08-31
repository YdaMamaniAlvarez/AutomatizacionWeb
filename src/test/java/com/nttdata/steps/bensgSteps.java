package com.nttdata.steps;

import com.nttdata.page.bensgStorePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class bensgSteps {
    private WebDriver driver;
    private WebDriverWait wait;

    //constructor
    public bensgSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));

    }

    /* Escribir el usuario */
    public void typeUser(String user) {
        WebElement userInputElement = driver.findElement(bensgStorePage.userInput);
        userInputElement.sendKeys(user);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bensgStorePage.loginButton));
    }

    /* Escribir el password */
    public void typePassword(String password) {
        driver.findElement(bensgStorePage.passInput).sendKeys(password);
    }

    /* Hacer click en el botón login */
    public void login() {
        driver.findElement(bensgStorePage.loginButton).click();
    }

   
    public void spinUp() {
        driver.findElement(bensgStorePage.btnSpinUpProducto).click();
    }

}
