package com.example.farazpatankar.l2frag;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FirstFragment extends Fragment {
    private static final String KEY_POSITION="position";
    public static String TEXT_TO_DISPLAY="nothing to see here";

    static FirstFragment newInstance(int position) {
        FirstFragment frag=new FirstFragment();
        Bundle args=new Bundle();

        args.putInt(KEY_POSITION, position);
        args.putString(TEXT_TO_DISPLAY, TEXT_TO_DISPLAY);
        frag.setArguments(args);

        return(frag);
    }

    static String getTitle(Context ctxt, int position) {
        if (position == 0) {
            return "Physics";
        } else if (position == 1) {
            return "Chemistry";
        } else {
            return "Maths";
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View result=inflater.inflate(R.layout.fragment_first, container, false);
        TextView editor=(TextView) result.findViewById(R.id.find_me);
        if (getArguments() != null) {

            int position=getArguments().getInt(KEY_POSITION, -1);
            String user_input = getArguments().getString((TEXT_TO_DISPLAY));
            if (position == 0) {
                editor.setHint("P --- " + user_input);
            } else if (position == 1) {
                editor.setHint("C --- " + user_input.toUpperCase());
            } else {
                editor.setHint("M --- " + user_input.toLowerCase());
            }
        }

        return(result);
    }
}