package com.example.Bookworming;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@RequiresApi(api = Build.VERSION_CODES.O)
public class BorrowedBooks {

    int user_id;
    int book_id;
    LocalDate date;

    //public BorrowedBooks(int uid, int bid){

        //user_id = uid;
        //book_id = bid;
    //}

    public long dayscalculation(){

        long days = ChronoUnit.DAYS.between(date, LocalDate.now());
        return days;
    }

}
