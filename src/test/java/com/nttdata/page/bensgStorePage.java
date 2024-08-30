package com.nttdata.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class bensgStorePage {
    private WebDriver driver;
    private WebDriverWait wait;


    //Localizadores de elementos
    public static final By userInput = By.id("field-email");
    public static final By passInput = By.id("field-password");
    public static final By loginButton = By.id("submit-login");
    /*de aqui para arriba no tocar nada */

    // localizador para el elemento de categoría Clothes
    public static final By getCategory3 = By.xpath("//a[@href='https://qalab.bensg.com/store/es/3-clothes']");
    // localizador para el elemento de sub-categoría Men
    public static final By getCategory4 = By.xpath("//a[@href='https://qalab.bensg.com/store/es/4-men']");




}
