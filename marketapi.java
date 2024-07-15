package com.stockanalysis.api;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Properties;

public class MarketstackAPI {
    private final String apiKey;
    private final String baseUrl;
    private final ObjectMapper objectMapper;

    public MarketstackAPI() {
        Properties prop = new Properties();
        try {
            prop.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
        this.apiKey = prop.getProperty("marketstack.api.key");
        this.baseUrl = prop.getProperty("marketstack.api.baseurl");
        this.objectMapper = new ObjectMapper();
    }

    public String fetchStockData(String symbol, String interval) throws IOException {
        String url = baseUrl + "/eod?access_key=" + apiKey + "&symbols=" + symbol + "&interval=" + interval;

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);
            return EntityUtils.toString(httpClient.execute(request).getEntity());
        }
    }

    // Add more methods for other API endpoints as needed
}