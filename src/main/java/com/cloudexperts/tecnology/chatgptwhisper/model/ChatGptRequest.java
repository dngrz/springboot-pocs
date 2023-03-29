package com.cloudexperts.tecnology.chatgptwhisper.model;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatGptRequest implements Serializable {
    private String model;
    private List<Message> messages;
}
