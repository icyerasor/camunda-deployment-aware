package de.iteratec.example;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;


@SpringBootApplication
@EnableScheduling
@EnableProcessApplication
public class ApplicationTwo {

  private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationTwo.class);

  private static int PORT;

  public static void main(String[] args) {
    SpringApplication.run(ApplicationTwo.class, args);
    LOGGER.info("You can reach the web app under: http://localhost:{}/", PORT);
  }

  @Component
  public static class ServletContainerListener implements ApplicationListener<EmbeddedServletContainerInitializedEvent> {

    @Override
    public void onApplicationEvent(EmbeddedServletContainerInitializedEvent event) {
      PORT = event.getEmbeddedServletContainer().getPort();
    }

  }
}
