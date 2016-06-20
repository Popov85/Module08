package module08task0102;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class {@code OrderPrinter} prints out all the orders in the shop in the form of table
 * @author  Andrii Popov
 */

public class OrderPrinter {

        private List<Order> orders;

        public OrderPrinter (List<Order> orders) {
                this.orders = new ArrayList<Order>(orders);
        }

        /**
         * Prints out info about all orders in the shop throughout the history
         * The following form:
         * Id, dateOfMaking, fulfilled?, cashier, client, {listOfItems}
         */
        public void tablePrint() {
                printTitle();
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                for (int i = 0; i <= orders.size()-1; i++) {
                        Order nextOrder = orders.get(i);
                        System.out.print(nextOrder.getId()+"            ");
                        //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                        System.out.print(dateFormat.format(nextOrder.getDate().getTime())+"             ");
                        System.out.print(nextOrder.isFulfilled()+"            ");
                        System.out.print(nextOrder.getCashier().getName()+"            ");
                        System.out.print(nextOrder.getClient().getName()+"            ");
                        System.out.println(getOrderItemList(nextOrder.getItems())+"            ");
                }

        }

        private void printTitle() {
                System.out.print("Id            ");
                System.out.print("date                          ");
                System.out.print("shipped           ");
                System.out.print("cashier               ");
                System.out.print("client                ");
                System.out.println("items               ");
        }

        /**
         * Creates a string of items in an order
         * @param items
         * @return
         */
        private StringBuilder getOrderItemList(List<OrderItem> items) {
                StringBuilder itemString = new StringBuilder(items.size() * 16);
                for (OrderItem i : items) {
                        if (itemString.length() > 0) itemString.append(", ");
                        itemString.append(i.toString());
                }
                return itemString;
        }

        /**
         * Sorts all orders in descending order
         * Classic Bubbles sorting algorithm
         */
        public void sortObject() {
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                for (int i = orders.size(); i > 0; i--) {
                        for (int j = 0; j < i-1; j++) {
                                Order order1 = orders.get(j);
                                Order order2 = orders.get(j + 1);
                                long number1 = getLongOutOfString(dateFormat, order1);
                                long number2 = getLongOutOfString(dateFormat, order2);
                                if (number2 >= number1) {
                                        Collections.swap(this.orders, j, j + 1);
                                }
                        }

                }
        }

        /**
         * Converts a string into Java long primitive
         * @param df
         * @param order
         * @return
         */
        private long getLongOutOfString(DateFormat df, Order order) {
                String dateString = df.format(order.getDate().getTime());
                String parsedDateString = deleteDelimiters(dateString);
                return Long.parseLong(parsedDateString);
        }


        /**
         * Deletes all the delimiters from an original string:
         * 2016/06/19 13:35:53
         * @param s
         * @return 20160619133553
         */
        private String deleteDelimiters(String s) {
                String newString = "";
                for (int i = 0; i < s.length(); i++){
                        char c = s.charAt(i);
                        if (c != ':' && c != '/' && c !=' ') {
                                newString = newString + c;
                        }
                }
                return newString;
        }
}
