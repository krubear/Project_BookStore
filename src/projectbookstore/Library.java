package projectbookstore;

class Library
{

    Book[] bookList = new Book[10];

    Library()
    {
        Book b1 = new Book(1, "Brave New World", "Aldous Huxley", 311, 108, 200);
        Book b2 = new Book(2, "Metro 2033", "Dmitry Glukhovsky", 458, 309, 500);
        Book b3 = new Book(3, "Java the Complete Reference, 11th Edition", "Herbert Schildt", 1248, 463, 1000);
        Book b4 = new Book(4, "Future", "Dmitry Glukhovsky", 660, 270, 480);
        Book b5 = new Book(5, "The Black Book of Communism", "Stéphane Courtois Et al.", 912, 565, 800);
        Book b6 = new Book(6, "Goodnight Mister Tom", "Michelle Magorian", 384, 108, 200);
        Book b7 = new Book(7, "Anarchist Cookbook", "William Powell", 162, 239, 150);
        Book b8 = new Book(8, "Sveriges Rikes Lag 2020", "Norstedts Juridik", 4632, 1113, 2000);
        Book b9 = new Book(9, "Blade Itself ", "Joe Abercrombie", 544, 121, 500);
        Book b10 = new Book(10, "Girl With All The Gifts", "M. R. Carey", 512, 95, 550);

        bookList[0] = b1;
        bookList[1] = b2;
        bookList[2] = b3;
        bookList[3] = b4;
        bookList[4] = b5;
        bookList[5] = b6;
        bookList[6] = b7;
        bookList[7] = b8;
        bookList[8] = b9;
        bookList[9] = b10;
    }

    public Book[] getBookList()
    {
        return bookList;
    }

}
