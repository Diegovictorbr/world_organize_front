package com.world.util;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

public class WebClient {

    private final OkHttpClient httpClient;
    private static WebClient webClient;

    private WebClient() {
        httpClient = new OkHttpClient.Builder()
                .proxy(Proxy.NO_PROXY)
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();
    }

    public static WebClient getInstance() {
        return webClient != null ? webClient : (webClient = new WebClient());
    }

    public String doGet(String url) throws IOException {
        Request httpRequest = new Request.Builder().url(url).build();
        Response httpResponse = httpClient.newCall(httpRequest).execute();
        return httpResponse.body().string();
    }

    public String doPost(String url, JSONObject body) throws IOException {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), body.toString());
        Request request = new Request.Builder()
                .header("Accept", "application/json")
                .header("Content-type", "application/json; charset=UTF-8")
                .url(url)
                .post(requestBody).build();
        Response response = httpClient.newCall(request).execute();
        return response.body().string();
    }

    public void saveImage(String imageUrl, String destinationFile) throws Exception {
        imageUrl = imageUrl.replace(" ", "");
        File pictureFile = new File(destinationFile);
        URL url = new URL(imageUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("Connection", "keep-alive");
        conn.setConnectTimeout(240000);
        conn.setRequestMethod("GET");
        conn.connect();
        FileUtils.copyInputStreamToFile(conn.getInputStream(), pictureFile);
    }

    public boolean hasInternetConnection() throws IOException {
        Request httpRequest = new Request.Builder().url("http://www.google.com/").build();
        Response httpResponse = httpClient.newCall(httpRequest).execute();
        return httpResponse.code() == 200;
    }
}
