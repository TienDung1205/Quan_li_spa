
package view;

import dao.NhanVienDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.NhanVien;

public class DangNhapQLFrm extends JFrame implements ActionListener {
    private JTextField txtTenDangNhap;
    private JPasswordField txtMatKhau;
    private JButton btnDangNhap;

    public DangNhapQLFrm() {
        setTitle("Dang nhap quan ly");
        setSize(420, 230);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(null);

        JLabel lblUser = new JLabel("Ten dang nhap:");
        lblUser.setBounds(25, 30, 120, 25);
        panel.add(lblUser);

        txtTenDangNhap = new JTextField();
        txtTenDangNhap.setBounds(145, 30, 220, 25);
        panel.add(txtTenDangNhap);

        JLabel lblPass = new JLabel("Mat khau:");
        lblPass.setBounds(25, 70, 120, 25);
        panel.add(lblPass);

        txtMatKhau = new JPasswordField();
        txtMatKhau.setBounds(145, 70, 220, 25);
        panel.add(txtMatKhau);

        btnDangNhap = new JButton("Dang nhap");
        btnDangNhap.setBounds(145, 115, 130, 30);
        btnDangNhap.addActionListener(this);
        panel.add(btnDangNhap);
        getRootPane().setDefaultButton(btnDangNhap);

        setContentPane(panel);
        setResizable(false);
    }

    private void btnDangNhapClick() {
        try {
            String tenDangNhap = txtTenDangNhap.getText();
            String matKhau = new String(txtMatKhau.getPassword());

            if (tenDangNhap.isEmpty() || matKhau.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nhap day du thong tin dang nhap.");
                return;
            }

            NhanVien nv = new NhanVien(tenDangNhap, matKhau);
            NhanVienDAO dao = new NhanVienDAO();
            if (!dao.checkDangNhap(nv)) {
                JOptionPane.showMessageDialog(this, "Sai ten dang nhap hoac mat khau.");
                return;
            }

            TrangChuQLFrm frm = new TrangChuQLFrm(nv);
            frm.setVisible(true);
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Loi dang nhap: " + ex.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnDangNhap) {
            btnDangNhapClick();
        }
    }
}
