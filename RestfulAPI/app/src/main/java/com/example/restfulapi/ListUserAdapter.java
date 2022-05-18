package com.example.restfulapi;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ListUserAdapter extends RecyclerView.Adapter<ListUserAdapter.ViewHolder> {
    private List<DataItem> dataUser;
    private Context ctx;

    public ListUserAdapter(List<DataItem> dataUser, Context ctx) {
        this.dataUser = dataUser;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ListUserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ListUserAdapter.ViewHolder holder, int i) {
        //int position = i;
        holder.tvName.setText(dataUser.get(i).getFirstName());
        holder.tvLastName.setText(dataUser.get(i).getLastName());
        Glide.with(ctx).load(dataUser.get(i).getAvatar()).into(holder.imgAvatar);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(ctx, UserActivity.class);
                //in.putExtra("userId", position);
                ctx.startActivity(in);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataUser.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgAvatar;
        TextView tvName;
        TextView tvLastName;
        RelativeLayout layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAvatar = itemView.findViewById(R.id.img_avatar);
            tvName = itemView.findViewById(R.id.tv_name);
            tvLastName = itemView.findViewById(R.id.tv_last_name);
            layout = itemView.findViewById(R.id.relativeLayout);
        }
    }
}
