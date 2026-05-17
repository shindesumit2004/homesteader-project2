package com.example.demo.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.GovernmentScheme;
import com.example.demo.repository.GovernmentSchemeRepository;
import com.example.demo.service.GovernmentSchemeService;

@Service
public class GovernmentSchemeServiceImpl implements GovernmentSchemeService {

    @Autowired
    private GovernmentSchemeRepository repository;

    @Override
    public GovernmentScheme saveScheme(GovernmentScheme scheme) {

        return repository.save(scheme);
    }

    @Override
    public List<GovernmentScheme> getAllSchemes() {

        return repository.findAll();
    }
}