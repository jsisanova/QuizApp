package com.example.android.quizapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.android.quizapp.R;

public class MainActivity extends AppCompatActivity {

    private int finalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitQuiz(View v) {

        EditText yearInput = (EditText) findViewById(R.id.input_year);
        String year = yearInput.getText().toString();
        int finalYear=Integer.parseInt(year);
//        Log.v("MainActivity", "Year = " + year);

        EditText capitalInput = (EditText) findViewById(R.id.input_capital);
        String capital = capitalInput.getText().toString();

        CheckBox czechRepublic = (CheckBox) findViewById(R.id.czech_republic);
        boolean isNeighboringCzechRepublic = czechRepublic.isChecked();

        CheckBox poland = (CheckBox) findViewById(R.id.poland);
        boolean isNeighboringPoland = poland.isChecked();

        CheckBox ukraine = (CheckBox) findViewById(R.id.ukraine);
        boolean isNeighboringUkraine = ukraine.isChecked();

        CheckBox hungary = (CheckBox) findViewById(R.id.hungary);
        boolean isNeighboringHungary = hungary.isChecked();

        CheckBox croatia = (CheckBox) findViewById(R.id.croatia);
        boolean isNeighboringCroatia = croatia.isChecked();

        CheckBox russia = (CheckBox) findViewById(R.id.russia);
        boolean isNeighboringRussia = russia.isChecked();

        CheckBox austria = (CheckBox) findViewById(R.id.austria);
        boolean isNeighboringAustria = austria.isChecked();

        CheckBox cabbage = (CheckBox) findViewById(R.id.cabbage);
        boolean isCheckedCabbage = cabbage.isChecked();
//        Log.v("MainActivity", "Cabbage: " + isCheckedCabbage);

        CheckBox potatoDough = (CheckBox) findViewById(R.id.potato_dough);
        boolean isCheckedPotatoDough = potatoDough.isChecked();

        CheckBox sheepCheese = (CheckBox) findViewById(R.id.sheep_cheese);
        boolean isCheckedSheepCheese = sheepCheese.isChecked();

        CheckBox friedBacon = (CheckBox) findViewById(R.id.fried_bacon);
        boolean isCheckedFriedBacon = friedBacon.isChecked();

        CheckBox flour = (CheckBox) findViewById(R.id.flour);
        boolean isCheckedFlour = flour.isChecked();

        CheckBox mushrooms = (CheckBox) findViewById(R.id.mushrooms);
        boolean isCheckedMushrooms = mushrooms.isChecked();

        RadioButton slovakFlag = (RadioButton) findViewById(R.id.slovak_flag);
        boolean isCheckedSlovakFlag = slovakFlag.isChecked();

        RadioButton dakujem = (RadioButton) findViewById(R.id.dakujem);
        boolean isSlovakDakujem = dakujem.isChecked();

//        int scoreYearOfDissociation = calculateScoreYear(finalYear);
//        int scoreCapital = calculateScoreCapital(capital);
//        int scoreNeighboringCountries = calculateScoreNeghboringCountries(isNeighboringCzechRepublic, isNeighboringPoland, isNeighboringUkraine, isNeighboringHungary, isNeighboringCroatia, isNeighboringRussia, isNeighboringAustria);
//        int scoreHalusky = calculateScoreHalusky(isCheckedCabbage, isCheckedPotatoDough, isCheckedSheepCheese, isCheckedFriedBacon, isCheckedFlour, isCheckedMushrooms);
//        int scoreThankYou = calculateScoreThankYou(isSlovakDakujem);
//        int scoreFlag =  calculateScoreFlags(isCheckedSlovakFlag);

//        int finalScore = scoreYearOfDissociation + scoreCapital + scoreNeighboringCountries + scoreHalusky + scoreThankYou + scoreFlag;

       calculateScoreYear(finalYear);
       calculateScoreCapital(capital);
       calculateScoreNeghboringCountries(isNeighboringCzechRepublic, isNeighboringPoland, isNeighboringUkraine, isNeighboringHungary, isNeighboringCroatia, isNeighboringRussia, isNeighboringAustria);
       calculateScoreHalusky(isCheckedCabbage, isCheckedPotatoDough, isCheckedSheepCheese, isCheckedFriedBacon, isCheckedFlour, isCheckedMushrooms);
       calculateScoreThankYou(isSlovakDakujem);
       calculateScoreFlags(isCheckedSlovakFlag);

//        Display toast message
        Toast.makeText(this, createText(finalScore) , Toast.LENGTH_LONG).show();
    }


