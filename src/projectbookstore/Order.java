package projectbookstore;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.ArrayList;

class Order
{

    Scanner in = new Scanner(System.in);
    ArrayList<Book> shoppingCart;
    private double totalCost = 0;
    private float numberOfBooks = 0;
    private double shippingCost = 150;
    
    
    Order()
    {
        shoppingCart = new ArrayList();
    }

    void setUpOrder() throws FileNotFoundException
    {
        ORDER:
        while (true)
        {
            System.out.println("Your order contains:\n");
            showShoppingcart();
            System.out.println(calculateTotalCost());
            System.out.println(calculateTotalWeight());
            System.out.println("\nIf you wish to have your order delivered you will be debited a fee of: " + shippingCost + " SEK");
            System.out.println("Resulting in a total price of: " + calculateTotalCostWithShipping() + " SEK");
            System.out.println("\nIf you wish to have your order picked up, please press \"P\".");
            System.out.println("If you wish to have your order delivered, please press \"D\".");
            System.out.print("Type your choice: ");
            String answer = in.next().toLowerCase();
            switch (answer)
            {
                case "p":
                    PrintStream pickUp = new PrintStream(new FileOutputStream("Receipt.txt"));
                    System.out.println("Thank you for your purchase, we hope you enjoy your books and return to Kruber´s books in the future.\n"
                            + "A receipt has been printed to your computer, named \"receipt.txt\"");
                    pickUp.println("Kruber´s books\nReceipt\n");
                    shoppingCart.forEach(shoppingCart1 ->
                    {
                        pickUp.println("1x  " + shoppingCart1.getTitle());
                    });
                    pickUp.println("\nYou have chosen to pick up your order. \nIt will be waiting for you at Kruber´s books.");
                    pickUp.println("\n" + calculateTotalCost());
                    pickUp.println(calculateTotalWeight());
                    pickUp.println("Order number: " + orderNumber());
                    pickUp.close();

                    break ORDER;

                case "d":
                    PrintStream delivery = new PrintStream(new FileOutputStream("Receipt.txt"));
                    System.out.println("Thank you for your purchase, we hope that you enjoy your purchase at Kruber´s books.\n"
                            + "A receipt has been printed to your computer, named \"receipt.txt\"");
                    delivery.println("Kruber´s books\nReceipt\n");
                    shoppingCart.forEach(shoppingCart1 ->
                    {
                        delivery.println("1x  " + shoppingCart1.getTitle());
                    });
                    delivery.println("\nYou have chosen to have your order delivered.\nIt will arrive at your doorstep in 3-5 business days.\n");
                    delivery.println("\n" + calculateTotalCost());
                    delivery.println(calculateTotalWeight());
                    delivery.println(calculateShippingFee());
                    delivery.println("Your total price, books including shipping fee: " + calculateTotalCostWithShipping() + " SEK");
                    delivery.println("Order number: " + orderNumber());
                    delivery.close();
                    break ORDER;

                default:
                    System.out.println("You have to use \"P\" or \"D\" to make your choice.");
                    System.out.println("Type your choice: ");
                    break;
            }
        }
    }

    String calculateTotalCost()
    {
        totalCost = 0;
        shoppingCart.forEach(shoppingCart1 ->
        {
            totalCost += shoppingCart1.getPrice();
        });
        return "Cost of books: " + totalCost + " SEK";
    }

    String calculateShippingFee()
    {

        numberOfBooks += shoppingCart.size();
        double numberOfBoxes = Math.ceil(numberOfBooks / 5);

        if (numberOfBoxes < 6)
        {
            shippingCost *= numberOfBoxes;
        }
        else
        {
            shippingCost = (shippingCost - 60) * numberOfBoxes;
        }
        return "Shipping fee for: " + numberOfBooks + " books in " + numberOfBoxes + " boxes is: " + shippingCost + " SEK";

    }

    Double calculateTotalCostWithShipping()
    {
        return shippingCost + totalCost;
    }

    String calculateTotalWeight()
    {
        double totalWeight = 0;
        totalWeight = shoppingCart.stream().map(shoppingCart1 -> shoppingCart1.getWeight()).reduce(totalWeight, (accumulator, _item) -> accumulator + _item);
        return "Your orders total weight is: " + (totalWeight / 1000) + " Kilograms";
    }

    void showShoppingcart()
    {
        shoppingCart.forEach(shoppingCart1 ->
        {
            System.out.println("1x  " + shoppingCart1.getTitle());
        });
    }
     String orderNumber()
    {
        double b = 1000000 * Math.random();
        return String.valueOf((int)b);
    }
}
