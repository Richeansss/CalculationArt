package com.example.colculationart;

import java.util.SplittableRandom;

class Character {
    int i_id_chr_name;
    int s_main_set;
    // [0] - Часы, [1] - Кубок, [2] - Голова, [3] - Тир 1 доп стат, [4] - Тир 2 доп стат [3] - Тир 1 доп стат
    int arr_i_bst_chr_art_stats[] = new int[10];


    public Character(int id_name, int main_set, int art_stat[]) {
        this.i_id_chr_name = id_name;
        this.s_main_set = main_set;
        for (int i = 0; i < art_stat.length; i++) {
            this.arr_i_bst_chr_art_stats[i] = art_stat[i];
        }
        //for (int i = 0; i < art_stat.length; i++) {
        //  System.out.print( this.arr_i_bst_chr_art_stats[i] = art_stat[i] );
        //}

    }
}
