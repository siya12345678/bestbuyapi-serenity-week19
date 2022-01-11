package com.bestbuy.api.bestbuyapiinfo;

import com.bestbuy.api.constants.EndPoints;
import com.bestbuy.api.testbase.TestBase;
import com.bestbuy.api.utils.TestUtils;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

//@RunWith(SerenityRunner.class)
public class ProductsCRUDTestWithSteps extends TestBase {

    static String id = "150115" +TestUtils.getRandomValue();
    static String name = "siya" + TestUtils.getRandomValue();
    static String type = "electronics";
    static double price = 10.50;
    static String upc = "219372";
    static double shipping = 10.40;
    static String description = "siya electronics";
    static String manufacturer = "siya store";
    static String model = "String";
    static String url = "String";
    static String image = "String";


    @Steps
    ProductsSteps productsSteps;


    @Title("This will get a product list")
    @Test
    public void test001(){
        productsSteps.getAllProducts().log().all()
                .statusCode(200);
    }
    @Title("This will create a new products")
    @Test
    public void test002(){
        productsSteps.createProducts(name,type,price,shipping,upc,description,manufacturer,model,url,image);


    }
    @Title("This will get products by id")
    @Test
    public void test003(){
        productsSteps.getProductsById(id);

    }
    @Title("Update the user information and verify the update information")
    @Test
    public void test004(){
        name = name + "-update";
        productsSteps.updateProducts(id,name,type);

    }
    @Title("Delete the Category and verify if the Category is deleted!")
    @Test
    public void test005(){
        productsSteps.deleteProducts(id);
        // validate id is delete..
        SerenityRest.given()
                .pathParam("id",id)
                .when()
                .get(EndPoints.GET_SINGLE_CATEGORIES)
                .then()
                .statusCode(404);
    }
    }







