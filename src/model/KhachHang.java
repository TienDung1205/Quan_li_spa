package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class KhachHang {
    private int id;
    private String tenDangNhap;
    private String matKhau;
    private String hoTen;
    private String email;
    private String sdt;

    public KhachHang() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void bindThemMoiParams(PreparedStatement ps) throws SQLException {
        ps.setString(1, tenDangNhap);
        ps.setString(2, matKhau);
        ps.setString(3, hoTen);
        ps.setString(4, email);
        ps.setString(5, sdt);
    }
}
