package com.example.colculationart;

import java.util.ArrayList;

public class CompareStat {
    public static ArrayList<Integer> getWhach(ArrayList<Character> CharacterList, int[] ArtStat){
        ArrayList<Integer> SuitableList = new ArrayList<Integer>();
        for(int i=0; i < CharacterList.size();i++){
            //System.out.println(CharacterList.size());
            if(CharacterList.get(i).arr_i_bst_chr_art_stats[0] == ArtStat[0]){
                //System.out.println(CharacterList.get(i).id_chr_name);
                SuitableList.add(CharacterList.get(i).id_chr_name);
            }
        }
        for(int i=0; i < SuitableList.size() ;i++){
            int countRequiredStat = 0;
            for(int j=3; j < CharacterList.get(SuitableList.get(i)-1).arr_i_bst_chr_art_stats.length;j++) {
                if (CharacterList.get(SuitableList.get(i)-1).arr_i_bst_chr_art_stats[j] == ArtStat[1] ||
                    CharacterList.get(SuitableList.get(i)-1).arr_i_bst_chr_art_stats[j] == ArtStat[2] ||
                    CharacterList.get(SuitableList.get(i)-1).arr_i_bst_chr_art_stats[j] == ArtStat[3]||
                    CharacterList.get(SuitableList.get(i)-1).arr_i_bst_chr_art_stats[j] == ArtStat[4]) {
                    countRequiredStat++;
                }
                System.out.println(countRequiredStat);
            }
        }
        return SuitableList;
    }
    public static ArrayList<Integer> getGoblet(ArrayList<Character> CharacterList, int[] ArtStat){
        ArrayList<Integer> SuitableList = new ArrayList<Integer>();
        for(int i=0; i < CharacterList.size();i++){
            //System.out.println(CharacterList.size());
            if(CharacterList.get(i).arr_i_bst_chr_art_stats[0] == ArtStat[0]){
                SuitableList.add(CharacterList.get(i).id_chr_name);
            }
        }
        return SuitableList;
    }
    public static ArrayList<Integer> getHat(ArrayList<Character> CharacterList, int[] ArtStat){
        ArrayList<Integer> SuitableList = new ArrayList<Integer>();
        for(int i=0; i < CharacterList.size();i++){
            //System.out.println(CharacterList.size());
            if(CharacterList.get(i).arr_i_bst_chr_art_stats[0] == ArtStat[0]){
                SuitableList.add(CharacterList.get(i).id_chr_name);
            }
        }
        return SuitableList;
    }
}
