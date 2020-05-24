package test_cases;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

public class UI_Test_Cases {
	
	//Creating Test Data Variables
	WebDriver driver;
	String chrome_driver_directory;
	String web_site;
	String unique_email;
	String first_name;
	String last_name;
	String pass_word;
	String day_of_birth;
	String month_of_birth;
	String year_of_birth;
	String first_address;
	String city;
	String state;
	String postal_code;
	String mobile_phone;
	String second_address;
	String category;
	String subcategory;
	String subcategory_long_text;
	String subcategory_image_title;
	String added_product_long_text;
	String payment_method_text;
	String payment_title;
	String order_confirmation_text;

	@Test (priority=1)
	public void Create_Account() throws InterruptedException, ParserConfigurationException, SAXException, IOException{
		
		//Creating an instance from UI_Modules
		modules.UI_Modules ui_modules = new modules.UI_Modules();
				
		//Initializing variables with Test Data values in XML File
		chrome_driver_directory= ui_modules.parsing_data_from_xml_file().getElementsByTagName("Chrome_Driver_Directory").item(0).getTextContent();
		web_site = ui_modules.parsing_data_from_xml_file().getElementsByTagName("Web_Site").item(0).getTextContent(); 
		first_name= ui_modules.parsing_data_from_xml_file().getElementsByTagName("first_name").item(0).getTextContent();
		last_name = ui_modules.parsing_data_from_xml_file().getElementsByTagName("last_name").item(0).getTextContent();
		pass_word = ui_modules.parsing_data_from_xml_file().getElementsByTagName("pass_word").item(0).getTextContent();
		day_of_birth = ui_modules.parsing_data_from_xml_file().getElementsByTagName("day_of_birth").item(0).getTextContent();
		month_of_birth = ui_modules.parsing_data_from_xml_file().getElementsByTagName("month_of_birth").item(0).getTextContent();
		year_of_birth = ui_modules.parsing_data_from_xml_file().getElementsByTagName("year_of_birth").item(0).getTextContent();
		first_address = ui_modules.parsing_data_from_xml_file().getElementsByTagName("first_address").item(0).getTextContent();
		city = ui_modules.parsing_data_from_xml_file().getElementsByTagName("city").item(0).getTextContent();
		state = ui_modules.parsing_data_from_xml_file().getElementsByTagName("state").item(0).getTextContent();
		postal_code = ui_modules.parsing_data_from_xml_file().getElementsByTagName("postal_code").item(0).getTextContent();
		mobile_phone = ui_modules.parsing_data_from_xml_file().getElementsByTagName("mobile_phone").item(0).getTextContent();
		second_address = ui_modules.parsing_data_from_xml_file().getElementsByTagName("second_address").item(0).getTextContent();
	
		//Configuring and initializing driver Instance 
		driver = ui_modules.configiring_and_initializing_driver(driver, chrome_driver_directory);
		
		//Step 1: create account and save registered e-mail
		unique_email = ui_modules.create_new_account(driver, web_site,first_name,last_name);
		System.out.println("the registered email is: "+ unique_email);
		
		//Step 2: fill account details and click register
		ui_modules.fill_account_personal_data(driver,first_name,last_name,pass_word,day_of_birth,month_of_birth,year_of_birth
				,first_address,city,state,postal_code,mobile_phone,second_address);
		
	}
	
	@Test (priority=2)	
	public void sign_in() throws InterruptedException, ParserConfigurationException, SAXException, IOException{
		
		//Creating an instance from UI_Modules
		modules.UI_Modules ui_modules = new modules.UI_Modules();
				
		//Initializing variables with Test Data values in XML File
		chrome_driver_directory= ui_modules.parsing_data_from_xml_file().getElementsByTagName("Chrome_Driver_Directory").item(0).getTextContent();
		web_site = ui_modules.parsing_data_from_xml_file().getElementsByTagName("Web_Site").item(0).getTextContent(); 
		first_name= ui_modules.parsing_data_from_xml_file().getElementsByTagName("first_name").item(0).getTextContent();
		last_name = ui_modules.parsing_data_from_xml_file().getElementsByTagName("last_name").item(0).getTextContent();
		pass_word = ui_modules.parsing_data_from_xml_file().getElementsByTagName("pass_word").item(0).getTextContent();
		
	
		//Configuring and initializing driver Instance 
		driver = ui_modules.configiring_and_initializing_driver(driver, chrome_driver_directory);
		
		//Step 1: sign in with e-mail and password created in create an account test and assert landing on home page
		ui_modules.sign_in(driver, web_site, first_name, last_name,unique_email,pass_word);
		
	}
	
