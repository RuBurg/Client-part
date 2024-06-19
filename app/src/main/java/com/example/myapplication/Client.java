package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Client extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_client);

        TextView ClientsName = findViewById(R.id.ClientsName);
        TextView ClientsSName = findViewById(R.id.ClientsSName);

        ClientsName.setText(getIntent().getStringExtra("ClientName"));
        ClientsSName.setText(getIntent().getStringExtra("ClientSName"));

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

    public void Measures (View v){
        Intent intent = new Intent(this, Measure.class);
        startActivity(intent);
    }

    public void btnEditClient (View v){
        EditClientDialog();
    }

    public void EditClientDialog () {
        AlertDialog.Builder builder = new AlertDialog.Builder(Client.this);

        final LinearLayout layoutClient = getLinearLayout();

        builder.setTitle("Изменить данные")
                .setCancelable(false)
                .setView(layoutClient)

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

    @NonNull
    private LinearLayout getLinearLayout() {
        final LinearLayout layoutClient = new LinearLayout(this);
        layoutClient.setOrientation(LinearLayout.VERTICAL);

        final EditText inputClientName = new EditText(this);
        final EditText inputClientSName= new EditText(this);
        final EditText inputClientPhone = new EditText(this);
        final EditText inputClientAge = new EditText(this);
        final EditText inputClientGoal = new EditText(this);
        final EditText inputClientNote = new EditText(this);

        inputClientName.setHint("Имя");
        inputClientSName.setHint("Фамилия");
        inputClientPhone.setHint("Телефон");
        inputClientAge.setHint("Возраст");
        inputClientAge.setInputType(InputType.TYPE_CLASS_NUMBER);
        inputClientGoal.setHint("Цель");
        inputClientNote.setHint("Заметки");
        inputClientNote.setInputType(InputType.TYPE_TEXT_VARIATION_LONG_MESSAGE);

        layoutClient.addView(inputClientName);
        layoutClient.addView(inputClientSName);
        layoutClient.addView(inputClientPhone);
        layoutClient.addView(inputClientAge);
        layoutClient.addView(inputClientGoal);
        layoutClient.addView(inputClientNote);
        return layoutClient;
    }

}