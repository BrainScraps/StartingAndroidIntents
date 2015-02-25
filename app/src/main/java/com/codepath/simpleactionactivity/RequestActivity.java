package com.codepath.simpleactionactivity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class RequestActivity extends ActionBarActivity {

    public static final int FORM_REQUEST_CODE = 1337;
    public static final int NEW_REQUEST_CODE = 1234;
    public User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        user = new User();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_request, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.miRequest) {
            //Three step process to make an intent
            // 1. Construct the intent (where you want to go)
            Intent i = new Intent(this, FormActivity.class);
            // 2. Pass the bundle (query string)
            i.putExtra("user", user);
            // 3. Execute the intent (like launching the request
            startActivityForResult(i, FORM_REQUEST_CODE);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == FORM_REQUEST_CODE){
            if (resultCode == RESULT_OK) {
                // RESULT IS READY AND TYPE
                user = (User) data.getSerializableExtra("user");
                if (user.canDrink()){
                    Toast.makeText(this, "Party On!", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(this, "No drink for you!", Toast.LENGTH_SHORT).show();


                }
                Toast.makeText(this, "Result!!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
