package com.example.demo.weather.controller;

import com.example.demo.weather.Weather;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller

public class WeatherController {

	//Mapping for Weather API
    @Operation(description = "Data about weather")
	@GetMapping("/getWeather")
    public Weather getWeather(@RequestParam("city") String city) {

        String apiKey = "1fbd5b6dc0a3b21b5991097c82147f1d";

        String apiUrl = "https://home.openweathermap.org/api_keys";

        String url = String.format("%s?q=%s&units=metric&appid=%s", apiUrl, city, apiKey);

        RestTemplate restTemplate = new RestTemplate();
        Weather weather = restTemplate.getForObject(url, Weather.class);

        return weather;
    }

}