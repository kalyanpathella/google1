package gluecode;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleHome;

public class StepDef {
	Shared sh;
	public StepDef(Shared x)
	{
		this.sh=x;
	}
	
	@Given("open a chrome browser")
	public void open_a_chrome_browser() 
	{
	    WebDriverManager.chromedriver().setup();
	    sh.driver = new ChromeDriver();
	    sh.driver.manage().window().maximize();
	    sh.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Then("launch a site {string}")
	public void launch_a_site(String url) 
	{
	    sh.driver.get(url);
	}

	@Then("check page title")
	public void check_page_title() 
	{
	   String title= sh.driver.getTitle();
	    if(title.contains("google"))
	    {
	    	System.out.println("Title Test passed");
	    }
	    else
	    {
	    	System.out.println("Title test failed");
	    }
	}

	@When("click on search box")
	public void click_on_search_box()throws Exception
	{
	   sh.google = new GoogleHome(sh.driver);
	   sh.google.clickOnSearchBox();
	}

	@Then("enter some text {string} on search box")
	public void enter_some_text_on_search_box(String data)
	{
	    sh.google.searchBox(data);
	}

	@Then("check given suggessions {string} are correct or not")
	public void check_given_suggessions_are_correct_or_not(String data)throws Exception
	{
	    sh.google.checkSuggestions(data);
	}



}
