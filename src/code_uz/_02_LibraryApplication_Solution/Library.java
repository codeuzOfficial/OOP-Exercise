package code_uz._02_LibraryApplication_Solution;

public class Library {

    Floor[] qavatlar = new Floor[3]; // qavat

    public Library() {
        for (int i = 0; i < 3; i++) {
            qavatlar[i] = new Floor(i);
        }
    }

    public boolean add(Book book, int floor, String closet, int shelf) {
        Floor f = this.qavatlar[floor];
        return f.addBook(book, closet, shelf);
    }

    public boolean contains(int floor, String closet, int shelf, Book book) {
        return this.qavatlar[floor].closetContains(closet, shelf, book);
    }

    public String getBooks(int floor, String closet) {
        return this.qavatlar[floor].getBooks(closet);
    }

    public Book find(String author, String title) {
        for (int i = 0; i < this.qavatlar.length; i++) {
            Book b = this.qavatlar[i].find(author, title);
            if (b != null) {
                return b;
            }
        }
        return null;
    }
}
