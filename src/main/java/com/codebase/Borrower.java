package com.codebase;

import java.util.ArrayList;

public class Borrower {

    private String name;
    private ArrayList<Book> borrowedBooks;

    public Borrower(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }
    public int borrowAmount(){
        return this.borrowedBooks.size();
    }
    public void addBook(Book book){
        this.borrowedBooks.add(book);
    }
}
