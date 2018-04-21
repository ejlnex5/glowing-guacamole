package edu.miracosta.cs134.workoutapprefactored;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NewUserEntry extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user_entry);
    }

/*    Button firstChild = (Button) findViewById(R.id.WorkoutDiary);
    firstChild.setOnClickListener(new View.OnClickListener()) {
        @Override
        public void OnClick(View v) {
            Intent intent = new Intent(getApplicationContext(), WorkoutDiary.class);
            startActivity(intent);
        }
    });
*/

    public void navigateToMenu(View view) {

        Intent toMenu = new Intent(this, WorkoutDiary.class);
        startActivity(toMenu);
    }

}
