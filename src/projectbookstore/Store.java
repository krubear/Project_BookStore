package projectbookstore;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Store
{

    Scanner in = new Scanner(System.in);
    private String switchCase;
    private String switchCase2;
    Library myLibrary = new Library();
    ArrayList<Book> shoppingCart = new ArrayList<>();
    Order myOrder = new Order();

    Store()
    {

    }

    void menu() throws FileNotFoundException
    {
        System.out.println("Welcome to Kruber's books - If you want to read, we're on the same page");
        MAIN:
        while (true)
        {
            System.out.println("\nCategories:\n");

            System.out.println("1. List of books\n2. Purchase books\n3. See shopping cart\n4. Check out\n5. Exit bookstore");
            System.out.print("Type your choice: ");
            switchCase = in.next().toLowerCase();
            System.out.println("");

            switch (switchCase)
            {
                case "1":
                    listOfBooks();
                    break;
                case "2":
                    purchaseBooksList();
                    break;
                case "3":
                    if (myOrder.shoppingCart.isEmpty() || myOrder == null)
                    {
                        System.out.println("Your shopping cart is empty");
                    }
                    else
                    {
                        System.out.println("Your shopping cart contains:\n");
                        myOrder.showShoppingcart();
                    }
                    break;
                case "4":
                    if (myOrder.shoppingCart.isEmpty())
                    {
                        System.out.println("You do not have an active order.");
                        break;
                    }
                    else
                    {
                        System.out.println("Do you wish to finish your order?\ntype"
                                + " \"yes\" to continue or \"no\" to return to the menu.");
                        System.out.print("Type your choice: ");
                        ANW:
                        while(true)
                        {
                        String anw = in.next().toLowerCase();
                        System.out.println("");
                        switch (anw)
                        {
                            case "yes":        
                                myOrder.setUpOrder();
                                break MAIN;
                            case "no":
                                break ANW;
                            default:
                                System.out.println("Please enter yes or no.");
                                System.out.print("Type your choice: ");
                                System.out.println("");
                                
                        }        
                        }
                    }
                case "l":
                    listOfBooks();
                    break;
                case "5":
                    break MAIN;
                default:
                    break;

            }
        }
    }

    void listOfBooks()
    {
        for (int i = 0; i < myLibrary.bookList.length; i++)
        {
            if (i == 9)
            {
                System.out.printf(myLibrary.bookList[i].getIndexNumber() + ": " + myLibrary.bookList[i].getTitle()
                        + ", " + myLibrary.bookList[i].getAuthor() + ". " + myLibrary.bookList[i].getPrice() + " SEK\n");
            }
            else
            {
                System.out.printf(myLibrary.bookList[i].getIndexNumber() + " : " + myLibrary.bookList[i].getTitle()
                        + ", " + myLibrary.bookList[i].getAuthor() + ". " + myLibrary.bookList[i].getPrice() + " SEK\n");
            }
        }
    }

    void purchaseBooksList()
    {
        BOOKLIST:
        while (true)
        {
            System.out.println("\nTo purchase a book enter the number written to the left of the title");
            System.out.println("To show the list of books press \"L\"");
            System.out.println("If you wish to return to the menu, press \"R\"");
            System.out.print("Type your choice: ");
            switchCase2 = in.next().toLowerCase();
            System.out.println("");

            switch (switchCase2)
            {
                case "1":
                    myOrder.shoppingCart.add(myLibrary.bookList[0]);
                    System.out.println("You added Brave New World, by Aldous Huxley to your shopping cart");
                    break;
                case "2":
                    myOrder.shoppingCart.add(myLibrary.bookList[1]);
                    System.out.println("You added Metro 2033, by Dmitry Glukhovsky to your shopping cart");
                    break;
                case "3":
                    myOrder.shoppingCart.add(myLibrary.bookList[2]);
                    System.out.println("You added Java the Complete Reference - 11th Edition, by Herbert Schildt to your shopping cart");
                    break;
                case "4":
                    myOrder.shoppingCart.add(myLibrary.bookList[3]);
                    System.out.println("You added Future, by Dmitry Glukhovsky to your shopping cart");
                    break;
                case "5":
                    myOrder.shoppingCart.add(myLibrary.bookList[4]);
                    System.out.println("You added The Black Book of Communism, by Stéphane Courtois Et al.to your shopping cart");
                    break;
                case "6":
                    myOrder.shoppingCart.add(myLibrary.bookList[5]);
                    System.out.println("You added Goodnight Mister Tom, by Michelle Magorian to your shopping cart");
                    break;
                case "7":
                    myOrder.shoppingCart.add(myLibrary.bookList[6]);
                    System.out.println("You added Anarchist Cookbook, by William Powell to your shopping cart");
                    break;
                case "8":
                    myOrder.shoppingCart.add(myLibrary.bookList[7]);
                    System.out.println("You added Sveriges Rikes Lag 2020, by Norstedts Juridik to your shopping cart");
                    break;
                case "9":
                    myOrder.shoppingCart.add(myLibrary.bookList[8]);
                    System.out.println("You added Blade Itself, by Joe Abercrombieto your shopping cart");
                    break;
                case "10":
                    myOrder.shoppingCart.add(myLibrary.bookList[9]);
                    System.out.println("You added Girl With All The Gifts, by M. R. Carey to your shopping cart");
                    break;
                case "r":
                    break BOOKLIST;
                case "l":
                    listOfBooks();
                    break;
                default:
                    System.out.println("Please press \"r\" to exit to main menu or press \"L\" to view list of books");
                    System.out.println("Type your choice: ");
            }
        }
    }
    
    public ArrayList<Book> getShoppingCart()
    {
        return shoppingCart;
    }

}
