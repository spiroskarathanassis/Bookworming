package com.example.Bookworming;

import android.os.Build;
import androidx.annotation.RequiresApi;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Book {
    int bookid =0;
    int id;
    String title;
    double price;
    String description;
    Author author;
    Publisher publisher;
    int isbn;
    List <String> type = new ArrayList<String>();
    int year;
    int pages;
    int review_id;
    int num_of_copies_for_buy;
    int num_of_copies_for_lending;

    //List<AvailabilityList> availabilitylist = new ArrayList<AvailabilityList>();

    public Book() {}

    public Book(String ttl, String aut, String pname, int is, List <String> ty, int ye){
        this.id = bookid++;
        this.title = ttl;
        this.author = new Author(aut, 'm');
        this.publisher = new Publisher(pname, pname + "@gmail.com");
        this.isbn = is;
        this.type = ty;
        this.year = ye;
    }

    public boolean checkBookData(){

        if(String.valueOf(year).length() != 4) {                  // year
            throw new IllegalArgumentException("Error...");
            return false;
        }
        if(String.valueOf(title).length() < 2 || title == null) {// title
            throw new IllegalArgumentException("Error...");
            return false;
        }
        if(author == null) {                                      // author
            throw new IllegalArgumentException("Error...");
            return false;
        }
        if(type.isEmpty()) {                                      // type
            throw new IllegalArgumentException("Error...");
            return false;
        }
        if(String.valueOf(isbn).length() < 8 ) {                 // isbn
            throw new IllegalArgumentException("Error...");
            return false;
        }

        return true;
    }

    public int getId(){
        return  id;
    }

    public List<String> getTypes(){
        return type;
    }

    public double getPrice(){
        return price;
    }

    List<BookList> book_list = new ArrayList<BookList>();

    @RequiresApi(api = Build.VERSION_CODES.O)
    public List<BookList> getBook(String type) throws IOException {//todo θελει αλλαγη
        List<BookList> returnList = new ArrayList<BookList>();

        for(int i=0; i<book_list.size(); i++){
            if(book_list.get(i).type == type) return List.add(book_list.get(i));//book_list.get(i).type == type
        }

        return returnList;
    }

    public boolean checkAvailability() {
        boolean availability_status = false;//book_not_available()

        //for (int i=0; i<books.size(); i++) {
        // Book randbook = (Book) books.get(i);

        if (num_of_copies_for_lending > 0) { //randbook.availability == 1
            availability_status = true;//book_available()
        }
        //}
        return availability_status;
    }

    public int stock() {
        return num_of_copies_for_buy;
    }

    public String checkbookstatus() {
        int status = 0;
        String message;

        if(num_of_copies_for_lending > 0 & num_of_copies_for_buy < 0)
            message="daneismos";
        else if(num_of_copies_for_lending < 0 & num_of_copies_for_buy > 0)
            message="agora";
        else if(num_of_copies_for_lending > 0 & num_of_copies_for_buy > 0)
            message="daneismos kai agora";
        else
            message="oxi diathesimo";

        return message;
    }


}




