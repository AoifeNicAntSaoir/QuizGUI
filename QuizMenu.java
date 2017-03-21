//Import Statements
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;  
import java.util.*;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class QuizMenu extends JFrame implements ActionListener,Serializable{
//Declaring public objects
     JMenu fileMenu,userMenu;
     JLabel questionno;
     JLabel question;
     JLabel blankspace1, blankspace2, blankspace3;
     JLabel score;     
     JButton q1option1Button, q1option2Button, q1option3Button, helpButton, finishButton;
     JButton q2option1Button, q2option2Button, q2option3Button;
     JButton q3option1Button, q3option2Button, q3option3Button;
     JButton q4option1Button, q4option2Button, q4option3Button;
     JButton q5option1Button, q5option2Button, q5option3Button;
     User [] users; // an array of users
     Score [] scores;
     int count; 
     final ImageIcon icon = new ImageIcon("Images/tick.png");
     final ImageIcon trophy = new ImageIcon("Images/trophy.png");
 
     QuesAns q1 = new QuesAns(1,"Which of the following is not a keyword in Java?","Boolean",1);
     QuesAns q2 = new QuesAns(2,"Inheritance represents a...","HAS A Relationship",2);
     QuesAns q3 = new QuesAns(3,"Default value of a String variable?","null",3);
     QuesAns q4 = new QuesAns(4,"Method Overloading are methods with...","Same name but different parameters",4);
     QuesAns q5 = new QuesAns(5,"Which of the following deals with Error Handling?","JVM",5);
     
   
     
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
// Driver 
    public static void main( String[] args ){
        QuizMenu frame = new QuizMenu();
        frame.setVisible(true);
    	
    
       //windows adapter added to class
       frame.addWindowListener(new WindowAdapter() {
		
	//Closing Window -yes no cancel option	
		public void windowClosing(WindowEvent e){
 					int choice = JOptionPane.showConfirmDialog(null,"Shut Down now");
 					if(choice == JOptionPane.YES_OPTION)
 				{
 				final ImageIcon byeicon = new ImageIcon("Images/bye.png"); //Reference: http://www.clipartbest.com/cliparts/9TR/Rgk/9TRRgk7dc.png
			 	JOptionPane.showMessageDialog(null,"Shutting Down now","Bye...",
			 	JOptionPane.PLAIN_MESSAGE,byeicon);	
			 	}
		else if (choice == JOptionPane.NO_OPTION)
			 	JOptionPane.showMessageDialog(null,"You chose no","Make up your mind!",
			 	JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			} // end windowClosing
		  }// end anonymous inner class definition
		); //end of addWindowListener method argument
    
    } //end main
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
 // constructor
    public QuizMenu( ) {
        newSystem();
        //set the frame default properties
        setTitle     ("Java Quiz");
        setSize      (700,600);
        setResizable (true);
        setLocation  (350,100);
        Container pane = getContentPane();
        		pane.setLayout(new GridLayout(16,3));
        		pane.setBackground(new Color(194, 102, 255));	
     	//creates menus
        createFileMenu();
        createUserMenu();
        //and add them to the menubar
        JMenuBar menuBar = new JMenuBar();
        	setJMenuBar(menuBar);
        		menuBar.add(fileMenu);
        		menuBar.add(userMenu);
        //sets favicon
		ImageIcon favicon = new ImageIcon("Images/quiz.png"); //Reference for favicon http://4.bp.blogspot.com/-trxswJemF1E/VRkseCOG5EI/AAAAAAAADhU/pPZLjn6QKmE/s1600/quiz.png
		setIconImage(favicon.getImage());
        
       
        //Question 1     	
     	questionno = new JLabel("Question " + q1.getQuestionNo() + ".");
     	questionno.setFont(new Font("Arial", Font.BOLD, 18));
     	question = new JLabel(q1.getQuestion(),SwingConstants.CENTER);
     	question.setForeground(Color.WHITE);
     	question.setFont(new Font("Arial", Font.PLAIN, 16));
     	blankspace1= new JLabel("");
     	score = new JLabel("Score Value: " + q1.getScore() + "/5");
     	score.setForeground(Color.PINK);
     	score.setFont(new Font("Arial", Font.ITALIC, 14));
     	pane.add(questionno);
     	pane.add(question);  
     	pane.add(blankspace1);          	 
     	
     	q1option1Button = new JButton(q1.getAnswer());
     	q1option2Button = new JButton("static");
     	q1option3Button = new JButton("void");
     	pane.add(q1option1Button);
     	pane.add(q1option2Button);
     	pane.add(q1option3Button);
     	q1option1Button.addActionListener(new q1option1ButtonHandler());
     	q1option2Button.addActionListener(new q1option2ButtonHandler());
     	q1option3Button.addActionListener(new q1option3ButtonHandler());
     	blankspace2 = new JLabel("");
     	blankspace3 = new JLabel("");
     	
     	pane.add(score);
		pane.add(blankspace2);
		pane.add(blankspace3);
		
		
		
        //Question 2
     	questionno = new JLabel("Question " + q2.getQuestionNo() + ".");
     	questionno.setFont(new Font("Arial", Font.BOLD, 18));
     	question = new JLabel(q2.getQuestion(),SwingConstants.CENTER);
     	question.setFont(new Font("Arial", Font.PLAIN, 16));
     	question.setForeground(Color.WHITE);
     	score = new JLabel("Score Value: " + q2.getScore() + "/5");
     	score.setForeground(Color.PINK);
     	score.setFont(new Font("Arial", Font.ITALIC, 14));
     	pane.add(questionno);
     	pane.add(question);
     	blankspace3 = new JLabel("");
     	pane.add(blankspace3);
    	 
     	q2option1Button = new JButton("IS A Relationship");
     	q2option2Button = new JButton(q2.getAnswer());
     	q2option3Button = new JButton("INCLUDES Relationship");
     
     	pane.add(q2option1Button);
     	pane.add(q2option2Button);
     	pane.add(q2option3Button);
     	
     	q2option1Button.setEnabled(false);	
  		q2option2Button.setEnabled(false);
     	q2option3Button.setEnabled(false);
     	     	
     	q2option1Button.addActionListener(new q2option1ButtonHandler());
     	q2option2Button.addActionListener(new q2option2ButtonHandler());
     	q2option3Button.addActionListener(new q2option3ButtonHandler());
     	pane.add(score);
     	blankspace2 = new JLabel("");
     	blankspace3 = new JLabel("");
     	pane.add(blankspace2);
     	pane.add(blankspace3);
     	
     	//Question 3
     	questionno = new JLabel("Question " + q3.getQuestionNo() + ".");
     	questionno.setFont(new Font("Arial", Font.BOLD, 18));
     	question = new JLabel(q3.getQuestion(),SwingConstants.CENTER);
     	question.setFont(new Font("Arial", Font.PLAIN, 16));
     	question.setForeground(Color.WHITE);
     	score = new JLabel("Score Value: " + q3.getScore() + "/5");
     	score.setForeground(Color.PINK);
     	score.setFont(new Font("Arial", Font.ITALIC, 14));
     	pane.add(questionno);
     	pane.add(question);
     	blankspace3 = new JLabel("");
     	pane.add(blankspace3);
    	 
     	q3option1Button = new JButton("\" \"");
     	q3option2Button = new JButton("not defined");
     	q3option3Button = new JButton(q3.getAnswer());
     	
     	pane.add(q3option1Button);
     	pane.add(q3option2Button);
     	pane.add(q3option3Button);
     	
     	q3option1Button.setEnabled(false);
     	q3option2Button.setEnabled(false);
     	q3option3Button.setEnabled(false);
     	
     	q3option1Button.addActionListener(new q3option1ButtonHandler());
     	q3option2Button.addActionListener(new q3option2ButtonHandler());
     	q3option3Button.addActionListener(new q3option3ButtonHandler());
        pane.add(score); 
        blankspace2 = new JLabel("");
        blankspace3 = new JLabel("");
        pane.add(blankspace2);
        pane.add(blankspace3);
        
        q3option1Button.setEnabled(false);	
  		q3option2Button.setEnabled(false);
     	q3option3Button.setEnabled(false);
     		    	
    	
    	//Question 4
		questionno = new JLabel("Question " + q4.getQuestionNo() + ".");
		questionno.setFont(new Font("Arial", Font.BOLD, 18));
     	question = new JLabel(q4.getQuestion(),SwingConstants.CENTER);
     	question.setFont(new Font("Arial", Font.PLAIN, 16));
     	question.setForeground(Color.WHITE);
     	blankspace3 = new JLabel("");
     	score = new JLabel("Score Value: " + q4.getScore() + "/5");
     	score.setForeground(Color.PINK);
     	score.setFont(new Font("Arial", Font.ITALIC, 14));
     	pane.add(questionno);
     	pane.add(question);
     	pane.add(blankspace3);
    	 
     	q4option1Button = new JButton("Same name but different return types");
     	q4option2Button = new JButton(q4.getAnswer());
     	q4option3Button = new JButton("None of the above");
     	
     	pane.add(q4option1Button);
     	pane.add(q4option2Button);
     	pane.add(q4option3Button);
     	
     	q4option1Button.setEnabled(false);
     	q4option2Button.setEnabled(false);
     	q4option3Button.setEnabled(false);
     	
     	q4option1Button.addActionListener(new q4option1ButtonHandler());
     	q4option2Button.addActionListener(new q4option2ButtonHandler());
     	q4option3Button.addActionListener(new q4option3ButtonHandler());
        pane.add(score);
        blankspace2 = new JLabel(""); 
        blankspace3 = new JLabel("");
        pane.add(blankspace2);
        pane.add(blankspace3);
        	
        
        //Question 5
		questionno = new JLabel("Question " + q5.getQuestionNo() + ".");
		questionno.setFont(new Font("Arial", Font.BOLD, 18));
     	question = new JLabel(q5.getQuestion(),SwingConstants.CENTER);
     	question.setFont(new Font("Arial", Font.PLAIN, 16));
     	question.setForeground(Color.WHITE);
     	blankspace3 = new JLabel("");
     	score = new JLabel("Score Value: " + q5.getScore() + "/5");
     	score.setForeground(Color.PINK);
     	score.setFont(new Font("Arial", Font.ITALIC, 14));
     	pane.add(questionno);
     	pane.add(question);
     	pane.add(blankspace3);
    	 
     	q5option1Button = new JButton(q5.getAnswer());
     	q5option2Button = new JButton("JBM");
     	q5option3Button = new JButton("JWM");
     	
     	pane.add(q5option1Button);
     	pane.add(q5option2Button);
     	pane.add(q5option3Button);
     	
     	q5option1Button.setEnabled(false);
     	q5option2Button.setEnabled(false);
     	q5option3Button.setEnabled(false);
     	
     	q5option1Button.addActionListener(new q5option1ButtonHandler());
     	q5option2Button.addActionListener(new q5option2ButtonHandler());
     	q5option3Button.addActionListener(new q5option3ButtonHandler());
        pane.add(score);
       	blankspace2 = new JLabel("");
       	blankspace3 = new JLabel("");
       	pane.add(blankspace2);
       	pane.add(blankspace3);
       	
       	//FINISH BUTTON
       	finishButton = new JButton("Finish Quiz");
       	finishButton.addActionListener(new finishButtonHandler());
       	pane.add(finishButton);
       	finishButton.setEnabled(false);
       	
       //HELP BUTTON
		blankspace1 = new JLabel("");
		pane.add(blankspace1);	
     	helpButton = new JButton("Help");
     	pane.add(helpButton);
     	helpButton.addActionListener(new helpButtonHandler());
     		
 
     }//end constructor
     
     
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
 //QUESTION 1
 private class q1option1ButtonHandler implements ActionListener{
	
	public void actionPerformed(ActionEvent e) {
		  JOptionPane.showMessageDialog(null,"Correct Answer  \nScore: " + q1.getScore());
			
			
		  	q2option1Button.setEnabled(true);
		  	q2option2Button.setEnabled(true);
		  	q2option3Button.setEnabled(true);
		  	
		 

	} 
  } 
  
  private class q1option2ButtonHandler implements ActionListener{
	
	public void actionPerformed(ActionEvent e) {
		  JOptionPane.showMessageDialog(null,"Wrong answer - Try Again","Error",JOptionPane.ERROR_MESSAGE);
	
	} 
  }
  
    private class q1option3ButtonHandler implements ActionListener{
	
	public void actionPerformed(ActionEvent e) {
		  JOptionPane.showMessageDialog(null,"Wrong answer - Try Again","Error",JOptionPane.ERROR_MESSAGE);
	} 
  }  
  
  //QUESTION 2
  private class q2option1ButtonHandler implements ActionListener{
	// specific to OK button, so no need for an 'if' statement
	public void actionPerformed(ActionEvent e) {
		  JOptionPane.showMessageDialog(null,"Wrong answer - Try Again","Error",JOptionPane.ERROR_MESSAGE);	
	} 
  }
  
  private class q2option2ButtonHandler implements ActionListener{
	
	public void actionPerformed(ActionEvent e) {
		  JOptionPane.showMessageDialog(null,"Correct Answer \nScore: " + q2.getScore());
		  
		  	q3option1Button.setEnabled(true);
		  	q3option2Button.setEnabled(true);
		  	q3option3Button.setEnabled(true);
		
	} 
  }  
  
    private class q2option3ButtonHandler implements ActionListener{
	
	public void actionPerformed(ActionEvent e) {
		  JOptionPane.showMessageDialog(null,"Wrong answer - Try Again","Error",JOptionPane.ERROR_MESSAGE);
		  	
	} 
  } 
  
   //QUESTION 3
  private class q3option1ButtonHandler implements ActionListener{
	
	public void actionPerformed(ActionEvent e) {
		  JOptionPane.showMessageDialog(null,"Wrong answer - Try Again","Error",JOptionPane.ERROR_MESSAGE);
		  		 
	}
  } 
  
  private class q3option2ButtonHandler implements ActionListener{
	
	public void actionPerformed(ActionEvent e) {
		  JOptionPane.showMessageDialog(null,"Wrong answer - Try Again","Error",JOptionPane.ERROR_MESSAGE);
	} 
  }  
  
    private class q3option3ButtonHandler implements ActionListener{
	
	public void actionPerformed(ActionEvent e) {
		  JOptionPane.showMessageDialog(null,"Correct Answer \nScore: " + q3.getScore());
		  q4option1Button.setEnabled(true);
		  q4option2Button.setEnabled(true);
		  q4option3Button.setEnabled(true);
		  	
	}
  } 
  
  //QUESTION 4
  private class q4option1ButtonHandler implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		  JOptionPane.showMessageDialog(null,"Wrong answer - Try Again","Error",JOptionPane.ERROR_MESSAGE);	
	} 
  } 
  
  private class q4option2ButtonHandler implements ActionListener{
	
	public void actionPerformed(ActionEvent e) {
		  JOptionPane.showMessageDialog(null,"Correct Answer \nScore: " + q4.getScore());
		  
		  	q5option1Button.setEnabled(true);
		  	q5option2Button.setEnabled(true);
		  	q5option3Button.setEnabled(true);
		  	finishButton.setEnabled(true);
		 
	}
  } 
  
    private class q4option3ButtonHandler implements ActionListener{
	
	public void actionPerformed(ActionEvent e) {
		  JOptionPane.showMessageDialog(null,"Wrong answer - Try Again","Error",JOptionPane.ERROR_MESSAGE);	
			
			} 
  } 
  
  
  //QUESTION 5
  private class q5option1ButtonHandler implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		  JOptionPane.showMessageDialog(null,"Correct Answer \nScore: " + q5.getScore());
		  
  		JOptionPane.showMessageDialog(null,"Congratulations! You finished the quiz! \nScore: 5/5","Finished Quiz",JOptionPane.PLAIN_MESSAGE,trophy);	
	}
  } 
  
  private class q5option2ButtonHandler implements ActionListener{
	
	public void actionPerformed(ActionEvent e) {
		  JOptionPane.showMessageDialog(null,"Wrong answer - Try Again","Error",JOptionPane.ERROR_MESSAGE);
		  
		  	
		 
	} 
  } 
  
    private class q5option3ButtonHandler implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		  JOptionPane.showMessageDialog(null,"Wrong answer - Try Again","Error",JOptionPane.ERROR_MESSAGE);
		  	
	} 
  } 
  
  //FINISH BUTTON
  	private class finishButtonHandler implements ActionListener {
  		public void actionPerformed(ActionEvent e)
  		{

  		JOptionPane.showMessageDialog(null,"Congratulations! You finished the quiz! \nScore: 5/5","Finished Quiz",JOptionPane.PLAIN_MESSAGE,trophy);
  		int choice = JOptionPane.showConfirmDialog(null,"Shut Down Now?");
 			if(choice == JOptionPane.YES_OPTION)
 				{
 				final ImageIcon byeicon = new ImageIcon("bye.png"); //Reference: http://www.clipartbest.com/cliparts/9TR/Rgk/9TRRgk7dc.png
			 	JOptionPane.showMessageDialog(null,"Shutting Down now","Bye...",
			 	JOptionPane.PLAIN_MESSAGE,byeicon);	
			 	System.exit(0);
			 	}
			else if (choice == JOptionPane.NO_OPTION)
			 	JOptionPane.showMessageDialog(null,"You chose no","Make up your mind!",
			 	JOptionPane.PLAIN_MESSAGE);
				newSystem();
  		  		
  		  		
  		}
  		
  	}  
  //HELP BUTTON 
    private class helpButtonHandler implements ActionListener{
	// specific to OK button, so no need for an 'if' statement
	public void actionPerformed(ActionEvent e) {
		JTextArea area1 = new JTextArea();
		area1.setText("Question No: \t\tAnswer:\n");
		area1.append("\n" + q1.getQuestionNo() + "\t\t" + q1.getAnswer());
		area1.append("\n" + q2.getQuestionNo() + "\t\t" + q2.getAnswer());
		area1.append("\n" + q3.getQuestionNo() + "\t\t" + q3.getAnswer());
		area1.append("\n" + q4.getQuestionNo() + "\t\t" + q4.getAnswer());
		area1.append("\n" + q5.getQuestionNo() + "\t\t" + q5.getAnswer());

		JOptionPane.showMessageDialog(null,area1,"Hints",JOptionPane.PLAIN_MESSAGE);
	} // end actionPerformed
  } // end smileButtonHandler inner class 
  
