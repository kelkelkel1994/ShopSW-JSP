/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connect.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Slide;

/**
 *
 * @author SONPC
 */
public class SlideDAO {
    public Slide getThongtin() throws SQLException {
        Connection connection = DBConnect.getConnection();
        String sql = "SELECT * FROM slide WHERE ID_Slide = 1";
        PreparedStatement ps = connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
         Slide customer = new Slide();
        while (rs.next()) {
           customer.setSlideID(rs.getLong("ID_Slide"));
            customer.setImage(rs.getString("Image"));
            customer.setDisplayorder(rs.getLong("DisplayOrder"));
            customer.setLink(rs.getString("Link"));
            customer.setDescription(rs.getString("Description"));
            if (Integer.parseInt(rs.getString("Status")) == 0) {
                customer.setSt(false);
            } else {
                customer.setSt(true);
            }
        }
        connection.close();
        return customer;
    }
    public boolean updateSlide(Slide c) throws SQLException {
        Connection connection = DBConnect.getConnection();
        String sql = "UPDATE slide SET Image = ?,DisplayOrder=?,Link=?,Description=?,Status=? WHERE ID_Slide = ?";
     try {
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setString(1, c.getImage());
            ps.setLong(2, c.getDisplayorder());
            ps.setString(3,c.getLink());
            ps.setString(4, c.getDescription());
            ps.setBoolean(5, c.getSt());
            ps.setLong(6,c.getSlideID());
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            connection.close();
        }
        return false;
    }
     public static void main(String[] args) throws SQLException {
        SlideDAO dao = new SlideDAO();
            Slide ds=dao.getThongtin();
             System.out.println(ds.getSt());
        }
    
}
