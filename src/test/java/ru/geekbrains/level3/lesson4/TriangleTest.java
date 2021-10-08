package ru.geekbrains.level3.lesson4;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.provider.Arguments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.level3.lession4.Triangle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TriangleTest {

    private static Logger logger = LoggerFactory.getLogger(TriangleTest.class);
    @BeforeAll
    static void loggingOn() {
        logger.debug("logging information");
    }

    // data set for test method isTriangleExist
    private static Stream<Arguments> isTriangleExistTestDataSet (){
        return Stream.of(
                Arguments.arguments(new Triangle(2,3,4), true),
                Arguments.arguments(new Triangle(3,4,5), true),
                Arguments.arguments(new Triangle(1,2,3), false),
                Arguments.arguments(new Triangle(1,0,3), false),
                Arguments.arguments(new Triangle(1,-2,3), false)
        );
    }

    @ParameterizedTest
    @DisplayName("check isTriangleExist method with 2 good and 3 bad datasets")
    @MethodSource("isTriangleExistTestDataSet")
    void testIsTriangleExist(Triangle triangle, boolean result){
        Assertions.assertEquals(result, triangle.isTriangleExist());
    }



    // data set for method squareOfTriangle
    private static Stream<Arguments> squareOfTriangleTestDataSet (){
        return Stream.of(
                Arguments.arguments(new Triangle(2,3,4), 2.9047375096555625),
                Arguments.arguments(new Triangle(3,4,5), 6.0),
                Arguments.arguments(new Triangle(3,0,5), 6.0)
        );
    }

    @ParameterizedTest
    @DisplayName("check if triangle square formula is ok")
    @MethodSource("squareOfTriangleTestDataSet")
    void isSquareOfTriangleTest(Triangle triangle, double result){
        Assumptions.assumeTrue(triangle.isTriangleExist());
        Assertions.assertEquals(result, triangle.squareOfTriangle());
    }

}