///////////////////////////////////////////////////////////////////////////////////////////
//FILE MENU METHODS FOR MENU ITEMS
// Save 	Open	OpenFile	New File	Quit
	
	//SAVE - saves to users.dat
	public void save() throws IOException {
      	ObjectOutputStream os;
      	os = new ObjectOutputStream(new FileOutputStream ("users.dat"));
      	os.writeObject(users);
      	os.close();
      }
      
      //OPEN
      /** loads an array of users from the file "users.dat"*/
      public void open() {
      	count = 0;
      	try{
      	  ObjectInputStream is;
      	  is = new ObjectInputStream(new FileInputStream ("users.dat"));
         	users  = (User []) is.readObject();
      	  is.close(); 
      	}
      	catch(Exception e){
      		JOptionPane.showMessageDialog(null,"open didn't work","Error",JOptionPane.ERROR_MESSAGE);
      		e.printStackTrace();
      	}
      	
      	// how many valid bike records?
      	while (users[count] !=null)
      	   count++;
      } // end open()
     
     //OPEN FILE
     public void OpenFile() {
     	JFileChooser chooser;
        	File         file, directory;
        	int          status;

       	 	chooser = new JFileChooser( );
        	status = chooser.showOpenDialog(null);
     
        	if (status == JFileChooser.APPROVE_OPTION) {
            	file      = chooser.getSelectedFile();
            	directory = chooser.getCurrentDirectory();

            	JOptionPane.showMessageDialog(null,
            	"Directory: " + directory.getName() +
            	"\nFile selected to open: " + file.getName() +
            	"\nFull path name: " +file.getAbsolutePath());
            	}
            else {
            	JOptionPane.showMessageDialog(null, "Open File dialog canceled");
        		}
        		// now show a 'save' dialog
        		status = chooser.showSaveDialog(null);
        		if (status == JFileChooser.APPROVE_OPTION) {
            file      = chooser.getSelectedFile();
            directory = chooser.getCurrentDirectory();

            JOptionPane.showMessageDialog(null,
            "Directory: " + directory.getName() +
            "\nFile selected to save to: " + file.getName() +
            "\nFull path name: " +file.getAbsolutePath());

        } else {
            JOptionPane.showMessageDialog(null, "Save File dialog canceled");
        }	
     }//end open file
      
    //New File
      public void newSystem() {
      	users = new User[10];
      	count = 0;
      	JOptionPane.showMessageDialog(null,"New Quiz opened!","Confirmation",JOptionPane.INFORMATION_MESSAGE);
      }
      
    //Quit Dealt with
