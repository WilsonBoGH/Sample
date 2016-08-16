package com.example;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class TestGreeter {

  private Greeter greeter;

  @Before
  public void setup() {
    greeter = new Greeter();
  }

  @Test
  public void greetShouldIncludeTheOneBeingGreeted() {
    String someone = "World";

    assertThat(greeter.greet(someone), containsString(someone));
  }

  @Test
  public void greetShouldIncludeGreetingPhrase() {
    String someone = "World";

    assertThat(greeter.greet(someone).length(), is(greaterThan(someone.length())));
  }
  
  @Test
  public void greetCalculateNumber() { 
    assertThat(greeter.calculate("a"), is(1));
    assertThat(greeter.calculate("b"), is(2));
    assertThat(greeter.calculate("c"), is(0));
  } 
  
  @Test
  public void greetShouldIncludeNotCoveredFunction() {
    String someone = "World";

    assertThat(greeter.NotCoveredFunction(someone), containsString(someone));
  }
  
  
}
