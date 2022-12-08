package com.example.week9onward;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;

public class APIUtility {

    /**
     * This method
     */
    public static APIResponse getMoviesFromDB(String searchTerm) throws IOException, InterruptedException {
        searchTerm = searchTerm.replaceAll("\s", "-");
        String uri = "https://www.omdbapi.com/?apikey=61a5cf5&s=" + searchTerm;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        HttpResponse<Path> response = client.send(request, HttpResponse.BodyHandlers.ofFile(Paths.get("jsonData.json")));

        return getMoviesFromJSON();
    }

    /**
     * This method will read the jsonData.json file from the root of the project and create an APIResponse object
     */
    private static APIResponse getMoviesFromJSON(){
        // create a GSON object
        Gson gson = new Gson();
        APIResponse apiResponse = null;

        // try with resources, whatever is in the () will automatically be closed
        try(JsonReader jsonReader = new JsonReader(new FileReader("jsonData.json")))
        {
            // jsonReader - the object that is parsing through the json file
            // APIResponse.class - the class that will be converted into from the JSON file
            apiResponse = gson.fromJson(jsonReader, APIResponse.class);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return apiResponse;
    }

    public static MovieDetails getMovieDetails(String imdbID) throws IOException, InterruptedException {
        String uri = "http://www.omdbapi.com/?apikey=61a5cf5&i=" + imdbID;

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        HttpResponse<Path> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofFile(Paths.get("jsonDetails.json")));

        // create a GSON object
        Gson gson = new Gson();
        MovieDetails details = null;

        // try with resources, whatever is in the () will automatically be closed
        try(JsonReader jsonReader = new JsonReader(new FileReader("jsonDetails.json")))
        {
            // jsonReader - the object that is parsing through the json file
            // APIResponse.class - the class that will be converted into from the JSON file
            details = gson.fromJson(jsonReader, MovieDetails.class);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return details;
    }

    public static Dealership getDealership(){
        // create a GSON object
        Gson gson = new Gson();
        Dealership dealership = null;

        try(JsonReader jsonReader = new JsonReader(new FileReader("carData.json")))
        {
            // jsonReader - the object that is parsing through the json file
            // APIResponse.class - the class that will be converted into from the JSON file
            dealership = gson.fromJson(jsonReader, Dealership.class);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return dealership;
    }
}
