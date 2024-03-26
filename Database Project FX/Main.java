package application;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;
import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Main extends Application {
	static ArrayList<StudentAddingFromAdmin> student = new ArrayList<>();
	@Override
	public void start(Stage primaryStage) {
		try {
			SchoolTraining moh = new SchoolTraining(student);
			
			BorderPane root = new BorderPane();
			// root.setStyle("-fx-background-color : aqua");
			Label myTitle = new Label("Abu Fuad Training School");
			HBox hbox = new HBox();
			hbox.getChildren().add(myTitle);
			hbox.setAlignment(Pos.TOP_CENTER);
			root.setTop(hbox);
			// myTitle.setStyle("-fx-background-color : black");
			myTitle.setTextFill(Color.BLACK);
			myTitle.setUnderline(true);
			Font myTitleFont = Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR,25);
			Font myTitleFontt = Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR,50);
			myTitle.setFont(myTitleFontt);
			BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
			root.setBackground(new Background(
					new BackgroundImage(new Image("file:///C:/Users/bashe/OneDrive/Desktop/Dr.Murad/Database_Project/src/car.jpg"),
							BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
							backgroundSize)));

			Scene scene = new Scene(root);

			Label usernameLabel = new Label("Username:");
			usernameLabel.setFont(myTitleFontt);
			// usernameLabel.setStyle("-fx-background-color : black");
			usernameLabel.setTextFill(Color.BLACK);
			TextField usernameField = new TextField();
			Label passwordLabel = new Label("Password:");
			// passwordLabel.setStyle("-fx-background-color : black");
			passwordLabel.setTextFill(Color.BLACK);
			passwordLabel.setFont(myTitleFontt);
			PasswordField passwordField = new PasswordField();
			passwordField.setPromptText("********");

			Label logIn = new Label("Login");
			logIn.setTextFill(Color.BLACK);
			logIn.setFont(myTitleFontt);
			
			
			StackPane forlogin = new StackPane();
			Rectangle shp = new Rectangle(300, 100);
			shp.setArcWidth(70);
			shp.setArcHeight(70);
			shp.setFill(Color.GREEN);
			shp.setStroke(Color.RED);
			Button log = new Button("LOGIN");
			log.setStyle("-fx-background-color : green");
			log.setTextFill(Color.ORANGE);
			log.setFont(myTitleFont);
			DropShadow shadow = new DropShadow(30, Color.BLUEVIOLET);
			log.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				log.setEffect(shadow);
				log.setEffect(shadow);
		        });
			log.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				log.setEffect(null);
				log.setEffect(null);
		        });
			forlogin.getChildren().addAll(shp,log);
			
			GridPane grid = new GridPane();
			grid.setVgap(20);
			grid.setHgap(30);
			grid.addRow(0,logIn);
			grid.addRow(1, usernameLabel, usernameField);
			grid.addRow(2, passwordLabel, passwordField);
			grid.addRow(3,forlogin);
			grid.setAlignment(Pos.BASELINE_LEFT);
			grid.setTranslateX(40);
			root.setCenter(grid);
			
			BorderPane rootManeger = new BorderPane();
			BorderPane rootTeach_St = new BorderPane();
			log.setOnAction(e -> {
				if(usernameField.getText().trim().equals("admin") && passwordField.getText().trim().equals("admin")) 
					scene.setRoot(rootManeger);
				else
					scene.setRoot(rootTeach_St);
					
			
			});
			forlogin.setOnMouseClicked(e->{
				if(usernameField.getText().trim().equals("admin") && passwordField.getText().trim().equals("admin")) 
					scene.setRoot(rootManeger);
				else
					scene.setRoot(rootTeach_St);
			});
			rootManeger.setStyle("-fx-background-color : blue");
			
			Text myTitle2 = new Text("CLICK ABOUT The Page DO YOU WANT");
			myTitle2.setFill(Color.GREEN);
			myTitle2.setStroke(Color.ORANGE);
			myTitle2.setUnderline(true);
			myTitle2.setFont(myTitleFont);
			HBox hboxxt = new HBox();
			hboxxt.getChildren().add(myTitle2);
			hboxxt.setAlignment(Pos.TOP_CENTER);
			rootManeger.setTop(hboxxt);
			
			StackPane forStd = new StackPane();
			Rectangle shp2 = new Rectangle(300, 100);
			shp2.setArcWidth(70);
			shp2.setArcHeight(70);
			shp2.setFill(Color.GREEN);
			shp2.setStroke(Color.RED);
			Button StdBtn = new Button("Go To Student Page");
			StdBtn.setStyle("-fx-background-color : green");
			StdBtn.setTextFill(Color.ORANGE);
			StdBtn.setFont(myTitleFont);
			StdBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				StdBtn.setEffect(shadow);
				StdBtn.setEffect(shadow);
		        });
			StdBtn.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				StdBtn.setEffect(null);
				StdBtn.setEffect(null);
		        });
			forStd.getChildren().addAll(shp2,StdBtn);
			
			StackPane forTeach = new StackPane();
			Rectangle shp3 = new Rectangle(300, 100);
			shp3.setArcWidth(70);
			shp3.setArcHeight(70);
			shp3.setFill(Color.GREEN);
			shp3.setStroke(Color.RED);
			Button teachBtn = new Button("Go To Teacher Page");
			teachBtn.setStyle("-fx-background-color : green");
			teachBtn.setTextFill(Color.ORANGE);
			teachBtn.setFont(myTitleFont);
			teachBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				teachBtn.setEffect(shadow);
				teachBtn.setEffect(shadow);
		        });
			teachBtn.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				teachBtn.setEffect(null);
				teachBtn.setEffect(null);
		        });
			forTeach.getChildren().addAll(shp3,teachBtn);
			
			StackPane forCar = new StackPane();
			Rectangle shp33 = new Rectangle(300, 100);
			shp33.setArcWidth(70);
			shp33.setArcHeight(70);
			shp33.setFill(Color.GREEN);
			shp33.setStroke(Color.RED);
			Button carBtn = new Button("Go To Vehicle Page");
			carBtn.setStyle("-fx-background-color : green");
			carBtn.setTextFill(Color.ORANGE);
			carBtn.setFont(myTitleFont);
			carBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				carBtn.setEffect(shadow);
				carBtn.setEffect(shadow);
		        });
			carBtn.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				carBtn.setEffect(null);
				carBtn.setEffect(null);
		        });
			forCar.getChildren().addAll(shp33,carBtn);
			
			StackPane forBack = new StackPane();
			Rectangle shp4 = new Rectangle(300, 100);
			shp4.setArcWidth(70);
			shp4.setArcHeight(70);
			shp4.setFill(Color.GREEN);
			shp4.setStroke(Color.RED);
			Button backBtn = new Button("Logout");
			backBtn.setStyle("-fx-background-color : green");
			backBtn.setTextFill(Color.ORANGE);
			backBtn.setFont(myTitleFont);
			backBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				backBtn.setEffect(shadow);
				backBtn.setEffect(shadow);
		        });
			backBtn.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				backBtn.setEffect(null);
				backBtn.setEffect(null);
		        });
			forBack.getChildren().addAll(shp4,backBtn);
			backBtn.setOnAction(e->{
				scene.setRoot(root);
				usernameField.clear();
				passwordField.clear();
				
			});
			forBack.setOnMouseClicked(e->{
				scene.setRoot(root);
				usernameField.clear();
				passwordField.clear();
			});
			
			
			VBox ms = new VBox(20);
			ms.getChildren().addAll(forStd,forTeach,forCar,forBack);
			ms.setAlignment(Pos.CENTER);
			rootManeger.setCenter(ms);
			
			BorderPane studentPage = new BorderPane();
			StdBtn.setOnAction(e->{
				scene.setRoot(studentPage);
			});
			forStd.setOnMouseClicked(e->{
				scene.setRoot(studentPage);
			});
			studentPage.setStyle("-fx-background-color : blue");
			
			StackPane forAdd = new StackPane();
			Rectangle shp9 = new Rectangle(550, 100);
			shp9.setArcWidth(70);
			shp9.setArcHeight(70);
			shp9.setFill(Color.GREEN);
			shp9.setStroke(Color.RED);
			Button addCostomer = new Button("Add Student");
			addCostomer.setStyle("-fx-background-color : green");
			addCostomer.setTextFill(Color.ORANGE);
			addCostomer.setFont(myTitleFont);
			addCostomer.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				addCostomer.setEffect(shadow);
				shp4.setEffect(shadow);
		        });
			addCostomer.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				addCostomer.setEffect(null);
				shp9.setEffect(null);
		        });
			forAdd.getChildren().addAll(shp9, addCostomer);

			StackPane forDelet = new StackPane();
			Rectangle shp5 = new Rectangle(550, 100);
			shp5.setArcWidth(70);
			shp5.setArcHeight(70);
			shp5.setFill(Color.GREEN);
			shp5.setStroke(Color.RED);
			Button deleteCostomer = new Button("Delete Student");
			deleteCostomer.setStyle("-fx-background-color : green");
			deleteCostomer.setTextFill(Color.ORANGE);
			deleteCostomer.setFont(myTitleFont);
			deleteCostomer.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				deleteCostomer.setEffect(shadow);
				shp5.setEffect(shadow);
		        });
			deleteCostomer.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				deleteCostomer.setEffect(null);
				shp5.setEffect(null);
		        });
			forDelet.getChildren().addAll(shp5, deleteCostomer);

			StackPane forUpdate = new StackPane();
			Rectangle shp6 = new Rectangle(550, 100);
			shp6.setArcWidth(70);
			shp6.setArcHeight(70);
			shp6.setFill(Color.GREEN);
			shp6.setStroke(Color.RED);
			Button updateCostomer = new Button("Update Student Information");
			updateCostomer.setStyle("-fx-background-color : green");
			updateCostomer.setTextFill(Color.ORANGE);
			updateCostomer.setFont(myTitleFont);
			updateCostomer.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				updateCostomer.setEffect(shadow);
				shp6.setEffect(shadow);
		        });
			updateCostomer.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				updateCostomer.setEffect(null);
				shp6.setEffect(null);
		        });
			forUpdate.getChildren().addAll(shp6, updateCostomer);

			StackPane forSearch = new StackPane();
			Rectangle shp7 = new Rectangle(550, 100);
			shp7.setArcWidth(70);
			shp7.setArcHeight(70);
			shp7.setFill(Color.GREEN);
			shp7.setStroke(Color.RED);
			Button searchCostomer = new Button("Search a Srudent by id");
			searchCostomer.setStyle("-fx-background-color : green");
			searchCostomer.setTextFill(Color.ORANGE);
			searchCostomer.setFont(myTitleFont);
			searchCostomer.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				searchCostomer.setEffect(shadow);
				shp7.setEffect(shadow);
		        });
			searchCostomer.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				searchCostomer.setEffect(null);
				shp7.setEffect(null);
		        });
			forSearch.getChildren().addAll(shp7, searchCostomer);

			StackPane forBack1 = new StackPane();
			Rectangle shp8 = new Rectangle(550, 100);
			shp8.setArcWidth(70);
			shp8.setArcHeight(70);
			shp8.setFill(Color.GREEN);
			shp8.setStroke(Color.RED);
			Button returnToMain = new Button("Return to main");
			returnToMain.setStyle("-fx-background-color : green");
			returnToMain.setTextFill(Color.ORANGE);
			returnToMain.setFont(myTitleFont);
			returnToMain.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				returnToMain.setEffect(shadow);
				shp8.setEffect(shadow);
		        });
			returnToMain.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				returnToMain.setEffect(null);
				shp8.setEffect(null);
		        });
			forBack1.getChildren().addAll(shp8, returnToMain);
			
			returnToMain.setOnAction(e->{
				scene.setRoot(rootManeger);
			});
			
			Text myTitle1 = new Text("CLICK ABOUT WHAT DO YOU WANT");
			myTitle1.setFill(Color.GREEN);
			myTitle1.setStroke(Color.ORANGE);
			myTitle1.setUnderline(true);
			myTitle1.setFont(myTitleFont);
			HBox hboxx = new HBox();
			hboxx.getChildren().add(myTitle1);
			hboxx.setAlignment(Pos.TOP_CENTER);
			studentPage.setTop(hboxx);

			VBox vbox = new VBox(30);
			vbox.getChildren().addAll(forAdd, forDelet, forUpdate, forSearch, forBack1);
			vbox.setAlignment(Pos.BOTTOM_CENTER);
			studentPage.setCenter(vbox);
			
			GridPane gridAdd = new GridPane();
			BorderPane rootAdd = new BorderPane();
			addCostomer.setOnAction(e -> {
				scene.setRoot(rootAdd);
			});
			forAdd.setOnMouseClicked(e ->{
				scene.setRoot(rootAdd);
			});
			gridAdd.setVgap(10);
			gridAdd.setHgap(20);
			Label costomerId = new Label("Student Id");
			costomerId.setFont(myTitleFontt);
			TextField textId = new TextField();
			textId.setPromptText("Mandatory");
			textId.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
			Label costomerName = new Label("Student Name");
			costomerName.setFont(myTitleFontt);
			TextField textName = new TextField();
			textName.setPromptText("Mandatory");
			textName.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
			textName.setDisable(true);
			Label costomerAddress = new Label("Student Address");
			costomerAddress.setFont(myTitleFontt);
			TextField textAddress = new TextField();
			textAddress.setPromptText("Mandatory");
			textAddress.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
			textAddress.setDisable(true);
			Label costomerWorking = new Label("Student Work");
			costomerWorking.setFont(myTitleFontt);
			TextField textWorking = new TextField();
			textWorking.setPromptText("Mandatory");
			textWorking.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
			textWorking.setDisable(true);
			Label costomerMobile = new Label("Number Phones");
			costomerMobile.setFont(myTitleFontt);
			TextField textTel = new TextField();
			textTel.setPromptText("Tel (Mandatory):");
			textTel.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
			textTel.setDisable(true);
			//Label costomerTel = new Label("Tel :");
			//costomerTel.setFont(myTitleFontt);
			TextField textMobile = new TextField();
			textMobile.setDisable(true);
			textMobile.setPromptText("Mob (Not Mandatory):");
			textMobile.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
			ImageView to_Add = new ImageView("https://img.icons8.com/fluency/344/add.png");
			to_Add.setFitHeight(50);
			to_Add.setFitWidth(50);

			ToggleGroup tg = new ToggleGroup();
			Label titlePlan = new Label("Student Gender");
			titlePlan.setFont(myTitleFontt);
			RadioButton male = new RadioButton("Male");
			male.setFont(myTitleFont);
			RadioButton feMale = new RadioButton("Female");
			feMale.setFont(myTitleFont);
			male.setToggleGroup(tg);
			feMale.setToggleGroup(tg);
			HBox mm = new HBox(50);
			
			ToggleGroup tgg = new ToggleGroup();
			Label titlePlann = new Label("Tybe Of Train");
			titlePlann.setFont(myTitleFontt);
			RadioButton aGear = new RadioButton("Automatic");
			aGear.setFont(myTitleFont);
			RadioButton nGear = new RadioButton("Normal");
			nGear.setFont(myTitleFont);
			RadioButton track = new RadioButton("Track");
			track.setFont(myTitleFont);
			aGear.setToggleGroup(tgg);
			nGear.setToggleGroup(tgg);
			track.setToggleGroup(tgg);
			HBox mmm = new HBox(50);
			Button addTheCostomer = new Button("Add", to_Add);
			addTheCostomer.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				addTheCostomer.setEffect(shadow);
		        });
			addTheCostomer.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				addTheCostomer.setEffect(null);
		        });
		

			textId.setOnKeyPressed(i -> {
				if (textId.getText() != "") {
					textName.setDisable(false);
				} else {
					textName.setDisable(true);
					textAddress.setDisable(true);
					textMobile.setDisable(true);
					textWorking.setDisable(true);
					textTel.setDisable(true);
				}
			});
			textName.setOnKeyPressed(i1 -> {
				if (textName.getText() != "") {
					textAddress.setDisable(false);
				} else {
					textAddress.setDisable(true);
					textMobile.setDisable(true);
					textTel.setDisable(true);
					textWorking.setDisable(true);
				}
			});
			textAddress.setOnKeyPressed(i2 -> {
				if (textAddress.getText() != "") {
					textMobile.setDisable(false);
					textTel.setDisable(false);
				} else {
					textMobile.setDisable(true);
					textTel.setDisable(true);
					textWorking.setDisable(true);
				}

			});
			textTel.setOnKeyPressed(i2 -> {
				if (textTel.getText() != "") {
					textWorking.setDisable(false);
				} else {
					textWorking.setDisable(true);
				}

			});
			textWorking.setOnKeyPressed(i6 -> {
				if (!textWorking.getText().equals("")) {
					mm.getChildren().addAll(male,feMale);
					mmm.getChildren().addAll(aGear,nGear,track);
				}

			});
			addTheCostomer.setFont(myTitleFont);
			addTheCostomer.setStyle("-fx-background-color : red");
			ImageView to_back = new ImageView(
					"https://img.icons8.com/external-others-phat-plus/344/external-back-essential-blue-others-phat-plus.png?fbclid=IwAR2CJ9dsA0kOSz6V2TtToUV46Nu9sWLPI-pA3TMo48YHbgK-TlgwB3Cx78Y");
			to_back.setFitHeight(50);
			to_back.setFitWidth(50);
			Button backAdd = new Button("Back", to_back);
			backAdd.setStyle("-fx-background-color : red");
			backAdd.setFont(myTitleFont);
			backAdd.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				backAdd.setEffect(shadow);
		        });
			backAdd.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				backAdd.setEffect(null);
		        });
			backAdd.setOnAction(e -> {
				rootAdd.setBottom(null);
				textName.setDisable(true);
				textAddress.setDisable(true);
				textMobile.setDisable(true);
				textMobile.setDisable(true);
				textTel.setDisable(true);
				textWorking.setDisable(true);
				male.setSelected(false);
				feMale.setSelected(false);
				nGear.setSelected(false);
				aGear.setSelected(false);
				track.setSelected(false);
				mm.getChildren().removeAll(male,feMale);
				mmm.getChildren().removeAll(nGear,aGear,track);
				textId.clear();
				textName.clear();
				textAddress.clear();
				textMobile.clear();
				textTel.clear();
				textTel.setPromptText("Tel (Mandatory):");
				textTel.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
				textMobile.setPromptText("Tel (Mandatory):");
				textMobile.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
				textWorking.clear();
				textId.setPromptText("Mandatory");
				textId.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
				textName.setPromptText("Mandatory");
				textName.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
				textAddress.setPromptText("Mandatory");
				textAddress.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
				textWorking.setPromptText("Mandatory");
				textWorking.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
				scene.setRoot(studentPage);
			});
			gridAdd.addRow(0, costomerId, textId);
			gridAdd.addRow(1, costomerName, textName);
			gridAdd.addRow(2, costomerAddress, textAddress);
			gridAdd.addRow(3, costomerMobile,textTel,textMobile);
			gridAdd.addRow(4, costomerWorking,textWorking);
			gridAdd.addRow(5, titlePlan, mm);
			gridAdd.addRow(6, titlePlann, mmm);
			gridAdd.addRow(7, addTheCostomer,backAdd);
			gridAdd.setAlignment(Pos.CENTER);
			rootAdd.setCenter(gridAdd);
			rootAdd.setStyle("-fx-background-color : orange");
			
			
			GridPane gridDelete = new GridPane();
			BorderPane rootDelete = new BorderPane();
			deleteCostomer.setOnAction(e -> {
				scene.setRoot(rootDelete);
			});
			forDelet.setOnMouseClicked(e->{
				scene.setRoot(rootDelete);
			});
			gridDelete.setVgap(10);
			gridDelete.setHgap(30);
			Label costomerId1 = new Label("Student Id");
			costomerId1.setFont(myTitleFontt);
			TextField textId1 = new TextField();
			textId1.setPromptText("Mandatory");
			textId1.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
			Label costomerName1 = new Label("Student Name");
			costomerName1.setFont(myTitleFontt);
			TextField textName1 = new TextField();
			textName1.setDisable(true);
			Label costomerAddress1 = new Label("Student Address");
			costomerAddress1.setFont(myTitleFontt);
			TextField textAddress1 = new TextField();
			textAddress1.setDisable(true);
			Label costomerMobile1 = new Label("Student Phones");
			costomerMobile1.setFont(myTitleFontt);
			TextField textMobile1 = new TextField();
			textMobile1.setDisable(true);
			TextField textTel1 = new TextField();
			textTel1.setDisable(true);
			Label costomerPlan1 = new Label("Student Gender");
			costomerPlan1.setFont(myTitleFontt);
			TextField textPlan1 = new TextField();
			textPlan1.setDisable(true);
			Label costomerWorking1 = new Label("Student Work");
			costomerWorking1.setFont(myTitleFontt);
			TextField textWork1 = new TextField();
			textWork1.setDisable(true);
			Label tybeTraning1 = new Label("Student Train");
			tybeTraning1.setFont(myTitleFontt);
			TextField textTrain1 = new TextField();
			textTrain1.setDisable(true);
			ImageView to_Delete = new ImageView(
					"https://img.icons8.com/external-kiranshastry-gradient-kiranshastry/344/external-delete-multimedia-kiranshastry-gradient-kiranshastry.png?fbclid=IwAR3Kg7w_RIW8qRtB86cJyYSmKlikZBrewF2AbNx_9U4OuRj0eS52yhhH8mg");
			to_Delete.setFitHeight(50);
			to_Delete.setFitWidth(50);
			Button deletTheCostomer = new Button("Delet", to_Delete);
			deletTheCostomer.setStyle("-fx-background-color : red");
			deletTheCostomer.setFont(myTitleFont);
			deletTheCostomer.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				deletTheCostomer.setEffect(shadow);
		        });
			deletTheCostomer.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				deletTheCostomer.setEffect(null);
		        });
			
			ImageView to_backd = new ImageView(
					"https://img.icons8.com/external-others-phat-plus/344/external-back-essential-blue-others-phat-plus.png?fbclid=IwAR2CJ9dsA0kOSz6V2TtToUV46Nu9sWLPI-pA3TMo48YHbgK-TlgwB3Cx78Y");
			to_backd.setFitHeight(50);
			to_backd.setFitWidth(50);
			Button backDeleted = new Button("Back", to_backd);
			backDeleted.setStyle("-fx-background-color : red");
			backDeleted.setFont(myTitleFont);
			backDeleted.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				backDeleted.setEffect(shadow);
		        });
			backDeleted.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				backDeleted.setEffect(null);
		        });
			backDeleted.setOnAction(e -> {
				rootDelete.setRight(null);
				textId1.clear();
				textName1.clear();
				textAddress1.clear();
				textMobile1.clear();
				textTel1.clear();
				textPlan1.clear();
				textWork1.clear();
				textTrain1.clear();
				textId1.setPromptText("Mandatory");
				textId1.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
				scene.setRoot(studentPage);
			});
			ImageView to_Find = new ImageView(
					"https://img.icons8.com/external-kiranshastry-gradient-kiranshastry/344/external-find-hotel-kiranshastry-gradient-kiranshastry.png?fbclid=IwAR0aG0Mq0Ar5ivhAo09n9NJsHWSoCcfH2lqj2QyJzdJlT-CYvCpQbdAqmZ8");
			to_Find.setFitHeight(50);
			to_Find.setFitWidth(50);
			Button find = new Button("Find", to_Find);
			find.setStyle("-fx-background-color : red");
			find.setFont(myTitleFont);
			find.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				find.setEffect(shadow);
		        });
			find.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				find.setEffect(null);
		        });
			backDeleted.setFont(myTitleFont);
			gridDelete.addRow(0, costomerId1, textId1);
			gridDelete.addRow(1, costomerName1, textName1);
			gridDelete.addRow(2, costomerAddress1, textAddress1);
			gridDelete.addRow(3, costomerMobile1,textTel1, textMobile1);
			gridDelete.addRow(4, costomerPlan1, textPlan1);
			gridDelete.addRow(5, costomerWorking1, textWork1);
			gridDelete.addRow(6, tybeTraning1, textTrain1);
			gridDelete.addRow(7, find, deletTheCostomer, backDeleted);
			gridDelete.setAlignment(Pos.CENTER);
			rootDelete.setCenter(gridDelete);
			rootDelete.setStyle("-fx-background-color : orange");
			
			GridPane gridUpdate = new GridPane();
			BorderPane rootUpdate = new BorderPane();
			updateCostomer.setOnAction(e -> {
				scene.setRoot(rootUpdate);
			});
			forUpdate.setOnMouseClicked(e->{
				scene.setRoot(rootUpdate);
			});
			gridUpdate.setVgap(10);
			gridUpdate.setHgap(30);
			Label costomerId2 = new Label("Student Id");
			costomerId2.setFont(myTitleFontt);
			TextField textId2 = new TextField();
			textId2.setPromptText("Mandatory");
			textId2.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
			Label costomerName2 = new Label("Student Name");
			costomerName2.setFont(myTitleFontt);
			TextField textName2 = new TextField();
			textName2.setDisable(true);
			Label costomerAddress2 = new Label("Student Address");
			costomerAddress2.setFont(myTitleFontt);
			TextField textAddress2 = new TextField();
			textAddress2.setDisable(true);
			Label costomerMobile2 = new Label("Student Phones : ");
			costomerMobile2.setFont(myTitleFontt);
			TextField textMobile2 = new TextField();
			textMobile2.setDisable(true);
			TextField textTel2 = new TextField();
			textTel2.setDisable(true);
			Label costomerPlan2 = new Label("Student Gender");
			costomerPlan2.setFont(myTitleFontt);
			TextField textPlan2 = new TextField();
			textPlan2.setDisable(true);
			Label costomerWorking2 = new Label("Student Work");
			costomerWorking2.setFont(myTitleFontt);
			TextField textWork2 = new TextField();
			textWork2.setDisable(true);
			Label tybeTraning2 = new Label("Student Train");
			tybeTraning2.setFont(myTitleFontt);
			TextField textTrain2 = new TextField();
			textTrain2.setDisable(true);
			ImageView to_Update = new ImageView("https://img.icons8.com/flat-round/344/loop.png");
			to_Update.setFitHeight(50);
			to_Update.setFitWidth(50);
			Button updateTheCostomer = new Button("Update", to_Update);
			updateTheCostomer.setStyle("-fx-background-color : red");
			updateTheCostomer.setFont(myTitleFont);
			updateTheCostomer.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				updateTheCostomer.setEffect(shadow);
		        });
			updateTheCostomer.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				updateTheCostomer.setEffect(null);
		        });
			ImageView to_backU = new ImageView(
					"https://img.icons8.com/external-others-phat-plus/344/external-back-essential-blue-others-phat-plus.png?fbclid=IwAR2CJ9dsA0kOSz6V2TtToUV46Nu9sWLPI-pA3TMo48YHbgK-TlgwB3Cx78Y");
			to_backU.setFitHeight(50);
			to_backU.setFitWidth(50);
			Button backUpdate = new Button("Back", to_backU);
			backUpdate.setStyle("-fx-background-color : red");
			backUpdate.setFont(myTitleFont);
			backUpdate.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				backUpdate.setEffect(shadow);
		        });
			backUpdate.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				backUpdate.setEffect(null);
		        });
			backUpdate.setOnAction(e -> {
				rootUpdate.setRight(null);
				textId2.clear();
				textName2.clear();
				textAddress2.clear();
				textMobile2.clear();
				textTel2.clear();
				textPlan2.clear();
				textWork2.clear();
				textTrain2.clear();
				textId2.setPromptText("Mandatory");
				textId2.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
				scene.setRoot(studentPage);
			});
			ImageView to_Find1 = new ImageView(
					"https://img.icons8.com/external-kiranshastry-gradient-kiranshastry/344/external-find-hotel-kiranshastry-gradient-kiranshastry.png?fbclid=IwAR0aG0Mq0Ar5ivhAo09n9NJsHWSoCcfH2lqj2QyJzdJlT-CYvCpQbdAqmZ8");
			to_Find1.setFitHeight(50);
			to_Find1.setFitWidth(50);
			Button find1 = new Button("Find", to_Find1);
			find1.setStyle("-fx-background-color : red");
			find1.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				find1.setEffect(shadow);
		        });
			find1.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				find1.setEffect(null);
		        });
			
			find1.setFont(myTitleFont);
			gridUpdate.addRow(0, costomerId2, textId2);
			gridUpdate.addRow(1, costomerName2, textName2);
			gridUpdate.addRow(2, costomerAddress2, textAddress2);
			gridUpdate.addRow(3, costomerMobile2,textTel2, textMobile2);
			gridUpdate.addRow(4, costomerPlan2, textPlan2);
			gridUpdate.addRow(5, costomerWorking2, textWork2);
			gridUpdate.addRow(6, tybeTraning2, textTrain2);
			gridUpdate.addRow(7, find1, updateTheCostomer, backUpdate);
			gridUpdate.setAlignment(Pos.CENTER);
			rootUpdate.setCenter(gridUpdate);
			rootUpdate.setStyle("-fx-background-color : orange");
			
			GridPane gridSearch = new GridPane();
			BorderPane rootSearch = new BorderPane();
			searchCostomer.setOnAction(e -> {
				scene.setRoot(rootSearch);
			});
			forSearch.setOnMouseClicked(e->{
				scene.setRoot(rootSearch);
			});
			gridSearch.setVgap(10);
			gridSearch.setHgap(30);
			Label costomerId3 = new Label("Student Id");
			costomerId3.setFont(myTitleFontt);
			TextField textId3 = new TextField();
			textId3.setPromptText("Mandatory");
			textId3.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
			Label costomerName3 = new Label("Student Name");
			costomerName3.setFont(myTitleFontt);
			TextField textName3 = new TextField();
			textName3.setDisable(true);
			Label costomerAddress3 = new Label("Student Address");
			costomerAddress3.setFont(myTitleFontt);
			TextField textAddress3 = new TextField();
			textAddress3.setDisable(true);
			Label costomerMobile3 = new Label("Student Phones");
			costomerMobile3.setFont(myTitleFontt);
			TextField textMobile3 = new TextField();
			textMobile3.setDisable(true);
			TextField textTel3 = new TextField();
			textTel3.setDisable(true);
			Label costomerPlan3 = new Label("Student Gender");
			costomerPlan3.setFont(myTitleFontt);
			TextField textPlan3 = new TextField();
			textPlan3.setDisable(true);
			Label costomerWorking3 = new Label("Student Work");
			costomerWorking3.setFont(myTitleFontt);
			TextField textWork3 = new TextField();
			textWork3.setDisable(true);
			Label tybeTraning3 = new Label("Student Train");
			tybeTraning3.setFont(myTitleFontt);
			TextField textTrain3 = new TextField();
			textTrain3.setDisable(true);
			ImageView to_Find2 = new ImageView(
					"https://img.icons8.com/external-kiranshastry-gradient-kiranshastry/344/external-find-hotel-kiranshastry-gradient-kiranshastry.png?fbclid=IwAR0aG0Mq0Ar5ivhAo09n9NJsHWSoCcfH2lqj2QyJzdJlT-CYvCpQbdAqmZ8");
			to_Find2.setFitHeight(50);
			to_Find2.setFitWidth(50);
			Button searchTheCostomer = new Button("Search", to_Find2);
			searchTheCostomer.setStyle("-fx-background-color : red");
			searchTheCostomer.setFont(myTitleFont);
			searchTheCostomer.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				searchTheCostomer.setEffect(shadow);
		        });
			searchTheCostomer.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				searchTheCostomer.setEffect(null);
		        });
			ImageView to_backm = new ImageView(
					"https://img.icons8.com/external-others-phat-plus/344/external-back-essential-blue-others-phat-plus.png?fbclid=IwAR2CJ9dsA0kOSz6V2TtToUV46Nu9sWLPI-pA3TMo48YHbgK-TlgwB3Cx78Y");
			to_backm.setFitHeight(50);
			to_backm.setFitWidth(50);
			Button backSearch = new Button("Back", to_backm);
			backSearch.setStyle("-fx-background-color : red");
			backSearch.setFont(myTitleFont);
			backSearch.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				backSearch.setEffect(shadow);
		        });
			backSearch.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				backSearch.setEffect(null);
		        });
			backSearch.setOnAction(e -> {
				rootSearch.setBottom(null);
				textId3.clear();
				textName3.clear();
				textAddress3.clear();
				textMobile3.clear();
				textTel3.clear();
				textPlan3.clear();
				textWork3.clear();
				textTrain3.clear();
				textId3.setPromptText("Mandatory");
				textId3.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
				scene.setRoot(studentPage);
			});
			gridSearch.addRow(0, costomerId3, textId3);
			gridSearch.addRow(1, costomerName3, textName3);
			gridSearch.addRow(2, costomerAddress3, textAddress3);
			gridSearch.addRow(3, costomerMobile3, textTel3,textMobile3);
			gridSearch.addRow(4, costomerPlan3, textPlan3);
			gridSearch.addRow(5, costomerWorking3, textWork3);
			gridSearch.addRow(6, tybeTraning3, textTrain3);
			gridSearch.addRow(8, searchTheCostomer, backSearch);
			gridSearch.setAlignment(Pos.CENTER);
			rootSearch.setCenter(gridSearch);
			rootSearch.setStyle("-fx-background-color : orange");
			
			
			
			
			
			BorderPane teacherPage = new BorderPane();
			teachBtn.setOnAction(e->{
				scene.setRoot(teacherPage);
			});
			forTeach.setOnMouseClicked(e->{
				scene.setRoot(teacherPage);
			});
			teacherPage.setStyle("-fx-background-color : blue");
			
			StackPane forAddT = new StackPane();
			Rectangle shp15 = new Rectangle(550, 100);
			shp15.setArcWidth(70);
			shp15.setArcHeight(70);
			shp15.setFill(Color.GREEN);
			shp15.setStroke(Color.RED);
			Button addCostomerT = new Button("Add Teacher");
			addCostomerT.setStyle("-fx-background-color : green");
			addCostomerT.setTextFill(Color.ORANGE);
			addCostomerT.setFont(myTitleFont);
			addCostomerT.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				addCostomerT.setEffect(shadow);
				shp15.setEffect(shadow);
		        });
			addCostomerT.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				addCostomerT.setEffect(null);
				shp15.setEffect(null);
		        });
			forAddT.getChildren().addAll(shp15, addCostomerT);

			StackPane forDeletT = new StackPane();
			Rectangle shp16 = new Rectangle(550, 100);
			shp16.setArcWidth(70);
			shp16.setArcHeight(70);
			shp16.setFill(Color.GREEN);
			shp16.setStroke(Color.RED);
			Button deleteCostomerT = new Button("Delete Teacher");
			deleteCostomerT.setStyle("-fx-background-color : green");
			deleteCostomerT.setTextFill(Color.ORANGE);
			deleteCostomerT.setFont(myTitleFont);
			deleteCostomerT.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				deleteCostomerT.setEffect(shadow);
				shp16.setEffect(shadow);
		        });
			deleteCostomerT.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				deleteCostomerT.setEffect(null);
				shp16.setEffect(null);
		        });
			forDeletT.getChildren().addAll(shp16, deleteCostomerT);

			StackPane forUpdateT = new StackPane();
			Rectangle shp17 = new Rectangle(550, 100);
			shp17.setArcWidth(70);
			shp17.setArcHeight(70);
			shp17.setFill(Color.GREEN);
			shp17.setStroke(Color.RED);
			Button updateCostomerT = new Button("Update Teacher Information");
			updateCostomerT.setStyle("-fx-background-color : green");
			updateCostomerT.setTextFill(Color.ORANGE);
			updateCostomerT.setFont(myTitleFont);
			updateCostomerT.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				updateCostomerT.setEffect(shadow);
				shp17.setEffect(shadow);
		        });
			updateCostomerT.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				updateCostomerT.setEffect(null);
				shp17.setEffect(null);
		        });
			forUpdateT.getChildren().addAll(shp17, updateCostomerT);

			StackPane forSearchT = new StackPane();
			Rectangle shp18 = new Rectangle(550, 100);
			shp18.setArcWidth(70);
			shp18.setArcHeight(70);
			shp18.setFill(Color.GREEN);
			shp18.setStroke(Color.RED);
			Button searchCostomerT = new Button("Search a Teacher by id");
			searchCostomerT.setStyle("-fx-background-color : green");
			searchCostomerT.setTextFill(Color.ORANGE);
			searchCostomerT.setFont(myTitleFont);
			searchCostomerT.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				searchCostomerT.setEffect(shadow);
				shp18.setEffect(shadow);
		        });
			searchCostomerT.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				searchCostomerT.setEffect(null);
				shp18.setEffect(null);
		        });
			forSearchT.getChildren().addAll(shp18, searchCostomerT);

			StackPane forBack1T = new StackPane();
			Rectangle shp19 = new Rectangle(550, 100);
			shp19.setArcWidth(70);
			shp19.setArcHeight(70);
			shp19.setFill(Color.GREEN);
			shp19.setStroke(Color.RED);
			Button returnToMainT = new Button("Return to main");
			returnToMainT.setStyle("-fx-background-color : green");
			returnToMainT.setTextFill(Color.ORANGE);
			returnToMainT.setFont(myTitleFont);
			returnToMainT.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				returnToMainT.setEffect(shadow);
				shp19.setEffect(shadow);
		        });
			returnToMainT.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				returnToMainT.setEffect(null);
				shp19.setEffect(null);
		        });
			forBack1T.getChildren().addAll(shp19, returnToMainT);
			
			returnToMainT.setOnAction(e->{
				scene.setRoot(rootManeger);
			});
			forBack1T.setOnMouseClicked(e->{
				scene.setRoot(rootManeger);
			});
			forBack1.setOnMouseClicked(e->{
				scene.setRoot(rootManeger);
			});
			
			Text myTitle1T = new Text("CLICK ABOUT WHAT DO YOU WANT");
			myTitle1T.setFill(Color.GREEN);
			myTitle1T.setStroke(Color.ORANGE);
			myTitle1T.setUnderline(true);
			myTitle1T.setFont(myTitleFont);
			HBox hboxxT = new HBox();
			hboxxT.getChildren().add(myTitle1T);
			hboxxT.setAlignment(Pos.TOP_CENTER);
			teacherPage.setTop(hboxxT);
			

			VBox vboxT = new VBox(30);
			vboxT.getChildren().addAll(forAddT, forDeletT, forUpdateT, forSearchT, forBack1T);
			vboxT.setAlignment(Pos.BOTTOM_CENTER);
			teacherPage.setCenter(vboxT);
			
			GridPane gridAddT = new GridPane();
			BorderPane rootAddT = new BorderPane();
			addCostomerT.setOnAction(e -> {
				scene.setRoot(rootAddT);
			});
			gridAddT.setVgap(10);
			gridAddT.setHgap(20);
			Label costomerIdT = new Label("Teacher Id");
			costomerIdT.setFont(myTitleFontt);
			TextField textIdT = new TextField();
			textIdT.setPromptText("Mandatory");
			textIdT.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
			Label costomerNameT = new Label("Teacher Name");
			costomerNameT.setFont(myTitleFontt);
			TextField textNameT = new TextField();
			textNameT.setPromptText("Mandatory");
			textNameT.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
			textNameT.setDisable(true);
			Label costomerAddressT = new Label("Teacher Address");
			costomerAddressT.setFont(myTitleFontt);
			TextField textAddressT = new TextField();
			textAddressT.setPromptText("Mandatory");
			textAddressT.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
			textAddressT.setDisable(true);
			Label costomerBirthT = new Label("Teacher Birth");
			costomerBirthT.setFont(myTitleFontt);
			TextField textBirth = new TextField();
			textBirth.setPromptText("Mandatory");
			textBirth.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
			textBirth.setDisable(true);
			Label costomerLessonsT = new Label("Number Leasson");
			costomerLessonsT.setFont(myTitleFontt);
			TextField textLess = new TextField();
			textLess.setPromptText("Mandatory");
			textLess.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
			textLess.setDisable(true);
			Label costomerMobileT = new Label("Number Phones");
			costomerMobileT.setFont(myTitleFontt);
			TextField textTelT = new TextField();
			textTelT.setPromptText("Tel (Mandatory):");
			textTelT.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
			textTelT.setDisable(true);
			//Label costomerTel = new Label("Tel :");
			//costomerTel.setFont(myTitleFontt);
			TextField textMobileT = new TextField();
			textMobileT.setDisable(true);
			textMobileT.setPromptText("Mob (Not Mandatory):");
			textMobileT.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
			ImageView to_AddT = new ImageView("https://img.icons8.com/fluency/344/add.png");
			to_AddT.setFitHeight(50);
			to_AddT.setFitWidth(50);

			ToggleGroup tgT = new ToggleGroup();
			Label titlePlanT = new Label("Teacher Gender");
			titlePlanT.setFont(myTitleFontt);
			RadioButton maleT = new RadioButton("Male");
			maleT.setFont(myTitleFont);
			RadioButton feMaleT = new RadioButton("Female");
			feMaleT.setFont(myTitleFont);
			maleT.setToggleGroup(tgT);
			feMaleT.setToggleGroup(tgT);
			HBox mmT = new HBox(50);
			
			ToggleGroup tggT = new ToggleGroup();
			Label titlePlannT = new Label("Tybe Of Tach");
			titlePlannT.setFont(myTitleFontt);
			RadioButton aGearT = new RadioButton("Automatic Gear");
			aGearT.setFont(myTitleFont);
			RadioButton nGearT = new RadioButton("Normal Gear");
			nGearT.setFont(myTitleFont);
			RadioButton trackT = new RadioButton("Track");
			trackT.setFont(myTitleFont);
			aGearT.setToggleGroup(tggT);
			nGearT.setToggleGroup(tggT);
			trackT.setToggleGroup(tggT);
			HBox mmmT = new HBox(50);
			Button addTheCostomerT = new Button("Add", to_AddT);
			addTheCostomerT.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				addTheCostomerT.setEffect(shadow);
		        });
			addTheCostomerT.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				addTheCostomerT.setEffect(null);
		        });
			addTheCostomerT.setOnAction(e -> {
				String cosIdT = textId.getText();
				String cosNameT = textName.getText();
				String cosAddraseT = textAddress.getText();
				String cosMobileT = textMobile.getText();
				String cosLessT = textLess.getText();
				String cosBirthT = textBirth.getText();
				String cosPlanT;
				String tybeTT;
				if (maleT.isSelected())
					cosPlanT = maleT.getText();
				else
					cosPlanT = feMaleT.getText();
				if (aGearT.isSelected())
					tybeTT = aGearT.getText();
				else if(nGearT.isSelected())
					tybeTT = nGearT.getText();
				else
					tybeTT = trackT.getText();
					

				TextArea addcT = new TextArea();
				
				

			});

			textIdT.setOnKeyPressed(i -> {
				if (textIdT.getText() != "") {
					textNameT.setDisable(false);
				} else {
					textNameT.setDisable(true);
					textAddressT.setDisable(true);
					textMobileT.setDisable(true);
					textTelT.setDisable(true);
					textBirth.setDisable(true);
					textLess.setDisable(true);
					
				}
			});
			textNameT.setOnKeyPressed(i1 -> {
				if (textNameT.getText() != "") {
					textAddressT.setDisable(false);
				} else {
					textAddressT.setDisable(true);
					textMobileT.setDisable(true);
					textTelT.setDisable(true);
					textBirth.setDisable(true);
					textLess.setDisable(true);
				}
			});
			textAddressT.setOnKeyPressed(i2 -> {
				if (textAddressT.getText() != "") {
					textMobileT.setDisable(false);
					textTelT.setDisable(false);
				} else {
					textMobileT.setDisable(true);
					textTelT.setDisable(true);
					textBirth.setDisable(true);
					textLess.setDisable(true);
				}

			});
			textTelT.setOnKeyPressed(i2 -> {
				if (textTelT.getText() != "") {
					textBirth.setDisable(false);
				} else {
					textBirth.setDisable(true);
					textLess.setDisable(true);
				}

			});
			textBirth.setOnKeyPressed(i2 -> {
				if (textBirth.getText() != "") {
					textLess.setDisable(false);
				} else {
					textLess.setDisable(true);
				}

			});
			textLess.setOnKeyPressed(i6 -> {
				if (!textLess.getText().equals("")) {
					mmT.getChildren().addAll(maleT,feMaleT);
					mmmT.getChildren().addAll(aGearT,nGearT,trackT);
				}

			});
			addTheCostomerT.setFont(myTitleFont);
			addTheCostomerT.setStyle("-fx-background-color : red");
			ImageView to_backT = new ImageView(
					"https://img.icons8.com/external-others-phat-plus/344/external-back-essential-blue-others-phat-plus.png?fbclid=IwAR2CJ9dsA0kOSz6V2TtToUV46Nu9sWLPI-pA3TMo48YHbgK-TlgwB3Cx78Y");
			to_backT.setFitHeight(50);
			to_backT.setFitWidth(50);
			Button backAddT = new Button("Back", to_backT);
			backAddT.setStyle("-fx-background-color : red");
			backAddT.setFont(myTitleFont);
			backAddT.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				backAddT.setEffect(shadow);
		        });
			backAddT.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				backAddT.setEffect(null);
		        });
			backAddT.setOnAction(e -> {
				rootAddT.setRight(null);
				textNameT.setDisable(true);
				textAddressT.setDisable(true);
				textMobileT.setDisable(true);
				textMobileT.setDisable(true);
				textTelT.setDisable(true);
				textBirth.setDisable(true);
				textLess.setDisable(true);
				maleT.setSelected(false);
				feMaleT.setSelected(false);
				nGearT.setSelected(false);
				aGearT.setSelected(false);
				trackT.setSelected(false);
				mmT.getChildren().removeAll(maleT,feMaleT);
				mmmT.getChildren().removeAll(nGearT,aGearT,trackT);
				textIdT.clear();
				textNameT.clear();
				textAddressT.clear();
				textMobileT.clear();
				textTelT.clear();
				textTelT.setPromptText("Tel (Mandatory):");
				textTelT.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
				textMobileT.setPromptText("Tel (Mandatory):");
				textMobileT.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
				textBirth.clear();
				textLess.clear();
				textIdT.setPromptText("Mandatory");
				textIdT.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
				textNameT.setPromptText("Mandatory");
				textNameT.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
				textAddressT.setPromptText("Mandatory");
				textAddressT.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
				textBirth.setPromptText("Mandatory");
				textBirth.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
				textLess.setPromptText("Mandatory");
				textLess.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
				scene.setRoot(teacherPage);
			});
			gridAddT.addRow(0, costomerIdT, textIdT);
			gridAddT.addRow(1, costomerNameT, textNameT);
			gridAddT.addRow(2, costomerAddressT, textAddressT);
			gridAddT.addRow(3, costomerMobileT,textTelT,textMobileT);
			gridAddT.addRow(4, costomerBirthT,textBirth);
			gridAddT.addRow(5, costomerLessonsT,textLess);
			gridAddT.addRow(6, titlePlanT, mmT);
			gridAddT.addRow(7, titlePlannT, mmmT);
			gridAddT.addRow(8, addTheCostomerT,backAddT);
			gridAddT.setAlignment(Pos.CENTER);
			rootAddT.setCenter(gridAddT);
			rootAddT.setStyle("-fx-background-color : orange");
			
			
			GridPane gridDeleteT = new GridPane();
			BorderPane rootDeleteT = new BorderPane();
			deleteCostomerT.setOnAction(e -> {
				scene.setRoot(rootDeleteT);
			});
			gridDeleteT.setVgap(10);
			gridDeleteT.setHgap(30);
			Label costomerId1T = new Label("Teacher Id");
			costomerId1T.setFont(myTitleFontt);
			TextField textId1T = new TextField();
			textId1T.setPromptText("Mandatory");
			textId1T.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
			Label costomerName1T = new Label("Teacher Name");
			costomerName1T.setFont(myTitleFontt);
			TextField textName1T = new TextField();
			textName1T.setDisable(true);
			Label costomerAddress1T = new Label("Teacher Address");
			costomerAddress1T.setFont(myTitleFontt);
			TextField textAddress1T = new TextField();
			textAddress1T.setDisable(true);
			Label costomerMobile1T = new Label("Teacher Phones");
			costomerMobile1T.setFont(myTitleFontt);
			TextField textMobile1T = new TextField();
			textMobile1T.setDisable(true);
			TextField textTel1T = new TextField();
			textTel1T.setDisable(true);
			Label costomerBirthT1 = new Label("Teacher Birth");
			costomerBirthT1.setFont(myTitleFontt);
			TextField textBirth1 = new TextField();
			textBirth1.setDisable(true);
			Label costomerLessonsT1 = new Label("Number Leasson");
			costomerLessonsT1.setFont(myTitleFontt);
			TextField textLess1 = new TextField();
			textLess1.setDisable(true);
			Label costomerPlan1T = new Label("Teacher Gender");
			costomerPlan1T.setFont(myTitleFontt);
			TextField textPlan1T = new TextField();
			textPlan1T.setDisable(true);
			Label tybeTraning1T = new Label("Teacher Teach");
			tybeTraning1T.setFont(myTitleFontt);
			TextField textTrain1T = new TextField();
			textTrain1T.setDisable(true);
			ImageView to_DeleteT = new ImageView(
					"https://img.icons8.com/external-kiranshastry-gradient-kiranshastry/344/external-delete-multimedia-kiranshastry-gradient-kiranshastry.png?fbclid=IwAR3Kg7w_RIW8qRtB86cJyYSmKlikZBrewF2AbNx_9U4OuRj0eS52yhhH8mg");
			to_DeleteT.setFitHeight(50);
			to_DeleteT.setFitWidth(50);
			Button deletTheCostomerT = new Button("Delet", to_DeleteT);
			deletTheCostomerT.setStyle("-fx-background-color : red");
			deletTheCostomerT.setFont(myTitleFont);
			deletTheCostomerT.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				deletTheCostomerT.setEffect(shadow);
		        });
			deletTheCostomerT.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				deletTheCostomerT.setEffect(null);
		        });
			
			ImageView to_backdT = new ImageView(
					"https://img.icons8.com/external-others-phat-plus/344/external-back-essential-blue-others-phat-plus.png?fbclid=IwAR2CJ9dsA0kOSz6V2TtToUV46Nu9sWLPI-pA3TMo48YHbgK-TlgwB3Cx78Y");
			to_backdT.setFitHeight(50);
			to_backdT.setFitWidth(50);
			Button backDeletedT = new Button("Back", to_backdT);
			backDeletedT.setStyle("-fx-background-color : red");
			backDeletedT.setFont(myTitleFont);
			backDeletedT.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				backDeletedT.setEffect(shadow);
		        });
			backDeletedT.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				backDeletedT.setEffect(null);
		        });
			backDeletedT.setOnAction(e -> {
				rootDeleteT.setRight(null);
				textId1T.clear();
				textName1T.clear();
				textAddress1T.clear();
				textMobile1T.clear();
				textTel1T.clear();
				textPlan1T.clear();
				textBirth1.clear();
				textLess1.clear();
				textTrain1T.clear();
				textId1T.setPromptText("Mandatory");
				textId1T.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
				scene.setRoot(teacherPage);
			});
			ImageView to_FindT = new ImageView(
					"https://img.icons8.com/external-kiranshastry-gradient-kiranshastry/344/external-find-hotel-kiranshastry-gradient-kiranshastry.png?fbclid=IwAR0aG0Mq0Ar5ivhAo09n9NJsHWSoCcfH2lqj2QyJzdJlT-CYvCpQbdAqmZ8");
			to_FindT.setFitHeight(50);
			to_FindT.setFitWidth(50);
			Button findT = new Button("Find", to_FindT);
			findT.setStyle("-fx-background-color : red");
			findT.setFont(myTitleFont);
			findT.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				findT.setEffect(shadow);
		        });
			findT.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				findT.setEffect(null);
		        });
			backDeletedT.setFont(myTitleFont);
			gridDeleteT.addRow(0, costomerId1T, textId1T);
			gridDeleteT.addRow(1, costomerName1T, textName1T);
			gridDeleteT.addRow(2, costomerAddress1T, textAddress1T);
			gridDeleteT.addRow(3, costomerMobile1T,textTel1T, textMobile1T);
			gridDeleteT.addRow(4, costomerPlan1T, textPlan1T);
			gridDeleteT.addRow(5, costomerBirthT1, textBirth1);
			gridDeleteT.addRow(6, costomerLessonsT1, textLess1);
			gridDeleteT.addRow(7, tybeTraning1T, textTrain1T);
			gridDeleteT.addRow(8, findT, deletTheCostomerT, backDeletedT);
			gridDeleteT.setAlignment(Pos.CENTER);
			rootDeleteT.setCenter(gridDeleteT);
			rootDeleteT.setStyle("-fx-background-color : orange");
			
			GridPane gridUpdateT = new GridPane();
			BorderPane rootUpdateT = new BorderPane();
			updateCostomerT.setOnAction(e -> {
				scene.setRoot(rootUpdateT);
			});
			gridUpdateT.setVgap(10);
			gridUpdateT.setHgap(30);
			Label costomerId2T = new Label("Teacher Id");
			costomerId2T.setFont(myTitleFontt);
			TextField textId2T = new TextField();
			textId2T.setPromptText("Mandatory");
			textId2T.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
			Label costomerName2T = new Label("Teacher Name");
			costomerName2T.setFont(myTitleFontt);
			TextField textName2T = new TextField();
			textName2T.setDisable(true);
			Label costomerAddress2T = new Label("Teacher Address");
			costomerAddress2T.setFont(myTitleFontt);
			TextField textAddress2T = new TextField();
			textAddress2T.setDisable(true);
			Label costomerMobile2T = new Label("Teacher Phones");
			costomerMobile2T.setFont(myTitleFontt);
			TextField textMobile2T = new TextField();
			textMobile2T.setDisable(true);
			TextField textTel2T = new TextField();
			textTel2T.setDisable(true);
			Label costomerBirthT2 = new Label("Teacher Birth");
			costomerBirthT2.setFont(myTitleFontt);
			TextField textBirth2 = new TextField();
			textBirth2.setDisable(true);
			Label costomerLessonsT2 = new Label("Number Leasson");
			costomerLessonsT2.setFont(myTitleFontt);
			TextField textLess2 = new TextField();
			textLess2.setDisable(true);
			Label costomerPlan2T = new Label("Teacher Gender");
			costomerPlan2T.setFont(myTitleFontt);
			TextField textPlan2T = new TextField();
			textPlan2T.setDisable(true);
			Label tybeTraning2T = new Label("Teacher Teach");
			tybeTraning2T.setFont(myTitleFontt);
			TextField textTrain2T = new TextField();
			textTrain2T.setDisable(true);
			ImageView to_UpdateT = new ImageView("https://img.icons8.com/flat-round/344/loop.png");
			to_UpdateT.setFitHeight(50);
			to_UpdateT.setFitWidth(50);
			Button updateTheCostomerT = new Button("Update", to_UpdateT);
			updateTheCostomerT.setStyle("-fx-background-color : red");
			updateTheCostomerT.setFont(myTitleFont);
			updateTheCostomerT.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				updateTheCostomerT.setEffect(shadow);
		        });
			updateTheCostomerT.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				updateTheCostomerT.setEffect(null);
		        });
			ImageView to_backUT = new ImageView(
					"https://img.icons8.com/external-others-phat-plus/344/external-back-essential-blue-others-phat-plus.png?fbclid=IwAR2CJ9dsA0kOSz6V2TtToUV46Nu9sWLPI-pA3TMo48YHbgK-TlgwB3Cx78Y");
			to_backUT.setFitHeight(50);
			to_backUT.setFitWidth(50);
			Button backUpdateT = new Button("Back", to_backUT);
			backUpdateT.setStyle("-fx-background-color : red");
			backUpdateT.setFont(myTitleFont);
			backUpdateT.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				backUpdateT.setEffect(shadow);
		        });
			backUpdateT.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				backUpdateT.setEffect(null);
		        });
			backUpdateT.setOnAction(e -> {
				rootUpdateT.setRight(null);
				textId2T.clear();
				textName2T.clear();
				textAddress2T.clear();
				textMobile2T.clear();
				textTel2T.clear();
				textPlan2T.clear();
				textBirth2.clear();
				textLess2.clear();
				textTrain2T.clear();
				textId2T.setPromptText("Mandatory");
				textId2T.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
				scene.setRoot(teacherPage);
			});
			ImageView to_Find1T = new ImageView(
					"https://img.icons8.com/external-kiranshastry-gradient-kiranshastry/344/external-find-hotel-kiranshastry-gradient-kiranshastry.png?fbclid=IwAR0aG0Mq0Ar5ivhAo09n9NJsHWSoCcfH2lqj2QyJzdJlT-CYvCpQbdAqmZ8");
			to_Find1T.setFitHeight(50);
			to_Find1T.setFitWidth(50);
			Button find1T = new Button("Find", to_Find1T);
			find1T.setStyle("-fx-background-color : red");
			find1T.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				find1T.setEffect(shadow);
		        });
			find1T.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				find1T.setEffect(null);
		        });
			
			find1T.setFont(myTitleFont);
			gridUpdateT.addRow(0, costomerId2T, textId2T);
			gridUpdateT.addRow(1, costomerName2T, textName2T);
			gridUpdateT.addRow(2, costomerAddress2T, textAddress2T);
			gridUpdateT.addRow(3, costomerMobile2T,textTel2T, textMobile2T);
			gridUpdateT.addRow(4, costomerPlan2T, textPlan2T);
			gridUpdateT.addRow(5, costomerBirthT2, textBirth2);
			gridUpdateT.addRow(6, costomerLessonsT2, textLess2);
			gridUpdateT.addRow(7, tybeTraning2T, textTrain2T);
			gridUpdateT.addRow(8, find1T, updateTheCostomerT, backUpdateT);
			gridUpdateT.setAlignment(Pos.CENTER);
			rootUpdateT.setCenter(gridUpdateT);
			rootUpdateT.setStyle("-fx-background-color : orange");
			
			GridPane gridSearchT = new GridPane();
			BorderPane rootSearchT = new BorderPane();
			searchCostomerT.setOnAction(e -> {
				scene.setRoot(rootSearchT);
			});
			gridSearchT.setVgap(10);
			gridSearchT.setHgap(30);
			Label costomerId3T = new Label("Teacher Id");
			costomerId3T.setFont(myTitleFontt);
			TextField textId3T = new TextField();
			textId3T.setPromptText("Mandatory");
			textId3T.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
			Label costomerName3T = new Label("Teacher Name");
			costomerName3T.setFont(myTitleFontt);
			TextField textName3T = new TextField();
			textName3T.setDisable(true);
			Label costomerAddress3T = new Label("Teacher Address");
			costomerAddress3T.setFont(myTitleFontt);
			TextField textAddress3T = new TextField();
			textAddress3T.setDisable(true);
			Label costomerMobile3T = new Label("Teacher Phones");
			costomerMobile3T.setFont(myTitleFontt);
			TextField textMobile3T = new TextField();
			textMobile3T.setDisable(true);
			TextField textTel3T = new TextField();
			textTel3T.setDisable(true);
			Label costomerBirthT3 = new Label("Teacher Birth");
			costomerBirthT3.setFont(myTitleFontt);
			TextField textBirth3 = new TextField();
			textBirth3.setDisable(true);
			Label costomerLessonsT3 = new Label("Number Leasson");
			costomerLessonsT3.setFont(myTitleFontt);
			TextField textLess3 = new TextField();
			textLess3.setDisable(true);
			Label costomerPlan3T = new Label("Teacher Gender");
			costomerPlan3T.setFont(myTitleFontt);
			TextField textPlan3T = new TextField();
			textPlan3T.setDisable(true);
			Label tybeTraning3T = new Label("Teacher Teach");
			tybeTraning3T.setFont(myTitleFontt);
			TextField textTrain3T = new TextField();
			textTrain3T.setDisable(true);
			ImageView to_Find2T = new ImageView(
					"https://img.icons8.com/external-kiranshastry-gradient-kiranshastry/344/external-find-hotel-kiranshastry-gradient-kiranshastry.png?fbclid=IwAR0aG0Mq0Ar5ivhAo09n9NJsHWSoCcfH2lqj2QyJzdJlT-CYvCpQbdAqmZ8");
			to_Find2T.setFitHeight(50);
			to_Find2T.setFitWidth(50);
			Button searchTheCostomerT = new Button("Search", to_Find2T);
			searchTheCostomerT.setStyle("-fx-background-color : red");
			searchTheCostomerT.setFont(myTitleFont);
			searchTheCostomerT.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				searchTheCostomerT.setEffect(shadow);
		        });
			searchTheCostomerT.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				searchTheCostomerT.setEffect(null);
		        });
			ImageView to_backmT = new ImageView(
					"https://img.icons8.com/external-others-phat-plus/344/external-back-essential-blue-others-phat-plus.png?fbclid=IwAR2CJ9dsA0kOSz6V2TtToUV46Nu9sWLPI-pA3TMo48YHbgK-TlgwB3Cx78Y");
			to_backmT.setFitHeight(50);
			to_backmT.setFitWidth(50);
			Button backSearchT = new Button("Back", to_backmT);
			backSearchT.setStyle("-fx-background-color : red");
			backSearchT.setFont(myTitleFont);
			backSearchT.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				backSearchT.setEffect(shadow);
		        });
			backSearchT.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				backSearchT.setEffect(null);
		        });
			backSearchT.setOnAction(e -> {
				rootSearchT.setRight(null);
				textId3T.clear();
				textName3T.clear();
				textAddress3T.clear();
				textMobile3T.clear();
				textTel3T.clear();
				textPlan3T.clear();
				textBirth3.clear();
				textLess3.clear();
				textTrain3T.clear();
				textId3T.setPromptText("Mandatory");
				textId3T.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
				scene.setRoot(teacherPage);
			});
			gridSearchT.addRow(0, costomerId3T, textId3T);
			gridSearchT.addRow(1, costomerName3T, textName3T);
			gridSearchT.addRow(2, costomerAddress3T, textAddress3T);
			gridSearchT.addRow(3, costomerMobile3T,textTel3T, textMobile3T);
			gridSearchT.addRow(4, costomerPlan3T, textPlan3T);
			gridSearchT.addRow(5, costomerBirthT3, textBirth3);
			gridSearchT.addRow(6, costomerLessonsT3, textLess3);
			gridSearchT.addRow(7, tybeTraning3T, textTrain3T);
			gridSearchT.addRow(8, searchTheCostomerT,backSearchT);
			gridSearchT.setAlignment(Pos.CENTER);
			rootSearchT.setCenter(gridSearchT);
			rootSearchT.setStyle("-fx-background-color : orange");
			
			forAddT.setOnMouseClicked(e -> {
				scene.setRoot(rootAddT);
			});
			forDeletT.setOnMouseClicked(e -> {
				scene.setRoot(rootDeleteT);
			});
			forUpdateT.setOnMouseClicked(e -> {
				scene.setRoot(rootUpdateT);
			});
			forSearchT.setOnMouseClicked(e -> {
				scene.setRoot(rootSearchT);
			});
			
			BorderPane carPage = new BorderPane();
			carBtn.setOnAction(e->{
				scene.setRoot(carPage);
			});
			forCar.setOnMouseClicked(e->{
				scene.setRoot(carPage);
			});
			carPage.setStyle("-fx-background-color : blue");
			
			StackPane forAddC = new StackPane();
			Rectangle shp9C = new Rectangle(550, 100);
			shp9C.setArcWidth(70);
			shp9C.setArcHeight(70);
			shp9C.setFill(Color.GREEN);
			shp9C.setStroke(Color.RED);
			Button addCostomerC = new Button("Add Vehicle");
			addCostomerC.setStyle("-fx-background-color : green");
			addCostomerC.setTextFill(Color.ORANGE);
			addCostomerC.setFont(myTitleFont);
			addCostomerC.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				addCostomerC.setEffect(shadow);
				shp9C.setEffect(shadow);
		        });
			addCostomerC.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				addCostomerC.setEffect(null);
				shp9C.setEffect(null);
		        });
			forAddC.getChildren().addAll(shp9C, addCostomerC);

			StackPane forDeletC = new StackPane();
			Rectangle shp5C = new Rectangle(550, 100);
			shp5C.setArcWidth(70);
			shp5C.setArcHeight(70);
			shp5C.setFill(Color.GREEN);
			shp5C.setStroke(Color.RED);
			Button deleteCostomerC = new Button("Delete Vehicle");
			deleteCostomerC.setStyle("-fx-background-color : green");
			deleteCostomerC.setTextFill(Color.ORANGE);
			deleteCostomerC.setFont(myTitleFont);
			deleteCostomerC.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				deleteCostomerC.setEffect(shadow);
				shp5C.setEffect(shadow);
		        });
			deleteCostomerC.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				deleteCostomerC.setEffect(null);
				shp5C.setEffect(null);
		        });
			forDeletC.getChildren().addAll(shp5C, deleteCostomerC);

			StackPane forUpdateC = new StackPane();
			Rectangle shp6C = new Rectangle(550, 100);
			shp6C.setArcWidth(70);
			shp6C.setArcHeight(70);
			shp6C.setFill(Color.GREEN);
			shp6C.setStroke(Color.RED);
			Button updateCostomerC = new Button("Update Vehicle Information");
			updateCostomerC.setStyle("-fx-background-color : green");
			updateCostomerC.setTextFill(Color.ORANGE);
			updateCostomerC.setFont(myTitleFont);
			updateCostomerC.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				updateCostomerC.setEffect(shadow);
				shp6C.setEffect(shadow);
		        });
			updateCostomerC.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				updateCostomerC.setEffect(null);
				shp6C.setEffect(null);
		        });
			forUpdateC.getChildren().addAll(shp6C, updateCostomerC);

			StackPane forSearchC = new StackPane();
			Rectangle shp7C = new Rectangle(550, 100);
			shp7C.setArcWidth(70);
			shp7C.setArcHeight(70);
			shp7C.setFill(Color.GREEN);
			shp7C.setStroke(Color.RED);
			Button searchCostomerC = new Button("Search a Vehicle by id");
			searchCostomerC.setStyle("-fx-background-color : green");
			searchCostomerC.setTextFill(Color.ORANGE);
			searchCostomerC.setFont(myTitleFont);
			searchCostomerC.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				searchCostomerC.setEffect(shadow);
				shp7C.setEffect(shadow);
		        });
			searchCostomerC.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				searchCostomerC.setEffect(null);
				shp7C.setEffect(null);
		        });
			forSearchC.getChildren().addAll(shp7C, searchCostomerC);

			StackPane forBack1C = new StackPane();
			Rectangle shp8C = new Rectangle(550, 100);
			shp8C.setArcWidth(70);
			shp8C.setArcHeight(70);
			shp8C.setFill(Color.GREEN);
			shp8C.setStroke(Color.RED);
			Button returnToMainC = new Button("Return to main");
			returnToMainC.setStyle("-fx-background-color : green");
			returnToMainC.setTextFill(Color.ORANGE);
			returnToMainC.setFont(myTitleFont);
			returnToMainC.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				returnToMainC.setEffect(shadow);
				shp8C.setEffect(shadow);
		        });
			returnToMainC.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				returnToMainC.setEffect(null);
				shp8C.setEffect(null);
		        });
			forBack1C.getChildren().addAll(shp8C, returnToMainC);
			
			returnToMainC.setOnAction(e->{
				scene.setRoot(rootManeger);
			});
			
			Text myTitle1C = new Text("CLICK ABOUT WHAT DO YOU WANT");
			myTitle1C.setFill(Color.GREEN);
			myTitle1C.setStroke(Color.ORANGE);
			myTitle1C.setUnderline(true);
			myTitle1C.setFont(myTitleFont);
			HBox hboxxC = new HBox();
			hboxxC.getChildren().add(myTitle1C);
			hboxxC.setAlignment(Pos.TOP_CENTER);
			carPage.setTop(hboxxC);

			VBox vboxC = new VBox(30);
			vboxC.getChildren().addAll(forAddC, forDeletC, forUpdateC, forSearchC, forBack1C);
			vboxC.setAlignment(Pos.BOTTOM_CENTER);
			carPage.setCenter(vboxC);
			
			GridPane gridAddC = new GridPane();
			BorderPane rootAddC = new BorderPane();
			addCostomerC.setOnAction(e -> {
				scene.setRoot(rootAddC);
			});
			forAddC.setOnMouseClicked(e ->{
				scene.setRoot(rootAddC);
			});
			gridAddC.setVgap(10);
			gridAddC.setHgap(20);
			Label IdCar = new Label("Vehicle Id");
			IdCar.setFont(myTitleFontt);
			TextField textIdC = new TextField();
			textIdC.setPromptText("Mandatory");
			textIdC.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
			Label NameC = new Label("Vehicle Name");
			NameC.setFont(myTitleFontt);
			TextField textNameC = new TextField();
			textNameC.setPromptText("Mandatory");
			textNameC.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
			textNameC.setDisable(true);
			Label yearofpurchasing = new Label("Year Purchasing");
			yearofpurchasing.setFont(myTitleFontt);
			TextField yearofpurchasingText = new TextField();
			yearofpurchasingText.setPromptText("Mandatory");
			yearofpurchasingText.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
			yearofpurchasingText.setDisable(true);
			Label licenseAndInsurance = new Label("License And Insurance");
			licenseAndInsurance.setFont(myTitleFontt);
			TextField licenseAndInsuranceText = new TextField();
			licenseAndInsuranceText.setPromptText("Mandatory");
			licenseAndInsuranceText.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
			licenseAndInsuranceText.setDisable(true);
			Label readyTrain = new Label("readyTrain");
			readyTrain.setFont(myTitleFontt);
			TextField readyTrainText = new TextField();
			readyTrainText.setPromptText("Mandatory");
			readyTrainText.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
			readyTrainText.setDisable(true);
			Label modelC = new Label("Model");
			modelC.setFont(myTitleFontt);
			TextField modelCText = new TextField();
			modelCText.setDisable(true);
			modelCText.setPromptText("Mandatory");
			modelCText.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
			ImageView to_AddC = new ImageView("https://img.icons8.com/fluency/344/add.png");
			to_AddC.setFitHeight(50);
			to_AddC.setFitWidth(50);
			
			ToggleGroup tggC = new ToggleGroup();
			Label tybeTrain = new Label("Tybe Of Train");
			tybeTrain.setFont(myTitleFontt);
			RadioButton aGearC = new RadioButton("Automatic Gear");
			aGearC.setFont(myTitleFont);
			RadioButton nGearC = new RadioButton("Normal Gear");
			nGearC.setFont(myTitleFont);
			RadioButton trackC = new RadioButton("Track");
			trackC.setFont(myTitleFont);
			aGearC.setToggleGroup(tggC);
			nGearC.setToggleGroup(tggC);
			trackC.setToggleGroup(tggC);
			HBox mmmC = new HBox(50);
			Button addTheCostomerC = new Button("Add", to_AddC);
			addTheCostomerC.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				addTheCostomerC.setEffect(shadow);
		        });
			addTheCostomerC.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				addTheCostomerC.setEffect(null);
		        });
			addTheCostomerC.setOnAction(e -> {
				String cosIdC = textId.getText();
				String cosNameC = textName.getText();
				String cosAddraseC = textAddress.getText();
				String cosMobileC = textMobile.getText();
				String cosPlanC;
				String tybeTC;
				
				if (aGearC.isSelected())
					tybeTC = aGearC.getText();
				else if(nGearC.isSelected())
					tybeTC = nGearC.getText();
				else
					tybeTC = trackC.getText();
					

				TextArea addc = new TextArea();
				
				

			});

			textIdC.setOnKeyPressed(i -> {
				if (textIdC.getText() != "") {
					textNameC.setDisable(false);
				} else {
					textNameC.setDisable(true);
					yearofpurchasingText.setDisable(true);
					licenseAndInsuranceText.setDisable(true);
					readyTrainText.setDisable(true);
					modelCText.setDisable(true);
				}
			});
			textNameC.setOnKeyPressed(i1 -> {
				if (textNameC.getText() != "") {
					yearofpurchasingText.setDisable(false);
				} else {
					yearofpurchasingText.setDisable(true);
					licenseAndInsuranceText.setDisable(true);
					readyTrainText.setDisable(true);
					modelCText.setDisable(true);
				}
			});
			yearofpurchasingText.setOnKeyPressed(i2 -> {
				if (yearofpurchasingText.getText() != "") {
					licenseAndInsuranceText.setDisable(false);
				} else {
					licenseAndInsuranceText.setDisable(true);
					readyTrainText.setDisable(true);
					modelCText.setDisable(true);
				}

			});
			licenseAndInsuranceText.setOnKeyPressed(i2 -> {
				if (licenseAndInsuranceText.getText() != "") {
					readyTrainText.setDisable(false);
				} else {
					readyTrainText.setDisable(true);
					modelCText.setDisable(true);
				}

			});
			readyTrainText.setOnKeyPressed(i2 -> {
				if (readyTrainText.getText() != "") {
					modelCText.setDisable(false);
				} else {
					modelCText.setDisable(true);
				}

			});
			modelCText.setOnKeyPressed(i6 -> {
				if (!modelCText.getText().equals("")) {
					mmmC.getChildren().addAll(aGearC,nGearC,trackC);
				}

			});
			addTheCostomerC.setFont(myTitleFont);
			addTheCostomerC.setStyle("-fx-background-color : red");
			ImageView to_backC = new ImageView(
					"https://img.icons8.com/external-others-phat-plus/344/external-back-essential-blue-others-phat-plus.png?fbclid=IwAR2CJ9dsA0kOSz6V2TtToUV46Nu9sWLPI-pA3TMo48YHbgK-TlgwB3Cx78Y");
			to_backC.setFitHeight(50);
			to_backC.setFitWidth(50);
			Button backAddC = new Button("Back", to_backC);
			backAddC.setStyle("-fx-background-color : red");
			backAddC.setFont(myTitleFont);
			backAddC.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				backAddC.setEffect(shadow);
		        });
			backAddC.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				backAddC.setEffect(null);
		        });
			backAddC.setOnAction(e -> {
				rootAddC.setRight(null);
				textNameC.setDisable(true);
				yearofpurchasingText.setDisable(true);
				licenseAndInsuranceText.setDisable(true);
				readyTrainText.setDisable(true);
				modelCText.setDisable(true);
				nGearC.setSelected(false);
				aGearC.setSelected(false);
				trackC.setSelected(false);
				mmmC.getChildren().removeAll(nGearC,aGearC,trackC);
				textIdC.clear();
				textNameC.clear();
				yearofpurchasingText.clear();
				licenseAndInsuranceText.clear();
				readyTrainText.clear();
				modelCText.clear();
				yearofpurchasingText.setPromptText("Mandatory");
				yearofpurchasingText.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
				licenseAndInsuranceText.setPromptText("Mandatory");
				licenseAndInsuranceText.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
				textIdC.setPromptText("Mandatory");
				textIdC.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
				textNameC.setPromptText("Mandatory");
				textNameC.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
				readyTrainText.setPromptText("Mandatory");
				readyTrainText.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
				modelCText.setPromptText("Mandatory");
				modelCText.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
				scene.setRoot(carPage);
			});
			gridAddC.addRow(0,IdCar, textIdC);
			gridAddC.addRow(1,NameC, textNameC);
			gridAddC.addRow(2,yearofpurchasing,yearofpurchasingText);
			gridAddC.addRow(3,licenseAndInsurance,licenseAndInsuranceText);
			gridAddC.addRow(4,readyTrain,readyTrainText);
			gridAddC.addRow(5,modelC,modelCText);
			gridAddC.addRow(6,tybeTrain, mmmC);
			gridAddC.addRow(7, addTheCostomerC,backAddC);
			gridAddC.setAlignment(Pos.CENTER);
			rootAddC.setCenter(gridAddC);
			rootAddC.setStyle("-fx-background-color : orange");
			
			
			GridPane gridDeleteC = new GridPane();
			BorderPane rootDeleteC = new BorderPane();
			deleteCostomerC.setOnAction(e -> {
				scene.setRoot(rootDeleteC);
			});
			forDeletC.setOnMouseClicked(e->{
				scene.setRoot(rootDeleteC);
			});
			gridDeleteC.setVgap(10);
			gridDeleteC.setHgap(30);
			Label IdCar1 = new Label("Vehicle Id");
			IdCar1.setFont(myTitleFontt);
			TextField textIdC1 = new TextField();
			Label NameC1 = new Label("Vehicle Name");
			NameC1.setFont(myTitleFontt);
			TextField textNameC1 = new TextField();
			textNameC1.setDisable(true);
			Label yearofpurchasing1 = new Label("Year Purchasing");
			yearofpurchasing1.setFont(myTitleFontt);
			TextField yearofpurchasingText1 = new TextField();
			yearofpurchasingText1.setDisable(true);
			Label licenseAndInsurance1 = new Label("License And Insurance");
			licenseAndInsurance1.setFont(myTitleFontt);
			TextField licenseAndInsuranceText1 = new TextField();
			licenseAndInsuranceText1.setDisable(true);
			Label readyTrain1 = new Label("readyTrain");
			readyTrain1.setFont(myTitleFontt);
			TextField readyTrainText1 = new TextField();
			readyTrainText1.setDisable(true);
			Label modelC1 = new Label("Model");
			modelC1.setFont(myTitleFontt);
			TextField modelCText1 = new TextField();
			modelCText1.setDisable(true);
			Label typeUsed = new Label("Type Train");
			typeUsed.setFont(myTitleFontt);
			TextField TypeUsedText = new TextField();
			TypeUsedText.setDisable(true);
			ImageView to_DeleteC = new ImageView(
					"https://img.icons8.com/external-kiranshastry-gradient-kiranshastry/344/external-delete-multimedia-kiranshastry-gradient-kiranshastry.png?fbclid=IwAR3Kg7w_RIW8qRtB86cJyYSmKlikZBrewF2AbNx_9U4OuRj0eS52yhhH8mg");
			to_DeleteC.setFitHeight(50);
			to_DeleteC.setFitWidth(50);
			Button deletTheCostomerC = new Button("Delet", to_DeleteC);
			deletTheCostomerC.setStyle("-fx-background-color : red");
			deletTheCostomerC.setFont(myTitleFont);
			deletTheCostomerC.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				deletTheCostomerC.setEffect(shadow);
		        });
			deletTheCostomerC.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				deletTheCostomerC.setEffect(null);
		        });
			
			ImageView to_backdC = new ImageView(
					"https://img.icons8.com/external-others-phat-plus/344/external-back-essential-blue-others-phat-plus.png?fbclid=IwAR2CJ9dsA0kOSz6V2TtToUV46Nu9sWLPI-pA3TMo48YHbgK-TlgwB3Cx78Y");
			to_backdC.setFitHeight(50);
			to_backdC.setFitWidth(50);
			Button backDeletedC = new Button("Back", to_backdC);
			backDeletedC.setStyle("-fx-background-color : red");
			backDeletedC.setFont(myTitleFont);
			backDeletedC.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				backDeletedC.setEffect(shadow);
		        });
			backDeletedC.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				backDeletedC.setEffect(null);
		        });
			backDeletedC.setOnAction(e -> {
				rootDeleteC.setRight(null);
				textIdC1.clear();
				textNameC1.clear();
				yearofpurchasingText1.clear();
				licenseAndInsuranceText1.clear();
				readyTrainText1.clear();
				modelCText1.clear();
				TypeUsedText.clear();
				textIdC1.setPromptText("Mandatory");
				textIdC1.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
				scene.setRoot(carPage);
			});
			ImageView to_FindC = new ImageView(
					"https://img.icons8.com/external-kiranshastry-gradient-kiranshastry/344/external-find-hotel-kiranshastry-gradient-kiranshastry.png?fbclid=IwAR0aG0Mq0Ar5ivhAo09n9NJsHWSoCcfH2lqj2QyJzdJlT-CYvCpQbdAqmZ8");
			to_FindC.setFitHeight(50);
			to_FindC.setFitWidth(50);
			Button findC = new Button("Find", to_FindC);
			findC.setStyle("-fx-background-color : red");
			findC.setFont(myTitleFont);
			findC.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				findC.setEffect(shadow);
		        });
			findC.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				findC.setEffect(null);
		        });
			backDeletedC.setFont(myTitleFont);
			gridDeleteC.addRow(0,IdCar1, textIdC1);
			gridDeleteC.addRow(1,NameC1, textNameC1);
			gridDeleteC.addRow(2,yearofpurchasing1,yearofpurchasingText1);
			gridDeleteC.addRow(3,licenseAndInsurance1,licenseAndInsuranceText1);
			gridDeleteC.addRow(4,readyTrain1,readyTrainText1);
			gridDeleteC.addRow(5,modelC1,modelCText1);
			gridDeleteC.addRow(6,typeUsed,TypeUsedText);
			gridDeleteC.addRow(7, findC, deletTheCostomerC, backDeletedC);
			gridDeleteC.setAlignment(Pos.CENTER);
			rootDeleteC.setCenter(gridDeleteC);
			rootDeleteC.setStyle("-fx-background-color : orange");
			
			GridPane gridUpdateC = new GridPane();
			BorderPane rootUpdateC = new BorderPane();
			updateCostomerC.setOnAction(e -> {
				scene.setRoot(rootUpdateC);
			});
			forUpdateC.setOnMouseClicked(e->{
				scene.setRoot(rootUpdateC);
			});
			gridUpdateC.setVgap(10);
			gridUpdateC.setHgap(30);
			Label IdCar2 = new Label("Vehicle Id");
			IdCar2.setFont(myTitleFontt);
			TextField textIdC2 = new TextField();
			Label NameC2 = new Label("Vehicle Name");
			NameC2.setFont(myTitleFontt);
			TextField textNameC2 = new TextField();
			textNameC2.setDisable(true);
			Label yearofpurchasing2 = new Label("Year Purchasing");
			yearofpurchasing2.setFont(myTitleFontt);
			TextField yearofpurchasingText2 = new TextField();
			yearofpurchasingText2.setDisable(true);
			Label licenseAndInsurance2 = new Label("License And Insurance");
			licenseAndInsurance2.setFont(myTitleFontt);
			TextField licenseAndInsuranceText2 = new TextField();
			licenseAndInsuranceText2.setDisable(true);
			Label readyTrain2 = new Label("readyTrain");
			readyTrain2.setFont(myTitleFontt);
			TextField readyTrainText2 = new TextField();
			readyTrainText2.setDisable(true);
			Label modelC2 = new Label("Model");
			modelC2.setFont(myTitleFontt);
			TextField modelCText2 = new TextField();
			modelCText2.setDisable(true);
			Label typeUsed2 = new Label("Type Train");
			typeUsed2.setFont(myTitleFontt);
			TextField TypeUsedText2 = new TextField();
			TypeUsedText2.setDisable(true);
			ImageView to_UpdateC = new ImageView("https://img.icons8.com/flat-round/344/loop.png");
			to_UpdateC.setFitHeight(50);
			to_UpdateC.setFitWidth(50);
			Button updateTheCostomerC = new Button("Update", to_UpdateC);
			updateTheCostomerC.setStyle("-fx-background-color : red");
			updateTheCostomerC.setFont(myTitleFont);
			updateTheCostomerC.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				updateTheCostomerC.setEffect(shadow);
		        });
			updateTheCostomerC.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				updateTheCostomerC.setEffect(null);
		        });
			ImageView to_backUC = new ImageView(
					"https://img.icons8.com/external-others-phat-plus/344/external-back-essential-blue-others-phat-plus.png?fbclid=IwAR2CJ9dsA0kOSz6V2TtToUV46Nu9sWLPI-pA3TMo48YHbgK-TlgwB3Cx78Y");
			to_backUC.setFitHeight(50);
			to_backUC.setFitWidth(50);
			Button backUpdateC = new Button("Back", to_backUC);
			backUpdateC.setStyle("-fx-background-color : red");
			backUpdateC.setFont(myTitleFont);
			backUpdateC.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				backUpdateC.setEffect(shadow);
		        });
			backUpdateC.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				backUpdateC.setEffect(null);
		        });
			backUpdateC.setOnAction(e -> {
				rootUpdateC.setRight(null);
				textIdC2.clear();
				textNameC2.clear();
				yearofpurchasingText2.clear();
				licenseAndInsuranceText2.clear();
				readyTrainText2.clear();
				modelCText2.clear();
				TypeUsedText2.clear();
				textIdC2.setPromptText("Mandatory");
				textIdC2.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
				scene.setRoot(carPage);
			});
			ImageView to_Find1C = new ImageView(
					"https://img.icons8.com/external-kiranshastry-gradient-kiranshastry/344/external-find-hotel-kiranshastry-gradient-kiranshastry.png?fbclid=IwAR0aG0Mq0Ar5ivhAo09n9NJsHWSoCcfH2lqj2QyJzdJlT-CYvCpQbdAqmZ8");
			to_Find1C.setFitHeight(50);
			to_Find1C.setFitWidth(50);
			Button find1C = new Button("Find", to_Find1C);
			find1C.setStyle("-fx-background-color : red");
			find1C.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				find1C.setEffect(shadow);
		        });
			find1C.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				find1C.setEffect(null);
		        });
			
			find1C.setFont(myTitleFont);
			gridUpdateC.addRow(0,IdCar2, textIdC2);
			gridUpdateC.addRow(1,NameC2, textNameC2);
			gridUpdateC.addRow(2,yearofpurchasing2,yearofpurchasingText2);
			gridUpdateC.addRow(3,licenseAndInsurance2,licenseAndInsuranceText2);
			gridUpdateC.addRow(4,readyTrain2,readyTrainText2);
			gridUpdateC.addRow(5,modelC2,modelCText2);
			gridUpdateC.addRow(6,typeUsed2,TypeUsedText2);
			gridUpdateC.addRow(7, find1C, updateTheCostomerC, backUpdateC);
			gridUpdateC.setAlignment(Pos.CENTER);
			rootUpdateC.setCenter(gridUpdateC);
			rootUpdateC.setStyle("-fx-background-color : orange");
			
			GridPane gridSearchC = new GridPane();
			BorderPane rootSearchC = new BorderPane();
			searchCostomerC.setOnAction(e -> {
				scene.setRoot(rootSearchC);
			});
			forSearchC.setOnMouseClicked(e->{
				scene.setRoot(rootSearchC);
			});
			gridSearchC.setVgap(10);
			gridSearchC.setHgap(30);
			Label IdCar3 = new Label("Vehicle Id");
			IdCar3.setFont(myTitleFontt);
			TextField textIdC3 = new TextField();
			Label NameC3 = new Label("Vehicle Name");
			NameC3.setFont(myTitleFontt);
			TextField textNameC3 = new TextField();
			textNameC3.setDisable(true);
			Label yearofpurchasing3 = new Label("Year Purchasing");
			yearofpurchasing3.setFont(myTitleFontt);
			TextField yearofpurchasingText3 = new TextField();
			yearofpurchasingText3.setDisable(true);
			Label licenseAndInsurance3 = new Label("License And Insurance");
			licenseAndInsurance3.setFont(myTitleFontt);
			TextField licenseAndInsuranceText3 = new TextField();
			licenseAndInsuranceText3.setDisable(true);
			Label readyTrain3 = new Label("readyTrain");
			readyTrain3.setFont(myTitleFontt);
			TextField readyTrainText3 = new TextField();
			readyTrainText3.setDisable(true);
			Label modelC3 = new Label("Model");
			modelC3.setFont(myTitleFontt);
			TextField modelCText3 = new TextField();
			modelCText3.setDisable(true);
			Label typeUsed3 = new Label("Type Train");
			typeUsed3.setFont(myTitleFontt);
			TextField TypeUsedText3 = new TextField();
			TypeUsedText3.setDisable(true);
			ImageView to_FindC1 = new ImageView(
					"https://img.icons8.com/external-kiranshastry-gradient-kiranshastry/344/external-find-hotel-kiranshastry-gradient-kiranshastry.png?fbclid=IwAR0aG0Mq0Ar5ivhAo09n9NJsHWSoCcfH2lqj2QyJzdJlT-CYvCpQbdAqmZ8");
			to_FindC1.setFitHeight(50);
			to_FindC1.setFitWidth(50);
			Button searchTheCostomerC = new Button("Search", to_FindC1);
			searchTheCostomerC.setStyle("-fx-background-color : red");
			searchTheCostomerC.setFont(myTitleFont);
			searchTheCostomerC.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				searchTheCostomerC.setEffect(shadow);
		        });
			searchTheCostomerC.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				searchTheCostomerC.setEffect(null);
		        });
			ImageView to_backmC = new ImageView(
					"https://img.icons8.com/external-others-phat-plus/344/external-back-essential-blue-others-phat-plus.png?fbclid=IwAR2CJ9dsA0kOSz6V2TtToUV46Nu9sWLPI-pA3TMo48YHbgK-TlgwB3Cx78Y");
			to_backmC.setFitHeight(50);
			to_backmC.setFitWidth(50);
			Button backSearchC = new Button("Back", to_backmC);
			backSearchC.setStyle("-fx-background-color : red");
			backSearchC.setFont(myTitleFont);
			backSearchC.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				backSearchC.setEffect(shadow);
		        });
			backSearchC.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				backSearchC.setEffect(null);
		        });
			backSearchC.setOnAction(e -> {
				rootSearchC.setRight(null);
				textIdC3.clear();
				textNameC3.clear();
				yearofpurchasingText3.clear();
				licenseAndInsuranceText3.clear();
				readyTrainText3.clear();
				modelCText3.clear();
				TypeUsedText3.clear();
				textIdC3.setPromptText("Mandatory");
				textIdC3.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
				scene.setRoot(carPage);
			});
			gridSearchC.addRow(0,IdCar3, textIdC3);
			gridSearchC.addRow(1,NameC3, textNameC3);
			gridSearchC.addRow(2,yearofpurchasing3,yearofpurchasingText3);
			gridSearchC.addRow(3,licenseAndInsurance3,licenseAndInsuranceText3);
			gridSearchC.addRow(4,readyTrain3,readyTrainText3);
			gridSearchC.addRow(5,modelC3,modelCText3);
			gridSearchC.addRow(6,typeUsed3,TypeUsedText3);
			gridSearchC.addRow(7,searchTheCostomerC, backSearchC);
			gridSearchC.setAlignment(Pos.CENTER);
			rootSearchC.setCenter(gridSearchC);
			rootSearchC.setStyle("-fx-background-color : orange");
			
			

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setMaximized(true);
			Stage stage = (Stage) root.getScene().getWindow();
			stage.setFullScreen(true);
			
			try{  
				   Class.forName("com.mysql.cj.jdbc.Driver");
				    
				   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/training_school","root","salma@eng1234");  

				   Statement stmt=con.createStatement();
				    
				   ResultSet rs=stmt.executeQuery("select * from student");

				   
				   
				   
//					public StudentAddingFromAdmin(int id, String name, String address,String work, int tel, String gender, int mobile
//							, int t_number, int v_number, String typeOfTraning , int tybe_number) {

				   while(rs.next())  
				    student.add(new StudentAddingFromAdmin(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10)));
				   con.close();  
				   
				   }catch(Exception e){
				    System.out.println(e);
				   }
			
			searchTheCostomer.setOnAction(e->{
				StudentAddingFromAdmin x = moh.searchStudent(Integer.parseInt(textId3.getText().trim()));
				if(x != null) {
					textName3.setText(x.name);
					textAddress3.setText(x.address);
					textTel3.setText(Integer.toString(x.tel));
					textMobile3.setText(Integer.toString(x.mobile));
					textPlan3.setText(x.gender);
					textWork3.setText(x.work);

					if(x.typeOfTraning == 1) 
						textTrain3.setText("Automatic Gear");
					else if(x.typeOfTraning == 2)
						textTrain3.setText("Normal Gear");
					else if(x.typeOfTraning == 3)
						textTrain3.setText("Truck");
					else
						textTrain3.setText("Null");
					
					Label labelSearch = new Label("The Student Is Found");
					labelSearch.setFont(myTitleFontt);
					labelSearch.setStyle("-fx-background-color : red");
					labelSearch.setTranslateX(400);
					rootSearch.setBottom(labelSearch);
				}
				else {
					textName3.setText("Null");
					textAddress3.setText("Null");
					textTel3.setText("Null");
					textMobile3.setText("Null");
					textPlan3.setText("Null");
					textWork3.setText("Null");
					textTrain3.setText("Null");
					Label labelSearch = new Label("The Student Is Not Found, Try Again.");
					labelSearch.setFont(myTitleFontt);
					labelSearch.setStyle("-fx-background-color : red");
					labelSearch.setTranslateX(200);
					rootSearch.setBottom(labelSearch);
				}
			});
			
			
			
