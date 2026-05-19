package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.GovernmentScheme;

public interface GovernmentSchemeService {

    GovernmentScheme saveScheme(GovernmentScheme scheme);

    List<GovernmentScheme> getAllSchemes();
}