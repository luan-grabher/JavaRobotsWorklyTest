package TesteDeFuncionamento.Model;

import sql.Banco;

public class testeBancos_Model {
    private static final String mySqlPath = "\\\\zac\\robos\\Tarefas\\Arquivos\\mysql.cfg";
    private static final String sciPath = "\\\\zac\\robos\\Tarefas\\Arquivos\\sci.cfg";
    private static final String questorPath = "\\\\zac\\robos\\Tarefas\\Arquivos\\questor.cfg";

    public static boolean mysqlZac() {
        Banco mysqlDb = new Banco("\\\\zac\\robos\\Tarefas\\Arquivos\\mysql.cfg");
        return mysqlDb.testConnection();
    }

    public static boolean sciUnico() {
        Banco sciDb = new Banco("\\\\zac\\robos\\Tarefas\\Arquivos\\sci.cfg");
        return sciDb.testConnection();
    }

    public static boolean questor() {
        Banco questorDb = new Banco("\\\\zac\\robos\\Tarefas\\Arquivos\\questor.cfg");
        return questorDb.testConnection();
    }
}