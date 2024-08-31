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

    // localizador para el elemento de categoría Clothes
    public static final By getCategory3 = By.xpath("//a[@href='https://qalab.bensg.com/store/es/3-clothes']");
    // localizador para el elemento de sub-categoría Men
    public static final By getCategory4 = By.xpath("//a[@href='https://qalab.bensg.com/store/es/4-men']");
    /*de aqui para arriba no tocar nada */

    //Localizador para elemento Producto en sección Men
    public static final By primerProductoMen = By.xpath("//a[@href='https://qalab.bensg.com/store/es/men/1-1-hummingbird-printed-t-shirt.html#/1-tamano-s/8-color-blanco']");

    //Localizador para el elemento botón spin Up para aumentar cantidad de productos
    public static final By btnSpinUpProducto = By.xpath("//button/i[contains(@class, 'touchspin-up')]");






}
