package com.example.sofyann.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    private EditText editText;
    private double newValeur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        constructUI();
        constructListeners();
    }

    private void constructUI() {
        this.button = (Button)findViewById(R.id.button);
        this.editText = (EditText)findViewById(R.id.editText);
    }

    private void constructListeners(){
        this.button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        displayingResult();
    }

    private boolean isMyEditTextEmpty(){
        boolean state;
        state = this.editText.getText().length() == 0; // si la taille est 0 alors state = true
        return state;
    }

    private double getNumberFromEditText(){
        double value;
        String temp;
        temp = this.editText.getText().toString();
        value = Double.parseDouble(temp);
        return value;
    }

    private void convertDollarsToEuro(double dollars){ // ici on recupere la valeur retourné par getNumberFromEditText
        double temp;
        temp =  (dollars*0.859291085); // on converti la valeur
        this.newValeur=temp; // on met a jour newValeur
    }

    private void displayingResult(){
        String temp;
        if (isMyEditTextEmpty()) {
            temp="Aucune valeur à convertir";
        } else {
            convertDollarsToEuro(getNumberFromEditText());
            temp = String.valueOf(newValeur);

        }
        Toast.makeText(this, temp, Toast.LENGTH_SHORT).show();

    }


}
