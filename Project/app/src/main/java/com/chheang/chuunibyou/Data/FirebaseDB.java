package com.chheang.chuunibyou.Data;

import android.util.Log;

import com.chheang.chuunibyou.R;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

/**
 * Created by User on 1/31/2016.
 */
public class FirebaseDB {
    private Firebase rootRef;
    private static final String[] databases = {"UserBase", "StoryBase", "ClassBase", "WeaponBase", "AbilityBase", "FriendsBase"};

    public FirebaseDB(){
        rootRef = new Firebase("https://chuunibyou.firebaseio.com/android/data");
    }

    public void save(int database, Data data){
        Firebase ref = rootRef.child(databases[database]).child(data.getName());
        ref.setValue(data);
    }

    public Data retrieve(int database, String name){
//        Firebase ref = rootRef.child(databases[database]).child(name);
//
//        ref.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot snapshot) {
//                // do some stuff once
//            }
//            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//                Log.d("Data Retrieval", "Unable to retrieve data");
//            }
//        });

        return null;
    }

}
