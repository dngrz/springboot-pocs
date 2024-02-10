package pe.com.cloudexperts.tech.ai.wisdom.ws.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.cloudexperts.tech.ai.wisdom.model.QuestionBean;
import pe.com.cloudexperts.tech.ai.wisdom.service.MtcAiClient;

@RestController
@RequestMapping("/ai/chatbot")
public class ChatResource {

  @Autowired
  private MtcAiClient mtcAiClient;

  @PostMapping
  public String doChat(@RequestBody QuestionBean question){
    var result = mtcAiClient.chat(question.getQuestion());
    return result;
  }
}
