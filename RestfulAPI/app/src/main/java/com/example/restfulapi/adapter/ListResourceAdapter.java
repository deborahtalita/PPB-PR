package com.example.restfulapi.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restfulapi.ListUserAdapter;
import com.example.restfulapi.R;
import com.example.restfulapi.responses.DataResourceItem;

import java.util.List;

public class ListResourceAdapter extends RecyclerView.Adapter<ListResourceAdapter.ViewHolder> {

    private List<DataResourceItem> dataRsc;
    private Context ctx;

    public ListResourceAdapter(List<DataResourceItem> dataRsc, Context ctx) {
        this.dataRsc = dataRsc;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ListResourceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_rsc_item, parent, false);
        return new ListResourceAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ListResourceAdapter.ViewHolder holder, int i) {
        holder.tvName.setText("Name: " + dataRsc.get(i).getName());
        holder.tvYear.setText("Year: " + dataRsc.get(i).getYear());
        holder.tvColor.setText("Color: " + dataRsc.get(i).getColor());
        holder.tvPantone.setText("Pantone value: " + dataRsc.get(i).getPantoneValue());
        holder.layout.setBackgroundColor(Color.parseColor(dataRsc.get(i).getColor()));
    }

    @Override
    public int getItemCount() {
        return dataRsc.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvYear, tvColor, tvPantone;
        LinearLayout layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvYear = itemView.findViewById(R.id.tvYear);
            tvColor = itemView.findViewById(R.id.tvColor);
            tvPantone = itemView.findViewById(R.id.tvPantone);
            layout = itemView.findViewById(R.id.layout_rsc);
        }
    }
}
