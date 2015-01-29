public class Task {

    private String content;
    private String ansver;
    private int mark;

    public Task(String content){
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAnsver() {
        return ansver;
    }

    public void setAnsver(String ansver) {
        this.ansver = ansver;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
