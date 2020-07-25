package app;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Part {

  private int partNumber;

  private String clazz;

  private String method;

  @JsonGetter("part")
  public int getPartNumber() {
    return partNumber;
  }

  @JsonSetter("part")
  public void setPartNumber(int part) {
    this.partNumber = part;
  }

  @JsonGetter("class")
  public String getClazz() {
    return clazz;
  }

  @JsonSetter("class")
  public void setClazz(String clazz) {
    this.clazz = clazz;
  }

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }


}
