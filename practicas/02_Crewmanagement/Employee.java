
package crewmanagement;

public class Employee {
    
    String name, surname, dni;
    Turn[] turns = null;
    int countTurn = 0;
  
    /**
     *  Request constructor, default
     */
    public Employee() {

    }

    /**
     *  Overloaded constructor
     */
    public Employee(String aName, String aSurname) {
        
        if (aName != null && aSurname != null) {   
            name = aName;
            surname = aSurname;
        }
    } 

    public Employee(String adni, String aName, String aSurname) {
        
        if (aName != null && aSurname != null && adni != null) {   
            name = aName;
            surname = aSurname;
            setDNI(adni);
        }
    } 
        
    /**
     * Set a valid employee's name
     */
    public void setName(String aName) {
        if (aName != null)
            this.name = aName;
        
    } 

    /**
     * Get employee's name
     */
    public String getName() {
        if ( name == null)
            return "";
        return name;
    } 

    /**
     * Set a valid employee's surname
     */  
    public void setSurname(String aSurname) {
            this.surname = aSurname;
    } 

    /**
     * Get employee's surname
     */
    public String getSurname() {
        if ( surname == null)
            return "";
        return surname;
    } 

    /**
     * Get's employee's full name,  
     * if nameInUppercase and surnameInUpperCase value is true 
     * returns uppercase full name otherwise returns the original value 
     */
    public String getFullName(boolean nameInUppercase, boolean surnameInUpperCase){
        String  fullname = ""; 

        if (nameInUppercase && getName() != null)
            fullname = getName().toUpperCase();
        else 
            fullname = getName();
        if ( getName() != "" && getSurname() !="")
            fullname += ", ";
        if (surnameInUpperCase && getSurname() != null)
            fullname += getSurname().toUpperCase();
        else
            fullname += getSurname();
                
        return  fullname;
    } 

    /**
     *  Set a valid DNI
     */
    public void setDNI(String dni){
        
        if(checkDni(dni))
            this.dni = dni;
    }

    /**
     *  Get a DNI
     */
    public String getDNI(){
        if (dni == null)
            dni="";
        return this.dni;
    }
    
    public int getTurnCount() {
        if (turns != null)
            return (int) turns.length;
        else
            return 0;
    }
    
        /**
     * adds one turn to the employee
     */
    public void addTurn(Turn newturn){
        if (newturn != null)
            turns = addNewTurn(newturn); 
    }
    
    /**
     * removes employee's daily turns 
     * searchin by name of the day
     */
    public void removeTurn (String aDay){
        
        if(getTurnCount() != 0){
            for(int i=0; i < getTurnCount(); i++){
                if ( turns[i].day.equals( aDay.toUpperCase()))
                { 
                    turns = removeATurn(i);
                } 
            }      
        }
        //turns = removeATurn(String aDay);
    }

    /**
     * Returns the turn in that position
     * returns null if it doesn't exists
     */
    public Turn getTurnAt(int anIndex){
        
        if (turns[anIndex] == null)
            return null;
        else
            return turns[anIndex];
    }

    /**
     *  returns the turns asigned to an employee 
     */
    public Turn[] getTurns(){
        return this.turns;
    }
    
    /**
     *  validates spanish dni
     */ 
    public boolean checkDni(String dni) {
        if (dni == null )
            return false;
        
        int position=0;
        String tmpdni = (dni.trim()).toUpperCase();
        String numdni="";
        String letter = "";
        String letters =  "TRWAGMYFPDXBNJZSQVHLCKE";
        
        //divide string part and numeric part
        for(int i=0; i < tmpdni.length(); i++){
            if( tmpdni.charAt(i) >= '0'  && tmpdni.charAt(i) <= '9')
               numdni += tmpdni.charAt(i);
            else if (tmpdni.charAt(i) != ' ' && tmpdni.charAt(i) != '-')
                letter += tmpdni.charAt(i);
        }
     
        // compares letters
        if (numdni != "")   
            position= Integer.parseInt(numdni)%23;
        else
            return false;
        if ( (letter != null) && (letter.length() == 1)
             && letter.equals( "" + letters.charAt(position) ))
            return true;
        else
            return false;
    }
    
    /**
    * Implements add turn, dinamic
    */
    public Turn[] addNewTurn(Turn newturn){
        int size = (int) getTurnCount();
        Turn[] temp;
        
        if (size == 0){
            temp = new Turn[size+1];
            temp[size] = newturn;
        }
        else if (size < 7) {    
            temp = new Turn[size+1];
            for ( int i=0; i < size; i++)
            {
                temp[i] = turns[i];
            }
            temp[size] = newturn; 
        }
        else
            return turns;
        return temp;
    }
    
    /**
    * Implements remove turn, dinamic
    */
    public Turn[] removeATurn(int posdel){
        int size = (int) getTurnCount();
        Turn[] temp=null;
        
        if (size == 0)
            return null;        
        else if (size > 1) {    
            temp = new Turn[size-1];
            for (int i=0; i < posdel;i++)
                temp[i] = turns[i];
            for ( int i=posdel; i < size-1; i++)
                temp[i] = turns[i+1];
        }
        return temp;
    }
}
