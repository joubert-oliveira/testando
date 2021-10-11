package com.streamobserver.streamobserver.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@ToString
public class Connection {
    private String host;
    private String streamingServiceURL;
    private int sentPackets;
    private int receivedPackets;
    private int lostPackets;
    private int packetLossPercentage;
    private int minLatency;
    private int maxLatency;
    private int avgLatency;

    public Connection(String streamingServiceURL) {
        this.streamingServiceURL = streamingServiceURL;
        testConnection();
    }

    public void testConnection() {
        if (!streamingServiceURL.contains("http") && !streamingServiceURL.contains("https")) {
            streamingServiceURL = "http://" + streamingServiceURL;
        }

        try {
            host = new URL(streamingServiceURL).getHost();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        String ping = "ping -n 10 " + host;

        try {
            Process process = Runtime.getRuntime().exec(ping);
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(process.getInputStream()));
            Pattern pattern = Pattern.compile("\\d+");
            String readerLine;

            while ((readerLine = inputStream.readLine()) != null) {
                Matcher matcher = pattern.matcher(readerLine);

                Supplier<Integer> matchValue = () -> {
                  matcher.find();
                  return Integer.valueOf(matcher.group());
                };

                System.out.println(readerLine);

                if (Pattern.compile("\\d,").matcher(readerLine).find()) {
                    sentPackets = matchValue.get();
                    receivedPackets = matchValue.get();
                    lostPackets = matchValue.get();
                    packetLossPercentage = matchValue.get();
                } else if (Pattern.compile("\\dms").matcher(readerLine).find()) {
                    minLatency = matchValue.get();
                    maxLatency = matchValue.get();
                    avgLatency = matchValue.get();
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
