package Util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 13/10/2016.
 */
public class Urls {

    public static Map<String, String> urlMapping;

    static {
        urlMapping = new HashMap<String, String>();

        // Developer Environment
        urlMapping.put("ONS", "https://develop.onsdigital.co.uk/");

        // About us
        urlMapping.put("About us", "https://develop.onsdigital.co.uk/aboutus");

        // Media
        urlMapping.put("Media", "https://develop.onsdigital.co.uk/news");
        urlMapping.put("List of all news", "https://develop.onsdigital.co.uk/news/news/staticlist");
        urlMapping.put("List of all statements and letters", "https://develop.onsdigital.co.uk/news/statementsandletters/staticlist");
        urlMapping.put("Contact Media Relations Office", "https://develop.onsdigital.co.uk/news/contactmediarelationsoffice");
        urlMapping.put("General and statistical enquiries", "https://develop.onsdigital.co.uk/aboutus/contactus/generalandstatisticalenquiries");
        urlMapping.put("Office locations", "https://develop.onsdigital.co.uk/aboutus/contactus/officelocations");

        // Florence
        urlMapping.put("Florence Home", "https://publishing.develop.onsdigital.co.uk/florence/index.html");
        urlMapping.put("Florence", "https://publishing.develop.onsdigital.co.uk/florence/index.html");

        // Ermintrude
        urlMapping.put("Ermintrude", "https://preview.develop.onsdigital.co.uk/ermintrude/index.html");

        // CPI Dataset Landpage
        urlMapping.put("CPI dataset landing", "https://develop.onsdigital.co.uk/economy/inflationandpriceindices/datasets/consumerpriceinflation");
    }
}


