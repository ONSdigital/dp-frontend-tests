package com.ons.dp.frontend.test.stepdefinitions.florence;

import com.ons.dp.frontend.test.core.TestContext;
import com.ons.dp.frontend.test.page.publish.ProductPage;
import com.ons.dp.frontend.test.stepdefinitions.BaseStepDefinition;
import com.ons.dp.frontend.test.util.AnyData;
import com.ons.dp.frontend.test.util.RandomStringGen;
import cucumber.api.java.en.And;

/**
 * Created by admin on 10/02/2017.
 */
public class ProductPageSteps {

    ProductPage productPage = new ProductPage();
    private BaseStepDefinition baseStepDefinition;

    public ProductPageSteps() {
        this.baseStepDefinition = new BaseStepDefinition();
    }

    @And("^I create a new (.*) page$")
    public void iCreateANewBulletinPage(String pageType) throws Throwable {
        String pageName = RandomStringGen.getRandomString(7);
        String editionName = RandomStringGen.getRandomString(6);
        TestContext.getCacheService().setDataMap("pageName", new AnyData(pageName));
        TestContext.getCacheService().setDataMap("editionName", new AnyData(editionName));
        productPage.createBulletinPage(pageType, pageName, editionName);
    }


}
