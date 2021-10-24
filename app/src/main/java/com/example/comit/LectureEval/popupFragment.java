package com.example.comit.LectureEval;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.RatingBar;

import androidx.fragment.app.DialogFragment;

import com.example.comit.R;

public class popupFragment extends DialogFragment {

    private RatingBar ratingbar;

    private MyDialogListener myListener;
    public interface MyDialogListener {
        public void myCallback(int cityName);
    }
    public popupFragment() {

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            myListener = (MyDialogListener) getTargetFragment();
        } catch (ClassCastException e) {
            throw new ClassCastException();
        }
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.rating_popup, null))
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        RatingBar ratingbar = (RatingBar)getDialog().findViewById(R.id.popuprating);
                        int rating = ratingbar.getNumStars();
                        myListener.myCallback(rating);
                    }
                });
        return builder.create();

    }


}