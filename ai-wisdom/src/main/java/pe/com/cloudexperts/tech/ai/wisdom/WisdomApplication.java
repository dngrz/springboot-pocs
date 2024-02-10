package pe.com.cloudexperts.tech.ai.wisdom;

import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pe.com.cloudexperts.tech.ai.wisdom.service.LoadService;
import pe.com.cloudexperts.tech.ai.wisdom.service.PdfService;

@Slf4j
@SpringBootApplication
public class WisdomApplication {

  @Autowired
  private LoadService loadService;

  @Autowired
  private PdfService pdfService;

  public static void main(String[] args) {
    SpringApplication.run(WisdomApplication.class, args);
  }

  @Bean
  ApplicationRunner applicationRunner() {
    return args -> {
      //setUp();
    };
  }

  private void setUp() throws IOException {
    loadService.setUp();
    pdfService.process();
  }

}
