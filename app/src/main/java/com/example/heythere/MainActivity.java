package com.example.heythere;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    private static final String TOTAL_COUNT = "total_count";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * Show a toast
     * @param view -- the view that is clicked, the view that receives the click event
     */
    public void toastMe(View view) {
        Toast myToast = Toast.makeText(this, "Hello Person!!", Toast.LENGTH_SHORT);
        myToast.show();
    }

    public void incrementCount(View view) {
        // get the text view
        TextView showCountTextView = (TextView) findViewById(R.id.textView2);
        // get the value of the text view
        String countString = showCountTextView.getText().toString();
        // int_of_string = Integer.parseInt
        Integer count = Integer.parseInt(countString);
        count++;
        showCountTextView.setText(count.toString());
    }

    public void randomMe(View view) {
        // create an intent to start the second activity
        // parameters: package context and the component class to be used for the intent
        Intent randomIntent = new Intent(this, SecondActivity.class);
        // get the text view that contains the count
        TextView countView = (TextView) findViewById(R.id.textView2);
        // extract its value
        // Remember that textview.getText() returns a CharSequence. gotta convert to string!
        String count = countView.getText().toString();
        // convert the count to an int
        int countnum = Integer.parseInt(count);
        // add the count to the extras for Intent.
        randomIntent.putExtra(TOTAL_COUNT, countnum);
        startActivity(randomIntent);
    }


}
