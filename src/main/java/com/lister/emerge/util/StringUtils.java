package com.lister.emerge.util;

/**
 * Created with IntelliJ IDEA.
 * User: vamsi
 * Date: 4/25/14
 * Time: 12:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class StringUtils {

    public static String removeQuotesFirstAndLast(String json) {
        json = json.replaceFirst("\"","").replace("}\"", "}").replace("\\","");
        return json;
    }
}
