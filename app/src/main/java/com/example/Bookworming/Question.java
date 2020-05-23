public class Question /*extends Quiz */{
    private String description;
    private String type;
    private Integer score;

    public Question(String description, String type) {
//        this.super(theme);
        this.description = description;
        this.type = type;
        this.setScore(type);
    }

    public String getDescription() {
        return this.description;
    }

    public String getType() {
        return this.type;
    }

    public void setScore(String qType) {
        if (qType == "multipleChoice") {
            this.score = 3;
        } else {
            this.score = 1;
        }
    }

    public Integer getScore() {
        return this.score;
    }

}