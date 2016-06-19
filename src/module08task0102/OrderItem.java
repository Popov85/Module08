package module08task0102;

/**
 * Class {@code OrderItem} keeps info about a part of orders
 * @author  Andrii Popov
 */

public class OrderItem {

        // Number if items a customer asked
        private int numberOfItems;
        // Item that a customer asked
        private Instrument instrument;

        public OrderItem(int number, Instrument instrument) throws Exception {
                if (number == 0) throw new Exception("Quantity of 0 was selected!");
                this.numberOfItems = number;
                this.instrument = instrument;
        }

        public Instrument getInstrument() {
                return instrument;
        }

        public int getNumberOfItems() {
                return numberOfItems;
        }

        public void setNumberOfItems(int numberOfItems) {
                this.numberOfItems = numberOfItems;
        }

        public void setInstrument(Instrument instrument) {
                this.instrument = instrument;
        }

        @Override
        public String toString() {
                return "{"+this.getInstrument().getInstrumentName()+"/"+this.getNumberOfItems()+"}";
        }

}
