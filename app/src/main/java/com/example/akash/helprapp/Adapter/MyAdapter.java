package com.example.akash.helprapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.example.akash.helprapp.Models.TitleChild;
import com.example.akash.helprapp.Models.TitleParent;
import com.example.akash.helprapp.R;
import com.example.akash.helprapp.ViewHolder.TitleChildViewHolder;
import com.example.akash.helprapp.ViewHolder.TitleParentViewHolder;

import java.util.List;

/**
 * Created by Akash on 23-06-2018.
 */

public class MyAdapter extends ExpandableRecyclerAdapter<TitleParentViewHolder,TitleChildViewHolder> {
    LayoutInflater inflater;

    public MyAdapter(Context context, List<ParentObject> parentItemList) {
        super(context, parentItemList);
        inflater=LayoutInflater.from(context);
    }

    @Override
    public TitleParentViewHolder onCreateParentViewHolder(ViewGroup viewGroup) {
        View view=inflater.inflate(R.layout.list_parent,viewGroup,false);
        return new TitleParentViewHolder(view);
    }

    @Override
    public TitleChildViewHolder onCreateChildViewHolder(ViewGroup viewGroup) {
        View view=inflater.inflate(R.layout.list_child,viewGroup,false);
        return new TitleChildViewHolder(view);
    }

    @Override
    public void onBindParentViewHolder(TitleParentViewHolder titleParentViewHolder, int i, Object o) {
        TitleParent title=(TitleParent)o;
        titleParentViewHolder.ngoNameText.setText(title.getNameOfNgo());
        titleParentViewHolder.animalNgoHelpsText.setText(title.getanimalNgoHelps());
        titleParentViewHolder.rankText.setText(title.getrank());
    }

    @Override
    public void onBindChildViewHolder(TitleChildViewHolder titleChidViewHolder, int i, Object o) {
        TitleChild title=(TitleChild)o;
        titleChidViewHolder.moneyText.setText(title.getMoney());
    }
}
