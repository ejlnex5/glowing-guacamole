package edu.miracosta.cs134.workoutapprefactored;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class WorkoutDiary extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener(){

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_search:
                    // Search fragment
                    FragmentManager fM = getFragmentManager();
                    FragmentTransaction fT = fM.beginTransaction();
                    SearchFragment f = new SearchFragment();
                    fT.add(R.id.searchFragment_container, f);
                    fT.addToBackStack(null);
                    fT.commit();
                    return true;
                case R.id.navigation_view_stats:
                    // Go to profile stats
                    Intent toStats = new Intent(WorkoutDiary.this, ProfileStatsActivity.class);
                    startActivity(toStats);
                    return true;
                case R.id.navigation_add_routine:
                    //todo
                    Intent toMenu = new Intent(WorkoutDiary.this, RecordWorkout.class);
                    startActivity(toMenu);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_diary);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);




        // Workout diary entries
        ArrayList<DiaryEntry> diaryEntries = new ArrayList<DiaryEntry>();
        diaryEntries.add(new DiaryEntry("100 Push-ups", "Do 100 push-ups.", "Easy"));
        diaryEntries.add(new DiaryEntry("100 Sit-ups", "Do 100 sit-ups.", "Moderate"));
        diaryEntries.add(new DiaryEntry("10k", "Run 10 kilometers.", "Moderate"));

        ListAdapter routineAdapter = new ArrayAdapter<DiaryEntry>(this, android.R.layout.simple_list_item_1, diaryEntries);
        ListView diaryListView = (ListView) findViewById(R.id.diary_list_view);
        diaryListView.setAdapter(routineAdapter);

        TextView entryDisplayText = (TextView) findViewById(R.id.entry_display_text);
        diaryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 DiaryEntry entry = (DiaryEntry) parent.getItemAtPosition(position);
                 //entryDisplayText.setText(entry.displayEntry());

                 Toast.makeText(WorkoutDiary.this, "JUST DO IT", Toast.LENGTH_LONG).show();
             }
         });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.workout_diary, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            //navigate to Profile Activity
        }
        else if (id == R.id.nav_manage) {
            //TODO
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void navigateToRecordWorkout(MenuItem item) {
        Intent toMenu = new Intent(this, RecordWorkout.class);
        startActivity(toMenu);
    }

    public void navigateToProfileStats(MenuItem item) {
        Intent toMenu = new Intent(this, ProfileStatsActivity.class);
        startActivity(toMenu);
    }
}
