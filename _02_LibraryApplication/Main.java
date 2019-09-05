package code_uz._02_LibraryApplication;

public class Main {

    public static void main(String[] args) {

        /** TEST  */
//        System.out.println("addBookTest() -> Library.addBook() : " + addBookTest());
//        System.out.println("containsTest() ->  Library.contains() : " + containsTest());
//        System.out.println("getBoinsTest() ->  Library.getBooks() : " + getBooksTest());
//        System.out.println("getBookPosition() ->  Book.(getCloset()/getCloset()/getShelf() : " + getBookPosition());
//        System.out.println("findTest() ->  Library.find() : " + findTest());


    }


    private static boolean addBookTest() {
        // Kitob yaratish
        Book book1 = new Book("author 1", "title 1");
        Book book2 = new Book("author 2", "title 2");

        Library library = new Library();

        // Kitob qo'shish
        boolean test1 = library.add(book1, 1, "C1", 1);
        if (!test1) {
            System.err.println("addBookTest: test1 ERROR");
            return false;
        }

        boolean test2 = library.add(book2, 1, "C2", 1);

        if (!test2) {
            System.err.println("addBookTest: test2 ERROR");
            return false;
        }
        return true;
    }

    private static boolean containsTest() {
        // Kitob yaratish
        Book book1 = new Book("author 1", "title 1");
        Book book2 = new Book("author 2", "title 2");

        Library library = new Library();

        // Kitob qo'shish
        library.add(book1, 1, "C1", 1);
        library.add(book2, 2, "C2", 1);

        // Kitob bor yo'qligini tekshirish
        boolean test1 = library.contains(1, "C1", 1, book1);
        if (!test1) {
            System.err.println("containsTest test1 ERROR");
            return false;
        }

        boolean test2 = library.contains(1, "C1", 1, new Book("a", "t"));
        if (test2) {
            System.err.println("containsTest test2 ERROR");
            return false;
        }

        boolean test3 = library.contains(1, "C1", 1, new Book("author 1", "title 1"));
        if (!test3) {
            System.err.println("containsTest test3 ERROR");
            return false;
        }

        return true;
    }

    private static boolean getBooksTest() {
        //Kitob yaratish
        Book book1 = new Book("author 1", "title 1");
        Book book2 = new Book("author 2", "title 2");

        Library library = new Library();

        // Kitob qo'shish
        library.add(book1, 1, "C1", 1);
        library.add(book2, 2, "C2", 1);

        String test1 = library.getBooks(1, "C1");
        if (!test1.contains("Shelf 0\n" +
                "Shelf 1\n" +
                "author 1, title 1\n" +
                "Shelf 2\n" +
                "Shelf 3\n" +
                "Shelf 4\n" +
                "Shelf 5\n")) {
            System.err.println("getBooksTest test1 ERROR");
            return false;
        }

        String test2 = library.getBooks(2, "C2");
        if (!test2.contains("Shelf 0\n" +
                "Shelf 1\n" +
                "author 2, title 2\n" +
                "Shelf 2\n" +
                "Shelf 3\n" +
                "Shelf 4\n" +
                "Shelf 5\n")) {
            System.err.println("getBooksTest test2 ERROR");
            return false;
        }
        return true;
    }

    private static boolean getBookPosition() {
        //Kitob yaratish
        Book book1 = new Book("author 1", "title 1");
        Book book2 = new Book("author 2", "title 2");

        Library library = new Library();

        // Kitob qo'shish
        library.add(book1, 1, "C1", 1);
        library.add(book2, 2, "C2", 1);

        int test1 = book1.getFloor();
        if (test1 != 1) {
            System.err.println("getBookPosition test1 ERROR");
            return false;
        }

        String test2 = book1.getCloset();
        if (!test2.equals("C1")) {
            System.err.println("getBookPosition test2 ERROR");
            return false;
        }

        int test3 = book1.getShelf();
        if (test3 != 1) {
            System.err.println("getBookPosition test3 ERROR");
            return false;
        }

        int test4 = book2.getFloor();
        if (test4 != 2) {
            System.err.println("getBookPosition test4 ERROR");
            return false;
        }

        String test5 = book2.getCloset();
        if (!test5.equals("C2")) {
            System.err.println("getBookPosition test5 ERROR");
            return false;
        }

        int test6 = book2.getShelf();
        if (test6 != 1) {
            System.err.println("getBookPosition test6 ERROR");
            return false;
        }


        return true;
    }

    private static boolean findTest() {
        // Kitob yaratish
        Book book1 = new Book("author 1", "title 1");
        Book book2 = new Book("author 2", "title 2");

        Library library = new Library();

        // Kitob qo'shish
        library.add(book1, 1, "C1", 1);
        library.add(book2, 2, "C2", 1);


        Book test1 = library.find("author 1", "title 1");
        if (test1 == null) {
            System.err.println("findTest: test1 ERROR");
            return false;
        }

        Book test2 = library.find("author 2", "title 2");
        if (test2 == null) {
            System.err.println("findTest: test2 ERROR");
            return false;
        }

        Book test3 = library.find("author 3", "title 3");
        if (test3 != null) {
            System.err.println("findTest: test3 ERROR");
            return false;
        }


        return true;
    }


}
