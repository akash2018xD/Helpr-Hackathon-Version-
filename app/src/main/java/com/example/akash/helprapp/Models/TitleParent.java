package com.example.akash.helprapp.Models;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.List;
import java.util.UUID;

/**
 * Created by Akash on 23-06-2018.
 */

public class TitleParent implements ParentObject {
    private List<Object> mChildrenList;
    private String nameOfNgo;
    private UUID id;
    private String animalNgoHelps;
    private int rank;

    public TitleParent(String nameOfNgo,String animalNgoHelps,int rank) {
        this.nameOfNgo = nameOfNgo;
        this.animalNgoHelps=animalNgoHelps;
        this.rank=rank;
        this.id = UUID.randomUUID();
    }
    public String getNameOfNgo(){
        return nameOfNgo;
    }

    public void setNameOfNgo(String nameOfNgo){
        this.nameOfNgo = nameOfNgo;
    }

    public String getanimalNgoHelps(){
        return animalNgoHelps;
    }
    public void setanimalNgoHelps(String animalNgoHelps){
        this.animalNgoHelps=animalNgoHelps;
    }
    public void setrank(int rank){
        this.rank=rank;
    }
    public int getrank(){
        return rank;
    }
    public UUID getid() {
        return id;
    }

    public void setid(UUID _id) {
        this.id = _id;
    }

    @Override
    public List<Object> getChildObjectList() {
        return mChildrenList;
    }

    @Override
    public void setChildObjectList(List<Object> list) {
        mChildrenList=list;
    }
}
