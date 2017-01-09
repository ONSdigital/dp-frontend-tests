package com.ons.dp.frontend.test.model;

/**
 * Created by admin on 06/01/2017.
 */
public class FoiEntry {
    public String title = "";
    public String releaseDate = "";
    public String keywords = "";
    public String metaDescription = "";


    public String markdownText = "";

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    public String getMarkdownText() {
        return markdownText;
    }

    public void setMarkdownText() {
        this.markdownText = markdownText;
    }
}
