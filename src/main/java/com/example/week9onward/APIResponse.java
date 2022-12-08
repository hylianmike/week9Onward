package com.example.week9onward;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

public class APIResponse {

    @SerializedName("Search")
    private Movie[] search;

    private String totalResults;

    @SerializedName("Response")
    private String response;

    @SerializedName("Error")
    private String error;

    public String getError() {
        return error;
    }

    public boolean resultsReturned(){
        return response.equalsIgnoreCase("True");
    }

    public APIResponse(Movie[] search, String totalResults, String response) {
        setSearch(search);
        setTotalResults(totalResults);
        setResponse(response);
    }

    public Movie[] getSearch() {
        return search;
    }

    public void setSearch(Movie[] search) {
        this.search = search;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public List<Movie> getMovies(){
        return Arrays.asList(search);
    }
}
