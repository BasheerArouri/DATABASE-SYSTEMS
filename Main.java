package application;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
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
	Connection con;
	int typeBeforeU = 0;
	ComboBox<String> combo_boxaGear = null;
	ComboBox<String> combo_boxnGear = null;
	ComboBox<String> combo_boxTruck = null;
	int[][] arr = new int[5][];
	int t_numberBefor;

	public void Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/training_school", "root", "salma@eng1234");

		} catch (Exception e1) {
			System.out.println(e1);
		}
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			Font myTitleF = Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 10);
			Font myTitleFon = Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 15);
			BorderPane rootForTeacher = new BorderPane();
			BorderPane rootForStudent = new BorderPane();
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
			Font myTitleFont = Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 25);
			Font myTitleFontt = Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 50);
			myTitle.setFont(myTitleFontt);
			BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
			root.setBackground(new Background(new BackgroundImage(new Image("car.jpg"), BackgroundRepeat.NO_REPEAT,
					BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize)));

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
			forlogin.getChildren().addAll(shp, log);

			GridPane grid = new GridPane();
			grid.setVgap(20);
			grid.setHgap(30);
			grid.addRow(0, logIn);
			grid.addRow(1, usernameLabel, usernameField);
			grid.addRow(2, passwordLabel, passwordField);
			grid.addRow(3, forlogin);
			grid.setAlignment(Pos.BASELINE_LEFT);
			grid.setTranslateX(40);
			root.setCenter(grid);

			BorderPane rootManeger = new BorderPane();
			BorderPane rootTeach_St = new BorderPane();

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
			forStd.getChildren().addAll(shp2, StdBtn);

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
			forTeach.getChildren().addAll(shp3, teachBtn);

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
			forCar.getChildren().addAll(shp33, carBtn);
			StackPane forReprts = new StackPane();
			Rectangle shp333 = new Rectangle(300, 100);
			shp333.setArcWidth(70);
			shp333.setArcHeight(70);
			shp333.setFill(Color.GREEN);
			shp333.setStroke(Color.RED);
			Button report = new Button("Some Reprts");
			report.setStyle("-fx-background-color : green");
			report.setTextFill(Color.ORANGE);
			report.setFont(myTitleFont);
			report.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				report.setEffect(shadow);
				report.setEffect(shadow);
			});
			report.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				report.setEffect(null);
				report.setEffect(null);
			});
			forReprts.getChildren().addAll(shp333, report);
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
			forBack.getChildren().addAll(shp4, backBtn);
			backBtn.setOnAction(e -> {
				scene.setRoot(root);
				usernameField.clear();
				passwordField.clear();

			});
			forBack.setOnMouseClicked(e -> {
				scene.setRoot(root);
				usernameField.clear();
				passwordField.clear();
			});

			VBox ms = new VBox(20);
			ms.getChildren().addAll(forStd, forTeach, forCar, forReprts, forBack);
			ms.setAlignment(Pos.CENTER);
			rootManeger.setCenter(ms);

			BorderPane studentPage = new BorderPane();
			StdBtn.setOnAction(e -> {
				scene.setRoot(studentPage);
			});
			forStd.setOnMouseClicked(e -> {
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

			returnToMain.setOnAction(e -> {
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

			forAdd.setOnMouseClicked(e -> {
				scene.setRoot(rootAdd);
			});
			gridAdd.setVgap(4);
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
			Label costomerAddress = new Label("Student Address");
			costomerAddress.setFont(myTitleFontt);
			TextField textAddress = new TextField();
			textAddress.setPromptText("Mandatory");
			textAddress.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
			Label costomerWorking = new Label("Student Work");
			costomerWorking.setFont(myTitleFontt);
			TextField textWorking = new TextField();
			textWorking.setPromptText("Mandatory");
			textWorking.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
			Label costomerMobile = new Label("Number Phones");
			costomerMobile.setFont(myTitleFontt);
			TextField textTel = new TextField();
			textTel.setPromptText("Tel (Mandatory):");
			textTel.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
			TextField textMobile = new TextField();
			textMobile.setPromptText("Mob (Not Mandatory):");
			textMobile.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
			Label pass = new Label("Student Password");
			pass.setFont(myTitleFontt);
			TextField textPass = new TextField();
			textPass.setPromptText("Mandatory");
			textPass.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
			Label pDate = new Label("Student Birth");
			pDate.setFont(myTitleFontt);
			TextField textPdate = new TextField();
			textPdate.setPromptText("Mandatory");
			textPdate.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
			Label yourTeacher = new Label("Your Teacher");
			yourTeacher.setFont(myTitleFontt);
			ArrayList<String> kind_Teacher = new ArrayList<String>();

			HBox hbox2 = new HBox();

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
			mm.getChildren().addAll(male, feMale);

			ToggleGroup tgg = new ToggleGroup();
			Label titlePlann = new Label("Type Of Train");
			titlePlann.setFont(myTitleFontt);
			RadioButton aGear = new RadioButton("Automatic Gear");
			aGear.setFont(myTitleFont);
			RadioButton nGear = new RadioButton("Normal Gear");
			nGear.setFont(myTitleFont);
			RadioButton track = new RadioButton("Truck");
			track.setFont(myTitleFont);
			aGear.setToggleGroup(tgg);
			nGear.setToggleGroup(tgg);
			track.setToggleGroup(tgg);
			HBox mmm = new HBox(50);
			mmm.getChildren().addAll(aGear, nGear, track);
			Button addTheCostomer = new Button("Add", to_Add);
			addTheCostomer.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				addTheCostomer.setEffect(shadow);
			});
			addTheCostomer.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				addTheCostomer.setEffect(null);
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

			gridAdd.addRow(0, costomerId, textId);
			gridAdd.addRow(1, costomerName, textName);
			gridAdd.addRow(2, costomerAddress, textAddress);
			gridAdd.addRow(3, pDate, textPdate);
			gridAdd.addRow(4, costomerMobile, textTel, textMobile);
			gridAdd.addRow(5, costomerWorking, textWorking);
			gridAdd.addRow(6, pass, textPass);
			gridAdd.addRow(7, titlePlan, mm);
			gridAdd.addRow(8, titlePlann, mmm);
			gridAdd.addRow(9, yourTeacher, hbox2);
			gridAdd.setAlignment(Pos.CENTER);
			rootAdd.setTop(gridAdd);
			Button list = new Button("List");
			list.setStyle("-fx-background-color : red");
			list.setFont(myTitleFont);
			list.setPrefSize(115, 67);
			list.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				list.setEffect(shadow);
			});
			list.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				list.setEffect(null);
			});
			addCostomer.setOnAction(e -> {
				scene.setRoot(rootAdd);
				list.setDisable(false);
			});
			HBox addAndBack = new HBox(30);
			addAndBack.getChildren().addAll(list, addTheCostomer, backAdd);
			addAndBack.setAlignment(Pos.BOTTOM_RIGHT);
			rootAdd.setRight(addAndBack);
			addAndBack.setTranslateY(-40);
			addAndBack.setTranslateX(-40);
			rootAdd.setStyle("-fx-background-color : orange");
			backAdd.setOnAction(e5 -> {
				list.setDisable(false);
				kind_Teacher.clear();
				rootAdd.setBottom(null);
				male.setSelected(false);
				feMale.setSelected(false);
				nGear.setSelected(false);
				aGear.setSelected(false);
				track.setSelected(false);
				textId.clear();
				textName.clear();
				textAddress.clear();
				textMobile.clear();
				textTel.clear();
				textPass.clear();
				textPdate.clear();

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
				textPass.setPromptText("Mandatory");
				textPass.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
				scene.setRoot(studentPage);
			});
			GridPane gridDelete = new GridPane();
			BorderPane rootDelete = new BorderPane();
			deleteCostomer.setOnAction(e -> {
				scene.setRoot(rootDelete);
			});
			forDelet.setOnMouseClicked(e -> {
				scene.setRoot(rootDelete);
			});
			gridDelete.setVgap(5);
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
			Label pass1 = new Label("Student Password");
			pass1.setFont(myTitleFontt);
			TextField textPass1 = new TextField();
			textPass1.setDisable(true);
			Label pDate1 = new Label("Student Birth");
			pDate1.setFont(myTitleFontt);
			TextField textPdate1 = new TextField();
			textPdate1.setDisable(true);
			Label yourTeacher1 = new Label("Your Teacher");
			yourTeacher1.setFont(myTitleFontt);
			TextField textTeacherName1 = new TextField();
			textTeacherName1.setDisable(true);
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
				rootDelete.setBottom(null);
				textId1.clear();
				textName1.clear();
				textAddress1.clear();
				textMobile1.clear();
				textTel1.clear();
				textPlan1.clear();
				textWork1.clear();
				textTrain1.clear();
				textPdate1.clear();
				textPass1.clear();
				textTeacherName1.clear();
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
			gridDelete.addRow(3, pDate1, textPdate1);
			gridDelete.addRow(4, costomerMobile1, textTel1, textMobile1);
			gridDelete.addRow(5, costomerWorking1, textWork1);
			gridDelete.addRow(6, yourTeacher1, textTeacherName1);
			gridDelete.addRow(7, costomerPlan1, textPlan1);
			gridDelete.addRow(8, tybeTraning1, textTrain1);
			gridDelete.addRow(9, pass1, textPass1);
			gridDelete.setAlignment(Pos.BASELINE_LEFT);
			rootDelete.setLeft(gridDelete);
			HBox DeleteAndBack = new HBox(30);
			DeleteAndBack.getChildren().addAll(find, deletTheCostomer, backDeleted);
			DeleteAndBack.setAlignment(Pos.BOTTOM_RIGHT);
			rootDelete.setRight(DeleteAndBack);
			DeleteAndBack.setTranslateY(-60);
			DeleteAndBack.setTranslateX(-40);
			rootDelete.setStyle("-fx-background-color : orange");

			GridPane gridUpdate = new GridPane();
			BorderPane rootUpdate = new BorderPane();
			updateCostomer.setOnAction(e -> {
				scene.setRoot(rootUpdate);
			});
			forUpdate.setOnMouseClicked(e -> {
				scene.setRoot(rootUpdate);
			});
			gridUpdate.setVgap(30);
			gridUpdate.setHgap(10);
			Label costomerId2 = new Label("Student Id");
			costomerId2.setFont(myTitleFont);
			TextField textId2 = new TextField();
			textId2.setPromptText("Mandatory");
			textId2.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
			Label costomerName2 = new Label("Student Name");
			costomerName2.setFont(myTitleFont);
			TextField textName2 = new TextField();
			textName2.setDisable(true);
			Label costomerAddress2 = new Label("Student Address");
			costomerAddress2.setFont(myTitleFont);
			TextField textAddress2 = new TextField();
			textAddress2.setDisable(true);
			Label costomerMobile2 = new Label("Student Phones");
			costomerMobile2.setFont(myTitleFont);
			TextField textMobile2 = new TextField();
			textMobile2.setDisable(true);
			TextField textTel2 = new TextField();
			textTel2.setDisable(true);
			Label costomerPlan2 = new Label("Student Gender");
			costomerPlan2.setFont(myTitleFont);
			RadioButton maleU = new RadioButton("Male");
			maleU.setFont(myTitleFont);
			RadioButton feMaleU = new RadioButton("Female");
			feMaleU.setFont(myTitleFont);
			maleU.setToggleGroup(tg);
			feMaleU.setToggleGroup(tg);
			HBox textPlan2 = new HBox(50);
			textPlan2.getChildren().addAll(maleU, feMaleU);
			Label costomerWorking2 = new Label("Student Work");
			costomerWorking2.setFont(myTitleFont);
			TextField textWork2 = new TextField();
			textWork2.setDisable(true);
			Label tybeTraning2 = new Label("Student Train");
			tybeTraning2.setFont(myTitleFont);
			RadioButton aGearU = new RadioButton("Automatic Gear");
			aGearU.setFont(myTitleFont);
			RadioButton nGearU = new RadioButton("Normal Gear");
			nGearU.setFont(myTitleFont);
			RadioButton trackU = new RadioButton("Truck");
			trackU.setFont(myTitleFont);
			aGearU.setToggleGroup(tgg);
			nGearU.setToggleGroup(tgg);
			trackU.setToggleGroup(tgg);
			maleU.setDisable(true);
			feMaleU.setDisable(true);
			aGearU.setDisable(true);
			nGearU.setDisable(true);
			trackU.setDisable(true);

			HBox textTrain2 = new HBox(50);
			textTrain2.getChildren().addAll(aGearU, nGearU, trackU);
			Label pass2 = new Label("Student Password");
			pass2.setFont(myTitleFont);
			TextField textPass2 = new TextField();
			textPass2.setDisable(true);
			Label pDate2 = new Label("Student Birth");
			pDate2.setFont(myTitleFont);
			TextField textPdate2 = new TextField();
			textPdate2.setDisable(true);
			Label yourTeacher2 = new Label("Your Teacher");
			yourTeacher2.setFont(myTitleFont);
			// TextField textTeacherName2 = new TextField();
			// textTeacherName2.setDisable(true);
			ArrayList<String> kind_TeacherU = new ArrayList<String>();
			ComboBox<String> combo_boxU = new ComboBox<>(FXCollections.observableArrayList(kind_TeacherU));
			combo_boxU.setMinWidth(50);
			combo_boxU.setMinHeight(50);
			combo_boxU.setPromptText("Selected Teacher");
			combo_boxU.setStyle("-fx-background-color : white; -fx-font-size : 20;");

			/*
			 * Button put = new Button("Put"); put.setOnAction(e->{
			 * textTeacherName2.setText(combo_boxU.getValue()); });
			 * put.setStyle("-fx-background-color : red"); put.setFont(myTitleFont);
			 * put.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			 * put.setEffect(shadow); }); put.addEventHandler(MouseEvent.MOUSE_EXITED,
			 * (MouseEvent e) -> { put.setEffect(null); });
			 */
			HBox hbox2U = new HBox(5);
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
			find1.setOnAction(e -> {
				textId2.setDisable(false);
				textName2.setDisable(false);
				textAddress2.setDisable(false);
				textMobile2.setDisable(false);
				textTel2.setDisable(false);
				textWork2.setDisable(false);
				textPdate2.setDisable(false);
				textPass2.setDisable(false);
				maleU.setDisable(false);
				feMaleU.setDisable(false);
				aGearU.setDisable(false);
				nGearU.setDisable(false);
				trackU.setDisable(false);
			});

			find1.setFont(myTitleFont);

			gridUpdate.addRow(0, costomerId2, textId2);
			gridUpdate.addRow(1, costomerName2, textName2);
			gridUpdate.addRow(2, costomerAddress2, textAddress2);
			gridUpdate.addRow(3, pDate2, textPdate2);
			gridUpdate.addRow(4, costomerMobile2, textTel2, textMobile2);
			gridUpdate.addRow(5, costomerWorking2, textWork2);
			gridUpdate.addRow(6, yourTeacher2, hbox2U);
			gridUpdate.addRow(7, costomerPlan2, textPlan2);
			gridUpdate.addRow(8, tybeTraning2, textTrain2);
			gridUpdate.addRow(9, pass2, textPass2);
			gridUpdate.setPrefWidth(1300);
			Button listu = new Button("List");
			listu.setStyle("-fx-background-color : red");
			listu.setFont(myTitleFont);
			listu.setPrefSize(115, 67);
			listu.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				listu.setEffect(shadow);
			});
			listu.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				listu.setEffect(null);
			});
			backUpdate.setOnAction(e -> {
				hbox2U.getChildren().remove(combo_boxU);
				updateTheCostomer.setDisable(true);
				list.setDisable(true);
				rootUpdate.setBottom(null);
				listu.setDisable(true);
				textId2.clear();
				textName2.clear();
				textAddress2.clear();
				textMobile2.clear();
				textTel2.clear();
				textWork2.clear();
				textPdate2.clear();
				textPass2.clear();
				combo_boxU.setDisable(true);
				textName2.setDisable(true);
				textAddress2.setDisable(true);
				textMobile2.setDisable(true);
				textTel2.setDisable(true);
				textWork2.setDisable(true);
				textPdate2.setDisable(true);
				textPass2.setDisable(true);
				maleU.setSelected(false);
				feMaleU.setSelected(false);
				nGearU.setSelected(false);
				aGearU.setSelected(false);
				trackU.setSelected(false);
				maleU.setDisable(true);
				feMaleU.setDisable(true);
				aGearU.setDisable(true);
				nGearU.setDisable(true);
				trackU.setDisable(true);
				textId2.setPromptText("Mandatory");
				textId2.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
				scene.setRoot(studentPage);
			});
			gridUpdate.setAlignment(Pos.BASELINE_LEFT);
			rootUpdate.setLeft(gridUpdate);
			HBox UpdateAndBack = new HBox(30);
			UpdateAndBack.getChildren().addAll(listu, find1, updateTheCostomer, backUpdate);
			UpdateAndBack.setAlignment(Pos.BOTTOM_RIGHT);
			rootUpdate.setRight(UpdateAndBack);
			UpdateAndBack.setTranslateY(-10);
			UpdateAndBack.setTranslateX(-460);
			rootUpdate.setStyle("-fx-background-color : orange");

			GridPane gridSearch = new GridPane();
			BorderPane rootSearch = new BorderPane();
			searchCostomer.setOnAction(e -> {
				scene.setRoot(rootSearch);
			});
			forSearch.setOnMouseClicked(e -> {
				scene.setRoot(rootSearch);
			});
			gridSearch.setVgap(5);
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
			Label pass3 = new Label("Student Password");
			pass3.setFont(myTitleFontt);
			TextField textPass3 = new TextField();
			textPass3.setDisable(true);
			Label pDate3 = new Label("Student Birth");
			pDate3.setFont(myTitleFontt);
			TextField textPdate3 = new TextField();
			textPdate3.setDisable(true);
			Label yourTeacher3 = new Label("Your Teacher");
			yourTeacher3.setFont(myTitleFontt);
			TextField textTeacherName3 = new TextField();
			textTeacherName3.setDisable(true);
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
				textTeacherName3.clear();
				textPdate3.clear();
				textPass3.clear();
				textId3.setPromptText("Mandatory");
				textId3.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
				scene.setRoot(studentPage);
			});
			gridSearch.addRow(0, costomerId3, textId3);
			gridSearch.addRow(1, costomerName3, textName3);
			gridSearch.addRow(2, costomerAddress3, textAddress3);
			gridSearch.addRow(3, pDate3, textPdate3);
			gridSearch.addRow(4, costomerMobile3, textTel3, textMobile3);
			gridSearch.addRow(5, costomerWorking3, textWork3);
			gridSearch.addRow(6, yourTeacher3, textTeacherName3);
			gridSearch.addRow(7, costomerPlan3, textPlan3);
			gridSearch.addRow(8, tybeTraning3, textTrain3);
			gridSearch.addRow(9, pass3, textPass3);

			gridSearch.setAlignment(Pos.BASELINE_LEFT);
			rootSearch.setLeft(gridSearch);
			HBox SearchAndBack = new HBox(30);
			SearchAndBack.getChildren().addAll(searchTheCostomer, backSearch);
			SearchAndBack.setAlignment(Pos.BOTTOM_RIGHT);
			rootSearch.setRight(SearchAndBack);
			SearchAndBack.setTranslateY(-20);
			SearchAndBack.setTranslateX(-40);
			rootSearch.setStyle("-fx-background-color : orange");

			BorderPane teacherPage = new BorderPane();
			teachBtn.setOnAction(e -> {
				scene.setRoot(teacherPage);
			});
			forTeach.setOnMouseClicked(e -> {
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

			returnToMainT.setOnAction(e -> {
				scene.setRoot(rootManeger);
			});
			forBack1T.setOnMouseClicked(e -> {
				scene.setRoot(rootManeger);
			});
			forBack1.setOnMouseClicked(e -> {
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
			Label costomerAddressT = new Label("Teacher Address");
			costomerAddressT.setFont(myTitleFontt);
			TextField textAddressT = new TextField();
			textAddressT.setPromptText("Mandatory");
			textAddressT.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
			Label costomerBirthT = new Label("Teacher Birth");
			costomerBirthT.setFont(myTitleFontt);
			TextField textBirth = new TextField();
			textBirth.setPromptText("Mandatory");
			textBirth.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
			Label costomerLessonsT = new Label("Number Leasson");
			costomerLessonsT.setFont(myTitleFontt);
			TextField textLess = new TextField();
			textLess.setPromptText("Mandatory");
			textLess.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
			Label costomerTelT = new Label("Number Phone");
			costomerTelT.setFont(myTitleFontt);
			TextField textTelT = new TextField();
			textTelT.setPromptText("Mandatory");
			textTelT.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
			Label teacherPass = new Label("Teacher Password");
			teacherPass.setFont(myTitleFontt);
			TextField textTeacherPass = new TextField();
			textTeacherPass.setPromptText("Mandatory");
			textTeacherPass.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
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
			mmT.getChildren().addAll(maleT, feMaleT);

			Label titlePlannT = new Label("Type Of Tach");
			titlePlannT.setFont(myTitleFontt);
			CheckBox aGearT = new CheckBox("Automatic Gear");
			aGearT.setFont(myTitleFont);
			CheckBox nGearT = new CheckBox("Normal Gear");
			nGearT.setFont(myTitleFont);
			CheckBox trackT = new CheckBox("Truck");
			trackT.setFont(myTitleFont);
			HBox mmmT = new HBox(50);
			mmmT.getChildren().addAll(aGearT, nGearT, trackT);
			Button addTheCostomerT = new Button("Add", to_AddT);
			addTheCostomerT.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				addTheCostomerT.setEffect(shadow);
			});
			addTheCostomerT.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				addTheCostomerT.setEffect(null);
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
				rootAddT.setBottom(null);
				maleT.setSelected(false);
				feMaleT.setSelected(false);
				nGearT.setSelected(false);
				aGearT.setSelected(false);
				trackT.setSelected(false);
				textIdT.clear();
				textNameT.clear();
				textAddressT.clear();
				textTeacherPass.clear();
				textTelT.clear();
				textTelT.setPromptText("Mandatory");
				textTelT.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
				textTeacherPass.setPromptText("Mandatory");
				textTeacherPass.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
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
			gridAddT.addRow(2, costomerTelT, textTelT);
			gridAddT.addRow(3, costomerAddressT, textAddressT);
			gridAddT.addRow(4, costomerBirthT, textBirth);
			gridAddT.addRow(5, costomerLessonsT, textLess);
			gridAddT.addRow(6, teacherPass, textTeacherPass);
			gridAddT.addRow(7, titlePlanT, mmT);
			gridAddT.addRow(8, titlePlannT, mmmT);

			gridAddT.setAlignment(Pos.BASELINE_LEFT);
			rootAddT.setTop(gridAddT);
			HBox addAndBackTeacher = new HBox(30);
			addAndBackTeacher.getChildren().addAll(addTheCostomerT, backAddT);
			addAndBackTeacher.setAlignment(Pos.BOTTOM_RIGHT);
			rootAddT.setRight(addAndBackTeacher);
			addAndBackTeacher.setTranslateY(-15);
			addAndBackTeacher.setTranslateX(-60);
			rootAddT.setStyle("-fx-background-color : orange");

			GridPane gridDeleteT = new GridPane();
			BorderPane rootDeleteT = new BorderPane();
			deleteCostomerT.setOnAction(e -> {
				scene.setRoot(rootDeleteT);
			});
			gridDeleteT.setVgap(15);
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
			Label costomerTel1T = new Label("Teacher Phone");
			costomerTel1T.setFont(myTitleFontt);
			TextField textTel1T = new TextField();
			textTel1T.setDisable(true);
			Label teacherPass1 = new Label("Teacher Password");
			teacherPass1.setFont(myTitleFontt);
			TextField textTeacherPass1 = new TextField();
			textTeacherPass1.setDisable(true);
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
			Button deletTheCostomerT = new Button("Delete", to_DeleteT);
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
				rootDeleteT.setBottom(null);
				textId1T.clear();
				textName1T.clear();
				textAddress1T.clear();
				textTel1T.clear();
				textTeacherPass1.clear();
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
			gridDeleteT.addRow(2, costomerTel1T, textTel1T);
			gridDeleteT.addRow(3, costomerAddress1T, textAddress1T);
			gridDeleteT.addRow(4, costomerPlan1T, textPlan1T);
			gridDeleteT.addRow(5, costomerBirthT1, textBirth1);
			gridDeleteT.addRow(6, costomerLessonsT1, textLess1);
			gridDeleteT.addRow(7, tybeTraning1T, textTrain1T);
			gridDeleteT.addRow(8, teacherPass1, textTeacherPass1);

			gridDeleteT.setAlignment(Pos.BASELINE_LEFT);
			rootDeleteT.setTop(gridDeleteT);
			HBox deleteAndBackTeacher = new HBox(30);
			deleteAndBackTeacher.getChildren().addAll(findT, deletTheCostomerT, backDeletedT);
			deleteAndBackTeacher.setAlignment(Pos.BOTTOM_RIGHT);
			rootDeleteT.setRight(deleteAndBackTeacher);
			deleteAndBackTeacher.setTranslateY(-60);
			deleteAndBackTeacher.setTranslateX(-60);
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
			Label costomerTel2T = new Label("Teacher Phone");
			costomerTel2T.setFont(myTitleFontt);
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
			RadioButton maleTU = new RadioButton("Male");
			maleTU.setFont(myTitleFont);
			RadioButton feMaleTU = new RadioButton("Female");
			feMaleTU.setFont(myTitleFont);
			maleTU.setToggleGroup(tgT);
			feMaleTU.setToggleGroup(tgT);
			HBox textPlan2T = new HBox(50);
			textPlan2T.getChildren().addAll(maleTU, feMaleTU);
			Label tybeTraning2T = new Label("Teacher Teach");
			tybeTraning2T.setFont(myTitleFontt);
			CheckBox aGearTU = new CheckBox("Automatic Gear");
			aGearTU.setFont(myTitleFont);
			CheckBox nGearTU = new CheckBox("Normal Gear");
			nGearTU.setFont(myTitleFont);
			CheckBox trackTU = new CheckBox("Truck");
			trackTU.setFont(myTitleFont);
			HBox textTrain2T = new HBox(50);
			maleTU.setDisable(true);
			maleTU.setDisable(true);
			feMaleTU.setDisable(true);
			nGearTU.setDisable(true);
			aGearTU.setDisable(true);
			trackTU.setDisable(true);
			textTrain2T.getChildren().addAll(aGearTU, nGearTU, trackTU);
			Label teacherPass2 = new Label("Teacher Password");
			teacherPass2.setFont(myTitleFontt);
			TextField textTeacherPass2 = new TextField();
			textTeacherPass2.setDisable(true);
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
				rootUpdateT.setBottom(null);
				textName2T.setDisable(true);
				textAddress2T.setDisable(true);
				textTeacherPass2.setDisable(true);
				textTel2T.setDisable(true);
				textBirth2.setDisable(true);
				textLess2.setDisable(true);
				textId2T.clear();
				textName2T.clear();
				textAddress2T.clear();
				textTeacherPass2.clear();
				textTel2T.clear();
				trackTU.setSelected(false);
				nGearTU.setSelected(false);
				aGearTU.setSelected(false);
				textBirth2.clear();
				textLess2.clear();
				maleTU.setSelected(false);
				feMaleTU.setSelected(false);
				maleTU.setDisable(true);
				maleTU.setDisable(true);
				feMaleTU.setDisable(true);
				nGearTU.setDisable(true);
				aGearTU.setDisable(true);
				trackTU.setDisable(true);
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
			find1T.setOnAction(e -> {
				textId2T.setDisable(false);
				textName2T.setDisable(false);
				textAddress2T.setDisable(false);
				textTeacherPass2.setDisable(false);
				textTel2T.setDisable(false);
				textBirth2.setDisable(false);
				textLess2.setDisable(false);
				maleTU.setDisable(false);
				maleTU.setDisable(false);
				feMaleTU.setDisable(false);
				nGearTU.setDisable(false);
				aGearTU.setDisable(false);
				trackTU.setDisable(false);
			});

			find1T.setFont(myTitleFont);
			gridUpdateT.addRow(0, costomerId2T, textId2T);
			gridUpdateT.addRow(1, costomerName2T, textName2T);
			gridUpdateT.addRow(2, costomerTel2T, textTel2T);
			gridUpdateT.addRow(3, costomerAddress2T, textAddress2T);
			gridUpdateT.addRow(4, costomerPlan2T, textPlan2T);
			gridUpdateT.addRow(5, costomerBirthT2, textBirth2);
			gridUpdateT.addRow(6, costomerLessonsT2, textLess2);
			gridUpdateT.addRow(7, tybeTraning2T, textTrain2T);
			gridUpdateT.addRow(8, teacherPass2, textTeacherPass2);

			gridUpdateT.setAlignment(Pos.BASELINE_LEFT);
			rootUpdateT.setTop(gridUpdateT);
			HBox updateAndBackTeacher = new HBox(30);
			updateAndBackTeacher.getChildren().addAll(find1T, updateTheCostomerT, backUpdateT);
			updateAndBackTeacher.setAlignment(Pos.BOTTOM_RIGHT);
			rootUpdateT.setRight(updateAndBackTeacher);
			updateAndBackTeacher.setTranslateY(-10);
			updateAndBackTeacher.setTranslateX(-60);
			rootUpdateT.setStyle("-fx-background-color : orange");

			GridPane gridSearchT = new GridPane();
			BorderPane rootSearchT = new BorderPane();
			searchCostomerT.setOnAction(e -> {
				scene.setRoot(rootSearchT);
			});
			gridSearchT.setVgap(15);
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
			Label costomerTel3T = new Label("Teacher Phone");
			costomerTel3T.setFont(myTitleFontt);
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
			Label teacherPass3 = new Label("Teacher Password");
			teacherPass3.setFont(myTitleFontt);
			TextField textTeacherPass3 = new TextField();
			textTeacherPass3.setDisable(true);
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
				rootSearchT.setBottom(null);
				textId3T.clear();
				textName3T.clear();
				textAddress3T.clear();
				textTeacherPass3.clear();
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
			gridSearchT.addRow(2, costomerTel3T, textTel3T);
			gridSearchT.addRow(3, costomerAddress3T, textAddress3T);
			gridSearchT.addRow(4, costomerPlan3T, textPlan3T);
			gridSearchT.addRow(5, costomerBirthT3, textBirth3);
			gridSearchT.addRow(6, costomerLessonsT3, textLess3);
			gridSearchT.addRow(7, tybeTraning3T, textTrain3T);
			gridSearchT.addRow(8, teacherPass3, textTeacherPass3);

			gridSearchT.setAlignment(Pos.BASELINE_LEFT);
			rootSearchT.setTop(gridSearchT);
			HBox searchAndBackTeacher = new HBox(30);
			searchAndBackTeacher.getChildren().addAll(searchTheCostomerT, backSearchT);
			searchAndBackTeacher.setAlignment(Pos.BOTTOM_RIGHT);
			rootSearchT.setRight(searchAndBackTeacher);
			searchAndBackTeacher.setTranslateY(-60);
			searchAndBackTeacher.setTranslateX(-60);
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
			carBtn.setOnAction(e -> {
				scene.setRoot(carPage);
			});
			forCar.setOnMouseClicked(e -> {
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

			returnToMainC.setOnAction(e -> {
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
			forAddC.setOnMouseClicked(e -> {
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
			Label yearofpurchasing = new Label("Year Purchasing");
			yearofpurchasing.setFont(myTitleFontt);
			TextField yearofpurchasingText = new TextField();
			yearofpurchasingText.setPromptText("Mandatory");
			yearofpurchasingText.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
			Label licenseAndInsurance = new Label("License And Insurance");
			licenseAndInsurance.setFont(myTitleFontt);
			ToggleGroup tgglicense = new ToggleGroup();
			RadioButton truelicense = new RadioButton("TRUE");
			truelicense.setFont(myTitleFont);
			RadioButton falselicense = new RadioButton("False");
			falselicense.setFont(myTitleFont);
			truelicense.setToggleGroup(tgglicense);
			falselicense.setToggleGroup(tgglicense);
			HBox licenseAndInsuranceText = new HBox(50);
			licenseAndInsuranceText.getChildren().addAll(falselicense, truelicense);
			Label readyTrain = new Label("readyTrain");
			readyTrain.setFont(myTitleFontt);
			ToggleGroup tggReady = new ToggleGroup();
			RadioButton trueReady = new RadioButton("TRUE");
			trueReady.setFont(myTitleFont);
			RadioButton falseReady = new RadioButton("False");
			falseReady.setFont(myTitleFont);
			trueReady.setToggleGroup(tggReady);
			falseReady.setToggleGroup(tggReady);
			HBox readyTrainText = new HBox(50);
			readyTrainText.getChildren().addAll(falseReady, trueReady);
			Label modelC = new Label("Vehicle Model");
			modelC.setFont(myTitleFontt);
			TextField modelCText = new TextField();
			modelCText.setPromptText("Mandatory");
			modelCText.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
			ImageView to_AddC = new ImageView("https://img.icons8.com/fluency/344/add.png");
			to_AddC.setFitHeight(50);
			to_AddC.setFitWidth(50);

			ToggleGroup tggC = new ToggleGroup();
			Label tybeTrain = new Label("Type Of Train");
			tybeTrain.setFont(myTitleFontt);
			RadioButton aGearC = new RadioButton("Automatic Gear");
			aGearC.setFont(myTitleFont);
			RadioButton nGearC = new RadioButton("Normal Gear");
			nGearC.setFont(myTitleFont);
			RadioButton trackC = new RadioButton("Truck");
			trackC.setFont(myTitleFont);
			aGearC.setToggleGroup(tggC);
			nGearC.setToggleGroup(tggC);
			trackC.setToggleGroup(tggC);
			HBox mmmC = new HBox(50);
			mmmC.getChildren().addAll(nGearC, aGearC, trackC);
			Button addTheCostomerC = new Button("Add", to_AddC);
			addTheCostomerC.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				addTheCostomerC.setEffect(shadow);
			});
			addTheCostomerC.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				addTheCostomerC.setEffect(null);
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
				rootAddC.setBottom(null);
				nGearC.setSelected(false);
				aGearC.setSelected(false);
				trackC.setSelected(false);
				textIdC.clear();
				textNameC.clear();
				truelicense.setSelected(false);
				falselicense.setSelected(false);
				trueReady.setSelected(false);
				falseReady.setSelected(false);
				yearofpurchasingText.clear();
				modelCText.clear();
				textIdC.setPromptText("Mandatory");
				textIdC.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
				textNameC.setPromptText("Mandatory");
				textNameC.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
				yearofpurchasingText.setPromptText("Mandatory");
				yearofpurchasingText.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
				modelCText.setPromptText("Mandatory");
				modelCText.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
				scene.setRoot(carPage);
			});
			gridAddC.addRow(0, IdCar, textIdC);
			gridAddC.addRow(1, NameC, textNameC);
			gridAddC.addRow(2, yearofpurchasing, yearofpurchasingText);
			gridAddC.addRow(3, licenseAndInsurance, licenseAndInsuranceText);
			gridAddC.addRow(4, readyTrain, readyTrainText);
			gridAddC.addRow(5, modelC, modelCText);
			gridAddC.addRow(6, tybeTrain, mmmC);
			gridAddC.addRow(7, addTheCostomerC, backAddC);
			gridAddC.setAlignment(Pos.CENTER);
			rootAddC.setCenter(gridAddC);
			rootAddC.setStyle("-fx-background-color : orange");

			GridPane gridDeleteC = new GridPane();
			BorderPane rootDeleteC = new BorderPane();
			deleteCostomerC.setOnAction(e -> {
				scene.setRoot(rootDeleteC);
			});
			forDeletC.setOnMouseClicked(e -> {
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
			Label modelC1 = new Label("Vehicle Model");
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
			Button deletTheCostomerC = new Button("Delete", to_DeleteC);
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
				deletTheCostomerC.setDisable(true);
				rootDeleteC.setBottom(null);
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
			gridDeleteC.addRow(0, IdCar1, textIdC1);
			gridDeleteC.addRow(1, NameC1, textNameC1);
			gridDeleteC.addRow(2, yearofpurchasing1, yearofpurchasingText1);
			gridDeleteC.addRow(3, licenseAndInsurance1, licenseAndInsuranceText1);
			gridDeleteC.addRow(4, readyTrain1, readyTrainText1);
			gridDeleteC.addRow(5, modelC1, modelCText1);
			gridDeleteC.addRow(6, typeUsed, TypeUsedText);
			gridDeleteC.addRow(7, findC, deletTheCostomerC, backDeletedC);
			gridDeleteC.setAlignment(Pos.CENTER);
			rootDeleteC.setCenter(gridDeleteC);
			rootDeleteC.setStyle("-fx-background-color : orange");

			GridPane gridUpdateC = new GridPane();
			BorderPane rootUpdateC = new BorderPane();
			updateCostomerC.setOnAction(e -> {
				scene.setRoot(rootUpdateC);
			});
			forUpdateC.setOnMouseClicked(e -> {
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
			ToggleGroup tgglicense1 = new ToggleGroup();
			RadioButton truelicense1 = new RadioButton("TRUE");
			truelicense1.setFont(myTitleFont);
			truelicense1.setDisable(true);
			RadioButton falselicense1 = new RadioButton("False");
			falselicense1.setFont(myTitleFont);
			falselicense1.setDisable(true);
			truelicense1.setToggleGroup(tgglicense1);
			falselicense1.setToggleGroup(tgglicense1);
			HBox licenseAndInsuranceText2 = new HBox(50);
			licenseAndInsuranceText2.getChildren().addAll(falselicense1, truelicense1);
			Label readyTrain2 = new Label("readyTrain");
			readyTrain2.setFont(myTitleFontt);
			ToggleGroup tggReady1 = new ToggleGroup();
			RadioButton trueReady1 = new RadioButton("TRUE");
			trueReady1.setFont(myTitleFont);
			trueReady1.setDisable(true);
			RadioButton falseReady1 = new RadioButton("False");
			falseReady1.setFont(myTitleFont);
			falseReady1.setDisable(true);
			trueReady1.setToggleGroup(tggReady1);
			falseReady1.setToggleGroup(tggReady1);
			HBox readyTrainText2 = new HBox(50);
			readyTrainText2.getChildren().addAll(falseReady1, trueReady1);
			Label modelC2 = new Label("Vehicle Model");
			modelC2.setFont(myTitleFontt);
			TextField modelCText2 = new TextField();
			modelCText2.setDisable(true);
			Label typeUsed2 = new Label("Type Train");
			typeUsed2.setFont(myTitleFontt);
			ToggleGroup tggUpdate = new ToggleGroup();
			RadioButton aGearUpdate = new RadioButton("Automatic Gear");
			aGearUpdate.setFont(myTitleFont);
			RadioButton nGearUpdate = new RadioButton("Normal Gear");
			nGearUpdate.setFont(myTitleFont);
			RadioButton trackUpdate = new RadioButton("Truck");
			trackUpdate.setFont(myTitleFont);
			aGearUpdate.setToggleGroup(tggC);
			nGearUpdate.setToggleGroup(tggC);
			trackUpdate.setToggleGroup(tggC);
			HBox TypeUsedText2 = new HBox(50);
			TypeUsedText2.getChildren().addAll(aGearUpdate, nGearUpdate, trackUpdate);
			aGearUpdate.setDisable(true);
			trackUpdate.setDisable(true);
			nGearUpdate.setDisable(true);
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
				rootUpdateC.setBottom(null);
				aGearUpdate.setDisable(true);
				trackUpdate.setDisable(true);
				nGearUpdate.setDisable(true);
				truelicense1.setDisable(true);
				falselicense1.setDisable(true);
				trueReady1.setDisable(true);
				falseReady1.setDisable(true);
				aGearUpdate.setSelected(false);
				trackUpdate.setSelected(false);
				nGearUpdate.setSelected(false);
				truelicense1.setSelected(false);
				falselicense1.setSelected(false);
				trueReady1.setSelected(false);
				falseReady1.setSelected(false);
				textNameC2.setDisable(true);
				readyTrainText2.setDisable(true);
				modelCText2.setDisable(true);
				yearofpurchasingText2.setDisable(true);
				textIdC2.clear();
				textNameC2.clear();
				yearofpurchasingText2.clear();
				modelCText2.clear();
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
			find1C.setOnAction(e -> {
				aGearUpdate.setDisable(false);
				trackUpdate.setDisable(false);
				nGearUpdate.setDisable(false);
				truelicense1.setDisable(false);
				falselicense1.setDisable(false);
				trueReady1.setDisable(false);
				falseReady1.setDisable(false);
				textNameC2.setDisable(false);
				readyTrainText2.setDisable(false);
				modelCText2.setDisable(false);
				yearofpurchasingText2.setDisable(false);
			});
			HBox vv = new HBox(10);
			vv.getChildren().addAll(find1C, updateTheCostomerC, backUpdateC);
			find1C.setFont(myTitleFont);
			gridUpdateC.addRow(0, IdCar2, textIdC2);
			gridUpdateC.addRow(1, NameC2, textNameC2);
			gridUpdateC.addRow(2, yearofpurchasing2, yearofpurchasingText2);
			gridUpdateC.addRow(3, licenseAndInsurance2, licenseAndInsuranceText2);
			gridUpdateC.addRow(4, readyTrain2, readyTrainText2);
			gridUpdateC.addRow(5, modelC2, modelCText2);
			gridUpdateC.addRow(6, typeUsed2, TypeUsedText2);
			gridUpdateC.addRow(8, vv);
			gridUpdateC.setAlignment(Pos.CENTER);
			rootUpdateC.setCenter(gridUpdateC);
			rootUpdateC.setStyle("-fx-background-color : orange");
			GridPane gridSearchC = new GridPane();
			BorderPane rootSearchC = new BorderPane();
			searchCostomerC.setOnAction(e -> {
				scene.setRoot(rootSearchC);
			});
			forSearchC.setOnMouseClicked(e -> {
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
			Label modelC3 = new Label("Vehicle Model");
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
				rootSearchC.setBottom(null);
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
			gridSearchC.addRow(0, IdCar3, textIdC3);
			gridSearchC.addRow(1, NameC3, textNameC3);
			gridSearchC.addRow(2, yearofpurchasing3, yearofpurchasingText3);
			gridSearchC.addRow(3, licenseAndInsurance3, licenseAndInsuranceText3);
			gridSearchC.addRow(4, readyTrain3, readyTrainText3);
			gridSearchC.addRow(5, modelC3, modelCText3);
			gridSearchC.addRow(6, typeUsed3, TypeUsedText3);
			gridSearchC.addRow(7, searchTheCostomerC, backSearchC);
			gridSearchC.setAlignment(Pos.CENTER);
			rootSearchC.setCenter(gridSearchC);
			rootSearchC.setStyle("-fx-background-color : orange");

			BorderPane reprtsPage = new BorderPane();
			report.setOnAction(e -> {
				scene.setRoot(reprtsPage);
			});
			forReprts.setOnMouseClicked(e -> {
				scene.setRoot(reprtsPage);
			});

			reprtsPage.setStyle("-fx-background-color : aqua");

			StackPane forQ1 = new StackPane();
			Rectangle shp91 = new Rectangle(550, 100);
			shp91.setArcWidth(70);
			shp91.setArcHeight(70);
			shp91.setFill(Color.GREEN);
			shp91.setStroke(Color.RED);
			Button q1 = new Button(
					"students name who rode in \"Hyundai\" and they are learning \"Automatic\" type and their ages are 20 or more");
			q1.setStyle("-fx-background-color : green");
			q1.setTextFill(Color.ORANGE);
			q1.setFont(myTitleF);
			q1.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				q1.setEffect(shadow);
				shp91.setEffect(shadow);
			});
			q1.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				q1.setEffect(null);
				shp91.setEffect(null);
			});
			forQ1.getChildren().addAll(shp91, q1);

			StackPane forQ2 = new StackPane();
			Rectangle shp92 = new Rectangle(550, 100);
			shp92.setArcWidth(70);
			shp92.setArcHeight(70);
			shp92.setFill(Color.GREEN);
			shp92.setStroke(Color.RED);
			Button q2 = new Button("The most popularity type of teaching between the students");
			q2.setStyle("-fx-background-color : green");
			q2.setTextFill(Color.ORANGE);
			q2.setFont(myTitleF);
			q2.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				q2.setEffect(shadow);
				shp92.setEffect(shadow);
			});
			q2.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				q2.setEffect(null);
				shp92.setEffect(null);
			});
			forQ2.getChildren().addAll(shp92, q2);

			StackPane forQ3 = new StackPane();
			Rectangle shp93 = new Rectangle(550, 100);
			shp93.setArcWidth(70);
			shp93.setArcHeight(70);
			shp93.setFill(Color.GREEN);
			shp93.setStroke(Color.RED);
			Button q3 = new Button("Getting all the students with their teachers and appointments");
			q3.setStyle("-fx-background-color : green");
			q3.setTextFill(Color.ORANGE);
			q3.setFont(myTitleF);
			q3.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				q3.setEffect(shadow);
				shp93.setEffect(shadow);
			});
			q3.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				q3.setEffect(null);
				shp93.setEffect(null);
			});
			forQ3.getChildren().addAll(shp93, q3);

			StackPane forQ4 = new StackPane();
			Rectangle shp94 = new Rectangle(550, 100);
			shp94.setArcWidth(70);
			shp94.setArcHeight(70);
			shp94.setFill(Color.GREEN);
			shp94.setStroke(Color.RED);
			Button q4 = new Button(
					"Print the male students and female students who starts their names with specific letter");
			q4.setStyle("-fx-background-color : green");
			q4.setTextFill(Color.ORANGE);
			q4.setFont(myTitleF);
			q4.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				q4.setEffect(shadow);
				shp94.setEffect(shadow);
			});
			q4.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				q4.setEffect(null);
				shp94.setEffect(null);
			});
			forQ4.getChildren().addAll(shp94, q4);

			StackPane forQ5 = new StackPane();
			Rectangle shp95 = new Rectangle(550, 100);
			shp95.setArcWidth(70);
			shp95.setArcHeight(70);
			shp95.setFill(Color.GREEN);
			shp95.setStroke(Color.RED);
			Button q5 = new Button("The teacher who teached maximimum number of students and his age larger than 40");
			q5.setStyle("-fx-background-color : green");
			q5.setTextFill(Color.ORANGE);
			q5.setFont(myTitleF);
			q5.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				q5.setEffect(shadow);
				shp95.setEffect(shadow);
			});
			q5.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				q5.setEffect(null);
				shp95.setEffect(null);
			});
			forQ5.getChildren().addAll(shp95, q5);

			StackPane forQ6 = new StackPane();
			Rectangle shp96 = new Rectangle(550, 100);
			shp96.setArcWidth(70);
			shp96.setArcHeight(70);
			shp96.setFill(Color.GREEN);
			shp96.setStroke(Color.RED);
			Button q6 = new Button("Print teachers info who teached all the (type of teaching)");
			q6.setStyle("-fx-background-color : green");
			q6.setTextFill(Color.ORANGE);
			q6.setFont(myTitleF);
			q6.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				q6.setEffect(shadow);
				shp96.setEffect(shadow);
			});
			q6.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				q6.setEffect(null);
				shp96.setEffect(null);
			});
			forQ6.getChildren().addAll(shp96, q6);

			StackPane forQBack = new StackPane();
			Rectangle shp97 = new Rectangle(550, 100);
			shp97.setArcWidth(70);
			shp97.setArcHeight(70);
			shp97.setFill(Color.GREEN);
			shp97.setStroke(Color.RED);
			Button q7 = new Button("Back");
			q7.setStyle("-fx-background-color : green");
			q7.setTextFill(Color.ORANGE);
			q7.setFont(myTitleF);
			q7.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				q7.setEffect(shadow);
				shp97.setEffect(shadow);
			});
			q7.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				q7.setEffect(null);
				shp97.setEffect(null);
			});
			forQBack.getChildren().addAll(shp97, q7);

			VBox vboxR = new VBox(5);
			vboxR.getChildren().addAll(forQ1, forQ2, forQ3, forQ4, forQ5, forQ6, forQBack);
			vboxR.setAlignment(Pos.TOP_LEFT);
			reprtsPage.setLeft(vboxR);
			TextArea toPrintReport = new TextArea();
			toPrintReport.setPrefWidth(600);
			toPrintReport.setPrefHeight(200);
			toPrintReport.setTranslateX(-20);
			reprtsPage.setRight(toPrintReport);
			q7.setOnAction(e -> {
				scene.setRoot(rootManeger);
				toPrintReport.clear();
			});
			forQBack.setOnMouseClicked(e -> {
				scene.setRoot(rootManeger);
				toPrintReport.clear();
			});
			VBox teacherProf = new VBox(5);
			ImageView imageProf = new ImageView(new Image("data.jpg"));
			imageProf.setFitHeight(200);
			imageProf.setFitWidth(220);
			Label nameProfaile = new Label("KHADER");
			nameProfaile.setFont(myTitleFont);
			nameProfaile.setTranslateX(55);
			teacherProf.getChildren().addAll(imageProf, nameProfaile);
			nameProfaile.setTextFill(Color.BLACK);
			nameProfaile.setUnderline(true);

			Label idTeacher = new Label("ID");
			idTeacher.setFont(myTitleFon);
			Label forIdTeacher = new Label("1");
			forIdTeacher.setFont(myTitleFon);
			Label nameTeacher = new Label("NAME");
			nameTeacher.setFont(myTitleFon);
			Label forNameTeacher = new Label("khader");
			forNameTeacher.setFont(myTitleFon);
			Label phoneTeacher = new Label("   PHONE");
			phoneTeacher.setFont(myTitleFon);
			Label forPhoneTeacher = new Label("0569635507");
			forPhoneTeacher.setFont(myTitleFon);
			Label addressTeacher = new Label("ADDRESS");
			addressTeacher.setFont(myTitleFon);
			Label forAddressTeacher = new Label("alram");
			forAddressTeacher.setFont(myTitleFon);
			Label genderTeacher = new Label("GENDER");
			genderTeacher.setFont(myTitleFon);
			Label forGenderTeacher = new Label("male");
			forGenderTeacher.setFont(myTitleFon);
			Label birthTeacher = new Label("BIRTH");
			birthTeacher.setFont(myTitleFon);
			Label forBirthTeacher = new Label("2002-5-6");
			forBirthTeacher.setFont(myTitleFon);
			Label lessonTeacher = new Label("NUMBER LESSONS");
			lessonTeacher.setFont(myTitleFon);
			Label forLessonTeacher = new Label("     5");
			forLessonTeacher.setFont(myTitleFon);
			Label passTeacher = new Label("PASSWORD");
			passTeacher.setFont(myTitleFon);
			Label forPassTeacher = new Label("T-khader1");
			forPassTeacher.setFont(myTitleFon);
			Label ownerTeacher = new Label("MANAGER");
			ownerTeacher.setFont(myTitleFon);
			Label forOwnerTeacher = new Label("    ali");
			forOwnerTeacher.setFont(myTitleFon);

			forIdTeacher.setStyle("-fx-background-color : red");
			forNameTeacher.setStyle("-fx-background-color : red");
			forPhoneTeacher.setStyle("-fx-background-color : red");
			forAddressTeacher.setStyle("-fx-background-color : red");
			forGenderTeacher.setStyle("-fx-background-color : red");
			forBirthTeacher.setStyle("-fx-background-color : red");
			forLessonTeacher.setStyle("-fx-background-color : red");
			forPassTeacher.setStyle("-fx-background-color : red");
			forOwnerTeacher.setStyle("-fx-background-color : red");

			GridPane forLabels = new GridPane();
			forLabels.setVgap(15);
			forLabels.setHgap(50);
			forLabels.setTranslateY(20);
			forLabels.addRow(0, idTeacher, nameTeacher, phoneTeacher, addressTeacher, genderTeacher, birthTeacher,
					lessonTeacher, passTeacher, ownerTeacher);
			forLabels.addRow(2, forIdTeacher, forNameTeacher, forPhoneTeacher, forAddressTeacher, forGenderTeacher,
					forBirthTeacher, forLessonTeacher, forPassTeacher, forOwnerTeacher);
			HBox GriddAndProf = new HBox(20);
			GriddAndProf.getChildren().addAll(teacherProf, forLabels);
			GriddAndProf.setAlignment(Pos.TOP_LEFT);
			rootForTeacher.setTop(GriddAndProf);

			Button regS = new Button("enrolled students");
			regS.setStyle(
					"-fx-font-size: 20pt; -fx-text-fill: red; -fx-background-color: transparent; -fx-border: none; -fx-focus-color: transparent;");
			regS.setOnMouseEntered(
					event -> regS.setStyle("-fx-background-color: lightgray;-fx-font-size: 20pt; -fx-text-fill: red;"));
			regS.setOnMouseExited(event -> regS
					.setStyle("-fx-background-color: transparent;-fx-font-size: 20pt; -fx-text-fill: red;"));
			Button choseCar = new Button("Vehicle Selection");
			choseCar.setStyle(
					"-fx-font-size: 20pt; -fx-text-fill: red; -fx-background-color: transparent; -fx-border: none; -fx-focus-color: transparent;");
			choseCar.setOnMouseEntered(event -> choseCar
					.setStyle("-fx-background-color: lightgray;-fx-font-size: 20pt; -fx-text-fill: red;"));
			choseCar.setOnMouseExited(event -> choseCar
					.setStyle("-fx-background-color: transparent;-fx-font-size: 20pt; -fx-text-fill: red;"));
			Button logoutTeacher = new Button("Logout");
			logoutTeacher.setStyle(
					"-fx-font-size: 20pt; -fx-text-fill: red; -fx-background-color: transparent; -fx-border: none; -fx-focus-color: transparent;");
			logoutTeacher.setOnMouseEntered(event -> logoutTeacher
					.setStyle("-fx-background-color: lightgray;-fx-font-size: 20pt; -fx-text-fill: red;"));
			logoutTeacher.setOnMouseExited(event -> logoutTeacher
					.setStyle("-fx-background-color: transparent;-fx-font-size: 20pt; -fx-text-fill: red;"));
			VBox forButton = new VBox(40);
			forButton.setTranslateY(-40);
			forButton.getChildren().addAll(regS, choseCar, logoutTeacher);
			forButton.setAlignment(Pos.CENTER_LEFT);
			rootForTeacher.setLeft(forButton);

			Button sat = new Button("Saturday");
			sat.setStyle(
					"-fx-font-size: 20pt; -fx-text-fill: red; -fx-background-color: transparent; -fx-border: none; -fx-focus-color: transparent;");
			sat.setOnMouseEntered(
					event -> sat.setStyle("-fx-background-color: lightgray;-fx-font-size: 20pt; -fx-text-fill: red;"));
			sat.setOnMouseExited(event -> sat
					.setStyle("-fx-background-color: transparent;-fx-font-size: 20pt; -fx-text-fill: red;"));

			Button sun = new Button("Sunday");
			sun.setStyle(
					"-fx-font-size: 20pt; -fx-text-fill: red; -fx-background-color: transparent; -fx-border: none; -fx-focus-color: transparent;");
			sun.setOnMouseEntered(
					event -> sun.setStyle("-fx-background-color: lightgray;-fx-font-size: 20pt; -fx-text-fill: red;"));
			sun.setOnMouseExited(event -> sun
					.setStyle("-fx-background-color: transparent;-fx-font-size: 20pt; -fx-text-fill: red;"));

			Button mon = new Button("Monday");
			mon.setStyle(
					"-fx-font-size: 20pt; -fx-text-fill: red; -fx-background-color: transparent; -fx-border: none; -fx-focus-color: transparent;");
			mon.setOnMouseEntered(
					event -> mon.setStyle("-fx-background-color: lightgray;-fx-font-size: 20pt; -fx-text-fill: red;"));
			mon.setOnMouseExited(event -> mon
					.setStyle("-fx-background-color: transparent;-fx-font-size: 20pt; -fx-text-fill: red;"));

			Button tues = new Button("Tuesday");
			tues.setStyle(
					"-fx-font-size: 20pt; -fx-text-fill: red; -fx-background-color: transparent; -fx-border: none; -fx-focus-color: transparent;");
			tues.setOnMouseEntered(
					event -> tues.setStyle("-fx-background-color: lightgray;-fx-font-size: 20pt; -fx-text-fill: red;"));
			tues.setOnMouseExited(event -> tues
					.setStyle("-fx-background-color: transparent;-fx-font-size: 20pt; -fx-text-fill: red;"));

			Button wed = new Button("Wednesday");
			wed.setStyle(
					"-fx-font-size: 20pt; -fx-text-fill: red; -fx-background-color: transparent; -fx-border: none; -fx-focus-color: transparent;");
			wed.setOnMouseEntered(
					event -> wed.setStyle("-fx-background-color: lightgray;-fx-font-size: 20pt; -fx-text-fill: red;"));
			wed.setOnMouseExited(event -> wed
					.setStyle("-fx-background-color: transparent;-fx-font-size: 20pt; -fx-text-fill: red;"));

			Button thurs = new Button("Thursday");
			thurs.setStyle(
					"-fx-font-size: 20pt; -fx-text-fill: red; -fx-background-color: transparent; -fx-border: none; -fx-focus-color: transparent;");
			thurs.setOnMouseEntered(event -> thurs
					.setStyle("-fx-background-color: lightgray;-fx-font-size: 20pt; -fx-text-fill: red;"));
			thurs.setOnMouseExited(event -> thurs
					.setStyle("-fx-background-color: transparent;-fx-font-size: 20pt; -fx-text-fill: red;"));

			HBox days = new HBox(20);
			days.getChildren().addAll(sat, sun, mon, wed, tues, thurs);
			days.setTranslateY(-80);
			days.setTranslateX(30);
			HBox kindCar = new HBox(30);
			kindCar.setAlignment(Pos.CENTER);
			kindCar.setTranslateY(-100);
			TextArea basheer = new TextArea();
			logoutTeacher.setOnAction(e -> {
				kindCar.getChildren().removeAll(combo_boxTruck, combo_boxnGear, combo_boxaGear);
				scene.setRoot(root);
				rootForTeacher.setCenter(null);
				rootForTeacher.setBottom(null);
				basheer.clear();
			});
			basheer.setTranslateX(-20);
			VBox momen = new VBox(40);
			momen.getChildren().addAll(days, basheer);
			momen.setTranslateY(-70);
			momen.setTranslateX(30);
			momen.setAlignment(Pos.CENTER);

			regS.setOnAction(e -> {
				kindCar.getChildren().removeAll(combo_boxTruck, combo_boxnGear, combo_boxaGear);
				rootForTeacher.setBottom(null);
				rootForTeacher.setCenter(momen);
			});

			Button submit = new Button("Submit");
			submit.setStyle(
					"-fx-font-size: 20pt; -fx-text-fill: red; -fx-background-color: transparent; -fx-border: none; -fx-focus-color: transparent;");
			submit.setOnMouseEntered(event -> submit
					.setStyle("-fx-background-color: lightgray;-fx-font-size: 20pt; -fx-text-fill: red;"));
			submit.setOnMouseExited(event -> submit
					.setStyle("-fx-background-color: transparent;-fx-font-size: 20pt; -fx-text-fill: red;"));

			VBox vbox12 = new VBox(20);
			vbox12.setAlignment(Pos.CENTER);
			vbox12.getChildren().addAll(kindCar, submit);

			VBox studentProf = new VBox(5);
			ImageView imageProfStudent = new ImageView(new Image("data.jpg"));
			imageProfStudent.setFitHeight(200);
			imageProfStudent.setFitWidth(220);
			Label nameProfaileStudent = new Label("KHADER");
			nameProfaileStudent.setFont(myTitleFont);
			nameProfaileStudent.setTranslateX(55);
			studentProf.getChildren().addAll(imageProfStudent, nameProfaileStudent);
			nameProfaileStudent.setTextFill(Color.BLACK);
			nameProfaileStudent.setUnderline(true);

			Font myTitleFo = Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 13);
			Label idStu = new Label("ID");
			idStu.setFont(myTitleFo);
			Label forIdStu = new Label("1");
			forIdStu.setFont(myTitleFo);
			Label nameStu = new Label("NAME");
			nameStu.setFont(myTitleFo);
			Label forNameStu = new Label("khader");
			forNameStu.setFont(myTitleFo);
			Label addressStu = new Label("ADDRESS");
			addressStu.setFont(myTitleFo);
			Label forAddressStu = new Label("alram");
			forAddressStu.setFont(myTitleFo);
			Label workStu = new Label("WORK");
			workStu.setFont(myTitleFo);
			Label forWorkStu = new Label("Student");
			forWorkStu.setFont(myTitleFo);
			Label phoneStu = new Label("   PHONE");
			phoneStu.setFont(myTitleFo);
			Label forPhoneStu = new Label("0569635507");
			forPhoneStu.setFont(myTitleFo);
			Label telStu = new Label("  TELEPHON");
			telStu.setFont(myTitleFo);
			Label forTelStu = new Label("0569635507");
			forTelStu.setFont(myTitleFo);
			Label genderStu = new Label("GENDER");
			genderStu.setFont(myTitleFo);
			Label forGenderStu = new Label("male");
			forGenderStu.setFont(myTitleFo);
			Label birthStu = new Label("BIRTH");
			birthStu.setFont(myTitleFo);
			Label forBirthStu = new Label("2002-5-6");
			forBirthStu.setFont(myTitleFo);
			Label TeacherStu = new Label("TEACHER");
			TeacherStu.setFont(myTitleFo);
			Label forTeacherStu = new Label("Mohammad");
			forTeacherStu.setFont(myTitleFo);
			Label trainStu = new Label("KIND TRAINING");
			trainStu.setFont(myTitleFo);
			Label forTrainStu = new Label("Truck");
			forTrainStu.setFont(myTitleFo);
			Label passStu = new Label("PASSWORD");
			passStu.setFont(myTitleFo);
			Label forPassStu = new Label("T-khader1");
			forPassStu.setFont(myTitleFo);
			Label ownerStu = new Label("MANAGER");
			ownerStu.setFont(myTitleFo);
			Label forOwnerStu = new Label("    ali");
			forOwnerStu.setFont(myTitleFo);

			forIdStu.setStyle("-fx-background-color : red");
			forNameStu.setStyle("-fx-background-color : red");
			forPhoneStu.setStyle("-fx-background-color : red");
			forTelStu.setStyle("-fx-background-color : red");
			forAddressStu.setStyle("-fx-background-color : red");
			forGenderStu.setStyle("-fx-background-color : red");
			forBirthStu.setStyle("-fx-background-color : red");
			forWorkStu.setStyle("-fx-background-color : red");
			forPassStu.setStyle("-fx-background-color : red");
			forOwnerStu.setStyle("-fx-background-color : red");
			forTrainStu.setStyle("-fx-background-color : red");
			forTeacherStu.setStyle("-fx-background-color : red");
			GridPane forLabelsStu = new GridPane();
			forLabelsStu.setVgap(15);
			forLabelsStu.setHgap(30);
			forLabelsStu.setTranslateY(20);
			forLabelsStu.addRow(0, idStu, nameStu, addressStu, phoneStu, telStu, genderStu, birthStu, workStu,
					TeacherStu, trainStu, passStu, ownerStu);
			forLabelsStu.addRow(2, forIdStu, forNameStu, forAddressStu, forPhoneStu, forTelStu, forGenderStu,
					forBirthStu, forWorkStu, forTeacherStu, forTrainStu, forPassStu, forOwnerStu);
			HBox GriddAndProfStu = new HBox(20);
			GriddAndProfStu.getChildren().addAll(studentProf, forLabelsStu);
			GriddAndProfStu.setAlignment(Pos.TOP_LEFT);
			rootForStudent.setTop(GriddAndProfStu);

			Button reserve = new Button("Reserve Day");
			reserve.setStyle(
					"-fx-font-size: 20pt; -fx-text-fill: red; -fx-background-color: transparent; -fx-border: none; -fx-focus-color: transparent;");
			reserve.setOnMouseEntered(event -> reserve
					.setStyle("-fx-background-color: lightgray;-fx-font-size: 20pt; -fx-text-fill: red;"));
			reserve.setOnMouseExited(event -> reserve
					.setStyle("-fx-background-color: transparent;-fx-font-size: 20pt; -fx-text-fill: red;"));

			Button cancelReserve = new Button("Cancel Reserve");
			cancelReserve.setStyle(
					"-fx-font-size: 20pt; -fx-text-fill: red; -fx-background-color: transparent; -fx-border: none; -fx-focus-color: transparent;");
			cancelReserve.setOnMouseEntered(event -> cancelReserve
					.setStyle("-fx-background-color: lightgray;-fx-font-size: 20pt; -fx-text-fill: red;"));
			cancelReserve.setOnMouseExited(event -> cancelReserve
					.setStyle("-fx-background-color: transparent;-fx-font-size: 20pt; -fx-text-fill: red;"));

			Button vedio = new Button("Vedio For Good Advice");
			vedio.setStyle(
					"-fx-font-size: 20pt; -fx-text-fill: red; -fx-background-color: transparent; -fx-border: none; -fx-focus-color: transparent;");
			vedio.setOnMouseEntered(event -> vedio
					.setStyle("-fx-background-color: lightgray;-fx-font-size: 20pt; -fx-text-fill: red;"));
			vedio.setOnMouseExited(event -> vedio
					.setStyle("-fx-background-color: transparent;-fx-font-size: 20pt; -fx-text-fill: red;"));
			Button logoutStu = new Button("Logout");
			logoutStu.setStyle(
					"-fx-font-size: 20pt; -fx-text-fill: red; -fx-background-color: transparent; -fx-border: none; -fx-focus-color: transparent;");
			logoutStu.setOnMouseEntered(event -> logoutStu
					.setStyle("-fx-background-color: lightgray;-fx-font-size: 20pt; -fx-text-fill: red;"));
			logoutStu.setOnMouseExited(event -> logoutStu
					.setStyle("-fx-background-color: transparent;-fx-font-size: 20pt; -fx-text-fill: red;"));
			VBox forButtonStu = new VBox(40);
			forButtonStu.setTranslateY(-40);
			forButtonStu.getChildren().addAll(reserve, cancelReserve, vedio, logoutStu);
			forButtonStu.setAlignment(Pos.CENTER_LEFT);
			rootForStudent.setLeft(forButtonStu);

			CheckBox day1 = new CheckBox("Saturday");
			CheckBox day2 = new CheckBox("Sunday");
			CheckBox day3 = new CheckBox("Monday");
			CheckBox day4 = new CheckBox("Tuesday");
			CheckBox day5 = new CheckBox("Wednesday");
			CheckBox day6 = new CheckBox("Thursday");
			day1.setFont(myTitleFont);
			day2.setFont(myTitleFont);
			day3.setFont(myTitleFont);
			day4.setFont(myTitleFont);
			day5.setFont(myTitleFont);
			day6.setFont(myTitleFont);

			HBox forDays = new HBox(20);
			forDays.getChildren().addAll(day1, day2, day3, day4, day5, day6);
			forDays.setTranslateX(30);
			forDays.setTranslateY(-100);

			Button submitStu = new Button("Submit");
			submitStu.setStyle(
					"-fx-font-size: 20pt; -fx-text-fill: red; -fx-background-color: transparent; -fx-border: none; -fx-focus-color: transparent;");
			submitStu.setOnMouseEntered(event -> submitStu
					.setStyle("-fx-background-color: lightgray;-fx-font-size: 20pt; -fx-text-fill: red;"));
			submitStu.setOnMouseExited(event -> submitStu
					.setStyle("-fx-background-color: transparent;-fx-font-size: 20pt; -fx-text-fill: red;"));

			VBox vboxStu = new VBox(35);
			vboxStu.setAlignment(Pos.CENTER);
			vboxStu.getChildren().addAll(forDays, submitStu);
			Label labelCancel = new Label("HI, YOU ARE RESERVE FOR THIS WEEK IN");
			labelCancel.setFont(myTitleFont);
			labelCancel.setTranslateY(-100);
			Label labelCancel1 = new Label("IF YOU WANT CANCEL THESE DAYS CLICK ON SUBMIT.");
			labelCancel1.setFont(myTitleFont);
			labelCancel1.setTranslateY(-100);
			Button submitCancel = new Button("Submit");
			submitCancel.setStyle(
					"-fx-font-size: 20pt; -fx-text-fill: red; -fx-background-color: transparent; -fx-border: none; -fx-focus-color: transparent;");
			submitCancel.setOnMouseEntered(event -> submitCancel
					.setStyle("-fx-background-color: lightgray;-fx-font-size: 20pt; -fx-text-fill: red;"));
			submitCancel.setOnMouseExited(event -> submitCancel
					.setStyle("-fx-background-color: transparent;-fx-font-size: 20pt; -fx-text-fill: red;"));
			Label labelSubmit = new Label("IF YOU WANT RESERVE NEW DAYS,GO TO RESERVE PAGE.");
			labelSubmit.setFont(myTitleFont);

			VBox forCancel = new VBox(20);
			forCancel.setAlignment(Pos.CENTER);
			forCancel.getChildren().addAll(labelCancel, labelCancel1, submitCancel, labelSubmit);

			reserve.setOnAction(e -> {
				rootForStudent.setCenter(vboxStu);
				rootForStudent.setBottom(null);

			});
			cancelReserve.setOnAction(e -> {
				rootForStudent.setCenter(forCancel);
				rootForStudent.setBorder(null);
			});
			logoutStu.setOnAction(e -> {
				scene.setRoot(root);
				day1.setSelected(false);
				day2.setSelected(false);
				day3.setSelected(false);
				day4.setSelected(false);
				day5.setSelected(false);
				day6.setSelected(false);
				rootForStudent.setCenter(null);
				rootForStudent.setBottom(null);
			});

			submitStu.setOnAction(e -> {
				try {
					Connect();
					Statement stmt = con.createStatement();
					if (day1.isSelected()) {

						int s_id = Integer.parseInt(forIdStu.getText().trim());
						int t_number = Integer.parseInt(forTeacherStu.getText().trim());
						stmt.executeUpdate("insert into reserve\r\n" + "values(" + t_number + "," + s_id + ",1);");

					}
					if (day2.isSelected()) {

						int s_id = Integer.parseInt(forIdStu.getText().trim());
						int t_number = Integer.parseInt(forTeacherStu.getText().trim());

						stmt.executeUpdate("insert into reserve\r\n" + "values(" + t_number + "," + s_id + ",2);");

					}
					if (day3.isSelected()) {

						int s_id = Integer.parseInt(forIdStu.getText().trim());
						int t_number = Integer.parseInt(forTeacherStu.getText().trim());

						stmt.executeUpdate("insert into reserve\r\n" + "values(" + t_number + "," + s_id + ",3);");

					}
					if (day4.isSelected()) {

						int s_id = Integer.parseInt(forIdStu.getText().trim());
						int t_number = Integer.parseInt(forTeacherStu.getText().trim());

						stmt.executeUpdate("insert into reserve\r\n" + "values(" + t_number + "," + s_id + ",4);");

					}
					if (day5.isSelected()) {

						int s_id = Integer.parseInt(forIdStu.getText().trim());
						int t_number = Integer.parseInt(forTeacherStu.getText().trim());

						stmt.executeUpdate("insert into reserve\r\n" + "values(" + t_number + "," + s_id + ",5);");

					}
					if (day6.isSelected()) {

						int s_id = Integer.parseInt(forIdStu.getText().trim());
						int t_number = Integer.parseInt(forTeacherStu.getText().trim());

						stmt.executeUpdate("insert into reserve\r\n" + "values(" + t_number + "," + s_id + ",6);");

					}
				} catch (SQLException e2) {
					Label invalid = new Label(e2.getMessage());
					invalid.setFont(Font.font(10));
					invalid.setStyle("-fx-background-color : red");
					invalid.setFont(myTitleFontt);
					invalid.setTranslateX(200);
					invalid.setTranslateY(-40);
					rootForStudent.setBottom(invalid);
				}
			});
			submitCancel.setOnAction(e -> {
				try {
					int s_id = Integer.parseInt(forIdStu.getText().trim());
					int t_number = Integer.parseInt(forTeacherStu.getText().trim());
					Connect();
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("select *\r\n" + "from reserve\r\n" + "where t_number = "
							+ t_number + " and s_id = " + s_id + "\r\n" + "order by d;");
					int d1 = 0, d2 = 0, d3 = 0, d4 = 0, d5 = 0, d6 = 0;
					while (rs.next()) {
						if (rs.getInt(3) == 1)
							d1 = 1;
						if (rs.getInt(3) == 2)
							d2 = 1;
						if (rs.getInt(3) == 3)
							d3 = 1;
						if (rs.getInt(3) == 4)
							d4 = 1;
						if (rs.getInt(3) == 5)
							d5 = 1;
						if (rs.getInt(3) == 6)
							d6 = 1;
					}
					if (d1 == 1)
						stmt.executeUpdate("DELETE from reserve\r\n" + "WHERE t_number = " + t_number + " and s_id = "
								+ s_id + " and d = " + 1 + ";");
					if (d2 == 1)
						stmt.executeUpdate("DELETE from reserve\r\n" + "WHERE t_number = " + t_number + " and s_id = "
								+ s_id + " and d = " + 2 + ";");
					if (d3 == 1)
						stmt.executeUpdate("DELETE from reserve\r\n" + "WHERE t_number = " + t_number + " and s_id = "
								+ s_id + " and d = " + 3 + ";");
					if (d4 == 1)
						stmt.executeUpdate("DELETE from reserve\r\n" + "WHERE t_number = " + t_number + " and s_id = "
								+ s_id + " and d = " + 4 + ";");
					if (d5 == 1)
						stmt.executeUpdate("DELETE from reserve\r\n" + "WHERE t_number = " + t_number + " and s_id = "
								+ s_id + " and d = " + 5 + ";");
					if (d6 == 1)
						stmt.executeUpdate("DELETE from reserve\r\n" + "WHERE t_number = " + t_number + " and s_id = "
								+ s_id + " and d = " + 6 + ";");
					Label labelDelete = new Label("The Lessons are Deleted");
					labelDelete.setFont(myTitleFontt);
					labelDelete.setStyle("-fx-background-color : red");
					labelDelete.setTranslateX(400);
					labelDelete.setTranslateY(-40);
					rootForStudent.setBottom(labelDelete);

				} catch (SQLException e2) {
					Label invalid = new Label(e2.getMessage());
					invalid.setFont(Font.font(10));
					invalid.setStyle("-fx-background-color : red");
					invalid.setFont(myTitleFontt);
					invalid.setTranslateX(200);
					invalid.setTranslateY(-40);
					rootForStudent.setBottom(invalid);
				}
			});
			sat.setOnAction(e -> {
				try {
					Connect();
					Statement stmt = con.createStatement();
					int id = Integer.parseInt(forIdTeacher.getText());
					ResultSet rs = stmt.executeQuery("select * from reserve where t_number = " + id + " and d = 1;");
					if (rs.next()) {
						ResultSet rs1 = stmt.executeQuery("select S.s_id, S.s_name, S.s_phonenumber, S.s_typeofwork\r\n"
								+ "from student S, teacher T, reserve R\r\n" + "where S.t_number = T.t_number\r\n"
								+ "AND R.t_number = T.t_number And R.s_id = S.s_id And T.t_number = " + id
								+ " AND R.d = 1;");
						ArrayList<String> text = new ArrayList<String>();
						text.add("student id\tname\tphone\twork\n");
						while (rs1.next()) {
							text.add(rs1.getString(1) + "\t" + rs1.getString(2) + "\t" + rs1.getString(3) + "\t"
									+ rs1.getString(4) + "\n");
						}
						basheer.setText(text.toString());
					} else
						basheer.setText("Oh, You dont have lessons today");

				} catch (Exception ex) {
					// System.out.println(ex.getMessage());
					ex.printStackTrace();
				}

			});
			sun.setOnAction(e -> {
				try {
					Connect();
					Statement stmt = con.createStatement();
					int id = Integer.parseInt(forIdTeacher.getText());
					ResultSet rs = stmt.executeQuery("select * from reserve where t_number = " + id + " and d = 2;");
					if (rs.next()) {
						ResultSet rs1 = stmt.executeQuery("select S.s_id, S.s_name, S.s_phonenumber, S.s_typeofwork\r\n"
								+ "from student S, teacher T, reserve R\r\n" + "where S.t_number = T.t_number\r\n"
								+ "AND R.t_number = T.t_number And R.s_id = S.s_id And T.t_number = " + id
								+ " AND R.d = 2;");
						ArrayList<String> text = new ArrayList<String>();
						text.add("student id\tname\tphone\twork\n");
						while (rs1.next()) {
							text.add(rs1.getString(1) + "\t" + rs1.getString(2) + "\t" + rs1.getString(3) + "\t"
									+ rs1.getString(4) + "\n");
						}
						basheer.setText(text.toString());
					} else
						basheer.setText("Oh, You dont have lessons today");
				} catch (Exception ex) {
					// System.out.println(ex.getMessage());
					ex.printStackTrace();
				}

			});
			mon.setOnAction(e -> {
				try {
					Connect();
					Statement stmt = con.createStatement();
					int id = Integer.parseInt(forIdTeacher.getText());
					ResultSet rs = stmt.executeQuery("select * from reserve where t_number = " + id + " and d = 3;");
					if (rs.next()) {
						ResultSet rs1 = stmt.executeQuery("select S.s_id, S.s_name, S.s_phonenumber, S.s_typeofwork\r\n"
								+ "from student S, teacher T, reserve R\r\n" + "where S.t_number = T.t_number\r\n"
								+ "AND R.t_number = T.t_number And R.s_id = S.s_id And T.t_number = " + id
								+ " AND R.d = 3;");
						ArrayList<String> text = new ArrayList<String>();
						text.add("student id\tname\tphone\twork\n");
						while (rs1.next()) {
							text.add(rs1.getString(1) + "\t" + rs1.getString(2) + "\t" + rs1.getString(3) + "\t"
									+ rs1.getString(4) + "\n");
						}
						basheer.setText(text.toString());
					} else
						basheer.setText("Oh, You dont have lessons today");
				} catch (Exception ex) {
					// System.out.println(ex.getMessage());
					ex.printStackTrace();
				}

			});
			wed.setOnAction(e -> {
				try {
					Connect();
					Statement stmt = con.createStatement();
					int id = Integer.parseInt(forIdTeacher.getText());
					ResultSet rs = stmt.executeQuery("select * from reserve where t_number = " + id + " and d = 4;");
					if (rs.next()) {
						ResultSet rs1 = stmt.executeQuery("select S.s_id, S.s_name, S.s_phonenumber, S.s_typeofwork\r\n"
								+ "from student S, teacher T, reserve R\r\n" + "where S.t_number = T.t_number\r\n"
								+ "AND R.t_number = T.t_number And R.s_id = S.s_id And T.t_number = " + id
								+ " AND R.d = 4;");
						ArrayList<String> text = new ArrayList<String>();
						text.add("student id\tname\tphone\twork\n");
						while (rs1.next()) {
							text.add(rs1.getString(1) + "\t" + rs1.getString(2) + "\t" + rs1.getString(3) + "\t"
									+ rs1.getString(4) + "\n");
						}
						basheer.setText(text.toString());
					} else
						basheer.setText("Oh, You dont have lessons today");
				} catch (Exception ex) {
					// System.out.println(ex.getMessage());
					ex.printStackTrace();
				}

			});
			tues.setOnAction(e -> {
				try {
					Connect();
					Statement stmt = con.createStatement();
					int id = Integer.parseInt(forIdTeacher.getText());
					ResultSet rs = stmt.executeQuery("select * from reserve where t_number = " + id + " and d = 5;");
					if (rs.next()) {
						ResultSet rs1 = stmt.executeQuery("select S.s_id, S.s_name, S.s_phonenumber, S.s_typeofwork\r\n"
								+ "from student S, teacher T, reserve R\r\n" + "where S.t_number = T.t_number\r\n"
								+ "AND R.t_number = T.t_number And R.s_id = S.s_id And T.t_number = " + id
								+ " AND R.d = 5;");
						ArrayList<String> text = new ArrayList<String>();
						text.add("student id\tname\tphone\twork\n");
						while (rs1.next()) {
							text.add(rs1.getString(1) + "\t" + rs1.getString(2) + "\t" + rs1.getString(3) + "\t"
									+ rs1.getString(4) + "\n");
						}
						basheer.setText(text.toString());
					} else
						basheer.setText("Oh, You dont have lessons today");
				} catch (Exception ex) {
					// System.out.println(ex.getMessage());
					ex.printStackTrace();
				}

			});
			thurs.setOnAction(e -> {
				try {
					Connect();
					Statement stmt = con.createStatement();
					int id = Integer.parseInt(forIdTeacher.getText());
					ResultSet rs = stmt.executeQuery("select * from reserve where t_number = " + id + " and d = 6;");
					if (rs.next()) {
						ResultSet rs1 = stmt.executeQuery("select S.s_id, S.s_name, S.s_phonenumber, S.s_typeofwork\r\n"
								+ "from student S, teacher T, reserve R\r\n" + "where S.t_number = T.t_number\r\n"
								+ "AND R.t_number = T.t_number And R.s_id = S.s_id And T.t_number = " + id
								+ " AND R.d = 6;");
						ArrayList<String> text = new ArrayList<String>();
						text.add("student id\tname\tphone\twork\n");
						while (rs1.next()) {
							text.add(rs1.getString(1) + "\t" + rs1.getString(2) + "\t" + rs1.getString(3) + "\t"
									+ rs1.getString(4) + "\n");
						}
						basheer.setText(text.toString());
					} else
						basheer.setText("Oh, You dont have lessons today");
				} catch (Exception ex) {
					// System.out.println(ex.getMessage());
					ex.printStackTrace();
				}

			});
			choseCar.setOnAction(e -> {
				try {
					rootForTeacher.setCenter(vbox12);
					Connect();
					Statement stmt = con.createStatement();
					int id = Integer.parseInt(forIdTeacher.getText());
					ResultSet rs = stmt
							.executeQuery("select * from teacher_typeOfTeaching\r\n" + "where t_number = " + id + ";");
					int[] ar = new int[3];
					while (rs.next()) {
						if (rs.getInt(2) == 1)
							ar[0] = 1;
						if (rs.getInt(2) == 2)
							ar[1] = 1;
						if (rs.getInt(2) == 3)
							ar[2] = 1;
					}
					if (ar[0] == 1) {
						ArrayList<String> kind_aGear = new ArrayList<String>();
						ResultSet rs1 = stmt.executeQuery("select * from vehicle\r\n" + "where type_number = 1;");
						while (rs1.next()) {
							kind_aGear.add(rs1.getString(1) + "/" + rs1.getString(2));
						}
						combo_boxaGear = new ComboBox<>(FXCollections.observableArrayList(kind_aGear));
						combo_boxaGear.setMinWidth(50);
						combo_boxaGear.setMinHeight(50);
						combo_boxaGear.setPromptText("Selected For Automatic Gear");
						combo_boxaGear.setStyle("-fx-background-color : white; -fx-font-size : 20;");
						kindCar.getChildren().addAll(combo_boxaGear);

					}
					if (ar[1] == 1) {
						ArrayList<String> kind_nGear = new ArrayList<String>();
						ResultSet rs1 = stmt.executeQuery("select * from vehicle\r\n" + "where type_number = 2;");
						while (rs1.next()) {
							kind_nGear.add(rs1.getString(1) + "/" + rs1.getString(2));
						}
						combo_boxnGear = new ComboBox<>(FXCollections.observableArrayList(kind_nGear));
						combo_boxnGear.setMinWidth(50);
						combo_boxnGear.setMinHeight(50);
						combo_boxnGear.setPromptText("Selected For Normal Gear");
						combo_boxnGear.setStyle("-fx-background-color : white; -fx-font-size : 20;");
						kindCar.getChildren().addAll(combo_boxnGear);
					}
					if (ar[2] == 1) {
						ArrayList<String> kind_Truck = new ArrayList<String>();
						ResultSet rs1 = stmt.executeQuery("select * from vehicle\r\n" + "where type_number = 3;");
						while (rs1.next()) {
							kind_Truck.add(rs1.getString(1) + "/" + rs1.getString(2));
						}
						combo_boxTruck = new ComboBox<>(FXCollections.observableArrayList(kind_Truck));
						combo_boxTruck.setMinWidth(50);
						combo_boxTruck.setMinHeight(50);
						combo_boxTruck.setPromptText("Selected For Truck");
						combo_boxTruck.setStyle("-fx-background-color : white; -fx-font-size : 20;");
						kindCar.getChildren().addAll(combo_boxTruck);

					}
					submit.setOnAction(e1 -> {
						try {
							int c_num;
							if (ar[0] == 1 && (combo_boxaGear.getValue() != null)) {
								c_num = Integer.parseInt(combo_boxaGear.getValue().split("/")[0]);
								stmt.executeUpdate(
										"INSERT INTO vehicle_to_teacher\r\n" + "VALUES (" + c_num + ", " + id + ");");
								Label valid = new Label("Done, You can start training on car # " + c_num);
								valid.setFont(Font.font(10));
								valid.setStyle("-fx-background-color : red");
								valid.setFont(myTitleFontt);
								valid.setTranslateX(200);
								valid.setTranslateY(-40);
								rootForTeacher.setBottom(valid);

							}
							if (ar[1] == 1 && (combo_boxnGear.getValue() != null)) {
								c_num = Integer.parseInt(combo_boxnGear.getValue().split("/")[0]);
								stmt.executeUpdate(
										"INSERT INTO vehicle_to_teacher\r\n" + "VALUES (" + c_num + ", " + id + ");");
								Label valid = new Label("Done, You can start training on car # " + c_num);
								valid.setFont(Font.font(10));
								valid.setStyle("-fx-background-color : red");
								valid.setFont(myTitleFontt);
								valid.setTranslateX(200);
								valid.setTranslateY(-40);
								rootForTeacher.setBottom(valid);

							}
							if (ar[2] == 1 && (combo_boxTruck.getValue() != null)) {
								c_num = Integer.parseInt(combo_boxTruck.getValue().split("/")[0]);
								stmt.executeUpdate(
										"INSERT INTO vehicle_to_teacher\r\n" + "VALUES (" + c_num + ", " + id + ");");
								Label valid = new Label("Done, You can start training on car # " + c_num);
								valid.setFont(Font.font(10));
								valid.setStyle("-fx-background-color : red");
								valid.setFont(myTitleFontt);
								valid.setTranslateX(200);
								valid.setTranslateY(-40);
								rootForTeacher.setBottom(valid);

							}
						}

						catch (SQLException e2) {
							Label invalid = new Label(e2.getMessage());
							invalid.setFont(Font.font(10));
							invalid.setStyle("-fx-background-color : red");
							invalid.setFont(myTitleFontt);
							invalid.setTranslateX(200);
							invalid.setTranslateY(-40);
							rootForTeacher.setBottom(invalid);
						}
					});
					logoutTeacher.setOnAction(e1 -> {
						kindCar.getChildren().removeAll(combo_boxTruck, combo_boxnGear, combo_boxaGear);
						scene.setRoot(root);
						rootForTeacher.setCenter(null);
						basheer.clear();
					});

				} catch (Exception ex) {
					// System.out.println(ex.getMessage());
					ex.printStackTrace();
				}
			});

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setMaximized(true);
			Stage stage = (Stage) root.getScene().getWindow();
			stage.setFullScreen(true);

			searchTheCostomer.setOnAction(e -> {
				try {
					Connect();
					Statement stmt = con.createStatement();
					int id = Integer.parseInt(textId3.getText());
					ResultSet rs = stmt.executeQuery("SELECT *\r\n" + "FROM student\r\n" + "where s_id = " + id + ";");
					if (rs.next()) {
						textName3.setText(rs.getString(2));
						textAddress3.setText(rs.getString(3));
						textWork3.setText(rs.getString(4));
						textTel3.setText(Integer.toString(rs.getInt(5)));
						textMobile3.setText(Integer.toString(rs.getInt(7)));
						textPdate3.setText(rs.getString(8));
						textPass3.setText(rs.getString(9));
						char gender = rs.getString(6).charAt(0);
						if (gender == 'M')
							textPlan3.setText("Male");
						else
							textPlan3.setText("Female");
						textWork3.setText(rs.getString(4));

						if (rs.getInt(11) == 1)
							textTrain3.setText("Automatic Gear");
						else if (rs.getInt(11) == 2)
							textTrain3.setText("Normal Gear");
						else if (rs.getInt(11) == 3)
							textTrain3.setText("Truck");
						else
							textTrain3.setText("Null");

						ResultSet rs1 = stmt.executeQuery("SELECT T.t_name\r\n" + "FROM teacher T\r\n"
								+ "where T.t_number In(select S.t_number\r\n" + "from student S \r\n"
								+ "where S.t_number = " + Integer.parseInt(rs.getString(10)) + ");");
						if (rs1.next())
							textTeacherName3.setText(rs1.getString(1));
						Label labelSearch = new Label("The Student Is Found");
						labelSearch.setFont(myTitleFontt);
						labelSearch.setStyle("-fx-background-color : red");
						labelSearch.setTranslateX(400);
						rootSearch.setBottom(labelSearch);
					} else {
						textName3.setText("Null");
						textAddress3.setText("Null");
						textTel3.setText("Null");
						textMobile3.setText("Null");
						textPlan3.setText("Null");
						textWork3.setText("Null");
						textTrain3.setText("Null");
						textPdate3.setText("NuLL");
						textPass3.setText("NuLL");
						textTeacherName3.setText("NuLL");
						Label labelSearch = new Label("The Student Is Not Found, Try Again.");
						labelSearch.setFont(myTitleFontt);
						labelSearch.setStyle("-fx-background-color : red");
						labelSearch.setTranslateX(200);
						rootSearch.setBottom(labelSearch);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			});

			addTheCostomer.setDisable(true);

			list.setOnAction(e -> {
				if (aGear.isSelected() | nGear.isSelected() | track.isSelected()) {
					try {
						addTheCostomer.setDisable(false);
						int flag = 0;
						if (aGear.isSelected())
							flag = 1;
						else if (nGear.isSelected())
							flag = 2;
						else if (track.isSelected())
							flag = 3;
						Connect();
						Statement stmt = con.createStatement();
						ResultSet rs = stmt.executeQuery("Select T.t_number,T.t_name\r\n" + "from teacher T\r\n"
								+ "where T.t_number IN(Select Tt.t_number\r\n"
								+ "					from teacher_typeOfTeaching Tt\r\n"
								+ "                    where Tt.type_number = " + flag + ");");
						while (rs.next()) {
							kind_Teacher.add(rs.getString(1) + "/" + rs.getString(2));
						}
						ComboBox<String> combo_box = new ComboBox<>(FXCollections.observableArrayList(kind_Teacher));
						combo_box.setMinWidth(50);
						combo_box.setMinHeight(50);
						combo_box.setPromptText("Selected training teachers");
						combo_box.setStyle("-fx-background-color : white; -fx-font-size : 20;");
						combo_box.setPromptText("Selected training teachers");
						hbox2.getChildren().add(combo_box);
						addTheCostomer.setOnAction(e1 -> {
							try {
								String cosId = textId.getText();
								String cosName = textName.getText();
								String cosAddrase = textAddress.getText();
								String cosWorking = textWorking.getText();
								String cosMobile = textMobile.getText();
								if (cosMobile.equals(""))
									cosMobile = null;
								String cosGender = null;
								String cosTel = textTel.getText();
								String cosPassword = textPass.getText();
								String costybeT;
								int t_number;
								if (male.isSelected())
									cosGender = "M";
								else if (feMale.isSelected())
									cosGender = "F";

								if (aGear.isSelected())
									costybeT = aGear.getText();
								else if (nGear.isSelected())
									costybeT = nGear.getText();
								else
									costybeT = track.getText();
								int flag1 = 0;
								if (costybeT.equals("Automatic Gear"))
									flag1 = 1;
								else if (costybeT.equals("Normal Gear"))
									flag1 = 2;
								else if (costybeT.equals("Track"))
									flag1 = 3;

								t_number = Integer.parseInt(combo_box.getValue().split("/")[0]);// take the number of
																								// teacher to add it
								ResultSet rs1 = stmt.executeQuery(
										"Select t_numberoflessons from teacher where t_number = " + t_number + ";");
								int numberoflessons = 0;
								if (rs1.next())
									numberoflessons = rs1.getInt(1);
								if (numberoflessons != 0) {
									stmt.executeUpdate("UPDATE teacher\r\n" + "SET t_numberoflessons = "
											+ (numberoflessons - 1) + " where t_number = " + t_number + ";");
									if (cosMobile != null) {
										stmt.executeUpdate(
												"INSERT INTO student(s_id, s_name, s_address, s_typeofwork, s_phonenumber, s_gender, s_mobilenumber, s_password, t_number, type_number, s_dateofbirth)\r\n"
														+ "VALUES(" + Integer.parseInt(cosId) + ", '" + cosName + "', '"
														+ cosAddrase + "', '" + cosWorking + "', "
														+ Integer.parseInt(cosMobile) + ", '" + cosGender + "', "
														+ Integer.parseInt(cosTel) + ", '" + cosPassword + "',"
														+ t_number + ", " + flag1 + ", '" + textPdate.getText()
														+ "');");

										Label valid = new Label("Adding this Student successfully!");
										valid.setFont(myTitleFontt);
										valid.setStyle("-fx-background-color : red");
										valid.setTranslateX(200);
										valid.setTranslateY(-40);
										rootAdd.setBottom(valid);
									} else {
										stmt.executeUpdate(
												"INSERT INTO student(s_id, s_name, s_address, s_typeofwork, s_phonenumber, s_gender, s_password, t_number, type_number, s_dateofbirth)\r\n"
														+ "VALUES(" + Integer.parseInt(cosId) + ", '" + cosName + "', '"
														+ cosAddrase + "', '" + cosWorking + "', "
														+ Integer.parseInt(cosTel) + ", '" + cosGender + "', '"
														+ cosPassword + "'," + t_number + ", " + flag1 + ", '"
														+ textPdate.getText() + "');");

										Label valid = new Label("Adding this Student successfully!");
										valid.setFont(myTitleFontt);
										valid.setStyle("-fx-background-color : red");
										valid.setTranslateX(200);
										valid.setTranslateY(-40);
										rootAdd.setBottom(valid);
									}
								} else {
									Label valid = new Label("Sorry, The teacher is busy");
									valid.setFont(myTitleFontt);
									valid.setStyle("-fx-background-color : red");
									valid.setTranslateX(200);
									valid.setTranslateY(-40);
									rootAdd.setBottom(valid);
								}

							} catch (SQLException e3) {
								System.out.println(e3.getMessage());
								Label invalid = new Label(e3.getMessage());
								invalid.setFont(Font.font(10));
								invalid.setStyle("-fx-background-color : red");
								invalid.setFont(myTitleFontt);
								invalid.setTranslateX(200);
								invalid.setTranslateY(-40);
								rootAdd.setBottom(invalid);
							}
						});

						backAdd.setOnAction(e5 -> {
							kind_Teacher.clear();
							hbox2.getChildren().remove(combo_box);
							rootAdd.setBottom(null);
							male.setSelected(false);
							feMale.setSelected(false);
							nGear.setSelected(false);
							aGear.setSelected(false);
							track.setSelected(false);
							textId.clear();
							textName.clear();
							textAddress.clear();
							textMobile.clear();
							textTel.clear();
							textPass.clear();
							textPdate.clear();

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
							textPass.setPromptText("Mandatory");
							textPass.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
							scene.setRoot(studentPage);
						});

					} catch (SQLException e1) {
						Label invalid = new Label(e1.getMessage());
						invalid.setFont(Font.font(10));
						invalid.setStyle("-fx-background-color : red");
						invalid.setTranslateX(200);
						invalid.setTranslateY(-40);
						rootAdd.setBottom(invalid);
					}
				}
			});
			deletTheCostomer.setDisable(true);
			find.setOnAction(e -> {
				try {
					Connect();
					Statement stmt = con.createStatement();
					int id = Integer.parseInt(textId1.getText());
					ResultSet rs = stmt.executeQuery("SELECT *\r\n" + "FROM student\r\n" + "where s_id = " + id + ";");
					if (rs.next()) {
						textName1.setText(rs.getString(2));
						textAddress1.setText(rs.getString(3));
						textWork1.setText(rs.getString(4));
						textTel1.setText(Integer.toString(rs.getInt(5)));
						textMobile1.setText(Integer.toString(rs.getInt(7)));
						textPdate1.setText(rs.getString(8));
						textPass1.setText(rs.getString(9));
						char gender = rs.getString(6).charAt(0);
						if (gender == 'M')
							textPlan1.setText("Male");
						else
							textPlan1.setText("Female");
						textWork1.setText(rs.getString(4));

						if (rs.getInt(11) == 1)
							textTrain1.setText("Automatic Gear");
						else if (rs.getInt(11) == 2)
							textTrain1.setText("Normal Gear");
						else if (rs.getInt(11) == 3)
							textTrain1.setText("Truck");
						else
							textTrain1.setText("Null");

						ResultSet rs1 = stmt.executeQuery("SELECT T.t_name\r\n" + "FROM teacher T\r\n"
								+ "where T.t_number In(select S.t_number\r\n" + "from student S \r\n"
								+ "where S.t_number = " + Integer.parseInt(rs.getString(10)) + ");");
						if (rs1.next())
							textTeacherName1.setText(rs1.getString(1));
						Label labelSearch = new Label("The Student Is Found");
						labelSearch.setFont(myTitleFontt);
						labelSearch.setStyle("-fx-background-color : red");
						labelSearch.setTranslateX(400);
						rootDelete.setBottom(labelSearch);
						deletTheCostomer.setDisable(false);
						deletTheCostomer.setOnAction(e1 -> {
							try {
								// increment # lessons
								int t_number = 0;
								ResultSet rs2 = stmt.executeQuery(
										"SELECT t_number\r\n" + "FROM student\r\n" + "where s_id = " + id + ";");
								if (rs2.next())
									t_number = rs2.getInt(1);
								ResultSet rs3 = stmt.executeQuery(
										"Select t_numberoflessons from teacher where t_number = " + t_number + ";");
								int numberoflessons = 0;
								if (rs3.next())
									numberoflessons = rs3.getInt(1);
								stmt.executeUpdate("UPDATE teacher\r\n" + "SET t_numberoflessons = "
										+ (numberoflessons + 1) + " where t_number = " + t_number + ";");
								stmt.executeUpdate("DELETE FROM student\r\n" + "WHERE s_id = " + id + ";");
								Label labelDelete = new Label("The Student Id (" + id + ") Is Deleted");
								labelDelete.setFont(myTitleFontt);
								labelDelete.setStyle("-fx-background-color : red");
								labelDelete.setTranslateX(400);
								labelDelete.setTranslateY(-40);
								rootDelete.setBottom(labelDelete);

							} catch (SQLException e6) {
								Label invalid = new Label(e6.getMessage());
								invalid.setFont(Font.font(10));
								invalid.setFont(myTitleFontt);
								invalid.setStyle("-fx-background-color : red");
								invalid.setTranslateX(400);
								invalid.setTranslateY(-40);
								rootDelete.setBottom(invalid);
							}
						});
					} else {
						textName1.setText("Null");
						textAddress1.setText("Null");
						textTel1.setText("Null");
						textMobile1.setText("Null");
						textPlan1.setText("Null");
						textWork1.setText("Null");
						textTrain1.setText("Null");
						textPdate1.setText("NuLL");
						textPass1.setText("NuLL");
						textTeacherName1.setText("NuLL");
						Label labelSearch = new Label("The Student Is Not Found, Try Again.");
						labelSearch.setFont(myTitleFontt);
						labelSearch.setStyle("-fx-background-color : red");
						labelSearch.setTranslateX(200);
						rootDelete.setBottom(labelSearch);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			});
			combo_boxU.setDisable(true);
			updateTheCostomer.setDisable(true);
			listu.setDisable(true);
			find1.setOnAction(e -> {
				try {
					Connect();
					Statement stmt = con.createStatement();
					int id = Integer.parseInt(textId2.getText());
					ResultSet rs = stmt.executeQuery("SELECT *\r\n" + "FROM student\r\n" + "where s_id = " + id + ";");
					if (rs.next()) {
						textName2.setText(rs.getString(2));
						textAddress2.setText(rs.getString(3));
						textWork2.setText(rs.getString(4));
						textTel2.setText(Integer.toString(rs.getInt(5)));
						textMobile2.setText(Integer.toString(rs.getInt(7)));
						textPdate2.setText(rs.getString(8));
						textPass2.setText(rs.getString(9));
						char gender = rs.getString(6).charAt(0);
						if (gender == 'M')
							maleU.setSelected(true);
						else
							feMaleU.setSelected(true);
						textWork2.setText(rs.getString(4));
						if (rs.getInt(11) == 1)
							aGearU.setSelected(true);
						else if (rs.getInt(11) == 2)
							nGearU.setSelected(true);
						else if (rs.getInt(11) == 3)
							trackU.setSelected(true);
						typeBeforeU = rs.getInt(11);
						ResultSet rs1 = stmt.executeQuery("SELECT T.t_name, T.t_number\r\n" + "FROM teacher T\r\n"
								+ "where T.t_number In(select S.t_number\r\n" + "from student S \r\n"
								+ "where S.t_number = " + Integer.parseInt(rs.getString(10)) + ");");
						if (rs1.next()) {
							combo_boxU.setPromptText(rs1.getString(1));
							t_numberBefor = rs1.getInt(2);
						}

						textName2.setDisable(false);
						textAddress2.setDisable(false);
						textName2.setDisable(false);
						textTel2.setDisable(false);
						textPdate2.setDisable(false);
						textPass2.setDisable(false);
						textWork2.setDisable(false);
						textMobile2.setDisable(false);
						maleU.setDisable(false);
						feMaleU.setDisable(false);
						aGearU.setDisable(false);
						nGearU.setDisable(false);
						trackU.setDisable(false);
						Label labelSearch = new Label("The Student Is Found");
						labelSearch.setFont(myTitleFontt);
						labelSearch.setStyle("-fx-background-color : red");
						labelSearch.setTranslateX(400);
						rootUpdate.setBottom(labelSearch);
						listu.setDisable(false);
						listu.setOnAction(e1 -> {
							int typeAfterU = 0;
							if (aGearU.isSelected())
								typeAfterU = 1;
							if (nGearU.isSelected())
								typeAfterU = 2;
							if (trackU.isSelected())
								typeAfterU = 3;
							if (typeBeforeU != typeAfterU) {
								try {
									combo_boxU.setDisable(false);
									updateTheCostomer.setDisable(false);
									Connect();
									ResultSet rs2 = stmt.executeQuery("Select T.t_number,T.t_name\r\n"
											+ "from teacher T\r\n" + "where T.t_number IN(Select Tt.t_number\r\n"
											+ "					from teacher_typeOfTeaching Tt\r\n"
											+ "                    where Tt.type_number = " + typeAfterU + ");");
									while (rs2.next()) {
										kind_TeacherU.add(rs2.getString(1) + "/" + rs2.getString(2));
									}
									ComboBox<String> combo_box = new ComboBox<>(
											FXCollections.observableArrayList(kind_TeacherU));
									combo_box.setMinWidth(50);
									combo_box.setMinHeight(50);
									combo_box.setPromptText("Selected training teachers");
									combo_box.setStyle("-fx-background-color : white; -fx-font-size : 20;");
									combo_box.setPromptText("Selected training teachers");
									hbox2U.getChildren().remove(combo_boxU);
									hbox2U.getChildren().add(combo_box);
									updateTheCostomer.setOnAction(e2 -> {
										try {
											String cosName = textName2.getText();
											String cosAddrase = textAddress2.getText();
											String cosWorking = textWork2.getText();
											String cosMobile = textMobile2.getText();
											if (cosMobile.equals(""))
												cosMobile = null;
											String cosGender;
											String cosTel = textTel2.getText();
											String cosPassword = textPass2.getText();
											String costybeT;
											int t_number;
											if (maleU.isSelected())
												cosGender = "M";
											else
												cosGender = "F";

											if (aGearU.isSelected())
												costybeT = aGearU.getText();
											else if (nGearU.isSelected())
												costybeT = nGearU.getText();
											else
												costybeT = trackU.getText();
											int flag1 = 0;
											if (costybeT.equals("Automatic Gear"))
												flag1 = 1;
											else if (costybeT.equals("Normal Gear"))
												flag1 = 2;
											else if (costybeT.equals("Track"))
												flag1 = 3;

											t_number = Integer.parseInt(combo_box.getValue().split("/")[0]);// take the
																											// number of
																											// teacher
																											// to add
																											// it

											ResultSet rs3 = stmt.executeQuery(
													"Select t_numberoflessons from teacher where t_number = "
															+ t_numberBefor + ";");
											int numberoflessons = 0;
											if (rs3.next())
												numberoflessons = rs3.getInt(1);
											stmt.executeUpdate("UPDATE teacher\r\n" + "SET t_numberoflessons = "
													+ (numberoflessons + 1) + " where t_number = " + t_numberBefor
													+ ";");
											ResultSet rs5 = stmt.executeQuery(
													"Select t_numberoflessons from teacher where t_number = " + t_number
															+ ";");
											if (rs5.next())
												numberoflessons = rs5.getInt(1);
											if (numberoflessons != 0) {
												System.out.println(numberoflessons);
												stmt.executeUpdate("UPDATE teacher\r\n" + "SET t_numberoflessons = "
														+ (numberoflessons - 1) + " where t_number = " + t_number
														+ ";");
												if (cosMobile != null) {

													stmt.executeUpdate("UPDATE student\r\n" + "SET s_name = '" + cosName
															+ "', s_address = '" + cosAddrase + "', s_typeofwork = '"
															+ cosWorking + "', s_phonenumber = '" + cosTel
															+ "', s_dateofbirth = '" + textPdate2.getText()
															+ "', s_gender = '" + cosGender + "', s_mobilenumber = "
															+ cosMobile + ", s_password = '" + cosPassword
															+ "', t_number = " + t_number + ", type_number = " + flag1
															+ " \r\nWHERE s_id = " + id + ";");

													Label valid = new Label("The Student Id (" + id + ") Is Updated");
													valid.setFont(myTitleFontt);
													valid.setStyle("-fx-background-color : red");
													valid.setTranslateX(200);
													valid.setTranslateY(-40);
													rootUpdate.setBottom(valid);
												} else {
													stmt.executeUpdate("UPDATE student\r\n" + "SET s_id = " + id
															+ ", s_name = '" + cosName + "', s_address = " + cosAddrase
															+ ", s_typeofwork = '" + cosWorking + "', s_phonenumber = '"
															+ cosTel + "', s_dateofbirth = '" + textPdate2.getText()
															+ "', s_gender = '" + cosGender + "'" + ", s_password = '"
															+ cosPassword + "', t_number = " + t_number
															+ ", type_number = " + flag1 + " \r\nWHERE s_id = " + id
															+ ";");

													Label valid = new Label("The Student Id (" + id + ") Is Updated");
													valid.setFont(myTitleFontt);
													valid.setStyle("-fx-background-color : red");
													valid.setTranslateX(200);
													valid.setTranslateY(-40);
													rootUpdate.setBottom(valid);
												}
											} else {
												Label valid = new Label("Sorry, The teacher is busy");
												valid.setFont(myTitleFontt);
												valid.setStyle("-fx-background-color : red");
												valid.setTranslateX(200);
												valid.setTranslateY(-40);
												rootUpdate.setBottom(valid);
											}

										} catch (SQLException e3) {
											e3.printStackTrace();
											Label invalid = new Label(e3.getMessage());
											invalid.setFont(Font.font(10));
											invalid.setStyle("-fx-background-color : red");
											invalid.setFont(myTitleFontt);
											invalid.setTranslateX(200);
											invalid.setTranslateY(-40);
											rootUpdate.setBottom(invalid);
										}
									});

									backUpdate.setOnAction(e5 -> {
										kind_TeacherU.clear();
										hbox2U.getChildren().remove(combo_box);
										rootUpdate.setBottom(null);
										maleU.setSelected(false);
										feMaleU.setSelected(false);
										nGearU.setSelected(false);
										aGearU.setSelected(false);
										trackU.setSelected(false);
										textId2.clear();
										textName2.clear();
										textAddress2.clear();
										textMobile2.clear();
										textTel2.clear();
										textPass2.clear();
										textPdate2.clear();
										textWork2.clear();
										hbox2U.getChildren().remove(combo_boxU);
										updateTheCostomer.setDisable(true);
										list.setDisable(true);
										rootUpdate.setBottom(null);
										listu.setDisable(true);
										textName2.setDisable(true);
										textAddress2.setDisable(true);
										textMobile2.setDisable(true);
										textTel2.setDisable(true);
										textWork2.setDisable(true);
										textPdate2.setDisable(true);
										textPass2.setDisable(true);
										maleU.setDisable(true);
										feMaleU.setDisable(true);
										aGearU.setDisable(true);
										nGearU.setDisable(true);
										trackU.setDisable(true);
										textId2.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
										textTel2.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
										textMobile2.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
										textId2.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
										textName2.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
										textAddress2.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
										textWork2.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
										textPass2.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
										scene.setRoot(studentPage);
									});

								} catch (SQLException e4) {
									Label invalid = new Label(e4.getMessage());
									invalid.setFont(Font.font(10));
									invalid.setStyle("-fx-background-color : red");
									invalid.setTranslateX(200);
									invalid.setTranslateY(-40);
									rootAdd.setBottom(invalid);
								}
							} else {
								try {
									combo_boxU.setDisable(false);
									updateTheCostomer.setDisable(false);
									Connect();
									ResultSet rs2 = stmt.executeQuery("Select T.t_number,T.t_name\r\n"
											+ "from teacher T\r\n" + "where T.t_number IN(Select Tt.t_number\r\n"
											+ "					from teacher_typeOfTeaching Tt\r\n"
											+ "                    where Tt.type_number = " + typeBeforeU + ");");
									while (rs2.next()) {
										t_numberBefor = rs2.getInt(1);
										kind_TeacherU.add(rs2.getString(1) + "/" + rs2.getString(2));
									}
									ComboBox<String> combo_box = new ComboBox<>(
											FXCollections.observableArrayList(kind_TeacherU));
									combo_box.setMinWidth(50);
									combo_box.setMinHeight(50);
									combo_box.setPromptText("Selected training teachers");
									combo_box.setStyle("-fx-background-color : white; -fx-font-size : 20;");
									combo_box.setPromptText("Selected training teachers");
									hbox2U.getChildren().remove(combo_boxU);
									hbox2U.getChildren().add(combo_box);
									updateTheCostomer.setOnAction(e2 -> {
										try {
											String cosName = textName2.getText();
											String cosAddrase = textAddress2.getText();
											String cosWorking = textWork2.getText();
											String cosMobile = textMobile2.getText();
											if (cosMobile.equals(""))
												cosMobile = null;
											String cosGender;
											String cosTel = textTel2.getText();
											String cosPassword = textPass2.getText();
											String costybeT;
											int t_number;
											if (maleU.isSelected())
												cosGender = "M";
											else
												cosGender = "F";

											if (aGearU.isSelected())
												costybeT = aGearU.getText();
											else if (nGearU.isSelected())
												costybeT = nGearU.getText();
											else
												costybeT = trackU.getText();
											int flag1 = 0;
											if (costybeT.equals("Automatic Gear"))
												flag1 = 1;
											else if (costybeT.equals("Normal Gear"))
												flag1 = 2;
											else if (costybeT.equals("Track"))
												flag1 = 3;

											t_number = Integer.parseInt(combo_box.getValue().split("/")[0]);// take the
																											// number of
																											// teacher
																											// to add
											ResultSet rs3 = stmt.executeQuery(
													"Select t_numberoflessons from teacher where t_number = " + t_number
															+ ";");
											int numberoflessons = 0;
											if (rs3.next())
												numberoflessons = rs3.getInt(1);
											if (t_numberBefor != t_number)
												stmt.executeUpdate("UPDATE teacher\r\n" + "SET t_numberoflessons = "
														+ (numberoflessons + 1) + " where t_number = " + t_numberBefor
														+ ";");
											ResultSet rs5 = stmt.executeQuery(
													"Select t_numberoflessons from teacher where t_number = " + t_number
															+ ";");
											if (rs5.next())
												numberoflessons = rs5.getInt(1);
											if (numberoflessons != 0) {
												stmt.executeUpdate("UPDATE teacher\r\n" + "SET t_numberoflessons = "
														+ (numberoflessons - 1) + " where t_number = " + t_number
														+ ";");
												if (cosMobile != null) // it
												{
													stmt.executeUpdate("UPDATE student\r\n" + "SET s_id = " + id
															+ ", s_name = '" + cosName + "', s_address = '" + cosAddrase
															+ "', s_typeofwork = '" + cosWorking
															+ "', s_phonenumber = '" + cosTel + "', s_dateofbirth = '"
															+ textPdate2.getText() + "', s_gender = '" + cosGender
															+ "', s_mobilenumber = " + cosMobile + ", s_password = '"
															+ cosPassword + "', t_number = " + t_number
															+ ", type_number = " + flag1 + " \r\nWHERE s_id = " + id
															+ ";");

													Label valid = new Label("The Student Id (" + id + ") Is Updated");
													valid.setFont(myTitleFontt);
													valid.setStyle("-fx-background-color : red");
													valid.setTranslateX(200);
													valid.setTranslateY(-40);
													rootUpdate.setBottom(valid);
												} else {
													stmt.executeUpdate("UPDATE student\r\n" + "SET s_id = " + id
															+ ", s_name = '" + cosName + "', s_address = " + cosAddrase
															+ ", s_typeofwork = '" + cosWorking + "', s_phonenumber = '"
															+ cosTel + "', s_dateofbirth = '" + textPdate2.getText()
															+ "', s_gender = '" + cosGender + "'" + ", s_password = '"
															+ cosPassword + "', t_number = " + t_number
															+ ", type_number = " + flag1 + " \r\nWHERE s_id = " + id
															+ ";");

													Label valid = new Label("The Student Id (" + id + ") Is Updated");
													valid.setFont(myTitleFontt);
													valid.setStyle("-fx-background-color : red");
													valid.setTranslateX(200);
													valid.setTranslateY(-40);
													rootUpdate.setBottom(valid);
												}
											} else {
												Label valid = new Label("Sorry, The teacher is busy");
												valid.setFont(myTitleFontt);
												valid.setStyle("-fx-background-color : red");
												valid.setTranslateX(200);
												valid.setTranslateY(-40);
												rootUpdate.setBottom(valid);
											}

										} catch (SQLException e3) {
											e3.printStackTrace();
											Label invalid = new Label(e3.getMessage());
											invalid.setFont(Font.font(10));
											invalid.setStyle("-fx-background-color : red");
											invalid.setFont(myTitleFontt);
											invalid.setTranslateX(200);
											invalid.setTranslateY(-40);
											rootUpdate.setBottom(invalid);
										}
										backUpdate.setOnAction(e5 -> {
											kind_TeacherU.clear();
											hbox2U.getChildren().remove(combo_box);
											rootUpdate.setBottom(null);
											maleU.setSelected(false);
											feMaleU.setSelected(false);
											nGearU.setSelected(false);
											aGearU.setSelected(false);
											trackU.setSelected(false);
											textId2.clear();
											textName2.clear();
											textAddress2.clear();
											textMobile2.clear();
											textTel2.clear();
											textPass2.clear();
											textPdate2.clear();
											hbox2U.getChildren().remove(combo_boxU);
											updateTheCostomer.setDisable(true);
											list.setDisable(true);
											rootUpdate.setBottom(null);
											listu.setDisable(true);
											textName2.setDisable(true);
											textAddress2.setDisable(true);
											textMobile2.setDisable(true);
											textTel2.setDisable(true);
											textWork2.setDisable(true);
											textPdate2.setDisable(true);
											textPass2.setDisable(true);
											maleU.setDisable(true);
											feMaleU.setDisable(true);
											aGearU.setDisable(true);
											nGearU.setDisable(true);
											trackU.setDisable(true);
											textId2.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
											textTel2.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
											textMobile2.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
											textId2.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
											textName2.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
											textAddress2.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
											textWork2.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
											textPass2.setStyle("-fx-prompt-text-fill: grey; -fx-font-size: 14pt;");
											scene.setRoot(studentPage);
										});
									});

								} catch (SQLException e4) {
									Label invalid = new Label(e4.getMessage());
									invalid.setFont(Font.font(10));
									invalid.setStyle("-fx-background-color : red");
									invalid.setTranslateX(200);
									invalid.setTranslateY(-40);
									rootAdd.setBottom(invalid);
								}

							}
						});

					} else {
						textName2.setText("Null");
						textAddress2.setText("Null");
						textTel2.setText("Null");
						textMobile2.setText("Null");
						textWork2.setText("Null");
						textPdate2.setText("NuLL");
						textPass2.setText("NuLL");
						textTeacherName3.setText("NuLL");
						Label labelSearch = new Label("The Student Is Not Found, Try Again.");
						labelSearch.setFont(myTitleFontt);
						labelSearch.setStyle("-fx-background-color : red");
						labelSearch.setTranslateX(200);
						rootUpdate.setBottom(labelSearch);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			});

			addTheCostomerT.setOnAction(e -> {
				try {
					Connect();
					Statement stmt = con.createStatement();
					String tgender;
					if (maleT.isSelected())
						tgender = "M";
					else
						tgender = "F";
					stmt.executeUpdate(
							"INSERT INTO teacher(t_number, t_name, t_phonenumber, t_address, t_gender, t_dateofbirth, t_numberoflessons, t_password)\r\n"
									+ "VALUES(" + Integer.parseInt(textIdT.getText()) + ", '" + textNameT.getText()
									+ "', " + Integer.parseInt(textTelT.getText()) + ", '" + textAddressT.getText()
									+ "', '" + tgender + "', '" + textBirth.getText() + "', "
									+ Integer.parseInt(textLess.getText()) + ", '" + textTeacherPass.getText() + "');");
					int[] teacherType = new int[3];// array to save the types that teacher teaching (maybe more than
													// one)
					if (aGearT.isSelected())
						teacherType[0] = 1;
					else
						teacherType[0] = 0;
					if (nGearT.isSelected())
						teacherType[1] = 1;
					else
						teacherType[1] = 0;
					if (trackT.isSelected())
						teacherType[2] = 1;
					else
						teacherType[2] = 0;
					for (int i = 0; i < 3; i++) {
						if (teacherType[i] == 1)
							stmt.executeUpdate("INSERT INTO teacher_typeOfTeaching\r\n" + "VALUES("
									+ Integer.parseInt(textIdT.getText()) + ", " + (i + 1) + ");");// i + 1 is for the
																									// type num is SQL

					}

					Label valid = new Label("Adding this Teacher successfully!");
					valid.setFont(myTitleFontt);
					valid.setStyle("-fx-background-color : red");
					valid.setTranslateX(200);
					valid.setTranslateY(-40);
					rootAddT.setBottom(valid);

				} catch (SQLException e1) {
					Label invalid = new Label(e1.getMessage());
					invalid.setFont(Font.font(10));
					invalid.setFont(myTitleFontt);
					invalid.setStyle("-fx-background-color : red");
					invalid.setTranslateX(200);
					invalid.setTranslateY(-40);
					rootAddT.setBottom(invalid);
				}
			});
			searchTheCostomerT.setOnAction(e -> {
				try {
					Connect();
					Statement stmt = con.createStatement();
					int id = Integer.parseInt(textId3T.getText());
					ResultSet rs = stmt.executeQuery("select * from teacher\r\n" + "where t_number = " + id + ";");
					try {
						if (rs.next()) {
							textName3T.setText(rs.getString(2));
							textAddress3T.setText(rs.getString(4));
							textTel3T.setText(Integer.toString(rs.getInt(3)));
							textLess3.setText(Integer.toString(rs.getInt(7)));
							textBirth3.setText(rs.getDate(6).toString());
							textTeacherPass3.setText(rs.getString(8));
							char gender = rs.getString(5).charAt(0);
							if (gender == 'M')
								textPlan3T.setText("Male");
							else
								textPlan3T.setText("Female");
							ResultSet rs1 = stmt.executeQuery(
									"select * from teacher_typeOfTeaching\r\n" + "where t_number = " + id + ";");
							ArrayList<String> type = new ArrayList<String>();
							while (rs1.next()) {
								if (rs1.getInt(2) == 1)
									type.add("Automatic Gear");
								if (rs1.getInt(2) == 2)
									type.add("Normal Gear");
								if (rs1.getInt(2) == 3)
									type.add("Truck");
							}
							if (type.isEmpty())
								textTrain3T.setText("Null");
							else
								textTrain3T.setText(type.toString());
							Label labelSearch = new Label("The Teacher Is Found");
							labelSearch.setFont(myTitleFontt);
							labelSearch.setStyle("-fx-background-color : red");
							labelSearch.setTranslateX(400);
							labelSearch.setTranslateY(-40);
							rootSearchT.setBottom(labelSearch);
						} else {
							textName3T.setText("Null");
							textAddress3T.setText("Null");
							textTel3T.setText("Null");
							textPlan3T.setText("Null");
							textTrain3T.setText("Null");
							textLess3.setText("NULL");
							textBirth3.setText("NULL");
							textTeacherPass3.setText("NULL");
							Label labelSearch = new Label("The Teacher Is Not Found, Try Again.");
							labelSearch.setFont(myTitleFontt);
							labelSearch.setStyle("-fx-background-color : red");
							labelSearch.setTranslateX(400);
							labelSearch.setTranslateY(-40);
							rootSearchT.setBottom(labelSearch);
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} catch (Exception ex) {
					// System.out.println(ex.getMessage());
					ex.printStackTrace();
				}
			});
			deletTheCostomerT.setDisable(true);
			findT.setOnAction(e -> {
				try {
					Connect();
					Statement stmt = con.createStatement();
					int id = Integer.parseInt(textId1T.getText());
					ResultSet rs = stmt.executeQuery("select * from teacher\r\n" + "where t_number = " + id + ";");
					try {
						if (rs.next()) {
							textName1T.setText(rs.getString(2));
							textAddress1T.setText(rs.getString(4));
							textTel1T.setText(Integer.toString(rs.getInt(3)));
							textLess1.setText(Integer.toString(rs.getInt(7)));
							textBirth1.setText(rs.getDate(6).toString());
							textTeacherPass1.setText(rs.getString(8));
							char gender = rs.getString(5).charAt(0);
							if (gender == 'M')
								textPlan1T.setText("Male");
							else
								textPlan1T.setText("Female");
							ResultSet rs1 = stmt.executeQuery(
									"select * from teacher_typeOfTeaching\r\n" + "where t_number = " + id + ";");
							ArrayList<String> type = new ArrayList<String>();
							while (rs1.next()) {
								if (rs1.getInt(2) == 1)
									type.add("Automatic Gear");
								if (rs1.getInt(2) == 2)
									type.add("Normal Gear");
								if (rs1.getInt(2) == 3)
									type.add("Truck");
							}
							if (type.isEmpty())
								textTrain1T.setText("Null");
							else
								textTrain1T.setText(type.toString());
							Label labelSearch = new Label("The Teacher Is Found");
							labelSearch.setFont(myTitleFontt);
							labelSearch.setStyle("-fx-background-color : red");
							labelSearch.setTranslateX(400);
							labelSearch.setTranslateY(-40);
							rootDeleteT.setBottom(labelSearch);
							deletTheCostomerT.setDisable(false);
							deletTheCostomerT.setOnAction(f -> {
								try {
									stmt.executeUpdate("DELETE FROM teacher\r\n" + "WHERE t_number = " + id + ";");
									Label labelDelete = new Label("The Teacher Id (" + id + ") Is Deleted");
									labelDelete.setFont(myTitleFontt);
									labelDelete.setStyle("-fx-background-color : red");
									labelDelete.setTranslateX(400);
									labelDelete.setTranslateY(-40);
									rootDeleteT.setBottom(labelDelete);

								} catch (SQLException e1) {
									Label invalid = new Label(e1.getMessage());
									invalid.setFont(Font.font(10));
									invalid.setFont(myTitleFontt);
									invalid.setStyle("-fx-background-color : red");
									invalid.setTranslateX(400);
									invalid.setTranslateY(-40);
									rootDeleteT.setBottom(invalid);
								}
							});
						} else {
							textName1T.setText("Null");
							textAddress1T.setText("Null");
							textTel1T.setText("Null");
							textPlan1T.setText("Null");
							textTrain1T.setText("Null");
							textLess1.setText("NULL");
							textBirth1.setText("NULL");
							textTeacherPass1.setText("NULL");
							Label labelSearch = new Label("The Teacher Is Not Found, Try Again.");
							labelSearch.setFont(myTitleFontt);
							labelSearch.setStyle("-fx-background-color : red");
							labelSearch.setTranslateX(400);
							labelSearch.setTranslateY(-40);
							rootDeleteT.setBottom(labelSearch);
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} catch (SQLException e1) {
					Label invalid = new Label(e1.getMessage());
					invalid.setFont(Font.font(10));
					invalid.setFont(myTitleFontt);
					invalid.setStyle("-fx-background-color : red");
					invalid.setTranslateX(200);
					rootAdd.setBottom(invalid);
				}
			});
			updateTheCostomerT.setDisable(true);
			find1T.setOnAction(e -> {
				try {
					Connect();
					Statement stmt = con.createStatement();
					int id = Integer.parseInt(textId2T.getText());
					ResultSet rs = stmt.executeQuery("select * from teacher\r\n" + "where t_number = " + id + ";");
					try {
						if (rs.next()) {
							textName2T.setText(rs.getString(2));
							textAddress2T.setText(rs.getString(4));
							textTel2T.setText(Integer.toString(rs.getInt(3)));
							textLess2.setText(Integer.toString(rs.getInt(7)));
							textBirth2.setText(rs.getDate(6).toString());
							textTeacherPass2.setText(rs.getString(8));
							char gender = rs.getString(5).charAt(0);
							textName2T.setDisable(false);
							textAddress2T.setDisable(false);
							textName2T.setDisable(false);
							textTel2T.setDisable(false);
							textLess2.setDisable(false);
							textBirth2.setDisable(false);
							textTeacherPass2.setDisable(false);
							maleTU.setDisable(false);
							feMaleTU.setDisable(false);
							aGearTU.setDisable(false);
							nGearTU.setDisable(false);
							trackTU.setDisable(false);
							if (gender == 'M')
								maleTU.setSelected(true);
							else
								feMaleTU.setSelected(true);
							ResultSet rs1 = stmt.executeQuery(
									"select * from teacher_typeOfTeaching\r\n" + "where t_number = " + id + ";");
							while (rs1.next()) {
								if (rs1.getInt(2) == 1)
									aGearTU.setSelected(true);
								if (rs1.getInt(2) == 2)
									nGearTU.setSelected(true);
								if (rs1.getInt(2) == 3)
									trackTU.setSelected(true);
							}
							int[] teacherTypeBefor = new int[3];// array to save the types that teacher teaching Before
																// Updating
							if (aGearTU.isSelected())
								teacherTypeBefor[0] = 1;
							else
								teacherTypeBefor[0] = 0;
							if (nGearTU.isSelected())
								teacherTypeBefor[1] = 1;
							else
								teacherTypeBefor[1] = 0;
							if (trackTU.isSelected())
								teacherTypeBefor[2] = 1;
							else
								teacherTypeBefor[2] = 0;
							Label labelSearch = new Label("The Teacher Is Found");
							labelSearch.setFont(myTitleFontt);
							labelSearch.setStyle("-fx-background-color : red");
							labelSearch.setTranslateX(400);
							labelSearch.setTranslateY(-40);
							rootUpdateT.setBottom(labelSearch);
							updateTheCostomerT.setDisable(false);
							updateTheCostomerT.setOnAction(f -> {
								try {
									Character cgender;
									if (maleTU.isSelected())
										cgender = 'M';// first letter from gender must
									// be putted in DB
									else
										cgender = 'F';

									stmt.executeUpdate("UPDATE teacher\r\n" + "SET t_number = " + id + ", t_name = '"
											+ textName2T.getText() + "', t_phonenumber = "
											+ Integer.parseInt(textTel2T.getText()) + ", t_address = '"
											+ textAddress2T.getText() + "', t_gender = '" + cgender
											+ "', t_dateofbirth = '" + textBirth2.getText() + "', t_numberoflessons = "
											+ Integer.parseInt(textLess2.getText()) + ", t_password = '"
											+ textTeacherPass2.getText() + "' \r\nWHERE t_number = " + id + ";");
									int[] teacherTypeAfter = new int[3];
									if (aGearTU.isSelected())
										teacherTypeAfter[0] = 1;
									else
										teacherTypeAfter[0] = 0;
									if (nGearTU.isSelected())
										teacherTypeAfter[1] = 1;
									else
										teacherTypeAfter[1] = 0;
									if (trackTU.isSelected())
										teacherTypeAfter[2] = 1;
									else
										teacherTypeAfter[2] = 0;
									for (int i = 0; i < 3; i++) {
										if (teacherTypeAfter[i] == 1 && teacherTypeBefor[i] == 0)
											stmt.executeUpdate("INSERT INTO teacher_typeOfTeaching\r\n" + "VALUES(" + id
													+ ", " + (i + 1) + ");");// i + 1 is for the type num is SQL
									}
									for (int i = 0; i < 3; i++) {
										if (teacherTypeBefor[i] == 1 && teacherTypeAfter[i] == 0)
											stmt.executeUpdate("DELETE FROM teacher_typeOfTeaching\r\n"
													+ "WHERE t_number = " + id + " AND type_number = " + (i + 1) + ";");// i
																														// +
																														// 1
																														// is
																														// for
																														// the
																														// type
																														// num
																														// is
																														// SQL
									}
									Label labelDelete = new Label("The Teacher Id (" + id + ") Is Updated");
									labelDelete.setFont(myTitleFontt);
									labelDelete.setStyle("-fx-background-color : red");
									labelDelete.setTranslateX(400);
									labelDelete.setTranslateY(-40);
									rootUpdateT.setBottom(labelDelete);

								} catch (SQLException e1) {
									Label invalid = new Label(e1.getMessage());
									invalid.setFont(Font.font(10));
									invalid.setFont(myTitleFontt);
									invalid.setStyle("-fx-background-color : red");
									invalid.setTranslateX(400);
									invalid.setTranslateY(-40);
									rootUpdateT.setBottom(invalid);
								}
							});
						} else {
							textName1T.setText("Null");
							textAddress1T.setText("Null");
							textTel1T.setText("Null");
							textLess1.setText("NULL");
							textBirth1.setText("NULL");
							textTeacherPass1.setText("NULL");
							Label labelSearch = new Label("The Teacher Is Not Found, Try Again.");
							labelSearch.setFont(myTitleFontt);
							labelSearch.setStyle("-fx-background-color : red");
							labelSearch.setTranslateX(400);
							labelSearch.setTranslateY(-40);
							rootUpdateT.setBottom(labelSearch);
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} catch (SQLException e1) {
					Label invalid = new Label(e1.getMessage());
					invalid.setFont(Font.font(10));
					invalid.setFont(myTitleFontt);
					invalid.setStyle("-fx-background-color : red");
					invalid.setTranslateX(200);
					rootAdd.setBottom(invalid);
				}
			});
			addTheCostomerC.setOnAction(e -> {
				try {
					Connect();
					Statement stmt = con.createStatement();
					int type = 0;
					if (aGearC.isSelected())
						type = 1;
					else if (nGearC.isSelected())
						type = 2;
					else if (trackC.isSelected())
						type = 3;
					boolean readyL = false;
					if (truelicense.isSelected())
						readyL = true;
					boolean readyT = false;
					if (trueReady.isSelected())
						readyT = true;

					stmt.executeUpdate("INSERT INTO vehicle\r\n" + "VALUES(" + Integer.parseInt(textIdC.getText())
							+ ", '" + textNameC.getText() + "', '" + yearofpurchasingText.getText() + "', " + readyL
							+ ", " + readyT + ", '" + modelCText.getText() + "', " + 1 + ", " + type + ");");
					Label valid = new Label("Adding this Car successfully!");
					valid.setFont(myTitleFontt);
					valid.setStyle("-fx-background-color : red");
					valid.setTranslateX(200);
					valid.setTranslateY(-40);
					rootAddC.setBottom(valid);

				} catch (SQLException e1) {
					Label invalid = new Label(e1.getMessage());
					invalid.setFont(Font.font(10));
					invalid.setFont(myTitleFontt);
					invalid.setStyle("-fx-background-color : red");
					invalid.setTranslateX(200);
					invalid.setTranslateY(-40);
					rootAddC.setBottom(invalid);
				}
			});
			searchTheCostomerC.setOnAction(e -> {
				try {
					Connect();
					Statement stmt = con.createStatement();
					int id = Integer.parseInt(textIdC3.getText());
					ResultSet rs = stmt.executeQuery("select * from vehicle\r\n" + "where v_number = " + id + ";");
					try {
						if (rs.next()) {
							textNameC3.setText(rs.getString(2));
							yearofpurchasingText3.setText(rs.getString(3));
							if (rs.getBoolean(4) == true)
								licenseAndInsuranceText3.setText("true");
							else
								licenseAndInsuranceText3.setText("false");
							if (rs.getBoolean(5) == true)
								readyTrainText3.setText("true");
							else
								readyTrainText3.setText("false");
							modelCText3.setText(Integer.toString(rs.getInt(6)));
							if (rs.getInt(8) == 1)
								TypeUsedText3.setText("Automatic Gear");
							else if (rs.getInt(8) == 2)
								TypeUsedText3.setText("Normal Gear");
							else if (rs.getInt(8) == 3)
								TypeUsedText3.setText("Truck");

							Label labelSearch = new Label("The Vehicle Is Found");
							labelSearch.setFont(myTitleFontt);
							labelSearch.setStyle("-fx-background-color : red");
							labelSearch.setTranslateX(400);
							labelSearch.setTranslateY(-40);
							rootSearchC.setBottom(labelSearch);
						} else {
							textNameC3.setText("Null");
							yearofpurchasingText3.setText("Null");
							licenseAndInsuranceText3.setText("Null");
							readyTrainText3.setText("Null");
							modelCText3.setText("Null");
							TypeUsedText3.setText("NULL");
							Label labelSearch = new Label("The Vehicle Is Not Found, Try Again.");
							labelSearch.setFont(myTitleFontt);
							labelSearch.setStyle("-fx-background-color : red");
							labelSearch.setTranslateX(400);
							labelSearch.setTranslateY(-40);
							rootSearchC.setBottom(labelSearch);
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			});
			deletTheCostomerC.setDisable(true);
			findC.setOnAction(e -> {
				try {
					Connect();
					Statement stmt = con.createStatement();
					int id = Integer.parseInt(textIdC1.getText());
					ResultSet rs = stmt.executeQuery("select * from vehicle\r\n" + "where v_number = " + id + ";");
					try {
						if (rs.next()) {
							textNameC1.setText(rs.getString(2));
							yearofpurchasingText1.setText(rs.getString(3));
							licenseAndInsuranceText1.setText(rs.getString(4));
							readyTrainText1.setText(rs.getString(5));
							modelCText1.setText(Integer.toString(rs.getInt(6)));
							if (rs.getInt(8) == 1)
								TypeUsedText.setText("Automatic Gear");
							else if (rs.getInt(8) == 2)
								TypeUsedText.setText("Normal Gear");
							else if (rs.getInt(8) == 3)
								TypeUsedText.setText("Truck");

							Label labelSearch = new Label("The Vehicle Is Found");
							labelSearch.setFont(myTitleFontt);
							labelSearch.setStyle("-fx-background-color : red");
							labelSearch.setTranslateX(400);
							labelSearch.setTranslateY(-40);
							rootDeleteC.setBottom(labelSearch);
							deletTheCostomerC.setDisable(false);
							deletTheCostomerC.setOnAction(e1 -> {
								try {
									stmt.executeUpdate("DELETE FROM vehicle\r\n" + "WHERE v_number = " + id + ";");
									Label labelDelete = new Label("The Vehicle Id (" + id + ") Is Deleted");
									labelDelete.setFont(myTitleFontt);
									labelDelete.setStyle("-fx-background-color : red");
									labelDelete.setTranslateX(400);
									labelDelete.setTranslateY(-40);
									rootDeleteC.setBottom(labelDelete);

								} catch (SQLException e3) {
									Label invalid = new Label(e3.getMessage());
									invalid.setFont(Font.font(10));
									invalid.setFont(myTitleFontt);
									invalid.setStyle("-fx-background-color : red");
									invalid.setTranslateX(400);
									invalid.setTranslateY(-40);
									rootDeleteC.setBottom(invalid);
								}
							});
						} else {
							textNameC1.setText("Null");
							yearofpurchasingText1.setText("Null");
							licenseAndInsuranceText1.setText("Null");
							readyTrainText1.setText("Null");
							modelCText1.setText("Null");
							TypeUsedText.setText("NULL");
							licenseAndInsuranceText1.setText("NULL");
							readyTrainText1.setText("NULL");
							Label labelSearch = new Label("The Vehicle Is Not Found, Try Again.");
							labelSearch.setFont(myTitleFontt);
							labelSearch.setStyle("-fx-background-color : red");
							labelSearch.setTranslateX(400);
							labelSearch.setTranslateY(-40);
							rootDeleteC.setBottom(labelSearch);
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			});
			updateTheCostomerC.setDisable(true);
			find1C.setOnAction(e -> {
				try {
					Connect();
					Statement stmt = con.createStatement();
					int id = Integer.parseInt(textIdC2.getText());
					ResultSet rs = stmt.executeQuery("select * from vehicle\r\n" + "where v_number = " + id + ";");
					try {
						if (rs.next()) {
							textNameC2.setText(rs.getString(2));
							yearofpurchasingText2.setText(rs.getString(3).split("-")[0]);
							if (rs.getBoolean(4) == true)
								truelicense1.setSelected(true);
							else
								falselicense1.setSelected(true);
							if (rs.getBoolean(5) == true)
								trueReady1.setSelected(true);
							else
								falseReady1.setSelected(true);
							modelCText2.setText(Integer.toString(rs.getInt(6)));
							if (rs.getInt(8) == 1)
								aGearUpdate.setSelected(true);
							else if (rs.getInt(8) == 2)
								nGearUpdate.setSelected(true);
							else if (rs.getInt(8) == 3)
								trackUpdate.setSelected(true);

							Label labelSearch = new Label("The Vehicle Is Found");
							labelSearch.setFont(myTitleFontt);
							labelSearch.setStyle("-fx-background-color : red");
							labelSearch.setTranslateX(400);
							labelSearch.setTranslateY(-40);
							rootUpdateC.setBottom(labelSearch);

							yearofpurchasingText2.setDisable(false);
							aGearUpdate.setDisable(false);
							trackUpdate.setDisable(false);
							nGearUpdate.setDisable(false);
							truelicense1.setDisable(false);
							falselicense1.setDisable(false);
							trueReady1.setDisable(false);
							falseReady1.setDisable(false);
							textNameC2.setDisable(false);
							readyTrainText2.setDisable(false);
							modelCText2.setDisable(false);
							updateTheCostomerC.setDisable(false);
							updateTheCostomerC.setOnAction(e1 -> {
								try {
									boolean license = false;
									boolean ready = false;
									int type = 0;
									if (truelicense1.isSelected())
										license = true;
									else
										license = false;
									if (trueReady1.isSelected())
										ready = true;
									else
										ready = false;
									if (aGearUpdate.isSelected())
										type = 1;
									else if (nGearUpdate.isSelected())
										type = 2;
									else if (trackUpdate.isSelected())
										type = 3;
									stmt.executeUpdate("update vehicle\r\n" + "set v_number = " + id + ", v_name = '"
											+ textNameC2.getText() + "', v_yearofpurchasing= '"
											+ yearofpurchasingText2.getText().split("-")[0]
											+ "', v_license_and_insurance = " + license + ", ready_to_training = "
											+ ready + "\r\n" + ", v_model = '" + Integer.parseInt(modelCText2.getText())
											+ "', o_number = 1, type_number = " + type + "\r\n" + "where v_number = "
											+ id + ";");

									Label labelUpdate = new Label("The Vehicle Id (" + id + ") Is Updated");
									labelUpdate.setFont(myTitleFontt);
									labelUpdate.setStyle("-fx-background-color : red");
									labelUpdate.setTranslateX(400);
									labelUpdate.setTranslateY(-40);
									rootUpdateC.setBottom(labelUpdate);

								} catch (SQLException e3) {
									Label invalid = new Label(e3.getMessage());
									invalid.setFont(Font.font(10));
									invalid.setFont(myTitleFontt);
									invalid.setStyle("-fx-background-color : red");
									invalid.setTranslateX(400);
									invalid.setTranslateY(-40);
									rootUpdateC.setBottom(invalid);
								}
							});
						} else {
							textNameC2.setText("Null");
							yearofpurchasingText2.setText("Null");
							modelCText2.setText("Null");
							Label labelSearch = new Label("The Vehicle Is Not Found, Try Again.");
							labelSearch.setFont(myTitleFontt);
							labelSearch.setStyle("-fx-background-color : red");
							labelSearch.setTranslateX(400);
							labelSearch.setTranslateY(-40);
							rootUpdateC.setBottom(labelSearch);
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			});
			log.setOnAction(e -> {

				Label invalid = new Label();
				invalid.setFont(Font.font(20));
				invalid.setFont(myTitleFo);
				invalid.setTranslateY(-525);
				invalid.setStyle("-fx-background-color : red");
				invalid.setTranslateX(260);
				root.setBottom(invalid);

				int flag = 0;
				if (usernameField.getText().trim() != "" && passwordField.getText().trim() != "") {

					if (usernameField.getText().trim().equals("admin")// **admin
							&& passwordField.getText().trim().equals("admin")) {
						scene.setRoot(rootManeger);
						flag = 1;
					}

					else if (usernameField.getText().trim().charAt(0) == 'T') {

						Connect();
						Statement stmt = null;
						try {
							stmt = con.createStatement();
						} catch (SQLException e2) {
							e2.printStackTrace();
						}

						ResultSet rs = null;
						try {
							rs = stmt.executeQuery("select * from Teacher ;");
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						try {

							while (rs.next()) {
								if (rs.getString(8).equals(passwordField.getText().trim())
										&& rs.getString(1).equals(usernameField.getText().trim().substring(1,
												usernameField.getText().trim().length()))) {

									flag = 1;
									invalid.setText("");
									nameProfaile.setText(rs.getString(2));
									forIdTeacher.setText(rs.getString(1));
									forNameTeacher.setText(rs.getString(2));
									forAddressTeacher.setText(rs.getString(4));
									forPhoneTeacher.setText(rs.getString(3));
									forGenderTeacher.setText(rs.getString(5));
									forBirthTeacher.setText(rs.getString(6));
									forLessonTeacher.setText(" 	  " + rs.getString(7));
									forPassTeacher.setText(rs.getString(8));
									forOwnerTeacher.setText(rs.getString(9) + "  Abu Fuad");

									usernameField.clear();
									passwordField.clear();
									scene.setRoot(rootForTeacher);
								}
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}

					} else if (usernameField.getText().trim().charAt(0) == 'S') {

						Connect();
						Statement stmt = null;
						try {
							stmt = con.createStatement();
						} catch (SQLException e2) {
							e2.printStackTrace();
						}

						ResultSet rs = null;
						try {
							rs = stmt.executeQuery("select * from Student ;");
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						try {

							while (rs.next()) {
								if (rs.getString(9).equals(passwordField.getText().trim())
										&& rs.getString(1).equals(usernameField.getText().trim().substring(1,
												usernameField.getText().trim().length()))) {

									flag = 1;
									invalid.setText("");
									nameProfaileStudent.setText(rs.getString(2));
									forIdStu.setText(rs.getString(1));
									forNameStu.setText(rs.getString(2));
									forAddressStu.setText(rs.getString(3));
									forWorkStu.setText(rs.getString(4));
									forPhoneStu.setText(rs.getString(5));
									forTelStu.setText(rs.getString(7));
									forGenderStu.setText(rs.getString(6));
									forBirthStu.setText(rs.getString(8));
									forPassStu.setText(rs.getString(9));
									forTeacherStu.setText("   " + rs.getString(10));

									if (rs.getInt(11) == 1)
										forTrainStu.setText("Automatic Gear");
									else if (rs.getInt(11) == 2)
										forTrainStu.setText("Normal Gear");
									else if (rs.getInt(11) == 3)
										forTrainStu.setText("Truck");
									else
										forTrainStu.setText("None");
									forOwnerStu.setText("Abu Fuad");

									usernameField.clear();
									passwordField.clear();
									scene.setRoot(rootForStudent);
								}
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}

					}
				}
				if (flag == 0) {
					invalid.setText("You should enter the correct password and username.");
				}
			});
			forlogin.setOnMouseClicked(e -> {
				Label invalid = new Label();
				invalid.setFont(Font.font(20));
				invalid.setFont(myTitleFo);
				invalid.setTranslateY(-525);
				invalid.setStyle("-fx-background-color : red");
				invalid.setTranslateX(260);
				root.setBottom(invalid);

				int flag = 0;
				if (usernameField.getText().trim() != "" && passwordField.getText().trim() != "") {

					if (usernameField.getText().trim().equals("admin")// **admin
							&& passwordField.getText().trim().equals("admin")) {
						scene.setRoot(rootManeger);
						flag = 1;
					}

					else if (usernameField.getText().trim().charAt(0) == 'T') {

						Connect();
						Statement stmt = null;
						try {
							stmt = con.createStatement();
						} catch (SQLException e2) {
							e2.printStackTrace();
						}

						ResultSet rs = null;
						try {
							rs = stmt.executeQuery("select * from Teacher ;");
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						try {

							while (rs.next()) {
								if (rs.getString(8).equals(passwordField.getText().trim())
										&& rs.getString(1).equals(usernameField.getText().trim().substring(1,
												usernameField.getText().trim().length()))) {

									flag = 1;
									invalid.setText("");
									nameProfaile.setText(rs.getString(2));
									forIdTeacher.setText(rs.getString(1));
									forNameTeacher.setText(rs.getString(2));
									forAddressTeacher.setText(rs.getString(4));
									forPhoneTeacher.setText(rs.getString(3));
									forGenderTeacher.setText(rs.getString(5));
									forBirthTeacher.setText(rs.getString(6));
									forLessonTeacher.setText(" 	  " + rs.getString(7));
									forPassTeacher.setText(rs.getString(8));
									forOwnerTeacher.setText(rs.getString(9) + "  Abu Fuad");

									usernameField.clear();
									passwordField.clear();
									scene.setRoot(rootForTeacher);
								}
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}

					} else if (usernameField.getText().trim().charAt(0) == 'S') {

						Connect();
						Statement stmt = null;
						try {
							stmt = con.createStatement();
						} catch (SQLException e2) {
							e2.printStackTrace();
						}

						ResultSet rs = null;
						try {
							rs = stmt.executeQuery("select * from Student ;");
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						try {

							while (rs.next()) {
								if (rs.getString(9).equals(passwordField.getText().trim())
										&& rs.getString(1).equals(usernameField.getText().trim().substring(1,
												usernameField.getText().trim().length()))) {

									flag = 1;
									invalid.setText("");

									forIdStu.setText(rs.getString(1));
									forNameStu.setText(rs.getString(2));
									forAddressStu.setText(rs.getString(3));
									forWorkStu.setText(rs.getString(4));
									forPhoneStu.setText(rs.getString(5));
									forTelStu.setText(rs.getString(7));
									forGenderStu.setText(rs.getString(6));
									forBirthStu.setText(rs.getString(8));
									forPassStu.setText(rs.getString(9));
									forTeacherStu.setText("   " + rs.getString(10));

									if (rs.getInt(11) == 1)
										forTrainStu.setText("Automatic Gear");
									else if (rs.getInt(11) == 2)
										forTrainStu.setText("Normal Gear");
									else if (rs.getInt(11) == 3)
										forTrainStu.setText("Truck");
									else
										forTrainStu.setText("None");
									forOwnerStu.setText("Abu Fuad");

									usernameField.clear();
									passwordField.clear();
									scene.setRoot(rootForStudent);
								}
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}

					}
				}
				if (flag == 0) {
					invalid.setText("You should enter the correct password and username.");
				}
			});

			q1.setOnAction(e -> {

				Connect();
				Statement stmt = null;
				try {
					stmt = con.createStatement();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}

				ResultSet rs = null;
				try {
					rs = stmt.executeQuery("SELECT S.s_name, S.s_id FROM STUDENT S, typeOfTeaching T, VEHICLE V\r\n"
							+ "	WHERE S.type_number = T.type_number AND T.type_number = V.type_number AND S.s_dateofbirth < '2001-1-1' AND V.v_name = 'Hyundai' AND T.type_name = 'A';\r\n"
							+ "");

					while (rs.next()) {
						toPrintReport.setText(rs.getString(1) + "    " + rs.getString(2));
						toPrintReport.setText("\n");
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			});
			
			q2.setOnAction(e -> {

				Connect();
				Statement stmt = null;
				try {
					stmt = con.createStatement();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}

				ResultSet rs = null;
				try {
					rs = stmt.executeQuery("	SELECT COUNT(S.s_id) as NumberOfStudents, type_number\r\n"
							+ "		FROM STUDENT S\r\n"
							+ "		GROUP BY S.type_number\r\n"
							+ "		ORDER BY COUNT(S.s_id) DESC;\r\n"
							+ "");

					while (rs.next()) {
						toPrintReport.setText(rs.getString(1) + "    " + rs.getString(2));
						toPrintReport.setText("\n");
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			});
			
			q3.setOnAction(e -> {

				Connect();
				Statement stmt = null;
				try {
					stmt = con.createStatement();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}

				ResultSet rs = null;
				try {
					rs = stmt.executeQuery("select S.s_name, T.t_name from Student S, Teacher T\r\n"
							+ "	where S.t_number = T.t_number;\r\n"
							+ "");

					while (rs.next()) {
						toPrintReport.setText(rs.getString(1) + "    " + rs.getString(2));
						toPrintReport.setText("\n");
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			});
			
			
			
			q4.setOnAction(e -> {

				Connect();
				Statement stmt = null;
				try {
					stmt = con.createStatement();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}

				ResultSet rs = null;
				try {
					rs = stmt.executeQuery("    SELECT COUNT(V.v_number) as NumberOfCars, V.type_number\r\n"
							+ "		FROM Vehicle V\r\n"
							+ "		GROUP BY V.type_number\r\n"
							+ "		ORDER BY COUNT(V.v_number) DESC;\r\n"
							+ "");

					while (rs.next()) {
						toPrintReport.setText(rs.getString(1) + "    " + rs.getString(2));
						toPrintReport.setText("\n");
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			});
			


			q5.setOnAction(e -> {

				Connect();
				Statement stmt = null;
				try {
					stmt = con.createStatement();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}

				ResultSet rs = null;
				try {
					rs = stmt.executeQuery("select S.s_id, S.s_name from Student S, typeOfTeaching TOF, reserve R\r\n"
							+ "		where S.type_number = TOF.type_number AND S.s_id = R.s_id AND TOF.type_number = 1 AND R.d = 1;\r\n"
							+ "");

					while (rs.next()) {
						toPrintReport.setText(rs.getString(1) + "    " + rs.getString(2));
						toPrintReport.setText("\n");
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
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
