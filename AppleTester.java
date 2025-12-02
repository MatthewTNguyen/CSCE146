package Apple;


public class AppleTester {

    /**
     * Entry point. Creates apples and demonstrates required features.
     *
     * @param args command-line args (not used)
     */
    public static void main(String[] args) {
        // Construct apples
        Apple defaultApple = new Apple(); // default constructor
        Apple validApple = new Apple("Granny Smith", 0.15, 0.50); // valid parameterized
        Apple invalidApple = new Apple("Pink Lady", -1.0, -5.0); // invalid params -> should fall back to defaults

        // Show initial states using toString (demonstrates default and parameterized constructors)
        System.out.println("Initial apples:");
        printApple("defaultApple", defaultApple);
        printApple("validApple", validApple);
        printApple("invalidApple", invalidApple);

        // Demonstrate accessors
        System.out.println("\nAccessors demonstration:");
        System.out.println("validApple type via getType(): " + validApple.getType());
        System.out.println("validApple weight via getWeight(): " + validApple.getWeight());
        System.out.println("validApple price via getPrice(): " + validApple.getPrice());

        // Demonstrate mutators - change values, including an invalid change
        System.out.println("\nMutators demonstration:");
        System.out.println("Setting defaultApple to a valid type, weight, price...");
        defaultApple.setType("Red Delicious");
        defaultApple.setWeight(0.2);
        defaultApple.setPrice(0.75);
        printApple("defaultApple (after valid sets)", defaultApple);

        System.out.println("Attempting to set validApple to invalid values (should revert to defaults)...");
        validApple.setType(null);       // invalid -> default
        validApple.setWeight(5.0);     // invalid -> default
        validApple.setPrice(-10.0);    // invalid -> default
        printApple("validApple (after invalid sets)", validApple);

        // Demonstrate equals
        System.out.println("\nEquals demonstration:");
        Apple a1 = new Apple("Gala", 0.0, 0.0);
        Apple a2 = new Apple("Gala", 0.0, 0.0);
        Apple a3 = new Apple("Gala", 0.001, 0.0);

        System.out.println("a1: " + a1.toString());
        System.out.println("a2: " + a2.toString());
        System.out.println("a3: " + a3.toString());

        System.out.println("a1.equals(a2) ? " + a1.equals(a2)); // expected true
        System.out.println("a1.equals(a3) ? " + a1.equals(a3)); // expected false

        // Additional check: equals with null
        System.out.println("a1.equals(null) ? " + a1.equals(null)); // expected false
    }

    /**
     * Helper method to print a label and an Apple object's toString.
     * Keeps main method shorter and improves readability.
     *
     * @param label label for the apple
     * @param a     Apple instance to print
     */
    private static void printApple(String label, Apple a) {
        System.out.println(label + " -> " + a.toString());
    }
}
