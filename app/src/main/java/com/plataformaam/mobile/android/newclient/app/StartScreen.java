package com.plataformaam.mobile.android.newclient.app;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class StartScreen extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        goToLogin();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        // int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        // if (id == R.id.action_settings) {            return true;        }
        return super.onOptionsItemSelected(item);
    }


    public void goToLogin(){
        Intent intent = new Intent(StartScreen.this,LoginUI.class);
        startActivity(intent);
    }
}
