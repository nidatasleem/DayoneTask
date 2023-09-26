package greens.org;


    import java.awt.AWTException;
	import java.awt.Robot;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.time.Duration;
	import java.util.Date;
	import java.util.List;

	import org.apache.commons.io.FileUtils;
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.CellType;
	import org.apache.poi.ss.usermodel.DateUtil;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebDriver.Navigation;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.FluentWait;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.Wait;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class Baseclass {
		WebDriver driver;
		public void BrowserLaunchChrome() {
	        driver=new ChromeDriver();
		}
		public void BrowserLaunchEdge() {
	        driver=new EdgeDriver();
		}
		public void BrowserLaunchFireFox() {
	        driver=new FirefoxDriver();
		}
		public void GetUrl(String Url) {
			driver.get(Url);
		}
		public void MaximizeWindow() {
			driver.manage().window().maximize();
		}
		public void SendKeys(WebElement element,String data) {
			if(IsEnabled(element) && (IsDisplayed(element)) && data!=null) {
			Visibilityof(element);
			element.sendKeys(data);
			}
		}
		public void SendKeysJs(WebElement element,String data) {
			 Visibilityof(element);
			 if(IsEnabled(element) && (IsDisplayed(element)) && data!=null) {
	         JavascriptExecutor executor=(JavascriptExecutor)driver;
	         executor.executeScript("arguments[0].SetAttribute('value','"+data+"')",element);
			 }
		}
		public void Click(WebElement element) {
			Visibilityof(element);
			if(IsEnabled(element) && (IsDisplayed(element))) {
			element.click();
			}
		}
		public String GetTitle() {
			String title = driver.getTitle();
			return title;
		}
		public WebElement FindByid(String idname) {
			WebElement element = driver.findElement(By.id(idname));
			return element;
		}
		public WebElement FindByName(String name) {
			WebElement element = driver.findElement(By.name(name));
			return element;
		}
		public WebElement FindByClass(String Classname) {
			WebElement element = driver.findElement(By.className(Classname));
			return element;
		}
		public WebElement FindByXpath(String xpath) {
			WebElement element = driver.findElement(By.xpath(xpath));
			return element;
		}
		public String GetCurrentUrl() {
			String currentUrl = driver.getCurrentUrl();
			return currentUrl;
		}
		public void CloseWindow() {
	        driver.close();
		}
		public void QuitWindow() {
	        driver.quit();
		}
		public String GetAttribute(WebElement element) {
			Visibilityof(element);
	         String attribute = element.getAttribute("value");
	         return attribute;
		}
		public String GetAttribute(WebElement element,String attributename) {
			Visibilityof(element);
	        String attribute = element.getAttribute(attributename);
	        return attribute;
			}
		public void SelectOptionByText(WebElement element,String text) {
			if(IsEnabled(element) && (IsDisplayed(element)) && text!=null) {
			Visibilityof(element);
	        Select s=new Select(element);
	        s.selectByVisibleText(text);
			}
		}
		public void SelectOptionByValue(WebElement element,String value) {
			Visibilityof(element);
			if(IsEnabled(element) && (IsDisplayed(element)) && value!=null) {
	        Select s=new Select(element);
	        s.selectByValue(value);
			}
		}
		public void SelectOptionByIndex(WebElement element,int index) {
			Visibilityof(element);
	        Select s=new Select(element);
	        s.selectByIndex(index);
		}
		public WebElement FindLocatorsById(String idname) {
			WebElement  element = (WebElement) driver.findElements(By.id(idname));
	      return element;
		}
		public List<WebElement> FindLocatorsByName(String name) {
		      List<WebElement> element = driver.findElements(By.name(name));
		      return element;
		}
		public List<WebElement> FindLocatorsByClass(String Classname) {
		      List<WebElement> element = driver.findElements(By.className(Classname));
		      return element;
		}
		public List<WebElement> FindLocatorsByXpath(String Xpath) {
		      List<WebElement> element = driver.findElements(By.xpath(Xpath));
		      return element;
		}
		
		public void ClickJs(WebElement element) {
			Visibilityof(element);
			if(IsEnabled(element) && (IsDisplayed(element))) {
	        JavascriptExecutor executor=(JavascriptExecutor)driver;
	        executor.executeScript("arguments[0].click()", element);
			}
		}
		public void SwitchToChildWindow(String id) {
	          driver.switchTo().window(id);
		}
		public void SwitchToFrameByIndex(int index) {
			driver.switchTo().frame(index);
		}
		public void SwitchToFrameById(String id) {
			driver.switchTo().frame(id);
		}
		public void implicitwait(int secs) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secs));
		}
		public void implicitwait() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		public void ExplicitWaitVisibitlityOf(int secs,String id) {
			WebDriverWait ref = new WebDriverWait(driver, Duration.ofSeconds(secs));
			WebElement element = ref.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(id))));
		}
		public void ExplicitWaitVisibitlityOfElementLocated(int secs,String id) {
			WebDriverWait ref = new WebDriverWait(driver, Duration.ofSeconds(secs));
		}
		public void FluentWait(int secs) {
			Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(secs)).pollingEvery(Duration.ofSeconds(secs)).ignoring(Exception.class);
		}
		public boolean IsDisplayed(WebElement element) {
			Visibilityof(element);
			boolean b = element.isDisplayed();
			return b;
		}
		public boolean IsEnabled(WebElement element) {
			Visibilityof(element);
			boolean b = element.isEnabled();
			return b;
		}
		public void IsSelected(WebElement element) {
			Visibilityof(element);
			element.isSelected();
		}
		public void IsMultiple(WebElement element) {
			Visibilityof(element);
			Select s=new Select(element);
			s.isMultiple();
		}
		public void NavigateTo(String text) {
			Navigation navigate = driver.navigate();
			navigate.to(text);
		}
		public void NavigateBack() {
			Navigation navigate = driver.navigate();
			navigate.back();	
		}
		public void NavigateForward() {
			Navigation navigate = driver.navigate();
			navigate.forward();
		}
		public void Refresh() {
			driver.navigate().refresh();
		}
		public void ThreadSleep(int secs) throws InterruptedException {
	         Thread.sleep(secs);
		}
		public void MoveToElement(WebElement element) {
			Visibilityof(element);
			Actions a= new Actions(driver);
			a.moveToElement(element).perform();
		}
		public void DragAndDrop(WebElement s, WebElement d) {
			Visibilityof(s);
			Visibilityof(d);
			Actions a= new Actions(driver);
			a.dragAndDrop(s, d);
		}
		public void RightClick(WebElement element) {
			Visibilityof(element);
			Actions a= new Actions(driver);
			a.contextClick(element).perform();
		}
		public void DoubleClick(WebElement element) {
			Visibilityof(element);
			Actions a= new Actions(driver);
			a.doubleClick(element).perform();
		}
		public void Clear(WebElement element) {
			Visibilityof(element);
	         element.clear();
		}
		public void DeSelectByIndex(WebElement element,int index) {
			Visibilityof(element);
	        Select s=new Select(element);
	        s.deselectByIndex(index);
		}
		public void DeSelectByValue(WebElement element,String value) {
			if(IsEnabled(element) && (IsDisplayed(element)) && value!=null) {
			Visibilityof(element);
	        Select s=new Select(element);
	        s.deselectByValue(value);
			}
		}
		public void DeSelectByText(WebElement element,String value) {
			if(IsEnabled(element) && (IsDisplayed(element)) && value!=null) {
			Visibilityof(element);
	        Select s=new Select(element);
	        s.deselectByVisibleText(value);
			}
		}
		public void DeSelectAll(WebElement element) {
			Visibilityof(element);
	        Select s=new Select(element);
	        s.deselectAll();
		}
		public void GetOptions(WebElement element) {
			Visibilityof(element);
	        Select s=new Select(element);
	        s.getOptions();
		}
		public void GetAllSelectedOptions(WebElement element) {
			Visibilityof(element);
	        Select s=new Select(element);
	        s.getAllSelectedOptions();
		}
		public void GetFirstSelectedOptions(WebElement element) {
			Visibilityof(element);
	        Select s=new Select(element);
	        s.getFirstSelectedOption();
		}
		public void acceptalert() {
			Alert a= driver.switchTo().alert();
			a.accept();
		}
		public void alert() {
			driver.switchTo().alert();
		}
		public void dismissalert() {
			Alert a= driver.switchTo().alert();
			a.dismiss();
		}
		public void SendKeysInAlert(String text) {
			Alert a= driver.switchTo().alert();
			a.sendKeys(text);
		}
		public void GetTextInAlert(String text) {
			Alert a= driver.switchTo().alert();
			a.getText();
		}
		public void KeyPress(int index) throws AWTException {
			Robot r=new Robot();
			r.keyPress(index);
		}
		public void KeyRelease(int index) throws AWTException {
			Robot r=new Robot();
			r.keyRelease(index);
		}
		public void KeyDown(CharSequence key) {
			Actions a=new Actions(driver);
			a.keyDown(key);
		}
		public void KeyUp(CharSequence key) {
			Actions a=new Actions(driver);
			a.keyUp(key);
		}
		public String ParentWindow() {
	       return driver.getWindowHandle();
		}
		public void ScreenShot(WebElement element,String name) throws IOException {
			Visibilityof(element);
			if(IsEnabled(element) && (IsDisplayed(element)) && name!=null) {
	     File s=element.getScreenshotAs(OutputType.FILE);
	     File d=new File("C:\\Users\\IND\\eclipse-workspace\\BaseClass\\ScreenShot"+name+".png");
	     FileUtils.copyFile(s, d);
			}
		}
		public void ScreenShot(String name) throws IOException {		
			 TakesScreenshot screenshot=(TakesScreenshot)driver;
		     File s=screenshot.getScreenshotAs(OutputType.FILE);
		     File d=new File("C:\\Users\\IND\\eclipse-workspace\\BaseClass\\ScreenShot"+name+".png");
		     FileUtils.copyFile(s, d);
		}
		public void Visibilityof(WebElement element) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		public String GetText(WebElement element) {
			String text = "";
			Visibilityof(element);
			boolean displayed = IsDisplayed(element);
			if (displayed) {
				text = element.getText();

			}
			return text;

		}

		public String GetCellData(String SheetName,int rownum,int cellnum) throws IOException {
	        String res=null;
	        File f=new File("C:\\Users\\hi\\java eclipse-workspace\\class\\Excel\\Grocery.xlsx");
	        FileInputStream f1=new FileInputStream(f);
	        Workbook w=new XSSFWorkbook(f1);
	        Sheet s = w.getSheet(SheetName);
	        Row r = s.getRow(rownum);
	        Cell c = r.getCell(cellnum);
	        CellType t = c.getCellType();
	        switch (t) {
			case STRING:
				res=c.getStringCellValue();
				break;
			case NUMERIC:
				if(DateUtil.isCellDateFormatted(c)) {
					Date d = c.getDateCellValue();
					SimpleDateFormat df=new SimpleDateFormat("dd/mm/yy");
					res=df.format(d);
				}else {
					double ncv = c.getNumericCellValue();
					long round = Math.round(ncv);
				if(ncv==round) {
					res=String.valueOf(round);
				}else {
					res=String.valueOf(ncv);
				}
				}
				break;
			    default:
				break;
			    }
	        return res;
		}
		public void UpdateCellData(String OldData,String NewData,String SheetName,int rownum,int cellnum) throws IOException {
	        File f=new File("C:\\Users\\IND\\eclipse-workspace\\BaseClass\\Excel");
	        FileInputStream f1=new FileInputStream(f);
	        Workbook w=new XSSFWorkbook(f1);
	        Sheet s = w.getSheet(SheetName);
	        Row r = s.getRow(rownum);
	        Cell c = r.getCell(cellnum);
	        String value = c.getStringCellValue();
	        if(value.equals(OldData)) {
	        	c.setCellValue(NewData);
	        }
	        FileOutputStream fos=new FileOutputStream(f);
	        w.write(fos);
		}
		public void WriteCellData(String Data,String SheetName,int rownum,int cellnum) throws IOException {
			File f=new File("C:\\Users\\IND\\eclipse-workspace\\BaseClass\\Excel");
	        FileInputStream f1=new FileInputStream(f);
	        Workbook w=new XSSFWorkbook(f1);
	        Sheet s = w.getSheet(SheetName);
	        Row r = s.getRow(rownum);
	        Cell c = r.createCell(cellnum);
	        FileOutputStream fos=new FileOutputStream(f);
	        w.write(fos);
		}
		
	
		
		}
			
	
		

