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
public class KetNoi {
    public static Connection KetNoiCSDL() throws SQLException{
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlsinhvien", "root", "");
        return con;
    }
}
