package com.plataformaam.mobile.android.newclient.app;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class LoginUI extends ActionBarActivity {

    final Context context = this;
    LoginButton facebook_login_button;
    Button plataformaam_login_button;
    Button plataformaam_do_login_Button;
    CallbackManager callbackManager;





    @Override
    protected void onResume() {
        super.onResume();
        // Logs 'install' and 'app activate' App Events.
        AppEventsLogger.activateApp(this);
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Logs 'app deactivate' App Event.
        AppEventsLogger.deactivateApp(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_login_ui, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
        //    return true;
        //}

        return super.onOptionsItemSelected(item);
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.activity_login_ui);

        prepareFacebookLogin();
        preparePlataformaAMLogin();


    }


    @Nullable
    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {


        //TODO

        return super.onCreateView(name, context, attrs);
    }

    private void prepareFacebookLogin(){
        facebook_login_button = (LoginButton)findViewById(R.id.facebook_login_button);
        facebook_login_button.setReadPermissions("user_friends");

        facebook_login_button.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast.makeText(getApplicationContext(),"Facebook Login Done ! ",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(),"Facebook Login has Canceled ! ",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException e) {
                Toast.makeText(getApplicationContext(),"Facebook Login Error ",Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        });


    }

    private void preparePlataformaAMLogin(){
        plataformaam_login_button = (Button) findViewById(R.id.plataformaam_login_button);
        plataformaam_login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginAMDialog();
            }
        });

    }

    public void openLoginAMDialog(){
        // inspired by http://www.mkyong.com/android/android-custom-dialog-example/
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_login_am);
        dialog.setTitle(getString(R.string.title_dialog_login_am));

        Button dialog_do_login_button =  (Button) dialog.findViewById(R.id.plataformaam_do_login_button);
        dialog_do_login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
                Toast.makeText(getApplicationContext(), "TODO login ", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }

    public void doLoginAM(String login,String password){

    }



    public void goToAfterLoginUI(){
        Intent intent = new Intent( LoginUI.this, AfterLoginUI.class);
        startActivity(intent);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
