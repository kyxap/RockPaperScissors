package io.github.kyxap.rockpaperscissors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Opens Game Rules
     */
    public void openRules(View view) {
        Intent intent = new Intent(this, DisplayGameRules.class);
        startActivity(intent);
    }

    /**
     * Starts Game
     */
    public void openGame(View view) {
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);
    }
}
