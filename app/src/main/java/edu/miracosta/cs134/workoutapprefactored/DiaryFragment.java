package edu.miracosta.cs134.workoutapprefactored;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class DiaryFragment extends Fragment {

    public DiaryFragment() {
        //REQUIRED PUBLIC CONSTRUCTOR
    }

    @Override
    public View onCreateView(LayoutInflater inflator, ViewGroup container,
                         Bundle savedInstanceState) {
        View view = inflator.inflate(R.layout.fragment_workout_diary, container, false);
        String[] diaryEntries = {"ENTRY 1", "ENTRY 2", "ENTRY 3"};

        //ListView listView = (ListView) view.findViewById(R.id.);

        return view;
    }
}
