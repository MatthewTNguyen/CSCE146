package Apple;

public class Apple {
	 // ---------- Instance variables (all private) ----------
    private String type;    // type must be one of: "Red Delicious", "Golden Delicious", "Gala", "Granny Smith"
    private double weight;  // weight in kilograms, range [0.0, 2.0]
    private double price;   // price per apple, non-negative

    // ---------- Default values ----------
    private static final String DEFAULT_TYPE = "Gala";
    private static final double DEFAULT_WEIGHT = 0.0;
    private static final double DEFAULT_PRICE = 0.0;

    // ---------- Constructors ----------

    /**
     * Default constructor - sets all instance variables to their default values.
     */
    public Apple() {
        // Use mutators or direct assignment through validation helpers
        this.type = DEFAULT_TYPE;
        this.weight = DEFAULT_WEIGHT;
        this.price = DEFAULT_PRICE;
    }

    /**
     * Parameterized constructor - validates inputs before assignment.
     * If a parameter is invalid, the corresponding default value is assigned.
     *
     * @param type   the apple type (must be one of the allowed types and non-null)
     * @param weight the weight in kilograms (must be between 0.0 and 2.0 inclusive)
     * @param price  the price per apple (must be non-negative)
     */
    public Apple(String type, double weight, double price) {
        if (isValidType(type)) {
            this.type = type;
        } else {
            this.type = DEFAULT_TYPE;
        }

        if (isValidWeight(weight)) {
            this.weight = weight;
        } else {
            this.weight = DEFAULT_WEIGHT;
        }

        if (isValidPrice(price)) {
            this.price = price;
        } else {
            this.price = DEFAULT_PRICE;
        }
    }

    // ---------- Validation helper methods (private) ----------

    /**
     * Checks whether the provided type is one of the allowed types (and non-null).
     *
     * @param t candidate type
     * @return true if t is valid, false otherwise
     */
    private static boolean isValidType(String t) {
        if (t == null) return false;
        return t.equals("Red Delicious")
                || t.equals("Golden Delicious")
                || t.equals("Gala")
                || t.equals("Granny Smith");
    }

    /**
     * Checks whether the provided weight is within [0.0, 2.0].
     *
     * @param w candidate weight
     * @return true if w is valid, false otherwise
     */
    private static boolean isValidWeight(double w) {
        return w >= 0.0 && w <= 2.0;
    }

    /**
     * Checks whether the provided price is non-negative.
     *
     * @param p candidate price
     * @return true if p is valid, false otherwise
     */
    private static boolean isValidPrice(double p) {
        return p >= 0.0;
    }

    // ---------- Accessors (getters) ----------

    /**
     * Returns the apple type.
     *
     * @return type
     */
    public String getType() {
        return this.type;
    }

    /**
     * Returns the apple weight (kg).
     *
     * @return weight
     */
    public double getWeight() {
        return this.weight;
    }

    /**
     * Returns the apple price.
     *
     * @return price
     */
    public double getPrice() {
        return this.price;
    }

    // ---------- Mutators (setters) ----------
    // Each mutator validates input; if invalid, sets the corresponding default value.

    /**
     * Sets the apple type if valid; otherwise sets default type.
     *
     * @param type new type
     */
    public void setType(String type) {
        if (isValidType(type)) {
            this.type = type;
        } else {
            this.type = DEFAULT_TYPE;
        }
    }

    /**
     * Sets the apple weight if valid; otherwise sets default weight.
     *
     * @param weight new weight (kg)
     */
    public void setWeight(double weight) {
        if (isValidWeight(weight)) {
            this.weight = weight;
        } else {
            this.weight = DEFAULT_WEIGHT;
        }
    }

    /**
     * Sets the apple price if valid; otherwise sets default price.
     *
     * @param price new price
     */
    public void setPrice(double price) {
        if (isValidPrice(price)) {
            this.price = price;
        } else {
            this.price = DEFAULT_PRICE;
        }
    }

    // ---------- toString ----------
    /**
     * Returns the string representation in the required format:
     * Type: <<apple’s name>> Weight <<apple’s weight>> Price <<apple’s price>>
     *
     * @return formatted String
     */
    public String toString() {
        return "Type: " + this.type + " Weight " + this.weight + " Price " + this.price;
    }

    // ---------- equals ----------
    /**
     * Compares this apple to another apple based on all instance variables.
     * Uses exact string comparison for type and numeric comparison for weight/price.
     *
     * @param other another Apple instance to compare to
     * @return true if all instance variables are equal, false otherwise
     */
    public boolean equals(Apple other) {
        if (other == null) return false;
        // Compare type strings (they must match exactly)
        if (!this.type.equals(other.type)) return false;
        // Compare doubles with exact equality (these are stored values)
        if (Double.compare(this.weight, other.weight) != 0) return false;
        if (Double.compare(this.price, other.price) != 0) return false;
        return true;
    }
}
