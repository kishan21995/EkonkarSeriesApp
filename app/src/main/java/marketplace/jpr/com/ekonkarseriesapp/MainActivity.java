package marketplace.jpr.com.ekonkarseriesapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ui.AppBarConfiguration;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Spinner spinner;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private TextView eknokarSeries, knowMore;
    private MenuItem home, galleryAmerpalli, musixGallery;

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
         setSupportActionBar(toolbar);
        spinner = findViewById(R.id.spinner);


        navigationView = findViewById(R.id.nav_view);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        View headerView = navigationView.inflateHeaderView(R.layout.nav_header_main);
        eknokarSeries = headerView.findViewById(R.id.ekonkarSeries);
        knowMore = headerView.findViewById(R.id.knowMore);


        // navigation menuItem
        Menu menues = navigationView.getMenu();
        home = menues.findItem(R.id.nav_home);
        galleryAmerpalli = menues.findItem(R.id.nav_gallery_Amrapalli);
        musixGallery = menues.findItem(R.id.nav_Music_Gallery);



        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        List<String> list = new ArrayList<String>();
        list.add("Select language");
        list.add("English");
        list.add("Hindi");
        list.add("China");
        list.add("French");
        list.add("Urdu");


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        //jo hum item select kre vo spinner pe dikh jaye//
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override

            //ek jo show krana h//
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinner.setSelection(i);

            }

            @Override
            //ek jo show nhi h//
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //toolbar.setTitle("Home");
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_gallery:
                    //toolbar.setTitle("Gallery Amrapali");
                    Intent intent1 = new Intent(MainActivity.this, GalleryActivity.class);
                    startActivity(intent1);
                    return true;
                case R.id.navigation_music:
                    //toolbar.setTitle("Music Gallery");
                    Intent intent2 = new Intent(MainActivity.this, MusicActivity.class);
                    startActivity(intent2);
                    return true;
                case R.id.navigation_contact:
                    //toolbar.setTitle("Contact Us");
                    Intent intent3 = new Intent(MainActivity.this, ContactUsActivity.class);
                    startActivity(intent3);
                    return true;
            }
            return false;
        }
    };

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        int id = menuItem.getItemId();

        switch (id) {
            case R.id.nav_home:
                Intent homeIntent = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(homeIntent);
                finish();
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_gallery_Amrapalli:
                Toast.makeText(this, "Amarpalli", Toast.LENGTH_SHORT).show();
                break;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }


// use only fragment case
    private void replaceFragment(Fragment fragment) {
        try {
            FragmentManager fragmentManager = getSupportFragmentManager();
            if (fragmentManager != null) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment, fragment, "");
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.commitAllowingStateLoss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*@Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
*/


}
