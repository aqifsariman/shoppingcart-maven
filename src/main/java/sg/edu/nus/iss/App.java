package sg.edu.nus.iss;

import java.io.Console;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        String dirPath = "\\data";
        String filename = "";
        File newDirectory = new File(dirPath);

        if (!newDirectory.exists()) {
            newDirectory.mkdir();
        } else {
            System.out.println("Directory already exists.");
        }
        System.out.println("Welcome to my shopping cart.");

        List<String> cartItems = new ArrayList<>();

        Console cons = System.console();

        String input = "";
        while (!input.equals("quit")) {
            input = cons.readLine("What do you want to perform? (Type 'quit' if you want to exit the program.)\n");

            switch (input) {
                case "help":
                    System.out.println("'list' to show a list of items in your shopping cart.");
                    System.out.println("'login' <name> to access your shopping cart.");
                    System.out.println("'add' <item> to your shopping cart.");
                    System.out.println("'delete' to show a list of items in your shopping cart.");
                    System.out.println("'quit' to exit this program.");
                    break;
                case "list":
                    if (cartItems.size() > 0) {
                        for (String item : cartItems) {
                            System.out.printf("%d. %s\n", cartItems.indexOf(item) + 1, item);
                        }
                    } else {
                        System.out.println("Cart is empty.");
                    }
                    break;
                case "users":
                    break;
                default:
            }

            if (input.startsWith("add")) {
                input = input.replace(",", " ");
                Scanner scan = new Scanner(input.substring(4));
                String strValue = "";

                while (scan.hasNext()) {
                    strValue = scan.next();
                    cartItems.add(strValue);
                    System.out.printf("%s added to cart.\n", strValue);
                }

            }
        }

    }
}
