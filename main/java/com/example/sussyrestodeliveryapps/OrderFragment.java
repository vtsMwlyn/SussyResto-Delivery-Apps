package com.example.sussyrestodeliveryapps;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

public class OrderFragment extends Fragment {
    Button addBurger, addTebs, addPizza, addBurgerPizza, addTaco, addChickenSteak, addCoke, addFanta;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order, container, false);

        addBurger = view.findViewById(R.id.add_burger);
        addTebs = view.findViewById(R.id.add_tebs);
        addPizza = view.findViewById(R.id.add_pizza);
        addBurgerPizza = view.findViewById(R.id.add_burgerpizza);
        addTaco = view.findViewById(R.id.add_taco);
        addChickenSteak = view.findViewById(R.id.add_chickensteak);
        addCoke = view.findViewById(R.id.add_coke);
        addFanta = view.findViewById(R.id.add_fanta);

        ArrayList<String> orderList = new ArrayList<String>();

        addBurger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean found = false;
                for(String s : orderList){
                    if(s.equals("Burger")){
                        found = true;
                        break;
                    }
                }

                if(!found){
                    orderList.add("Burger");
                }
            }
        });

        addTebs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean found = false;
                for(String s : orderList){
                    if(s.equals("Tebs 330 ml")){
                        found = true;
                        break;
                    }
                }

                if(!found){
                    orderList.add("Tebs 330 ml");
                }
            }
        });

        addPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean found = false;
                for(String s : orderList){
                    if(s.equals("Pizza")){
                        found = true;
                        break;
                    }
                }

                if(!found){
                    orderList.add("Pizza");
                }
            }
        });

        addBurgerPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean found = false;
                for(String s : orderList){
                    if(s.equals("Burger Pizza")){
                        found = true;
                        break;
                    }
                }

                if(!found){
                    orderList.add("Burger Pizza");
                }
            }
        });

        addTaco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean found = false;
                for(String s : orderList){
                    if(s.equals("Taco")){
                        found = true;
                        break;
                    }
                }

                if(!found){
                    orderList.add("Taco");
                }
            }
        });

        addChickenSteak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean found = false;
                for(String s : orderList){
                    if(s.equals("Chicken Steak")){
                        found = true;
                        break;
                    }
                }

                if(!found){
                    orderList.add("Chicken Steak");
                }
            }
        });

        addCoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean found = false;
                for(String s : orderList){
                    if(s.equals("Coke 330 ml")){
                        found = true;
                        break;
                    }
                }

                if(!found){
                    orderList.add("Coke 330 ml");
                }
            }
        });

        addFanta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean found = false;
                for(String s : orderList){
                    if(s.equals("Fanta 330 ml")){
                        found = true;
                        break;
                    }
                }

                if(!found){
                    orderList.add("Fanta 330 ml");
                }
            }
        });

        Bundle orDatBun = new Bundle();
        orDatBun.putStringArrayList("list", orderList);
        getParentFragmentManager().setFragmentResult("reqKey", orDatBun);

        return view;
    }
}