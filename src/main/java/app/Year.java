package app;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.util.List;

public class Year {

  private int yearNumber;

  private List<Day> days;

  @JsonGetter("year")
  public int getYearNumber() {
    return yearNumber;
  }

  @JsonSetter("year")
  public void setYearNumber(int yearNumber) {
    this.yearNumber = yearNumber;
  }

  public List<Day> getDays() {
    return days;
  }

  public void setDays(List<Day> days) {
    this.days = days;
  }
}
