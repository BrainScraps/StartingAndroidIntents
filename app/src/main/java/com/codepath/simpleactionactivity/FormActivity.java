package com.codepath.simpleactionactivity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class FormActivity extends ActionBarActivity {

    EditText etAge;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        user = (User) getIntent().getSerializableExtra("user");
        etAge = (EditText) findViewById(R.id.etAge);
        etAge.setText(user.getAgeString());

        Button b = (Button) findViewById(R.id.btnSubmit);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // SUBMIT BUTTON PRESSED
                // Send back the age
                // Set the result
                Intent res = new Intent();
                etAge = (EditText) findViewById(R.id.etAge);
                user.age = Integer.parseInt(etAge.getText().toString());
                res.putExtra("user", user);
                setResult(RESULT_OK, res);
                finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_form, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