	@Test (priority=3)	
	public void hover_over_subcategory_and_checkout_procedure_with_payment() throws InterruptedException, ParserConfigurationException, SAXException, IOException{
		
		//Creating an instance from UI_Modules
		modules.UI_Modules ui_modules = new modules.UI_Modules();
				
		//Initializing variables with Test Data values in XML File
		chrome_driver_directory= ui_modules.parsing_data_from_xml_file().getElementsByTagName("Chrome_Driver_Directory").item(0).getTextContent();
		web_site = ui_modules.parsing_data_from_xml_file().getElementsByTagName("Web_Site").item(0).getTextContent(); 
		first_name= ui_modules.parsing_data_from_xml_file().getElementsByTagName("first_name").item(0).getTextContent();
		last_name = ui_modules.parsing_data_from_xml_file().getElementsByTagName("last_name").item(0).getTextContent();
		pass_word = ui_modules.parsing_data_from_xml_file().getElementsByTagName("pass_word").item(0).getTextContent();
		category= ui_modules.parsing_data_from_xml_file().getElementsByTagName("category").item(0).getTextContent();
		subcategory = ui_modules.parsing_data_from_xml_file().getElementsByTagName("subcategory").item(0).getTextContent();
		subcategory_long_text = ui_modules.parsing_data_from_xml_file().getElementsByTagName("subcategory_long_text").item(0).getTextContent();
		subcategory_image_title = ui_modules.parsing_data_from_xml_file().getElementsByTagName("subcategory_image_title").item(0).getTextContent();
		added_product_long_text = ui_modules.parsing_data_from_xml_file().getElementsByTagName("added_product_long_text").item(0).getTextContent();
		payment_method_text = ui_modules.parsing_data_from_xml_file().getElementsByTagName("payment_method_text").item(0).getTextContent();
		payment_title = ui_modules.parsing_data_from_xml_file().getElementsByTagName("payment_title").item(0).getTextContent();
		order_confirmation_text = ui_modules.parsing_data_from_xml_file().getElementsByTagName("order_confirmation_text").item(0).getTextContent();
		
		//Configuring and initializing driver Instance 
		driver = ui_modules.configiring_and_initializing_driver(driver, chrome_driver_directory);
		
		//Step 1: sign in with e-mail and password created in create an account test and assert landing on home page
		ui_modules.sign_in(driver, web_site, first_name, last_name,unique_email,pass_word);
		//Step 2: click on sub-category after hovering over category and sub-category
		ui_modules.select_sub_category(driver, category, subcategory,subcategory_long_text);
		//Step 3: select product and follow up check out procedure
		ui_modules.select_product_and_check_out_procedure(driver,subcategory_image_title,added_product_long_text,payment_method_text);
		//Step 4: make payment
		ui_modules.confirm_payment_and_validate_order(driver, payment_title,order_confirmation_text);
		
	}
	
	@Test (priority=4)	
	public void check_order_in_history() throws InterruptedException, ParserConfigurationException, SAXException, IOException{
		
		//Creating an instance from UI_Modules
		modules.UI_Modules ui_modules = new modules.UI_Modules();
				
		//Initializing variables with Test Data values in XML File
		chrome_driver_directory= ui_modules.parsing_data_from_xml_file().getElementsByTagName("Chrome_Driver_Directory").item(0).getTextContent();
		web_site = ui_modules.parsing_data_from_xml_file().getElementsByTagName("Web_Site").item(0).getTextContent(); 
		first_name= ui_modules.parsing_data_from_xml_file().getElementsByTagName("first_name").item(0).getTextContent();
		last_name = ui_modules.parsing_data_from_xml_file().getElementsByTagName("last_name").item(0).getTextContent();
		pass_word = ui_modules.parsing_data_from_xml_file().getElementsByTagName("pass_word").item(0).getTextContent();
		
		//Configuring and initializing driver Instance 
		driver = ui_modules.configiring_and_initializing_driver(driver, chrome_driver_directory);
		
		//Step 1: sign in with e-mail and password created in create an account test and assert landing on home page
		ui_modules.sign_in(driver, web_site, first_name, last_name,unique_email,pass_word);
		//Step 2: click on sub-category after hovering over category and sub-category
		ui_modules.check_order_history(driver, first_name, last_name);
		
	}
	
	@AfterMethod
	public void quit_driver(){
		
		//Creating an instance from UI_Modules
		modules.UI_Modules ui_modules = new modules.UI_Modules();
				
		//quitting driver after each method
		ui_modules.quit(driver);
		
	}
	
	
}

