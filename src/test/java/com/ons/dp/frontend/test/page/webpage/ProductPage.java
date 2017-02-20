package com.ons.dp.frontend.test.page.webpage;

import com.ons.dp.frontend.test.model.DataTable;
import com.ons.dp.frontend.test.page.BasePage;
import com.ons.dp.frontend.test.util.CustomDates;
import org.junit.Assert;
import org.openqa.selenium.By;

public class ProductPage extends BasePage {
    public By page_title = By.cssSelector(".page-intro__title");
    public By release_date = By.xpath("//div[@class='col-wrap']/p[2]");
    public By first_section_text = By.cssSelector("#section-1>header>h2");
    public By chart_title = By.cssSelector(".flush--third--vertical");
    public By chart_subtitle = By.cssSelector(".flush--third--bottom");
    public By chart_units = By.cssSelector(".highcharts-yaxis-title");
    public By chart_data_preview_firstrow = By.cssSelector(".highcharts-axis-labels.highcharts-xaxis-labels>span");
    public By chart_data_preview_secondrow = By.cssSelector(".highcharts-axis-labels.highcharts-xaxis-labels>span:last-child");
    public By chart_data_preview_firstcolumn = By.xpath("//div[@class='highcharts-legend']/div/div/div[1]/span");
    public By chart_data_preview_secondcolumn = By.xpath("//div[@class='highcharts-legend']/div/div/div[2]/span");
    public By chart_finish_at_100 = By.cssSelector(".highcharts-axis-labels.highcharts-yaxis-labels>span:nth-child(6)");
    public By chart_source = By.cssSelector(".flush--third--bottom.font-size--h6");
    public By chart_notes = By.cssSelector(".markdown-chart-container.panel--bottom-mar.print--avoid-break>p");
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

    public void verifyChartData(String pageName, String editionName) {

        Assert.assertTrue(getElementText(page_title).contains(pageName + ": " + editionName));
        Assert.assertTrue(getElementText(release_date).contains(CustomDates.getDateInDiffFormat(+1)));
        Assert.assertTrue(getElementText(first_section_text).contains("Section 1"));
        Assert.assertTrue(getElementText(chart_title).contains("Figure 2: Percentage of VAT and/or PAYE based enterprises by year"));

        Assert.assertTrue(getElementText(chart_subtitle).contains("UK, 2005 to 2010"));
        Assert.assertTrue(getElementText(chart_units).contains("%"));
        Assert.assertTrue(getElementText(chart_data_preview_firstrow).contains("2010"));
        Assert.assertTrue(getElementText(chart_data_preview_secondrow).contains("2011"));
        Assert.assertTrue(getElementText(chart_data_preview_firstcolumn).contains("Sole Proprietors and Partnerships"));
        Assert.assertTrue(getElementText(chart_data_preview_secondcolumn).contains("Companies and Public Corporations"));
        Assert.assertTrue(getElementText(chart_finish_at_100).contains("100"));
        Assert.assertTrue(getElementText(chart_source).contains("Source: Office for National Statistics"));
        Assert.assertTrue(getElementText(chart_notes).contains("This is the chart for PAYE and Companies data of 2010 and 2011"));

    }
}
