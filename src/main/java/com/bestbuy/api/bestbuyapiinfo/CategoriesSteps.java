package com.bestbuy.api.bestbuyapiinfo;

import com.bestbuy.api.constants.EndPoints;
import com.bestbuy.api.model.CategoriesPojo;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;


public class CategoriesSteps {

    @Step("Get the all Categories ")
    public ValidatableResponse getAllCategories() {
        return SerenityRest
                .given().log().all()
                .header("Content-Type", "application/json")
                .when()
                .get(EndPoints.GET_ALL_CATEGORIES)
                .then();
    }
    @Step("Creating new categories with setName: {0},setId {1}")
    public ValidatableResponse createCategories(String id,String name) {
        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setId(id);
        categoriesPojo.setName(name);
        return SerenityRest
                .given().log().all()
                .header("Content-Type", "application/json")
                .body(categoriesPojo)
                .when()
                .post(EndPoints.GET_ALL_CATEGORIES)
                .then();
    }

    @Step("Updating categories with setName : {0}")
    public ValidatableResponse updateCategories(String id,String name){
        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setId(id);
        categoriesPojo.setName(name);
        return  SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .pathParam("id",id)
                .body(categoriesPojo)
                .when()
                .put(EndPoints.UPDATE_CATEGORIES_BY_ID)
                .then().log().all().statusCode(200);
    }

    @Step("Delete categories information with categoriesID: {0}")
    public ValidatableResponse deleteCategories(String id){
        return  SerenityRest.given().log().all()
                .pathParam("id", id)
                .when()
                .delete(EndPoints.DELETE_CATEGORIES_BY_ID)
                .then().statusCode(200);
    }

    @Step("Getting categories information with categoriesId :{0}")
    public ValidatableResponse getCategoriesById (String id){
        return  SerenityRest.given().log().all()
                .pathParam("id",id)
                .when()
                .get(EndPoints.GET_SINGLE_CATEGORIES)
                .then().statusCode(200).log().ifValidationFails();
    }

}
