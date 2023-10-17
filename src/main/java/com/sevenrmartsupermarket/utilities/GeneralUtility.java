package com.sevenrmartsupermarket.utilities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

public class GeneralUtility {
	
	static Faker faker = new Faker();
	
	public String getTextOfElement(WebElement element) {
		return element.getText();
	}
	
	public List<String> getTextOfElements(List<WebElement> element){
		List<String> listOfElements = new ArrayList<String>();
		for(WebElement newElement : element) {
			listOfElements.add(newElement.getText());
		}
		return listOfElements;
	}
	
	public boolean _isDisplayed(WebElement element) {
		return element.isDisplayed();
	}
	
	public boolean _isSelected(WebElement element) {
		return element.isSelected();
	}
	
	public boolean _isEnabled(WebElement element) {
		return element.isEnabled();
	}
	
	public String getElementAttribute(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}
	
	public boolean isTextPresent(WebElement element, String expectedText) {
		String data = element.getText();
		return data.contains(expectedText);
	}
	
	public static String getRandomFullName() {
		String name = faker.name().fullName();
		return name;		
	}
	
	public static String getRandomAddress() {
		return faker.address().streetAddress();
	}
	
	public static String getTimeStamp() {
		return new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
	}

}
