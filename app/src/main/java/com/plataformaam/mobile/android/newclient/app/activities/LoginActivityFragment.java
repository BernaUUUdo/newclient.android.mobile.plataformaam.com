package com.plataformaam.mobile.android.newclient.app.activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.plataformaam.mobile.android.newclient.app.AfterLoginUI;
import com.plataformaam.mobile.android.newclient.app.R;
import com.plataformaam.mobile.android.newclient.app.activities.dialogs.LoginFormDialogFragment;

/**
 * A placeholder fragment containing a simple view.
 */
public class LoginActivityFragment extends Fragment {
    View rootView;
    //Plataforma AM Login
    Button doLoginAMDialogButton;
    EditText etxLogin;
    EditText etxPassword;
    Button plataformaam_login_button;


    public LoginActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView =inflater.inflate(R.layout.fragment_login, container, false);
        preparePlataformaAMLogin();
        return rootView;
    }



    private void preparePlataformaAMLogin(){
        plataformaam_login_button = (Button) rootView.findViewById(R.id.plataformaam_login_button);
        plataformaam_login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginAMDialog();
            }
        });

    }


    public void openLoginAMDialog(){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("LoginFormDialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);
        LoginFormDialogFragment dialog = LoginFormDialogFragment.newInstance(this);
        dialog.show(ft,"LoginFormDialog");
    }


    public void doLoginAM(String login,String password){
        //TODO - Implement login
        //doLoginAMDialogButton.setEnabled(false);
        if( login.equals("teste") && password.equals("1234")){
            goToAfterLoginUI();
        }else{
           //doLoginAMDialogButton.setEnabled(true);
            Toast.makeText(getActivity(),getString(R.string.errorLoginFail),Toast.LENGTH_SHORT).show();
        }
    }

    public void goToAfterLoginUI(){
        Intent intent = new Intent( getActivity(), AfterLoginUI.class);
        startActivity(intent);
    }



}
