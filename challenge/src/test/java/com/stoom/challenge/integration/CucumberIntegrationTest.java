package com.stoom.challenge.integration;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by MRomeh.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"},
                 format = {"pretty", "html:target/reports/cucumber/html", "json:target/cucumber.json", "usage:target/usage.jsonx", "junit:target/junit.xml"},
                 glue = {"com.stoom.challenge.integration"},
                 tags = {"~@ignore", "~@wip"})
public class CucumberIntegrationTest {}