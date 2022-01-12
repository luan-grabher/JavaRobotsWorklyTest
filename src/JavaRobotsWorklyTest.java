
import Robo.AppRobo;
import Model.testeBancos_Model;
import Model.testeSeleniumChromeDriver_Model;

public class JavaRobotsWorklyTest {
    public static void main(String[] args) {
        AppRobo robo = new AppRobo("Teste de Funcionamento");

        try {
            robo.definirParametros();
            String parametro = robo.getParametro("parametro");
            robo.executar(executar(parametro));   
        } catch (Exception e) {
            //printa o erro
            System.out.println(e.getMessage());
        }
        System.exit(0);
    }

    public static String executar(String parametro) {
        StringBuilder r = new StringBuilder();

        String retornoParametro = parametro.equals("") ? ""
                : new StringBuilder().append("Recebi um parâmetro: <b>'").append(parametro).append("'</b><br><br>")
                        .toString();
        r.append(retornoParametro);

        r.append("Status conexão bancos de dados:<br>");
        r.append("Mysql ZAC: ").append(servicoFuncionando(testeBancos_Model.mysqlZac())).append("<br>");
        r.append("SCI Unico: ").append(servicoFuncionando(testeBancos_Model.sciUnico())).append("<br>");
        r.append("Questor: ").append(servicoFuncionando(testeBancos_Model.questor())).append("<br>");
        r.append("<br>");
        r.append("Status Selenium Webdriver Chrome:").append("<br>");
        r.append("Abrindo: ").append(servicoFuncionando(testeSeleniumChromeDriver_Model.abrindo()))
                .append("<br>");
        r.append("Local chromedriver: ").append(testeSeleniumChromeDriver_Model.localChromeDriver())
                .append("<br>");
        r.append("Versão chromedriver: ")
                .append(testeSeleniumChromeDriver_Model.versionChromeDriverDownloaded()).append("<br>");
        r.append("Ultima versão Chrome(incluindo Canary): ")
                .append(testeSeleniumChromeDriver_Model.lastVersionChrome()).append("<br>");

        return r.toString();
    }

    private static String servicoFuncionando(boolean test) {
        return test ? "Funcionando" : "Erro";
    }
}