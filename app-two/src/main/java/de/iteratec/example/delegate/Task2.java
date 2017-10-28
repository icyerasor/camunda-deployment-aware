package de.iteratec.example.delegate;

import org.camunda.bpm.engine.ProcessEngineConfiguration;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("task2")
public class Task2 implements JavaDelegate {

  private static final Logger LOGGER = LoggerFactory.getLogger(Task2.class);

  @Autowired
  ProcessEngineConfiguration processEngineConfiguration;

  @Override
  public void execute(DelegateExecution execution) throws Exception {

    boolean jobExecutorDeploymentAware = processEngineConfiguration.isJobExecutorDeploymentAware();
    LOGGER.error("AWARE: {}", jobExecutorDeploymentAware);

    LOGGER.info("Executing Task2 for proc with businessKey: {}", execution.getProcessInstance().getBusinessKey());
  }
}
