package com.example.landmarker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class LandMarks extends AppCompatActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_land_marks);

        recyclerView= (RecyclerView) findViewById(R.id.List);
        new FirebaseHelper().ReadMark(new FirebaseHelper.Satus() {
            @Override
            public void DataIsLoaded(List<Marks> marks, List<String> keys) {
              new  ListViewConfig().setConfig(recyclerView,LandMarks.this,marks,keys);
            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });
    }
}