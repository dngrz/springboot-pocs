package com.cloudexperts.tecnology.chatgptwhisper.client;

import com.cloudexperts.tecnology.chatgptwhisper.model.ChatGptRequest;
import com.cloudexperts.tecnology.chatgptwhisper.model.ChatGptResponse;
import com.cloudexperts.tecnology.chatgptwhisper.model.WhisperTranscriptionRequest;
import com.cloudexperts.tecnology.chatgptwhisper.model.WhisperTranscriptionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
    name = "openai-service",
    url = "${openai-service.urls.base-url}",
    configuration = OpenAiClientConfig.class
)
public interface OpenAiClient {
    @PostMapping(value = "${openai-service.urls.chat-url}", headers = {"Content-Type=application/json"})
    ChatGptResponse chat(@RequestBody ChatGptRequest request);

    @PostMapping(value = "${openai-service.urls.create-transcription-url}", headers = {"Content-Type=multipart/form-data"})
    WhisperTranscriptionResponse createTranscription(@ModelAttribute WhisperTranscriptionRequest request);
}
