public class TextStatement extends Statement {
    // REMOVER método value - agora está na superclasse
    
    @Override
    protected String header(Customer aCustomer) {
        return "Rental Record for " + aCustomer.getName() + "\n";
    }

    @Override
    protected String eachLine(Rental aRental) {
        return "\t" + aRental.getMovie().getTitle() + "\t" +
                String.valueOf(aRental.getCharge()) + "\n";
    }

    @Override
    protected String footer(Customer aCustomer) {
        String result = "Amount owed is " + String.valueOf(aCustomer.getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
                " frequent renter points";
        return result;
    }
}