//package com.escuela.api.utilities;
//
//import com.atlassian.jira.rest.client.api.JiraRestClient;
//import com.atlassian.jira.rest.client.api.JiraRestClientFactory;
//import com.atlassian.jira.rest.client.api.domain.BasicProject;
//import com.atlassian.jira.rest.client.api.domain.Issue;
//import com.atlassian.jira.rest.client.api.domain.SearchResult;
//import com.atlassian.jira.rest.client.api.domain.User;
//import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
//import com.atlassian.util.concurrent.Promise;
//
//import java.net.URI;
//
//public class JIRATest {
//
////    public static void main(String[] args) {
//////        MyJiraClient myJiraClient = new MyJiraClient(
//////                "user.name",
//////                "password",
//////                "http://jira.company.com");
////
////        new AsynchronousJiraRestClientFactory()
////                .createWithBasicHttpAuthentication(getJiraUri(),"escuelatech","OPXllMIfS46txiWefoRv97EA");
////    }
//
//    private static URI getJiraUri() {
//        return URI.create("https://escuelatech.atlassian.net");
//    }
//
//
//    private static final String JIRA_URL = "https://escuelatech.atlassian.net";
//    private static final String JIRA_ADMIN_USERNAME = "escuela.tech@gmail.com";
//    private static final String JIRA_ADMIN_PASSWORD = "OPXllMIfS46txiWefoRv97EA";
//
//    public static void main(String[] args) throws Exception {
//        // Construct the JRJC client
//        System.out.println(String.format("Logging in to %s with username '%s' and password '%s'", JIRA_URL, JIRA_ADMIN_USERNAME, JIRA_ADMIN_PASSWORD));
//        JiraRestClientFactory factory = new AsynchronousJiraRestClientFactory();
//        URI uri = new URI(JIRA_URL);
//        JiraRestClient client = factory.createWithBasicHttpAuthentication(uri, JIRA_ADMIN_USERNAME, JIRA_ADMIN_PASSWORD);
////        System.err.println(client.getIssueClient().getIssue("ES-27").get().getAssignee());
//        // Invoke the JRJC Client
//        Promise<User> promise = client.getUserClient().getUser("nikdev91");
//        User user = promise.claim();
//
//        for (BasicProject project : client.getProjectClient().getAllProjects().claim()) {
//            System.out.println(project.getKey() + ": " + project.getName());
//        }
//
//        Promise<SearchResult> searchJqlPromise = client.getSearchClient().searchJql("project = MYPURRJECT AND status in (Closed, Completed, Resolved) ORDER BY assignee, resolutiondate");
//
//        for (Issue issue : searchJqlPromise.claim().getIssues()) {
//            System.out.println(issue.getSummary());
//        }
//
//        // Print the result
//        System.out.println(String.format("Your admin user's email address is: %s\r\n", user.getEmailAddress()));
//
//        // Done
//        System.out.println("Example complete. Now exiting.");
//        System.exit(0);
//    }
//}
