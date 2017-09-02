package io.github.activiti_demo.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/spring/spring-core.xml"})
public class SimpleLeaveFlowTest {

  @Test
  public void testStartProcess() {
    //创建一个临时的ProcessEngine
    ProcessEngine processEngine = ProcessEngineConfiguration
        .createStandaloneInMemProcessEngineConfiguration().buildProcessEngine();
    //获取到RepositoryService
    RepositoryService repositoryService = processEngine.getRepositoryService();
    //部署Leave流程文件
    repositoryService.createDeployment().addClasspathResource("activiti/leave.bpmn").deploy();
    //验证部署的流程
    ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().singleResult();
    //打印出当前流程的Key
    Assert.assertEquals("leave", processDefinition.getKey());
    System.out.println(processDefinition.getKey() + "\n");
    //启动流程并返回实例
    RuntimeService runtimeService = processEngine.getRuntimeService();
    //根据Key启动对应的流程
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("leave");
    Assert.assertNotNull(processDefinition);
    //打印处此流程相关信息
    System.out.println("pid=" + processInstance.getId() + "\n" + "pdid=" + processInstance.getProcessDefinitionId());
  }
}
