package com.cloudexperts.tecnology.chatgptwhisper.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.Data;

@Data
public class Choice implements Serializable {

    private Integer index;
    @JsonProperty("finish_reason")
    private String finishReason;
    private Message message;


}
