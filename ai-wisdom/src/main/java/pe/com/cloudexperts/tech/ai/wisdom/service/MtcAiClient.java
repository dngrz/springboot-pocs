package pe.com.cloudexperts.tech.ai.wisdom.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MtcAiClient {
  private final String templatePrompt = """
                    Usted es un asistente que responde preguntas relacionadas a Examen de MTC Categoria A1 de Perú
                    El Ministerio de Transportes y Comunicaciones (MTC) es una organización que emite licencias de tránsito en Perú.
                           
                    Utilice la información de la sección DOCUMENTS para responder.
                    si no estas seguro de la respuesta, responde: Desconosco la respuesta.
                           
                    DOCUMENTS:
                    {documents}
                    
        """;

  @Autowired
  private ChatClient chatClient;
  @Autowired
  private VectorStore vectorStore;

  public String chat(String message) {

    var listOfSimilarDocuments = this.vectorStore.similaritySearch(message);
    var documents = listOfSimilarDocuments
        .stream()
        .map(Document::getContent)
        .collect(Collectors.joining(System.lineSeparator()));
    var systemMessage = new SystemPromptTemplate(this.templatePrompt)
        .createMessage(Map.of("documents", documents));
    var userMessage = new UserMessage(message);
    var prompt = new Prompt(List.of(systemMessage, userMessage));
    var chatResponse = chatClient.call(prompt);
    //log.info("finishQuery");
    return chatResponse.getResult().getOutput().getContent();

  }


}
