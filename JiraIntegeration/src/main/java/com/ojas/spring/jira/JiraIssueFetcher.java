package com.ojas.spring.jira;

//import java.net.URI;
//import java.util.List;
//
//import com.atlassian.jira.rest.client.api.JiraRestClient;
//import com.atlassian.jira.rest.client.api.domain.Issue;
//import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
//import com.atlassian.jira.rest.client.internal.async.BasicHttpAuthenticationHandler;
//
//public class JiraIssueFetcher {
//
//    public static void main(String[] args) throws Exception {
//
//        // Set up authentication
//        String jiraBaseUrl = "https://your.jira.server";
//        String username = "your-jira-username";
//        String password = "your-jira-password";
//        URI uri = new URI(jiraBaseUrl);
//        BasicHttpAuthenticationHandler authHandler = new BasicHttpAuthenticationHandler(username, password);
//        AsynchronousJiraRestClientFactory factory = new AsynchronousJiraRestClientFactory();
//        JiraRestClient client = factory.create(uri, authHandler);
//
//        // Fetch issues using JQL
//        String jql = "project = MYPROJECT AND status = Open";
//        List<Issue> issues = client.getSearchClient().searchJql(jql).get().getIssues();
//
//        // Display issue details
//        for (Issue issue : issues) {
//            System.out.println(issue.getKey() + ": " + issue.getSummary());
//        }
//
//        // Clean up
//        client.close();
//    }
//}
