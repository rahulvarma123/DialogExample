package com.example.dialogexample;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DisplayFragment extends Fragment implements MyDialogFragment.DialogButtonListener {

    TextView tvStudentName, tvStudentUsn;
    Button btnShowDialog;
    MyDialogFragment dialogFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_display, container, false);
        tvStudentName = view.findViewById(R.id.tvStudentName);
        tvStudentUsn = view.findViewById(R.id.tvStudentUsn);
        btnShowDialog = view.findViewById(R.id.showdialog);
        dialogFragment = new MyDialogFragment();
        dialogFragment.setDialogButtonListener(this);
        btnShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //dialogFragment.setStyle(DialogFragment.STYLE_NO_FRAME, R.style.Theme_AppCompat_Light);
                dialogFragment.show(getFragmentManager(), "Alert Dialog");
            }
        });
        return view;
    }


    @Override
    public void listenToDialogButton(String name, String usn) {
        tvStudentName.setText(name);
        tvStudentUsn.setText(usn);
        /*tvMessage.setText(str);
        if (str.equals("Yes")) {
            finish();
        }*/
    }
}
