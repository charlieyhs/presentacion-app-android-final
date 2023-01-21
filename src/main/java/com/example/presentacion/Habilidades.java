package com.example.presentacion;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Habilidades extends AppCompatActivity {
    private RecyclerView cRecyclerView;
    private ArrayList<Skill> mSkillsData = new ArrayList<Skill>();
    private SkillAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habilidades);

        // inicializar el recyclerview
        cRecyclerView = findViewById(R.id.recyclerView);

        // setear el layout manager
        cRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mSkillsData = new ArrayList<>();


        mAdapter = new SkillAdapter(this, mSkillsData);
        cRecyclerView.setAdapter(mAdapter);
        initializeData();

        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.LEFT |
                                                                                        ItemTouchHelper.RIGHT |
                                                                                        ItemTouchHelper.DOWN |
                                                                                        ItemTouchHelper.UP,
                                                                                        ItemTouchHelper.LEFT |
                                                                                        ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView,
                                  @NonNull RecyclerView.ViewHolder viewHolder,
                                  @NonNull RecyclerView.ViewHolder target) {
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();
                Collections.swap(mSkillsData, from, to);
                mAdapter.notifyItemMoved(from,to);
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                mSkillsData.remove(viewHolder.getAdapterPosition());
                mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });
        helper.attachToRecyclerView(cRecyclerView);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void resetSports(View view){
        initializeData();
    }
    private void initializeData(){

        String[] skillsList = getResources()
                .getStringArray(R.array.skills_titles);

        String[] skillsInfo = getResources()
                .getStringArray(R.array.skills_info);

        TypedArray sportsImageResources =
                            getResources().obtainTypedArray(R.array.skills_images);

        mSkillsData.clear();

        for(int i=0;i < skillsList.length;i++){
            mSkillsData.add(new Skill(skillsList[i], skillsInfo[i],"Proyectos",
                                sportsImageResources.getResourceId(i,0)));
        }
        sportsImageResources.recycle();
        mAdapter.notifyDataSetChanged();
    }

}