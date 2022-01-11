package com.bestbuy.api.bestbuyapiinfo;

import com.bestbuy.api.constants.EndPoints;
import com.bestbuy.api.model.StoresPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class StoresSteps {

    @Step("Get the all Stores ")
    public ValidatableResponse getAllStores() {
        return SerenityRest
                .given().log().all()
                .header("Content-Type", "application/json")
                .when()
                .get (EndPoints.GET_ALL_STORES)
                .then();
    }

    @Step("Creating new Store with name: {0}, type: {1}, address: {2}, address2: {3}, city: {4}, state: {5}, zip {6}, lat {7}, lng {8} and hours {9}")

    public ValidatableResponse createNewStore(String name, String type, String address, String address2, String city, String state
            , String zip,float lat, float lng, String hours) {

        StoresPojo storePojo = new StoresPojo();

        storePojo.setName(name);
        storePojo.setType(type);
        storePojo.setAddress(address);
        storePojo.setAddress2(address2);
        storePojo.setCity(city);
        storePojo.setState(state);
        storePojo.setZip(zip);
        storePojo.setLat(lat);
        storePojo.setLng(lng);
        storePojo.setHours(hours);

        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .body(storePojo)
                .when()
                .post(EndPoints.GET_ALL_STORES)
                .then();

    }
    @Step("Updating stores with setName: {0}, setType: {1}, "
    )
    public ValidatableResponse updateStores(String id, String name, String type) {

        StoresPojo storesPojo = new StoresPojo();
        storesPojo.setName(name);
        storesPojo.setType(type);


        return SerenityRest
                .given().log().all()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(storesPojo)
                .when()
                .patch(EndPoints.UPDATE_STORES_BY_ID)
                .then()
                .statusCode(200);
    }


    @Step("Delete categories information with categoriesID: {0}")
    public ValidatableResponse deleteStores(String id) {

        return SerenityRest
                .given()
                .pathParam("id", id)
                .log().all()
                .when()
                .delete(EndPoints.DELETE_STORES_BY_ID)
                .then()
                .statusCode(200);

    }


    @Step("Getting categories information with categoriesId :{0}")
    public ValidatableResponse getStoresById(String id) {

        return SerenityRest
                .given()
                .pathParam("id", id)
                .log().all()
                .when()
                .get(EndPoints.GET_SINGLE_STORES)
                .then()
                .statusCode(200).log().all();

    }



}
