package org.example.springaidemo.controllers;

import org.example.springaidemo.entities.Answer;
import org.example.springaidemo.entities.Question;
import org.example.springaidemo.tools.WeatherTools;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AskController {

    private ChatClient chatClient;

    public AskController(ChatClient.Builder chatClientbuilder) {
        this.chatClient = chatClientbuilder.build();
    }

    @PostMapping("/ask")
    public Answer askQuestion(@RequestBody Question question) {
        return chatClient.prompt()
                .user(question.question())
                .tools(new WeatherTools())
                .call()
                .entity(Answer.class);
    }
}
