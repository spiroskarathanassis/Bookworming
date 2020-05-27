package com.example.Bookworming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library{

    int id;
    String name;


    List<Book> books = new ArrayList<Book>();
    Book book4 = new Book("book4", "author4", 2125, "sometype4", 2009);

    public Library(int i_d, String na){
        id = i_d;
        name = na;

        books.add(book4);
    }



    public void addBook(Book book_to_add){

        books.add(book_to_add);
    }

    public void changeBook(String ttl, String aut, int is, List <String> ty, int ye){

        for (int i=0; i<books.size(); i++) {
            if ((books.get(i)).id == id) {

                (books.get(i)).title = ttl;
                (books.get(i)).author = aut;
                (books.get(i)).isbn = is;
                (books.get(i)).type =  ty;
                (books.get(i)).year = ye;
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
