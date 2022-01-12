package Model;

import sql.Database;

public class testeBancos_Model {
    public static boolean mysqlZac() {
        Database mysqlDb = new Database("\\\\zac\\robos\\Tarefas\\Arquivos\\mysql.cfg");
        return mysqlDb.testConnection();
    }

    public static boolean sciUnico() {
        Database sciDb = new Database("\\\\zac\\robos\\Tarefas\\Arquivos\\sci.cfg");
        return sciDb.testConnection();
    }

    public static boolean questor() {
        Database questorDb = new Database("\\\\zac\\robos\\Tarefas\\Arquivos\\questor.cfg");
        return questorDb.testConnection();
    }
}