package com.gorgonshank.pair_o_dice;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Player2 extends ActionBarActivity {
    private FrameLayout die1, die2;
    private Button roll, hold;

    private ImageView d1, d2;

    private int total = 0;
    private int playerOne = 0, playerTwo = 0;
    private int rolled;

    private TextView round, us, them;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player2);

        d1 = (ImageView) findViewById(R.id.imageViewDie1);
        d2 = (ImageView) findViewById(R.id.imageViewDie2);


        try {
            Intent intent = getIntent();
            playerOne = intent.getExtras().getInt("p1_score");
            playerTwo = intent.getExtras().getInt("p2_score");
        } catch (NullPointerException e) {
            Toast.makeText(this, "Caught Error", Toast.LENGTH_LONG).show();
        }

        us = (TextView) findViewById(R.id.us);
        us.setText("Us: " + playerTwo);

        them = (TextView) findViewById(R.id.them);
        them.setText("Them: " + playerOne);

        roll = (Button) findViewById(R.id.rollButton);
        roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rolled = rollDice();
                if (rolled == 0) {
                    passTurn(playerOne, playerTwo);
                } else {
                    total = total + rolled;
                    round = (TextView) findViewById(R.id.round);
                    round.setText("Round: " + total);
                }

                //rollThem();
                /*Uri number = Uri.parse("tel:3235398977");
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                startActivity(callIntent);*/
            }
        });

        die1 = (FrameLayout) findViewById(R.id.die1);
        die2 = (FrameLayout) findViewById(R.id.die2);

        hold = (Button) findViewById(R.id.hold_button);
        hold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent(where are we?, where are we going?)
                playerTwo = playerTwo + total;
                us = (TextView) findViewById(R.id.us);
                us.setText("Us: " + playerTwo);
                if(playerTwo > 100){
                    AlertDialog alertDialog = new AlertDialog.Builder(Player2.this).create();
                    alertDialog.setTitle("You Won!");
                    alertDialog.setMessage("Player 2 Wins with a score of " + playerTwo);
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
                else{
                    passTurn(playerOne, playerTwo);
                }
            }
        });


    }

    public void passTurn(int playerOne, int playerTwo) {
        Intent intent = new Intent(Player2.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        intent.putExtra("p1_score", playerOne);
        intent.putExtra("p2_score", playerTwo);
        startActivity(intent);
    }

    public int rollDice() {
        int minimum = 1;
        int maximum = 6;
        int dice1 = minimum + (int) (Math.random() * maximum);
        int dice2 = minimum + (int) (Math.random() * maximum);

        Drawable one = getResources().getDrawable(R.drawable.die_face_1);
        Drawable two = getResources().getDrawable(R.drawable.die_face_2);
        Drawable three = getResources().getDrawable(R.drawable.die_face_3);
        Drawable four = getResources().getDrawable(R.drawable.die_face_4);
        Drawable five = getResources().getDrawable(R.drawable.die_face_5);
        Drawable six = getResources().getDrawable(R.drawable.die_face_6);

        int total;

        total = dice1 + dice2;

        switch (dice1) {
            case 1:
                d1.setImageDrawable(one);
                total = 0;
                break;
            case 2:
                d1.setImageDrawable(two);
                break;
            case 3:
                d1.setImageDrawable(three);
                break;
            case 4:
                d1.setImageDrawable(four);
                break;
            case 5:
                d1.setImageDrawable(five);
                break;
            case 6:
                d1.setImageDrawable(six);
                break;
        }

        switch (dice2) {
            case 1:
                d2.setImageDrawable(one);
                total = 0;
                break;
            case 2:
                d2.setImageDrawable(two);
                break;
            case 3:
                d2.setImageDrawable(three);
                break;
            case 4:
                d2.setImageDrawable(four);
                break;
            case 5:
                d2.setImageDrawable(five);
                break;
            case 6:
                d2.setImageDrawable(six);
                break;
        }


        return (total);
    }

    public void rollThem() {
        int minimum = 1;
        int maximum = 6;
        int dice1 = minimum + (int) (Math.random() * maximum);
        int dice2 = minimum + (int) (Math.random() * maximum);

        setDie(dice1, die1);
        setDie(dice2, die2);
    }

    public void setDie(int num, FrameLayout layout) {
        Drawable pic;
        switch (num) {
            case 1:
                pic = getResources().getDrawable(R.drawable.die_face_1);
                layout.setBackground(pic);
                break;
            case 2:
                pic = getResources().getDrawable(R.drawable.die_face_2);
                layout.setBackground(pic);
                break;
            case 3:
                pic = getResources().getDrawable(R.drawable.die_face_3);
                layout.setBackground(pic);
                break;
            case 4:
                pic = getResources().getDrawable(R.drawable.die_face_4);
                layout.setBackground(pic);
                break;
            case 5:
                pic = getResources().getDrawable(R.drawable.die_face_5);
                layout.setBackground(pic);
                break;
            case 6:
                pic = getResources().getDrawable(R.drawable.die_face_6);
                layout.setBackground(pic);
                break;
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
