package com.cloudexperts.tecnology.chatgptwhisper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ChatgptWhisperApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatgptWhisperApplication.class, args);
	}

}
