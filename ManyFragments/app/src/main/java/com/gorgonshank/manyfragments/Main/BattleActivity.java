package com.gorgonshank.manyfragments.Main;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.gorgonshank.manyfragments.Battle.Enemy;
import com.gorgonshank.manyfragments.Data.CharacterData;
import com.gorgonshank.manyfragments.R;

import java.io.IOException;

public class BattleActivity extends ActionBarActivity{

    private ImageView characterPortrait;
    private ImageView enemyPortrait;
    private Button attack, run, heal, item;
    private TextView charHP_TextView, enemyHP_TextView, combat_text;
    private ScrollView scroll;
    private MediaPlayer mp;
    private LinearLayout battle_background;
    private Enemy combatant;

    public long character_HP, enemy_HP, character_max_HP, enemy_max_HP;

    private int end = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        int Min = 0;
        int Max = 1;
        int decision = Min + (int)(Math.random() * ((Max - Min) + 1));

        enemyPortrait = (ImageView) findViewById(R.id.enemy);


        if(decision == 0) {
            battle_background = (LinearLayout) findViewById(R.id.battle_background);
            selectBackground(battle_background);
            playSound("FF6_05_Battle_Theme.mid");
            mp.setLooping(true);
            combatant = new Enemy();
            enemyPortrait.setImageResource(R.drawable.imp);
            Log.i("Enemy Stats", "HP: " + combatant.getHp() + " Attack: " + combatant.getAttack() + " Defence: " + combatant.getDefence() + "");
        } else if(decision == 1) {
            battle_background = (LinearLayout) findViewById(R.id.battle_background);
            battle_background.setBackgroundResource(R.drawable.battle_background_boss);
            playSound("FF6_48_The_Fierce_Battle.mid");
            mp.setLooping(true);
            combatant = new Enemy(2);
            enemyPortrait.setImageResource(R.drawable.tiamat);
        }

        characterPortrait = (ImageView) findViewById(R.id.character);
        characterPortrait.setImageResource(R.drawable.fighter);



        charHP_TextView = (TextView) findViewById(R.id.char_HP);
        charHP_TextView.setText("HP: " + CharacterData.getMyHitPoints() + "/" + CharacterData.getMyMaxHitPoints());

        character_HP = CharacterData.getMyHitPoints();
        character_max_HP = CharacterData.getMyMaxHitPoints();

        enemyHP_TextView = (TextView) findViewById(R.id.enemy_HP);
        enemyHP_TextView.setText("Enemy: " + combatant.getHp() + "/" + combatant.getMaxHP());

        enemy_HP = combatant.getHp();
        enemy_max_HP = combatant.getMaxHP();

        scroll = (ScrollView) findViewById(R.id.scroll);
        combat_text = (TextView) findViewById(R.id.combat_text);

        attack = (Button) findViewById(R.id.attack_button);
        attack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long damage = (CharacterData.getAttack() - combatant.getDefence());

