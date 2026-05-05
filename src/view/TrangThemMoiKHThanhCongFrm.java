package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Frame;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TrangThemMoiKHThanhCongFrm extends JFrame implements ActionListener {
    private JLabel lblThanhCong;
    private JButton btnVeTrangChu;

    public TrangThemMoiKHThanhCongFrm() {
        setTitle("Thong bao");
        setSize(360, 180);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel(null);

        lblThanhCong = new JLabel("Them moi khach hang thanh cong!");
        lblThanhCong.setBounds(65, 35, 250, 25);
        panel.add(lblThanhCong);

        btnVeTrangChu = new JButton("Ve trang chu");
        btnVeTrangChu.setBounds(110, 80, 130, 30);
        btnVeTrangChu.addActionListener(this);
        panel.add(btnVeTrangChu);

        setContentPane(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnVeTrangChu) {
            btnVeTrangChuClick();
        }
    }

    private void btnVeTrangChuClick() {
        for (Frame frame : Frame.getFrames()) {
            if (frame instanceof TrangChuQLFrm) {
                frame.setVisible(true);
                frame.toFront();
                break;
            }
        }
        dispose();
    }
}
