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


public class Scientific extends ActionBarActivity {

    private EditText calculator;
    private TextView operation;
    private String value = "0";
    private String last_value = "0";
    private String op = "";
    private Button delete;
    private Button sin, cos, tan, pos_neg;
    private Button ln, log, pi, e;
    private Button percent, factorial, square_root, power;
    private Button equals;
    private double calculation;
    private boolean first = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scientific);

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

        sin = (Button) findViewById(R.id.sin_button);
        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = calculator.getText().toString();
                calculation = Double.parseDouble(value);
                calculation = Math.toRadians(calculation);
                calculation = Math.sin(calculation);
                value = calculation+"";
                calculator.setText(value);
            }
        });

        cos = (Button) findViewById(R.id.cos_button);
        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = calculator.getText().toString();
                calculation = Double.parseDouble(value);
                calculation = Math.toRadians(calculation);
                calculation = Math.cos(calculation);
                value = calculation+"";
                calculator.setText(value);
            }
        });

        tan = (Button) findViewById(R.id.tan_button);
        tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = calculator.getText().toString();
                calculation = Double.parseDouble(value);
                calculation = Math.toRadians(calculation);
                calculation = Math.tan(calculation);
                value = calculation+"";
                calculator.setText(value);
            }
        });

        pos_neg = (Button) findViewById(R.id.pos_neg_button);
        pos_neg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = calculator.getText().toString();
                calculation = Double.parseDouble(value);
                calculation = calculation * -1.0;
                value = calculation+"";
                calculator.setText(value);
            }
        });



        ln = (Button) findViewById(R.id.ln_button);
        ln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = calculator.getText().toString();
                calculation = Double.parseDouble(value);
                calculation = Math.toRadians(calculation);
                calculation = Math.log(calculation);
                value = calculation+"";
                calculator.setText(value);
            }
        });

        log = (Button) findViewById(R.id.log_button);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = calculator.getText().toString();
                calculation = Double.parseDouble(value);
                calculation = Math.toRadians(calculation);
                calculation = Math.log10(calculation);
                value = calculation+"";
                calculator.setText(value);
            }
        });

        pi = (Button) findViewById(R.id.pi_button);
        pi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = calculator.getText().toString();

                calculation = Math.PI;
                value = calculation + "";

                calculator.setText(value);
            }
        });

        e = (Button) findViewById(R.id.e_button);
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = calculator.getText().toString();
                calculation = Double.parseDouble(value);
                calculation = Math.exp(calculation);
                value = calculation+"";
                calculator.setText(value);
            }
        });

        percent = (Button) findViewById(R.id.percent_button);
        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = calculator.getText().toString();
                calculation = Double.parseDouble(value);
                calculation = calculation/100.0;
                value = calculation+"";
                calculator.setText(value);
            }
        });

        factorial = (Button) findViewById(R.id.factorial_button);
        factorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = calculator.getText().toString();
                calculation = Double.parseDouble(value);
                calculation = factorial(calculation);
                value = calculation+"";
                calculator.setText(value);
            }
        });

        square_root = (Button) findViewById(R.id.sqrt_button);
        square_root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = calculator.getText().toString();
                calculation = Double.parseDouble(value);
                calculation = Math.sqrt(calculation);
                value = calculation+"";
                calculator.setText(value);
            }
        });

        power = (Button) findViewById(R.id.pow_button);
        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op = "^";
                operation.setText(op);
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

    double factorial(double calculation) {
        double result;
        if(calculation <= 1){
            return calculation;
        }
        result = factorial(calculation - 1) * calculation;

        return result;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scientific, menu);
        return true;
    }

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
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.basic_mode) {
            Intent intent = new Intent(Scientific.this, MainActivity.class);
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
