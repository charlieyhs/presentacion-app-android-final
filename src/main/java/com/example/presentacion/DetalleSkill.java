package com.example.presentacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetalleSkill extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_skill);

        TextView skillTitle = findViewById(R.id.detalleTitle);
        TextView skillInfo = findViewById(R.id.detalleNewsTitle);
        ImageView skillImage = findViewById(R.id.detalleSkillImage);

        skillTitle.setText(getIntent().getStringExtra("title"));
        skillInfo.setText(getIntent().getStringExtra("info"));
        skillImage.setImageResource(getIntent().getIntExtra("image_resource",0));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Glide.with(this).load(getIntent().getIntExtra("image_resource",0)).into(skillImage);
    }
}