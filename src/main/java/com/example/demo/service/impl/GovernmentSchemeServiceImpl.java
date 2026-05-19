package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.service.GovernmentSchemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.GovernmentScheme;
import com.example.demo.repository.GovernmentSchemeRepository;

@Service
public class GovernmentSchemeServiceImpl implements GovernmentSchemeService {

    @Autowired
    private GovernmentSchemeRepository repo;

    @Override
    public GovernmentScheme saveScheme(GovernmentScheme scheme) {

        return repo.save(scheme);
    }

    @Override
    public List<GovernmentScheme> getAllSchemes() {

        return repo.findAll();
    }
}