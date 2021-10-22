package projectbookstore;

class Book
{

    private final int indexNumber;
    private final String title;
    private final String author;
    private final int numberOfPages;
    private final double price;
    private final double weight;

    public Book(int indexNumber, String title, String author, int numberOfPages, double price, double weight)
    {
        this.indexNumber = indexNumber;
        this.title = title;
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.price = price;
        this.weight = weight;
    }

    public int getIndexNumber()
    {
        return indexNumber;
    }

    public String getTitle()
    {
        return title;
    }

    public String getAuthor()
    {
        return author;
    }

    public int getNumberOfPages()
    {
        return numberOfPages;
    }

    public double getPrice()
    {
        return price;
    }

    public double getWeight()
    {
        return weight;
    }

}
