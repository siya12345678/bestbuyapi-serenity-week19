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
public class ServicesCRUDTestWithSteps extends TestBase {

    static String id = "12" + TestUtils.getRandomValue();
    static String name = "Samsung Services" + TestUtils.getRandomValue();



    @Steps
    ServicesSteps servicesSteps;
    @Title("This will get a Services list")
    @Test
    public void test001() {

        servicesSteps.getAllServices().log().all().statusCode(200);

    }

    @Title("This will create a new services")
    @Test
    public void test002() {

        servicesSteps.createServices(name);

    }


    @Title("This will get services by id")
    @Test
    public void test003() {
        servicesSteps.getServicesById(id);
    }

    @Title("Update the user information and verify the update information")
    @Test
    public void test004(){

        name = name + "_Updated";

        servicesSteps.updateServices(id,name);


    }
    @Title("Delete the Category and verify if the Category is deleted!")
    @Test
    public void test005() {
        servicesSteps.deleteServices(id);
        // validate id is delete..
        SerenityRest.given()
                .pathParam("id",id)
                .when()
                .get(EndPoints.GET_SINGLE_CATEGORIES)
                .then()
                .statusCode(404);

    }



}
