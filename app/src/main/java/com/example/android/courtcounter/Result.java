package com.example.android.courtcounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //Get Intent
        Intent i = getIntent();
        int win = i.getIntExtra("winner", 0);

        //Checking intent value
        ImageView winn = (ImageView) findViewById(R.id.imageView4);
        String winner;
        if (win == 1){
            winner = getString(R.string.teamAScore);
            winn.setImageResource(R.drawable.det);
        }
        else if (win == 2) {
            winner = getString(R.string.teamBScore);
            winn.setImageResource(R.drawable.bkl);
        }
        else winner = getString(R.string.noWinner);



        //Showing result
        TextView resultWinner = (TextView) findViewById(R.id.resultWinner);
        resultWinner.setText(winner);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_result, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }
}
