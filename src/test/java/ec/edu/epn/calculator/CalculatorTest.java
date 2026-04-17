package ec.edu.epn.calculator;

import org.junit.Test;

import junit.framework.Assert;

public class CalculatorTest {

    @Test
    public void testSum() {

        Calculator calculator = new Calculator();
        int result = calculator.sum(2, 2);
        if (result !=4) {
            Assert.fail();  
        }
    }

}

