package io.github.activiti_demo.bean;

import org.springframework.stereotype.Component;

@Component
public class TestBean {

  private String beanName;

  public String getBeanName() {
    return beanName;
  }

  public TestBean setBeanName(String beanName) {
    this.beanName = beanName;
    return this;
  }
}
