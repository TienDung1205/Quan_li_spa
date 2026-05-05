
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.KhachHang;
import model.NhanVien;

public class TrangChuQLFrm extends JFrame implements ActionListener {
    private JButton btnThemMoiKH;
    private JButton btnDanhSachKH;
    private JButton btnDanhSachLichHen;
    private JLabel lblHoTen;
    private NhanVien nv;

    public TrangChuQLFrm(NhanVien nv) {
        this.nv = nv;
        setTitle("Trang chu quan ly");
        setSize(700, 220);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel(null);

        lblHoTen = new JLabel("Xin chao: " + (nv.getHoTen() == null ? nv.getTenDangNhap() : nv.getHoTen()));
        lblHoTen.setBounds(30, 20, 400, 25);
        panel.add(lblHoTen);

        btnThemMoiKH = new JButton("Them moi khach hang");
        btnThemMoiKH.setBounds(20, 70, 210, 36);
        btnThemMoiKH.addActionListener(this);
        panel.add(btnThemMoiKH);

        btnDanhSachKH = new JButton("Danh sach khach hang");
        btnDanhSachKH.setBounds(245, 70, 210, 36);
        panel.add(btnDanhSachKH);

        btnDanhSachLichHen = new JButton("Danh sach lich hen");
        btnDanhSachLichHen.setBounds(470, 70, 210, 36);
        panel.add(btnDanhSachLichHen);

        setContentPane(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnThemMoiKH) {
            btnThemMoiKHClick();
        }
    }

    private void btnThemMoiKHClick() {
        TrangThemMoiKhachHangFrm frm = new TrangThemMoiKhachHangFrm(new KhachHang());
        frm.setVisible(true);
        setVisible(false);
    }
}
