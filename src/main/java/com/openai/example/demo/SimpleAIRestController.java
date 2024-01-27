package com.openai.example.demo;

import org.springframework.ai.client.AiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleAIRestController {
    private final AiClient aiClient;

    @Autowired
    public SimpleAIRestController(AiClient aiClient){
        this.aiClient = aiClient;
    }

    @GetMapping("/ai/simple")
    public Completion completion(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message){
        return new Completion(aiClient.generate(message));
    }
}