addTheCostomer.setOnAction(e -> {
								
	
			String cosId = textId.getText();
			String cosMobile = textMobile.getText();
			String cosTel = textTel.getText();
			String cosName = textName.getText();
			String cosWorking = textWorking.getText();
			String cosAddrase = textAddress.getText();
			String cosGender;
			String costybeT;
			
			
			if (male.isSelected())
				cosGender = "M";
			else
				cosGender = "F";
			
			if (aGear.isSelected())
				costybeT = aGear.getText();
			else if(nGear.isSelected())
				costybeT = nGear.getText();
			else
				costybeT = track.getText();
					
				
				if(!textId.getText().equals("") &&  !textName.getText().equals("") && !textAddress.getText().equals("") &&  !textMobile.getText().equals("") && !textTel.getText().equals("") && !textWorking.getText().equals("") && !cosGender.equals("") && !costybeT.equals("")) {
					
					
					
					int cosIdAfter = Integer.parseInt(textId.getText().trim());
					int cosMobileAfter = Integer.parseInt(textMobile.getText().trim());
					int cosTelAfter = Integer.parseInt(textTel.getText().trim());
					
					int zeft;
					
					if(costybeT.equals("Automatic")) {
						zeft = 1;
					}else if(costybeT.equals("Normal")) {
						zeft = 2;
					}else if(costybeT.equals("Truck")) {
						zeft = 3;
					}else {
						zeft = 0;
					}
					
					
					boolean isExist = moh.isTheStudentExist(cosIdAfter, cosName, cosAddrase, cosMobileAfter, cosTelAfter, cosWorking, cosGender, zeft);
					
					
					
				if(isExist == false) {

					Label invalid = new Label("Sorry, we cannot Add this student.");
					
					invalid.setFont(myTitleFontt);
					invalid.setStyle("-fx-background-color : red");
					invalid.setTranslateX(200);
					rootAdd.setBottom(invalid);
				
				}else {
					
					
					///ADDING TO THE SQL DATABASE
					try {
					 Class.forName("com.mysql.cj.jdbc.Driver");
					    
					   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/training_school","root","salma@eng1234");  

					   Statement stmt1=con.createStatement();
					    
					   stmt1.executeUpdate("INSERT INTO student VALUES ("+cosIdAfter+",' "+cosName+"', '"+cosAddrase+"', '"+cosWorking+"', "+cosMobileAfter+", '"+cosGender+"', "+cosTelAfter+", 1 , 1 , "+zeft+");");
					   
					}catch(Exception e1){
					    System.out.println(e1);
					   }

					
					Label valid = new Label("Adding this student successfully!");
					
					valid.setFont(myTitleFontt);
					valid.setStyle("-fx-background-color : red");
					valid.setTranslateX(200);
					rootAdd.setBottom(valid);

				}}else {
					
					Label invalid = new Label("Sorry, but you must fill the whole info to Add this student.");
					invalid.setFont(Font.font(10));
					invalid.setFont(myTitleFontt);
					invalid.setStyle("-fx-background-color : red");
					invalid.setTranslateX(200);
					rootAdd.setBottom(invalid);
					
				}

			});

			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
