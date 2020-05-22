package StepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LoginNew {
	 public static WebDriver driver;	
	 
	 @Before
		public void testPageTitle() 
		{
			System.out.println("At Before");
			if(driver == null) {
			
			System.setProperty("webdriver.chrome.driver","E:\\Driver\\chromedriver.exe");
			this.driver = new ChromeDriver();
			this.driver.manage().window().maximize();
			//this.driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
			}
			else
			{
				System.out.println("same driver");	
			}
			
		}
     
	 
     
    
  
 @Given("^Open the chrome and launch the application$")
 public void open_the_chrome_and_launch_the_application() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	
	
 }

  @When("^nevigate the orange hrm page of orange hrm$")
  public void nevigate_the_orange_hrm_page_of_orange_hrm() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	driver.get("https://opensource-demo.orangehrmlive.com/");
 }
  
  @When("^Enter the username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
  public void enter_the_username_as_and_password_as(String arg1, String arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	driver.findElement(By.xpath("//*[@id=\"txtUsername\"]")).sendKeys("Admin");
	driver.findElement(By.xpath("//*[@id=\"txtPassword\"]")).sendKeys("admin123");
	
 }

  @When("^click on submit button$")
  public void click_on_submit_button() throws Throwable {
	
    // Write code here that turns the phrase above into concrete actions
	driver.findElement(By.id("btnLogin")).click();
	Thread.sleep(2000);
 }

  @Then("^see the welcome page$")
  public void see_the_welcome_page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	//Logout
		driver.findElement(By.partialLinkText("Welcome Admin")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Logout")).click();
		
  }

  @Given("^i should nevigate the skill page$")
  public void i_should_nevigate_the_skill_page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	driver.findElement(By.linkText("Admin")).click();
	driver.findElement(By.id("menu_admin_Qualifications")).click();
	driver.findElement(By.cssSelector("#menu_admin_viewSkills")).click();
	
 }

  @When("^i click on add button$")
  public void i_click_on_add_button() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	driver.findElement(By.id("btnAdd")).click();
 }

  @When("^i enter the skill \"([^\"]*)\" as a skill$")
  public void i_enter_the_skill_as_a_skill(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	driver.findElement(By.id("skill_name")).sendKeys("Manual Testing");
	driver.findElement(By.id("skill_description")).sendKeys("Tester better way to Know Manual Testing");
 }

  @When("^click on save button$")
  public void click_on_save_button() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	driver.findElement(By.id("btnSave")).click();
	
 }

  @Then("^add skill successfully$")
  public void add_skill_successfully() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	boolean flag = driver.findElement(By.cssSelector("#recordsListTable > thead > tr > th:nth-child(2)")).isDisplayed();
	
	if(flag)
	{
		System.out.println("Test case pass. Add skill successful");
		
		//checkpoint 2-to check the name
		if(driver.getPageSource().contains("Manual Testing"))
		{
			System.out.println("Test case-2 pass. Skill is correct");
		}
		else
		{
			System.out.println("Test case-2 fail. Skill is already exist");
		}
		
 	}
	else
	{
		System.out.println("Test case fail. skill not added successfully");
	}
 }
  
@Then("^Skill show on skill table$")
public void skill_show_on_skill_table() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
  
   }

}
