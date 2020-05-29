package com.example.Bookworming;

public class Coupons{

    int id;
    float discount;
    String name;
    int points;

    public Coupons(int i_d, float disc, String na){

        id = i_d;
        discount = disc;
        name = na;
    }

    public boolean checkpoints(int user_points){

        if(user_points >= points) return true;
        else return false;
    }

    public int applydiscount(int price, int discount){

        //checkout
        price -= (price*discount)/100;
        return  price;
    }
}
