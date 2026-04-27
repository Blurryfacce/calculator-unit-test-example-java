package ec.edu.epn.calculator;

import static org.junit.jupiter.api.Assertions.*;

// Fíjate cómo ahora los imports dicen "jupiter", que es el nombre clave de JUnit 5
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

    private Calculator calculator;

    // Aquí está el BeforeEach que pidió el profesor
    @BeforeEach
    public void setUp() {
        // Arrange
        calculator = new Calculator();
    }

    // Arrange
    // Act
    // Assert

    @Test
    @DisplayName("Addition of two positive numbers")
    public void testSum() {
        // // Arrange + Act 
        // int result = calculator.sum(2, 2);
        // // Assert
        // assertEquals(4, result);

        assertAll("Suma valores en varios casos",
            () -> {
                int resultado = calculator.sum(2, 2);
                assertEquals(4, resultado);
            },
            () -> {
                int resultado = calculator.sum(-1, 1);
                assertEquals(0, resultado);
            }


        );
          
    }

    @Test
    public void testSum2(){
        int result = calculator.sum(4, 6);
        assertEquals(10, result);
    }

    @ParameterizedTest
    @CsvSource({
        "2, 1, 3",
        "0, 5, 5",
        "-1, 2, 1"
    })
    public void testSumMultipleData(int a, int b, int expected){
        //Arrange + Act
        int result = calculator.sum(a, b);
        //Assert
        assertEquals(expected, result);
        
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 5, 10, 100 ,-1})
    public void testSumWithFixedValues(int value){
        // Arrange + Act
        int result = calculator.sum(value, 0);
        //Assert
        assertTrue(result == value);

    }

    @Test
    public void testDivideSuccess() {
         // Arrange + Act 
        int result = calculator.divide(10, 2);
          // Assert
        assertEquals(5, result);
    }

    @Test
    public void testDivideFail() {
        // En JUnit 5, así se verifica el error. 
        // Le decimos: "Asegúrate de que lanzar este error (ArithmeticException) al ejecutar esta función"
         // Arrange + Act 
        assertThrows(ArithmeticException.class, () -> {
        // Assert
            calculator.divide(10, 0);
        });
    }

    @Test
    public void testMultiply() {
         // Arrange + Act 
        int result = calculator.multiply(3, 4);
        // Assert
        assertEquals(12, result);
    }
}