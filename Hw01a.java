import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class Hw01a {
    static Scanner input = new Scanner(System.in);
    public static void main(String [] args){
        try{
            Scanner inputFile = new Scanner(new FileReader("stocks.txt"));
            String stock1 = inputFile.next();
            double value1 = inputFile.nextDouble();
            
            String stock2 = inputFile.next();
            double value2 = inputFile.nextDouble();
            
            inputFile.close();
            
            System.out.println("Enter '1' to get price by stock ticker");
            System.out.println("Enter '2' to get stocks greater than or equal to specified price");
            System.out.println("Enter '3' to quit");
            System.out.print("Your choice: ");

            int choice = input.nextInt();

            switch(choice){
                case 1:
                    System.out.print("Enter a stock ticker: ");
                    String stock_choice = input.next();
                    if(stock_choice.equalsIgnoreCase(stock1))
                        System.out.println(stock1 + " current price is " + value1);
                    else if(stock_choice.equalsIgnoreCase(stock2))
                        System.out.println(stock2 + " current price is " + value2);
                    break;
                case 2:
                    System.out.print("Enter a price: ");
                    double price_choice = input.nextDouble();
                    if(price_choice >= value1)
                        System.out.println(stock1 + " is more than " + price_choice);
                    else if(price_choice >= value2)
                        System.out.println(stock2 + " is more than " + price_choice);
                    else if(price_choice < value1 && price_choice < value2){
                        System.out.println(stock1 + " is more than " + price_choice);
                        System.out.println(stock2 + " is more than " + price_choice);
                    }
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    System.exit(1);
                default:
                    System.out.println("Unrecognized menu option, exiting");
                    System.exit(1);
            }
        }
        catch(FileNotFoundException e){
             System.out.println("File not found");
       }
    }
}
