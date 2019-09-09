package ru.norma.test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

class CalculatorTest {

    private Calculator calculator;

    static Stream<Arguments> intProvider() {
        return Stream.of(Arguments.of(100,200), Arguments.of(5,6));
    }

    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

/*
    можно запускать тесты по тэгу (для экономии времени, когда не нужен полный прогон)
    для этого в pom-файле в плагине maven-surefire-plugin добавляем
    <properties>
        <includeTags>critical</includeTags>
        <excludeTags>slow</excludeTags>
    </properties>
    где critical, это указаннный тэг в аннотации @Tag
*/
    @Test
    @Tag("critical")
    @DisplayName("Верное сложение двух положительных")
    void addTwoPositiveResPos() {
        assertEquals(calculator.add(1, 6), 7);
    }

    @Test
    @Tag("slow")
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

    //зависимость junit-jupiter-params
    //Если необходимо протестировать один и тот же метод с разными параметрами
    @ParameterizedTest
    @DisplayName("Мультипараметры")
    //CsvSource - какой набор параметров передаётся в x и y
    @CsvSource({"1,2", "3,4", "-5, 10"})
    void addMultiParametersResPos(int x, int y) {
        assertTrue(calculator.add(x, y) > 0 );
    }

    //Если же параметры заранее неизвестны, то
    @ParameterizedTest
    @DisplayName("Динамические мультипараметры")
    @MethodSource("intProvider")
    void addDynamicMultiParametersResPos(int x, int y) {
        assertTrue(calculator.add(x, y) > 0 );
    }

    @Nested
    class DiffTests {

        @Test
        @DisplayName("Верная разность двух положительных")
        void diffTwoPositiveResPos() {
            assertEquals(calculator.diff(1, 6), -5);
        }

        @Test
        @DisplayName("Неверная разность двух положительных")
        void diffTwoPositiveResNeg() {
            //запускать тест, только при выполнении условия, в данном случае, количество процессоров от 4
            //иначе тест игнорируется
            Assumptions.assumeTrue(Runtime.getRuntime().availableProcessors() >= 4);

            assertNotEquals(calculator.diff(1, 6), 5);
        }

        //автоматическая генерация тестов
        @TestFactory
        Stream<DynamicTest> dynamicTests() {
            return Stream.generate(Math::random)
                    .limit(100)
                    .mapToInt(v -> (int) (v * 1000))
                    .mapToObj( i -> dynamicTest("test diff operation for value " + i,
                            () -> assertTrue(calculator.diff(i, i) == 0)));
        }

    }

    //проверяем, что метод выбрасывает исключение при некорректных данных (деление на нуль)
    @Test
    void divideSecondZeroExceptionThrow() {
        Exception ex = assertThrows(Exception.class, () -> calculator.divide(5,0));
        assertEquals(ex.getMessage(), "/ by zero", "Invalid error message received");
    }
}
