package com.cloudexperts.tecnology.chatgptwhisper.business;

import com.cloudexperts.tecnology.chatgptwhisper.model.ChatGptResponse;
import com.cloudexperts.tecnology.chatgptwhisper.model.ChatRequest;
import com.cloudexperts.tecnology.chatgptwhisper.model.TranscriptionRequest;
import com.cloudexperts.tecnology.chatgptwhisper.model.WhisperTranscriptionResponse;

public interface OpenAiClientService {
    ChatGptResponse chat(ChatRequest chatRequest);

    WhisperTranscriptionResponse createTranscription(TranscriptionRequest transcriptionRequest);
}
