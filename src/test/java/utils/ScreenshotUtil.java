package utils;

import java.util.Base64;

public class ScreenshotUtil {
  public static String convertTextToBase64(String text) {
	  return Base64.getEncoder().encodeToString(text.getBytes());
  }
}
//this class converts API Response text into something Extent can show.