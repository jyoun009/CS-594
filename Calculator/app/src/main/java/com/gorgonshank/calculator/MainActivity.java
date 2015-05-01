package com.gorgonshank.calculator;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private EditText calculator;
    private TextView operation;
    private String value = "0";
    private String last_value = "0";
    private String op = "";
    private Button delete;
    private Button seven, eight, nine, divide;
    private Button four, five, six, multiply;
    private Button one, two, three, subtract;
    private Button decimal, zero, equals, add;
    private double calculation;
    private boolean first = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculator = (EditText) findViewById(R.id.calc_window);
        operation = (TextView) findViewById(R.id.operation_window);

        disableSoftInputFromAppearing(calculator);

        try {
            Intent intent = getIntent();
            value = intent.getExtras().getString("value");
            last_value = intent.getExtras().getString("last_value");
            op = intent.getExtras().getString("op");
        } catch (NullPointerException e) {
            //Toast.makeText(this, "Caught Error", Toast.LENGTH_LONG).show();
        }

        calculator.setText(value);
        operation.setText(op);

        delete = (Button) findViewById(R.id.delete_button);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = "0";
                calculator.setText(value);
                op = "";
                operation.setText(op);
                first = true;
            }
        });

        seven = (Button) findViewById(R.id.button7);
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = calculator.getText().toString();
                op = operation.getText().toString();

                if(value.equals("0")) {
                    value = "7";
                    first = false;
                }
                else if(first){
                    last_value = value;
                    value = "7";
                    first = false;
                }
                else
                    value = value.concat("7");

                calculator.setText(value);
            }
        });

        eight = (Button) findViewById(R.id.button8);
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = calculator.getText().toString();
                op = operation.getText().toString();

                if(value.equals("0")) {
                    value = "8";
                    first = false;
                }
                else if(first){
                    last_value = value;
                    value = "8";
                    first = false;
                }
                else
                    value = value.concat("8");

                calculator.setText(value);
            }
        });

        nine = (Button) findViewById(R.id.button9);
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = calculator.getText().toString();
                op = operation.getText().toString();

                if(value.equals("0")) {
                    value = "9";
                    first = false;
                }
                else if(first){
                    last_value = value;
                    value = "9";
                    first = false;
                }
                else
                    value = value.concat("9");

                calculator.setText(value);
            }
        });

        four = (Button) findViewById(R.id.button4);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = calculator.getText().toString();
                op = operation.getText().toString();

                if(value.equals("0")) {
                    value = "4";
                    first = false;
                }
                else if(first){
                    last_value = value;
                    value = "4";
                    first = false;
                }
                else
                    value = value.concat("4");

                calculator.setText(value);
            }
        });

        five = (Button) findViewById(R.id.button5);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = calculator.getText().toString();
                op = operation.getText().toString();

                if(value.equals("0")) {
                    value = "5";
                    first = false;
                }
                else if(first){
                    last_value = value;
                    value = "5";
                    first = false;
                }
                else
                    value = value.concat("5");

                calculator.setText(value);
            }
        });

        six = (Button) findViewById(R.id.button6);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = calculator.getText().toString();
                op = operation.getText().toString();

                if(value.equals("0")) {
                    value = "6";
                    first = false;
                }
                else if(first){
                    last_value = value;
                    value = "6";
                    first = false;
                }
                else
                    value = value.concat("6");

                calculator.setText(value);
            }
        });

        one = (Button) findViewById(R.id.button1);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = calculator.getText().toString();
                op = operation.getText().toString();

                if(value.equals("0")) {
                    value = "1";
                    first = false;
                }
                else if(first){
                    last_value = value;
                    value = "1";
                    first = false;
                }
                else
                    value = value.concat("1");

                calculator.setText(value);
            }
        });

        two = (Button) findViewById(R.id.button2);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = calculator.getText().toString();
                op = operation.getText().toString();

                if(value.equals("0")) {
                    value = "2";
                    first = false;
                }
                else if(first){
                    last_value = value;
                    value = "2";
                    first = false;
                }
                else
                    value = value.concat("2");

                calculator.setText(value);
            }
        });

        three = (Button) findViewById(R.id.button3);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = calculator.getText().toString();
                op = operation.getText().toString();

                if(value.equals("0")) {
                    value = "3";
                    first = false;
                }
                else if(first){
                    last_value = value;
                    value = "3";
                    first = false;
                }
                else
                    value = value.concat("3");

                calculator.setText(value);
            }
        });

        zero = (Button) findViewById(R.id.button0);
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = calculator.getText().toString();

                if(value.equals("0"))
                    value = "0";
                else
                    value = value.concat("0");

                calculator.setText(value);
            }
        });

        add = (Button) findViewById(R.id.plus_button);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = calculator.getText().toString();
                op = operation.getText().toString();

                if(op.equals(""))
                {
                    last_value = value;
                    op = "+";
                    operation.setText(op);
                    calculator.setText("0");
                    first = true;
                }
                else
                {
                    calculation = add(value, last_value);
                    last_value = calculation+"";
                    op = "";
                    operation.setText(op);
                    calculator.setText(calculation+"");
                    first = true;
                }
            }
        });

        subtract = (Button) findViewById(R.id.subtract_button);
        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = calculator.getText().toString();
                op = operation.getText().toString();

                if(op.equals(""))
                {
                    last_value = value;
                    op = "-";
                    operation.setText(op);
                    calculator.setText("0");
                    first = true;
                }
                else
                {
                    calculation = subtract(value, last_value);
                    last_value = calculation+"";
                    op = "";
                    operation.setText(op);
                    calculator.setText(calculation+"");
                    first = true;
                }
            }
        });

        multiply = (Button) findViewById(R.id.multiply_button);
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = calculator.getText().toString();
                op = operation.getText().toString();

                if(op.equals(""))
                {
                    last_value = value;
                    op = "x";
                    operation.setText(op);
                    calculator.setText("0");
                    first = true;
                }
                else
                {
                    calculation = multiply(value, last_value);
                    last_value = calculation+"";
                    op = "";
                    operation.setText(op);
                    calculator.setText(calculation+"");
                    first = true;
                }
            }
        });

        divide = (Button) findViewById(R.id.divide_button);
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = calculator.getText().toString();
                op = operation.getText().toString();

                if(op.equals(""))
                {
                    last_value = value;
                    op = "/";
                    operation.setText(op);
                    calculator.setText("0");
                    first = true;
                }
                else
                {
                    calculation = divide(value, last_value);
                    last_value = calculation+"";
                    op = "";
                    operation.setText(op);
                    calculator.setText(calculation+"");
                    first = true;
                }
            }
        });

        decimal = (Button) findViewById(R.id.decimal_button);
        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = calculator.getText().toString();
                op = operation.getText().toString();

                if(value.equals("0")) {
                    value = "0.";
                    first = false;
                }
                else if(first){
                    last_value = value;
                    value = "0.";
                    first = false;
                }
                else
                    value = value.concat(".");

                calculator.setText(value);
            }
        });

        equals = (Button) findViewById(R.id.equals_button);
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = calculator.getText().toString();
                op = operation.getText().toString();

                if(op.equals("+"))
                {
                    calculation = add(value, last_value);
                    op = "";
                    operation.setText(op);
                    calculator.setText(calculation+"");
                    first = true;
                    value = "0";
                    last_value = calculator.getText().toString();
                }
                else if(op.equals("-"))
                {
                    calculation = subtract(value, last_value);
                    op = "";
                    operation.setText(op);
                    calculator.setText(calculation+"");
                    first = true;
                    value = "0";
                    last_value = calculator.getText().toString();
                }
                else if(op.equals("x"))
                {
                    calculation = multiply(value, last_value);
                    op = "";
                    operation.setText(op);
                    calculator.setText(calculation+"");
                    first = true;
                    value = "0";
                    last_value = calculator.getText().toString();
                }
                else if(op.equals("/"))
                {
                    calculation = divide(value, last_value);
                    op = "";
                    operation.setText(op);
                    calculator.setText(calculation+"");
                    first = true;
                    value = "0";
                    last_value = calculator.getText().toString();
                }
                else if(op.equals("^"))
                {
                    calculation = Math.pow(Double.parseDouble(last_value),Double.parseDouble(value));
                    op = "";
                    operation.setText(op);
                    calculator.setText(calculation+"");
                    first = true;
                    value = "0";
                    last_value = calculator.getText().toString();
                }
            }
        });
    }

    public double add(String value, String last_value) {
        return (Double.parseDouble(last_value) + Double.parseDouble(value));
    }

    public double subtract(String value, String last_value) {
        return (Double.parseDouble(last_value) - Double.parseDouble(value));
    }

    public double multiply(String value, String last_value) {
        return (Double.parseDouble(last_value) * Double.parseDouble(value));
    }

    public double divide(String value, String last_value) {
        double total = 0.0;

        try{
            total = (Double.parseDouble(last_value) / Double.parseDouble(value));
        } catch(ArithmeticException e){
            total = Double.POSITIVE_INFINITY;
        }

        return total;
    }

    /**
     * Disable soft keyboard from appearing, use in conjunction with adding the android:windowSoftInputMode="stateAlwaysHidden|adjustNothing" attribute to your activity tag in your manifest
     file.
     * @param editText
     */
    public static void disableSoftInputFromAppearing(EditText editText) {
        if (Build.VERSION.SDK_INT >= 11) {
            editText.setRawInputType(InputType.TYPE_CLASS_TEXT);
            editText.setTextIsSelectable(true);
        } else {
            editText.setRawInputType(InputType.TYPE_NULL);
            editText.setFocusable(true);
        }
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
        if (id == R.id.scientific_mode) {
            Intent intent = new Intent(MainActivity.this, Scientific.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            value = calculator.getText().toString();
            intent.putExtra("value", value);
            intent.putExtra("last_value", last_value);
            intent.putExtra("op", op);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
