package view;

import dao.KhachHangDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.KhachHang;

public class TrangThemMoiKhachHangFrm extends JFrame implements ActionListener {
    private JTextField txtTenDangNhap;
    private JPasswordField txtMatKhau;
    private JTextField txtHoTen;
    private JTextField txtEmail;
    private JTextField txtSdt;
    private JButton btnThemMoi;
    private KhachHang kh;

    public TrangThemMoiKhachHangFrm(KhachHang kh) {
        this.kh = kh;
        setTitle("Them moi khach hang");
        setSize(460, 320);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel(null);

        JLabel lblTenDangNhap = new JLabel("Ten dang nhap:");
        lblTenDangNhap.setBounds(30, 25, 120, 25);
        panel.add(lblTenDangNhap);

        txtTenDangNhap = new JTextField();
        txtTenDangNhap.setBounds(160, 25, 250, 25);
        panel.add(txtTenDangNhap);

        JLabel lblMatKhau = new JLabel("Mat khau:");
        lblMatKhau.setBounds(30, 60, 120, 25);
        panel.add(lblMatKhau);

        txtMatKhau = new JPasswordField();
        txtMatKhau.setBounds(160, 60, 250, 25);
        panel.add(txtMatKhau);

        JLabel lblHoTen = new JLabel("Ho ten:");
        lblHoTen.setBounds(30, 95, 120, 25);
        panel.add(lblHoTen);

        txtHoTen = new JTextField();
        txtHoTen.setBounds(160, 95, 250, 25);
        panel.add(txtHoTen);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(30, 130, 120, 25);
        panel.add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(160, 130, 250, 25);
        panel.add(txtEmail);

        JLabel lblSdt = new JLabel("SDT:");
        lblSdt.setBounds(30, 165, 120, 25);
        panel.add(lblSdt);

        txtSdt = new JTextField();
        txtSdt.setBounds(160, 165, 250, 25);
        panel.add(txtSdt);

        btnThemMoi = new JButton("Them moi");
        btnThemMoi.setBounds(160, 210, 120, 32);
        btnThemMoi.addActionListener(this);
        panel.add(btnThemMoi);
        getRootPane().setDefaultButton(btnThemMoi);

        setContentPane(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnThemMoi) {
            btnThemMoiClick();
        }
    }

    private void btnThemMoiClick() {
        String tenDangNhap = txtTenDangNhap.getText();
        String matKhau = new String(txtMatKhau.getPassword());
        String hoTen = txtHoTen.getText().trim();
        String email = txtEmail.getText();
        String sdt = txtSdt.getText();

        String tenDangNhapPattern = "^[a-zA-Z0-9_]+$";
        int minPasswordLength = 6;
        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        String sdtPattern = "^0\\d{9,10}$";
        
        if (!tenDangNhap.matches(tenDangNhapPattern)) {
            JOptionPane.showMessageDialog(this, "Ten dang nhap khong hop le.");
            return;
        }
        
        if (!matKhau.equals(matKhau.trim())) {
            JOptionPane.showMessageDialog(this, "Mat khau khong duoc co khoang trang o dau hoac cuoi.");
            return;
        }
        
        if (matKhau.length() < minPasswordLength) {
            JOptionPane.showMessageDialog(this, "Mat khau phai co it nhat 6 ky tu.");
            return;
        }
        if (hoTen.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ho ten khong hop le.");
            return;
        }
        if (!email.matches(emailPattern)) {
            JOptionPane.showMessageDialog(this, "Email khong hop le.");
            return;
        }
        if (!sdt.matches(sdtPattern)) {
            JOptionPane.showMessageDialog(this, "So dien thoai khong hop le.");
            return;
        }

        kh.setTenDangNhap(tenDangNhap);
        kh.setMatKhau(matKhau);
        kh.setHoTen(hoTen);
        kh.setEmail(email);
        kh.setSdt(sdt);

        KhachHangDAO dao = new KhachHangDAO();
        if (dao.isExistedTenDangNhap(kh)) {
            JOptionPane.showMessageDialog(this, "Ten dang nhap da ton tai.");
            return;
        }
        if (dao.isExistedEmail(kh)) {
            JOptionPane.showMessageDialog(this, "Email da ton tai.");
            return;
        }
        if (dao.isExistedSDT(kh)) {
            JOptionPane.showMessageDialog(this, "So dien thoai da ton tai.");
            return;
        }
        if (!dao.themMoiKH(kh)) {
            JOptionPane.showMessageDialog(this, "Them moi khach hang that bai.");
            return;
        }

        TrangThemMoiKHThanhCongFrm frm = new TrangThemMoiKHThanhCongFrm();
        frm.setVisible(true);
        dispose();
    }
}
