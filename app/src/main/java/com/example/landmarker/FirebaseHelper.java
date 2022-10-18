package com.example.landmarker;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
 public class FirebaseHelper {


    private  FirebaseDatabase db;
  private  DatabaseReference dr;
  private  List<Marks> Land_Marks = new ArrayList<>();

  public  interface Satus{
      void DataIsLoaded(List<Marks> Land_Marks , List<String> keys);
      void DataIsUpdated();
      void DataIsInserted();
      void DataIsDeleted();

  }
    public FirebaseHelper() {
      db =  FirebaseDatabase.getInstance();
      dr=  db.getReference("Land Marks ");
    }


    public  void ReadMark(final Satus satus){
        dr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Land_Marks.clear();
                List<String> keys = new ArrayList<>();
                for(DataSnapshot keyNode : snapshot.getChildren()){

                    keys.add(keyNode.getKey());
                    Marks mark = keyNode.getValue(Marks.class);
                    Land_Marks.add(mark);
                }
                satus.DataIsLoaded(Land_Marks,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}
