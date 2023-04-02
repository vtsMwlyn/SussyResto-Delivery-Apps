package com.example.sussyrestodeliveryapps;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CartFragment extends Fragment {
    TextView outpPrice, outpDeliveryFee, outpTotalPayment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        Bundle orderData = getArguments();
        ArrayList<String> orderList = orderData.getStringArrayList("list");

        String[] nameList = new String[orderList.size()];
        int[] menuList = new int[orderList.size()];
        String[] priceList = new String[orderList.size()];

        for(int i = 0; i < orderList.size(); i++){
            if(orderList.get(i).equals("Burger")){
                nameList[i] = orderList.get(i);
                menuList[i] = R.drawable.burger;
                priceList[i] = "Rp 32.000,-";
            }

            else if(orderList.get(i).equals("Tebs 330 ml")){
                nameList[i] = orderList.get(i);
                menuList[i] = R.drawable.tebs;
                priceList[i] = "Rp 5.000,-";
            }

            else if(orderList.get(i).equals("Pizza")){
                nameList[i] = orderList.get(i);
                menuList[i] = R.drawable.pizza;
                priceList[i] = "Rp 32.000,-";
            }

            else if(orderList.get(i).equals("Burger Pizza")){
                nameList[i] = orderList.get(i);
                menuList[i] = R.drawable.burger_pizza;
                priceList[i] = "Rp 60.000,-";
            }

            else if(orderList.get(i).equals("Taco")){
                nameList[i] = orderList.get(i);
                menuList[i] = R.drawable.taco;
                priceList[i] = "Rp 25.000,-";
            }

            else if(orderList.get(i).equals("Chicken Steak")){
                nameList[i] = orderList.get(i);
                menuList[i] = R.drawable.chicken_steak;
                priceList[i] = "Rp 30.000,-";
            }

            else if(orderList.get(i).equals("Coke 330 ml")){
                nameList[i] = orderList.get(i);
                menuList[i] = R.drawable.coke;
                priceList[i] = "Rp 9.000,-";
            }

            else if(orderList.get(i).equals("Fanta 330 ml")){
                nameList[i] = orderList.get(i);
                menuList[i] = R.drawable.fanta;
                priceList[i] = "Rp 8.000,-";
            }
        }

        Adaptus adapter = new Adaptus(this.getContext(), nameList, menuList, priceList);
        ListView lv = view.findViewById(R.id.order_item_list);
        lv.setAdapter(adapter);

        outpPrice = view.findViewById(R.id.price);
        outpDeliveryFee = view.findViewById(R.id.delivery_fee);
        outpTotalPayment = view.findViewById(R.id.total_payment);

        int price = 0;
        for(String s : orderList){
            if(s.equals("Burger") || s.equals("Pizza")){
                price += 32000;
            }

            else if(s.equals("Tebs 330 ml")){
                price += 5000;
            }

            else if(s.equals("Burger Pizza")){
                price += 60000;
            }

            else if(s.equals("Taco")){
                price += 25000;
            }

            else if(s.equals("Chicken Steak")){
                price += 30000;
            }

            else if(s.equals("Coke 330 ml")){
                price += 9000;
            }
            else if(s.equals("Fanta 330 ml")){
                price += 8000;
            }
        }

        int deliveryFee = 8000;
        int totalPayment = price + deliveryFee;

        outpPrice.setText("Rp " + price + ",-");
        outpDeliveryFee.setText("Rp " + deliveryFee + ",-");
        outpTotalPayment.setText("Rp " + totalPayment + ",-");

        return view;
    }
}