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

import com.example.myapplication.ListAdapters.ClientsAdapter;
import com.example.myapplication.ListClasses.ListClients;

import java.util.ArrayList;
import java.util.List;

public class Clients extends AppCompatActivity {

    RecyclerView ClientsListRecycler;

    ClientsAdapter ClientsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_clients);

        List<ListClients> ClientsList = new ArrayList<>();
        ClientsList.add(new ListClients(1, "Елисей","Ярославович"));
        ClientsList.add(new ListClients(2, "Олег","Дмитриевич"));
        ClientsList.add(new ListClients(3, "Дмитрий","Самойлов"));
        ClientsList.add(new ListClients(4, "Анна","Базитова"));

        setClientsListRecycler(ClientsList);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void setClientsListRecycler(List<ListClients> clientsList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        ClientsListRecycler = findViewById(R.id.ClientsList);
        ClientsListRecycler.setLayoutManager(layoutManager);

        ClientsAdapter = new ClientsAdapter(this, clientsList);

        ClientsListRecycler.setAdapter(ClientsAdapter);
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

    public void CreateClient (View v){
        Intent intent = new Intent(this, CreateClient.class);
        startActivity(intent);
    }

}