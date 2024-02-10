package pe.com.cloudexperts.tech.ai.wisdom.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
@Getter
public class DataConfiguration {

  @Value("classpath:data-pdf/MTC-CLASE-A1.pdf")
  Resource dataPdf;

}
