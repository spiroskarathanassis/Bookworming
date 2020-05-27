package com.example.Bookworming;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AvailabilityList{

    int user_id;
    int book_id;
    //int availability;

    public AvailabilityList(int uid, int bid){

        user_id = uid;
        book_id = bid;
    }

    public void  add_availabilitylist(){

        File file = new File("AvailabilityList.csv");
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);

            // adding header to csv
            String[] header = {"user_id", "book_id"};
            writer.writeNext(header);

            // add data to csv
            String[] data1 = {"1", "10"};
            writer.writeNext(data1);
            String[] data2 = {"1", "10"};;
            writer.writeNext(data2);

            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
