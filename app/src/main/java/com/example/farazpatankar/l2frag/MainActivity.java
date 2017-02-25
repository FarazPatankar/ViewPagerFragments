package com.example.farazpatankar.l2frag;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements ScheduleFragment.OnTextSubmittedListener{
    public Fragment selectedFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_favorites:
                                selectedFragment = new FavoritesFragment();
                                break;
                            case R.id.action_schedules:
                                selectedFragment = new ScheduleFragment();
                                break;
                            case R.id.action_music:
                                selectedFragment = new MusicFragment();
                                break;

                        }
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.content_container, selectedFragment);
                        ft.commit();
                        return true;
                    }
                });
    }

    @Override
    public void onTextSubmitted(String user_input) {
        MusicFragment musicFragment = new MusicFragment();
        Bundle args = new Bundle();
        args.putString(MusicFragment.ARG_INPUT, user_input);
        musicFragment.setArguments(args);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_container, musicFragment);
        ft.commit();
    }
}
