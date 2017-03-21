package lab13;
/**
 *@author Aoife Sayers MM t00170881
 *@version 1.0
 *@since 2015-11-20
 JMenu
 */

import java.io.*;  // needed for saving arrays of bicycles to file
/** minimal class which models a bicycle */
public class User implements Serializable{  // needed for saving
	
	//attributes
	private String name;
	private String initials;
	private double score;
	
	public  User( String n, double s ){
		name = n;
		initials = "unknown initials";
		score = s;
	}
	
	public  User( String n ){
		name = n;
		initials = "unknown initials";
	}
	
	/**Single argument constructor 
	 *@param gives name and initials default value*/
	public  User( ){
		name = "unknown name";
		initials = "unknown initials";
	}
	
	/** mutator method to set the name of the user
	*@param nameof the User */
	public void setName(String n){
		name = n;
	}
	
	/** mutator method to set the initials of the user
	*@param initials of the User */
	public void setInitials(String i){
		initials = i;
	}
	/** mutator method to set the name of the user
	*@param of the User */
	public void setScore(double s){
		score = s;
	}
	/** acessor method to return the name of the user
	*@return the number of the User */
	public String getName(){
	  return name;	
	}
	/** acessor method to return the initials of the user
	*@return the initials of the User */
	public String getInitials(){
	  return initials;	
	}
	/** acessor method to return the score of the user
	*@return the score of the User */
	public double getScore(){
	  return score;	
	}
	
	public String toString() {
		return "\t" + name + "\t " + initials + "\t " + score;
	}
}