package pageObjects;

import org.openqa.selenium.By;

public class Test_PO {

	public By openModelBtn=By.xpath("//button[text()='Open Modal']");
	public By nameInput=By.id("name");
	public By cityInput=By.id("city");
	public By enterBtn=By.id("enter");
	public By closeBtn=By.cssSelector("button.btn.btn-default");
	public By displayName=By.id("nameVal");
	public By displayCity=By.id("cityVal");
	public By clickMe=By.xpath("//button[@class='btn btn-primary dropdown-toggle']");
	public By searchField=By.id("myInput");
	public By dropdownBlock=By.xpath("//ul[@class='dropdown-menu show']");
	public By items=By.tagName("li");
	public By tableSearch=By.id("searchMe");
	public By tableRows=By.xpath("//tbody[@id='someTable']/tr");
	public By dropBlock=By.id("div1");
    public By dragBlock=By.id("drag1");
    public By afterDrop=By.xpath("//div[@id='div1']/button[@id='drag1']");
}
