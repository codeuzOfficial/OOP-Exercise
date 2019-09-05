package code_uz._02_LibraryApplication_Solution;

public class Book {

    private String author;
    private String title;
    private Shelve shelve;

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String toString() {
        return this.author + ", " + this.title;
    }

    public int getShelf() { // Javon nomeri
        return this.shelve.getNumber();
    }

    public String getCloset() { // Shkaf nomi
        return this.shelve.getCloset().getName();
    }

    public int getFloor() {
        return this.shelve.getCloset().getFloor().getNumber();
    }

    public void setShelve(Shelve shelve) {
        this.shelve = shelve;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

      Book b = (Book) obj;

        if (this.author.equals(b.author) && this.title.equals(b.title)) {
            return true;
        }
        return false;
    }


    public boolean equals(String author, String title) {
        if (this.author.equals(author) && this.title.equals(title)) {
            return true;
        }
        return false;
    }
}
