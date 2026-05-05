
package dao;

import config.DBConnection;
import java.sql.Connection;
import java.sql.SQLException;

public class DAO {
    protected Connection con;

    public DAO() {
        try {
            con = DBConnection.getConnection();
        } catch (SQLException ex) {
            throw new RuntimeException("Khong the ket noi CSDL: " + ex.getMessage(), ex);
        }
    }
}
