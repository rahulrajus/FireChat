package com.leapsign.kosmos;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Date;


/**
 * Created by Rahul on 3/15/16.
 */

public class Chat {
    Firebase database;
    String url;
    String name;
    String receive;
    boolean change = false;
    Object b = null;
    public Chat(String l,String n,String r)
    {
        url = l;

        name = n;
        receive = r;
        database = new Firebase(url);
        database.addValueEventListener((new MyChildEventListener()));
        database.child("users").child(receive).child("receive").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                System.out.println("boi: " + snapshot.getValue());  //prints "Do you have data? You'll love Firebase."
                b = snapshot.getValue();
            }
            @Override public void onCancelled(FirebaseError error) { }
        });
        System.out.println("Welcome to Kosmos FireChat");

        System.out.println(new Date().toString());
      //  update(url);

    }
    public Object getChange()
    {


        System.out.println("b: " + b);
        return b;




        // Firebase database_update = new Firebase("https://aql7inf6yqv.firebaseio-demo.com/");




        //database.child("test").setValue("hey");

    }
    public void updateDatabase(String str)
    {
        database.child("users").child(name).child("receive").setValue(str);
    }

    class MyChildEventListener implements ValueEventListener
    {
        //@Override
        public void onChildAdded(DataSnapshot dataSnapshot, String s)
        {


        }

        //@Override
        public void onChildChanged(DataSnapshot dataSnapshot, String s)
        {
           // System.out.println(dataSnapshot.getValue());
            String word = "" + dataSnapshot.getValue();
            if(word.contains(name))
            {
                System.out.println(word);
                updateDatabase(word);


            }
            if(word.contains(receive))
            {
                System.out.println(word);

            }
            change = true;
    }

    // @Override
    public void onChildRemoved(DataSnapshot dataSnapshot)
    {

    }

    // @Override

        public void onChildMoved(DataSnapshot dataSnapshot, String s)
        {

        }

       // @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
           // System.out.println(dataSnapshot.getValue());
        }

      //  @Override
        public void onCancelled(FirebaseError firebaseError) {

        }
    }
}
