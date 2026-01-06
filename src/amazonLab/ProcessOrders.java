package amazonLab;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * The class represents a unit of work that processes a
 * single order from the shared order queue in OrderProcessingApp.
 * When run in a separate thread, this class removes the next available order
 * from the queue (if any) and records it in the "Completed_Orders.txt" file.
 */
public class ProcessOrders implements Runnable {

	private static final String FILE_TO_WRITE = "Completed_Orders.txt";
	
    /**
     * Called when the thread starts. 
     */
    @Override
    public void run() {
        startProcessing();
    }

    /**
     * Attempts to remove one order from the shared queue.
     * If the queue is not empty, the next order is removed and written to the
     * completed orders file. Any unexpected errors during removal or writing
     * are caught and reported.
     */
    private static void startProcessing() {
        try {
            if (!AmazonMain.orders.isEmpty()) {
                Order order = AmazonMain.orders.remove();
                System.out.println("Order removed " + order.getOrderID());

                writeToFile(order);
            }
        } catch (Exception e) {
            System.out.println("Problem processing order: " + e.getMessage());
        }
    }

    /**
     * Writes the given order's ID to file.
     * The file is opened in append mode so that each processed order is added
     * to the end rather than overwriting existing content.


     * @param order the order to be recorded
     */
    private static void writeToFile(Order order) {
        try {
            FileWriter fw = new FileWriter(new File(FILE_TO_WRITE), true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("Order Id : " + order.getOrderID());
            bw.newLine();

            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("Problem recording order processing: " + e.getMessage());
        }
    }
}
