package com.example.colculationart;

import java.util.ArrayList;

class Character {
    int id_chr_name;
    int id_main_set;
    // [0] - Часы, [1] - Кубок, [2] - Голова, [3] - Тир 1 доп стат, [4] - Тир 2 доп стат [3] - Тир 1 доп стат
    int arr_i_bst_chr_art_stats[] = new int[10];


    public Character(int id_name, int main_set, int art_stat[]) {
        this.id_chr_name = id_name;
        this.id_main_set = main_set;
        for (int i = 0; i < art_stat.length; i++) {
            this.arr_i_bst_chr_art_stats[i] = art_stat[i];
        }
    }
    public Character addToList(ArrayList<Character> CharacterList) {
        CharacterList.add(this);
        return this;
    }
}
