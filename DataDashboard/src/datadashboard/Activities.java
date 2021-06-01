/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datadashboard;

import javafx.scene.control.ProgressBar;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.color;

/**
 *
 * @author Ahmed Diab
 */
public class Activities {
    private String activityName;
    private int activityPercentage;
    private ProgressBar activityPercentageBar;
    
    /**
     * constructor.
     * @param activityName
     * @param activityPercentage
     * @param activityPercentageBar 
     */
    public Activities(String activityName, int activityPercentage, ProgressBar activityPercentageBar){
        
        setActivityName(activityName);
        setActivityPercentage(activityPercentage);
        setActivityPercentageBar(activityPercentageBar);
        
    }
    
    /**
     * set activityName.
     * @param activityName 
     */
    public void setActivityName(String activityName){
        this.activityName = activityName;
    }
    
    /**
     * set activityPercentage
     * @param activityPercentage 
     */
    public void setActivityPercentage(int activityPercentage){
        this.activityPercentage = activityPercentage;
    }
    
    /**
     * set activityPercentageBar
     * @param activityPercentageBar 
     */
    public void setActivityPercentageBar(ProgressBar activityPercentageBar){
        activityPercentageBar.setStyle(getColor());
        activityPercentageBar.setMaxWidth(Double.MAX_VALUE);
        this.activityPercentageBar = activityPercentageBar;
    }
    
    /**
     * access to activityName.
     * @return 
     */
    public String getActivityName(){
        return activityName;
    }
    
    /**
     * access to activityPercentage.
     * @return 
     */
    public int getActivityPercentage(){
        return activityPercentage;
    }
    
    /**
     * access to activityPercentageBar.
     * @return 
     */
    public ProgressBar getActivityPercentageBar(){
        return activityPercentageBar;
    }
    
    /**
     * method that returns the color of activityPercentageBar..
     * @return 
     */
    private String getColor(){
        String color = "";
        // if activity percentage is less than or equal 25, set the color of the activityPercentageBar to indianred.
        if(activityPercentage <= 25){
            color = " -fx-accent: indianred;";
        }
        // if activity percentage is in the range of (25 - 50), set the color of the activityPercentageBar to lightsalmon.
        else if(activityPercentage > 25 && activityPercentage <=50){
            color = " -fx-accent: lightsalmon;";
        }
        // if activity percentage is in the range of (50 - 75), set the color of the activityPercentageBar to lightgreen.
        else if(activityPercentage > 50 && activityPercentage <=75){
            color = " -fx-accent: lightgreen;";
        }
        // if activity percentage is in the range of (75 - 100), set the color of the activityPercentageBar to green.
        else if(activityPercentage > 75 && activityPercentage <=100){
            color = " -fx-accent: green;";
        }
        return color;
    }
    
}