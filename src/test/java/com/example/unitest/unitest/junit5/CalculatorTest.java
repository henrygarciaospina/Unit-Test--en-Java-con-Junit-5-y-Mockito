package com.example.unitest.unitest.junit5;

import org.junit.jupiter.api.*;

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
    void assertTypesTest() {
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
        //assertEquals(1, 1.6, 0.5, "La diferencia entre el valor actual y el esperado supera el valor de tolerancia 0.5");

    }

    @Test
    void addValidInputValidExpectedTest(){
        assertEquals(11, calculator.add(7,4));
    }

    @Test
    void subtractValidInputValidExpectedTest(){
        assertEquals(11, calculator.subtract(15,4));
    }

    @Test
    void dividedValidInputValidExpectedTest(){
        assertEquals(2, calculator.divided(10,5));
    }

/*
    @Test
    void dividedInvalidInputTest(){
        fail("Fallo detectado manualmente - No se puede dividir entre cero");
        calculator.divided(10,0);
    }
*/
    @Test
    void dividedInvalidInputExpectedExceptionTest(){
        assertThrows(ArithmeticException.class, ()-> calculator.dividedByZero(2,0), "No se puede dividir entre cero");
    }

    @Disabled("Disabled until bug 23 be resolved")
    @Test
    void dividedInvalidInputTest(){
        assertEquals(2,calculator.divided(5,0));
    }

    @Test
    @DisplayName("Método divided --> funciona")
    void dividedValidInputValidExpectedNameTest(){
        assertEquals(2, calculator.divided(10,5));
    }

    @Test
    void addAssertAllTest(){
       assertAll(
               ()-> assertEquals(31, calculator.add(11,20)),
               ()-> assertEquals(20, calculator.subtract(20,10)),
               ()-> assertEquals(5, calculator.divided(45,9))
       );
    }

}