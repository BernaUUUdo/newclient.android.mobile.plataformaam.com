package com.plataformaam.mobile.android.newclient.app.session;
import com.plataformaam.mobile.android.newclient.app.models.User;

public class SessionManager {
    //Singleton
    private static SessionManager instance;
    protected User loggedUser;

    public static SessionManager getInstance(){
        if( instance == null ){
            instance = new SessionManager();
        }
        return instance;
    }

    public SessionManager() {
    }

    public void doLogin(User user){
        loggedUser = user;
    }

    public void doLogut(){
        loggedUser = null;
    }

    public boolean isLogged(){
        if( loggedUser == null ){
            return false;
        }else {
            return true;
        }
    }

    public User getLoggedUser() {
        return loggedUser;
    }


}
