package gluecode;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleHome;

public class StepDef2 
{

	Shared sh;
	public StepDef2(Shared x)
	{
		this.sh=x;
	}
	@Given("open a chrome browser")
	public void open_a_chrome_browser()
	{
		WebDriverManager.chromedriver().setup();
		sh.driver=new ChromeDriver();
		sh.driver.manage().window().maximize();
		sh.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
	}
	@Then("launch a site {string}")
	public void launch_a_site(String url)
	{
		sh.driver.get(url);
	}
	@Then ("check page title1")
	public void check_page_title1()
	{
		sh.driver.getTitle();
	}	
	@When("Enter a required {string} data into search")
	public void Enter_a_required_data_into_search(String data)
	{
		sh.google = new GoogleHome(sh.driver);
		sh.google.searchBox(data);
	}
	@Then("click on search button")
	public void click_on_search_button()
	{
		sh.google.clickOnSearch();
	}
	@Then("back to the prevoius page")
	public void back_to_the_prevoius_page()throws Exception
	{
		sh.driver.navigate().back();
		Thread.sleep(2000);
	}
	
	
}
