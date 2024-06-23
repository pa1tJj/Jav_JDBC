/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;
import java.sql.*;
/**
 *
 * @author PHAN ANH TUAN
 */
public class test {
    public static void main(String[] args) throws SQLException{
        Connection con = KetNoi.KetNoiCSDL();
        if(con == null) {
            System.out.println("that bai");
        }else {
            System.out.println("thanh cong");
        }
    }
}
