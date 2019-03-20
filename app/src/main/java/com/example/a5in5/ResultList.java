package com.example.a5in5;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ArrayAdapter;

import java.util.List;


public class ResultList extends ArrayAdapter<Result>{
    private Activity context;
    List<Result> Results;

    // constructor - bind to layout_track_list layout resource file
    public ResultList(Activity context, List<Result> Results) {

        super(context,R.layout.layout_result_list, Results);
        this.context = context;
        this.Results = Results;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater= context.getLayoutInflater();

        //reference the layout we want to bind to

        View listViewItem = inflater.inflate(R.layout.layout_result_list,null,true);

        //access the 2 textview we need to populate for each list item
        TextView textViewScore=listViewItem.findViewById(R.id.textViewScore);
        TextView textViewTopic = listViewItem.findViewById(R.id.textViewMyGrade);

        //bind the data
        Result result = Results.get(position);
        textViewScore.setText("Your Score:                                     "+String.valueOf(result.getscore())+"/5");
        textViewTopic.setText("Topic:                                              "+result.gettopic());


        //send back the populated list view item
        return listViewItem;
    }
}
