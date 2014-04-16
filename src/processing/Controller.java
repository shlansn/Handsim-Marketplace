package processing;

import java.util.Date;
import java.util.HashMap;

import org.eclipse.swt.widgets.TreeItem;

import processing.data.Assignment;
import processing.data.OfferHandler;
import processing.data.User;
import processing.data.Company;
import processing.data.Category;
import processing.data.AssignmentHandler;
import processing.dataBase.dbHandler;

public class Controller {

	/*
	 * Attributes
	 */
	private User activeUser;
	private Company[] companyList;
	private TreeItem[] mainCategoryList;
	private AssignmentHandler assignmentHandler;
	private dbHandler dbHandler;

	// Singleton methods and attributes

	private static Controller instance;

	/**
	 * Constructor is private (Singleton).
	 */
	private Controller() {
	}

	/**
	 * @return Returns the singleton instance of Controller
	 */
	public static Controller getInstance() {
		if (instance == null) {
			instance = new Controller();
		}
		return instance;
	}

	// Init Methods

	/**
	 * TODO Gives the caller the Singleton instance and (re)creates the object.
	 * ONLY USE FOR THE INITIAL SETUP OR A WANTED RESET OF THE OBJECT
	 * 
	 * @param userData
	 * @param dbHandler
	 */
	public static Controller init(String[] userData, dbHandler dbHandler) {
		Controller c = getInstance();
		c.importUser(userData);
		c.dbHandler = dbHandler;
		c.importAssingments();
		return c;
	}

	/**
	 * Creates the active User from the result coming from the data base.
	 * 
	 * @param data
	 *            The User information
	 */
	private void importUser(String[] data) {
		this.activeUser = new User(data);
	}

	/**
	 * TODO right Exception, finish Method
	 * This Method imports all Categories and creates the TreeItem Array
	 */
	private TreeItem[] importCategories() {
		
		try{
			HashMap<String,String[]> dataFromDB = this.dbHandler.getCategories();
		/**
		 * TODO read Data out of the DBdataHashmap
		 */
		
		return null;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	/**
	 * TODO finish this method
	 */
	private void importAssingments() {
		try{
			HashMap<String,String[]> dataFromDB = this.dbHandler.getAssignments(this.activeUser.getUserID());
			Assignment[] temporaryAssignmentList = new Assignment[1]; 
		/**
		 * TODO read Data out of the DBdataHashmap
		 */
		
		this.assignmentHandler = new AssignmentHandler(temporaryAssignmentList);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * TODO
	 */
	private void importCompanyList() {
		// TODO
	}

	// GUI triggered Methods

	/**
	 * TODO Called by GUI, when user changes their user data. method changes its
	 * actual user and notifies DBHandler of changes
	 * 
	 * @param updatedUser
	 *            Updated User item that comes from the GUI
	 */
	public void editUser(User updatedUser) {
		this.activeUser = updatedUser;
		// TODO DBHandler triggern
	}

	/**
	 * Called by GUI when User selects to delete his Account. The user will
	 * automatically get logged out and will return to the Login Screen WARNING:
	 * THIS WILL BASICALLY RESET THE WHOLE PROGRAM
	 */
	public void deleteUser() {
		// TODO es waere sicherlich ganz gut, hier noch ein paar Unterfunktionen
		// zu bauen
		// TODO GUI schliessen
		// TODO DBHandler benachtrichtigen
		instance = null;
		// TODO LoginController starten
	}

	/**
	 * TODO
	 */
	public void createAssignment(String assignmentID, TreeItem[] positionList, OfferHandler offerHandler, 
								 String description, Date dateOfCreation, Date deadline, String status, String title) {
		
		// Creation of the new assignment initialized from the GUI    
		Assignment newAssignment = new Assignment(assignmentID, positionList, offerHandler, 
												  description, dateOfCreation,deadline, status, title);
		
		// Add the new assigment to the Controller's AssignmentList
		Assignment[] newAssignmentList = new Assignment[this.assignmentHandler.getAssignmentList().length + 1];
		newAssignmentList[this.assignmentHandler.getAssignmentList().length] = newAssignment;
		this.assignmentHandler.setAssignmentList(newAssignmentList);
	}

	/**
	 * TODO Position in DBHandler speichern
	 */
	public void savePosition() {
		// TODO
	}

	/**
	 * TODO
	 * 
	 * @return
	 */
	public TreeItem[] createPositionTree() {
		// TODO
		return null;
	}

	// Not yet assigned

	
	// Getters

	public User getUser() {
		return activeUser;
	}

	public Company[] getCompanyList() {
		return companyList;
	}

	public TreeItem[] getMainCategoryList() {
		return mainCategoryList;
	}

	public AssignmentHandler getAssignmentHandler() {
		return assignmentHandler;
	}

	public dbHandler getDbHandler() {
		return dbHandler;
	}

	// Setters TODO
}
