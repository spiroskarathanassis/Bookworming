package java.com.example.Bookworming;

public class MainActivity {

    public static void main() {
        System.out.println();

        Admin admin1 = new Admin("Mike", "mike@gmail.com", "1234", 1);

        User user1 = new User("Adreas", "adreas@gmail.com", "4321");
        User user2 = new User("Dimitris", "dim@gmail.com", "4321");

        Book book1 = new Book("Java 6", "Rogers", "Giourdas",1056789010, new Arraylist<String>("programming",
                "university"), 2013);
        Book book2 = new Book("C++", "Yao", "Kareklas", 1056789011, new Arraylist<String>("programming",
                "university"), 2013);
        Book book3 = new Book("Php", "David" ,"Tsiordas", 1056789032, new Arraylist<String>("programming",
                "web"), 2013);


        List<Book> library1_books = Arrays.asList(book1, book3);
        Library library1 = new Library(1, "University Library", library1_books);


        List<Book> library2_books = Arrays.asList(book2, book3);
        Library library2 = new Library(2, "Patras Library", library2_books);

        admin1.addBookList();

        user1.setScoreOfBook(book1, 2);
        user2.clickOnCompareButton(4);
        user2.bookCheck(1);
        List<Book> purshased_books = Arrays.asList(book1, book3);
        Borrowedbooks borrowedbooks = new Borrowedbooks(2, 1);  //user2, book1
        Shoppingbasket basket1 = new Shoppingbasket(1, 1, purshased_books);

        basket1.getPurshasedBooks();
        if(basket1.checkForBooks()) {
            basket1.addListToBasket(purshased_books);
            basket1.applyDiscount(user1);
        }

        MyBooks mybooks = new MyBooks(2, 3, 1, 3);  //user2, book3, book_list1, score 3

        Coupons coupon1 = new Coupons(11, 0.11, "discount11");
        if(coupon1.checkPoints(user2)){

            int discount = coupon1.applydiscount(40, 11);
            System.out.println("You have 11% discount!!");
        }

        }
    }
}
