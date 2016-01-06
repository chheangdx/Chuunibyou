package com.chheang.chuunibyou.Data;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chheang.chuunibyou.R;

import java.util.ArrayList;

/**
 * Created by User on 1/5/2016.
 */
public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>{
    private LayoutInflater inflater;
    ArrayList<Data> data = new ArrayList<Data>();

    public Adapter(Context context, ArrayList<Data> data){
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Data current = data.get(position);
        holder.name.setText(current.getName());
        holder.description.setText(current.getDescription());

        //TODO set icon
    }
    @Override
    public int getItemCount() {
        return 0;
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView icon;
        TextView name, description;

        public MyViewHolder(View itemView){
            super(itemView);
            icon = (ImageView) itemView.findViewById(R.id.list_item_icon);
            name = (TextView) itemView.findViewById(R.id.list_item_name);
            description = (TextView) itemView.findViewById(R.id.list_item_description);
        }
    }
}
