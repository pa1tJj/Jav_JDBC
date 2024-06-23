/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package process;

import database.KetNoi;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author PHAN ANH TUAN
 */
public class SinhVienPro {
    
    public List<SinhVien> layDanhSachSinhVien(){
        List<SinhVien> list = new ArrayList<>();
        Connection con = null;
        try {
            con = KetNoi.KetNoiCSDL();
            String sql = "select *from sinhvien";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                SinhVien sv= new SinhVien();
                sv.setMasv(rs.getString("masv"));
                sv.setTensv(rs.getString("hoten"));
                sv.setEmail(rs.getString("email"));
                sv.setDiachi(rs.getString("diachi"));
                list.add(sv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienPro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public boolean kiemTraMaTrung(String maTrung){
        for (SinhVien x : layDanhSachSinhVien()) {
            if(x.getMasv().equals(maTrung)){
                return true;
            }
        }
        return false;
    }
    public boolean them(SinhVien sv){
        Connection con = null;
        try {
            con = KetNoi.KetNoiCSDL();
            String sql = "insert into sinhvien values(?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sv.getMasv());
            ps.setString(2, sv.getTensv());
            ps.setString(3, sv.getEmail());
            ps.setString(4, sv.getDiachi());
            ps.setString(5, sv.getMalop());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            if(kiemTraMaTrung(sv.getMasv())){
                return false;
            }
        }
        return false;
    }
    
    public boolean sua(SinhVien sv){
        Connection con = null;
        try {
            con = KetNoi.KetNoiCSDL();
            String sql = "update sinhvien set hoten = ?, email = ?, diachi = ?, malop = ? where masv = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sv.getTensv());
            ps.setString(2, sv.getEmail());
            ps.setString(3, sv.getDiachi());
            ps.setString(4, sv.getMalop());
            ps.setString(5, sv.getMasv());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienPro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean xoa(String maXoa){
        Connection con = null;
        try {
            con = KetNoi.KetNoiCSDL();
            String sql = "delete from sinhvien where masv = '"+maXoa+"'";
            PreparedStatement ps = con.prepareStatement(sql);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienPro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
