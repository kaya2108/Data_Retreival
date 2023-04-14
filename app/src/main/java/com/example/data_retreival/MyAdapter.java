package com.example.data_retreival;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    List<Model> posts;
    public MyAdapter(List<Model> posts, Context context){
        this.posts=posts;
        this.context=context;

    }
    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_view,parent,false);

        return new MyAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        Model p=posts.get(position);
        holder.name.setText(p.getName());
        holder.regno.setText(p.getRegno());
        holder.phone.setText(p.getPhone());
        holder.size.setText(p.getSize());
        holder.comments.setText(p.getComments());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name,regno,phone,size,comments;
        Button deleteBtn;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name= itemView.findViewById(R.id.name);
            regno= itemView.findViewById(R.id.regno);
            phone= itemView.findViewById(R.id.phone);
            size= itemView.findViewById(R.id.size);
            comments= itemView.findViewById(R.id.comments);
            deleteBtn=itemView.findViewById(R.id.delete);
            deleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}
