import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.*;
import java.util.Optional;
import java.util.Scanner;


public class HighScore extends Pane{
    public static String[] nameList = new String[10];
    public static String[] scoreList = new String[10];
    public String[][]  testScores = new String[10][2];
    private static int counter;
    public String name = "";
    public String score = "";
    public static TableView tableView = new TableView();
    public static int count = 1;
    TableView<HighScore> table;
    private static ObservableList<HighScore> data = FXCollections.observableArrayList();



    public HighScore(){

    }

    public HighScore(String name, String score) {
        this.name = name;
        this.score = score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
    public String getName(){
        return name;
    }
    private static Pane scoreboardPieces(){
        Pane scPieces = new Pane();
        TableColumn<String, HighScore> column1 = new TableColumn<>("First Name");
        column1.setCellValueFactory(new PropertyValueFactory<>("Name"));

        TableColumn<String, HighScore> column2 = new TableColumn<>("Score");
        column2.setCellValueFactory(new PropertyValueFactory<>("Score"));
        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.sort();
        VBox vbox = new VBox(tableView);
        tableView.setPlaceholder(new Label("No rows to display"));
         scPieces.getChildren().add(vbox);
        return scPieces;
    }


    public static Pane menuAddScoreboard() throws IOException
    {
        tableView.getColumns().clear();
        Pane scoreboard = new Pane();
        addFiles();

        scoreboard.getChildren().add(scoreboardPieces());

        return scoreboard;

    }

    static void addFiles() throws IOException {
        String fileScores= "textFiles\\names.txt";
        String fileNames ="textFiles\\scores.txt";
        Scanner sc = new Scanner(new File(fileScores));
        BufferedReader readerScore = new BufferedReader(new FileReader(fileScores));
        BufferedReader readerName = new BufferedReader(new FileReader(fileNames));

        String name = new String("a");
        String score = new String("a");


        tableView = new TableView();

        while(score != null)
        {

            try {
                name = readerName.readLine();
                score = readerScore.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            nameList(name, score);
        }

        readerName.close();
        readerScore.close();
    }

    public static void checkHighScore(){
        int score = JumpGame.getTotalScore();
        TextInputDialog dialog = new TextInputDialog("");

        dialog.setTitle("Name Entry");
        dialog.setHeaderText("Enter your name:");
        dialog.setContentText("Name:");

        Optional<String> result = dialog.showAndWait();

        result.ifPresent(nameEntered -> {
            String name = (nameEntered);
            output(name, String.valueOf(score));
        });

    }
    public static void output(String first, String score) {
            try {
                if(count == 1) {
                    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("textFiles\\names.txt", true)));
                    out.println("" + first);
                    PrintWriter out2 = new PrintWriter(new BufferedWriter(new FileWriter("textFiles\\scores.txt", true)));
                    out2.println("" + score);
                    out.close();
                    out2.close();
                    count++;
                }
                }
             catch (IOException e) {
        }
    }

    private static void nameList(String readerName, String readerScore) {

/*
        HighScore.nameList[counter] = readerName;
        HighScore.scoreList[counter] = readerScore;*/
         data.add(new HighScore(readerName,readerScore));
         tableView.getItems().addAll(new HighScore(readerName, readerScore));
    }

}
