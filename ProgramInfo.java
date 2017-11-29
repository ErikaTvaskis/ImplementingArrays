/* **********************************************************
 * Programmer:      Erika Tvaskis
 * Class:           CS30S
 * Assignment:      Program Info
 * Description:     Prints banner
 * *************************************************************
 */

public class ProgramInfo {  
    // begin class
 	
//CLASS VARIABLES
     
    private static String AssignmentQuestionData = "";  
    //Assignment Name
    private static String AssignmentNameData = ""; 
    //Question Number
                
//CONSTRUCTORS
                
/***************************************************
* Purpose:      Prints banner with the assignment and question
* In:           None
* Out:          None
****************************************************/
    public ProgramInfo(){  
        AssignmentQuestionData = "";
    } //End of default constructor    
            
/***************************************************
* Purpose:      Prints banner with the assignment name
* In:           None
* Out:          None
****************************************************/
    public ProgramInfo(String A){ 
        AssignmentQuestionData = A;
    } //End of initialized constructor
            
/***************************************************
* Purpose:      Prints banner with assignment and question
* In:           None
* Out:          None
****************************************************/
    public ProgramInfo(String A, String B){ 
        AssignmentQuestionData = A;
        AssignmentNameData = B;
    } //End of initialized constructor

//ACCESSORS
            
/***************************************************
* Purpose:      Gets assignment name
* In:           None
* Out:          Assignment Name
****************************************************/
    public String getAssignment(){
        String assignment = AssignmentQuestionData;
        return assignment;
    }//end getassignment 
    
/***************************************************
* Purpose:      Gets class name
* In:           Class name
* Out:          Class name
****************************************************/
    public String getClassData() {
        String classData = "CS30S";
        return classData;
    }//end of getclassname
    
/***************************************************
* Purpose:      Gets my name
* In:           My name
* Out:          My name
****************************************************/
    public String getName(){
        String nameData = "Erika Tvaskis";
        return nameData;
    }//end name of programmer
    
/***************************************************
* Purpose:      Gets question number
* In:           None
* Out:          Question number
****************************************************/
    public String getAssignmentName() {
        String AssignmentName = AssignmentNameData;
        return AssignmentName;
    }//End getAssignmentName
    
/***************************************************
* Purpose:      Prints end of processing
* In:           None
* Out:          "End of the processing"
****************************************************/
    public String endProgram(){
        String endProgram = "end of processing";
        return endProgram;
    }//end of String theprogram
            
/***************************************************
* Purpose:      Prints everything all together
* In:           None
* Out:          The program info
****************************************************/
    public String toString(){
        String programInfo= "";
        programInfo =  "*********************************\n";
        programInfo += "Name:        " + this.getName() + "\n";
        programInfo += "Class:       " + this.getClassData() + "\n";
        programInfo += "Assignment: " +  this.getAssignmentName() + "\n";
        programInfo += "***********************************\n";
        return programInfo;
    } //End of toString
     
 }  //End of class