package com.chheang.chuunibyou.Data;

import com.chheang.chuunibyou.R;
import com.firebase.client.Firebase;

/**
 * Created by User on 1/31/2016.
 */
public class FirebaseDB {
    private Firebase rootRef;

    public FirebaseDB(){
        rootRef = new Firebase("https://chuunibyou.firebaseio.com/android/data");
    }
}
