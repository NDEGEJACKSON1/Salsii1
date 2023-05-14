package com.stress.salsii1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.stress.salsii1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //fragmentRepl(new HomeFragment());
        BottomNavigationView btnView = findViewById(R.id.btnNav);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.flame_layout, new HomeFragment())
                .commit();

        binding.btnNav.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragmentRepl(new HomeFragment());
                    break;

                case R.id.navigation_notifications:
                    fragmentRepl(new NotificationFragment());
                    break;

                case R.id.settings:
                    fragmentRepl(new SettingFragment());
                    break;

                case R.id.navigation_profile:
                    fragmentRepl(new ProfileFragment());
                    break;
            }
            return true;
        });
    }

    private void fragmentRepl(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flame_layout, fragment);
        fragmentTransaction.commit();
    }
}