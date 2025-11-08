package edu.farmingdale.library.model;

import java.util.Objects;

public class Book
        implements Comparable<Book>{

    private static int nextID = 100000;
    private int ID;
    private String ISBN;
    private String bookTitle;
    private String author;
    private Boolean inLibrary;
    private String possessionStudentID;
    public Book() {
    }

    public Book(String ISBN, String bookTitle, String author, Boolean inLibrary, String possessionStudentID) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.inLibrary = inLibrary;
        this.possessionStudentID = possessionStudentID;
        this.ISBN = ISBN;
        this.ID = nextID++;
    }

 // Getters
    public int getID() { return ID; }
    public String getISBN() { return ISBN; }
    public String getBookTitle() { return bookTitle; }
    public String getAuthor() { return author; }
    public Boolean getInLibrary() { return inLibrary; }
    public String getPossessionStudentID() { return possessionStudentID; }

    // Setters
    public void setID(int ID) { this.ID = ID; }
    public void setISBN(String ISBN) { this.ISBN = ISBN; }
    public void setBookTitle(String bookTitle) { this.bookTitle = bookTitle; }
    public void setAuthor(String author) { this.author = author; }
    public void setInLibrary(Boolean inLibrary) { this.inLibrary = inLibrary; }
    public void setPossessionStudentID(String possessionStudentID) { this.possessionStudentID = possessionStudentID; }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return ID == book.ID && ISBN == book.ISBN && Objects.equals(bookTitle, book.bookTitle) && Objects.equals(author, book.author) && Objects.equals(inLibrary, book.inLibrary) && Objects.equals(possessionStudentID, book.possessionStudentID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, ISBN, bookTitle, author, inLibrary, possessionStudentID);
    }

    @Override
    public int compareTo(Book other) {
        return this.bookTitle.compareToIgnoreCase(other.bookTitle);
    }

    @Override
    public String toString() {
        return "Book{" +
                "ID=" + ID +
                ", ISBN='" + ISBN + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                ", author='" + author + '\'' +
                ", inLibrary=" + inLibrary +
                ", possessionStudentID=" + possessionStudentID +
                '}';
    }
}
