package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class OpenAIService {

    @Value("${openai.api.key}")
    private String apiKey;

    public String getChatResponse(String userMessage) {

        String url =
                "https://generativelanguage.googleapis.com/v1/models/gemini-2.5-flash:generateContent?key="
                        + apiKey;

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> text = new HashMap<>();
        text.put("text", userMessage);

        Map<String, Object> part = new HashMap<>();
        part.put("parts", List.of(text));

        Map<String, Object> body = new HashMap<>();
        body.put("contents", List.of(part));

        HttpEntity<Map<String, Object>> request =
                new HttpEntity<>(body, headers);

        try {
            ResponseEntity<Map> response =
                    restTemplate.exchange(url, HttpMethod.POST, request, Map.class);

            Map res = response.getBody();

            List candidates = (List) res.get("candidates");

            Map first = (Map) candidates.get(0);

            Map content = (Map) first.get("content");

            List parts = (List) content.get("parts");

            Map part0 = (Map) parts.get(0);

            return part0.get("text").toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "AI service error: " + e.getMessage();
        }
    }
}