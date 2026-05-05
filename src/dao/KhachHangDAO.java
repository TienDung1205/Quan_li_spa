package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.KhachHang;

public class KhachHangDAO extends DAO {

    public KhachHangDAO() {
        super();
    }

    public boolean themMoiKH(KhachHang kh) {
        String sql = "INSERT INTO tblKhachHang(tenDangNhap, matKhau, hoTen, email, sdt) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            kh.bindThemMoiParams(ps);
            return ps.executeUpdate() > 0;
        } catch (Exception ex) {
            System.out.println("Loi themMoiKH: " + ex.getMessage());
            return false;
        }
    }

    public boolean isExistedTenDangNhap(KhachHang kh) {
        String sql = "SELECT id FROM tblKhachHang WHERE tenDangNhap = ?";
        if (kh.getTenDangNhap() == null || kh.getTenDangNhap().isEmpty()) {
            return false;
        }
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, kh.getTenDangNhap());
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (Exception ex) {
            System.out.println("Loi isExistedTenDangNhap: " + ex.getMessage());
            return false;
        }
    }

    public boolean isExistedEmail(KhachHang kh) {
        String sql = "SELECT id FROM tblKhachHang WHERE email = ?";
        String email = kh.getEmail();
        if (email == null || email.isEmpty()) {
            return false;
        }
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (Exception ex) {
            System.out.println("Loi isExistedEmail: " + ex.getMessage());
            return false;
        }
    }

    public boolean isExistedSDT(KhachHang kh) {
        String sql = "SELECT id FROM tblKhachHang WHERE sdt = ?";
        String sdt = kh.getSdt();
        if (sdt == null || sdt.isEmpty()) {
            return false;
        }
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, sdt);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (Exception ex) {
            System.out.println("Loi isExistedSDT: " + ex.getMessage());
            return false;
        }
    }

}
