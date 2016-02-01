package com.erminesoft.my_account.myacount.ui.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;


import com.erminesoft.my_account.myacount.ui.MainActivity;
import com.erminesoft.my_account.myacount.R;

public class RegistrationDialog extends DialogFragment{

    final String LOG_TAG = "myLog";

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Log.d(LOG_TAG, "Start"+"Dialog");
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.move_to_next)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Log.d(LOG_TAG, "Start" + "Dialog_Set_True");
                        MainActivity activity = (MainActivity) getActivity();
                        activity.write(0);

                    }
                })
                .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MainActivity activity = (MainActivity) getActivity();
                        activity.finish();
                    }
                });
        return builder.create();
    }
}

