package code_uz._07_Web_Forum_Solution;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Topic {

    private String name;
    private String subject;
    private User creator;

    private List<Message> messageList = new LinkedList<>();

    public Topic(String name, String subject, User creator) {
        this.name = name;
        this.subject = subject;
        this.creator = creator;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public User getUser() {
        return creator;
    }

    public Message submitMessage(User user, String title, String body) {
        Message message = new Message(user, title, body, this);

        messageList.add(message);

        user.incrementSubmitNum();

        return message;
    }

    public Collection<Message> getMessagges() {
        return this.messageList;
    }

    public long numMessages() {
        return this.messageList.size();
    }
}
