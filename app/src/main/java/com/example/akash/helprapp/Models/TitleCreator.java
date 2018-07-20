package com.example.akash.helprapp.Models;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akash on 23-06-2018.
 */

public class TitleCreator {
    static TitleCreator titleCreator;
    static List<TitleParent> titleParent;

    public TitleCreator(Context context){
        titleParent=new ArrayList<>();
        /*
        for(int i=1;i<=100;i++){
            TitleParent title=new TitleParent(String.format("Caller UID :"+i,i));
            _titleParent.add(title);
        }
        */
        TitleParent ngo1=new TitleParent("Ngo One","Dog",1);
        TitleParent ngo2=new TitleParent("Ngo Two","Dog",2);
        TitleParent ngo3=new TitleParent("Ngo Three","Dog",3);
        TitleParent ngo4=new TitleParent("Ngo Four","Dog",4);
        TitleParent ngo5=new TitleParent("Ngo Five","Dog",5);
        TitleParent ngo6=new TitleParent("Ngo Six","Dog",6);
        TitleParent ngo7=new TitleParent("Ngo Seven","Dog",7);
        TitleParent ngo8=new TitleParent("Ngo Eight","Dog",8);
        TitleParent ngo9=new TitleParent("Ngo Nine","Dog",9);
        TitleParent ngo10=new TitleParent("Ngo Ten","Dog",10);

        titleParent.add(ngo1);titleParent.add(ngo2);
        titleParent.add(ngo3);titleParent.add(ngo4);
        titleParent.add(ngo5);titleParent.add(ngo6);
        titleParent.add(ngo7);titleParent.add(ngo8);
        titleParent.add(ngo9);titleParent.add(ngo10);
    }
    public static TitleCreator get(Context context){
            if(titleCreator==null)
                titleCreator=new TitleCreator(context);
            return titleCreator;
    }

    public List<TitleParent> getAll() {
        return titleParent;
    }
}
