package module08task0102;

/**
 * Class {@code Cashier} keeps info about a person who process orders
 * @author  Andrii Popov
 */

public class Cashier {
        private String name;

        public Cashier() {
                this.name = "Mrs Smith";
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }
}
