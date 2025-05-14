package services;

import models.User;

public class SessionManager {
    private static SessionManager instance;
//    Anetaret e Sessionit
    private User user;
    private String theme;

    private SessionManager(){
        this.theme = "default";
    }

    public static SessionManager getInstance(){
        if(instance == null){
            instance = new SessionManager();
        }
        return instance;
    }

    public void setCurrentUser(User user){
        this.user = user;
    }

    public User getCurrentUser(){
        return this.user;
    }
}
