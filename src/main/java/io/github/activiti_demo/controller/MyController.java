package io.github.activiti_demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

  @RequestMapping(value = "index", method = RequestMethod.GET)
  public String index() {
    return "Hello,Spring & Spring MVC";
  }
}
