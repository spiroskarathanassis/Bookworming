package com.example.bookworms;

//package com.mkyong.android;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.app.AppCompatActivity;
import java.io.File;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    Book book1 = new Book("book", "author", 2125);



    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arxiki_selida);

        addListenerOnButton();
        //printMessageOlok();
        //printMessageError()
    }

    //methods...
    //button listener
    public void addListenerOnButton() {

        imageButton = (ImageButton)findViewById(R.id.newbutton);

        imageButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Toast.makeText(MainActivity.this,
                        book1.title, Toast.LENGTH_SHORT).show();

            }

        });
    }

    //ektiposi minimatos oloklirosis doreas
    public void printMessageOlok() {

        imageButton = (ImageButton)findViewById(R.id.newbutton);

        imageButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Toast.makeText(MainActivity.this,
                        "Η διαδικασία της δωρεάς ολοκληρώθηκε με επιτχία!",
                        Toast.LENGTH_SHORT).show();

            }

        });
    }

    //ektiposi minimatos lathous
    public void printMessageError() {

        imageButton = (ImageButton)findViewById(R.id.newbutton);

        imageButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Toast.makeText(MainActivity.this,
                        "Τα στοιχεία σας είναι λάθος.", Toast.LENGTH_SHORT).show();

            }

        });
    }

}



class Book{

    String title;
    String author;
    int isbn;

    public Book(String ttl, String aut, int is){

        title = ttl;
        author = aut;
        isbn = is;
        }
    //elegxos stoixeiwn pou edwse o xristis
    //public void checkBookData(){

    //}


}


//class Author{

    //public Author(){

   // }
//}

//class Publisher{

//public Publisher(){

// }
//}


class User{
    String name;
    String email;
    String password;
    int points;
    int id;

    public User(String na, String em, String pass){
        name = na;
        email = em;
        password = pass;
    }

    public boolean bookCheck(){

        if(true) {

            checkDate();
            return true;//findBook()
        }
        else {

            return false;//notFindBook()
        }
    }

    public boolean checkDate(){

        if(true) {

            return true;//findBookNotXreosi()
        }
        else {

            return false;//FindBookXreosi()
        }

    }

    public void addPoints(int newpoints){

        points = points + newpoints;
    }
}



class Library{
    int id;
    String name;

    public Library(int i_d, String na){
        id = i_d;
        name = na;

    }
}


class Coupons{
    int id;
    float discount;
    String name;

    public Coupons(int i_d, float disc, String na){
        id = i_d;
        discount = disc;
        name = na;
    }
}


class BookWorming{
    int id;
    String type;
    String title;

    public BookWorming(int i_d, String ty, String tit){
        id = i_d;
        type = ty;
        title = tit;

    }
}
