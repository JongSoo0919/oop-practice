package org.example.calculate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

/**
 * - 요구사항
 *     1. 간단한 사칙연산을 할 수 있다.
 *     2. 양수로만 계산할 수 있다.
 *     3. 나눗셈에서 0을 나누는 경우 IllegalArugment 예외를 발생시킨다.
 *     4. MVC 패턴(Model-View-Controller) 기반으로 구현한다.
 */
public class CalculatorTest {
    @DisplayName("덧셈 연산을 수행한다")
    @Test
    void additionalTest(){
        int result = Calculator.calculate(new PositiveNumber(1), "+", new PositiveNumber(2));
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("받은 파라미터를 통해 사칙연산을 수행한다")
    @ParameterizedTest
    @MethodSource("formulaAndResult")
    void calculatorTest(PositiveNumber operand1, String operator, PositiveNumber operand2, int result){
        int answer = Calculator.calculate(operand1, operator, operand2);

        assertThat(answer).isEqualTo(result);
    }
    private static Stream<Arguments> formulaAndResult(){
        return Stream.of(
                arguments(new PositiveNumber(1), "+", new PositiveNumber(2), 3),
                arguments(new PositiveNumber(1), "-", new PositiveNumber(2), -1),
                arguments(new PositiveNumber(4), "*", new PositiveNumber(2), 8),
                arguments(new PositiveNumber(4), "/", new PositiveNumber(2), 2)
        );
    }


    /**
     * 해당 테스트는 PositiveNumber 객체가 생겼고, PositiveNumber 객체에 의하여 Calculate의 operand 변수는 무조건 양수 임이 보장되므로
     * CalculatorTest 보다는 PositiveTest에서 따로 체크해주는 것이 좋음
     */
//    @DisplayName("0으로는 나눌 수 없다.")
//    @Test
//    void calculateExceptionTest(){
//        assertThatCode(() -> Calculator.calculate(new PositiveNumber(10), "/", new PositiveNumber(0)))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage("0으로는 나눌 수 없습니다.");
//    }
}
