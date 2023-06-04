package sisrest.test.beneficiario;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;

import com.sisrest.model.entities.Beneficiario;
import com.sisrest.services.BeneficiarioService;

class BeneficiarioSelenium {
	private Beneficiario beneficiario;
	private static ChromeDriver driver;

	@Autowired
	private BeneficiarioService beneficiarioService;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	@EnabledOnOs(value = OS.WINDOWS)

	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Test
	// esse valido
	void seveBeneficiario() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();
		driver.get("http://localhost:3000/criar");

		WebElement selectEdital = driver.findElement(By.id("inputEdital"));
		Select select1 = new Select(selectEdital);
		select1.selectByIndex(2);

		WebElement name = driver.findElement(By.id("inputNome"));
		name.sendKeys("Patricia");

		WebElement matricula = driver.findElement(By.id("inputMatricula"));
		matricula.sendKeys("12345666999");

		WebElement cpf = driver.findElement(By.id("inputCPF"));
		Select select = new Select(cpf);
		select.selectByIndex(1);

		WebElement email = driver.findElement(By.id("inputEmail"));
		email.sendKeys(" patriciasantospb7@gmail.com");

		WebElement selectCampus = driver.findElement(By.id("inputCampus"));
		Select select2 = new Select(selectCampus);
		select2.selectByIndex(2);

		WebElement cadastrar = driver.findElement(By.id("buttonCadastrar"));
		cadastrar.click();
		Thread.sleep(5000);
	}

	@Test
	void cancelarButtonCreateBeneficiario() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:3000/createUser");

		WebElement cancel = driver.findElement(By.id("buttonCancelar"));
		cancel.click();
		// Thread.sleep(5000);
		driver.navigate().to("http://localhost:3000");

	}

	@Test
	void updateBeneficiario() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:3000/criar");

		List<WebElement> editar = driver.findElements(By.id("idEdit"));

		editar.get(0).click();

	}

	@AfterEach
	void tearDown() {
		driver.quit();

	}

}
