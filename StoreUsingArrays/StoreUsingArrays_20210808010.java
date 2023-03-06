// @author:Eren Sel  @date:01.12.2022
import java.util.Scanner;
public class StoreUsingArrays_20210808010 {
    public static void capitalFirstLetter(String[] Item) {
        for (int i = 0; i < Item.length; i++) {
            Item[i] = Item[i].substring(0, 1).toUpperCase() + Item[i].substring(1).toLowerCase();
        }
    }
    public static int menu(String[] Item, double[] price, Scanner input){
        System.out.println("Please enter what would you like: ");
        for (int i = 0; i < Item.length; i++) {
            System.out.println((i + 1) + " - for " + Item[i] + " (" + price[i] + ")" );
    }
        System.out.println("0 - to checkout");

        return input.nextInt();
    }

    public static String returnedAmounts(double amount) {
        String result = "";
        double[] bills = {200, 100, 50, 20, 10, 5, 1, 0.50, 0.25, 0.10, 0.05, 0.01};
        for (int i = 0; i < bills.length; i++) {
            int count = (int) (amount / bills[i]);
            if (count > 0) {
                result += count + " - " + bills[i] + "\n";
            }
            amount = amount % bills[i];
        }
        return result;
    }
    public static void storeRun(String[] Item,int[] quantity,double[] price) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to our store, we have the following");
        int choice = menu(Item, price, input);
        int[] quantityBought = new int[Item.length];
        while (choice != 0) {
            if (choice > 0 && choice <= Item.length) {
                System.out.println("How many " + Item[choice - 1] + " would you like to buy ?");
                int userWants = input.nextInt();
                if (userWants > 0 && userWants <= quantity[choice - 1]) {
                    quantity[choice - 1] -= userWants;
                    quantityBought[choice - 1] += userWants;
                } else {
                    System.out.println("Error: Invalid request");
                }
            } else {
                System.out.println("Error: Invalid request");
            }
            choice = menu(Item, price, input);
        }
        double total = 0;
        for (int i = 0; i < Item.length; i++) {
            total += (price[i] * quantityBought[i]);
        }


        System.out.println("*****Customer Total*****");
        for (int i = 0; i < Item.length; i++) {
            if(quantityBought[i] > 0) {
                System.out.println(Item[i] + " - " + quantityBought[i] + " * " + price[i] + " = " + (price[i] * quantityBought[i]));
            }
        }


        System.out.println("-----------------------------");
        System.out.println("Total due: " + total);
        System.out.println("Please enter the amount given: ");
        double amountGiven = input.nextDouble();
        while (amountGiven < total) {
            System.out.println("Not enough payment given");
            System.out.println("\nPlease enter the amount given");
            amountGiven = input.nextDouble();
            }
        System.out.println("Thank you for your business. Your change given is: ");
        System.out.println(returnedAmounts(amountGiven - total));

    }

    public static void main(String[] args){
        String[] Item = {"bread", "cola", "snickers", "AYRAN"};
        int quantity[] = {10,15,12,30};
        double[] price = {0.75,2.5,2.25,1};
        capitalFirstLetter(Item);
        storeRun(Item,quantity,price);
    }
}

