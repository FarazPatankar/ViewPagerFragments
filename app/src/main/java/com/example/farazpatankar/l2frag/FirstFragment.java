package com.example.farazpatankar.l2frag;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FirstFragment extends Fragment {
    private static final String KEY_POSITION="position";

    static FirstFragment newInstance(int position) {
        FirstFragment frag=new FirstFragment();
        Bundle args=new Bundle();

        args.putInt(KEY_POSITION, position);
        frag.setArguments(args);

        return(frag);
    }

    static String getTitle(Context ctxt, int position) {
        return "Hi";
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View result=inflater.inflate(R.layout.fragment_first, container, false);
        TextView editor=(TextView) result.findViewById(R.id.find_me);
        int position=getArguments().getInt(KEY_POSITION, -1);

        editor.setHint("Bye");

        return(result);
    }
}