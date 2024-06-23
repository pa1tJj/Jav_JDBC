/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package process;

import database.KetNoi;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PHAN ANH TUAN
 */
public class LopHocPro {

    public List<LopHoc> listLH() {
        List<LopHoc> list = new ArrayList<>();
        Connection con = null;
        try {
            con = KetNoi.KetNoiCSDL();
            PreparedStatement ps;
            ResultSet rs;
            ps = con.prepareStatement("select * from lophoc");
            rs = ps.executeQuery();
            while (rs.next()) {
                LopHoc l = new LopHoc();
                l.setMalop(rs.getString("malop"));
                l.setTenlop(rs.getString("tenlop"));
                l.setGiaovien(rs.getString("giaoviencn"));
                list.add(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LopHocPro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public boolean kiemTraMaTrung(String id){
        for (LopHoc object : listLH()) {
            if(object.getMalop().equals(id)){
                return true;
            }
        }
        return false;
    }
    
    public boolean them(LopHoc l) {
        Connection con = null;
        try {
            con = KetNoi.KetNoiCSDL();
            String sql = "insert into lophoc values(?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, l.getMalop());
            ps.setString(2, l.getTenlop());
            ps.setString(3, l.getGiaovien());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            if(kiemTraMaTrung(l.getMalop())){
                return false;
            }
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(LopHocPro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean sua(LopHoc l) {
        Connection con = null;
        try {
            con = KetNoi.KetNoiCSDL();
            String sql = "update lophoc set tenlop = ?, giaoviencn = ? where malop = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, l.getTenlop());
            ps.setString(2, l.getGiaovien());
            ps.setString(3, l.getMalop());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(LopHocPro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean xoa(String id) {
        Connection con = null;
        LopHoc l = new LopHoc();
        try {
            con = KetNoi.KetNoiCSDL();
            String sql = "delete from lophoc where malop = '"+id+"' and (select Count(*) from sinhvien where malop) = 0";
            PreparedStatement ps = con.prepareStatement(sql);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            
        }
        return false;
    }
    

    public void luu() {
        
    }

}
