package com.example.farazpatankar.l2frag;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScheduleFragment extends Fragment {
    OnTextSubmittedListener mCallback;


    public ScheduleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_schedule, container, false);


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        Button submit_button = (Button) getView().findViewById(R.id.submit_input);
        submit_button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText user_input = (EditText) getView().findViewById(R.id.user_input);
                mCallback.onTextSubmitted(user_input.getText().toString());
            }
        });
//        super.onViewCreated(view, savedInstanceState);
    }

    public interface OnTextSubmittedListener {
        public void onTextSubmitted(String user_input);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback = (OnTextSubmittedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }
}
