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
import java.util.ArrayList;
import model.Product;

/**
 *
 * @author SONPC
 */
public class ProductDAO {

    // get danh sách sản phẩm
    public ArrayList<Product> getListProduct() throws SQLException {
        Connection connection = DBConnect.getConnection();
        String sql = "SELECT * FROM product";
        PreparedStatement ps = connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<Product> list = new ArrayList<>();
        while (rs.next()) {
            Product product = new Product();
            product.setProductID(rs.getLong("ID_Product"));
            product.setCategoryID(rs.getLong("ID_Category"));
            product.setProductName(rs.getString("Name"));
            product.setProductPrite(rs.getLong("Price"));
            product.setProductPromotionPrice(rs.getLong("PromotionPrice"));
            product.setProductShortDescription(rs.getString("ShortDescription"));
            product.setProductDescription(rs.getString("Description"));
            product.setProductImagesFeature(rs.getString("ImagesFeature"));
            product.setProductSubImages1(rs.getString("Subimage1"));
            product.setProductSubImages2(rs.getString("Subimage2"));
            if (Integer.parseInt(rs.getString("StatusPromotion")) == 0) {
                product.setProductStPromotion(false);
            } else {
                product.setProductStPromotion(true);
            }
            if (Integer.parseInt(rs.getString("StatusHot")) == 0) {
                product.setProductStHot(false);
            } else {
                product.setProductStHot(true);
            }
            if (Integer.parseInt(rs.getString("StatusTop")) == 0) {
                product.setProductStTop(false);
            } else {
                product.setProductStTop(true);
            }
            if (Integer.parseInt(rs.getString("StatusNew")) == 0) {
                product.setProductStNew(false);
            } else {
                product.setProductStNew(true);
            }
             if (Integer.parseInt(rs.getString("StatusTopWeek")) == 0) {
                product.setProductStTopWeek(false);
            } else {
                product.setProductStTopWeek(true);
            }
            list.add(product);

        }
        return list;
    }
    
     public static void main(String[] args) throws SQLException {
        ProductDAO dao = new ProductDAO();
        //dao.insertCategory(new Category(new Date().getTime(), "ahih"));
        for (Product ds : dao.getListProduct()) {
            System.out.println(ds.getProductID() + " - " + ds.getProductName()+" - "+ds.getProductPrite()+" - "+ds.getProductDescription()+" - "+ds.getProductImagesFeature()
            +" - "+String.valueOf(ds.getProductSt())+" - "+String.valueOf(ds.getProductStTop()));
            //System.out.println(dao.deleteCategory(4));
            //Customer ds1 = dao.getCustomer(1);
             //System.out.println(ds1.getCustomerID() + " - " + ds1.getCustomerName()+" - "+ds1.getCustomerUser());
            //System.out.println(ds1.getCategoryID() + " - " + ds1.getCategoryName() + " - " + String.valueOf(ds1.getCategorySt()));
        }
    }
}