                if(damage > 0) {
                    combat_text.append("\nPlayer did " + damage + " to enemy.");
                    scroll.smoothScrollTo(0, combat_text.getBottom());
                    enemy_HP -= damage;
                    playSound("sword_attack.wav");
                    if(enemy_HP < 0) {
                        enemy_HP = 0;
                    }
                } else {
                    combat_text.append("\nPlayer did not do damage to enemy.");
                    scroll.smoothScrollTo(0, combat_text.getBottom());
                }
                enemyHP_TextView.setText("Enemy: " + enemy_HP + "/" + enemy_max_HP);
                combatant.setHp(enemy_HP);

                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Log.i("Battle", "Didn't work");
                }

                checkVictoryOrLoss(combatant);
                enemyTurn(combatant);
            }
        });

        run = (Button) findViewById(R.id.run_button);
        run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Min = 0;
                int Max = 2;
                int decision = Min + (int)(Math.random() * ((Max - Min) + 1));
                if(decision == 0) {
                    combat_text.append("\nRan away.");
                    scroll.smoothScrollTo(0, combat_text.getBottom());

                    Intent mainIntent = new Intent(BattleActivity.this, MainActivity.class);
                    Toast toast = Toast.makeText(getApplicationContext(), "Ran Away" , Toast.LENGTH_LONG);
                    toast.show();

                    end = 0;

                    startActivity(mainIntent);
                    BattleActivity.this.finish();


                } else {
                    combat_text.append("\nFailed to run away.");
                    scroll.smoothScrollTo(0, combat_text.getBottom());
                    enemyTurn(combatant);
                }
            }
        });

        heal = (Button) findViewById(R.id.heal_button);
        heal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                long healing = 100l;
                character_HP += healing;

                if(character_HP > character_max_HP) {
                    character_HP = character_max_HP;
                }

                CharacterData.setMyHitPoints(character_HP);
                charHP_TextView.setText("HP: " + character_HP + "/" + character_max_HP);
                combat_text.append("\nPlayer recovered " + healing + " HP.");
                scroll.smoothScrollTo(0, combat_text.getBottom());
                playSound("heal.mp3");

                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Log.i("Battle", "Didn't work");
                }

                checkVictoryOrLoss(combatant);
                enemyTurn(combatant);
            }
        });

        item = (Button) findViewById(R.id.item_button);
        item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(end == 1) {
            mp.stop();
            playSound("FF6_06_Fanfare.mid");
        } else if(end == 2) {
            mp.stop();
            playSound("FF6_50_Dark_World.mid");
        } else {
            mp.stop();
            playSound("run_away.mp3");
        }
    }

    public void selectBackground(LinearLayout battle_background) {
        int Min = 0;
        int Max = 3;
        int decision = Min + (int)(Math.random() * ((Max - Min) + 1));

        if(decision == 0) {
            battle_background.setBackgroundResource(R.drawable.battle_background_desert);
        } else if(decision == 1) {
            battle_background.setBackgroundResource(R.drawable.battle_background_forest);
        } else if(decision == 2) {
            battle_background.setBackgroundResource(R.drawable.battle_background_mountain);
        } else if(decision == 3) {
            battle_background.setBackgroundResource(R.drawable.battle_background_plains);
        }
    }

    public void playSound(String fileName) {

        //String fileName = "";
        AssetFileDescriptor afd = null;

        try{
            afd = getAssets().openFd(fileName);
        } catch(IOException e) {
            Log.i("Error", "Assets file I/O Error");
        }

        mp = new MediaPlayer();
        try{
            mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(),afd.getLength());
            mp.prepare();
            mp.start();
        } catch (IOException e) {
            Log.i("Error", "Media player I/O Exception");
        }
    }

    public void enemyTurn(Enemy combatant) {

        int Min = 0;
        int Max = 2;
        int decision = Min + (int)(Math.random() * ((Max - Min) + 1));

        if(combatant.getHp() > 0) {

            if(decision == 0) {
                long damage = (combatant.getAttack() - CharacterData.getDefense());

                if(damage > 0) {
                    combat_text.append("\nEnemy did " + damage + " to player.");
                    scroll.smoothScrollTo(0, combat_text.getBottom());
                    character_HP -= damage;
                    if(character_HP < 0) {
                        character_HP = 0;
                    }
                } else {
                    combat_text.append("\nEnemy did not do damage to player.");
                    scroll.smoothScrollTo(0, combat_text.getBottom());
                }
                charHP_TextView.setText("HP: " + character_HP + "/" + character_max_HP);
                CharacterData.setMyHitPoints(character_HP);
                playSound("damage.wav");

            } else if(decision == 1) {
                combat_text.append("\nEnemy is loafing around.");
                scroll.smoothScrollTo(0, combat_text.getBottom());
            } else if(decision == 2) {
                long heal = 50;
                enemy_HP = combatant.getHp();
                enemy_HP += heal;

                if(enemy_HP > combatant.getMaxHP()) {
                    enemy_HP = combatant.getMaxHP();
                }

                combat_text.append("\nEnemy healed itself for " + heal + " HP.");
                scroll.smoothScrollTo(0, combat_text.getBottom());
                enemyHP_TextView.setText("Enemy: " + enemy_HP + "/" + enemy_max_HP);
                combatant.setHp(enemy_HP);
                playSound("heal.mp3");
            }

        }

        checkVictoryOrLoss(combatant);
    }

    public void checkVictoryOrLoss(Enemy combatant) {
        if(combatant.getHp() <= 0) {
            Intent mainIntent = new Intent(BattleActivity.this, MainActivity.class);
            mainIntent.putExtra("experience", combatant.getExperience());
            mainIntent.putExtra("loot", combatant.getLoot());

            Toast toast = Toast.makeText(getApplicationContext(), "You win " + " loot: " + combatant.getLoot(), Toast.LENGTH_LONG);
            toast.show();

            end = 1;

            startActivity(mainIntent);
            BattleActivity.this.finish();
        } else if(CharacterData.getMyHitPoints() <= 0) {
            Intent mainIntent = new Intent(BattleActivity.this, MainActivity.class);
            Toast toast = Toast.makeText(getApplicationContext(), "You lose.", Toast.LENGTH_LONG);
            toast.show();

            end = 2;

            startActivity(mainIntent);
            BattleActivity.this.finish();
        }
    }

}
