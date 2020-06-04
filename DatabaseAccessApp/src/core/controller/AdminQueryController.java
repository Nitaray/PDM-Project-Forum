package core.controller;

import core.DatabaseConnectionManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.sql.*;

public class AdminQueryController {
    private static MainController mainController;

    @FXML
    private TextField queryField;
    @FXML
    private TableView resultTable;
    @FXML
    private TextArea resultField;

    private ObservableList<ObservableList> data;

    private void reset() {
        resultField.clear();
        resultTable.getItems().clear();
        resultTable.getColumns().clear();
        resultTable.refresh();
    }

    public void runQuery() {
        reset();
        Connection connection = DatabaseConnectionManager.getDBConnection();
        data = FXCollections.observableArrayList();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryField.getText());
            ResultSetMetaData meta = resultSet.getMetaData();

            StringBuilder result = new StringBuilder();
            int recordFound = 0;

            for (int col = 0; col < meta.getColumnCount(); col++) {
                final int j = col;
                TableColumn column = new TableColumn(meta.getColumnName(col+1));
                column.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>) param -> new SimpleStringProperty(param.getValue().get(j).toString()));
                resultTable.getColumns().add(column);
            }

            while(resultSet.next()){
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=resultSet.getMetaData().getColumnCount(); i++){
                    String res = resultSet.getString(i);
                    if (res == null)
                        row.add("null");
                    else
                        row.add(resultSet.getString(i));
                }
                recordFound++;
//                System.out.println("Row [1] added "+row );
                data.add(row);
            }
            result.append(String.format("Found %d records satisfying the condition in the query", recordFound));
            resultTable.setItems(data);
            resultField.setText(result.toString());
        } catch (SQLException e) {
            e.printStackTrace();
            resultTable.setPlaceholder(new Label("Something went wrong! Sorry for the inconvenience!"));
            resultField.setText(e.getMessage());
        }

    }
}
