package com.example.demo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class MyController {

    private final ChatClient chatClient;

    public MyController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping("/ai")
    String generation(String userInput) {

        /*ChatModel chatModel = OpenAiChatModel.builder();

        String response = ChatClient.create(chatModel)
                .prompt("What day is tomorrow?")
                .tools(new DateTimeTools())
                .call()
                .content();*/

        return this.chatClient.prompt().tools(new MyTools())
                .user(userInput)
                .call()
                .content();
/*        return this.chatClient.prompt()
                .user(userInput)
                .call()
                .content();*/


    }
}
