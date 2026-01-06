package amazonLab;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AmazonMain {
	public static Queue<Order> orders = new LinkedList<Order>();
	public static void main(String[] args) {
		
		readFile();
		drawMenu();
		System.out.println("Exiting App");
	}

	private static void drawMenu() {
		Scanner sc = new Scanner(System.in);
        int choice;
		do {
			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("\n___________________________");
			System.out.println("Order menu");
			System.out.println("1. Show all orders");
			System.out.println("2. Search for order");
			System.out.println("3. Process order");
			System.out.println("0. Quit");
			System.out.println();
            System.out.print("Enter choice: ");
 
            // check for int entry
            while (!sc.hasNextInt()) {
                System.out.print("Please enter a number: ");
                sc.next(); // discard invalid input
            }
            choice = sc.nextInt();
            sc.nextLine(); // clear newline
            
            switch(choice) {
            case 1:
            	displayOrders();
            	break;
            case 2:
            	System.out.print("Enter order ID to search for: ");
                while (!sc.hasNextInt()) {
                    System.out.print("Please enter a number: ");
                    sc.next(); // discard invalid input
                }
                int orderID = sc.nextInt();
                sc.nextLine(); // clear newline
 
                Order order = searchForOrder(orderID);
 
                if (order != null) {
                    System.out.println("\nOrder details");
                    order.displayAll();
                } else {
                    System.out.println("\nCan't find that order!\n");
                }
                break;
            	
            case 3:
            	// in a new Thread - start processing the next order (dequeue)
                System.out.println("Processing orders started");
                Thread t = new Thread(new ProcessOrders());
                t.start();
            	break;
            case 0:
            	System.out.println("Goodbye");
            	break;
            default:
            	System.out.println("Invalid option, returning to menu");
            }
            
            
            
            
		}while(choice!=0);
		
		sc.close();
	}

	/**
     * Searches for an order with the given ID in the {@link #orders} queue.
     *
     * @param orderID the order ID to search for
     * @return the order if found, or null if no matching order exists
     */
	private static Order searchForOrder(int orderID) {
		for(Order order: orders) {
			if(order.getOrderID()==orderID) {
				return order;
			}
		}
		return null;
	}

	/**
	 * Display all details of the orders in the orders list
	 */
	private static void displayOrders() {
		System.out.println("\nAll orders ______________________");
		for(Order order:orders) {
			order.displayAll();
			
		}
		System.out.println("__________________");
		
	}

	
	
	
	
	public static void readFile() {
		File file = new File("amazon_orders.csv");
		String data;
		try(BufferedReader br= new BufferedReader(new FileReader(file))) {
			
			br.readLine();
			data=br.readLine();
//			System.out.println(data);
			
			while(data!=null) {
				String[] parsed = data.split(",");
				if(parsed.length>=7) {
				Order order = new Order();
				//OrderID,CustomerName,ItemID,ItemName,Quantity,DeliveryArea,Priority
				try {
					order.setOrderID(Integer.parseInt(parsed[0]));
					order.setItemID(Integer.parseInt(parsed[2]));
					
				}catch(NumberFormatException e) {
					System.err.println("Error with parsing: "+data);
					data=br.readLine();
					continue;
				}
				try {
					order.setQuantity(Integer.parseInt(parsed[4]));
				}catch(NumberFormatException e) {
					System.err.println("Error with quantity, falling back to one");
					order.setQuantity(1);
				}
				order.setCustomerName(parsed[1]);
				order.setItemName(parsed[3]);
				order.setDeliveryArea(parsed[5]);
				order.setPriority(Priority.fromString(parsed[6]));
//				order.displayAll();
				orders.add(order);
				}else {
					System.err.println("Error with array Length: "+data);
				}
				data=br.readLine();
				
			}
			
		}catch(FileNotFoundException e) {
			System.err.println("File not found");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
