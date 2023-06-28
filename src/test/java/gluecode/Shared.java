package gluecode;

import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pages.GoogleHome;

public class Shared {
	
	public RemoteWebDriver driver;
	public GoogleHome google;
	public Scenario s;
	@Before
	public void method(Scenario x)
	{
		this.s=x;
	}
}