//END FILE MENU ITEM MEHTODS

//USER MENU ITEM METHODS 
// Add		Display		High Scores
      
     
      //Add (User)
      public void addUser(){
      	User temp = new User();
      	temp.setName(JOptionPane.showInputDialog("Enter Username: "));
      	temp.setInitials(JOptionPane.showInputDialog("Enter Initials:"));
      	temp.setScore(Integer.parseInt(JOptionPane.showInputDialog("Enter your High Score:")));
      	JOptionPane.showMessageDialog(null,"The username you added are as follows: \n\nUsername: " + temp.getName() + 
      																				"\nInitials: " + temp.getInitials() +
      																			"\nScore: " + temp.getScore(),"User Added",
      																				JOptionPane.PLAIN_MESSAGE,icon);
      	users[count] = temp; 
      	count++; 
      } //end addUser
      
      //Display
      public void display(){
      	JTextArea area = new JTextArea();
      
      	if (count>0) {
      	  area.setText("User List:");	
      	  area.setText("User No: \tUsername: \tInitials: \tScore: \n");
      	  for (int i = 0; i<count; i++) 
      	    area.append("\n" + i + " " +users[i].toString());
      	  showMessage(area);
      	}
      	else
      	    JOptionPane.showMessageDialog(null,"No users in the system","Error - no users",JOptionPane.ERROR_MESSAGE);
      } // end display
      
      //High Scores      	
      public void highScores() {
      	JTextArea area1 = new JTextArea();
      	if(count>0)
      	{
      		area1.setText("Username and High Scores:");
      	area1.setText("\nNumber  \tHighScores: \tUsername:");
      	 for (int i = 0; i<count; i++) 
      	    area1.append("\n" + i + "\t" + users[i].getScore() + "\t" + users[i].getName());
      	  JOptionPane.showMessageDialog(null,area1,"High Scores",JOptionPane.PLAIN_MESSAGE);
      	  
      	}
      	else
      		JOptionPane.showMessageDialog(null,"No users in the System","Error - no users",JOptionPane.ERROR_MESSAGE);
      }//end highscores

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Action Peformed
      public void actionPerformed (ActionEvent e) {
   //FILE MENU
      	if (e.getActionCommand() .equals ("Quit")){
      	 showMessage("Shutting down the system");
      	 System.exit(0);
      	}
      	//Save
      	else if (e.getActionCommand() .equals ("Save")){
      	 try{
      	 	save();
      	 	showMessage("Data saved successfully");
      	 } // try
      	 catch (IOException f){
      	 	showMessage("Not able to save the file:\n"+
      	 	"Check the console printout for clues to why ");
      	 	f.printStackTrace();
      	 }// catch
      	}// end save
      	
      	//Open
      	else if (e.getActionCommand() .equals ("Open")){
      	 open();
        display();
      	} //end open
      	
      	//OpenFile
      	else if (e.getActionCommand() .equals("Open file...")){	
       	OpenFile();
      	} //end openfile
      	
      	//New File
      	else if (e.getActionCommand() .equals ("New File")){
      	newSystem();
        } //end new file
        
        
     //USER MENU
      	//Add
      	else if (e.getActionCommand() .equals ("Add")){  
      	   addUser(); // branch to a separate method
      	} //end add
      	
      	//Display
      	else if (e.getActionCommand() .equals ("Display")){
           display();
      	} //end display
      
      	//High Scores
        else if (e.getActionCommand() .equals ("High Scores"))
        {
        	highScores();
        } //end high scores
      	
      
      	else
      	  showMessage("I have no idea what you clicked");
      } // end actionPerformed
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Creating Menu IEMS  
      	//FILE MENU
        private void createFileMenu(){
         // create the menu
      	fileMenu = new JMenu("File");
      	// declare a menu item (re-usable)
      	JMenuItem item;
      	item = new JMenuItem("Save");
      	item.addActionListener(this);
      	fileMenu.add(item);
      	item = new JMenuItem("Open");
      	item.addActionListener(this);
      	fileMenu.add(item);
      	item = new JMenuItem("Open file...");
      	item.addActionListener(this);
      	fileMenu.add(item);
      	item = new JMenuItem("New File");
      	item.addActionListener(this);
      	fileMenu.add(item);
      	// create the 'quit' option
      	fileMenu.addSeparator();
      	item = new JMenuItem("Quit");
      	item.addActionListener(this);
      	fileMenu.add(item);
      }//end creating File Menu Items
      
      //Creating USER MENU ITEMS
      private void createUserMenu(){
      	// create the menu
      	userMenu = new JMenu("Users");
      	// declare a menu item (re-usable)
      	JMenuItem item;
      	
      	item = new JMenuItem("Add");
      	item.addActionListener(this);
      	userMenu.add(item);
      	
      	item = new JMenuItem("Display");
      	item.addActionListener(this);
      	userMenu.add(item);
      	
      	item = new JMenuItem("High Scores");      //High Scores
        item.addActionListener( this );
   		userMenu.add(item);
      }//end user menu items

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
       /** utility methods to make the code simpler */
      public void showMessage (String s){
      	JOptionPane.showMessageDialog(null,s);
      }
      
      public void showMessage (JTextArea s){
      	JOptionPane.showMessageDialog(null,s);
      }  
}