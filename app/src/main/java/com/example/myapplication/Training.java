package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.ListAdapters.TrainingAdapter;
import com.example.myapplication.ListClasses.ListTraining;

import java.util.ArrayList;
import java.util.List;


public class Training extends AppCompatActivity {

    RecyclerView TrainingListRecycler;

    TrainingAdapter TrainingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_training);

        //ConstraintLayout training = findViewById(R.id.trainingPG);
        TextView ClientTrain = findViewById(R.id.ClientTrain);
        TextView ClientSNameTrain = findViewById(R.id.ClientSNameTrain);
        TextView DateTrain = findViewById(R.id.DateTrain);
        //Передача спсика упражнений

        ClientTrain.setText(getIntent().getStringExtra("ClientNameTrain"));
        ClientSNameTrain.setText(getIntent().getStringExtra("ClientSNameTrain"));
        DateTrain.setText(getIntent().getStringExtra("DateTrain"));

        //Необходимо сделать подбор упражнений для этой тренировки из базы данных
        List<ListTraining> ListTraining = new ArrayList<>();
        ListTraining.add(new ListTraining(1, "Прыжки","link"));
        ListTraining.add(new ListTraining(2, "Подтягивания","link"));
        ListTraining.add(new ListTraining(3, "Отжимания","link"));
        ListTraining.add(new ListTraining(4, "Приседания","link"));

        setTrainingListRecycler(ListTraining);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.trainingPG), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void setTrainingListRecycler(List<ListTraining> listTraining) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        TrainingListRecycler = findViewById(R.id.TrainingList);
        TrainingListRecycler.setLayoutManager(layoutManager);

        TrainingAdapter = new TrainingAdapter(this, listTraining);

        TrainingListRecycler.setAdapter(TrainingAdapter);

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