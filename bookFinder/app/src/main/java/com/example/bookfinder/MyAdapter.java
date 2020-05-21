package com.example.bookfinder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    Context ct;
    String[] branches;
    int images[];

    public MyAdapter(MainActivity mainActivity, String[] branches, int[] images) {
        ct = mainActivity;
        this.branches = branches;
        this.images = images;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(ct).inflate(R.layout.row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv.setText(branches[position]);
        holder.iv.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return branches.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv;
        CircleImageView iv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv  = itemView.findViewById(R.id.tv);
            iv = itemView.findViewById(R.id.iv);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int i = getAdapterPosition();
            Intent intent = new Intent(ct,Branch.class);
            intent.putExtra("key",branches[i]);
            ct.startActivity(intent);

        }
    }
}
