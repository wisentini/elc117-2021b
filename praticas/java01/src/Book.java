public class Book {
    private String title;
    private String author;
    private String publisher;
    private long isbn;
    private int year;
    private int numberOfPages;
    private double price;

    public Book(String title, String author, String publisher, long isbn, int year, int numberOfPages, double price) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.year = year;
        this.numberOfPages = numberOfPages;
        this.price = price;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public long getISBN() {
        return this.isbn;
    }

    public int getYear() {
        return this.year;
    }

    public int getNumberOfPages() {
        return this.numberOfPages;
    }

    public double getPrice() {
        return this.price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setISBN(long isbn) {
        this.isbn = isbn;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void show() {
        System.out.println();
        System.out.println("\"title\": " + "\"" + this.title + "\",");
        System.out.println("\"author\": " + "\"" + this.author + "\",");
        System.out.println("\"publisher\": " + "\"" + this.publisher + "\",");
        System.out.println("\"isbn\": " + "\"" + this.isbn + "\",");
        System.out.println("\"year\": " + "\"" + this.year + "\",");
        System.out.println("\"numberOfPages\": " + "\"" + this.numberOfPages + "\",");
        System.out.println("\"price\": " + "\"" + this.price + "\"");
        System.out.println();
    }
}
