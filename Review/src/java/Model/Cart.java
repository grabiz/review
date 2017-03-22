/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author NGUYEN
 */
public class Cart implements Serializable{
    private ArrayList<LineItem>  items;

    public Cart() {
       items = new ArrayList<LineItem>();
    }

    public ArrayList<LineItem> getItems() {
        return items;
    }
    
    public int getCount()
    {
        return items.size();
    }
    public void addItem(LineItem item)
    {
        Product cartItem =item.getProduct();
        int quantity =item.getQuantity();
        for(LineItem lineItem: items)
        {
            if(lineItem.getProduct().getCode().equals(cartItem.getCode()))
           {
               lineItem.setQuantity(quantity);
               return;
           }
        }
        items.add(item);
//        String code = item.getProduct().getCode();
//        int quantity = item.getQuantity();
//        for (LineItem cartItem : items) {
//            if (cartItem.getProduct().getCode().equals(code)) {
//                cartItem.setQuantity(quantity);
//                return;
//            }
//        }
//        items.add(item);
    }
    public void removeItem(LineItem item)
    {
        for(int i=0; i< this.getCount();i++)
        {
            if(items.get(i).getProduct().getCode().equals(item.getProduct().getCode()))
            {
                items.remove(i);
           }
        }
       
    
    
    }
    
    
}
