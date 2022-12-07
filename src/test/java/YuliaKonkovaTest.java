import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class YuliaKonkovaTest {

    @Test
    public void testH2TagText_WhenSearchingCityCountry() throws InterruptedException {//требования к названию теста - что где когда (мы тестируем)
        System.setProperty("webdriver.chrome.driver", "/Users/juliafedosova/Desktop/Java_2022/chromedriver/chromedriver");
        WebDriver driver = new ChromeDriver();

        //arrange
        String url = "https://openweathermap.org/";
        String cityName = "Paris";
        String expectedResult = "Paris, FR";

        //act
        driver.get(url);
        Thread.sleep(10000);
        WebElement searchCityField = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//input[@placeholder='Search city']")
        );
        searchCityField.click();
        searchCityField.sendKeys(cityName);
        WebElement searchButton = driver.findElement(
                By.xpath("//div[@id='weather-widget']//button[@type='submit']")
        );
        searchButton.click();

        Thread.sleep(3000);
        WebElement parisFRChoiceInDropdownMenu = driver.findElement(
                By.xpath("//ul[@class='search-dropdown-menu']/li/span[text()='Paris, FR ']")
        );
        parisFRChoiceInDropdownMenu.click();
        Thread.sleep(3000);

        WebElement h2CityNameHeader = driver.findElement(By.xpath("//div[@id='weather-widget']//h2"));

        Thread.sleep(1000);
        String actualResult = h2CityNameHeader.getText();

        //assert
        Assert.assertEquals(actualResult,expectedResult);

        driver.quit();
    }
}
