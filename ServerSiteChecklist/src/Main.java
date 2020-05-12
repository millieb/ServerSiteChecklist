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
    			Update update = new Update();
    			update.updateExcel();
			}
    	});
      	
    	/** Adds everything to grid */
    	grid.getChildren().addAll(nameLabel, nameInput, passLabel, 
    			passInput, loginButton);
    	
    	Scene scene = new Scene(grid, 300, 400);
    	window.setScene(scene);
    	window.show();
    	

	}

	private void goToChecklist() {
		//Check boxes
		CheckBox box1 = new CheckBox("Servers");
		CheckBox box2 = new CheckBox("Physical Ground");
		CheckBox box3 = new CheckBox("UPS");
		CheckBox box4 = new CheckBox("Network Equipment");
		
		//Date Label
    	Label dateLabel = new Label("Date:");
    	GridPane.setConstraints(dateLabel, 0, 0);
    	
    	//Date Input
    	TextField dateInput = new TextField("mm/dd/yyyy");
    	GridPane.setConstraints(dateInput, 1, 0);
		
		//Layout Checklist
		VBox layoutChecklist = new VBox(10);
		layoutChecklist.setPadding(new Insets(20, 20, 20, 20));
		layoutChecklist.getChildren().addAll(box1, box2, box3, box4, dateLabel, dateInput);
		
		Scene scene2 = new Scene(layoutChecklist, 400, 300);
		window.setScene(scene2);   	
		
	}

 
}