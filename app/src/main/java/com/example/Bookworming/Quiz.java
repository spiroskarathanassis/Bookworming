import java.util.Scanner;

public class Quiz {
    private String theme;
    private Integer result;

    public Quiz(String theme) {
        this.theme = theme;
        this.result = 0;
    }

    public String getTheme() {
        return this.theme;
    }

    public static void beginQuiz() {
        String[][] quizQuestionData = getQuestions(this.theme); 

        Boolean isAnswerCorrect;
        String currentType;
        int score =0, maxScore =0;
        int i=0;
        while (i < quizQuestionData.length) {
            Question currentQuestion = new Question(
                quizQuestionData[i][0], 
                quizQuestionData[i][1]
            );    

            printNextQuestion(currentQuestion);

            type = currentQuestion.getType();
            printAnswers(type, i, questionData[i][2]);

            isAnswerCorrect = chooseAnswers();
            if (isAnswerCorrect) {
                score += addToScore(currentQuestion);
            }

            maxScore = currentQuestion.getScore();
        }

        int result = displayResults(score, maxScore);
        if (result >= 70) {
            displayMessage("success");
            submitScore(result);
        } else {
            displayMessage("fail");
            dismiss(result);
            displayMessage("dismiss");
        }
    }

    public String[][] getQuestions() {
        // data is a query to database return an 2D array with question[Description][Type]
        String[][] questionData = {
            {"question 1","multipleChoice", "1"},
            {"question 2","multipleChoice", "4"},
            {"question 3","multipleChoice", "3"},
            {"question 4","multipleChoice", "1"},
            {"question 5","trueFalse", "2"}
        };

        return questionData;
    }

    public String[][] getAnswers() {
        // data is a query to database return an 2D array with question[Description][Type]        
        String[][] answersData = {
            {"answer 1", "answer 2", "answer 3", "answer 4"},
            {"answer 1", "answer 2", "answer 3", "answer 4"},
            {"answer 1", "answer 2", "answer 3", "answer 4"},
            {"answer 1", "answer 2", "answer 3", "answer 4"},
            {"True", "False"}
        };

        return answersData; 
    }

    public void printNextQuestion(Question q) {
        // print Questions
        String questionHeader = q.getDescription();
        System.out.println("Question: " + questionHeader);
    }

    public void printAnswers(String type, int index, String correctAnswer) { 
        String[][] currentAnswers = getAnswers();
        int length;

        (type == "multipleChoice") ? length = 4 : length = 2;
        
        for (int i=0; i<length; i++) {
            Answer ("answer" + i+1) = new Answer(
                currentAnswers[index][i],
                i,
                correctAnswer
            );

            String answerDescription = ("answer" +  i+1).getDescription();
            System.out.println(answerDescription);
        }
    }

    public Boolean reviewAnswers(Integer[] userAnswerId) {
        for (int elementId : userAnswerId) {
            if ( ("answer" + elementId).isCorrectAnswer() ) {
                return true;
            }
        }

        return false;
    }

    public Boolean chooseAnswers() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your answer (1-4)");

        // int userAnswerId = parseInt(input.nextLine());
        Integer[] userAnswerId = {1};

        return reviewAnswers(userAnswerId);
    }

    public Integer addToScore(Question q) {
        return q.getScore();
    }

    public Integer displayResults(int userScore, int maxScore) {
        int result = (int) (userScore / maxScore) * 100;
        System.out.println(" Your score is " + result + "%");

        return result;
    }
    
    public void displayMessage(String message) {
        switch (message) {
            case "success":
                System.out.println( "You did very well. Wou win a coupon code for a free book of your choice");
                break;
            case "fail":
                System.out.println("Your score is failed. But it was a nice try");
                break;
            case "dismiss":
                setTimeout( () --> 
                    System.out.println("You can retry after 3 months again. Until then read more"),
                    3000
                );
                break;
        }
    }

    public void submitScore(int sum) {
        // insert into user database the result of quiz
        System.out.println("Your result submitted successfully");
    }

    public void dismiss(int userResult) {
        Scanner dismissChoice = new Scanner(System.in);
        System.out.println("Do you want to dismiss result? Enter Y/N");

        if (toUpperCase( dismissChoice.nextLine() ) == "N") {
            submitScore(userResult);
        }
    }
}
