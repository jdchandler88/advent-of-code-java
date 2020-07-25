package aoc.y2019;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Day1FuelCalculatorTests {

  @ParameterizedTest
  @CsvSource({"12, 2", "14, 2", "1969, 654", "100756, 33583"})
  public void shouldReturnProperMass_part1(int mass, int requiredFuel) {
    assertEquals(Day1FuelCalculator.calculateFuel1(mass), requiredFuel);
  }

  @ParameterizedTest
  @CsvSource({"14, 2", "1969, 966", "100756, 50346"})
  public void shouldReturnProperMass_part2(int mass, int requiredFuel) {
    assertEquals(Day1FuelCalculator.calculateFuel2(mass), requiredFuel);
  }

}
