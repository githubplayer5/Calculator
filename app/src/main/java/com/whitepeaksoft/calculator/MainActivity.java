package com.whitepeaksoft.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText operand1;
    private EditText operand2;
    private Button btnAddition;
    private Button btnSubtraction;
    private Button btnMultiplication;
    private Button btnDivision;
    private TextView txtResult;
    private Button btnClear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


        operand1 = (EditText) findViewById(R.id.operand1);
        operand2 = (EditText) findViewById(R.id.operand2);
        btnAddition = (Button) findViewById(R.id.btnAddition);
        btnSubtraction = (Button) findViewById(R.id.btnSubtraction);
        btnMultiplication = (Button) findViewById(R.id.btnMultiplication);
        btnDivision = (Button) findViewById(R.id.btnDivision);
        txtResult = (TextView) findViewById(R.id.txtResult);
        btnClear = (Button) findViewById(R.id.btnClear);

        btnAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean bool = validationMethod(operand1, operand2);
                if(bool == true)
                    return;
                double oper1 = Double.parseDouble(operand1.getText().toString());
                double oper2 = Double.parseDouble(operand2.getText().toString());

                double result = oper1 + oper2;
                txtResult.setText(Double.toString(result));
            }
        });

        btnSubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean bool = validationMethod(operand1, operand2);
                if(bool == true)
                    return;
                double oper1 = Double.parseDouble(operand1.getText().toString());
                double oper2 = Double.parseDouble(operand2.getText().toString());

                double result = oper1 - oper2;
                txtResult.setText(Double.toString(result));
            }
        });

        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean bool = validationMethod(operand1, operand2);
                if(bool == true)
                    return;
                double oper1 = Double.parseDouble(operand1.getText().toString());
                double oper2 = Double.parseDouble(operand2.getText().toString());

                double result = oper1 / oper2;
                txtResult.setText(Double.toString(result));
            }
        });

        btnMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean bool = validationMethod(operand1, operand2);
                if(bool == true)
                    return;
                double oper1 = Double.parseDouble(operand1.getText().toString());
                double oper2 = Double.parseDouble(operand2.getText().toString());

                double result = oper1 * oper2;
                txtResult.setText(Double.toString(result));
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operand1.setText("");
                operand2.setText("");
                operand1.requestFocus();
            }
        });
    }

    public boolean validationMethod (EditText op1, EditText op2){
        boolean bool = false;
        if(op1.getText().toString().equals("") || op2.getText().toString().equals("")) {
            Toast.makeText(MainActivity.this, "None of the fields can be left empty!", Toast.LENGTH_LONG).show();
            bool = true;
        }
        else if (operand2.getText().toString().startsWith("0")){
            Toast.makeText(MainActivity.this, "2nd field cannot contain zero!", Toast.LENGTH_LONG).show();
            bool = true;
        }
        return bool;
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
