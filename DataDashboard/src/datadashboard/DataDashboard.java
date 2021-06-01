/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datadashboard;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Ahmed Diab
 */
public class DataDashboard extends Application {

    @Override
    public void start(Stage primaryStage) {
        
        AdminstorPage firstPage=new AdminstorPage();
        
        readXLSXData dataTable=new readXLSXData();
        
        
        // create 4 objects from class TeamMember.
        TeamMember member1 = new TeamMember("Ahmed Diab", "Technical Lead", 'm', "am265119@bhcc.edu", 95);
        TeamMember member2 = new TeamMember("Cristian Lopez", "Designer", 'm', "c.resttrepolopez@bhcc.edu", 65);
        TeamMember member3 = new TeamMember("Supawadee Phakdee", "Facilitator", 'f', "sphakdee@bhcc.edu", 33);
        TeamMember member4 = new TeamMember("Zhong Zheng", "Builder", 'm', "zz203444@bhcc.edu", 20);
        
        // add activities to member1.
        member1.addActivity(new Activities("Remote Work", 55, new ProgressBar(0.55)));
        member1.addActivity(new Activities("Skill Development - Part 1", 65, new ProgressBar(0.65)));
        member1.addActivity(new Activities("Deconstruct your brief", 74, new ProgressBar(0.74)));
        member1.addActivity(new Activities("Build your Project Plan", 98, new ProgressBar(0.98)));
        member1.addActivity(new Activities("Investigation", 87, new ProgressBar(0.87)));
        member1.addActivity(new Activities("Status Update #1", 91, new ProgressBar(0.91)));
        member1.addActivity(new Activities("Skill Development - Part 2", 47, new ProgressBar(0.47)));
        member1.addActivity(new Activities("Status Update", 81, new ProgressBar(0.81)));
        member1.addActivity(new Activities("Project Report", 50, new ProgressBar(0.50)));
        member1.addActivity(new Activities("Project Presentation", 97, new ProgressBar(0.97)));
        
        // add activities to member2.
        member2.addActivity(new Activities("Remote Work", 91, new ProgressBar(0.91)));
        member2.addActivity(new Activities("Skill Development - Part 1", 93, new ProgressBar(0.93)));
        member2.addActivity(new Activities("Deconstruct your brief", 82, new ProgressBar(0.82)));
        member2.addActivity(new Activities("Build your Project Plan", 47, new ProgressBar(0.47)));
        member2.addActivity(new Activities("Investigation", 28, new ProgressBar(0.28)));
        member2.addActivity(new Activities("Status Update #1", 59, new ProgressBar(0.59)));
        member2.addActivity(new Activities("Skill Development - Part 2", 29, new ProgressBar(0.29)));
        member2.addActivity(new Activities("Status Update", 52, new ProgressBar(0.52)));
        member2.addActivity(new Activities("Project Report", 68, new ProgressBar(0.68)));
        member2.addActivity(new Activities("Project Presentation", 15, new ProgressBar(0.15)));
        
        // add activities to member3.
        member3.addActivity(new Activities("Remote Work", 51, new ProgressBar(0.51)));
        member3.addActivity(new Activities("Skill Development - Part 1", 13, new ProgressBar(0.13)));
        member3.addActivity(new Activities("Deconstruct your brief", 28, new ProgressBar(0.28)));
        member3.addActivity(new Activities("Build your Project Plan", 49, new ProgressBar(0.49)));
        member3.addActivity(new Activities("Investigation", 91, new ProgressBar(0.91)));
        member3.addActivity(new Activities("Status Update #1", 88, new ProgressBar(0.88)));
        member3.addActivity(new Activities("Skill Development - Part 2", 81, new ProgressBar(0.81)));
        member3.addActivity(new Activities("Status Update", 71, new ProgressBar(0.71)));
        member3.addActivity(new Activities("Project Report", 28, new ProgressBar(0.28)));
        member3.addActivity(new Activities("Project Presentation", 14, new ProgressBar(0.14)));
        
        // add activities to member4.
        member4.addActivity(new Activities("Remote Work", 31, new ProgressBar(0.31)));
        member4.addActivity(new Activities("Skill Development - Part 1", 69, new ProgressBar(0.69)));
        member4.addActivity(new Activities("Deconstruct your brief", 38, new ProgressBar(0.38)));
        member4.addActivity(new Activities("Build your Project Plan", 23, new ProgressBar(0.23)));
        member4.addActivity(new Activities("Investigation", 19, new ProgressBar(0.19)));
        member4.addActivity(new Activities("Status Update #1", 19, new ProgressBar(0.19)));
        member4.addActivity(new Activities("Skill Development - Part 2", 41, new ProgressBar(0.41)));
        member4.addActivity(new Activities("Status Update", 29, new ProgressBar(0.29)));
        member4.addActivity(new Activities("Project Report", 34, new ProgressBar(0.34)));
        member4.addActivity(new Activities("Project Presentation", 58, new ProgressBar(0.58)));


        Text teamName = new Text("Team Discovery");
        teamName.setFill(Color.SILVER);
        teamName.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
        
        // creating an array list of TeamMember and adding the members to it.
        ArrayList<TeamMember> memberList = new ArrayList<>();
        memberList.add(member1);
        memberList.add(member2);
        memberList.add(member3);
        memberList.add(member4);
        
        // creating a grid pane and adding the team name to it.
        GridPane pane = new GridPane();
        pane.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, null, null)));
        pane.setHgap(7);
        pane.setVgap(7);
        pane.add(teamName, 30, 35);
        
        // creating a back button.
        Button backBtn=new Button();
        backBtn.setText("Back");
        backBtn.setMinSize(60, 30);
        pane.add(backBtn, 30, 36);//adding button go back to the pane.
        
        
        pane.add(member1.getRoot(), 9, 20);
        pane.add(member2.getRoot(), 50, 20);
        pane.add(member3.getRoot(), 9, 40);
        pane.add(member4.getRoot(), 50, 40);
        
        // creating a scene and adding the pane to it.
        Scene scene = new Scene(pane, 1040, 800);
        
        primaryStage.setTitle("Dashboard"); // set the primary stage title.
        primaryStage.setScene(scene); // add scene to primary stage.
        primaryStage.setResizable(false); // prevent the stage from getting resized.
        
        boolean loginB;
        
        
        try{
            
            firstPage.LoginStart();
            loginB = firstPage.loginVerify;
            if(loginB)
            {
                firstPage.close();
                dataTable.displayData(primaryStage);
                
                
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
            
        
        // when click on the back button, hide the primary stage, and open the data table page.
        backBtn.setOnAction(e->{
            
            primaryStage.hide();
            dataTable.Show();
        });
        
        
        // loop through the array list of members.
        for (int i = 0; i < memberList.size(); i++) {
            ImagePattern imagePattern2 = new ImagePattern(memberList.get(i).getGenderImage());
            // create a circle.
            Circle circle = new Circle(30);
            circle.setFill(imagePattern2);   // put the image inside the circle.
            Text email = new Text("Email:");
            email.setFill(Color.SILVER);
            email.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
            
            // create a text of the member name.
            Text name = new Text(memberList.get(i).getName());
            name.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
            name.setFill(Color.SILVER);
            
            // create a text of the member role.
            Text role = new Text(memberList.get(i).getRole());
            role.setFont(Font.font("Verdana", FontWeight.THIN, 15));
            role.setFill(Color.SILVER);
            
            // create a text of the member email.
            Text memberEmail = new Text(memberList.get(i).getEmail());
            memberEmail.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
            memberEmail.setFill(Color.SILVER);
            
            // create a table.
            TableView table = new TableView();
            // create a column activities.
            TableColumn activities = new TableColumn("Activities");
            
            // create a nested column from Activities called Activity Name.
            TableColumn activityName = new TableColumn("Activity Name");
            activityName.setStyle("-fx-alignment: CENTER;");

            activityName.setCellValueFactory(
                    new PropertyValueFactory<Activities, String>("activityName"));
            activityName.setMinWidth(450);
            
            // create a nested column from Activities called Activity Completion Percentage.
            TableColumn activityCompleted = new TableColumn("Activity Completion Percentage");
            activityCompleted.setStyle("-fx-alignment: CENTER;");
            activityCompleted.setMinWidth(450);

            activityCompleted.setCellValueFactory(
                    new PropertyValueFactory<Activities, String>("activityPercentage"));

            activityCompleted.setCellValueFactory(
                    new PropertyValueFactory<Activities, ProgressBar>("activityPercentageBar"));

            
            activities.getColumns().addAll(activityName, activityCompleted);
            table.getColumns().addAll(activities);
            table.setItems(memberList.get(i).getActivityList());
            
            // create VBox and add name and role to it.
            VBox vbox = new VBox(7);
            vbox.setPadding(new Insets(15, 5, 5, 5));
            vbox.getChildren().addAll(name, role);
            
            // create topPane and add circle, vbox, email and member email to it.
            GridPane topPane = new GridPane();
            topPane.setHgap(7);
            topPane.add(circle, 4, 0);
            topPane.add(vbox, 5, 0);
            topPane.add(email, 45, 0);
            topPane.add(memberEmail, 46, 0);
            topPane.setBackground(new Background(new BackgroundFill(Color.GREY, null, null)));
            
            // create BorderPane and set pane2 at the top, and table at the center.
            BorderPane pane2 = new BorderPane();
            pane2.setPadding(new Insets(5, 5, 5, 5));
            pane2.setTop(topPane);
            pane2.setCenter(table);
            
            // add the pane to the scene.
            Scene scene2 = new Scene(pane2, 950, 700);
            
            Stage stage2 = new Stage();
            stage2.setTitle("Student Data");
            stage2.setScene(scene2);
            
            // when click on the member button, open up the member page.
            memberList.get(i).getBtn().setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    stage2.show();
                }
            });
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
