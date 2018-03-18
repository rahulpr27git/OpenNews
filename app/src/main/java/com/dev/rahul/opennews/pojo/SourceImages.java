package com.dev.rahul.opennews.pojo;

import java.util.Arrays;
import java.util.List;

/**
 * Created by rahul on 18/3/18.
 */

public class SourceImages {

    //================ Source Ids ===================
    private static final String id[] = {
            "abc-news",
            "abc-news-au",
            "aftenposten",
            "al-jazeera-english"
    };
    private static List<String> ids = Arrays.asList(id);

    //================= Source Images ===============
    private static final String image[] = {
            "http://s.abcnews.com/assets/images/apple-touch-icons/touch-icon-ipad-retina.png",
            "http://mobile.abc.net.au/homepage/mobile/images/homepage/apple-touch-icon-144x144.png",
            "https://www.aftenposten.no/public/apple-touch-icon-120x120.png",
            "https://www.aljazeera.com/mritems/assets/images/touch-icon-iphone-retina.png"
    };

    public static String getImageById(String id) {
        int index = ids.indexOf(id);
        if (index > -1 ) {
            return image[index];
        } else {
            return "https://dummyimage.com/100x100/9e9e9e/030303.png&text=No+Image";
        }
    }


}
