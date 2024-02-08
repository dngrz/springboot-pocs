package com.cloudexperts.tecnology.chatgptwhisper.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public  class TranscriptionRequest implements Serializable {
    private MultipartFile file;
}
