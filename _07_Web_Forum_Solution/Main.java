package code_uz._07_Web_Forum_Solution;

import java.util.Collection;
import java.util.List;

/**
 * OOP
 * _Web_Forum
 */
public class Main {


    public static void main(String[] args) {

        System.out.println("Talab 1:  " + talab_1());
        System.out.println("Talab 2:  " + talab_2());
        System.out.println("Talab 3:  " + talab_3());
        System.out.println("Talab 4:  " + talab_4());
    }


    public static boolean talab_1() {

        Forum forum = new Forum("www.codeuz.uz");

        //# test1
        String test1 = forum.getUrl();
        if (test1 == null || !test1.equals("www.codeuz.uz")) {
            System.err.println("talab_1: test1  null qiymat keldi  ERROR");
            return false;
        }

        User user = null;
        //# test2
        try {
            user = forum.registerUser("Bob", "isim", "familiya", "codeuz@mail", "123");
        } catch (DuplicateNickname e) {
            System.err.println("talab_1: test2 DuplicateNickname istisnosini tashlanmasligi kerak edi ERROR");
            return false;
        }

        //# test 3
        try {
            User testUser = forum.registerUser("Bob", "isim1", "familiya1", "mail", "123123");
            System.err.println("talab_1: test3 DuplicateNickname istisnosini tashlanishi kerak edi ERROR");
            return false;
        } catch (DuplicateNickname e) {

        }

        //# test4
        if (user == null) {
            System.err.println("talab_1: test4 User qani ERROR");
            return false;
        }

        //# test5
        if (!user.getNick().equals("Bob")) {
            System.err.println("talab_1: test5 taxallus 'Bob' ga teng bo'lishi kerak ERROR");
            return false;
        }

        User bob_user = forum.login("Bob", "123");

        //# test6
        if (bob_user == null) {
            System.err.println("talab_1: test6 'Bob' qani ERROR");
            return false;
        }

        //# test7
        if (!bob_user.getNick().equals("Bob")) {
            System.err.println("talab_1: test7 User ni taxallusi 'Bob' ga teng bo'lishi kerak ERROR");
            return false;
        }

        //# test8
        User null_user = forum.login("Ali", "1234");
        if (null_user != null) {
            System.err.println("talab_1: test8 'Ali' qayerdan keldi ERROR");
            return false;
        }
        return true;
    }

    public static boolean talab_2() {

        Forum forum = new Forum("www.codeuz.uz");

        User user = null;

        try {
            user = forum.registerUser("Bob", "isim", "familiya", "codeuz@mail", "123");
        } catch (DuplicateNickname e) {

        }

        //# test1
        Topic topic = forum.createTopic("OOP", "Java", user);
        if (topic == null) {
            System.err.println("talab_2: test1 Topic o'byekti qani  ERROR");
            return false;
        }

        //# test2
        if (topic.getName() == null || !topic.getName().equals("OOP")) {
            System.err.println("talab_2: test2 Mavzuning nomida hatolik bo'ldi  ERROR");
            return false;
        }

        //# test3
        User user1 = topic.getUser();
        if (user1 == null || !user1.getNick().equals("Bob")) {
            System.err.println("talab_2: test3 Topic o'byektida user xato keldi    ERROR");
            return false;
        }

        //# test4
        Collection<Topic> collections = forum.listTopic();
        if (collections == null) {
            System.err.println("talab_2: test4  mavzular ro'yhati qani  ERROR");
            return false;
        }

        forum.createTopic("test", "bekorchilik", user);
        //# test5
        if (collections.size() != 2) {
            System.err.println("talab_2: test5  mavzular ro'yhatida ikkita mavzu bo'lishi kerak  ERROR");
            return false;
        }

        return true;
    }

