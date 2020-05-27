## Bookworming

This is a **Library Mobile System** that 
**User** can
  - search books
  - be informed about the availability of books around his/her city's Libraries
  - reserve, buy or borrow books
  - review his/her books
  - take knowledge quiz about differents categories of books
  - choose to suggest him/her the best book by top rated reviews in this category.
  
Also we have also implemented an Interface for **Admin** where can
 - manage books (add/ edit/ delete)
 - manage Book Lists (=same category books)
 
 

 ### --> UI

* Some of UIs that implemented on Android Studio is here:

![Image of Login_Page](./MockUps/login_page.PNG)
![Image of Login_Page](./MockUps/user_main_page.PNG)
![Image of Login_Page](./MockUps/user_bookwormingAnaz_page.PNG)
![Image of Login_Page](./MockUps/admin_main_page.PNG)
![Image of Login_Page](./MockUps/admin_activitySettings_page.PNG)
![Image of Login_Page](./MockUps/admin_addBook_page.PNG)
![Image of Login_Page](./MockUps/admin_editBook_Page.PNG)

* You can check our prototype virtual application [here](https://www.figma.com/proto/BLNJzArXshZJ9vYTSCEAxp/BookWorms?node-id=192%3A2&scaling=scale-down)

### --> UX

Class Diagram:

Class Name | Description
---------- | ----------
Admin | Entity that manage books, set quiz & create book lists
User | Entity that uses the app
Library | Entity that requires books
Book | Object that requires details of Book (id, name, author, publisher etc)
MyBooks | Entity that requires user's borrowed/purchased  books
BorrowedBooks | Entity that requires user's borrowed books
CompareBook | 
BookList | Entity that requires available book lists for BookWorming
AvailabilityList | Entity that requires books where user looks for availability 
Reviews | Entity that requires reactions of "stars" (score of book)
Author | Entity that required on Book's characteristics
Publisher | Entity that required on Book's characteristics
ShoppingBasket | Entity that includes books before been purchasing by User
SetQuiz | Entity that set quiz game
Quiz | Entity that user reacts with
Question | Entity that requires quiz questions
Answer | Enitty that requires quiz answers


Class path: [src/main/Bookworming](https://github.com/spiroskarathanassis/Bookworming/tree/master/app/src/main/java/com/example/Bookworming)



#### Team
Names                 | Email
--------------------- | ---------------------
Spiros Karathanassis  | karathanassis13@gmail.com
Giorgos Tzelepis      | geo335127@gmail.com
Stella Markopoulou    | stmarkop@gmail.com
Niki Georgiou         | georgioynikh@gmail.com
Dimitra Poulaki       | dimitrampoulaki@gmail.com
