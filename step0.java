// C:\\Users\\khan\\chrome driver\\chromedriver.exe

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.lang.model.element.Element;
//import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class step0 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\khan\\chrome driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

//STEP(0)		
		driver.get("https://omayo.blogspot.in/");
//STEP(1)	
		// text field 1
		driver.findElement(By.xpath("//div[contains(@class,'navbar')]//following :: textarea[contains(@id,'ta')]"))
				.sendKeys("Muhammad Idrees Balooch");

		// text field 2
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		
		WebElement textArea2 = driver
				.findElement(By.xpath("//div[contains(@class,'navbar')]//following :: textarea[contains(text(),'The ')]"));
		
		textArea2.sendKeys(Keys.CONTROL + "a");

		textArea2.sendKeys(Keys.BACK_SPACE);
		
		textArea2.sendKeys("A supreme lover of plants  is automating the browser!");
		
//STEP(2)
		// getting the table
		WebElement table = driver.findElement(By.xpath("//div[contains(@class,'navbar')]//following :: table[contains(@id,'table')]"));
		List<WebElement> allRows = driver.findElements(By.tagName("tr"));
		for (WebElement row : allRows) {

			System.out.print(row.getText() + '\n');

		}

//	//first login
		//name
		driver.findElement(By.xpath("// form[contains(@name,'form')]//child::input[contains(@type,'text')]"))
				.sendKeys("Muhammad Iddrees");
		//password
		driver.findElement(By.xpath("// form[contains(@name,'form')]//child::input[contains(@type,'password')]"))
				.sendKeys("8932");
		//submit
		driver.findElement(By.xpath("// form[contains(@name,'form')]//child::button[contains(@type,'button')]")).click();
		//scroll down
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();

//Step (3): 		

		// switchingToFrames
		//frame1
		Thread.sleep(2000);
		WebElement frame1 = driver
				.findElement(By.xpath("(//div[contains(@class,'widget-content')]//descendant :: iframe)[1]"));
		driver.switchTo().frame(frame1);
		//switch to default frame
		driver.switchTo().defaultContent();

		//frame2
		WebElement frame2 = driver
				.findElement(By.xpath("(//div[contains(@class,'widget-content')]//descendant :: iframe)[2]"));
		driver.switchTo().frame(frame2);
		//back to default frame
		driver.switchTo().defaultContent();

		// 2nd login
		driver.findElement(By.xpath("// form[contains(@name,'login')]//child::input[contains(@type,'text')]")).sendKeys("Muhammad Iddrees");
		driver.findElement(By.xpath("// form[contains(@name,'login')]//child::input[contains(@type,'password')]")).sendKeys("8932");
		driver.findElement(By.xpath("// form[contains(@name,'login')]//child::input[contains(@type,'button')]")).click();
		driver.switchTo().alert().accept();

//Step (4):
		actions.sendKeys(Keys.PAGE_UP).build().perform();
		actions.sendKeys(Keys.PAGE_UP).build().perform();
	// select hyundai
		driver.findElement(By.xpath("//div[contains(@class,'widget HTML')]//child :: option[contains(text(),'Hyundai')]")).click();
	// select doc3
		//dropdown
		WebElement dropdown = driver
				.findElement(By.xpath("//div[contains(@class,'widget HTML')]//child :: select[contains(@class,'combo')]"));
		dropdown.click();
	//doc3	
		WebElement doc3 = driver
				.findElement(By.xpath("//select[contains(@class,'combo')]//child :: option[contains(@value,'jkl')]"));
		doc3.click();

	// preloaded textbox

		driver.findElement(By.xpath("//div[contains(@class,'widget-content')]//child :: input[contains(@value,'Selenium')]")).click();
		WebElement preLoadedText = driver
				.findElement(By.xpath("(//div[contains(@class,'sidebar section')]//descendant :: input)[1]"));
		preLoadedText.sendKeys(Keys.CONTROL + "a");
		preLoadedText.sendKeys(Keys.BACK_SPACE);
		preLoadedText.sendKeys("hello world");
	// enabled button
		WebElement btn2 = driver.findElement(By.xpath("//div[contains(@class,'widget-content')]//child :: button[contains(text(),'Button2')]"));
		btn2.click();
	//checking enability
		System.out.println("button 2 is" + btn2.isEnabled());

		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
	//clicking submit + login + register
		driver.findElement(By.xpath("//div[contains(@class,'widget-content')]//child :: button[contains(text(),'Submit')]")).click();
		driver.findElement(By.xpath("//div[contains(@class,'widget-content')]//child :: button[contains(text(),'Login')]")).click();
		driver.findElement(By.xpath("//div[contains(@class,'widget-content')]//child :: button[contains(text(),'Register')]")).click();
	// clickAfterTextDisapear button
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@id,'delete')]")));
	//alert	
		driver.findElement(By.xpath("//div[contains(@class,'widget-content')]//child :: input[contains(@value,'ClickAfter')]")).click();
		driver.switchTo().alert().accept();
