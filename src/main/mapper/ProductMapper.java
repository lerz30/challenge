package main.mapper;

import main.pojo.Product;
import java.util.*;

public class ProductMapper {

    private static final String SOUP = "SOUP";
    private static final String BREAD = "BREAD";
    private static final String MILK = "MILK";
    private static final String APPLES= "APPLES";
    private static final String PEANUTS = "PEANUTS";
    private static final String BANANA = "BANANA";

    public static List<Product> createProductsList(HashMap userInput){
        List<Product> result = new ArrayList<>();

        if(userInput==null || userInput.isEmpty()){
            return null;
        }

        Set set = userInput.entrySet();
        Iterator iterator = set.iterator();
        while ((iterator.hasNext())){
            Map.Entry mapEntry = (Map.Entry)iterator.next();
            if(mapEntry.getKey().equals(SOUP)){
                result.add(createProduct("1", mapEntry.getValue().toString(), "Tin", "£", 0.65, Integer.parseInt(mapEntry.getValue().toString()), 0));
            }
            if(mapEntry.getKey().equals(BREAD)){
                result.add(createProduct("2", mapEntry.getValue().toString(), "Loaf", "£", 0.80, Integer.parseInt(mapEntry.getValue().toString()), 50));
            }
            if(mapEntry.getKey().equals(MILK)){
                result.add(createProduct("3", mapEntry.getValue().toString(), "Bottle", "£", 1.30, Integer.parseInt(mapEntry.getValue().toString()), 0));
            }
            if(mapEntry.getKey().equals(APPLES)){
                result.add(createProduct("4", mapEntry.getValue().toString(), "Bag", "£", 1.00, Integer.parseInt(mapEntry.getValue().toString()), 10));
            }
            if(mapEntry.getKey().equals(PEANUTS)){
                result.add(createProduct("5", mapEntry.getValue().toString(), "Bag", "€", 2.00, Integer.parseInt(mapEntry.getValue().toString()), 0));
            }
            if(mapEntry.getKey().equals(BANANA)){
                result.add(createProduct("6", mapEntry.getValue().toString(), "Bag", "€", 1.20, Integer.parseInt(mapEntry.getValue().toString()), 0));
            }
        }
        return result;

    }

    private static Product createProduct(String code, String name, String unit, String currency, Double price, int quantity, int discount){
        Product product = new Product();
        product.setCode(code);
        product.setName(name);
        product.setUnit(unit);
        product.setCurrency(currency);
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setDiscount(discount);
        return product;
    }

}
