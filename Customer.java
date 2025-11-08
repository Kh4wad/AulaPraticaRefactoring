import java.util.Enumeration;
import java.util.Vector;

public class Customer {
   private String _name;
   private Vector _rentals = new Vector();

   public Customer (String name){
      _name = name;
   }

   public void addRental(Rental arg) {
      _rentals.addElement(arg);
   }
   
   public String getName (){
      return _name;
   }
   
     public String statement() {
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
           Rental each = (Rental) rentals.nextElement();

           // show figures for this rental
           result += "\t" + each.getMovie().getTitle()+ "\t" +
              String.valueOf(each.getCharge()) + "\n";
        }
        //add footer lines
        result +=  "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) +
                " frequent renter points";
        return result;
      }

   public String htmlStatement() {
      Enumeration rentals = _rentals.elements();
      String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";
      while (rentals.hasMoreElements()) {
         Rental each = (Rental) rentals.nextElement();
         // show figures for each rental
         result += each.getMovie().getTitle()+ ": " +
            String.valueOf(each.getCharge()) + "<BR>\n";
      }
      // add footer lines
      result +=  "<P>You owe <EM>" + String.valueOf(getTotalCharge()) + "</EM><P>\n";
      result += "On this rental you earned <EM>" +
            String.valueOf(getTotalFrequentRenterPoints()) +
            "</EM> frequent renter points<P>";
      return result;
   }

      private double getTotalCharge() {
         double result = 0;
         Enumeration rentals = _rentals.elements();
         while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
         }
         return result;
      }

      private int getTotalFrequentRenterPoints() {
         int result = 0;
         Enumeration rentals = _rentals.elements();
         while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRenterPoints();
         }
         return result;
      }

      /* 
   public static void main(String[] args) {
      // Create a customer
      Customer customer = new Customer("John Doe");

      // Create some movies
      Movie movie1 = new Movie("The Matrix", Movie.REGULAR);
      Movie movie2 = new Movie("Star Wars", Movie.NEW_RELEASE);
      Movie movie3 = new Movie("Toy Story", Movie.CHILDRENS);

      // Create rentals
      customer.addRental(new Rental(movie1, 3));  // Regular movie for 3 days
      customer.addRental(new Rental(movie2, 2));  // New release for 2 days
      customer.addRental(new Rental(movie3, 4));  // Children's movie for 4 days

      // Print both statement formats
      System.out.println("PLAIN TEXT STATEMENT:");
      System.out.println(customer.statement());
      System.out.println("\nHTML STATEMENT:");
      System.out.println(customer.htmlStatement());
   }

   */
}

