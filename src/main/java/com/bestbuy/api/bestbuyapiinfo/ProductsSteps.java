package com.bestbuy.api.bestbuyapiinfo;

import com.bestbuy.api.constants.EndPoints;
import com.bestbuy.api.model.ProductsPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class ProductsSteps {

    @Step("Get the all products")
    public ValidatableResponse getAllProducts(){
        return SerenityRest
                .given().log().all()
                .header("Content-Type","application/json")
                .when()
                .get(EndPoints.GET_ALL_PRODUCTS)
                .then();
    }

    @Step("Creating new categories with setName: {0},setType: {1}, setPrice:{2}, setUpc{3}, setShipping{4},setDescription: {5},setManufacturer: {6},setModel: {7},setUrl: {8},setImage: {9}" )
    public ValidatableResponse createProducts(String name,String type,double price,double shipping,
                                              String upc,String description,String manufacturer,
                                              String model,String url,String image){
        ProductsPojo productsPojo = new ProductsPojo();
        productsPojo.setName(name);
        productsPojo.setType(type);
        productsPojo.setPrice(price);
        productsPojo.setShipping(shipping);
        productsPojo.setUpc(upc);
        productsPojo.setDescription(description);
        productsPojo.setManufacturer(manufacturer);
        productsPojo.setModel(model);
        productsPojo.setUrl(url);
        productsPojo.setImage(image);

        return SerenityRest
                .given().log().all()
                .header("Content-type","application/json")
                .body(productsPojo)
                .when()
                .post(EndPoints.GET_ALL_PRODUCTS)
                .then();

    }
    @Step("Updating products with setName:{0},setType:{1}")
    public ValidatableResponse updateProducts(String id, String name, String type){
        ProductsPojo productsPojo = new ProductsPojo();
        productsPojo.setName(name);
        productsPojo.setType(type);

        return SerenityRest
                .given().log().all()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .body(productsPojo)
                .patch(EndPoints.UPDATE_PRODUCTS_BY_ID)
                .then();

    }
    @Step("Delete products information with productsID:{0}")
    public ValidatableResponse deleteProducts(String id){

        return SerenityRest
                .given()
                .pathParam("id",id)
                .log().all()
                .when()
                .get(EndPoints.DELETE_PRODUCTS_BY_ID)
                .then();
    }
    @Step("Getting products information with productsId :{0}")
    public ValidatableResponse getProductsById(String id){
        return SerenityRest
                .given()
                .log().all()
                .pathParam("id",id)
                .when()
                .get(EndPoints.GET_SINGLE_PRODUCTS)
                .then()
                .statusCode(200).log().ifValidationFails();

    }

}
