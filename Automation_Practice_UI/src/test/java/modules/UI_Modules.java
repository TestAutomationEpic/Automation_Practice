package modules;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class UI_Modules {

	public Element parsing_data_from_xml_file () throws ParserConfigurationException, SAXException, IOException {
		
			//Parsing Data from UI_Test_Data XML file
			final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			final DocumentBuilder builder = factory.newDocumentBuilder();
			final Document document= builder.parse(new File("UI_Test_Data.xml"));
			document.getDocumentElement().normalize();
			Element root = document.getDocumentElement();
			return root;
	}
	
	public WebDriver configiring_and_initializing_driver (WebDriver driver, String chrome_driver_directory) throws ParserConfigurationException, SAXException, IOException {
		
			//configuring and initializing Chrome driver
			System.setProperty("webdriver.chrome.driver", chrome_driver_directory);
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			driver.manage().window().setSize(new Dimension(1024,768));
			return driver;
	}
	
	public String create_new_account (WebDriver driver, String web_site, String first_name,String last_name ) throws InterruptedException {
			
			//Opening web site
			driver.get(web_site);
			
			//signing out if user already signed in
			if (driver.findElements(By.xpath("//span[contains(text(), '"+first_name+" "+last_name+"')]")).size()  > 0) {
	     		 WebElement sign_out = driver.findElement(By.xpath("//a[contains(text(), '"+"Sign out"+"')]"));
	     		sign_out.click();
     		 }
			
			//click Signin
			WebElement btn_signin = driver.findElement(By.xpath("//a[contains(text(), '"+"Sign in"+"')]"));
			btn_signin.click();
			
		    //getting current time to add it to e-mail to make it unique and store it in a string variable
	 	    LocalDateTime dateTime = LocalDateTime.now();
	 	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmmss");
	 	    String unique_email = "example_automation_e-mail_"+dateTime.format(formatter)+"@gmail.com";
	 	    
	 	    //inserting unique e-mail
	 	    WebElement txt_email = driver.findElement(By.id("email_create"));
			txt_email.click();
			txt_email.clear();
			txt_email.sendKeys(unique_email);
			
	 	   	//click CREATE AN ACCOUNT label to activate e-mail text field after inserting value in it
			WebElement label_create_account = driver.findElement(By.xpath("//h3[contains(text(), '"+"Create an account"+"')]"));
			label_create_account.click();
			
			//click create an account
			WebElement btn_create_an_account = driver.findElement(By.id("SubmitCreate"));
			btn_create_an_account.click();
			
			return unique_email;
	           
	}
	
	public void fill_account_personal_data(WebDriver driver, String first_name, String last_name, String pass_word,
			String day_of_birth, String month_of_birth, String year_of_birth, String first_address, String city,
			String state, String postal_code, String mobile_phone, String second_address) {
		
		//choosing gender
		WebElement radio_btn_title = driver.findElement(By.id("id_gender1"));
		radio_btn_title.click();
		
		//insert first name
		WebElement txt_first_name = driver.findElement(By.id("customer_firstname"));
		txt_first_name.click();
		txt_first_name.clear();
		txt_first_name.sendKeys(first_name);
		
		//insert last name
		WebElement txt_last_name = driver.findElement(By.id("customer_lastname"));
		txt_last_name.click();
		txt_last_name.clear();
		txt_last_name.sendKeys(last_name);
		
		//insert password
		WebElement txt_pass_word = driver.findElement(By.id("passwd"));
		txt_pass_word.click();
		txt_pass_word.clear();
		txt_pass_word.sendKeys(pass_word);
		
		//insert date of birth
		Select select_day = new Select(driver.findElement(By.id("days")));
		select_day.selectByValue(day_of_birth);
		Select select_month = new Select(driver.findElement(By.id("months")));
		select_month.selectByValue(month_of_birth);
		Select select_year = new Select(driver.findElement(By.id("years")));
		select_year.selectByValue(year_of_birth);
		
		//insert address
		WebElement txt_first_address = driver.findElement(By.id("address1"));
		txt_first_address.click();
		txt_first_address.clear();
		txt_first_address.sendKeys(first_address);
		
		//insert city
		WebElement txt_city = driver.findElement(By.id("city"));
		txt_city.click();
		txt_city.clear();
		txt_city.sendKeys(city);
		
		//insert state
		Select select_state = new Select(driver.findElement(By.id("id_state")));
		select_state.selectByValue(state);
		
		//insert postal Code
		WebElement txt_postal_code = driver.findElement(By.id("postcode"));
		txt_postal_code.click();
		txt_postal_code.clear();
		txt_postal_code.sendKeys(postal_code);
		
		//insert mobile phone number
		WebElement txt_mobile_phone = driver.findElement(By.id("phone_mobile"));
		txt_mobile_phone.click();
		txt_mobile_phone.clear();
		txt_mobile_phone.sendKeys(mobile_phone);
		
		//insert second address
		WebElement txt_second_address = driver.findElement(By.id("alias"));
		txt_second_address.click();
		txt_second_address.clear();
		txt_second_address.sendKeys(second_address);
		
		//click register button
		WebElement btn_register = driver.findElement(By.xpath("//span[contains(text(), '"+"Register"+"')]"));
		btn_register.click();
		
	}
	
	public void sign_in (WebDriver driver, String web_site, String first_name,String last_name, String unique_email, String pass_word ) throws InterruptedException {
		
		//Opening web site
		driver.get(web_site);
		
		//signing out if user already signed in
		if (driver.findElements(By.xpath("//span[contains(text(), '"+first_name+" "+last_name+"')]")).size()  > 0) {
     		 WebElement sign_out = driver.findElement(By.xpath("//a[contains(text(), '"+"Sign out"+"')]"));
     		sign_out.click();
 		 }
		
		//click Signin
		WebElement btn_signin = driver.findElement(By.xpath("//a[contains(text(), '"+"Sign in"+"')]"));
		btn_signin.click();
		
		//inserting unique e-mail
 	    WebElement txt_email = driver.findElement(By.id("email"));
		txt_email.click();
		txt_email.clear();
		txt_email.sendKeys(unique_email);
		
		//inserting password
 	    WebElement txt_password = driver.findElement(By.id("passwd"));
 	    txt_password.click();
 	    txt_password.clear();
 	    txt_password.sendKeys(pass_word);
 	    
    	//click Sign in
 		WebElement btn_signin_with_user = driver.findElement(By.id("SubmitLogin"));
 		btn_signin_with_user.click();
 		
 		//asserting landing on home page by validating user name and password existence
		if (driver.findElements(By.xpath("//span[contains(text(), '"+first_name+" "+last_name+"')]")).size()  > 0) {
			Assert.assertTrue(true);
			System.out.println("Landed on User Home Page");
		}
		else {
			Assert.assertTrue(false);
			System.out.println("Didn't land on User Home Page");
		}
	}
	
	public void quit (WebDriver driver) {
		
		//quitting driver
		driver.quit();
	}
	
	public void select_sub_category (WebDriver driver, String category ,String subcategory, String subcategory_long_text) {
		
		 //hover over category, then sub-category then click it
		 WebElement link_category = driver.findElement(By.xpath("//a[contains(text(), '"+category+"')]"));
		 WebElement link_sub_category = driver.findElement(By.xpath("//a[contains(text(), '"+subcategory+"')]"));
		 Actions categories_hovering_action = new Actions(driver);
		 categories_hovering_action.moveToElement(link_category).moveToElement(link_sub_category).click().build().perform();
		 
		//asserting landing on sub-category page by validating long text existence
		if (driver.findElements(By.xpath("//div[contains(text(), '"+subcategory_long_text+"')]")).size()  > 0) {
			Assert.assertTrue(true);
			System.out.println("Landed on sub-category page");
		}
		else {
			Assert.assertTrue(false);
			System.out.println("Didn't land on sub-category Page");
		}
	 
	}	
	
	public void select_product_and_check_out_procedure (WebDriver driver, String subcategory_image_title,String added_product_long_text, String payment_method_text) {
		
		 //hover over category, then sub-category then click it
		 WebElement image_product = driver.findElement(By.xpath("//img[contains(@class, 'replace-2x img-responsive')and contains(@title, '"+subcategory_image_title+"')]"));
		 WebElement btn_add_to_cart = driver.findElement(By.xpath("//span[contains(text(), '"+"Add to cart"+"')]"));
		 Actions add_to_cart_action = new Actions(driver);
		 add_to_cart_action.moveToElement(image_product).moveToElement(btn_add_to_cart).click().build().perform();
		 
		//asserting that one product was added to cart and clicking proceed to check out button on sub-category page
		if (driver.findElements(By.xpath("//span[contains(text(), '"+added_product_long_text+"')]")).size()  > 0) {
			Assert.assertTrue(true);
			System.out.println("one product was added to cart");
			WebElement link_proceed_to_check_out = driver.findElement(By.xpath("//a[contains(@class, 'btn btn-default button button-medium')and contains(@title, '"+"Proceed to checkout"+"')]"));
			link_proceed_to_check_out.click();
		}
		else {
			Assert.assertTrue(false);
			System.out.println("product wasn't added to cart");
		}
		
		//clicking proceed to check out on Shopping cart summary page
		WebElement link_proceed_to_check_out = driver.findElement(By.xpath("//a[contains(@class, 'button btn btn-default standard-checkout button-medium')and contains(@title, '"+"Proceed to checkout"+"')]"));
		link_proceed_to_check_out.click();
		
		//clicking proceed to check out on confirming address page
		WebElement btn_proceed_to_check_out = driver.findElement(By.xpath("//button[contains(@class, 'button btn btn-default button-medium')and contains(@name, '"+"processAddress"+"')]"));
		btn_proceed_to_check_out.click();
		
		//click I agree check box then on proceed to check out button from the shipping page
		WebElement check_box_agreement = driver.findElement(By.id("cgv"));
		check_box_agreement.click();
		WebElement btn_proceed_to_check_out_shipping_page = driver.findElement(By.xpath("//button[contains(@class, 'button btn btn-default standard-checkout button-medium')and contains(@name, '"+"processCarrier"+"')]"));
		btn_proceed_to_check_out_shipping_page.click();
		
		//asserting reaching the payment method page
		if (driver.findElements(By.xpath("//h1[contains(text(), '"+payment_method_text+"')]")).size()  > 0) {
			Assert.assertTrue(true);
			System.out.println("Landed on payment method page");
		}
		else {
			Assert.assertTrue(false);
			System.out.println("didn't land on payment method page");
		}	
	 
	}	
	
	public void confirm_payment_and_validate_order (WebDriver driver, String payment_title,String order_confirmation_text) {
		
		//clicking payment method
		WebElement link_payment_method = driver.findElement(By.xpath("//a[contains(@title, '"+payment_title+"')]"));
		link_payment_method.click();
		
		//clicking I confirm my order button
		WebElement btn_confirming_payment = driver.findElement(By.xpath("//button[contains(@class, 'button btn btn-default button-medium')and contains(@type, '"+"submit"+"')]"));
		btn_confirming_payment.click();
	 
		//asserting order completion
		if (driver.findElements(By.xpath("//strong[contains(text(), '"+order_confirmation_text+"')]")).size()  > 0) {
			Assert.assertTrue(true);
			System.out.println("Order has been completed");
		}
		else {
			Assert.assertTrue(false);
			System.out.println("order wasn't completed");
		}	
	}
	
	public void check_order_history (WebDriver driver,String first_name,String last_name) {
		
		//clicking user name
		WebElement link_user_name = driver.findElement(By.xpath("//span[contains(text(), '"+first_name+" "+last_name+"')]"));
		link_user_name.click();
		
		//clicking oder history and details button
		WebElement btn_order_history = driver.findElement(By.xpath("//a[contains(@title, '"+"Orders"+"')]"));
		btn_order_history.click();
		
		//asserting that order exists in history by checking that order status text exists
		if (driver.findElements(By.xpath("//span[contains(text(), '"+"On backorder"+"')]")).size()  > 0) {
			Assert.assertTrue(true);
			System.out.println("order exists in History");
		}
		else {
			Assert.assertTrue(false);
			System.out.println("order doesn't exist in History");
		}
	 
	}
}
