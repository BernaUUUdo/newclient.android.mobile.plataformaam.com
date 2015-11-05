package com.plataformaam.mobile.android.newclient.app.helpers;

import com.robotium.solo.Condition;
import com.robotium.solo.Solo;

/**
 * Created by bernard on 04/11/2015.
 */
public class ToastHelper {
    public static Condition generateWaitForToastCondition(final Solo solo, final String text){
        Condition textNotFound = new Condition() {

            @Override
            public boolean isSatisfied() {
                return !solo.searchText(text);
            }
        };
        return  textNotFound;
    }
}
