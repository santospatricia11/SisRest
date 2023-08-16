package sisrest.testSeleniun;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class ContaServidorSeleniun {
	private static WebDriver driver;
	private static WebDriverWait we;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		we = new WebDriverWait(driver, 0);
	}

	/*
	 * @Test void test() { fail("Not yet implemented"); }
	 */

	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	void loginTest() throws NoSuchElementException {
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");

			driver.get("http://localhost:3000");
			WebElement selectEntrar = driver.findElement(By.cssSelector(".social-btn img"));
			selectEntrar.click();
			WebElement email = driver.findElement(By.cssSelector(".N3Hzgf .zHQkBf"));
			email.sendKeys("patricia.pereira@academico.ifpb.edu.br");
			WebElement avancar = driver.findElement(By.cssSelector(".VfPpkd-LgbsSe-OWXEXe-k8QpJ"));
			avancar.click();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebDriverWait t = new WebDriverWait(driver, 10);
			WebElement senha = t
					.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ze9ebf .zHQkBf")));
			senha.sendKeys("coracao100%a");
			WebElement avança = driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span"));
			avança.click();

			WebElement entrar = driver.findElement(By.cssSelector(".social-btn img"));
			entrar.click();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	@Test
	void cadastroNovoServidorValido() throws TimeoutException, InterruptedException {
		// http://localhost:3000/boasVindas
		driver.get("http://localhost:3000/boasVindas");
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement ben = we.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("	//*[@id=\"root\"]/div/div[2]/div/div[1]/div/ul/li[8]")));
			ben.click();
			Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement tew = we
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"idFilterNome\"]")));
			tew.sendKeys("patricia");
			Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement matricula = we
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"idFilterMatricula\"]")));
			matricula.sendKeys("123456");
			Thread.sleep(2000);
			WebElement email = we
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("	//*[@id=\"idFilterEmail\"]")));
			email.sendKeys("patriciasantos@gmail.com");
			Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			WebElement nova = we.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div[2]/div/div/div[2]/form/div[2]/div/button")));
			nova.click();
			Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			WebElement nome = we.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"		//*[@id=\"root\"]/div/div[2]/div/div[2]/div[2]/div/div/div/form/div[1]/div[1]/div/input\r\n"
							+ "")));
			nome.sendKeys("Patricia Santos");
			Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement em = we.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"			//*[@id=\"root\"]/div/div[2]/div/div[2]/div[2]/div/div/div/form/div[1]/div[2]/div/input\r\n"
							+ "")));
			em.sendKeys("patriciasantos@gmail.com");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			WebElement se = we.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"		//*[@id=\"root\"]/div/div[2]/div/div[2]/div[2]/div/div/div/form/div[1]/div[3]/div/select\r\n"
							+ "")));
			se.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement ma = we.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"		//*[@id=\"root\"]/div/div[2]/div/div[2]/div[2]/div/div/div/form/div[1]/div[4]/div/input\r\n"
							+ "")));
			ma.sendKeys("2333335");
			Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement campus = we.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"		//*[@id=\"root\"]/div/div[2]/div/div[2]/div[2]/div/div/div/form/div[1]/div[5]/div/input\r\n"
							+ "")));
			campus.sendKeys("Monteiro");

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement cadastrar = we.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"		//*[@id=\"root\"]/div/div[2]/div/div[2]/div[2]/div/div/div/form/div[2]/div/div[2]/div/button/span\r\n"
							+ "")));
			cadastrar.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("http://localhost:3000/listarContasServidor");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}
}
