package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

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
//        Log.v("MainActivity", "Capital = " + capital);

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
//        Log.v("MainActivity", "slovak flag is checked: " + isCheckedSlovakFlag);

        RadioButton dakujem = (RadioButton) findViewById(R.id.dakujem);
        boolean isSlovakDakujem = dakujem.isChecked();
//        Log.v("MainActivity", "slovak " +isSlovakDakujem);

        int scoreYearOfDissociation = calculateScoreYear(finalYear);
        int scoreCapital = calculateScoreCapital(capital);
        int scoreNeighboringCountries = calculateScoreNeghboringCountries(isNeighboringCzechRepublic, isNeighboringPoland, isNeighboringUkraine, isNeighboringHungary, isNeighboringCroatia, isNeighboringRussia, isNeighboringAustria);
        int scoreHalusky = calculateScoreHalusky(isCheckedCabbage, isCheckedPotatoDough, isCheckedSheepCheese, isCheckedFriedBacon, isCheckedFlour, isCheckedMushrooms);
        int scoreThankYou = calculateScoreThankYou(isSlovakDakujem);
        int scoreFlag =  calculateScoreFlags(isCheckedSlovakFlag);

        int finalScore = scoreYearOfDissociation + scoreCapital + scoreNeighboringCountries + scoreHalusky + scoreThankYou + scoreFlag;

//        display toast message
        Toast.makeText(this, createText(finalScore) , Toast.LENGTH_LONG).show();
    }

    /** Create text
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
     * @return score for the question
     */
    private int calculateScoreYear(int yearOfDissociation) {
        int yearPoint = 0;

        if (yearOfDissociation == 1993) {
            yearPoint = yearPoint + 1;
        }

        return yearPoint;
    }

    /** Add point to score in quiz for question about our capital
     *
     * @param capitalOfSlovakia is the name of the capital of Slovakia
     * @return score for the question
     */
    private int calculateScoreCapital(String capitalOfSlovakia) {
        int capitalCityPoint = 0;

        if (capitalOfSlovakia.equals("Bratislava") || capitalOfSlovakia.equals("bratislava")) {
            capitalCityPoint = capitalCityPoint + 1;
        }

        return capitalCityPoint;
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
     * @return score for the question
     */

    private int calculateScoreNeghboringCountries(boolean czechRepublic, boolean poland, boolean ukraine, boolean hungary, boolean croatia, boolean russia, boolean austria) {
        int neighboringCountriesPoint = 0;

        if (czechRepublic && poland && ukraine && hungary && austria && !croatia && !russia) {
            neighboringCountriesPoint = neighboringCountriesPoint + 1;
        }

        return neighboringCountriesPoint;
    }

    /** Add point to score in quiz for question about national food halusky
     *
     * @param cabbage is checked if it is ingredient for halusky
     * @param potatoDough is checked if it is ingredient for halusky
     * @param sheepCheese is checked if it is ingredient for halusky
     * @param friedBacon is checked if it is ingredient for halusky
     * @param flour is checked if it is ingredient for halusky
     * @param mushrooms is checked if it is ingredient for halusky
     * @return score for the question
     */

    private int calculateScoreHalusky(boolean cabbage, boolean potatoDough, boolean sheepCheese, boolean friedBacon, boolean flour, boolean mushrooms) {
        int haluskyPoint = 0;

        if (potatoDough && sheepCheese && friedBacon && flour && !cabbage && !mushrooms) {
            haluskyPoint = haluskyPoint + 1;
        }

        return haluskyPoint;
    }


    /** Add point to score in quiz for THANK YOU translation question
     *
     * @param slovakThankYou is if slovak thank you is checked
     * @return score for the question
     */

    private int calculateScoreThankYou(boolean slovakThankYou) {
        int thankYouPoint = 0;

        if (slovakThankYou) {
            thankYouPoint = thankYouPoint + 1;
        }

        return thankYouPoint;
    }

    /** Add point to score in quiz for flag question
     *
     * @param slovakFlag is if slovak flag is checked
     * @return score for the question
     */

    private int calculateScoreFlags(boolean slovakFlag) {
        int flagPoint = 0;

        if (slovakFlag) {
            flagPoint = flagPoint + 1;
        }

        return flagPoint;
    }
}