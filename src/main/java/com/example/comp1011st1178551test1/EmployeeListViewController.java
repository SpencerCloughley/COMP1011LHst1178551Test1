package com.example.comp1011st1178551test1;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeListViewController implements Initializable {

    @FXML
    private Label averageSalaryLabel;

    @FXML
    private BarChart<?, ?> barChart;

    @FXML
    private TableColumn<Employee, String> departmentColumn;

    @FXML
    private TableColumn<Employee, String> emailColumn;

    @FXML
    private TextField filterTextField;

    @FXML
    private TableColumn<Employee, Integer> idColumn;

    @FXML
    private TableColumn<Employee, String> nameColumn;

    @FXML
    private Label numberEmployeesLabel;

    @FXML
    private TableColumn<Employee, Double> salaryColumn;
    @FXML
    private TableView<Employee> tableView;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("FullName"));
        departmentColumn.setCellValueFactory(new PropertyValueFactory<>("Department"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("Email"));
        salaryColumn.setCellValueFactory(new PropertyValueFactory<>("Salary"));
        tableView.getItems().addAll((DBUtility.getEmployees()));
    }
}