    public static boolean talab_3() {

        Forum forum = new Forum("www.codeuz.uz");

        User user_Ali = null;
        User user_Vali = null;
        try {
            user_Ali = forum.registerUser("AliShox", "isim", "familiya", "ali@mail", "123");
            user_Vali = forum.registerUser("ValiShox", "isim", "familiya", "vali@mail", "456");

        } catch (DuplicateNickname e) {

        }

        //# test1
        Topic topic = forum.createTopic("OOP", "Java", user_Ali);
        if (topic == null) {
            System.err.println("talab_3: test1 Topic o'byektini qani  ERROR");
            return false;
        }

        //# test2
        Message message_1 = topic.submitMessage(user_Ali, "Xabar nomi", "Salom java chilar bormisizlar");
        if (message_1 == null) {
            System.err.println("talab_3: test2 Message o'byektini qani  ERROR");
            return false;
        }

        //# test3
        if (!message_1.getTitle().equals("Xabar nomi")) {
            System.err.println("talab_3: test3 xabarning  nomi qani ERROR");
            return false;
        }

        //# test4
        if (message_1.getUser() == null) {
            System.err.println("talab_3: test4 xabarni yozgan User qani ERROR");
            return false;
        }

        //# test5
        if (!message_1.getUser().getNick().equals("AliShox")) {
            System.err.println("talab_3: test5 xabarni yozgan Userning taxallusi 'AliShox' qani ERROR");
            return false;
        }

        //# test6
        if (message_1.getTopic() == null) {
            System.err.println("talab_3: test6 Topic o'byekti qani ERROR");
            return false;
        }

        //# test7
        if (!message_1.getTopic().getName().equals("OOP")) {
            System.err.println("talab_3: test7 Mavzuning nomi 'OOP' bo'lishi kerak ERROR");
            return false;
        }

        //# test8
        if (message_1.getTimestamp() == 0) {
            System.err.println("talab_3: test8 Mavzuni tizimga kiritilgan vaqti qani ERROR");
            return false;
        }

        topic.submitMessage(user_Vali, "sava", "Salom Ali qalaysan");

        Collection<Message> messageCollection = topic.getMessagges();

        //# test9
        if (messageCollection == null) {
            System.err.println("talab_3: test9 Mavzuga yozilgan xabarlar qani ERROR");
            return false;
        }

        //# test10
        if (messageCollection.size() != 2) {
            System.err.println("talab_3: test10 Mavzuga  2 ta xabar yozilgan ERROR");
            return false;
        }

        return true;
    }

    public static boolean talab_4() {

        Forum forum = new Forum("www.codeuz.uz");

        User user_Ali = null;
        User user_Vali = null;
        try {
            user_Ali = forum.registerUser("AliShox", "isim", "familiya", "ali@mail", "123");
            user_Vali = forum.registerUser("ValiShox", "isim", "familiya", "vali@mail", "456");

        } catch (DuplicateNickname e) {

        }

        Topic topic = forum.createTopic("OOP", "Java", user_Ali);

        Message message_1 = topic.submitMessage(user_Ali, "Xabar nomi 1", "Salom java chilar bormisizlar");
        Message message_2 = topic.submitMessage(user_Ali, "Xabar nomi 2", "Kim bor gruppada");
        Message message_3 = topic.submitMessage(user_Ali, "Xabar nomi 3", "Yozmisizlarmi?");

        Message message_4 = topic.submitMessage(user_Vali, "Xabar nomi 4", "Shuyerdaman");

        long messageCount_Ali = user_Ali.numSubmitted();

        //# test1
        if (messageCount_Ali != 3) {
            System.err.println("talab_4: test1 Ali 3 ta xabar yozgan (message) ERROR");
            return false;
        }

        //# test2
        List<User> userList = forum.rankUsers();
        if (userList == null) {
            System.err.println("talab_4: test2  ro'yhat qani ERROR");
            return false;
        }

        //# test3
        if (userList.size() != 2) {
            System.err.println("talab_4: test3  ro'yhat soni boshqachaqu ERROR");
            return false;
        }

        //# test4
        if (!userList.get(0).getNick().equals("AliShox")) {
            System.err.println("talab_4: test4  ro'yhat soni boshqachaqu ERROR");
            return false;
        }

        long messageCount = topic.numMessages();

        //# test5
        if (messageCount != 4) {
            System.err.println("talab_4: test5  mavzuga yozilgan xabarlar soni 4 teng bo'lishi kerak ERROR");
            return false;
        }

        Topic topic_2 = forum.createTopic("Collection", "Java", user_Ali);


        //# test6
        double avg = forum.averageMessages();
        if (avg != 2) {
            System.err.println("talab_4: test5  mavzuga yozilgan xabarlar soni 4 teng bo'lishi kerak ERROR");
            return false;
        }

        return true;
    }

}
