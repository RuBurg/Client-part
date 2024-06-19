package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
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

    public void btnEdit (View v){
        showAlertDialog();
    }

    public void showAlertDialog () {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        final LinearLayout layoutProfile = getLinearLayout();

        builder.setTitle("Изменить данные")
                .setCancelable(false)
                .setView(layoutProfile)

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
        final LinearLayout layoutProfile = new LinearLayout(this);
        layoutProfile.setOrientation(LinearLayout.VERTICAL);

        final EditText inputUserName = new EditText(this);
        final EditText inputFirstName = new EditText(this);
        final EditText inputSecondName = new EditText(this);

        inputUserName.setHint("Username");
        inputFirstName.setHint("Имя");
        inputSecondName.setHint("Фамилия");

        layoutProfile.addView(inputUserName);
        layoutProfile.addView(inputFirstName);
        layoutProfile.addView(inputSecondName);
        return layoutProfile;
    }

}