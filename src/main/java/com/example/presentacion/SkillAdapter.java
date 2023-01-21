package com.example.presentacion;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class SkillAdapter extends RecyclerView.Adapter<SkillAdapter.ViewHolder> {

    private final ArrayList<Skill> mSkillData;
    private final Context mContext;


    SkillAdapter(Context context, ArrayList<Skill> skillData){
        this.mContext = context;
        this.mSkillData = skillData;
    }

    @NonNull
    @Override
    public SkillAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_skills,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SkillAdapter.ViewHolder holder, int position) {
        Skill currentSkill = mSkillData.get(position);

        holder.bindTo(currentSkill);
    }

    @Override
    public int getItemCount() {
        return mSkillData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final TextView mTitleText;
        private final TextView mSubTitle;
        private final TextView mInfoText;
        private final ImageView mSkillImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mTitleText = itemView.findViewById(R.id.title);
            mInfoText = itemView.findViewById(R.id.subTitle);
            mSubTitle = itemView.findViewById(R.id.newsTitle);
            mSkillImage = itemView.findViewById(R.id.skillImage);

            itemView.setOnClickListener(this);
        }

        public void bindTo(@NonNull Skill currentSkill){
            mTitleText.setText(currentSkill.getTitle());
            mInfoText.setText(currentSkill.getInfo());
            mSubTitle.setText(currentSkill.getSubTitle());
            mSkillImage.setImageResource( currentSkill.getImageResource());

        }

        @Override
        public void onClick(View view) {
            Skill currentSkill = mSkillData.get(getAdapterPosition());

            Intent detailIntent = new Intent(mContext, DetalleSkill.class);
            detailIntent.putExtra("title",currentSkill.getTitle());
            detailIntent.putExtra("info",currentSkill.getInfo());
            detailIntent.putExtra("image_resource", currentSkill.getImageResource());

            mContext.startActivity(detailIntent);
        }
    }

}









