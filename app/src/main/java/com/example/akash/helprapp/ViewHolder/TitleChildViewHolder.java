package com.example.akash.helprapp.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import com.example.akash.helprapp.R;

/**
 * Created by Akash on 23-06-2018.
 */

public class TitleChildViewHolder extends ChildViewHolder {
    public TextView textAmount;
    public ImageView minusButton;
    public TextView moneyText;
    public ImageView plusButton;
    public TextView colonText;
    public ImageView nextButton;

    public TitleChildViewHolder(View itemView){
        super(itemView);
        textAmount=(TextView)itemView.findViewById(R.id.textAmount);
        minusButton=(ImageView) itemView.findViewById(R.id.minusButton);
        moneyText=(TextView)itemView.findViewById(R.id.moneyText);
        plusButton=(ImageView)itemView.findViewById(R.id.plusButton);
        colonText=(TextView)itemView.findViewById(R.id.colonText);
        nextButton=(ImageView) itemView.findViewById(R.id.nextButton);

    }
}
