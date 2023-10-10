package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

class BeneficiarioSelenium {


	private static WebDriver driver;
	private static WebDriverWait we;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		we = new WebDriverWait(driver, 0);
	}

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
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement entrar = driver.findElement(By.cssSelector(".social-btn img"));
			entrar.click();

		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	@Test
	@DisplayName("With Empty Name Field")
	void createEstudanteComNameField() throws InterruptedException {

		try {
			driver.get("http://localhost:3000/boasVindas");
			Thread.sleep(5000);

			WebElement tew = we.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/ul/li[5]/a/span")));
			tew.click();

			WebElement s = we.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//*[@id=\"root\"]/div/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/span/input")));
			s.sendKeys("P");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			WebElement novo = we
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"btnNew\"]/span")));
			novo.click();
			Thread.sleep(5000);
			WebElement nome = we.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"idNome\"]")));
			nome.sendKeys("Pedro Sousa");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement matricula = we
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"idMatricula\"]")));
			matricula.sendKeys("201526109221");
			Thread.sleep(5000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement email = we
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"idEmail\"]")));
			email.sendKeys("pedrosousa@gmail.com");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(5000);
			WebElement campus = we
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"idCampus\"]")));
			campus.sendKeys("Campina Grande");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement curso = we
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"idCurso\"]")));
			curso.sendKeys("TCE");
			Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement cadastrar = we.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div[2]/div/div/div[2]/form/div[2]/div[2]/button")));
			cadastrar.click();

			Thread.sleep(5000);
			String toastTitle = driver.findElement(By.xpath("//*[@id=\"pr_id_2\"]/ul/li/input")).getText();
			String toastMessage = driver.findElement(By.xpath("//*[@id=\"pr_id_3\"]/ul/li/input")).getText();

			Assert.assertEquals(toastTitle, "Erro");
			Assert.assertEquals(toastMessage, "O Nome Beneficiario deve ter no mínimo 2 e no máximo 100 caracteres!");

			Thread.sleep(2000);

			driver.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	void cadastrarNovoBeneficiario() throws InterruptedException {
		try {
			driver.get("http://localhost:3000/listarBeneficiarios");
			Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement novo = we.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div[2]/div/div/div[2]/form/div[2]/div[2]/button")));
			novo.click();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Test
	void detalnherBeneficiario() throws InterruptedException {
		try {
			driver.get("http://localhost:3000/listarBeneficiarios");
			Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement detalhe = we.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//*[@id=\"root\"]/div/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/table/tbody/tr[1]/td[5]/button[1]/span[1]")));
			Thread.sleep(2000);
			detalhe.click();

			WebElement voltar = we
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"btnBack\"]/span")));
			Thread.sleep(5000);
			voltar.click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	void editarBeneficiario() throws InterruptedException {
		try {
			driver.get("http://localhost:3000/listarBeneficiarios");
			Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement editar = we.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//*[@id=\"root\"]/div/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/table/tbody/tr[1]/td[5]/button[1]/span[1]")));
			Thread.sleep(2000);
			editar.click();

			WebElement edital = we
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pr_id_6\"]/ul/li/input")));
			Thread.sleep(5000);
			edital.click();

			WebElement ativo = we
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"idAtivo\"]")));
			Thread.sleep(5000);
			ativo.click();

			WebElement programa = we.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"			//*[@id=\"root\"]/div/div[2]/div/div[2]/div[2]/div/div/div/form/div/div[6]/div/input\r\n"
							+ "")));
			Thread.sleep(5000);
			programa.sendKeys("Program de Alimentação Jantar");

			WebElement atualizar = we
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"btnCreate\"]/span")));
			Thread.sleep(5000);
			atualizar.click();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	void excluirBeneficiario() throws InterruptedException {
		driver.get("http://localhost:3000/listarBeneficiarios");

		WebElement apagar = we.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//*[@id=\"root\"]/div/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[2]/table/tbody/tr[1]/td[5]/button[3]")));
		Thread.sleep(5000);
		apagar.click();
		Thread.sleep(5000);
		driver.get("http://localhost:3000/listarBeneficiarios");

	}
}
