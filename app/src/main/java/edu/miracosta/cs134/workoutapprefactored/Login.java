package edu.miracosta.cs134.workoutapprefactored;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


    public void navigateToDiary(View view) {
        Intent navi = new Intent(this,WorkoutDiary.class);
        startActivity(navi);
    }

    public void navigateToNewUserEntry(View view) {
        Intent navi = new Intent(this,NewUserEntry.class);
        startActivity(navi);
    }
}
