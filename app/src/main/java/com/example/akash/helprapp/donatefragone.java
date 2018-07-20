package com.example.akash.helprapp;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.example.akash.helprapp.Adapter.MyAdapter;
import com.example.akash.helprapp.Models.TitleChild;
import com.example.akash.helprapp.Models.TitleCreator;
import com.example.akash.helprapp.Models.TitleParent;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class donatefragone extends Fragment {

    RecyclerView recyclerView;

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        ((MyAdapter)recyclerView.getAdapter()).onSaveInstanceState(outState);
    }

    public donatefragone() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.fragment_donatefragone, container, false);
        recyclerView=(RecyclerView)rootView.findViewById(R.id.myRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        MyAdapter adapter=new MyAdapter(this.getContext(),initData());
        adapter.setParentClickableViewAnimationDefaultDuration();
        adapter.setParentAndIconExpandOnClick(true);
        recyclerView.setAdapter(adapter);
        return rootView;
    }

    private List<ParentObject> initData() {
        TitleCreator titleCreator=TitleCreator.get(this.getContext());
        List<TitleParent> titles =titleCreator.getAll();
        List<ParentObject> parentObject=new ArrayList<>();
        for(TitleParent title:titles){
            List<Object> childList=new ArrayList<>();
            childList.add(new TitleChild("10"));
            title.setChildObjectList(childList);
            parentObject.add(title);
        }
        return parentObject;
    }

}
