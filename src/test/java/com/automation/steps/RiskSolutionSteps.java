package com.automation.steps;

import io.cucumber.java.en.When;
import pages.RiskSolutionPage;

public class RiskSolutionSteps {

    RiskSolutionPage riskSolutionPage=new RiskSolutionPage();

    @When("I clicks on {string} and {string}")
    public void iClicksOnAnd(String menu1, String menu2) {
        riskSolutionPage.navigateToCareers();
    }
    @When("I clicks on {string}")
    public void userClicksOn(String linkText) {
        riskSolutionPage.clickSearchAllJobs();
    }
}
