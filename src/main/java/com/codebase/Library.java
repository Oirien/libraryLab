package com.codebase;

import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    private int shelfSpace;
    private ArrayList<Book> bookCollection;
    private HashMap<String, Integer> genres;

    public Library(int shelfSpace) {
        this.shelfSpace = shelfSpace;
        this.bookCollection = new ArrayList<>();
        this.genres = new HashMap<>();
    }

    public boolean hasCapacity(){
        return shelfSpace > bookCollection.size();
    }
    public int collectionSize(){
        return bookCollection.size();
    }
    public void addBookToCollection(Book book){
        if (hasCapacity()){
            bookCollection.add(book);
            genreAdd(book);
        }
    }
    public boolean bookInStock(Book book){
        if(bookCollection.contains(book)){
            return true;
        } else {
            return false;
        }
    }
    public void lendBookToBorrower(Book book, Borrower borrower){
        bookCollection.remove(book);
        borrower.addBook(book);
    }
    public void genreAdd(Book book){
        String genre = book.getGenre();
        if(genres.containsKey(genre)){
            int genreCount = genres.get(genre);
            genreCount++;
            genres.put(genre, genreCount);
        } else {
            genres.put(genre, 1);
        }
    }

    public int genreCount(String genre){
        return this.genres.get(genre);
    }

}
