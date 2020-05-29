package com.example.Bookworming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library{

    private int id;
    private String name;

    private  List<Book> books;

    public Library(int i_d, String na, List<Book> books){
        id = i_d;
        name = na;
        this.books = books;

    }

    public boolean checkavailability(int book_id){
        boolean availability = false;
        for (int i=0; i<books.size(); i++) {
            if ((books.get(i)).id == book_id) {
                availability = books.get(i).checkAvailability();
            }
        }
        return availability;
    }

    public void addBook(Book book_to_add){

        books.add(book_to_add);
    }

    public void changeBook(int id, Book book){

        for (int i=0; i<books.size(); i++) {
            if ((books.get(i)).id == id) {

                books.set(i, book);
                /*(books.get(i)).title = ttl;
                (books.get(i)).author = aut;
                (books.get(i)).isbn = is;
                (books.get(i)).type =  ty;
                (books.get(i)).year = ye;*/
            }
        }
    }

    public void deleteBook(int id){

        for (int i=0; i<books.size(); i++) {
            Book randbook = (Book) books.get(i);

            if (randbook.id == id) {

                books.remove(i);
            }
        }
    }


}
