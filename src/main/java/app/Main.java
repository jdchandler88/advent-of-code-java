package app;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.nio.charset.Charset;

public class Main {

  /**
   * Main application. This reads from app.json (src/main/resources) and executes methods that
   * return answers to the AOC solutions.
   *
   * @param args cmd line arguments
   * @throws Exception if problem parsing app.json or if problem reflectively invoking methods
   */
  public static void main(String[] args)
      throws Exception {
    //read properties file to see what functions to run
    AdventOfCode adventOfCode = new ObjectMapper()
        .readValue(new InputStreamReader(ClassLoader.getSystemResourceAsStream("app.json"),
                Charset.defaultCharset()),
            AdventOfCode.class);

    //iterate over functions that should produce output
    for (Year year : adventOfCode.getYears()) {
      System.out.println("Year: " + year.getYearNumber());
      for (Day day : year.getDays()) {
        System.out.println("\tDay " + day.getDayNumber());
        for (Part part : day.getParts()) {
          System.out.println("\t\tPart " + part.getPartNumber());
          Class cls = Class.forName(part.getClazz());
          Method method = cls.getMethod(part.getMethod());
          System.out.println("\t\t\tResult: " + method.invoke(null));
        }
      }
    }


  }

}
