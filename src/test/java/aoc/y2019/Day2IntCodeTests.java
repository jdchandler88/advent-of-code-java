package aoc.y2019;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Day2IntCodeTests {

  @ParameterizedTest
  @MethodSource("part1Data")
  public void shouldReturnAppropriateValue_Part1(int[] input, int[] expected) {
    new Day1IntCodeComputer().run1(input);
    Assertions.assertArrayEquals(expected, input);
  }

  /**
   * Provides data to the "shouldReturnAppropriateValue_Part1" test method. The data is gathered
   * from the spec in AdventOfCode
   * @return stream of arguments to supply to the parameterized test
   */
  public static Stream<Arguments> part1Data() {
    return Stream.of(
        Arguments.of(new int[] {1, 9, 10, 3, 2, 3, 11, 0, 99, 30, 40, 50},
            new int[] {3500, 9, 10, 70, 2, 3, 11, 0, 99, 30, 40, 50}),
        Arguments.of(new int[] {1, 0, 0, 0, 99}, new int[] {2, 0, 0, 0, 99}),
        Arguments.of(new int[] {2, 3, 0, 3, 99}, new int[] {2, 3, 0, 6, 99}),
        Arguments.of(new int[] {2, 4, 4, 5, 99, 0}, new int[] {2, 4, 4, 5, 99, 9801}),
        Arguments
            .of(new int[] {1, 1, 1, 4, 99, 5, 6, 0, 99}, new int[] {30, 1, 1, 4, 2, 5, 6, 0, 99})
    );
  }

}
