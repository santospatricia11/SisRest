package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class LoginSelenium {

	private static WebDriver driver;
	private static WebDriverWait we;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		we = new WebDriverWait(driver, 10);
	}

	void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Test
	@DisplayName("Open screen Home")
	void home() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");

		driver.get("http://localhost:3000");
		assertTrue(driver.getTitle().contentEquals("SisRest"));

		Thread.sleep(3000);
	}

	@Test
	void loginTest() throws NoSuchElementException {
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");

			driver.get("http://localhost:3000");
			WebElement selectEntrar = driver.findElement(By.cssSelector(".social-btn img"));
			selectEntrar.click();

			WebElement email = driver.findElement(By.cssSelector(".N3Hzgf .zHQkBf"));
			email.sendKeys(" patricia.pereira@academico.ifpb.edu.br");

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

		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	//@Test
	void seveBeneficiario() throws InterruptedException, WebDriverException {

		try {
			driver.get("http://localhost:3000/boasVindas");

			WebDriverWait we = new WebDriverWait(driver, 0);
			WebElement tew = we.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/ul/li[5]/a/span")));
			tew.click();
			Thread.sleep(3000);
			WebElement s = we.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//*[@id=\"root\"]/div/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/span/input")));
			s.sendKeys("patricia");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(3000);
			WebElement novo = we
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"btnNew\"]/span")));
			novo.click();
			///////////////////////////////////
			// cadastro novo estudante
			Thread.sleep(3000);
			WebElement nome = we.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"idNome\"]")));
			nome.sendKeys("Pedro Sousa");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement matricula = we
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"idMatricula\"]")));
			matricula.sendKeys("201526109221");
			Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement email = we
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"idEmail\"]")));
			email.sendKeys("pedrosousa@gmail.com");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(3000);
			WebElement campus = we
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"idCampus\"]")));
			campus.sendKeys("Campina Grande");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement curso = we
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"idCurso\"]")));
			curso.sendKeys("TCE");
			Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement cadastrar = we.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div[2]/div/div/div[2]/form/div[2]/div[2]/button")));
			cadastrar.click();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	void editarBeneficiario() throws InterruptedException {
		// driver.get("http://localhost:3000/atualizarContaEstudante/8");
		try {

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebDriverWait we = new WebDriverWait(driver, 10);
			Thread.sleep(3000);
			WebElement tew = we.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//*[@id=\"root\"]/div/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/table/tbody/tr[1]/td[6]/button[1]/span[1]")));
			tew.click();
			Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebDriverWait ti = new WebDriverWait(driver, 10);
			WebElement s = ti.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//*[@id=\"root\"]/div/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/span/input")));
			s.sendKeys("patricia");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(3000);
			WebElement novo = we
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"btnNew\"]/span")));
			novo.click();
			///////////////////////////////////
			// cadastro novo estudante
			WebElement nome = ti.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"idNome\"]")));
			nome.sendKeys("Maria Sousa");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement matricula = ti
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"idMatricula\"]")));
			matricula.sendKeys("201526109111");
			Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement email = ti
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"idEmail\"]")));
			email.sendKeys("mariaesdu@gmail.com");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(3000);
			WebElement campus = ti
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"idCampus\"]")));
			campus.sendKeys("Monteiro");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(3000);
			WebElement curso = ti
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"idCurso\"]")));
			curso.sendKeys("ADS");
			Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement atualizar = ti.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div[2]/div/div/div[2]/form/div[2]/div[2]/button")));
			atualizar.click();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	void atualizarUsuario() throws InterruptedException {
		driver.get("http://localhost:3000/listarContasEstudante");
		// *[@id="root"]/div/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/table/tbody/tr[1]/td[6]/button[1]/span[1]

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait e = new WebDriverWait(driver, 10);
		Thread.sleep(3000);
		WebElement editar = e.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"		//*[@id=\"root\"]/div/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/table/tbody/tr[1]/td[6]/button[1]/span[1]\r\n"
						+ "")));
		editar.click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait we = new WebDriverWait(driver, 10);
		Thread.sleep(3000);
		WebElement nome = we.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("	//*[@id=\"idNome\"]")));

		nome.sendKeys("Eduarda Santos");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement matricula = we
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"idMatricula\"]")));
		matricula.sendKeys("201526109221");
		Thread.sleep(3000);

		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		WebElement email = we.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"idEmail\"]")));
		email.sendKeys("pedrosousa@gmail.com");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		Thread.sleep(3000);
		WebElement campus = we.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"idCampus\"]")));
		campus.sendKeys("Campina Grande");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		WebElement curso = we.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"idCurso\"]")));
		curso.sendKeys("TCE");
		Thread.sleep(3000);
		WebElement atualizar = we.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//*[@id=\"root\"]/div/div[2]/div/div[2]/div[2]/div/div/div[2]/form/div[2]/div[2]/button\r\n" + "")));

		atualizar.click();
		Thread.sleep(3000);
		driver.get("http://localhost:3000/listarContasEstudante");

	}

	/*
	 * @Test void excluirContaEstudante() {
	 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 * WebDriverWait we = new WebDriverWait(driver, 100); WebElement apagar =
	 * we.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
	 * "		//*[@id=\"root\"]/div/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/table/tbody/tr[1]/td[6]/button[2]/span[1]\r\n"
	 * + "")));
	 * 
	 * apagar.click();
	 * 
	 * driver.get("http://localhost:3000/listarContasEstudante");
	 * 
	 * }
	 */
	@Test
	void seveBeneficiarioInvalido() {

		driver.get("http://localhost:3000/boasVindas");

		WebDriverWait we = new WebDriverWait(driver, 10);
		WebElement tew = we.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/ul/li[5]/a/span")));
		tew.click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement novo = we.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"btnNew\"]/span")));
		novo.click();

		WebElement nome = we.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"idNome\"]")));
		nome.sendKeys("P");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement matricula = we
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"idMatricula\"]")));
		matricula.sendKeys("q");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement email = we.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"idEmail\"]")));
		email.sendKeys("@gmail.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement campus = we.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"idCampus\"]")));
		campus.sendKeys("Campina Grande");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement curso = we.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"idCurso\"]")));
		curso.sendKeys("TCE");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement cadastrar = we.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div[2]/div/div/div[2]/form/div[2]/div[2]/button")));
		cadastrar.click();

	}

}
