package services;

import com.fasterxml.jackson.databind.JsonNode;
import models.Contributor;
import play.libs.Json;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import play.libs.ws.WSResponse;

import javax.inject.Inject;
import java.util.*;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;

/***
 * Classe de acesso à API GitHub
 * @author Harrison J. S. Amorim
 * @version 1.0
 */
public class GitHubService {
    private final String gh_token;
    private final WSClient ws;
    private String urlGitHub;

    @Inject
    public GitHubService(WSClient ws) {
        this.ws = ws;
        /**
         *   Token OAuth carregado de uma variável de ambiente. Necessita dos seguintes scopos : repo, read:org, read:user
         */
        gh_token = System.getenv("GH_TOKEN");
    }

    /**
     * @return Método retorna um json com name[login] e número de contribuições[contributions] dos contribuidores
     */
    public JsonNode getContributions(final String orgName) {
        List<String> repositoryNames = getRepositoryNamesByOrgName(orgName);
        List<Contributor> contributors = getContributors(orgName, repositoryNames);
        Collections.sort(contributors);
        return Json.toJson(contributors);
    }

    /**
     * Conseguindos os nomes dos repositorios que estão presentes na organização
     * Link da API GitHub: https://api.github.com/orgs/[orgName]/repos
     */
    public List<String> getRepositoryNamesByOrgName(final String orgName) {
        JsonNode jsonNode = null;
        CompletionStage<? extends WSResponse> responsePromise = null;
        this.urlGitHub = "https://api.github.com/orgs/" + orgName + "/repos";

        responsePromise = ws.url(this.urlGitHub)
                .addHeader("Authorization", "token " + this.gh_token)
                .addHeader("accept", "application/vnd.github.v3+json")
                .get();
        try {
            jsonNode = Json.parse(responsePromise.toCompletableFuture().get().getBody());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return jsonNode.findValuesAsText("name");
    }

    /**
     * @return  Método retorna lista de todos os contribuidores presentes nos diversos repositórios de uma determinada organização;
     * Link da API GitHub: https://api.github.com/repos/[orgName]/[repositoryName]/contributors
     */
    public List<Contributor> getContributors(final String orgName, List<String> repositoryNames) {
        WSRequest request = null;
        JsonNode jsonNode = null;
        List<Contributor> contributors = new ArrayList<>();
        CompletionStage<? extends WSResponse> responsePromise = null;

        for (String repositoryName : repositoryNames) {
            this.urlGitHub = "https://api.github.com/repos/" + orgName + "/" + repositoryName + "/contributors";
            request = ws.url(this.urlGitHub)
                    .addHeader("Authorization", "token " + this.gh_token)
                    .addHeader("accept", "application/vnd.github.v3+json");
            responsePromise = request.get();

            try {
                jsonNode = Json.parse(responsePromise.toCompletableFuture().get().getBody());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            for (int x = 0; x < jsonNode.size(); x++) {
                Contributor contributor = new Contributor();
                contributor.setName(jsonNode.get(x).findValue("login").toString().replace("\"", ""));
                contributor.setContributions(Integer.parseInt(jsonNode.get(x).findValue("contributions").toString()));
                contributors.add(contributor);
            }
        }

        /**
         * Alguns contribuidores aparecem mais de uma vez devido estarem presentes em mais de um repositório
         *   Esse loop trata isso, realizando um merge desses contribuidores repetidos e juntando(somando) suas contribuições
         */
        for (int x = 0; x < contributors.size(); x++) {
            for (int y = 0; y < contributors.size(); y++) {
                if (x != y) {
                    if (contributors.get(x).getName().equals(contributors.get(y).getName())) {
                        int somaDasContributions = contributors.get(x).getContributions() + contributors.get(y).getContributions();
                        contributors.get(x).setContributions(somaDasContributions);
                        contributors.remove(y);
                    }
                }
            }
        }
        return contributors;
    }
}
