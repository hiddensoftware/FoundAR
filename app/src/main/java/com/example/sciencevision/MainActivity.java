package com.example.sciencevision;


import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.sciencevision.fragments.FindingFragment;
import com.example.sciencevision.fragments.ProfileFragment;
import com.example.sciencevision.fragments.SocialFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FragmentManager fragmentManager = getSupportFragmentManager();

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        // define your fragments here
        final Fragment fragmentFinding = new FindingFragment();
        final Fragment fragmentProfile = new ProfileFragment();
        final Fragment fragmentSocial = new SocialFragment();

        // handle navigation selection
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment fragment;
                        switch (item.getItemId()) {
                            case R.id.action_finding:
                                fragment = fragmentFinding;
                                break;
                            case R.id.action_profile:
                                fragment = fragmentProfile;
                                break;
                            case R.id.action_social:
                                fragment = fragmentSocial;
                                break;
                            default:
                                fragment = fragmentProfile;
                                break;
                        }
                        fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                        return true;
                    }
                });
        // Set default selection
        bottomNavigationView.setSelectedItemId(R.id.action_profile);
    }
}