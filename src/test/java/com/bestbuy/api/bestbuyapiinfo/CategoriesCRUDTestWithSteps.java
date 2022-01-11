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
public class CategoriesCRUDTestWithSteps extends TestBase {
    static String id = "1807" +TestUtils.getRandomValue();
    static String name = "philip" + TestUtils.getRandomValue();

    @Steps
    CategoriesSteps categoriesSteps;
    @Title("This will get a Categories list")
    @Test
    public void test001() {
        categoriesSteps.getAllCategories().log().all()
                .statusCode(200);
    }
    @Title("This will create a new categories")
    @Test
    public void test002() {

        categoriesSteps.createCategories(id,name);
    }

    @Title("This will get categories by id")
    @Test
    public void test003(){

        categoriesSteps.getCategoriesById(id);
    }

    @Title("Update the user information and verify the update information")
    @Test
    public void test004(){
        name  = name +"_upadate";
        categoriesSteps.updateCategories(id,name);

    }
    @Title("Delete the Category and verify if the Category is deleted!")
    @Test
    public void test005(){
        categoriesSteps.deleteCategories(id);
        // validate id is delete..
        SerenityRest.given()
                .pathParam("id",id)
                .when()
                .get(EndPoints.GET_SINGLE_CATEGORIES)
                .then()
                .statusCode(404);
    }
}
