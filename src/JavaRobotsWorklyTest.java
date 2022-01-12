
import Robo.AppRobo;
import io.github.bonigarcia.wdm.WebDriverManager;
import sql.Database;

import java.io.File;
import java.util.List;

import org.ini4j.Ini;
import org.openqa.selenium.chromeclass.SeleniumChrome;

public class JavaRobotsWorklyTest {

    public static Ini ini = null;
    public static void main(String[] args) {
        //Try to load the ini file, if it doesn't exist, print an error message
        try {
            ini = new Ini(new File("javaRobotsWorklyTest.ini"));
            
            //initialize the AppRobo
            AppRobo robo = new AppRobo("Teste de Funcionamento");
            
            //get parameters of robot
            robo.definirParametros();
            //define 'parametro'
            String parametro = robo.getParametro("parametro") == null ? "null" : robo.getParametro("parametro");

            //execute the robot
            robo.executar(executar(parametro));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        System.exit(0);
    }

    public static String executar(String parametro) {
        StringBuilder r = new StringBuilder();

        //show 'Parametro recebido' = 'parametro'
        r.append("Parametro recebido: " + parametro + "\n");

        r.append("Status conexão bancos de dados:<br>");
        //show 'Mysql ZAC' = try to connect to database using the config 'databases.zac'
        //r.append("Mysql ZAC: " + work((new Database(ini.get("databases", "zac"))).testConnection()) + "<br>");
        //show 'Sci Unico' = try to connect to database using the config 'databases.sci'
        //r.append("Sci Unico: " + work((new Database(ini.get("databases", "sci"))).testConnection()) + "<br>");
        r.append("<br>");

        r.append("Status Selenium Webdriver Chrome:").append("<br>");

        //show 'Abrindo' = try to open chrome
        r.append("Abrindo: ");
        try {
            SeleniumChrome chrome = new SeleniumChrome();

            boolean abriu = chrome.abrirChrome("http://google.com");
            chrome.fecharChrome();
            
            r.append(work(abriu)).append("<br>");
        } catch (Exception e) {
            r.append(work(false)).append("<br>");
        }
        
        //show 'Local do ChromeDriver' = try to get the path of chrome driver
        r.append("Local do ChromeDriver: ");
        try {
            String path = WebDriverManager.chromedriver().getBinaryPath();
            r.append(path).append("<br>");
        } catch (Exception e) {
            r.append("ChromeDriver não encontrado!").append("<br>");
        }

        //show 'Versão do ChromeDriver Baixado' = try to get the version of chrome driver downloaded
        r.append("Versão do ChromeDriver Baixado: ");
        try {
            String version = WebDriverManager.chromedriver().getDownloadedVersion();            
            r.append(version).append("<br>");
        } catch (Exception e) {
            r.append("ChromeDriver não encontrado!").append("<br>");
        }

        //show 'Última Versão do Google Chrome' = try to get the last version of google chrome
        r.append("Última Versão do Google Chrome(incluindo Canary): ");
        try {
            List<String> l = WebDriverManager.chromedriver().getVersions();

            String version = (String) l.get(l.size() - 1);
            r.append(version).append("<br>");
        } catch (Exception e) {
            r.append("Google Chrome não encontrado!").append("<br>");
        }

        return r.toString();
    }

    private static String work(boolean test, String errorMessage) {
        return test ? "OK" : errorMessage;
    }

    private static String work(boolean test) {
        return work(test, "Não Funcionou");
    }


}