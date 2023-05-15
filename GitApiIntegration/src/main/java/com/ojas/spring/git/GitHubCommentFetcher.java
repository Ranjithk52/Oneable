package com.ojas.spring.git;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.egit.github.core.Comment;
import org.eclipse.egit.github.core.Issue;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.service.IssueService;
import org.eclipse.egit.github.core.service.RepositoryService;

public class GitHubCommentFetcher {
    private static final String REPOSITORY_OWNER = "Ranjithk52";
    private static final String REPOSITORY_NAME = "Practice";
    private static final String GITHUB_ACCESS_TOKEN = "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";

    public static void main(String[] args) throws IOException {
        RepositoryService repositoryService = new RepositoryService();
        repositoryService.getClient().setOAuth2Token(GITHUB_ACCESS_TOKEN);

        Repository repository = repositoryService.getRepository(REPOSITORY_OWNER, REPOSITORY_NAME);

        IssueService issueService = new IssueService();
        issueService.getClient().setOAuth2Token(GITHUB_ACCESS_TOKEN);

        List<Issue> issues = issueService.getIssues(repository, null);
        List<Comment> comments = new ArrayList<Comment>();
        for (Issue issue : issues) {
        
            comments.addAll(issueService.getComments(repository, issue.getNumber()));
        }

       
        for (Comment comment : comments) {
            System.out.println(comment.getBody());
        }
    }
}