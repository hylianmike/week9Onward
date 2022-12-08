package com.example.week9onward;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.util.converter.CurrencyStringConverter;

import java.net.URL;
import java.util.Arrays;
import java.util.Locale;
import java.util.OptionalDouble;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class DealershipController implements Initializable {

    @FXML
    private Label avgPriceLabel;

    @FXML
    private BarChart<?, ?> chart;

    @FXML
    private Label dealershipLabel;

    @FXML
    private TableColumn<?, ?> idColumn;

    @FXML
    private TableColumn<?, ?> makeColumn;

    @FXML
    private ComboBox<String> makeComboBox;

    @FXML
    private TableColumn<?, ?> modelColumn;

    @FXML
    private TableColumn<?, ?> priceColumn;

    @FXML
    private TextField searchTextField;

    @FXML
    private Label totalValueLabel;

    @FXML
    private TableColumn<?, ?> typeColumn;

    @FXML
    private TableColumn<?, ?> yearColumn;

    private Dealership dealership;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dealership = APIUtility.getDealership();
        dealershipLabel.setText(dealership.getName());

        // using a stream display the total value of the inventory
        CurrencyStringConverter converter = new CurrencyStringConverter(Locale.CANADA);
        totalValueLabel.setText(converter.toString(dealership.getCars().stream().mapToDouble(car -> car.getPrice()).sum()));

        // using a stream display the average price of all cars
        OptionalDouble value = dealership.getCars().stream().mapToDouble(Car::getPrice).average();
        if (value.isPresent())
            avgPriceLabel.setText(converter.toString(value.getAsDouble()));
        else
            avgPriceLabel.setText("N/A");

        // using a stream to filter the results for all manufacturers
        makeComboBox.getItems().addAll(dealership.getCars().stream().map(Car::getMake).distinct().sorted().collect(Collectors.toList()));

        // using a stream to filter the results for all models
        makeComboBox.getItems().addAll(dealership.getCars().stream().map(Car::getModel).distinct().sorted().collect(Collectors.toList()));
    }
}