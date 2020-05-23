
public class Answer /* extends Quiz */{
	private String description;
	private Integer answerId;
	private Boolean correctAnswer = false;

	public Answer(String desc, Integer id, Boolean correct) {
//		super(theme);
		this.description = desc;
		this.answerId = id;
		this.setCorrectAnswer(correct);
	}

	public String getDescription() {
        return this.description;
    }

    public Integer getAnswerId() {
        return this.answerId;
    }

    public void setCorrectAnswer(Boolean correct) {
		this.correctAnswer = true;
    }

    public Boolean isCorrectAnswer() {
        return this.correctAnswer;
    }

}