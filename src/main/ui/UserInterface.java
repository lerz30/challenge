package main.ui;

import main.calculate.Calculate;
import main.pojo.Receipt;
import main.util.Messages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class UserInterface {

    public static void greetUser() throws IOException {
        boolean nextItem = true;
        HashMap userInput = new HashMap();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(Messages.WELCOME_MESSAGE);
        while(nextItem){
            System.out.println(Messages.USER_INTERACTION_CODE);
            String code = reader.readLine();
            if(code.toLowerCase().equals("soup")||code.toLowerCase().equals("bread")||code.toLowerCase().equals("milk")||code.toLowerCase().equals("apple")
                    ||code.toLowerCase().equals("peanuts")||code.toLowerCase().equals("banana")){
                System.out.println(Messages.USER_INTERACTION_QUANTITY);
                int quantity = Integer.parseInt(reader.readLine());
                userInput.put(code.toUpperCase(), quantity);
            } if(code.equals("x")||code.equals("X")){
                nextItem = false;
                System.out.println(Messages.SHOW_SHOPPING_CART + userInput);
            }
        }
        System.out.println(printReceipt(userInput));
    }

    public static String printReceipt(HashMap userInput){
        final Calculate calculate = new Calculate();
        Receipt receipt = calculate.calculateTotal(userInput);
        if(receipt!=null){
            return String.format(Messages.OUTPUT_MESSAGE, receipt.getSubtotal(), receipt.getSavings(), receipt.getTotal());
        } else{
            return Messages.GENERIC_ERROR;
        }

    }

}
