package com.cloudexperts.tecnology.chatgptwhisper.business.impl;

import com.cloudexperts.tecnology.chatgptwhisper.business.OpenAiClientService;
import com.cloudexperts.tecnology.chatgptwhisper.client.OpenAiClient;
import com.cloudexperts.tecnology.chatgptwhisper.client.OpenAiClientConfig;
import com.cloudexperts.tecnology.chatgptwhisper.model.ChatGptRequest;
import com.cloudexperts.tecnology.chatgptwhisper.model.ChatGptResponse;
import com.cloudexperts.tecnology.chatgptwhisper.model.ChatRequest;
import com.cloudexperts.tecnology.chatgptwhisper.model.Message;
import com.cloudexperts.tecnology.chatgptwhisper.model.TranscriptionRequest;
import com.cloudexperts.tecnology.chatgptwhisper.model.WhisperTranscriptionRequest;
import com.cloudexperts.tecnology.chatgptwhisper.model.WhisperTranscriptionResponse;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OpenAiClientServiceImpl implements OpenAiClientService {

    private final OpenAiClient openAIClient;
    private final OpenAiClientConfig openAiClientConfig;

    private final static String ROLE_USER = "user";

    @Override
    public ChatGptResponse chat(ChatRequest chatRequest) {
        Message message = Message.builder()
            .role(ROLE_USER)
            .content(chatRequest.getQuestion())
            .build();
        ChatGptRequest chatGPTRequest = ChatGptRequest.builder()
            .model(openAiClientConfig.getModel())
            .messages(Collections.singletonList(message))
            .build();
        return openAIClient.chat(chatGPTRequest);
    }

    @Override
    public WhisperTranscriptionResponse createTranscription(TranscriptionRequest transcriptionRequest) {
        WhisperTranscriptionRequest whisperTranscriptionRequest = WhisperTranscriptionRequest.builder()
            .model(openAiClientConfig.getAudioModel())
            .file(transcriptionRequest.getFile())
            .build();
        return openAIClient.createTranscription(whisperTranscriptionRequest);
    }
}
