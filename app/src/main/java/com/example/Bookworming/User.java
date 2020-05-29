package com.example.Bookworming;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//public @RequiresApi(api = Build.VERSION_CODES.O)
@RequiresApi(api = Build.VERSION_CODES.O)
public class User{

    String name;
    String email;
    String password;
    int points;
    private int id;


    //MyBooks list
    List<MyBooks> my_books = new ArrayList<MyBooks>();//todo read from file

    //CompareBook list
    List<CompareBook> compare_books = new ArrayList<CompareBook>();//todo read from

    //BorrowedBooks list
    List<BorrowedBooks> b_books = new ArrayList<BorrowedBooks>();//todo read from file
    //create
    BorrowedBooks book2 = new BorrowedBooks();
    BorrowedBooks book3 = new BorrowedBooks();

    @RequiresApi(api = Build.VERSION_CODES.O)
    public User(String na, String em, String pass) throws IOException {

        name = na;
        email = em;
        password = pass;

        //List<BorrowedBooks> books = new ArrayList<BorrowedBooks>();
        //book2.book_id = 2;
        //book3.book_id = 3;
        //books.add(book2);
        //books.add(book3);
        //bookCheck();

        Log.d("myTag", "User created");
    }

    public void clickOnCompareBook(){//todo -> or clickOnCompareButton

    }

    public int getPoints(){

        return points;
    }

    public void setScoreOfBook(Book b){
        // input score = 2 stars
        int score = 2;
        Reviews review = new Reviews(Math.random() * 1000);

        review.addReview(score);
    }

    //CompareBook list
    List<CompareBook> compare_books = new ArrayList<CompareBook>();//todo read from file
    public void clickOnCompareButton(int compId) {
        compBook1 = new CompareBook(this.id, compId);

        if (compare_books.size() == 0) {
            compBook2 = continueWithAnotherChoice();
        } else {
            compBook2 = chooseBookToCompareWith();
        }

        compareBooks(compBook1, compBook2);
    }

    public CompareBook continueWithAnotherChoice() {
        int compId2 = 100;      // random

        return new CompareBook(this.id, compId2);
    }

    public CompareBook chooseBookToCompareWith(int compId) {
        List<CompareBook> compBooks = getCompareBooks();

        for (CompareBook cb : compBooks) {
            if (cb.checkUnavailability() && (cb.book_id == compId)) {
                compBooks.remove(cb);
                cb.displayUnavailability();
            }
        }

        return compBooks.get(1);
    }

    public void compareBooks(CompareBook compB1, CompareBook compB2) {}


    public List<CompareBook> getCompareBooks() {
        return compare_books;
    }

    public void setName(String new_name){

        name = new_name;
    }

    public String getName(){

        return name;
    }

    public String getEmail(){

        return email;
    }

    public String getPassword(){

        return password;
    }

    public void setPassword(String new_password){

        password = new_password;

    }
    public void addBookData(Book b){

       if(b.checkBookData()){
            dataOk();
       }
       else dataNotOk();
    }

    public void dataOk(){
        System.out.println("Completion message");//todo
        addPoints(5);
    }

    public void dataNotOk(){
        System.out.println("Error");
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public boolean bookCheck(int id) throws IOException {

        Log.d("booker2", "bookCheck message");

        //CSVReader reader = new CSVReader(new FileReader("raw/book.csv"));
        //List books = reader.readAll();
        //int size = books.size();

        boolean message = false;//notFindBook()

        //Log.d("MainActivity", String.valueOf(message));
        //print(a);
        for (int i=0; i<b_books.size(); i++) {
            BorrowedBooks randbook = (BorrowedBooks) b_books.get(i);
            Log.d("booker", String.valueOf(randbook.book_id)); //String.valueOf(randbook.book_id)
            if ( randbook.book_id == id) {
                //return (int) books.get(0);//findBook()
                message = true;//findBook()

                checkDate(randbook.book_id);
            }
        }
        return message;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public boolean checkDate(int id) throws IOException {

        //CSVReader reader = new CSVReader(new FileReader("Book.csv"));
        //List books = reader.readAll();
        //int size = books.size();

        boolean message = false;//FindBookNotXreosi()

        for (int i=0; i<b_books.size(); i++) {
            BorrowedBooks randbook = (BorrowedBooks) b_books.get(i);
            if (randbook.book_id == id) {
                //compare book date with current

                if (randbook.dayscalculation() > 20)

                    //return (int) books.get(0);//findBook()
                    message = true;//findBookXreosi()
            }
        }
        return message;

    }

    public void addPoints(int newpoints){

        points += newpoints;
    }
}
