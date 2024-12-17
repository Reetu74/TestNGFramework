package com.testng.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import com.testng.base.BasePage;

public class EditViewPage extends BasePage {

	public EditViewPage(WebDriver driver) {
		super(driver);

	}

	
	
	//TC12
    @FindBy(xpath="//*[@id=\"fcf\"]")
	WebElement viewdropdown;
    public void selectview()
    {
    Select newview = new Select(viewdropdown);
    newview.selectByVisibleText("powersoft1");
    }
    
    @FindBy(xpath="//a[text()='Edit']")
    WebElement editviewlk ;
    public void editviewlink()
    {
   	waitmethod1(editviewlk);
    editviewlk.click();
    }
    
    String strnewviewname ="new view daily";
    @FindBy(xpath="//*[@id=\"fname\"]")
    WebElement editviewname;
    public void enternewviewname()
    {
    	editviewname.sendKeys(strnewviewname);
    }
    
    
    @FindBy(xpath="//*[@id=\"devname\"]")
    WebElement newuniqviewname; 
    public void enteruniqviewname()
    {
         newuniqviewname.click();
    }
    
    @FindBy(id="fcol1")
    WebElement selectfield;
    public void selectacctname()
    {
    	Select selfield = new Select(selectfield);
    	selfield.selectByVisibleText("Account Name");
    }
    
    @FindBy(id="fop1")
    WebElement operator;
    public void selectoperator()
    {
    	Select seloperator = new Select(operator);
    	seloperator.selectByVisibleText("contains");
    }
    @FindBy(xpath="//*[@id=\"fval1\"]")
    WebElement filteracc;
    public void filteracctby()
    {
    filteracc.sendKeys("a");
    }
    
    @FindBy(xpath="//*[@id=\"colselector_select_0\"]")
    WebElement selectfieldsdropdown;
    public void selectfields()
    {
    Select selectfield = new Select(selectfieldsdropdown);
    selectfield.selectByVisibleText("Last Activity");
    }
    
    @FindBy(xpath="//*[@id=\"colselector_select_0_right\"]/img")
    WebElement addfield;
    public void addField()
    {
     addfield.click();
    }
    
    @FindBy(xpath="//*[@id=\"editPage\"]/div[3]/table/tbody/tr/td[2]/input[1]")
    WebElement save;
    public void savefilter()
    {
    save.click();
    }
    
    public void verifyfilterresult()
    {
    	
    }
}

