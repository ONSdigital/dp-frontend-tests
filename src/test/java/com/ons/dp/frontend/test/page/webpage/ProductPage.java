package com.ons.dp.frontend.test.page.webpage;

import com.ons.dp.frontend.test.model.DataTable;
import com.ons.dp.frontend.test.page.BasePage;
import com.ons.dp.frontend.test.util.CustomDates;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductPage extends BasePage {
    public By page_title = By.cssSelector(".page-intro__title");
    public By release_date = By.xpath("//div[@class='col-wrap']/p[2]");
    public By first_section_text = By.cssSelector("#section-1>section>header>h2");
    public By chart_title = By.cssSelector(".flush--third--vertical");
    public By chart_subtitle = By.cssSelector(".flush--third--bottom");
    public By chart_units = By.cssSelector(".highcharts-yaxis-title");
    public By bar_chart_data_preview_firstrow = By.cssSelector(".highcharts-axis-labels.highcharts-xaxis-labels>span:nth-child(1)");
    public By bar_chart_data_preview_secondrow = By.cssSelector(".highcharts-axis-labels.highcharts-xaxis-labels>span:nth-child(2)");
    public By bar_chart_data_preview_thirdrow = By.cssSelector(".highcharts-axis-labels.highcharts-xaxis-labels>span:nth-child(3)");

    public By line_chart_data_preview_firstrow = By.cssSelector(".highcharts-axis-labels.highcharts-xaxis-labels>span:nth-child(3)");
    public By line_chart_data_preview_secondrow = By.cssSelector(".highcharts-axis-labels.highcharts-xaxis-labels>span:nth-child(2)");
    public By line_chart_data_preview_thirdrow = By.cssSelector(".highcharts-axis-labels.highcharts-xaxis-labels>span:nth-child(1)");

    public By chart_data_preview_firstcolumn = By.xpath("//div[@class='highcharts-legend']/div/div/div[1]/span");
    public By chart_data_preview_secondcolumn = By.xpath("//div[@class='highcharts-legend']/div/div/div[2]/span");
    public By chart_finish_at_100 = By.cssSelector(".highcharts-axis-labels.highcharts-yaxis-labels>span:nth-child(5)");
    public By chart_y_axis_max = By.cssSelector(".highcharts-axis-labels.highcharts-yaxis-labels>span:nth-child(5)");
    public By chart_source = By.cssSelector(".flush--third--bottom.font-size--h6");
    public By chart_notes = By.cssSelector(".notes-holder-js>p");
    public By chart_controls = By.cssSelector(".btn.btn--secondary.btn--chart-control");

    public By from_quarter_dropdown = By.id("from-quarter-1");
    public By from_year_dropdown = By.id("from-year-1");
    public By to_quarter_dropdown = By.id("to-quarter-2");
    public By to_year_dropdown = By.id("to-year-2");

    public By filtered_time_series = By.cssSelector(".btn.btn--secondary.btn--chart-control.btn--chart-control--download.btn--secondary-active");
    public By start_point_of_graph = By.cssSelector(".highcharts-axis-labels.highcharts-xaxis-labels>text:first-child");
    public By end_point_of_graph = By.cssSelector(".highcharts-axis-labels.highcharts-xaxis-labels>text:last-child");
    public By filtered_image_link = By.xpath(".//*[@id='filtered-download-controls']/div/a[1]");
    public By filtered_csv_link = By.xpath(".//*[@id='filtered-download-controls']/div/a[2]");
    public By filtered_xls_link = By.xpath(".//*[@id='filtered-download-controls']/div/a[3]");
    private String from_quarter_value = "Q2";
    private String from_year_value = "1960";
    private String to_quarter_value = "Q4";
    private String to_year_value = "2015";
    private String labour_productivity_csv_timeseries = "/generator?format=csv&uri=/employmentandlabourmarket/peopleinwork/labourproductivity/timeseries/a4ym/prdy";

    private String labour_productivity_image_timeseries = "/employmentandlabourmarket/peopleinwork/labourproductivity/timeseries/a4ym/prdy/linechartimage";
    private String labour_productivity_xls_timeseries = "/generator?format=xls&uri=/employmentandlabourmarket/peopleinwork/labourproductivity/timeseries/a4ym/prdy";


    private String businessinvestmentpage = getConfig().getOnsdevelop_URL() + "economy/grossdomesticproductgdp/datasets/businessinvestment";
    private String labourProductivityPage = getConfig().getOnsdevelop_URL() + "employmentandlabourmarket/peopleinwork/labourproductivity/timeseries/a4ym/prdy/";

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

    public void verifyBarChartData(String pageName, String editionName) throws InterruptedException {

        refresh();
        Thread.sleep(500);
        Assert.assertTrue(getElementText(page_title).contains(pageName + ": " + editionName));
        Assert.assertTrue(getElementText(release_date).contains(CustomDates.getDateInDiffFormat(+1).substring(1)));
        Assert.assertTrue(getElementText(first_section_text).contains("Section 1"));
        Assert.assertTrue(getElementText(chart_title).contains("Figure 2: Percentage of VAT and/or PAYE based enterprises by year"));

        Assert.assertTrue(getElementText(chart_subtitle).contains("UK, 2005 to 2010"));
        Assert.assertTrue(getElementText(chart_units).contains("%"));
        Assert.assertTrue(getElementText(bar_chart_data_preview_firstrow).contains("2010"));
        Assert.assertTrue(getElementText(bar_chart_data_preview_secondrow).contains("2011"));
        Assert.assertTrue(getElementText(bar_chart_data_preview_thirdrow).contains("2012"));
        Assert.assertTrue(getElementText(chart_data_preview_firstcolumn).contains("Sole Proprietors and Partnerships"));
        Assert.assertTrue(getElementText(chart_data_preview_secondcolumn).contains("Companies and Public Corporations"));
        Assert.assertTrue(getElementText(chart_finish_at_100).contains("100"));
        Assert.assertTrue(getElementText(chart_source).contains("Source: Office for National Statistics"));
        Assert.assertTrue(getElementText(chart_notes).contains("This is the chart for PAYE and Companies data of 2010 and 2011"));

        ArrayList<WebElement> chartMarkerPoints = (ArrayList<WebElement>) getDriver().findElements(By.cssSelector(".highcharts-series.highcharts-series-0>rect"));
        Assert.assertTrue(chartMarkerPoints.get(0).getAttribute("fill").equals("gold"));

    }

    public void verifyLineChartData(String pageName, String editionName) {

        Assert.assertTrue(getElementText(page_title).contains(pageName + ": " + editionName));
        Assert.assertTrue(getElementText(release_date).contains(CustomDates.getDateInDiffFormat(+1).substring(1)));
        Assert.assertTrue(getElementText(first_section_text).contains("Section 1"));
        Assert.assertTrue(getElementText(chart_title).contains("Figure 2: Percentage of VAT and/or PAYE based enterprises by year"));

        Assert.assertTrue(getElementText(chart_subtitle).contains("UK, 2005 to 2010"));
        Assert.assertTrue(getElementText(chart_units).contains("%"));
        Assert.assertTrue(getElementText(line_chart_data_preview_firstrow).contains("2010"));
        Assert.assertTrue(getElementText(line_chart_data_preview_secondrow).contains("2011"));
        Assert.assertTrue(getElementText(line_chart_data_preview_thirdrow).contains("2012"));
        Assert.assertTrue(getElementText(chart_data_preview_firstcolumn).contains("Sole Proprietors and Partnerships"));
        Assert.assertTrue(getElementText(chart_data_preview_secondcolumn).contains("Companies and Public Corporations"));
        Assert.assertTrue(getElementText(chart_y_axis_max).contains("80"));
        Assert.assertTrue(getElementText(chart_source).contains("Source: Office for National Statistics"));
        Assert.assertTrue(getElementText(chart_notes).contains("This is the chart for PAYE and Companies data of 2010 and 2011"));

    }

    public void navigateToLabourProductivityPage() {

        navigateToUrl(labourProductivityPage);
    }

    public void customiseTimePeriod() {

        List<WebElement> ListOfControls = getDriver().findElements(chart_controls);
        for (WebElement eachControl : ListOfControls) {

            if (eachControl.getText().contains("Custom")) {
                eachControl.click();
            }

        }

        select(from_quarter_dropdown, from_quarter_value);
        select(from_year_dropdown, from_year_value);
        select(to_quarter_dropdown, to_quarter_value);
        select(to_year_dropdown, to_year_value);


    }

    public void customisedGraph() {

        Assert.assertTrue(getElementText(start_point_of_graph).contentEquals(from_year_value + " " + from_quarter_value));
        Assert.assertTrue(getElementText(end_point_of_graph).contentEquals(to_year_value + " " + to_quarter_value));


    }

    public void downloadCustomisedTimeSeries() {

        getElement(filtered_time_series).click();
        Assert.assertTrue(getElement(filtered_image_link).getAttribute("href").contains(labour_productivity_image_timeseries));
        Assert.assertTrue(getElement(filtered_csv_link).getAttribute("href").contains(labour_productivity_csv_timeseries));
        Assert.assertTrue(getElement(filtered_xls_link).getAttribute("href").contains(labour_productivity_xls_timeseries));

    }
}
