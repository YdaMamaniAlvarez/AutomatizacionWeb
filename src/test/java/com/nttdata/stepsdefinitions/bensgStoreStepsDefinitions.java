package com.nttdata.stepsdefinitions;


import com.nttdata.page.bensgStorePage;
import com.nttdata.steps.InventorySteps;
import com.nttdata.steps.bensgSteps;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;
import static com.nttdata.core.DriverManager.scrollDown;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class bensgStoreStepsDefinitions {
    private WebDriver driver;
    private bensgSteps bensgSteps;


    private InventorySteps inventorySteps(WebDriver driver) {
        return new InventorySteps(driver);
    }

    @Given("estoy en la página de la tienda")
    public void estoyEnLaPaginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store/es/iniciar-sesion?back=https%3A%2F%2Fqalab.bensg.com%2Fstore%2Fes%2F");
        screenShot();
    }

    @And("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String email, String password) {
        bensgSteps bensgSteps = new bensgSteps(driver);
        bensgSteps.typeUser(email);
        bensgSteps.typePassword(password);
        bensgSteps.login();
        screenShot();
    }
    //de aqui para arriba no tocar nada

    @When("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String categoria, String subcategoria) {

        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        By categoriaLocator;
        By subcategoriaLocator;

        // Determinar los localizadores basados en los parámetros de entrada
        if (categoria.equalsIgnoreCase("Clothes")) {
            categoriaLocator = bensgStorePage.getCategory3;
        } else {
            throw new IllegalArgumentException("Categoría no soportada: " + categoria);
        }

        // Localizador relativo para la subcategoría dentro de la lista de categorías
        if (subcategoria.equalsIgnoreCase("Men")) {
            subcategoriaLocator = By.xpath("//ul[contains(@class, 'category-sub-menu')]//a[contains(@href, '/4-men')]");
        } else {
            throw new IllegalArgumentException("Subcategoría no soportada: " + subcategoria);
        }

        // Navegar a la categoría
        wait.until(ExpectedConditions.elementToBeClickable(categoriaLocator)).click();
        scrollDown();
        screenShot();


        // Esperar hasta que la subcategoría sea visible dentro del menú antes de intentar hacer clic
        WebElement subcategoriaElement = wait.until(ExpectedConditions.visibilityOfElementLocated(subcategoriaLocator));
        subcategoriaElement.click();
        scrollDown();
        screenShot();
    }


    @And("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int arg0) {
    }

    @Then("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {

    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {

    }

    @When("finalizo la compra")
    public void finalizoLaCompra() {

    }

    @Then("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {

    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
    }
}
