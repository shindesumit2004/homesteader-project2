package com.example.demo.controller;

import com.example.demo.service.OpenAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
public class ChatController {

    @Autowired
    private OpenAIService openAIService;

    @PostMapping("/chat")
    public String chat(@RequestBody Map<String, String> request) {

        String message = request.get("message");

        return openAIService.getChatResponse(message);
    }
}