package com.yuandika.seahawksoffensivestartinglineup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class HalamanUtamaAdapter extends RecyclerView.Adapter<HalamanUtamaAdapter.ListViewHolder>{
    private ArrayList<Player> listPlayer;

    public HalamanUtamaAdapter(ArrayList<Player> list) {
        this.listPlayer = list;
    }

    @NonNull
    @Override
    public HalamanUtamaAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.halaman_utama, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HalamanUtamaAdapter.ListViewHolder holder, int position) {
        Player player = listPlayer.get(position);
        Glide.with(holder.itemView.getContext())
                .load(player.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);
        holder.tvName.setText(player.getName());
        holder.tvDetail.setText(player.getDetail());

    }

    @Override
    public int getItemCount() {
        return listPlayer.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDetail;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
        }
    }
}
