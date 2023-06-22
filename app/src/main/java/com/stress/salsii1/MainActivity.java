package com.stress.salsii1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.stress.salsii1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    private Toolbar toolbar;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
//// set the Toolbar as the action bar
//        toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

    }

    private void fragmentRepl(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flame_layout, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.hearing) {
            // Handle menu item 1 selection
            Toast.makeText(this, "Listening clicked", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == R.id.login) {
            // Handle menu item 2 selection
            Toast.makeText(this, "login selected", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == R.id.logout) {
            // Handle menu item 3 selection
            Toast.makeText(this, "logout selected", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}