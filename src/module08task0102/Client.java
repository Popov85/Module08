package module08task0102;

/**
 * Class {@code Client} keeps info about a buyer
 * @author  Andrii Popov
 */

public class Client {
        private String name;

        public Client() {
                this.name = "Mr Simpson";
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }
}
