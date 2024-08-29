package com.nttdata.stepsdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;


public class bensgStoreStepsDefinitions {
    private WebDriver driver;
    private double precioTotal;


    @Given("estoy en la página de la tienda")
    public void estoyEnLaPaginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store/es/");
        screenShot();
    }
    @And("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String email, String password) {
        screenShot();
    }

    @When("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String categoria, String subcategoria) {
        driver.findElement(By.linkText(categoria)).click();
        driver.findElement(By.linkText(subcategoria)).click();
        screenShot();
    }

    @And("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int cantidad) {
        WebElement producto = driver.findElement(By.cssSelector(".product-item:first-child"));
        double precioUnitario = Double.parseDouble(producto.findElement(By.className("price")).getText().replace("$", ""));
        precioTotal = precioUnitario * cantidad;

        for (int i = 0; i < cantidad; i++) {
            producto.findElement(By.className("add-to-cart")).click();
        }
    }

    @Then("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmacionDelProductoAgregado() {
        WebElement popup = driver.findElement(By.id("confirmation-popup"));
        Assert.assertTrue("El popup de confirmación no es visible", popup.isDisplayed());
        Assert.assertTrue("El mensaje de confirmación es incorrecto",
                popup.getText().contains("Producto agregado al carrito"));
    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        WebElement popupTotal = driver.findElement(By.id("popup-total"));
        double popupTotalPrice = Double.parseDouble(popupTotal.getText().replace("$", ""));
        Assert.assertEquals("El monto total en el popup no coincide", precioTotal, popupTotalPrice, 0.01);
    }

    @When("finalizo la compra")
    public void finalizoLaCompra() {
        driver.findElement(By.id("finalizar-compra")).click();
    }

    @Then("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        Assert.assertEquals("El título de la página del carrito es incorrecto",
                "Carrito de Compras", driver.getTitle());
    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        WebElement cartTotal = driver.findElement(By.id("cart-total"));
        double cartTotalPrice = Double.parseDouble(cartTotal.getText().replace("$", ""));
        Assert.assertEquals("El monto total en el carrito no coincide", precioTotal, cartTotalPrice, 0.01);
    }
}
