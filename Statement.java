import java.util.Enumeration;

public abstract class Statement {

    protected abstract String header(Customer aCustomer);
    protected abstract String eachLine(Rental aRental);
    protected abstract String footer(Customer aCustomer);
}