package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.ListAdapters.ClientsAdapter;
import com.example.myapplication.ListAdapters.CompetitionAdapter;
import com.example.myapplication.ListClasses.ListClients;
import com.example.myapplication.ListClasses.ListCompetition;

import java.util.ArrayList;
import java.util.List;

public class Competition extends AppCompatActivity {

    RecyclerView CompetListRecycler;

    CompetitionAdapter CompetitionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_competition);

        TextView NameOfCompetition = findViewById(R.id.NameOfCompetition);
        TextView CompetAddress = findViewById(R.id.CompetAddress);
        TextView CompetDate = findViewById(R.id.CompetDate);

        NameOfCompetition.setText(getIntent().getStringExtra("NameOfCompetition"));
        CompetAddress.setText(getIntent().getStringExtra("CompetAddress"));
        CompetDate.setText(getIntent().getStringExtra("CompetDate"));

        List<ListCompetition> CompetitionList = new ArrayList<>();
        CompetitionList.add(new ListCompetition(1, "Яна","Базитова"));
        CompetitionList.add(new ListCompetition(2, "Виталий","Фещенко"));

        setCompetitionListRecycler(CompetitionList);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void setCompetitionListRecycler(List<ListCompetition> competitionList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        CompetListRecycler = findViewById(R.id.CompetitionList);
        CompetListRecycler.setLayoutManager(layoutManager);

        CompetitionAdapter = new CompetitionAdapter(this, competitionList);

        CompetListRecycler.setAdapter(CompetitionAdapter);

    }

    public void WorkoutBtnClick (View v){
        Intent intent = new Intent(this, Trainings.class);
        startActivity(intent);
    }

    public void ClientsBtnClick (View v){
        Intent intent = new Intent(this, Clients.class);
        startActivity(intent);
    }

    public void CompetBtnClick (View v){
        Intent intent = new Intent(this, Competitions.class);
        startActivity(intent);
    }

    public void ProfileBtnClick (View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}