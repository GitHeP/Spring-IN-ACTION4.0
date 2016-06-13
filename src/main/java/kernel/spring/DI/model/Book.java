package kernel.spring.DI.model;

/**
 * Created by kernel on 2016/6/13.
 */
public class Book {

    private String bookName;

    private String authorName;

    public Book(){}

    public Book(String bookName,String authorName){
        this.bookName = bookName;
        this.authorName = authorName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
