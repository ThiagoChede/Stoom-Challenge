package com.stoom.challenge.integration;

import com.stoom.challenge.ChallengeApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;


@SpringBootTest(classes = ChallengeApplication.class)
@ActiveProfiles("test")
@ContextConfiguration
public class CucumberRoot { }
