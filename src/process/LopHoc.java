/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package process;

/**
 *
 * @author PHAN ANH TUAN
 */
public class LopHoc {
    private String malop;
    private String tenlop;
    private String giaovien;

    public LopHoc() {
    }

    public String getMalop() {
        return malop;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }

    public String getTenlop() {
        return tenlop;
    }

    public void setTenlop(String tenlop) {
        this.tenlop = tenlop;
    }

    public String getGiaovien() {
        return giaovien;
    }

    public void setGiaovien(String giaovien) {
        this.giaovien = giaovien;
    }

    @Override
    public String toString() {
        return "LopHoc{" + "malop=" + malop + ", tenlop=" + tenlop + ", giaovien=" + giaovien + '}';
    }
    
    
}
