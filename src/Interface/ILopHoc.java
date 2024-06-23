/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import java.util.List;
import process.LopHoc;

/**
 *
 * @author PHAN ANH TUAN
 */
public interface ILopHoc {
    public List<LopHoc> listLH();
    public boolean them(LopHoc x);
    public void luu();
    public boolean sua();
    public boolean xoa(String x);
}
