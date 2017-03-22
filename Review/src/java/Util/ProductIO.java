/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Model.Product;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NGUYEN
 */
public class ProductIO {
    public static Product getProduct(String code, String path)
    {
        try {
            File file = new File(path);
            BufferedReader in = new BufferedReader(
                                new FileReader(file));
            
            String line;
                while((line=in.readLine())!= null)
                {
                    String productPart[] = line.split(",");
                    if(productPart[0].equals(code))
                    {
                        Product p = new Product();
                        p.setCode(productPart[0]);
                        p.setDescription(productPart[1]);
                        p.setPrice(Double.parseDouble(productPart[2]));
                        return p;
                    }
                }
            return null;
            } catch (IOException ex) {
                Logger.getLogger(ProductIO.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
     
        }
       
    public static ArrayList<Product> getProductList(String path)
    {
        ArrayList<Product> productList = new ArrayList<Product>();;
        try {
            BufferedReader buff = new BufferedReader(new FileReader(path));
            try {
                while(buff.readLine()!=null)
                {
                    String productPart[] = buff.readLine().split("|");
                    Product product =new Product(productPart[0],productPart[1],Double.parseDouble(productPart[2]));
                    productList.add(product);
                }
                return productList;
            } catch (IOException ex) {
                Logger.getLogger(ProductIO.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProductIO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
}
