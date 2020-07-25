package aoc.y2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Day1IntCodeComputer {

  interface Instruction {

    public int size();

    public boolean execute(int[] program, int programCounter);

  }

  static class Add implements Instruction {
    @Override
    public int size() {
      return 4;
    }

    @Override
    public boolean execute(int[] program, int programCounter) {
      int addendLocation1 = program[programCounter + 1];
      int addendLocation2 = program[programCounter + 2];
      int storageLocation = program[programCounter + 3];
      program[storageLocation] = program[addendLocation1] + program[addendLocation2];
      return true;
    }
  }

  static class Multiply implements Instruction {
    @Override
    public int size() {
      return 4;
    }

    @Override
    public boolean execute(int[] program, int programCounter) {
      int multiplicandLocation1 = program[programCounter + 1];
      int multiplicandLocation2 = program[programCounter + 2];
      int storageLocation = program[programCounter + 3];
      program[storageLocation] = program[multiplicandLocation1] * program[multiplicandLocation2];
      return true;
    }
  }

  static class Halt implements Instruction {
    @Override
    public int size() {
      return 1;
    }

    @Override
    public boolean execute(int[] program, int programCounter) {
      return false;
    }
  }

  private static Map<Integer, Instruction> instructions = new HashMap<>();

  static {
    instructions.put(1, new Add());
    instructions.put(2, new Multiply());
    instructions.put(99, new Halt());
  }

  /**
   * Runs IntCode program for Day2-Part1 requirements. This takes the program as input (no copy, so
   * it *will* modify the program) and runs the program.
   *
   * @param program input program
   */
  public static void run1(int[] program) {
    int programCounter = 0;
    boolean result;
    do {
      Instruction instruction = instructions.get(program[programCounter]);
      result = instruction.execute(program, programCounter);
      programCounter += instruction.size();
    } while (result);
  }

  /**
   * Part1. This parses input program and executes it
   *
   * @return value at memory location 0 after execution
   */
  public static int part1() {
    //parse program
    int[] program = getProgramFromInputFile();

    //modify program according to spec
    setProgramInputs(program, 12, 2);

    //run it
    Day1IntCodeComputer.run1(program);

    //provide answer
    return program[0];
  }

  static final int EXPECTED_RESULT_PART2 = 19690720;

  /**
   * Part2. This iterates over several executions of the input program to solve for a specific
   * number.
   *
   * @return (100 * input1) + input2 == (100*noun) + verb
   */
  public static int part2() {
    /*
    There's no way to get rid of this error. PMD thinks that we are nullifying 'originalProgram' in
    the following code. I don't want to read from the file system for each iteration, which would
     be the only way.
     */
    @SuppressWarnings("PMD.DataflowAnomalyAnalysis")
    int[] originalProgram = getProgramFromInputFile();
    int noun;
    int verb;
    for (noun = 0; noun <= 99; noun++) {
      for (verb = 0; verb <= 99; verb++) {
        //execute program with this input
        int[] programCopy = copyAndInsertInputs(originalProgram, noun, verb);
        Day1IntCodeComputer.run1(programCopy);
        if (programCopy[0] == EXPECTED_RESULT_PART2) {
          return (100 * noun) + verb;
        }
      }
    }
    return -999;
  }

  private static int[] getProgramFromInputFile() {
    try (BufferedReader reader = new BufferedReader(
        new InputStreamReader(ClassLoader.getSystemResourceAsStream("DayTwoInput.txt"), Charset
            .defaultCharset()))) {
      return reader.lines()
          .flatMap(line -> Arrays.asList(line.split(",")).stream())
          .mapToInt(Integer::parseInt)
          .toArray();
    } catch (IOException ioe) {
      throw new RuntimeException("Error input for problem.", ioe);
    }
  }

  private static void setProgramInputs(int[] program, int input1, int input2) {
    program[1] = input1;
    program[2] = input2;
  }

  private static int[] copyAndInsertInputs(int[] program, int input1, int input2) {
    int[] copy = Arrays.copyOf(program, program.length);
    setProgramInputs(copy, input1, input2);
    return copy;
  }

}
