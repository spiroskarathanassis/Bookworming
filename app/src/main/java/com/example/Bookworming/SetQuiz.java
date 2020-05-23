public class SetQuiz {
	Quiz quiz;
	User user;

	public SetQuiz(User currentUser, String theme) {
		this.user = currentUser;
		printPossibleThemes();
	}

	public void chooseTheme(User user, String theme) {
		String[] quizThemes = getQuizThemes();
		String[] userThemes = getUserThemes(/* User user */);
		Boolean isThemeCorrect = false;

		if (userThemes.length != 0) {
			for (String userEl : userThemes) {

				// if user's theme match user's choice
				if (theme == userEl) {
					for (String quizEl : quizThemes) {
						
						// if theme match the existing User's purchased books
						if (userEl == quizEl) {
							isThemeCorrect = true;
							quiz = new Quiz(theme);
							quiz.beginQuiz();
						}
					}
				}
			}
		}

		if (!isThemeCorrect) {
			System.out.println("Μη Διαθέσιμο Quiz");
		}
	} 

	public String[] getQuizThemes() {
		// queryThemes = this is a query from database;
		String[] queryThemes = {"History", "Adventure", "Sports", "Autobiographies"};

		return queryThemes;
	}

	public String[] getUserThemes(/* User user */) {
		// query = user.getAllBooks(categrgory); or query to database
		String[] query = {"Adventure"};
		
		if (query.length == 0) {
			System.out.println("User has not bought yet Books");
			return 0; 
		}

		return query;
	}

	public void printPossibleThemes() {
		String[] quizThemes = getUserThemes();

		for (String el: quizThemes) {
			System.out.println(el)
		}
	}
} 
