package com.example.week9onward;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.IOException;

public class DetailsController {
    @FXML
    private ListView<String> actorsListView;

    @FXML
    private Label boxOfficeLabel;

    @FXML
    private Label directorLabel;

    @FXML
    private Label ratingLabel;

    @FXML
    private Label runtimeLabel;

    @FXML
    private Label titleLabel;

    @FXML
    private Label yearLabel;
    public void getMovieDetails(String imdbID) throws IOException, InterruptedException {
        MovieDetails details = APIUtility.getMovieDetails(imdbID);

        yearLabel.setText(details.getYear());
        boxOfficeLabel.setText(details.getBoxOffice());
        directorLabel.setText(details.getDirector());
        ratingLabel.setText(details.getRated());
        runtimeLabel.setText(details.getRunTime());
        titleLabel.setText(details.getTitle());
        actorsListView.getItems().addAll(details.getActorsArray());
    }

    @FXML
    public void goBack(ActionEvent event) throws IOException, InterruptedException {
        SceneChanger.changeScenes(event,"search-view.fxml");
    }
}
