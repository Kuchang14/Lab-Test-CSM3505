package com.example.mindsharpener;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //Set variable for TextView
    TextView number1,number2,operator,pointCounter;

    //Set variable for TextInput
    TextInputEditText inputJawapan;

    //Set points variable
    int points = 0;

    //Save difficulty
    int difficulty = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get the TextView component at the Start of the app
        number1 = (TextView) findViewById(R.id.number1);
        number2 = (TextView) findViewById(R.id.number2);
        operator = (TextView) findViewById(R.id.operator);
        pointCounter = (TextView) findViewById(R.id.pointCounter);

        //Get the TextInput component
        inputJawapan = (TextInputEditText) findViewById(R.id.textInputJawapan);

        clickEasy(null);

    }
    public void clickEasy(View view) {
        //Save difficulty
        difficulty = 1;

        //Say that they selected what mode
        Toast.makeText(this, "You selected Easy mode!", Toast.LENGTH_SHORT).show();

        //Generate 2 random numbers with 1 digit
        Random random = new Random();
        int randomNumber = random.nextInt(9);
        int randomNumber2 = random.nextInt(9);

        //Set the text to generated number
        number1.setText(    String.valueOf(randomNumber)    );
        number2.setText(    String.valueOf(randomNumber2)    );

        //Generate random 0,1,2,3 number for Operator
        int randomOperator = random.nextInt(4);

        //if 0 -> +  , 1 -> - , 2 -> * , 3 -> /
        if        (randomOperator == 0) {
            operator.setText("+");
        }else if  (randomOperator == 1) {
            operator.setText("-");
        }else if  (randomOperator == 2) {
            operator.setText("*");
        }else {
            operator.setText("/");
        }

    }
    public void clickMedium(View view) {
        //Save difficulty
        difficulty = 2;

        Toast.makeText(this, "You selected Medium mode!", Toast.LENGTH_SHORT).show();

        //Generate 2 random numbers with 2 digit
        Random random = new Random();
        int randomNumber = random.nextInt(99);
        int randomNumber2 = random.nextInt(99);

        //Set the text to generated number
        number1.setText(    String.valueOf(randomNumber)    );
        number2.setText(    String.valueOf(randomNumber2)    );

        //Generate random 0,1,2,3 number for Operator
        int randomOperator = random.nextInt(4);

        //if 0 -> +  , 1 -> - , 2 -> * , 3 -> /
        if        (randomOperator == 0) {
            operator.setText("+");
        }else if  (randomOperator == 1) {
            operator.setText("-");
        }else if  (randomOperator == 2) {
            operator.setText("*");
        }else {
            operator.setText("/");
        }
    }
    public void clickHard(View view) {
        //Save difficulty
        difficulty = 3;

        Toast.makeText(this, "You selected Hard mode!", Toast.LENGTH_SHORT).show();

        //Generate 2 random numbers with 3 digit
        Random random = new Random();
        int randomNumber = random.nextInt(999);
        int randomNumber2 = random.nextInt(999);

        //Set the text to generated number
        number1.setText(    String.valueOf(randomNumber)    );
        number2.setText(    String.valueOf(randomNumber2)    );

        //Generate random 0,1,2,3 number for Operator
        int randomOperator = random.nextInt(4);

        //if 0 -> +  , 1 -> - , 2 -> * , 3 -> /
        if        (randomOperator == 0) {
            operator.setText("+");
        }else if  (randomOperator == 1) {
            operator.setText("-");
        }else if  (randomOperator == 2) {
            operator.setText("*");
        }else {
            operator.setText("/");
        }
    }

    //CheckButton onClick
    public void clickCheckButton(View view) {

        //---- Get the question ----
        //Get number in integer
        int num1 = Integer.parseInt(     number1.getText().toString()    );
        int num2 = Integer.parseInt(     number2.getText().toString()    );
        int result;

        //Get operator and Calculate the result
        if (operator.getText().toString() == "+") {
            result = num1 + num2;
        } else if (operator.getText().toString() == "-") {
            result = num1 - num2;
        } else if (operator.getText().toString() == "*") {
            result = num1 * num2;
        } else {
            result = num1 / num2;
        }

        //Check result is true
        if ( Integer.parseInt(inputJawapan.getText().toString()) == result ) {
            Toast.makeText(this, "CORRECT!", Toast.LENGTH_SHORT).show();

            //Increase the point by 1
            points = points+1;

            //Display it into PointCounter
            pointCounter.setText("POINT : " + points);

        } else {
            Toast.makeText(this, "Wrong Answer :(", Toast.LENGTH_SHORT).show();

            //Decrease the point by 1
            points = points-1;

            //Display it into PointCounter
            pointCounter.setText("POINT : " + points);
        }

        //Refresh the level based on difficulty
        if (difficulty == 1) {
            clickEasy(null);
        } else if (difficulty == 2) {
            clickMedium(null);
        } else if (difficulty == 3) {
            clickHard(null);
        }

        //Reset the input answer to blank
        inputJawapan.setText("");

    }
}