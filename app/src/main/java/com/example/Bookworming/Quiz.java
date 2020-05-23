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

    public void beginQuiz() {
        String[][] quizQuestionData = getQuestions(this.theme); 
        
        String currentType;
        int score =0, maxScore =0;
        Boolean isAnswerCorrect;
        int i=0;
        while (i < quizQuestionData.length) {
            
            Question currentQuestion = new Question(
                quizQuestionData[i][0], 
                quizQuestionData[i][1]
            );    

            printNextQuestion(currentQuestion);
            
            /* print Answers */
            currentType = currentQuestion.getType();
            int answerLength = (currentType == "multipleChoice") ? 4 : 2;
            Answer[] answerNames = new Answer[answerLength];
     	   	String[][] currentAnswers = getAnswers();

        	for (int j=0; j<answerLength; j++) {
        		answerNames[j] = new Answer(
        				currentAnswers[i][j], 
        				j, 
        				true
        		);
        		printAnswers(answerNames[j]);
        	}
            	
            Integer[] answerPressed = chooseAnswers();
            isAnswerCorrect = reviewAnswers(answerPressed, answerNames);
            
            if (isAnswerCorrect) {
            	score += addToScore(currentQuestion);
            }
            maxScore = currentQuestion.getScore();
            
            i++;
        }
        
        this.result = displayResults(score, maxScore);
        if (result >= 70) {
        	displayMessage("success");
        	submitScore(result);
        } else {
        	displayMessage("fail");
        	dismiss(result);
        	displayMessage("dismiss");
        }

    }

    public String[][] getQuestions(String theme) {
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

    public static void printNextQuestion(Question q) {
        String questionHeader = q.getDescription();
        System.out.println("Question: " + questionHeader);
    }

    public void printAnswers(Answer answer) { 
        String answerDescription = answer.getDescription();
        System.out.println(answerDescription);
    }

    public Boolean reviewAnswers(Integer[] userAnswerId, Answer[] answerNames) {
        for (int elementId : userAnswerId) {
            if ( answerNames[elementId].isCorrectAnswer() ) {
                return true;
            }
        }
        
        return false;
    }

    public Integer[] chooseAnswers() {
//        Scanner input = new Scanner(System.in);
        System.out.println("Enter your answer (1-4)");

//        userAnswerId = parseInt(input.nextLine());
        Integer[] userAnswerId = {1};

        return userAnswerId;
    }
    
    public int addToScore(Question q) {
    	return q.getScore();
    }
    
    public Integer displayResults(int userScore, int maxScore) {
    	int result = (int) (userScore / maxScore) * 100;
    	System.out.println("Your score is " + result + "%");

    	return result;
    }
    
    public void displayMessage(String message) {
    	switch (message) {
    		case "sucess":
    			System.out.println("You did very well. You win a coupon code to "
    							+ "use it for tour next order of book of your choice");
    			break;
    		case "fail":
    			System.out.println("Your score is failed. But it was a nice try");
    			break;
    		case "dismiss":
    			/* setTimeout(() -> 		// lambda expression
    				System.out.println("You can retry after 3 months again. Until then read more..."),
    				3000
    			); */
    			break;
    	}
    }
    
    public static void submitScore(int sum) {
    	// insert into user database the result od quiz
    	System.out.println("Your result submitted successfully");
    }
    
    public void dismiss(int userResult) {
    	Scanner dismissScanner = new Scanner(System.in);
    	System.out.println("Do you want to dismiss result? Enter Y/N");
    	
    	if (dismissScanner.hasNext("N")) {
    		submitScore(userResult);
    	}
    	
    	dismissScanner.close();
    }
    
    

}