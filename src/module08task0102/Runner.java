package module08task0102;

import java.util.*;

/**
 * Class {@code Runner} Module 08 tasks 02
 * Modified version of . Prints out entities of a collection in the form of table sorted with Collections.sort()
 * @author  Andrii Popov
 */
public class Runner {
        public static void main (String[] args) throws MoreThanIsLeftException {
                // Create instances of musical instruments
                Instrument aPiano = new Piano();
                Instrument aTrumpet = new Trumpet();
                Instrument aGuitar = new Guitar();

                // Fill StoreHouse with some musical instruments
                setInitialQuantity(aPiano, aTrumpet, aGuitar);

                // Print the current state of StoreHouse
                StoreHouse.printStockState();
                /*Let's make a dozen of orders to be printed out and add them to an ArrayList*/
                List<Order> orderList = createOrders(12, aPiano, aTrumpet, aGuitar);

                //Task 01. Print out entities of a collection in the form of table sorted via Collections.sort()
                Collections.sort(orderList);
                OrderPrinter printClass = new OrderPrinter(orderList);
                printClass.tablePrint();
        }

        /**
         * Sets initial quantity of each instrument
         * @param aPiano
         * @param aTrumpet
         * @param aGuitar
         */
        private static void setInitialQuantity(Instrument aPiano, Instrument aTrumpet, Instrument aGuitar) {
                HashMap<Instrument, Integer> mapInstance = new HashMap<>();
                mapInstance.put(aPiano, 200);
                mapInstance.put(aTrumpet, 700);
                mapInstance.put(aGuitar, 1600);
                StoreHouse.setStock(mapInstance);
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
