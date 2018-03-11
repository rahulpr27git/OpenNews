package com.dev.rahul.opennews.pojo;

import java.util.List;

/**
 * Created by rahul on 4/3/18.
 */

public class Response {

    private String status = "";
    private int totalResults = 0;

    private List<Sources> sources;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<Sources> getSources() {
        return sources;
    }

    public void setSources(List<Sources> sources) {
        this.sources = sources;
    }
}
