package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;

import com.example.myapplication.ListAdapters.ClientsAddAdapter;
import com.example.myapplication.ListClasses.ListClientsAdd;

import java.util.ArrayList;
import java.util.List;

public class CreateCompetition extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_competition);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
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
    public void CreateAnotherCompetition (View v){
        //создать соревнование
    }
    public void AddClientToCompetition (View v){
        showAlertDialog();
    }

    public void showAlertDialog () {
        AlertDialog.Builder builder = new AlertDialog.Builder(CreateCompetition.this);

        LayoutInflater inflater = getLayoutInflater();
        View dialogView = (View) inflater.inflate(R.layout.dialog_list, null);
        builder.setView(dialogView);

        List<ListClientsAdd> ClientsListAdd = new ArrayList<>();
        ClientsListAdd.add(new ListClientsAdd(1, "Елисей","Ярославович"));
        ClientsListAdd.add(new ListClientsAdd(2, "Олег","Дмитриевич"));
        ClientsListAdd.add(new ListClientsAdd(3, "Дмитрий","Самойлов"));
        ClientsListAdd.add(new ListClientsAdd(4, "Анна","Базитова"));

        RecyclerView rv = (RecyclerView) dialogView.findViewById(R.id.recyclerViewAdd);
        ClientsAddAdapter adapter = new ClientsAddAdapter(this, ClientsListAdd);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);

        builder.setTitle("Добавить клиентов")
                .setCancelable(false)
                .setPositiveButton("Добавить", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

}