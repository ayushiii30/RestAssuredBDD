package base;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import utils.ConfigReader;
public class BaseTest {
	
	@BeforeClass
	public void setup() {
		
		//dynamically get baseURI from jenkins param or config
		RestAssured.baseURI = ConfigReader.getBaseURI();
		System.out.println("Running tests with Base URI:"+ RestAssured.baseURI);
		//IF YOUR TEST NEED TOKEN 
		
		String token = ConfigReader.getToken();
		System.out.println("Using API Token:" + token);
//		
//		String baseUri = System.getenv("BASE_URI");
//		if(baseUri==null || baseUri.isEmpty()) {
//			throw new RuntimeException("BASE_URI environment variable is not set!");
//		}
//		RestAssured.baseURI = baseUri;
	}
}
