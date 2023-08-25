/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

import java.sql.*;
/**
 *
 * @author Home
 */
public class Conn {
    Connection c;
    Statement s;
    Conn(){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        c=DriverManager.getConnection("jdbc:mysql://localhost:4306/hotel_ms","root","");
        s=c.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
