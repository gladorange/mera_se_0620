package com.mera.lesson8;

import java.util.Objects;

@XmlTypeName("Книга")
public class Book {
    public static final String EMPTY_STRING = "";

    @XmlName("Название")
    protected String title;

    @XmlName("Автор")
    protected String author;

    @XmlName("Количество страниц")
    protected int numPages;

    @XmlName("Прочитана")
    protected boolean isRead;

    public Book() {
        title = EMPTY_STRING;
        author = EMPTY_STRING;
    }

    public Book(String title, String author, int numPages, boolean isRead) {
        this.title = title;
        this.author = author;
        this.numPages = numPages;
        this.isRead = isRead;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public boolean isRead() {
        return isRead;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", numPages=" + numPages +
                ", isRead=" + isRead +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return numPages == book.numPages &&
                isRead == book.isRead &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, numPages, isRead);
    }
}
