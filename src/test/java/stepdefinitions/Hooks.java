package stepdefinitions;

import io.cucumber.java.Before;
import Core.BaseTest;
import Core.DriverManager;
import io.cucumber.java.After;

public class Hooks extends BaseTest {

	 @Before
	    public void setUp() {
	        DriverManager.init();   // ✅ runs before each scenario
	    }

	    @After
	    public void tearDown() {
	        DriverManager.quit();   // ✅ runs after each scenario
	    }
}