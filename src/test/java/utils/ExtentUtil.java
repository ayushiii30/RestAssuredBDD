package utils;

import io.restassured.response.Response;

public class ExtentUtil {

	public static void attachResponse(String title, Response response) {
        ExtentTestNGListener.getTest()
                .info(title + "<pre>" + response.asPrettyString() + "</pre>");
    }
}
