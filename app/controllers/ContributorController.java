package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import services.GitHubService;

import javax.inject.Inject;

/**
 * @author Harrison J. S. Amorim
 * @version 1.0
 */
public class ContributorController extends Controller {
    private GitHubService gitHubService;
    /**
     * @param gitHubService um {@code GitHubService} injetado automaticamente
     */
    @Inject
    public ContributorController(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    /**
     * @param orgName o nome da organização
     * @return um Result
     */
    public Result getContributions(String orgName) {
        return ok(gitHubService.getContributions(orgName));
    }

}