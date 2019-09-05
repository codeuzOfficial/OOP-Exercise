package code_uz._07_Web_Forum;

import java.util.Collection;
import java.util.List;

public class Forum {
    
    public Forum(String url){
    }
    
    public String getUrl(){
        return null;
    }

    public User registerUser(String nick, String first, String last, String email, String password)
        throws DuplicateNickname {
        return null;
    }
    
    public User login(String nick, String password){
        return null;
    }
    
    public Topic createTopic(String name, String subject, User creator){
        return null;
    }
    
    public Collection<Topic> listTopic(){
        return null;
    }
    
    public List<User> rankUsers(){
        return null;
    }
    
    public double averageMessages(){
        return 0.0;
    }
    
}
