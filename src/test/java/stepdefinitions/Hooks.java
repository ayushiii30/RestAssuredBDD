package stepdefinitions;
import io.cucumber.java.After;
import org.testng.asserts.SoftAssert;
public class Hooks {
private static ThreadLocal<SoftAssert> softAssert = new ThreadLocal<>();

public static SoftAssert getSoftAssert() {
	if(softAssert.get()==null) {
		softAssert.set(new SoftAssert());
		
	}
	return softAssert.get();
}

@After
public void afterScenario() {
	getSoftAssert().assertAll();
	softAssert.remove();
}

}
