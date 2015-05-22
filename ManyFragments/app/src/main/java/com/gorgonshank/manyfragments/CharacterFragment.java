package com.gorgonshank.manyfragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CharacterFragment extends Fragment {

    private static final String TAG = "CharacterFragment";

    private int hp = 0;
    private TextView characterName, characterHP;
    private ImageView characterPortrait;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.character_fragment, container, false);

        final MainActivity activity = (MainActivity) getActivity();
        this.hp = activity.getHP();

        characterName = (TextView) v.findViewById(R.id.characterName);
        String cName = "Fighter";
        characterName.append(cName);

        characterHP = (TextView) v.findViewById(R.id.characterHP);

        String cHP = hp + "/100";
        characterHP.append(cHP);

        characterPortrait = (ImageView) v.findViewById(R.id.characterPortrait);
        characterPortrait.setImageResource(R.drawable.fighter);

        Button doSomething = (Button) v.findViewById(R.id.button);
        doSomething.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hp -= 10;
                String text = "HP: " + hp + "/100";
                activity.setHP(hp);
                characterHP.setText(text);
            }
        });

        return v;
    }


    public static CharacterFragment newInstance(String text) {

        CharacterFragment f = new CharacterFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);



        return f;
    }
}