    /** Create final text toast message
     *
     */
    private String createText(int endScore) {
        String textResult = "";
        if (endScore <= 1) {
            textResult = getString(R.string.poorResult, endScore);
        } else if (endScore > 1 && endScore <= 3) {
            textResult = getString(R.string.goodResult, endScore);
        } else if (endScore == 4 || endScore == 5) {
            textResult = getString(R.string.veryGoodResult, endScore);
        } else {
            textResult = getString(R.string.championResult, endScore);
        }
        return textResult;
    }

    /** Add point to score in quiz for question about year of dissociation of Czechoslovakia
     *
     * @param yearOfDissociation is the year of dissociation of Czechoslovakia
     */
    private void calculateScoreYear(int yearOfDissociation) {
        if (yearOfDissociation == 1993) {
           finalScore = finalScore + 1;
        }
    }

    /** Add point to score in quiz for question about our capital
     *
     * @param capitalOfSlovakia is the name of the capital of Slovakia
     */
    private void calculateScoreCapital(String capitalOfSlovakia) {
        if (capitalOfSlovakia.equalsIgnoreCase("bratislava")) {
            finalScore = finalScore + 1;
        }
    }

    /** Add point to score in quiz for question about neighboring countries
     *
     * @param czechRepublic is checked if it is neighboring country
     * @param poland is checked if it is neighboring country
     * @param ukraine is checked if it is neighboring country
     * @param hungary is checked if it is neighboring country
     * @param croatia is checked if it is neighboring country
     * @param russia is checked if it is neighboring country
     * @param austria is checked if it is neighboring country
     */
    private void calculateScoreNeghboringCountries(boolean czechRepublic, boolean poland, boolean ukraine, boolean hungary, boolean croatia, boolean russia, boolean austria) {
        if (czechRepublic && poland && ukraine && hungary && austria && !croatia && !russia) {
            finalScore = finalScore + 1;
        }
    }

    /** Add point to score in quiz for question about national food halusky
     *
     * @param cabbage is checked if it is ingredient for halusky
     * @param potatoDough is checked if it is ingredient for halusky
     * @param sheepCheese is checked if it is ingredient for halusky
     * @param friedBacon is checked if it is ingredient for halusky
     * @param flour is checked if it is ingredient for halusky
     * @param mushrooms is checked if it is ingredient for halusky
     */
    private void calculateScoreHalusky(boolean cabbage, boolean potatoDough, boolean sheepCheese, boolean friedBacon, boolean flour, boolean mushrooms) {
        if (potatoDough && sheepCheese && friedBacon && flour && !cabbage && !mushrooms) {
            finalScore = finalScore + 1;
        }
    }


    /** Add point to score in quiz for THANK YOU translation question
     *
     * @param slovakThankYou is if slovak thank you is checked
     */
    private void calculateScoreThankYou(boolean slovakThankYou) {
        if (slovakThankYou) {
            finalScore = finalScore + 1;
        }
    }

    /** Add point to score in quiz for flag question
     *
     * @param slovakFlag is if slovak flag is checked
     */
    private void calculateScoreFlags(boolean slovakFlag) {
        if (slovakFlag) {
            finalScore = finalScore + 1;
        }
    }
}