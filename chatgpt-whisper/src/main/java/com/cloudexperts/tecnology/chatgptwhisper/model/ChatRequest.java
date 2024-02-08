package com.cloudexperts.tecnology.chatgptwhisper.model;

import java.io.Serializable;
import lombok.Data;

@Data
public class ChatRequest implements Serializable {
    private String question;
}
