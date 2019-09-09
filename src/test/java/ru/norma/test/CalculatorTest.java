package ru.norma.test;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Верное сложение двух положительных")
    void addTwoPositiveResPos() {
        assertEquals(calculator.add(1, 6), 7);
    }

    @Test
    @DisplayName("Неверное сложение двух положительных")
    void addTwoPositiveResNeg() {
        assertNotEquals(calculator.add(1, 6), 5);
    }

    @Test
    @DisplayName("Верное сложение двух отрицательных")
    void addTwoNegativeResPos() {
        assertEquals(calculator.add(-10, -5), -15);
    }

    @Test
    @DisplayName("Неверное сложение двух отрицательных")
    void addTwoNegativeResNeg() {
        assertNotEquals(calculator.add(-10, -5), -5);
    }

    @Test
    @DisplayName("Верное сложение чисел с разным знаком")
    void addOppositeResPos() {
        assertEquals(calculator.add(-5, 11), 6);
    }

    @Test
    @DisplayName("Неверное сложение чисел с разным знаком")
    void addOppositeResNeg() {
        assertNotEquals(calculator.add(5, -11), 17);
    }


    @Test
    @DisplayName("Верная разность двух положительных")
    void diffTwoPositiveResPos() {
        assertEquals(calculator.diff(1, 6), -5);
    }

    @Test
    @DisplayName("Неверная разность двух положительных")
    void diffTwoPositiveResNeg() {
        assertNotEquals(calculator.diff(1, 6), 5);
    }

    @Test
    @DisplayName("Верная разность двух отрицательных")
    void diffTwoNegativeResPos() {
        assertEquals(calculator.diff(-10, -5), -5);
    }

    @Test
    @DisplayName("Неверная разность двух отрицательных")
    void diffTwoNegativeResNeg() {
        assertNotEquals(calculator.add(-10, -5), -5);
    }

    @Test
    @DisplayName("Верная разность чисел с разным знаком")
    void diffOppositeResPos() {
        assertEquals(calculator.diff(-5, 11), -16);
    }

    @Test
    @DisplayName("Неверная разность чисел с разным знаком")
    void diffOppositeResNeg() {
        assertNotEquals(calculator.add(5, -11), -16);
    }

}
