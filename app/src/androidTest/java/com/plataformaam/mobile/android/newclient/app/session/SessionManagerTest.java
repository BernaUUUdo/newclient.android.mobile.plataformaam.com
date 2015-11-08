package com.plataformaam.mobile.android.newclient.app.session;

import com.plataformaam.mobile.android.newclient.app.models.User;

import junit.framework.TestCase;

/**
 * Created by bernard on 08/11/2015.
 */
public class SessionManagerTest extends TestCase {

    public void setUp(){

    }

    public void tearDown(){

    }

    //Testa se o login foi feito
    public void test_doLogin(){
        SessionManager sessionManager = SessionManager.getInstance();
        User user = new User();
        sessionManager.doLogin(user);
        assertTrue( sessionManager.isLogged() );
    }

    //Testa se o Logout foi feito
    public void test_doLogout(){
        SessionManager sessionManager = SessionManager.getInstance();
        User user = new User();
        sessionManager.doLogin(user);
        assertTrue(sessionManager.isLogged());
        sessionManager.doLogut();
        assertFalse(sessionManager.isLogged());

    }

    //Teste a obtenção de um usuário com o sistema logado
    public void test_getLoggedUser(){
        SessionManager sessionManager = SessionManager.getInstance();
        User user = new User();
        user.setId(1);
        sessionManager.doLogin(user);
        assertTrue( sessionManager.isLogged() );
        User verifyUser = SessionManager.getInstance().getLoggedUser();
        assertEquals(user.getId(), verifyUser.getId() );
    }




}
