package com.example.Bookworming;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MyBooks {

    int user_id;
    int book_id;
    int list_id;
    int score;
    //List<Book> my_books = new ArrayList<Book>();

    public MyBooks(int uid, int bid, int lid, int score){

        user_id = uid;
        book_id = bid;
        list_id = lid;
        score = 0;
    }



    public  void reviewBook(String review){

        this.review = review;
    }

    public void setScoreOfBook(int score){

        this.score = score;
    }

    public void saveReview(){

        // insert into database
        System.out.println("Successful saved");
    }

    public void displayFailReviewMessage(){
        System.out.println("Fail review message.");
    }

}//end of class
