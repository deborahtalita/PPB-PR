package com.example.aplikasiets;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Adapter extends
        RecyclerView.Adapter<Adapter.ViewHolder>{

    Context ctx;
    private LayoutInflater mInflater;
    ArrayList<Klub> listKlub = new ArrayList<>();
    String[] name;
    int[] rank;
    int[] poin;

    public Adapter(Context ctx, ArrayList<Klub> listKlub){
        mInflater = LayoutInflater.from(ctx);
//        this.name = name;
//        this.rank = rank;
//        this.poin = poin;
        this.listKlub = listKlub;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View klubView = mInflater.inflate(R.layout.klublist_item, viewGroup, false);
        ViewHolder vHolder = new ViewHolder(klubView);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.namaKlub.setText(listKlub.get(i).getNama());
        viewHolder.rank.setText(listKlub.get(i).getPeringkat());
        viewHolder.poin.setText(listKlub.get(i).getTotalPoin());
//        viewHolder.namaKlub.setText(name[i]);
//        viewHolder.rank.setText(rank[i]);
//        viewHolder.poin.setText(poin[i]);
    }

    @Override
    public int getItemCount() {
//        return name.length;
        return listKlub.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView namaKlub, rank, poin;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            namaKlub = (TextView) itemView.findViewById(R.id.namaKlub);
            rank = (TextView) itemView.findViewById(R.id.rank);
            poin = (TextView) itemView.findViewById(R.id.poin);
        }
    }
}
