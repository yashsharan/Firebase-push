package com.example.android.firebasepush;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference mRef = FirebaseDatabase.getInstance().getReference();
    private EditText mNameText;
    private EditText mNumberText;
    private Button mSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Layout child ids
        mNameText = (EditText)findViewById(R.id.editText);
        mNumberText = (EditText)findViewById(R.id.editText2);
        mSubmit = (Button)findViewById(R.id.button);

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Model model = new Model(
                        mNameText.getText().toString(),
                        mNumberText.getText().toString());

                HashMap<String,Object> temp = model.toMap();

                String uniqueID = mRef.child("Forms").push().getKey();

                HashMap<String,Object> mapFirebase = new HashMap<String, Object>();

                mapFirebase.put("Forms/" + uniqueID,temp);

                mRef.updateChildren(mapFirebase);




            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
