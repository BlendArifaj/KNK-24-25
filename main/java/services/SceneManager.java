package services;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import utils.SceneLocator;

public class SceneManager {
    private static SceneManager sceneManager;
    private static final String DEFAULT_START_PAGE = SceneLocator.LOGIN_PAGE;
    private Scene scene;
    private LanguageManager languageManager;
    private String currentPath;
    private Pane currentPane;

    private SceneManager(){
        this.languageManager = LanguageManager.getInstance();
        this.scene = this.initScene();
    }

    public static SceneManager getInstance(){
        if(sceneManager == null)
            sceneManager = new SceneManager();
        return sceneManager;
    }

    private Scene initScene(){
        try{
            return new Scene(this.getParent(getPath()));
        }catch (Exception e){
            return null;
        }
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
        this.currentPath = path;
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
        loader.setResources(this.languageManager.getResourceBundle());
        return loader.load();
    }

    public static void reload() throws Exception{
        if(sceneManager.currentPane != null){
            load(sceneManager.getPath(), sceneManager.currentPane);
        }
        load(sceneManager.getPath());
    }

    public Scene getScene() {
        return scene;
    }

    private String getPath(){
        if(this.currentPath == null){
            return DEFAULT_START_PAGE;
        }
        return this.currentPath;
    }
}
