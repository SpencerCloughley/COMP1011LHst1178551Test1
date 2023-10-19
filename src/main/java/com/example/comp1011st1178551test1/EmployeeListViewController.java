package com.example.comp1011st1178551test1;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class EmployeeListViewController {

    @FXML
    private Label averageSalaryLabel;

    @FXML
    private BarChart<?, ?> barChart;

    @FXML
    private TableColumn<?, ?> departmentColumn;

    @FXML
    private TableColumn<?, ?> emailColumn;

    @FXML
    private TextField filterTextField;

    @FXML
    private TableColumn<?, ?> idColumn;

    @FXML
    private TableColumn<?, ?> nameColumn;

    @FXML
    private Label numberEmployeesLabel;

    @FXML
    private TableColumn<?, ?> salaryColumn;

}

