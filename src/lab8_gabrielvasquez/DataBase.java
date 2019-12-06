package lab8_gabrielvasquez;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DataBase {

    private String db;
    private Connection conn;
    public Statement query;

    public DataBase(String db) {
        this.db = db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public void conectar() {
        try {
            String driver = "jdbc:ucanaccess://";
            conn = DriverManager.getConnection(driver + db, "", "");
            query = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void desconectar() {
        try {
            query.close();
            conn.close();
        } catch (Exception e) {
        }
    }

    public void commit() {
        try {
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}