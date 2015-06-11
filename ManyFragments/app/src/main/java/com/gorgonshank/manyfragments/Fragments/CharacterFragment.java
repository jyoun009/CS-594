package com.gorgonshank.manyfragments.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.gorgonshank.manyfragments.Data.CharacterData;
import com.gorgonshank.manyfragments.R;

public class CharacterFragment extends Fragment implements Hideable {

    private static final String TAG = "CharacterFragment";

    private TextView characterName, characterHP;
    private ImageView characterPortrait;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.character_fragment, container, false);

        characterName = (TextView) v.findViewById(R.id.characterName);
        String cName = "Fighter";
        characterName.append(cName);

        characterHP = (TextView) v.findViewById(R.id.characterHP);
        String cHP = CharacterData.getMyHitPoints() + "/" + CharacterData.getMyMaxHitPoints();
        characterHP.append(cHP);

        characterPortrait = (ImageView) v.findViewById(R.id.characterPortrait);
        characterPortrait.setImageResource(R.drawable.fighter);

        Button add = (Button) v.findViewById(R.id.increase_hit_points_button);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long tempHP = CharacterData.getMyHitPoints();
                tempHP +=100;

                if(tempHP > CharacterData.getMyMaxHitPoints()) {
                    tempHP = CharacterData.getMyMaxHitPoints();
                } else if(tempHP < 0) {
                    tempHP = 0;
                }

                String text = "myHitPoints: " + tempHP + "/" + CharacterData.getMyMaxHitPoints();
                CharacterData.setMyHitPoints(tempHP);
                characterHP.setText(text);
            }
        });

        Button subtract = (Button) v.findViewById(R.id.decrease_hit_points_button);
        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long tempHP = CharacterData.getMyHitPoints();
                tempHP -=100;

                if(tempHP > CharacterData.getMyMaxHitPoints()) {
                    tempHP = CharacterData.getMyMaxHitPoints();
                } else if(tempHP < 0) {
                    tempHP = 0;
                }

                String text = "myHitPoints: " + tempHP + "/" + CharacterData.getMyMaxHitPoints();
                CharacterData.setMyHitPoints(tempHP);
                characterHP.setText(text);
            }
        });

        return v;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        // Make sure that we are currently visible
        if (this.isVisible()) {
            // Method to change things when coming into focus
            onShowFragment();
            if (!isVisibleToUser) {
                // Method to change things when leaving focus
                onHideFragment();
            }
        }
    }

    public void onShowFragment() {

        characterHP = (TextView) getView().findViewById(R.id.characterHP);
        String text = "myHitPoints: " + CharacterData.getMyHitPoints() + "/" + CharacterData.getMyMaxHitPoints();
        characterHP.setText(text);
    }

    public void onHideFragment() {

    }






    public static CharacterFragment newInstance(String text) {

        CharacterFragment f = new CharacterFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);



        return f;
    }
}