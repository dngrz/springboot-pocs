## CHATGPT - WHISPER

**Ejemplo de Integración de Springboot con ChatGPT Permite realizar consultas a chatgpt con postman**


## ENVIRONMENT VARS:

    API_KEY : Api Key Generated by OpenAI.com

## Local Execution

    curl --location --request POST 'http://localhost:9027/api/v1/chat' \
    --header 'Authorization: Bearer ${API_KEY}' \
    --header 'Content-Type: application/json' \
    --data-raw '{
    "question": "Transforma éste código java a expresiones lambda: for(int i = 0; i<= 10 ; i++) { Sytem.out.println(i); } "
    }'

Author: CLODOALDO SANCHEZ - 2023

### Reference Documentation
For further reference, please consider the following sections:

* [Official ChatGPT documentation](https://platform.openai.com/docs/api-reference/introduction)
* [Integrating ChatGPT and Whisper APIs Into Spring Boot Microservice](https://betterprogramming.pub/integrating-chatgpt-and-whisper-apis-into-spring-boot-microservice-5545e2ea44fc)


