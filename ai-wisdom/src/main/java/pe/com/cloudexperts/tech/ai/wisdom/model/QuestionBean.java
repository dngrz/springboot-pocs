package pe.com.cloudexperts.tech.ai.wisdom.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionBean implements Serializable {

  private String question;
}
