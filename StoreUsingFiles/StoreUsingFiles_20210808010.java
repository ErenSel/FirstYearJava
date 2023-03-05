//@author: Eren Sel @since: 21.12.2022
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class StoreUsingFiles_20210808010 {


    public static void main(String[] args) throws Exception {
        String filename = args[0] + "_ProductInfo.txt";
        String orderFileName = args[0] + "_Order.txt";
        String updatedfilename = args[0] +"_ProductInfoAfterOrder.txt";
        String errors = args[0] +".log";
        String[] itemID = new String[countProducts(filename)];
        String[] itemName = new String[countProducts(filename)];
        int[] quantity = new int[countProducts(filename)];
        double[] price = new double[countProducts(filename)];
        getProductInfo(itemID,itemName,quantity,price,filename);
        File orderFile = new File(orderFileName);
        Scanner reader = new Scanner(orderFile);
        File Errors = new File(errors);
        PrintWriter writer = new PrintWriter(Errors);
        String receipt = args[0] +"_Receipt.txt";
        File receiptFile = new File(receipt);
        PrintWriter write = new PrintWriter(receiptFile);
        double total = 0;
        write.println("********* Customer Receipt *********");
        for (int i = 0; i < countProducts(orderFileName); i++) {
            String orderID=reader.next();
            int orderQuantity= reader.nextInt();
            for (int j = 0; j < countProducts(filename); j++) {
                if(orderID.equals(itemID[j])){
                    if(orderQuantity <= quantity[j] && orderQuantity > 0){
                        total += orderQuantity*price[j];
                        quantity[j] -= orderQuantity;
                        write.println(itemName[j] + "(" +orderID+ ")" + " - " +orderQuantity+" * "+price[j]+" = "+(orderQuantity*price[j]));
                        break;
                    }
                    else if (orderQuantity > quantity[j]){
                        writer.println("ERROR: "+itemName[j]+" - "+orderQuantity+" requested but only "+quantity[j]+ " remaining.");
                        break;
                    }
                    else if(orderQuantity < 0){
                        writer.println("ERROR: Invalid amount requested "+"("+orderQuantity+")");
                        break;
                    }
                }
                else if(j == countProducts(filename)-1){
                    writer.println("ERROR: Product "+orderID+" not found");
                }
            }

        }
        write.println("------------------------------------");
        write.println("Total due - "+total);
        writer.close();
        write.close();
        writeProductInfo(itemID,itemName,quantity,price,updatedfilename);

    }
    public static int countProducts(String fileName){
        int counter = 0;
        try {
            Scanner input = new Scanner(new File(fileName));
            while(input.hasNextLine()){
                counter++;
                input.nextLine();
            }
            input.close();
        }
        catch (IOException e){
            e.printStackTrace();

        }
        return counter;
    }
    public static void getProductInfo(String[] itemID, String[] itemName, int[] quantity, double[] price, String filename)throws Exception {
        File fileName = new File(filename);
        Scanner scan = new Scanner(fileName);
        for (int i = 0; i < itemID.length; i++) {
            itemID[i] = scan.next();
            itemName[i] = scan.next();
            quantity[i] = scan.nextInt();
            price[i] = scan.nextDouble();
        }
        scan.close();
    }

    public static void writeProductInfo(String[] itemID, String[] itemName, int[] quantity, double[] price,String filename)  {
        File fileName = new File(filename);
        try{
            PrintWriter writer = new PrintWriter(fileName);
            for (int i = 0; i < itemID.length; i++) {
                writer.println(itemID[i] +" "+itemName[i]+" "+quantity[i]+" "+price[i]);
            }
            writer.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
