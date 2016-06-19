package module08task0102;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Class {@code Runner} Module 08 tasks 01-02
 * Task 01. Print out entities of a collection in the form of table
 * Task 02. Sort objects without Collections.sort(). Algorithm is the following^
 * It is based on converting the dates into long primitive and applies usual Bubble sorting algorithm to the collection
 */
public class Runner {
        public static void main (String[] args) throws MoreThanIsLeftException {

                // Create instances of musical instruments
                Instrument aPiano = new Piano();
                Instrument aTrumpet = new Trumpet();
                Instrument aGuitar = new Guitar();

                // Fill StoreHouse with some musical instruments
                HashMap<Instrument, Integer> mapInstance = new HashMap<Instrument, Integer>();
                mapInstance.put(aPiano, 200);
                mapInstance.put(aTrumpet, 700);
                mapInstance.put(aGuitar, 1600);
                StoreHouse.setStock(mapInstance);
                // Print the current state of StoreHouse
                StoreHouse.printStockState();

                /*Let's make a dozen of orders to be printed out and add them to an ArrayList*/
                List<Order> orderList = createOrders(12, aPiano, aTrumpet, aGuitar);

                /*
                Task 01. Print out entities of a collection in the form of table
                 */

                /*Print out all the orders in the form of table*/
                OrderPrinter printClass = new OrderPrinter(orderList);
                printClass.tablePrint();
                /*
                Task 02. Sort objects without Collections.sort()
                 */
                /*Sort the orders by date in descending order*/
                printClass.sortObject();
                /*Print out all the orders from the most recent to the last recent*/
                System.out.println("The most recent orders are the following:");
                printClass.tablePrint();
        }

        /**
         * Fills an ArrayList with test Orders
         * Each order may contain x-pianos, y-guitars, z-trumpets
         * If all x,y,z are zeros - order is considered to be cancelled
         * x,y,z [0-3]
         * Delay in time (empty loop) is added to simulate different times of each order
         * @param quantity
         * @return
         */
        private static List<Order> createOrders(int quantity, Instrument aPiano, Instrument aTrumpet, Instrument aGuitar) throws MoreThanIsLeftException {
                Random rand = new Random();
                List<Order> orders = new ArrayList<Order>();
                for (int i = 1; i <= quantity; i++) {
                        // Randomly select the quantity of each instrument in an order
                        int randPiano = rand.nextInt(4);
                        int randGuitar = rand.nextInt(4);
                        int randTrumpet = rand.nextInt(4);
                        if (randPiano == 0 && randGuitar == 0 && randTrumpet == 0 ) {
                                System.out.println("User has changed his mind and refused to buy anything");
                        }
                        else {
                                Order myOrder = new Order();
                                myOrder.addItem(randPiano, aPiano);
                                myOrder.addItem(randTrumpet, aTrumpet);
                                myOrder.addItem(randGuitar, aGuitar);
                                // Put just created Order object to ArrayList
                                orders.add(myOrder);
                        }
                        // Empty loop is added to simulate different date/times of order placements
                        for (int j = 0; j < 1000000000; j++) {};
                }
                return orders;
        }
}
