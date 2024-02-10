package pe.com.cloudexperts.tech.ai.wisdom.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class LoadService {

  private final JdbcTemplate jdbcTemplate;

  public void setUp(){
    log.info("running setUp()");
    jdbcTemplate.update("delete from vector_store");
  }

}
