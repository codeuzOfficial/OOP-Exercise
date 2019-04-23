package code_uz._07_Web_Forum_Solution;

public class User implements Comparable<User> {

    private String nick;
    private String first;
    private String last;
    private String email;
    private String password;

    private long submitNum = 0;

    public User(String nick, String first, String last, String email, String password) {
        this.nick = nick;
        this.first = first;
        this.last = last;
        this.email = email;
        this.password = password;
    }

    public String getNick() {
        return nick;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public String getEmail() {
        return email;
    }

    public long numSubmitted() {
        return submitNum;
    }

    public void incrementSubmitNum() {
        this.submitNum++;
    }

    @Override
    public int compareTo(User user) {

        return (int) (user.submitNum - this.submitNum);
    }

    public String getPassword() {
        return password;
    }


}
