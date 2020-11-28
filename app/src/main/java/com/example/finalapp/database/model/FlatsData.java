package com.example.finalapp.database.model;

public class FlatsData {

    public static Flat[] populateFlatData(){
        return  new Flat[]{
                new Flat(1,"Gliwice - Pawła Stalmacha 22 / ",1200, 44 ),
                new Flat(2,"Gliwice - Kujawska 12 / ",1100, 18 ),
                new Flat(3,"Gliwice - Pszczyńska 7 / ",900, 33 ),
                new Flat(4,"Gliwice - Zwycięstwa 22 / ",850, 5 ),
                new Flat(5,"Gliwice - Jasnogórska 4 / ",600, 21 )
        };
    }
}
