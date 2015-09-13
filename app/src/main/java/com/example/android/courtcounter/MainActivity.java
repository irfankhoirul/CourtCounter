package com.example.android.courtcounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA = 0, scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Merest score menjadi 0
     */
    public void resetScore(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    /**
     * Menampilkan hasil / result dan memanggil activity result dg intent
     * Jika pemenang adalah tim A, data extra = 1
     * Jika pemenang adalah tim B, data extra = 2
     * Jika seri, data ekstra = 0
     */
    public void result(View view) {
        // Call Intent to show result winner
        Intent i = new Intent(this, Result.class);
        if (scoreTeamA > scoreTeamB) {
            i.putExtra("winner", 1);
        }
        else if (scoreTeamB > scoreTeamA) {
            i.putExtra("winner", 2);
        }
        else {
            i.putExtra("winner", 0);
        }
        startActivity(i);
        resetScore(view);
    }

    /**
     * Menambah skor tim A + 3
     */
    public void teamAPlus3(View view) {
        scoreTeamA += 3;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Menambah skor tim A + 2
     */
    public void teamAPlus2(View view) {
        scoreTeamA += 2;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Menambah skor tim A + 1
     */
    public void teamAFreeThrow(View view) {
        scoreTeamA += 1;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Menambah skor tim B + 3
     */
    public void teamBPlus3(View view) {
        scoreTeamB += 3;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Menambah skor tim B + 2
     */
    public void teamBPlus2(View view) {
        scoreTeamB += 2;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Menambah skor tim B + 1
     */
    public void teamBFreeThrow(View view) {
        scoreTeamB += 1;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Menampilkan skor tim A saat ini
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Menampilkan skor tim B saat ini
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
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
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }
}
