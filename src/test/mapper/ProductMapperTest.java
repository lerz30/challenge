package test.mapper;

import main.mapper.ProductMapper;
import main.pojo.Product;
import org.junit.Assert;
import org.junit.Test;
import test.util.CreateHashMap;

import java.util.*;

import static org.junit.Assert.*;

public class ProductMapperTest {

    @Test
    public void createProductsListOK() {
        HashMap userInput = CreateHashMap.generateUserInput();
        List<Product> productList = ProductMapper.createProductsList(userInput);
        Assert.assertNotNull(productList);
    }

    @Test
    public void createProductsListKO_1() {
        HashMap userInput = null;
        List<Product> productList = ProductMapper.createProductsList(userInput);
        Assert.assertNull(productList);
    }



}
