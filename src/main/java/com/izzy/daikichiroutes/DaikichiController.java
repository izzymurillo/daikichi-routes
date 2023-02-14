package com.izzy.daikichiroutes;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Create a new controller called DaikichiController
// and be sure you annotate it as a @RestController
@RestController
@RequestMapping("/daikichi") // <== D.R.Y.
public class DaikichiController {

  // Have an http GET request to 'http://localhost:8080/daikichi'
  // display text that says 'Welcome!'
  @RequestMapping("")
  public String index() {
    return "<h1>Welcome!</h1>";
  }

  // Have an http GET request to 'http://localhost:8080/daikichi/today'
  // display text that says 'Today you will find luck in all your endeavors!'
  @RequestMapping("/today")
  public String today() {
    return "Today you will find luck in all your endeavors!";
  }

  // Have an http GET request to 'http://localhost:8080/daikichi/tomorrow'
  // display text that says 'Tomorrow, an opportunity will arise, so be sure to be
  // open to new ideas!'
  @RequestMapping("/tomorrow")
  public String tomorrow() {
    return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
  }

  // =========  DAIKICHI PATH VARIABLES  =========
  // Add 2 new routes with corresponding method definitions
  // in your Daikichi Routes project that will accept path variables.
  // Have an http GET request to 'http://localhost:8080/daikichi/travel/kyoto' 
  // where the url will take any string for the city, and display text that says 
  // for example, 'Congratulations! You will soon travel to kyoto!'.
  @RequestMapping("/travel/{location}")
  public String showLocation(@PathVariable("location") String location) {
    return "Congratulations! You will soon travel to " + location + "!";
  }

  // Have an http GET request to 'http://localhost:8080/daikichi/lotto/8', 
  // where the url will take any integer. If the number is even, display text that 
  // says 'You will take a grand journey in the near future, but be weary of tempting offers'. 
  // If it is odd, display text that says "You have enjoyed the fruits of your labor 
  // but now is a great time to spend time with family and friends."
  @RequestMapping("/lotto/{number}")
  public String showNumber(@PathVariable("number") int number) {
    if (number % 2 == 0) {
      return "You will take a grand journey in the near future, but be weary of tempting offers.";
    }
    return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
  }

}
