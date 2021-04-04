package com.example.informationapp2021;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Shop extends Fragment {

    private int ButtonClicks;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View shopView  = inflater.inflate(R.layout.shop, container, false);

        final TextView character1Cost = (TextView) shopView.findViewById(R.id.character1Coins);
        final TextView character2Cost = (TextView) shopView.findViewById(R.id.character2Coins);
        final TextView character3Cost = (TextView) shopView.findViewById(R.id.character3Coins);
       /* final TextView character4Cost = (TextView) shopView.findViewById(R.id.character4Coins);
        final TextView character5Cost = (TextView) shopView.findViewById(R.id.character5Coins);*/

        final ImageView Image1 = (ImageView) shopView.findViewById(R.id.character1);
        final ImageView Image2 = (ImageView) shopView.findViewById(R.id.character2);
        final ImageView Image3 = (ImageView) shopView.findViewById(R.id.character3);
        /*final ImageView Image4 = (ImageView) shopView.findViewById(R.id.character4);
        final ImageView Image5 = (ImageView) shopView.findViewById(R.id.character5);*/



        Button purchaseButton1 = (Button) shopView.findViewById(R.id.character1PurchaseButton);
        Button purchaseButton2 = (Button) shopView.findViewById(R.id.character2PurchaseButton);
        Button purchaseButton3 = (Button) shopView.findViewById(R.id.character3PurchaseButton);
      /*  Button purchaseButton4 = (Button) shopView.findViewById(R.id.character4PurchaseButton);
        Button purchaseButton5 = (Button) shopView.findViewById(R.id.character5PurchaseButton);*/

        purchaseButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonClicks = 0;
                if (ButtonClicks == 0) {
                    character1Cost.setText(R.string.characterPurchased);
                    Image1.setImageResource(R.drawable.bear_character);
                    ButtonClicks = 1;
                }else if (ButtonClicks > 0){
                    makeToast();
                }
            }
        });

        purchaseButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonClicks = 0;
                if (ButtonClicks == 0) {
                    character2Cost.setText(R.string.characterPurchased);
                    Image2.setImageResource(R.drawable.antelope_character);
                    ButtonClicks = 1;
                }else if (ButtonClicks > 0){
                    makeToast();
                }
            }
        });

        purchaseButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonClicks = 0;
                if (ButtonClicks == 0) {
                    character3Cost.setText(R.string.characterPurchased);
                    Image3.setImageResource(R.drawable.frog_character);
                    ButtonClicks = 1;
                }else if (ButtonClicks > 0){
                    makeToast();
                }
            }
        });

/*
        purchaseButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonClicks = 0;
                if (ButtonClicks == 0) {
                    character4Cost.setText(R.string.characterPurchased);
                    Image4.setImageResource(R.drawable.character4);
                    ButtonClicks = 1;
                }else if (ButtonClicks > 0){
                    makeToast();
                }
            }
        });

        purchaseButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonClicks = 0;
                if (ButtonClicks == 0) {
                    character5Cost.setText(R.string.characterPurchased);
                    Image5.setImageResource(R.drawable.character5);
                    ButtonClicks = 1;
                }else if (ButtonClicks > 0){
                    makeToast();
                }
            }
        });
*/


        return shopView;
    }

    public void makeToast(){
        Toast CharacterPurchased = Toast.makeText(getContext(), "Character has already been purchased!", Toast.LENGTH_LONG);
        CharacterPurchased.show();
    }
}
