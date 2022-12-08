package com.example.week9onward;

import com.google.gson.annotations.SerializedName;

import java.util.*;

public class MovieDetails {

    @SerializedName("Title")
    private String title;
    @SerializedName("Year")
    private String year;
    @SerializedName("Rated")
    private String rated;
    @SerializedName("Runtime")
    private String runTime;
    @SerializedName("Director")
    private String director;
    @SerializedName("Actors")
    private String actors;
    @SerializedName("BoxOffice")
    private String boxOffice;
    private HashMap<String, String> ratings;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActors() {
        return actors;
    }

    public String[] getActorsArray() {
        String[] results = actors.split(", ");
        Arrays.sort(results);
        return results;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getBoxOffice() {
        return boxOffice;
    }

    public void setBoxOffice(String boxOffice) {
        this.boxOffice = boxOffice;
    }

    public HashMap<String, String> getRatings() {
        return ratings;
    }

    public void setRatings(HashMap<String, String> ratings) {
        this.ratings = ratings;
    }
}
