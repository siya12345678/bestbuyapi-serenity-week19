package com.bestbuy.api.bestbuyapiinfo;

import com.bestbuy.api.constants.EndPoints;
import com.bestbuy.api.model.ServicesPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class ServicesSteps {
    @Step("Get the all Services ")
    public ValidatableResponse getAllServices() {
        return SerenityRest.rest()
                .given().log().all()
                .header("Content-Type", "application/json")
                .when()
                .get(EndPoints.GET_ALL_SERVICES)
                .then();
    }


    @Step("Creating new services with setName: {0}")

    public ValidatableResponse createServices(String name) {


        ServicesPojo servicesPojo = new ServicesPojo();
        servicesPojo.setName(name);

        return SerenityRest.rest()
                .given().log().all()
                .header("Content-Type", "application/json")
                .body(servicesPojo)
                .when()
                .post(EndPoints.GET_ALL_SERVICES)
                .then()
                .statusCode(201);
    }

    @Step("Updating services with setName: {0}")

    public ValidatableResponse updateServices(String id, String name) {

        ServicesPojo servicesPojo = new ServicesPojo();
        servicesPojo.setName(name);

        return SerenityRest
                .given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .log().all()
                .body(servicesPojo)
                .when()
                .put(EndPoints.UPDATE_SERVICES_BY_ID)
                .then()
                .statusCode(200).log().all();
    }


    @Step("Delete categories information with categoriesID: {0}")
    public ValidatableResponse deleteServices(String id) {

        return SerenityRest
                .given().log().all()
                .pathParam("id", id)
                .log().all()
                .when()
                .delete(EndPoints.DELETE_SERVICES_BY_ID)
                .then()
                .statusCode(200).log().all();

    }

    @Step("Getting categories information with categoriesId :{0}")
    public ValidatableResponse getServicesById(String id) {

        return SerenityRest
                .given().log().all()
                .pathParam("id", id)
                .when()
                .get(EndPoints.GET_SINGLE_SERVICES)
                .then()
                .statusCode(200).log().ifValidationFails();

    }
}


