package com.automation.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.RiskSolutionPage;

public class RiskSolutionSteps {

    RiskSolutionPage riskSolutionPage=new RiskSolutionPage();

    @When("I clicks on {string} and {string}")
    public void iClicksOnAnd(String menu1, String menu2) {
        riskSolutionPage.navigateToCareers();
    }
    @When("I click on search jobs button to search for {string} Jobs")
    public void IClicksOn(String inputText) {
        riskSolutionPage.clickSearchJobsButton();
        riskSolutionPage.searchForJobs(inputText);
    }

    @Then("I should see at least one job published")
    public void verifyJobResults(){
        Assert.assertTrue("No search results found!", riskSolutionPage.isResultAvailable());

    }
}