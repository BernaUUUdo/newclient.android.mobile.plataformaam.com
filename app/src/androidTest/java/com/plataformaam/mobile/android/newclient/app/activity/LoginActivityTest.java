package com.plataformaam.mobile.android.newclient.app.activity;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;

import com.plataformaam.mobile.android.newclient.app.activities.LoginActivity;
import com.robotium.solo.Solo;
import com.plataformaam.mobile.android.newclient.app.R;

import com.robotium.solo.Condition;


public class LoginActivityTest extends ActivityInstrumentationTestCase2<LoginActivity> {
    Solo solo;

    public LoginActivityTest() {
        super(LoginActivity.class);
    }

    //Carregando as classes de testes
    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
    }

    //Liberando as classes de testes
    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }


    //Testa a abertura do Dialog com o formulário para login da plataformaAM
    public void test_dialogOpenerAfterLoginAMClickButton(){
        String dialog_title = solo.getString(R.string.title_dialog_login_am);
        Button plataformaam_login_buton = (Button) solo.getView("plataformaam_login_button");
        solo.clickOnView(plataformaam_login_buton);
        solo.waitForDialogToOpen();
        boolean dialogOpened = solo.waitForText( dialog_title);
        assertEquals("dialogOpenerAfterLoginAMClickButton", true, dialogOpened);
        solo.goBack();
    }


    //test: submeter formulário vazio para login
    public void test_emptyFormLoginAMSubimit(){
        Button openDialogButton = (Button) solo.getView("plataformaam_login_button");
        solo.clickOnView(openDialogButton);
        solo.waitForDialogToOpen();

        Button loginSubmitButton = (Button) solo.getView("plataformaam_do_login_button");
        solo.clickOnView(loginSubmitButton);

        solo.clearEditText((EditText) solo.getView(R.id.etxLoginUserLoginUI ));
        solo.clearEditText( (EditText) solo.getView(R.id.etxPasswordUserLoginUI));
        waitForToast("test_emptyFormLoginAMSubimit", solo.getString(R.string.errorLoginFail));
        solo.goBack();
    }


    //test: usar password errado.
    public void test_FormLoginAMWrongPassword(){
        Button openDialogButton = (Button) solo.getView("plataformaam_login_button");
        solo.clickOnView(openDialogButton);
        solo.waitForDialogToOpen();
        solo.enterText((EditText) solo.getView(  R.id.etxLoginUserLoginUI ),"login_errado");
        solo.enterText((EditText) solo.getView(  R.id.etxPasswordUserLoginUI ),"senha_errada");
        Button loginSubmitButton = (Button) solo.getView("plataformaam_do_login_button");
        solo.clickOnView(loginSubmitButton);
        waitForToast("test_FormLoginAMWrongPassword",solo.getString(R.string.errorLoginFail));
        solo.goBack();

    }

    //test: Login efetuado e usuário redirecionado.
    public void test_LoginAMSucefull(){
        //Open ogin dialog form
        Button openDialogButton = (Button) solo.getView("plataformaam_login_button");
        solo.clickOnView(openDialogButton);
        solo.waitForDialogToOpen();
        //
        solo.enterText((EditText) solo.getView(R.id.etxLoginUserLoginUI), "teste");
        solo.enterText((EditText) solo.getView(R.id.etxPasswordUserLoginUI), "1234");
        //Try the login
        Button loginSubmitButton = (Button) solo.getView("plataformaam_do_login_button");
        solo.clickOnView(loginSubmitButton);
        //Wait for the activity
        solo.waitForActivity("AfterLoginUI");
        solo.assertCurrentActivity("AfterLoginUI não encontrado ", "AfterLoginUI");
        solo.goBack();
        //assertTrue("Login efetuado e usuário redirecionado.", activityOpen);

    }



    private void waitForToast(final String message, final String text) {
        Condition textNotFound = new Condition() {

            @Override
            public boolean isSatisfied() {
                return !solo.searchText(text);
            }
        };
        assertTrue(message + " => " + text, solo.waitForCondition(textNotFound, 2000));
    }






}
