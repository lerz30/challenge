package main.calculate;

import main.mapper.ProductMapper;
import main.pojo.Product;
import main.pojo.Receipt;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Calculate {

    private static final Double EXCHANGE_RATE = 1.11;

    public Receipt calculateTotal(HashMap userInput){

        Receipt receipt = new Receipt();

        Double subtotal = 0.0;
        Double savings = 0.0;
        Double total = 0.0;
        List<Product> shoppingBasket = calculateTotalPricePerElement(ProductMapper.createProductsList(userInput));
        if(shoppingBasket!=null && shoppingBasket.size()>0){
            for(Product x : shoppingBasket){
                subtotal += x.getSubtotal();
                savings += x.getSavings();
                total += x.getTotal();
            }
        }else{
            return null;
        }
        DecimalFormat formatter = new DecimalFormat("#.##");
        receipt.setSubtotal(formatter.format(subtotal));
        receipt.setSavings(formatter.format(savings));
        receipt.setTotal(formatter.format(total));

        return receipt;
    }

    private List<Product> calculateTotalPricePerElement(List<Product> shoppingBasket){
        List<Product> result = new ArrayList<>();
        if(shoppingBasket!=null && shoppingBasket.size()>0){
            Product productSoup = shoppingBasket.stream().filter(x -> x.getName().toLowerCase().equals("soup")).findFirst().orElse(null);

            for(Product x : shoppingBasket){
                if(!x.getName().toLowerCase().equals("bread")){
                    if(x.getDiscount()>0){
                        if(x.getCurrency().equals("£")){
                            performOperations(x, true,true);
                        } else{
                            performOperations(x, true, false);
                        }
                    } else {
                        if(x.getCurrency().equals("£")){
                            performOperations(x, false, true);
                        } else{
                            performOperations(x, false, false);
                        }
                    }
                } else{
                    if(productSoup!=null && productSoup.getQuantity()>=2){
                        if(x.getQuantity()<=productSoup.getQuantity()/2){
                            performOperations(x, true, true);
                        } else{
                            breadDiscount(x, productSoup.getQuantity()/2);
                        }
                    } else{
                        performOperations(x, false, true);
                    }
                }
                result.add(x);
            }
        } else{
            return null;
        }
        return result;
    }

    private void performOperations(Product product, boolean discount, boolean exchange){
        if(exchange){
            product.setSubtotal(poundsToEuros(product.getPrice()*product.getQuantity()));
        } else{
            product.setSubtotal(product.getPrice()*product.getQuantity());
        }
        if(discount){
            product.setSavings(product.getSubtotal()*(product.getDiscount()/100.00));
        } else{
            product.setSavings(0.0);
        }
        product.setTotal(product.getSubtotal()-product.getSavings());
    }

    private void breadDiscount(Product product, int partial){
        product.setSubtotal(poundsToEuros(product.getPrice()*product.getQuantity()));
        product.setSavings(poundsToEuros(product.getPrice() * partial) * (product.getDiscount()/100.00));
        product.setTotal(product.getSubtotal()-product.getSavings());
    }

    private Double poundsToEuros(Double subtotal){
        return subtotal*EXCHANGE_RATE;
    }
}
