package com.example.farazpatankar.l2frag;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritesFragment extends Fragment {


    public final static String ARG_INPUT="no input yet";

    public FavoritesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorites, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        if (getArguments() != null) {
            Bundle bundle = getArguments();
            String user_input = getArguments().getString(ARG_INPUT);
            TextView tv = (TextView) getView().findViewById(R.id.fav_text);
            tv.setText(user_input);
        }
        super.onViewCreated(view, savedInstanceState);
    }
}
