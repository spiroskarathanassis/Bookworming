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

    public boolean checkpoints(User user){

        if(user.getPoints() >= points) return true;
        else return false;
    }

    public int applydiscount(int price, int discount){

        //checkout
        price -= (price*discount)/100;
        return  price;
    }
}
