package com.gorgonshank.manyfragments.Fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.gorgonshank.manyfragments.Main.BarcodeActivity;
import com.gorgonshank.manyfragments.Main.BattleActivity;
import com.gorgonshank.manyfragments.R;

import java.math.BigInteger;
import java.util.ArrayList;

public class BarcodeFragment extends Fragment {

    ImageView canvas;
    Button scanButton;
    ArrayList<Drawable> drawables = new ArrayList<Drawable>();
    int drawableWidth = 200;
    int drawableHeight = 200;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.barcode_fragment, container, false);

        initDrawables();

        canvas = (ImageView)v.findViewById(R.id.canvas);

        scanButton = (Button)v.findViewById(R.id.scanButton);
        scanButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), BarcodeActivity.class);
                startActivity(intent);
                getActivity().finish();

            }
        });

        Intent bcActivity = getActivity().getIntent();
        String barcode = bcActivity.getStringExtra("barcode");
        if(barcode != null){
            Log.i("Info", "Barcode is " + barcode);
            BigInteger bigBarcode = new BigInteger(barcode);
            int index = Math.abs(bigBarcode.intValue() % drawables.size());
            canvas.setImageDrawable(drawables.get(index));

            // This is the condition where we determine which method to send it to
            if(true) {
                Intent intent = new Intent(getActivity(), BattleActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        }
        else{
            Log.i("Info", "Barcode is null");
        }

        Long loot = bcActivity.getLongExtra("loot", 100l);

        if(loot != 100l && loot != null){
            Log.i("Info", "loot is " + loot);
            Integer stuff = loot.intValue();
            Log.i("Info", "loot is " + stuff);
            canvas.setImageDrawable(drawables.get(stuff));
        }
        else{
            Log.i("Info", "Loot is null");
        }



        return v;
    }

    public static BarcodeFragment newInstance(String text) {

        BarcodeFragment f = new BarcodeFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }

    public void initDrawables(){
        try {
            Drawable drawable = this.getResources().getDrawable(R.drawable.agate);
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Drawable d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.antidote);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.apple);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.armor1);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.armor2);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.armor3);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.axe1);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.axe2);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.axe3);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.banana);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.bluepotion1);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.bluepotion2);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.bow1);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.bow2);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.bow3);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.chestclosed);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.chestopen);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.crystal);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.dagger1);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.dagger2);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.dagger3);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.diamond);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.gloves1);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.gloves2);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.gloves3);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.goldbar);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.goldcoin);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.grapes);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.greenpotion1);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.greenpotion2);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.mace1);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.mace2);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.mace3);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.mushroom);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.redpotion1);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.redpotion2);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.ruby);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.sapphire);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.shield1);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.shoes1);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.shoes2);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.shoes3);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.spear1);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.spear2);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.spear3);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.sword1);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.sword2);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.sword3);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.sword4);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.sword5);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);

            drawable = this.getResources().getDrawable(R.drawable.sword6);
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, drawableWidth, drawableHeight, true));
            drawables.add(d);
        }catch(NullPointerException e){
            Log.i("Error", "The resource was not found");
        }
    }
}
