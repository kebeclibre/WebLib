/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weblib.central.beans;

import be.bt.model.Book;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rome10
 */
public class ShopCart {
    private List<Book> bookList = new ArrayList<Book>();
    private int totalPrice;
    
    public void addBook(Book b) {
        bookList.add(b);
        incrementPrice(b);
    }
    
    public void removeBook(Book b) {
        decrementPrice(b);
        bookList.remove(b);
    }
    
    public void clearCart() {
        bookList.clear();
        totalPrice = 0;
    }
    
    public int getTotalPrice() {
        int total = 0;
        for (Book b : bookList) {
            total += b.getPrice();
        }
        return total;
    }
    
    public void incrementPrice(Book b) {
        totalPrice += b.getPrice();
    }
    
    public void decrementPrice(Book b) {
        totalPrice -= b.getPrice();
    }
    
    public List<Book> getList() {
        return bookList;
    }
    
    public boolean inCart(Book b) {
        return bookList.contains(b);
        
    }
}
