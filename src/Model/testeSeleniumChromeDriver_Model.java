package Model;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;
import org.openqa.selenium.chromeclass.SeleniumChrome;

public class testeSeleniumChromeDriver_Model {
    public static boolean abrindo() {
        try {
            SeleniumChrome chrome = new SeleniumChrome();

            boolean abriu = chrome.abrirChrome("http://google.com");
            chrome.fecharChrome();
            return abriu;
        } catch (Exception e) {
        }
        return false;
    }

    public static String localChromeDriver() {
        try {
            return WebDriverManager.chromedriver().getBinaryPath();
        } catch (Exception e) {
        }
        return "ChromeDriver não encontrado!";
    }

    public static String versionChromeDriverDownloaded() {
        try {
            return WebDriverManager.chromedriver().getDownloadedVersion();
        } catch (Exception e) {
        }
        return "ChromeDriver não encontrado!";
    }

    public static String lastVersionChrome() {
        try {
            List l = WebDriverManager.chromedriver().getVersions();

            return (String) l.get(l.size() - 1);
        } catch (Exception e) {
        }
        return "Google Chrome não encontrado não encontrado!";
    }
}