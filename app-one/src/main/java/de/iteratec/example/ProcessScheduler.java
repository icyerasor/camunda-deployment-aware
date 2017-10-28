package de.iteratec.example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.camunda.bpm.engine.RuntimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class ProcessScheduler {

  private static final Logger LOGGER = LoggerFactory.getLogger(ProcessScheduler.class);
  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

  @Autowired
  private RuntimeService runtimeService;

  @Scheduled(initialDelay = 5 * 1000, fixedRate = 60 * 1000)
  public void schedule() {
    String businessKey = dateFormat.format(new Date());
    LOGGER.info("The time is now {}", businessKey);

    runtimeService.startProcessInstanceByKey("parent_process", businessKey, new HashMap<String, Object>());
  }
}
