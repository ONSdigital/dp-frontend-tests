package com.ons.dp.frontend.test.page.webpage;

import com.ons.dp.frontend.test.core.TestContext;
import com.ons.dp.frontend.test.model.DataTable;
import com.ons.dp.frontend.test.page.BasePage;
import org.junit.Assert;

public class ProductPage extends BasePage {
    private String businessinvestmentpage = getConfig().getOnsdevelop_URL() + "economy/grossdomesticproductgdp/datasets/businessinvestment";

    public void clickPreviousVersionsLink() {
        click(getlinkText("Previous versions"));
    }

    public void navigateToBusinessInvestmentDatasetPage() {
        navigateToUrl(businessinvestmentpage);
    }

    public int getPublishedVersionRows() {
        DataTable dataTable = new DataTable(true);
        return dataTable.numberOfRows;
    }

    public void seeTheNewTimeSeriesUploaded() {


    }

}
