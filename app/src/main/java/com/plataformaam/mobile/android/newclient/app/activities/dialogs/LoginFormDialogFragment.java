package com.plataformaam.mobile.android.newclient.app.activities.dialogs;


import android.os.Bundle;

import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.plataformaam.mobile.android.newclient.app.R;
import com.plataformaam.mobile.android.newclient.app.activities.LoginActivityFragment;



public class LoginFormDialogFragment extends DialogFragment {
    View v;
    Button doLoginButton;
    EditText etxLogin;
    EditText etxPassword;
    LoginActivityFragment fragment;

    public LoginFormDialogFragment() {
    }

    public static LoginFormDialogFragment newInstance(LoginActivityFragment fragment){
        LoginFormDialogFragment dialog = new LoginFormDialogFragment();
        dialog.fragment = fragment;

        return dialog;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.dialog_login_am, container, false);
        etxLogin = (EditText) v.findViewById(R.id.etxLoginUserLoginUI);
        etxPassword = (EditText) v.findViewById(R.id.etxPasswordUserLoginUI);
        doLoginButton =  (Button) v.findViewById(R.id.plataformaam_do_login_button);
        doLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment.doLoginAM(etxLogin.getText().toString(), etxPassword.getText().toString());
            }
        });
        getDialog().setTitle( getString(R.string.title_dialog_login_am) );
        return v;

    }


}
