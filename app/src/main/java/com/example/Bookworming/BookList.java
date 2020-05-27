package com.example.Bookworming;

import java.util.List;
import java.util.Scanner;

public class BookList {
	private int id;
	private String name;
	private String type;
	private List<Book> bookList;
	
	public BookList(String name, String type, List<Book> bookList) {
		this.setId();
		this.name = name;
		this.type = type;
		this.bookList = bookList;
	}

	public int getId() {
		return id;
	}

	public void setId() {
		this.id = (int) Math.floor( Math.random() * 10000);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Book> getBookList() {
		return bookList;
	}
	
	// change List's name and if is possible the type
	public void changeBookOfList() {		// chooseChange
		Scanner form = new Scanner(System.in);
		System.out.println("Rename BookList");
		
		String listName = form.nextLine();
		setName(listName);
		
		System.out.println("Reset BookList's type");
		String listType = form.nextLine();
		
		boolean isChanged;
		for (Book b : this.bookList) {
			if (b.getTypes() == listType) {
				isChanged = true;
				setType(listType);
			}
		}
		
		if (isChanged) {
			System.out.println("Successfully changed");
		} else {
			System.out.println("Type can't be changed, "
					+ "because one or more Book do not belong in this category");			
		}
	}
	
	public void addBookToList(Book book) {
		this.bookList.add(book);
	}
	
	public void deleteBookFromList(Book book) {
		this.bookList.remove(book);
	}
	
	public boolean checkListAvailability() {
		for (Book b : this.bookList) {
			if (!b.checkAvailability(b.get(id))) {
				return false;
			}
		}
		
		return true;
	}
	
}
