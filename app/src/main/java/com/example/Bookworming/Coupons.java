package com.example.bookworms;

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

    public boolean checkpoints(){//todo μεταφορα σε User

        return false;
    }

    public int applydiscount(int price, int discount){

        //checkout
        price -= (price*discount)/100;
        return  price;
    }
}
