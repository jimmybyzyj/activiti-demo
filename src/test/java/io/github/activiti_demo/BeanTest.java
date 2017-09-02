package io.github.activiti_demo;

import io.github.activiti_demo.bean.TestBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-core.xml"})
public class BeanTest {

  @Autowired
  private TestBean testBean;

  @Test
  public void beanTest() {
    Assert.assertNotNull(testBean);
  }
}
