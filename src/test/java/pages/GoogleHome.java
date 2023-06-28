package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHome {
	
	
	@FindBy(name="q")private WebElement search;
	@FindBy(xpath="(//ul[@role='listbox'])[1]/child::li")private List<WebElement> suggestions;
	@FindBy(xpath="(//input[@value='Google Search'])[2]")private WebElement click;
	
	public GoogleHome(RemoteWebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void clickOnSearchBox()throws Exception
	{
		if(search.isEnabled())
		{
			search.click();
			Thread.sleep(2000);
			System.out.println("Search box Test Passed");
		}
		else
		{
			System.out.println("search box Test Failed");
		}
	}
	public void searchBox(String data)
	{
		if(search.isEnabled())
		{
			search.sendKeys(data);
			System.out.println("Search box Test Passed");
		}
		else
		{
			System.out.println("search box Test Failed");
		}
	}
	public void checkSuggestions(String input)throws Exception
	{
		int flag=0;
		
		for(WebElement suggestion : suggestions)
		{
			Thread.sleep(3000);
			String name = suggestion.getText();
			name = name.toLowerCase();
			name = name.replace(" ", "");
			input = input.toLowerCase();
			input = input.replace(" ", "");
			if(!name.contains(input))
			{
				System.out.println(name);
				flag=1;
			}
			
		}
		if(flag==0)
		{
			System.out.println("All seggestions are correct");
		}
		else
		{
			System.out.println("All suggestions are incorrect");
		}
	}
	public void clickOnSearch()
	{
		search.click();
	}
	
}
