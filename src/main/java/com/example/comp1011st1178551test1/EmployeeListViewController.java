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
import java.util.ArrayList;
import java.util.OptionalDouble;
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

    ArrayList<Employee> employees;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("FullName"));
        departmentColumn.setCellValueFactory(new PropertyValueFactory<>("Department"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("Email"));
        salaryColumn.setCellValueFactory(new PropertyValueFactory<>("Salary"));

        employees = DBUtility.getEmployees();

        tableView.getItems().addAll((employees));
        updateLabels();
    }

    private void updateLabels(){
        numberEmployeesLabel.setText("Number of Employees: " + tableView.getItems().size());
        OptionalDouble averageSalary = tableView.getItems().stream().mapToDouble(Employee::getSalary).average();
        averageSalaryLabel.setText("Average Salary: " + String.format("%.2f",averageSalary.isPresent()?averageSalary.getAsDouble():0));
    }
}

