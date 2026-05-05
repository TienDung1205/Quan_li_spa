
package app;

import config.DBConnection;
import java.sql.Connection;
import javax.swing.SwingUtilities;
import view.DangNhapQLFrm;

public class Main {
    public static void main(String[] args) {
        try (Connection con = DBConnection.getConnection()) {
            if (con != null && !con.isClosed()) {
                System.out.println("KET NOI DB THANH CONG");
            } else {
                System.out.println("KET NOI DB THAT BAI");
            }
        } catch (Exception ex) {
            System.out.println("KET NOI DB THAT BAI: " + ex.getMessage());
        }

        SwingUtilities.invokeLater(() -> {
            DangNhapQLFrm frm = new DangNhapQLFrm();
            frm.setVisible(true);
        });
    }
}
