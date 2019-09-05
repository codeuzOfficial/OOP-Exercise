package code_uz._07_Web_Forum_Solution;

import java.util.*;

public class Forum {

    private String url;

    private Map<String, User> userMap = new TreeMap<>();
    private List<Topic> topicList = new LinkedList<>();

    public Forum(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public User registerUser(String nick, String first, String last, String email, String password)
            throws DuplicateNickname {

        if (!userMap.containsKey(nick)) {
            User user = new User(nick, first, last, email, password);
            this.userMap.put(nick, user);
            return user;
        }

        throw new DuplicateNickname();
    }

    public User login(String nick, String password) {

        if (this.userMap.containsKey(nick)) {

            User user = this.userMap.get(nick);

            if (user.getPassword().equals(password)) {
                return user;
            }
        }

        return null;
    }

    public Topic createTopic(String name, String subject, User creator) {

        Topic topic = new Topic(name, subject, creator);
        this.topicList.add(topic);

        return topic;
    }

    public Collection<Topic> listTopic() {
        return this.topicList;
    }

    public List<User> rankUsers() {

        List<User> userList = new LinkedList<>(this.userMap.values());

        Collections.sort(userList);
        return userList;
    }

    public double averageMessages() {
        double total = 0;
        for (Topic topic : this.topicList) {
            total += topic.numMessages();
        }

        return total / this.topicList.size();
    }

}
