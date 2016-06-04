/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
*/

package crewmanagement;

public class Turn {
    
    String day;
    int hour;
    int initHour,finisHour;
    
    /**
     *  Request constructor, default
     */
    public Turn(){
        
    }
    
    /**
     * overloaded constructor 
     */
    public Turn(String aDay){
        if (aDay != null)
        day = aDay.toUpperCase();
    }
    
    public Turn(String aDay, int aInitHour, int aFinishHour){
        day = aDay.toUpperCase();
        if (checkHour(aInitHour))
            this.initHour = aInitHour;
        if (checkHour(aFinishHour))
            this.finisHour=aFinishHour;
    }
    
    /**
     *  Set the name of the day in uppercase 
     */
    public void setDay(String aday){
       if (aday != null)
           day = aday.toUpperCase();
    }
    
    /**
     *  Gets the name of the day 
     */    
    public String getDay(){
        return day;
    }
 
    /**
     *  Set the start time of the turn 
     */
    public void setInitHour(int ahour){
    
        if (checkHour(ahour))
            this.initHour = ahour;
    }

    /**
     *  Get the start time of the turn 
     */
    public int getInitHour(){
        return initHour;
    }

    /**
     *  Set the final hour of the turn 
     */
    public void setFinishHour(int finisHour){
        
        if (checkHour(finisHour))
            this.finisHour = finisHour; 
    }
 
    /**
     *  Get the final hour of the turn 
     */
    public int getFinishHour()  {
        return finisHour;
    }
    
    /**
     * Validate the time range
     */
    public boolean checkHour(int newhour) {
       
        if( newhour < 0 || newhour > 23)
            return false;
        else
            return true;
    } 
  
}


