package twitter;

import exceptions.TwitterApiClientException;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.Format;
import java.text.MessageFormat;

/**
 * Created by Baptiste on 03/11/2016.
 */
public class TwitterApiClient {
    private final char SEPARATOR = '\\';

    private String apiTwitterUrl = "https://api.twitter.com";
    private String apiVersion = "1.1";
    private String typeApi = "search/tweets.json?";
    private String getQuery = "q=";

    public String finalURL;
    public TwitterApiClient(String query) throws TwitterApiClientException {
        String queryFormated = encodeQuery(query);
        if (queryFormated.isEmpty()) throw new TwitterApiClientException("Initial query is empty");

        this.formatTwitterApiURL(queryFormated);
    }

    public void request(String type) {

    }

    private void formatTwitterApiURL(String queryOfRequest) {
        getQuery += queryOfRequest;
        finalURL = apiTwitterUrl + SEPARATOR + apiVersion + SEPARATOR + typeApi + getQuery;
    }

    private String encodeQuery(String queryToEncode) {
        try {
            if (queryToEncode.isEmpty()) return "";

            return URLEncoder.encode(queryToEncode, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            System.out.println("Query encoding error");
            return "";
        }
    }

    public static void main (String[] args) {
        System.out.println("ok");
    }
}
