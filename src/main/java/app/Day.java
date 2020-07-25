package app;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.util.List;

public class Day {

  private int dayNumber;

  private List<Part> parts;

  @JsonGetter("day")
  public int getDayNumber() {
    return dayNumber;
  }

  @JsonSetter("day")
  public void setDayNumber(int dayNumber) {
    this.dayNumber = dayNumber;
  }

  public List<Part> getParts() {
    return parts;
  }

  public void setParts(List<Part> parts) {
    this.parts = parts;
  }
}
