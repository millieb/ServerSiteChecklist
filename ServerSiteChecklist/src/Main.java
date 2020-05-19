/**
* Application to log activity on server site. 
*
* @author Mildred Brito
*/

import javafx.application.*;
import javafx.stage.*;
import net.codejava.excel.Update;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;


public class Main extends Application {
	 
    Stage window;
 
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    /** Launches login screen. */
    public void start(Stage primaryStage) throws Exception {
    	window = primaryStage;
    	window.setTitle("Server Site Checklist");
    	
    	/** GridPane with 10px padding around edge */
    	GridPane grid = new GridPane();
    	grid.setPadding(new Insets(10, 10, 10, 10));
    	grid.setVgap(8); //vertical gap between rows
    	grid.setHgap(10); //horizontal gap between rows
    	
    	/** Labels */
    	
    	//Name Label
    	Label nameLabel = new Label("Username:");
    	GridPane.setConstraints(nameLabel, 0, 0);
    	
    	//Name Input
    	TextField nameInput = new TextField("username");
    	GridPane.setConstraints(nameInput, 1, 0);
    	
    	//Password Label
    	Label passLabel = new Label("Password:");
    	GridPane.setConstraints(passLabel, 0, 1);
    	
    	//Password Input
    	TextField passInput = new TextField("password");
    	passInput.setPromptText("password");
    	GridPane.setConstraints(passInput, 1, 1);
    	
    	/*Follow this example*/
    	/*https://docs.oracle.com/javafx/2/ui_controls/password-field.htm*/
    	
    	//Login
    	Button loginButton = new Button("Log In");
    	GridPane.setConstraints(loginButton, 1, 2);
    	/** Login button verifies credentials */
    	isUsername isUsernameValid = new isUsername();
    	loginButton.setOnAction( e -> isUsernameValid.isValid(nameInput.getText()));
    	
    	/** Login button verifies password */
    	isPassword isPasswordValid = new isPassword();
    	loginButton.setOnAction(e -> {
    		
			boolean password = isPasswordValid.isValid(passInput.getText());
    		
    		if(password == false) {
    			AlertBox.display("Invalid Login","Invalid username or password.");
    		}
    		else {
    			goToChecklist();
			}
    	});
      	
    	/** Adds everything to grid */
    	grid.getChildren().addAll(nameLabel, nameInput, passLabel, 
    			passInput, loginButton);
    	
    	Scene scene = new Scene(grid, 300, 200);
    	window.setScene(scene);
    	window.show();
    	

	}

	private void goToChecklist() {
		//Date Label
    	Label dateLabel = new Label("Date:");
    	GridPane.setConstraints(dateLabel, 0, 0);
    	//Date Input
    	TextField dateInput = new TextField("mm/dd/yyyy");
    	GridPane.setConstraints(dateInput, 1, 0);
    	
		//Servers Label
    	Label serversLabel = new Label("Servers:");
    	GridPane.setConstraints(serversLabel, 0, 0);
    	//Servers Input
    	TextField serversInput = new TextField();
    	GridPane.setConstraints(serversInput, 1, 0);
    	
    	//Temperature Label
    	Label temperatureLabel = new Label("Site Temperature:");
    	GridPane.setConstraints(temperatureLabel, 0, 0);
    	//Temperature Input
    	TextField temperatureInput = new TextField();
    	GridPane.setConstraints(temperatureInput, 1, 0);
    	
		//Ground Label
    	Label groundLabel = new Label("Physical Ground:");
    	GridPane.setConstraints(groundLabel, 0, 0);
    	//Ground Input
    	TextField groundInput = new TextField();
    	GridPane.setConstraints(groundInput, 1, 0);
    	
		//UPS Label
    	Label upsLabel = new Label("UPS:");
    	GridPane.setConstraints(upsLabel, 0, 0);
    	//UPS Input
    	TextField upsInput = new TextField();
    	GridPane.setConstraints(upsInput, 1, 0);
    	
		//Network Label
    	Label networkLabel = new Label("Network Equipment:");
    	GridPane.setConstraints(networkLabel, 0, 0);
    	//Network Input
    	TextField networkInput = new TextField();
    	GridPane.setConstraints(networkInput, 1, 0);
    	
    	//Signatures Label
    	Label signaturesLabel = new Label("Signatures:");
    	GridPane.setConstraints(signaturesLabel, 0, 0);
    	//Signatures Input
    	TextField signaturesInput = new TextField();
    	GridPane.setConstraints(signaturesInput, 1, 0);
    	
    	//Comments Label
    	Label commentsLabel = new Label("Issues or Comments:");
    	GridPane.setConstraints(commentsLabel, 0, 0);
    	//Comments Input
    	TextField commentsInput = new TextField();
    	GridPane.setConstraints(commentsInput, 1, 0);
		
    	/**Submit Button that saves all info */
    	Button submitButton = new Button("Submit");
    	GridPane.setConstraints(submitButton, 1, 2);
    	
    	/** Setting an action for the Submit button */
    	submitButton.setOnAction( e -> {
	        if ( (dateInput.getText() != null && !dateInput.getText().isEmpty())
	        		&& (serversInput.getText() != null && !serversInput.getText().isEmpty())
	        		&& (temperatureInput.getText() != null && !temperatureInput.getText().isEmpty())
	        		&& (groundInput.getText() != null && !groundInput.getText().isEmpty()) 
	        		&& (upsInput.getText() != null && !upsInput.getText().isEmpty())
	        		&& (networkInput.getText() != null && !networkInput.getText().isEmpty())
	        		&& (signaturesInput.getText() != null && !signaturesInput.getText().isEmpty())
	        		&& (commentsInput.getText() != null && !commentsInput.getText().isEmpty()) ) {
	        	Update update = new Update();
	        	String date = dateInput.getText();
	        	String servers = serversInput.getText();
	        	String temperature = temperatureInput.getText();
	        	String ground = groundInput.getText();
	        	String ups = upsInput.getText();
	        	String network = networkInput.getText();
	        	String signatures = signaturesInput.getText();
	        	String comments = commentsInput.getText();
	        	
	        	update.updateExcel(date, servers, temperature, ground, ups, network, signatures, comments);
	        	System.exit(0);
	        } else {
	        	AlertBox.display("Invalid Entry", "You have not left a comment.");
	        }     
    	});
    	
    	
    	
		//Layout Checklist
		VBox layoutChecklist = new VBox(10);
		layoutChecklist.setPadding(new Insets(20, 20, 20, 20));
		layoutChecklist.getChildren().addAll(dateLabel, dateInput, 
				serversLabel, serversInput, 
				temperatureLabel, temperatureInput,
				groundLabel, groundInput, 
				upsLabel, upsInput, 
				networkLabel, networkInput, 
				signaturesLabel, signaturesInput,
				commentsLabel, commentsInput,
				submitButton);
		
		Scene scene2 = new Scene(layoutChecklist, 250, 620);
		window.setScene(scene2);   	
		
	}

 
}