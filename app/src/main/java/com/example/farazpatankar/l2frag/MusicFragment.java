package com.example.farazpatankar.l2frag;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MusicFragment extends Fragment {

    public final static String ARG_INPUT="no input yet";


    public MusicFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View result=inflater.inflate(R.layout.fragment_music, container, false);
        ViewPager pager=(ViewPager)result.findViewById(R.id.pager);

        pager.setAdapter(buildAdapter());

        return(result);
    }

    private PagerAdapter buildAdapter() {
        return(new SampleAdapter(getActivity(), getChildFragmentManager()));
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        if (getArguments() != null) {
            Bundle bundle = getArguments();
            String user_input = getArguments().getString(ARG_INPUT);
            FirstFragment firstFragment = (FirstFragment) getChildFragmentManager().findFragmentById(R.id.first_fragment);
            firstFragment.TEXT_TO_DISPLAY = user_input;

        }
        super.onViewCreated(view, savedInstanceState);
    }
}
