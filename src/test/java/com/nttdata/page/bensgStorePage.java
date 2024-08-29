package com.nttdata.page;

import org.openqa.selenium.By;


public class bensgStorePage {

    //Localizadores de elementos
    public static By emailField = By.id("field-email");
    public static By passwordField = By.id("field-password");
    public static By loginButton = By.cssSelector("submit-login");
    //public static By userInput = By.id("field-email");
    //public static By passInput = By.id("field-password");
    //public static By loginButton = By.id("submit-login");

    // localizador para el elemento de categoría
    public static By category3 = By.id("category-3");

    // localizador para la categoría "Men"
    public static By categoryMen = By.xpath("//li[@class='category']//a[@class='dropdown-item dropdown-submenu' and contains(text(), 'Men')]");

    // localizador para el botón "Añadir al carrito" botón agrego 2 unidades del primer producto al carrito
    public static By addToCartButton = By.xpath("//button[@class='btn btn-primary add-to-cart' and @data-button-action='add-to-cart' and contains(., 'Añadir al carrito')]");

    // localizador usando XPath con atributo personalizado
    //popup la confirmación del producto agregado
    public static By modalContent = By.xpath("//div[@class='modal-content' and @data-testid='unique-modal-content']");

    // localizador para el span que contiene el monto
    public static By priceValue = By.xpath("//span[@class='value' and contains(text(), 'PEN')]");

    //valido el titulo de la pagina del carrito
    public static By logoImage = By.cssSelector("div#_desktop_logo img");

    /*public static By productsTitle = By.cssSelector("span.title");
    public static By itemsCards = By.cssSelector("div.inventory_item");*/
}
