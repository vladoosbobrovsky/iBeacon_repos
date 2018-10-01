package com.example.user.myapp;

import java.util.ArrayList;
import java.util.List;

public class ModelItem {
    private String author;
    private int imgId;
    private ModelItem(String author, int imgId){
        this.author = author;
        this.imgId = imgId;

    }
    public int getImgId(){
        return imgId;

    }
    public String getAuthor(){
        return author;

    }

    public static List<ModelItem> getFakeItems(){
        ArrayList<ModelItem> itemsList = new ArrayList<>();
        itemsList.add(new ModelItem("The Scream",R.drawable.scream256));
        itemsList.add(new ModelItem("The persistence of Memory",R.drawable.persist256));
        itemsList.add(new ModelItem("Starry Night",R.drawable.staryy256));
        itemsList.add(new ModelItem("Dancers",R.drawable.dance256));
        itemsList.add(new ModelItem("The Scream",R.drawable.scream256));
        itemsList.add(new ModelItem("The Scream",R.drawable.scream256));
        itemsList.add(new ModelItem("The Scream",R.drawable.scream256));
        itemsList.add(new ModelItem("The Scream",R.drawable.scream256));
        itemsList.add(new ModelItem("The Scream",R.drawable.scream256));
        itemsList.add(new ModelItem("The Scream",R.drawable.scream256));




        return itemsList;
    }
}
