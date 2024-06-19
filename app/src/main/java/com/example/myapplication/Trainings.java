package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.ListAdapters.CompetitionsAdapter;
import com.example.myapplication.ListAdapters.TrainingsAdapter;
import com.example.myapplication.ListClasses.ListCompetitions;
import com.example.myapplication.ListClasses.ListTrainings;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Trainings extends AppCompatActivity {

    RecyclerView TrainingsListRecycler;

    TrainingsAdapter TrainingsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_trainings);

        List<ListTrainings> ListTrainings = new ArrayList<>();
        ListTrainings.add(new ListTrainings(1, "Елисей","Ярославович", LocalDate.of(2027, 1, 22)));
        ListTrainings.add(new ListTrainings(2, "Олег","Дмитриевич",LocalDate.of(2027, 1, 22)));
        ListTrainings.add(new ListTrainings(3, "Дмитрий","Самойлов",LocalDate.of(2027, 1, 22)));
        ListTrainings.add(new ListTrainings(4, "Анна","Базитова",LocalDate.of(2027, 1, 22)));

        setTrainingsListRecycler(ListTrainings);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void setTrainingsListRecycler(List<ListTrainings> listTrainings) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        TrainingsListRecycler = findViewById(R.id.ListTrainings);
        TrainingsListRecycler.setLayoutManager(layoutManager);

        TrainingsAdapter = new TrainingsAdapter(this, listTrainings);

        TrainingsListRecycler.setAdapter(TrainingsAdapter);
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

    public void CreateTraining (View v){
        Intent intent = new Intent(this, CreateTraining.class);
        startActivity(intent);
    }

}