package com.example;

/**
 * This is a class.
 */
public class Greeter {

  /**
   * This is a constructor.
   */
  public Greeter() {

  }

  //TODO: Add javadoc comment
  public String greet(String someone) {
    return String.format("Hello, %s!", someone);
  }
  
  public int calculate(String param)
  {
	  if(param == "a")
		  return 1;
	  else if(param =="b")
		  return 2;
	  else
		  return 0;
  }
  
  public String NotCoveredFunction(String someone) {
	    return String.format("Hello, %s!", someone);
  }
}
