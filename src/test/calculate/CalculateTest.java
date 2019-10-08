package test.calculate;

import main.calculate.Calculate;
import main.pojo.Receipt;
import org.junit.Assert;
import org.junit.Test;
import test.util.CreateHashMap;

import java.util.HashMap;

public class CalculateTest {

    @Test
    public void calculateTotalOK() {
        HashMap userInput = CreateHashMap.generateUserInput();
        Calculate calculate = new Calculate();
        Receipt receipt = calculate.calculateTotal(userInput);
        Assert.assertNotNull(receipt);
    }

    @Test
    public void calculateTotalKO() {
        HashMap userInput = null;
        Calculate calculate = new Calculate();
        Receipt receipt = calculate.calculateTotal(userInput);
        Assert.assertNull(receipt);
    }

}
