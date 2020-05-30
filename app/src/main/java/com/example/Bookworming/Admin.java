package com.example.Bookworming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin {

    private String name;
    private String email;
    private String password;
    private int id;

    public Admin(String name, String email, String pass, int adminId) {
        
        this.name = name;
        this.email = email;
        this.password = pass;
        this.id = adminId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public void addBookList() {
        Scanner listInput = new Scanner(System.in);

        System.out.println("Set name for this book list");
        String listName = listInput.nextLine();
        System.out.println("Set type for this book list");
        String type = listInput.nextLine();

        if ( !((listName && type) instanceof String) || ((listName && type) == null)) {
            System.out.println("Retry again. Your input didn't match the requirements values");
            addBookList();
        }

        System.out.println("Write 3 books names for this book list");
        Book book1 = new Book( /*listInput.nextLine()*/ );
        Book book2 = new Book( /*listInput.nextLine()*/ );
        Book book3 = new Book( /*listInput.nextLine()*/ );
        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);

        new BookList(listName, type, books);
        listInput.close();
    }

    public void deleteBookList(String name) {
        if (!searchBookList(name)) {
            System.out.println("This list does not exist");
        } else {
            // Delete from Database
            System.out.println("Deleted successfully");
        }
    }

    public boolean searchBookList(String name) {
        // query to BookList database
        return true;
    }
}
