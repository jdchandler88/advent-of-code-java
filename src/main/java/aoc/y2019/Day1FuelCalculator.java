package aoc.y2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.stream.Collectors;

public final class Day1FuelCalculator {

  private Day1FuelCalculator() {
  }

  /**
   * Calculates fuel based on input mass. The formula is RoundDown(mass / 3) - 2
   *
   * @param mass input mass
   * @return fuel required for input mass
   */
  public static int calculateFuel1(int mass) {
    return Math.floorDiv(mass, 3) - 2;
  }

  /**
   * Reads module masses from input file and calculates sum of fuel using calculateFuel1.
   *
   * @return total fuel
   * @throws IOException if problem reading from input
   */
  public static Object part1() throws IOException {
    try (BufferedReader br = new BufferedReader(
        new InputStreamReader(ClassLoader.getSystemResourceAsStream("DayOneInput.txt"),
            Charset.defaultCharset()))) {
      return br.lines()
          .map(s -> Integer.parseInt(s))
          .map(mass -> calculateFuel1(mass))
          .collect(Collectors.summingInt(Integer::intValue));
    }
  }

  /**
   * Calculates fuel based on input mass. Any fuel that is calculated from a mass itself requires
   * fuel. This is calculated recursively until the fuel required is <=0
   *
   * @param mass input mass
   * @return fuel required for mass
   */
  public static int calculateFuel2(int mass) {
    int fuel = Math.floorDiv(mass, 3) - 2;
    if (fuel >= 0) {
      return fuel + calculateFuel2(fuel);
    }
    return 0;
  }

  /**
   * Reads module masses from input file and calculates sum of fuel using calculateFuel2.
   *
   * @return total fuel
   * @throws IOException if problem reading from input
   */
  public static Object part2() throws IOException {
    try (BufferedReader br = new BufferedReader(
        new InputStreamReader(ClassLoader.getSystemResourceAsStream("DayOneInput.txt"),
            Charset.defaultCharset()))) {
      return br.lines()
          .map(s -> Integer.parseInt(s))
          .map(mass -> calculateFuel2(mass))
          .collect(Collectors.summingInt(Integer::intValue));
    }
  }

}
