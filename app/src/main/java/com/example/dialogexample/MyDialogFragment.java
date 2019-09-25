package com.example.dialogexample;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyDialogFragment extends DialogFragment {

    DialogButtonListener dialogButtonListener; // declaration

    Button btnShow;
    Button btnClear;

    EditText etStName, etStUsn;

    public MyDialogFragment() {
        // Required empty public constructor
    }

    /*@Override
    public void onAttach(Context context) {
        super.onAttach(context);
        dialogButtonListener = (DialogButtonListener) context;
    }*/

    public void setDialogButtonListener(DialogButtonListener listener) {
        dialogButtonListener = listener;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_dialog, container, false);
        btnShow = view.findViewById(R.id.btnShow);
        btnClear = view.findViewById(R.id.btnClear);
        etStName = view.findViewById(R.id.etStName);
        etStUsn = view.findViewById(R.id.etStUsn);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stName = etStName.getText().toString();
                String stUsn = etStUsn.getText().toString();
                dialogButtonListener.listenToDialogButton(stName, stUsn);
                getDialog().dismiss();
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etStName.setText("");
                etStUsn.setText("");
            }
        });
        return view;
    }

    /*@NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Exit From Application");
        builder.setMessage("Do you want to close Application?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getContext(), "Yes Pressed", Toast.LENGTH_SHORT).show();
                dialogButtonListener.listenToDialogButton("Yes");
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getContext(), "No Pressed", Toast.LENGTH_SHORT).show();
                dialogButtonListener.listenToDialogButton("No");
            }
        });
        AlertDialog alertDialog = builder.create();
        return alertDialog;
    }*/

    interface DialogButtonListener {
        public void listenToDialogButton(String name, String usn);
    }
}
