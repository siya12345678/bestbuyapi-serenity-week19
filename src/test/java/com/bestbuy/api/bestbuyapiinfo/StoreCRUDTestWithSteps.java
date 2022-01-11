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

@RunWith(SerenityRunner.class)
public class StoreCRUDTestWithSteps extends TestBase {
    static String id = "20" + TestUtils.getRandomValue();
    static String name = "ipad" + TestUtils.getRandomValue();
    static String type = "tablet";
    static String address = "12";
    static String address2 = "wembley";
    static String city = "London";
    static String state = "abcd";
    static String zip = "HA0 2PR";
    static float lat = 0;
    static float lng = 0;
    static String hours = "string";

    @Steps
    StoresSteps storesSteps;

    @Title("This will get a store list")
    @Test
    public void test001() {

        storesSteps.getAllStores().log().all().statusCode(200);

    }

    @Title("This will create a new stores")
    @Test
    public void test002() {

        storesSteps.createNewStore(name,type,address,address2,city,state,zip,lat,lng,hours);

    }


    @Title("This will get stores by id")
    @Test
    public void test003() {
        storesSteps.getStoresById(id);


    }

    @Title("Update the user information and verify the update information")
    @Test
    public void test004() {
        name = name + "_update";
        storesSteps.updateStores(id, name, type);


    }

    @Title("Delete the Category and verify if the Category is deleted!")
    @Test
    public void test005() {
        storesSteps.deleteStores(id);
        // validate id is delete..
        SerenityRest.given()
                .pathParam("id",id)
                .when()
                .get(EndPoints.GET_SINGLE_CATEGORIES)
                .then()
                .statusCode(404);

    }
}
