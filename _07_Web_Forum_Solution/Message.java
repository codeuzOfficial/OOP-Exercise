package code_uz._07_Web_Forum_Solution;

public class Message {


    private User user;
    private String title;
    private String body;

    private Topic topic;

    private long submitTime;

    public Message(User user, String title, String body, Topic topic) {
        this.user = user;
        this.title = title;
        this.body = body;
        this.topic = topic;

        submitTime = System.currentTimeMillis();
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public User getUser() {
        return user;
    }

    public Topic getTopic() {
        return topic;
    }

    public long getTimestamp() {
        return submitTime;
    }
}
