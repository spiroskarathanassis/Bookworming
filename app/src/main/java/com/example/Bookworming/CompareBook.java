package com.example.Bookworming;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CompareBook{

    int user_id;
    int book_id;
    int book2_id;

    public CompareBook(int uid, int id1, int id2){//todo καποια σημεια δεν ειναι κατανοητα

        user_id = uid;
        book_id = id1;
        book2_id = id2;
    }

    public void saveOnDatabase(){

        File file = new File("CompareBook.csv");
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);

            // adding header to csv
            String[] header = {"user_id", "book_id"};
            writer.writeNext(header);

            // add data to csv
            String[] data1 = {String.valueOf(user_id), String.valueOf(book_id)};
            writer.writeNext(data1);

            String[] data2 = {String.valueOf(user_id), String.valueOf(book2_id)};
            writer.writeNext(data1);

            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getCompareBooks(){

        //save to db the 1 book
    }

    public void displayUnavailability(){

        System.out.println("failure message");
    }

}