//New Window		
		driver.findElement(By.xpath("//div[contains(@class,'widget-content')]//child :: a[contains(text(),'Open')]")).click();
	// gets parent/current window name
		String parentWindowHandler = driver.getWindowHandle();
		String subWindowHandler = null;

		// get subWindow handles
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()) {
			subWindowHandler = iterator.next();
		}

		driver.switchTo().window(subWindowHandler);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("main")));
	//getting text from new popup window
		WebElement para1 = driver.findElement(By.className("main"));

		WebElement para2 = driver.findElement(By.className("sub"));
		System.out.println(para1.getText() + "\n" + para2.getText());
		driver.switchTo().window(parentWindowHandler);
		
	//uploading a file
		WebElement fileUpload = driver.findElement(By.xpath("//form[contains(@action,'demo_form')]//child :: input"));
	//fileUpload.click();
		fileUpload.sendKeys("C:\\Users\\khan\\Desktop\\docs\\matric degree.jpg");

	// my btn functionality before clicking "try it"
		WebElement myBtn = driver
				.findElement(By.xpath("//button[contains(text(),'My')]"));
		System.out.println("'My Button' functionality before clicking 'Try It' button" + myBtn.isEnabled());
		// tryIt button
		driver.findElement(By.xpath("//button[contains(text(),'Try')]")).click();
		Thread.sleep(4000);
		// my btn functionality after clicking "try it"
		System.out.println("'My Button' functionality after clicking 'Try It' button" + myBtn.isEnabled());
		// chekThis buton
		driver.findElement(By.xpath("//button[contains(text(),'Check')]")).click();
		// checkbox wait
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//input[contains(@id,'dt') ]")));
		// checkbox click
		driver.findElement(By.xpath("//input[contains(@id,'dt') ]")).click();

//Step (5):
		
		actions.sendKeys(Keys.PAGE_UP).build().perform();
		actions.sendKeys(Keys.PAGE_UP).build().perform();
	// gender
		driver.findElement(By.xpath("(//div[contains(@class,'widget HTML')]//descendant :: input)[13]")).click();
		Thread.sleep(2000);
	//getting alert
		driver.findElement(By.xpath("//input[contains(@value,'ClickTo')]")).click();
	//accepting alert
		driver.switchTo().alert().accept();
	// blue color
		driver.findElement(By.xpath("//input[contains(@value,'blue')]")).click();
	//	orange color
		driver.findElement(By.xpath("//input[contains(@value,'ora')]")).click();
	//readonly textbox	
		WebElement readOnlyTextBox = driver
				.findElement(By.xpath("//input[contains(@value,'Read')]"));
		actions.doubleClick(readOnlyTextBox).perform();

		// get Prompt for name 

		WebElement getPrompt = driver
				.findElement(By.xpath("//input[contains(@value,'GetPrompt')]"));
		getPrompt.click();
		Alert promptPresent = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(promptPresent.getText());
	//put name in alert
		String name = "Muhammad Idrees";
		driver.switchTo().alert().sendKeys(name);
		promptPresent.accept();

	// filling text boxes and selecting car
		//1st textbox
		WebElement locateUsingClass1 = driver
				.findElement(By.xpath("(//div[contains(@class,'widget-content') ]//descendant :: input)[26]"));
		locateUsingClass1.click();
		locateUsingClass1.sendKeys("located finally");
		//2nd texbox
		WebElement locateUsingClass2 = driver
				.findElement(By.xpath("(//div[contains(@class,'widget-content') ]//descendant :: input)[27]"));
		locateUsingClass2.click();
		locateUsingClass2.sendKeys("hope done the question");
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
	//car	
		driver.findElement(By.xpath("//input[contains(@value,'Car')]")).click();
	//bag	
		driver.findElement(By.xpath("//input[contains(@value,'Bag')]")).click();
	//book select	
		driver.findElement(By.xpath("//input[contains(@value,'Book')]")).click();
	// book deselect	
		driver.findElement(By.xpath("//input[contains(@value,'Book')]")).click();
	// clicking the dropdown
		driver.findElement(By.xpath("//button[contains(@class,'drop')]")).click();
	//wait for dropdown to open	
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[contains(text(),'Facebook')]")));
	// moving to facebook
		driver.findElement(By.xpath("//a[contains(text(),'Facebook')]")).click();

	}

}
