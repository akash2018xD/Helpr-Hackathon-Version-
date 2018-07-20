package com.example.akash.helprapp.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;
import com.example.akash.helprapp.R;

/**
 * Created by Akash on 23-06-2018.
 */

public class TitleParentViewHolder extends ParentViewHolder {
    public ImageView ngoProfilePicture;
    public TextView ngoNameText;
    public TextView animalNgoHelpsText;
    public TextView rankText;
    public TextView rankAmountText;
    public ImageView downArrowButton;

    public TitleParentViewHolder(View itemView){
        super(itemView);
        ngoProfilePicture=(ImageView)itemView.findViewById(R.id.ngoprofilepic);
        ngoNameText=(TextView)itemView.findViewById(R.id.ngonametext);
        animalNgoHelpsText=(TextView)itemView.findViewById(R.id.animalngohelpstext);
        rankText=(TextView)itemView.findViewById(R.id.ranktext);
        rankAmountText=(TextView)itemView.findViewById(R.id.rankamounttext);
        downArrowButton=(ImageView)itemView.findViewById(R.id.downarrowbutton);
    }
}
