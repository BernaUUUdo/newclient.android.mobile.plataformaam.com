package com.plataformaam.mobile.android.newclient.app.session;

import android.support.test.runner.AndroidJUnit4;

import com.plataformaam.mobile.android.newclient.app.models.User;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class SessionManagerTest {

    @Before
    public void setUp(){

    }

    @After
    public void tearDown(){

    }

    //Testa se o login foi feito
    @Test
    public void test_doLogin(){
        SessionManager sessionManager = SessionManager.getInstance();
        User user = new User();
        sessionManager.doLogin(user);
        Assert.assertTrue(sessionManager.isLogged());
    }

    //Testa se o Logout foi feito
    @Test
    public void test_doLogout(){
        SessionManager sessionManager = SessionManager.getInstance();
        User user = new User();
        sessionManager.doLogin(user);
        Assert.assertTrue(sessionManager.isLogged());
        sessionManager.doLogut();
        Assert.assertFalse(sessionManager.isLogged());

    }

    //Teste a obtenção de um usuário com o sistema logado
    @Test
    public void test_getLoggedUser(){
        SessionManager sessionManager = SessionManager.getInstance();
        User user = new User();
        user.setId(1);
        sessionManager.doLogin(user);
        Assert.assertTrue(sessionManager.isLogged());
        User verifyUser = SessionManager.getInstance().getLoggedUser();
        Assert.assertEquals(user.getId(), verifyUser.getId());
    }




}
