package services;

import group_03.java_10.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class SceneManager {
    private static SceneManager sceneManager;
    private Scene scene;

    private SceneManager(Scene scene){
        this.scene = scene;
    }

    public static void initialize(Scene scene){
        sceneManager = new SceneManager(scene);
    }

    public static void load(String path) throws Exception{
        if(sceneManager == null){
            throw new Exception("Scene manager is not initialized yet!");
        }
        sceneManager.loadParent(path);
    }
    public static void load(String path, Pane pane) throws Exception{
        if(sceneManager == null){
            throw new Exception("Scene manager is not initialized yet!");
        }
        sceneManager.loadParent(path, pane);
    }

    private void loadParent(String path) throws Exception{
        Parent parent = getParent(path);
        scene.setRoot(parent);
    }

    private void loadParent(String path, Pane pane) throws Exception{
        pane.getChildren().clear();

        Parent parent = getParent(path);
        pane.getChildren().add(parent);
    }

    private Parent getParent(String path) throws Exception{
        FXMLLoader loader = new FXMLLoader(
                this.getClass().getResource(path)
        );
        return loader.load();
    }
}
