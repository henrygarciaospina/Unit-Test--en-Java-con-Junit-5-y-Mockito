package com.example.unitest.unitest.junit5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;
    private Calculator calculatorNull;

    @BeforeEach
    void SetUp(){
        calculator = new Calculator();
        System.out.println("@BeforeEach -> setUp()");
    }

    @AfterEach
    void tearDown(){
        calculator = null;
        System.out.println("@AfterEach -> tearDown()");
    }

    @Test
    void calculatorNotNullTest(){
        assertNotNull(calculator, "Calculator debe ser not null");
        System.out.println("@Test -> calculatorNotNullTest()");
    }

    @Test
    void calculatorNullTest(){
        assertNull(calculatorNull);
        System.out.println("@Test -> calculatorNullTest()");
    }

    /*
       Método a Probar        Entrada             Salida esperada
       add(unt a, int b)      a = 10, b = 20          30
     */

    @Test
    void addAssert(){
        //1.- Setup
        int resultadoEsperado = 30;
        int resultadoActual;
        //2.- Action
        resultadoActual = calculator.add(10,20);
        //3.- Assert
        assertEquals(resultadoEsperado, resultadoActual);
        System.out.println("@Test -> addAssertTest()");
    }

    @Test
    void addTest(){
        assertEquals(30, calculator.add(10,20));
    }

    // Debería ir un solo assert en la prueba
    @Test
    void assertTypesTest(){
        assertTrue(1 == 1);
//      assertTrue(1 == 2);

        assertNull(calculatorNull);
        assertNotNull(calculator);

        Calculator calculator1 = new Calculator();
        Calculator calculator2 = new Calculator();
        Calculator calculator3 = calculator1;

        assertSame(calculator1, calculator3);
        //assertSame(calculator1, calculator2);

        assertNotSame(calculator1, calculator2);
        //assertNotSame(calculator1, calculator3);

        //assertEquals("henry", "henr", "Ha fallado nuestro método String");

        //0.5 es la cantidad de diferencia permitida entre lo actual y lo esperado
        assertEquals(1, 1.4, 0.5);
        assertEquals(1, 1.6, 0.5, "La diferencia entre el valor actual y el esperado supera el valor de tolerancia 0.5");
    }
}
