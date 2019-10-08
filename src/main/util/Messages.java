package main.util;

public class Messages {

    public static final String WELCOME_MESSAGE = "WELCOME TO YOUR LOCAL SHOP!\n" +
            "\n" +
            "Here is the list of available products with their prices\n" +
            "\n" +
            "****************PRODUCTS****************\n" +
            "* Code     Name       Price            *\n" +
            "* 1        Soup       65p per tin      *\n" +
            "* 2        Bread      80p per loaf     *\n" +
            "* 3        Milk       1.30 per bottle  *\n" +
            "* 4        Apples     1.00 per bag     *\n" +
            "* 5        Peanuts    2€ per bag       *\n" +
            "* 6        Banana     1.20€ per bag    *\n" +
            "****************************************\n" +
            "\n" +
            "Current special offers:\n" +
            "\n" +
            "Apples have 10% discount off their normal price. Just this week!!\n" +
            "Buy 2 tins of soup and get a loaf of bread for falf price";

    public static final String USER_INTERACTION_CODE = "\n\nPlease, type the name of the product you wish to add to your basket or type X to finish your purchase";

    public static final String USER_INTERACTION_QUANTITY = "\nPlease, insert the quantity";

    public static final String USER_INTERACTION_ERROR = "\nInvalid product code. Please type a valid code";

    public static final String GENERIC_ERROR = "\nSomething went wrong. Please try again later";

    public static final String SHOW_SHOPPING_CART = "\nHere is your shopping cart: \n";

    public static final String OUTPUT_MESSAGE = "\nSubtotal: '%1$s'€\n" +
            "Your savings in this purchase: '%2$s'€\n" +
            "Total: '%3$s'€";
}
