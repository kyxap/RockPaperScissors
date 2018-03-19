package io.github.kyxap.rockpaperscissors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Game extends AppCompatActivity {

    String[] gameChoices;
    String aiChoice;
    String yourChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // get string label from button to create array with possible choices
        gameChoices = new String[]{
                getResources().getString(R.string.button_scissors),
                getResources().getString(R.string.button_paper),
                getResources().getString(R.string.button_rock)
        };
    }

    public void selectRock(View view) {
        Button button = findViewById(R.id.button_rock);
        setLabelYourChoice(button.getText().toString());
    }

    public void selectPaper(View view) {
        Button button = findViewById(R.id.button_paper);
        setLabelYourChoice(button.getText().toString());
    }

    public void selectScissors(View view) {
        Button button = findViewById(R.id.button_scissors);
        setLabelYourChoice(button.getText().toString());
    }

    /**
     * Sets Label and enables Play Button
     */
    private void setLabelYourChoice(String yourChoice) {
        TextView textView = findViewById(R.id.label_your_choice);
        textView.setText(yourChoice);
        this.yourChoice = yourChoice;
        Button button_play = findViewById(R.id.button_play);
        button_play.setVisibility(View.VISIBLE); //todo maybe check if it visible
    }


    public void play(View view) {
        aiChoice = getRandomChoiceAI();
        TextView label_ai_choice = findViewById(R.id.label_ai_choice);
        label_ai_choice.setText(aiChoice);
        TextView label_who_won = findViewById(R.id.label_who_won);


        // Todo: Main Logic, Refactor and move out
        if (yourChoice.equals(aiChoice)) {
            String draw = "DRAW! Please Re-Choice"; // todo move to string
            label_who_won.setText(draw);
            label_who_won.setVisibility(View.VISIBLE);
        } else if (yourChoice.equals(gameChoices[0]) && aiChoice.equals(gameChoices[1])) {
            youWon();
        } else if (yourChoice.equals(gameChoices[1]) && aiChoice.equals(gameChoices[2])) {
            youWon();
        } else if (yourChoice.equals(gameChoices[2]) && aiChoice.equals(gameChoices[0])) {
            youWon();
        } else if (yourChoice.equals(gameChoices[1]) && aiChoice.equals(gameChoices[0])) {
            aiWon();
        } else if (yourChoice.equals(gameChoices[2]) && aiChoice.equals(gameChoices[1])) {
            aiWon();
        } else if (yourChoice.equals(gameChoices[0]) && aiChoice.equals(gameChoices[2])) {
            aiWon();
        }
    }

    /**
     * Actions in case of player is won
     */
    private void youWon() {
        TextView label_who_won = findViewById(R.id.label_who_won);
        String won = "You Won!";
        label_who_won.setText(won);
        label_who_won.setVisibility(View.VISIBLE);
        TextView label_you_count = findViewById(R.id.label_you_count);
        int your_count = Integer.parseInt(label_you_count.getText().toString());
        your_count++;
        label_you_count.setText(String.valueOf(your_count));
    }

    /**
     * Actions in case of Ai is won
     */
    private void aiWon() {
        TextView label_who_won = findViewById(R.id.label_who_won);
        String won = "Computer Won!";
        label_who_won.setText(won);
        label_who_won.setVisibility(View.VISIBLE);
        TextView label_ai_count = findViewById(R.id.label_computer_count);
        int ai_count = Integer.parseInt(label_ai_count.getText().toString());
        ai_count++;
        label_ai_count.setText(String.valueOf(ai_count));
    }

    /**
     * Returns random possible ai choice
     */
    private String getRandomChoiceAI() {
        return this.gameChoices[(int) (Math.random() * ( 3 ))];
    }
}
