package com.example.comp1011st1178551test1;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
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
    private BarChart<String, Integer> barChart;

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
        int[] departmentCount= DBUtility.countDepartments();

        XYChart.Series<String,Integer> departmentData = new XYChart.Series<>();
        departmentData.getData().add(new XYChart.Data<>("Sales",departmentCount[0]));
        departmentData.getData().add(new XYChart.Data<>("Marketing",departmentCount[1]));
        departmentData.getData().add(new XYChart.Data<>("Finance",departmentCount[2]));
        departmentData.getData().add(new XYChart.Data<>("HR",departmentCount[3]));
        departmentData.getData().add(new XYChart.Data<>("IT",departmentCount[4]));
        departmentData.getData().add(new XYChart.Data<>("Research",departmentCount[5]));

        barChart.getData().addAll(departmentData);

        tableView.getItems().addAll((employees));

        filterTextField.textProperty().addListener((observableValue, oldValue, newValue) -> {
            filteredTasks(newValue);
        });

        updateLabels();
    }

    private void updateLabels(){
        numberEmployeesLabel.setText("Number of Employees: " + tableView.getItems().size());
        OptionalDouble averageSalary = tableView.getItems().stream().mapToDouble(Employee::getSalary).average();
        averageSalaryLabel.setText("Average Salary: " + String.format("%.2f",averageSalary.isPresent()?averageSalary.getAsDouble():0));
    }

    private void filteredTasks(String searchTerm){
        tableView.getItems().clear();
        tableView.getItems().addAll(employees.stream().filter(employee -> employee.contains(searchTerm)).toList());

        updateLabels();
    }
}

