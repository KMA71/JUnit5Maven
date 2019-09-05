package ru.norma.test;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setup() {calculator = new Calculator();}

    @Test
    public void addTwoPositiveResPos() {assertEquals(calculator.add(1,6), 7);}

    @Test
    public void addTwoPositiveResNeg() {assertNotEquals(calculator.add(1,6), 5);}

    @Test
    public void addTwoNegativeResPos() {assertEquals(calculator.add(-10, -5), -15);}

    @Test
    public void addTwoNegativeResNeg() {assertNotEquals(calculator.add(-10, -5), -5);}

    @Test
    public void addOppositeResPos() {assertEquals(calculator.add(-5, 11), 6);}

    @Test
    public void addOppositeResNeg() {assertNotEquals(calculator.add(5, -11), 17);}


    @Test
    public void diffTwoPositiveResPos() {assertEquals(calculator.diff(1,6), -5);}

    @Test
    public void diffTwoPositiveResNeg() {assertNotEquals(calculator.diff(1,6), 5);}

    @Test
    public void diffTwoNegativeResPos() {assertEquals(calculator.diff(-10, -5), -5);}

    @Test
    public void diffTwoNegativeResNeg() {assertNotEquals(calculator.add(-10, -5), -5);}

    @Test
    public void diffOppositeResPos() {assertEquals(calculator.diff(-5, 11), -16);}

    @Test
    public void diffOppositeResNeg() {assertNotEquals(calculator.add(5, -11), -16);}


//    @Test
//    public void sum
}
