package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.NhanVien;

public class NhanVienDAO extends DAO {

    public NhanVienDAO() {
        super();
    }

    public boolean checkDangNhap(NhanVien nv) {
        String sql = "SELECT id, tenDangNhap, hoTen, sdt, trangThai, chucVu "
        + "FROM tblNhanVien "
        + "WHERE BINARY tenDangNhap = BINARY ? "
        + "AND BINARY matKhau = BINARY ? "
        + "AND trangThai = ? "
        + "AND chucVu = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            nv.bindDangNhapParams(ps);
            ps.setString(3, "hoatDong");
            ps.setString(4, "quanLy");
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) {
                    return false;
                }
                nv.setId(rs.getInt("id"));
                nv.setTenDangNhap(rs.getString("tenDangNhap"));
                nv.setHoTen(rs.getString("hoTen"));
                nv.setSdt(rs.getString("sdt"));
                nv.setTrangThai(rs.getString("trangThai"));
                nv.setChucVu(rs.getString("chucVu"));
                return true;
            }
        } catch (Exception ex) {
            System.out.println("Loi checkDangNhap: " + ex.getMessage());
            return false;
        }
    }
}
