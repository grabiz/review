/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Cart;
import Model.LineItem;
import Model.Product;
import Util.ProductIO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author NGUYEN
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String action =req.getParameter("action");
        String url="";
       
        if (action==null)
        {
         action="cart";
        }
       
        
        if(action.equals("cart"))
        {
            HttpSession session = req.getSession();
            Cart cart = (Cart) session.getAttribute("cart");
            if(cart==null)
            {
              cart = new Cart();
            }
            
            
            String code = req.getParameter("productCode");
            String quantity = req.getParameter("quantity");
            int qtt;
            try {
                qtt = Integer.parseInt(quantity);
             } catch (NumberFormatException nfe) {
                qtt = 1;
             }
             Product product = ProductIO.getProduct(code,"/WEB-INF/product.txt");
             LineItem item = new LineItem();
             item.setProduct(product);
             item.setQuantity(qtt);
            if (qtt >0)
            {
               cart.addItem(item);
            }
            else if(qtt==0){
               cart.removeItem(item);
            }
            session.setAttribute("cart",cart);
            url="/cart.jsp";
        }
        else if(action.equals("shop"))
        {
           url="/index.jsp";
        }
        else if(action.equals("checkout"))
        {
           url="/checkout.jsp";
        }
//        if (action.equals("cart")) {
//            String productCode = req.getParameter("productCode");
//            String quantityString = req.getParameter("quantity");
//
//            HttpSession session = req.getSession();
//            Cart cart = (Cart) session.getAttribute("cart");
//            if (cart == null) {
//                cart = new Cart();
//            }
//
//            //if the user enters a negative or invalid quantity,
//            //the quantity is automatically reset to 1.
//            int quantity;
//            try {
//                quantity = Integer.parseInt(quantityString);
//                if (quantity < 0) {
//                    quantity = 1;
//                }
//            } catch (NumberFormatException nfe) {
//                quantity = 1;
//            }
//
//            String path = getServletContext().getRealPath("/WEB-INF/products.txt");
//            Product product = ProductIO.getProduct(productCode, path);
//
//            LineItem lineItem = new LineItem();
//            lineItem.setProduct(product);
//            lineItem.setQuantity(quantity);
//            if (quantity > 0) {
//                cart.addItem(lineItem);
//            } else if (quantity == 0) {
//                cart.removeItem(lineItem);
//            }
//
//            session.setAttribute("cart", cart);
//            url = "/cart.jsp";
//        }
//        else if(action.equals("shop"))
//        {
//           url="/index.jsp";
//        }
//        else if(action.equals("checkout"))
//        {
//           url="/checkout.jsp";
//        }
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    
    }
    
}
