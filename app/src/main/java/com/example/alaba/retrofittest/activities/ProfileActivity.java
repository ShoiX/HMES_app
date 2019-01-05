package com.example.alaba.retrofittest.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.alaba.retrofittest.R;
import com.example.alaba.retrofittest.fragments.HomeFragment;
import com.example.alaba.retrofittest.fragments.RoomDetailFragment;
import com.example.alaba.retrofittest.fragments.SettingsFragment;
import com.example.alaba.retrofittest.fragments.UserFragment;
import com.example.alaba.retrofittest.models.Room;
import com.example.alaba.retrofittest.models.User;
import com.example.alaba.retrofittest.storage.SPManager;

public class ProfileActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private TextView textView;
    private RoomDetailFragment roomDetailFragment;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        BottomNavigationView navigationView = findViewById(R.id.bottom_nav);
        navigationView.setOnNavigationItemSelectedListener(this);
        roomDetailFragment = new RoomDetailFragment();
        displayFragment(new HomeFragment());
    }

    private void displayFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.containerdiv, fragment)
                .commit();

    }

    @Override
    protected void onStart() {
        super.onStart();

        /*if (!SPManager.getInstance(this).isLogged()){
            Intent intent = new Intent(this, SignUpActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }*/
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Fragment fragment = null;
        switch (menuItem.getItemId()){
            case R.id.menu_home:
                fragment = new HomeFragment();
                break;
            case R.id.menu_users:
                fragment = new UserFragment();
                break;
            case R.id.menu_settings:
                fragment = new SettingsFragment();
                break;
        }
        if (fragment != null){
            displayFragment(fragment);
        }
        return false;
    }

    public void viewRoom(Room room){
        roomDetailFragment.setCurRoom(room);
        displayFragment(roomDetailFragment);
    }
}
