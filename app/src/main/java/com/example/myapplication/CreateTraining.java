package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.ListAdapters.ClientsAddAdapter;
import com.example.myapplication.ListClasses.ListClientsAdd;

import java.util.ArrayList;
import java.util.List;

public class CreateTraining extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_training);
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

    public void NewClientBtnClick (View v){
        newClientAlertDialog();
    }

    public void btnAddExe (View v){
        CreateTrainingDialog();
    }

    public void CreateTrainingDialog () {
        AlertDialog.Builder builder = new AlertDialog.Builder(CreateTraining.this);

        final LinearLayout layoutTraining = new LinearLayout(this);
        layoutTraining.setOrientation(LinearLayout.VERTICAL);

        final EditText inputExe = new EditText(this);
        final EditText inputFExeLink = new EditText(this);

        inputExe.setHint("Упражнение");
        inputFExeLink.setHint("Ссылка");

        layoutTraining.addView(inputExe);
        layoutTraining.addView(inputFExeLink);

        builder.setTitle("Изменить данные")
                .setCancelable(false)
                .setView(layoutTraining)

                .setPositiveButton("Сохранить", new DialogInterface.OnClickListener() {
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

    public void newClientAlertDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(CreateTraining.this);

        LayoutInflater inflater = getLayoutInflater();
        View dialogView = (View) inflater.inflate(R.layout.training_dialog_list, null);
        builder.setView(dialogView);

        List<ListClientsAdd> ClientsListAdd = new ArrayList<>();
        ClientsListAdd.add(new ListClientsAdd(1, "Олег","Ярославович"));
        ClientsListAdd.add(new ListClientsAdd(2, "Олег","Дмитриевич"));
        ClientsListAdd.add(new ListClientsAdd(3, "Дмитрий","Самойлов"));
        ClientsListAdd.add(new ListClientsAdd(4, "Анна","Базитова"));

        RecyclerView rv = (RecyclerView) dialogView.findViewById(R.id.recyclerViewTrainingClient);
        ClientsAddAdapter adapter = new ClientsAddAdapter(this, ClientsListAdd);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);

        builder.setTitle("Добавить клиента")
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