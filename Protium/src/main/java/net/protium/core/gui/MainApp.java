/*
 * Copyright (C) 2017 - Protium - Ussoltsev Dmitry, Jankurazov Ruslan - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package net.protium.core.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class MainApp extends Application {

	public static MenuController controller;
	public static MainApp self;

	@Override
	public void start(Stage stage) throws Exception {
		URL url = getClass().getResource("/menu.fxml");
		FXMLLoader loader = new FXMLLoader(url);
		Parent root = loader.load();
		Scene scene = new Scene(root);

		stage.setTitle("Protium Server ");
		stage.setScene(scene);
		stage.setMinWidth(600);
		stage.setMinHeight(300);
		stage.show();
		controller = loader.getController();
		controller.setMainApp(this);
		self = this;
	}
}
