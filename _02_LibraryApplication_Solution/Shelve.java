package code_uz._02_LibraryApplication_Solution;

public class Shelve { // Javon

    Book[] kitoblar = new Book[10];
    int currentIndex = 0;

    private Closet closet;
    private int number;

    public Shelve(int number, Closet closet) {
        this.number = number;
        this.closet = closet;
    }

    public boolean add(Book book) {
        if (this.currentIndex < 10) {
            kitoblar[this.currentIndex] = book;
            book.setShelve(this);
            this.currentIndex++;
            return true;
        }
        return false;
    }


    public boolean bookContains(Book book) {
        for (int i = 0; i < this.kitoblar.length; i++) {
            Book b = this.kitoblar[i];
            if (b != null) {
                if (b.equals(book)) {
                    return true;
                }
            }
        }
        return false;
    }


    public String getBooks() {
        String result = "";
        for (int i = 0; i < this.kitoblar.length; i++) {
            Book book = this.kitoblar[i];
            if (book != null) {
                result += book.toString() + "\n";
            }
        }
        return result;
    }

    public int getNumber() {
        return number;
    }

    public Closet getCloset() {
        return closet;
    }

    public Book find(String author, String title) {
        for (int i = 0; i < this.kitoblar.length; i++) {
            Book b = this.kitoblar[i];
            if (b != null && b.equals(author, title)) {
                return b;
            }
        }

        return null;
    }
}
