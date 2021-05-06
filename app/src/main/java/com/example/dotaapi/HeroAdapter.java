package com.example.dotaapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.ViewHolder> {
    List<HeroModel> heroList;

    public HeroAdapter(List<HeroModel>heroList) {
        this.heroList = heroList;
    }

    @NonNull
    @Override
    public HeroAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.hero_holder,null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroAdapter.ViewHolder holder, int position) {
        HeroModel hero = heroList.get(position);
        holder.mNama.setText(hero.getHeroName());
        holder.mAttribute.setText(hero.getHeroAttr());
        holder.mAttack.setText(hero.getHeroAttack());
        Glide.with(holder.itemView).load(hero.getHeroImg()).into(holder.mImg);


    }

    @Override
    public int getItemCount() {
        return heroList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mNama;
        TextView mAttribute;
        TextView mAttack;
        ImageView mImg;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mNama = itemView.findViewById(R.id.tv_name);
            mAttribute = itemView.findViewById(R.id.tv_attr);
            mAttack = itemView.findViewById(R.id.tv_attk);
            mImg = itemView.findViewById(R.id.tv_img);
        }
    }
}
