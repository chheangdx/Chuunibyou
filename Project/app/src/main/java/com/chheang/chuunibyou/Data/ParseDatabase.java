package com.chheang.chuunibyou.Data;

import android.util.Log;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 12/22/2015.
 */
public class ParseDatabase {
    private static final String[] databases = {"UserBase", "StoryBase", "ClassBase", "WeaponBase", "AbilityBase", "FriendsBase"};
    private Data user;

    public ParseDatabase(Data user){
        this.user = user;
    }

    //PreCondition: database to parse, and the Data to be updated
    //PostCondition: data is updated in the background
    public void updateData(int database, final Data data){
        if(data.getId().equals("")){ //using this method to know that the data is new is faster than searching if it already exists
            //this is new data
            ParseObject testObject = new ParseObject(databases[database]);

            testObject.put("Name", data.getName());
            testObject.put("Description", data.getDescription());
            try{ //save on main thread so that we can access the data immediately without errors
                testObject.save();
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            //this is old data that needs to be updated
            ParseQuery<ParseObject> query = ParseQuery.getQuery(databases[database]);

            // Retrieve the object by id
            query.getInBackground(data.getId(), new GetCallback<ParseObject>() {
                public void done(ParseObject group, ParseException e) {
                    if (e == null) {
                        // Now let's update it with some new data. In this case, only cheatMode and score
                        // will get sent to the Parse Cloud. playerName hasn't changed.
                        group.put("Name", data.getName());
                        group.put("Description", data.getDescription());
                        group.saveInBackground();
                        //this data can be saved in the background because we already have all the data ourselves
                    }
                }
            });
        }
    }

    //PreCondition: database to parse, and the id of the parent data or user
    //PostCondition: data collected as a array list
    public ArrayList<Data> retrieveListData(int database, String id){
        ArrayList<Data> list = new ArrayList<Data>();

//        ParseQuery<ParseObject> query = ParseQuery.getQuery(databases[database]);
//        query.whereEqualTo("Name", name);
//        try {
//            List<ParseObject> objects = query.find();
//            for (int i = 0; i < objects.size(); i++) {
//                ParseObject object = objects.get(i);
//                Data data = new Data();
//                data.setBitmap(object.getInt("Bitmap"));
//                data.setName(object.getString("Name"));
//                data.setAdminID(object.getString("AdminID"));
//                data.setDescription(object.getString("Description"));
//                data.setGroupID(object.getObjectId());
//                data.setGroupFunds(object.getDouble("GroupFunds"));
//                data.setPayHistory(object.getString("PayHistory"));
//                data.setTreasurerID(object.getString("TreasurerID"));
//                list.add(data);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return list;
    }

    //Finds a specific data
    //PreCondition: an object ID
    //PostCondition: data corresponding to that ID
    public Data retrieveData(int database, String objectID){
        Data data = new Data();

        ParseQuery<ParseObject> query = ParseQuery.getQuery(databases[database]);
        Log.d("Database", "Searching for " + objectID);
        query.whereEqualTo("objectId", objectID);
        try {
            ParseObject object = query.getFirst();
            Log.d("Database", "Data found!");
            data.setName(object.getString("Name"));
            data.setDescription(object.getString("Description"));
            data.setId(object.getObjectId());
            data.setDate(object.getCreatedAt());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

}
