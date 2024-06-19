package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.annotation.SuppressLint;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.DB.clientModel;
import com.example.myapplication.retrofit.RetrofitService;
import com.example.myapplication.retrofit.clientAPI;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateClient extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_client);

        initializeComponents();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void initializeComponents() {

        EditText inputEditName = findViewById(R.id.EditClientName);
        EditText inputEditSNme = findViewById(R.id.EditClientSName);
        EditText inputEditPhone = findViewById(R.id.EditPhone);
        EditText inputEditAge = findViewById(R.id.EditAge);
        EditText inputEditGoal = findViewById(R.id.EditGoal);
        EditText inputEditNotes = findViewById(R.id.EditNotes);

        @SuppressLint("WrongViewCast") MaterialButton SaveButton = findViewById(R.id.SaveClient);

        RetrofitService retrofitService = new RetrofitService();
        clientAPI clientAPI = retrofitService.getRetrofit().create(clientAPI.class);

        SaveButton.setOnClickListener(view -> {
                String ClientName = inputEditName.getText().toString();
                String ClientSName = inputEditSNme.getText().toString();
                String ClientPhone = inputEditPhone.getText().toString();
                int ClientAge = Integer.parseInt(inputEditAge.getText().toString());
                String ClientGoal = inputEditGoal.getText().toString();
                String ClientNotes = inputEditNotes.getText().toString();

                clientModel client = new clientModel();
                client.setFirst_name(ClientName);
                client.setSecond_name (ClientSName);
                client.setPhone_number(ClientPhone);
                client.setAge(ClientAge);
                client.setGoal(ClientGoal);
                client.setNotes_about_client(ClientNotes);

            clientAPI.save(client)
                    .enqueue(new Callback<clientModel>() {
                        @Override
                        public void onResponse(Call<clientModel> call, Response<clientModel> response) {
                            Toast.makeText(CreateClient.this, "Save successful!", Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onFailure(Call<clientModel> call, Throwable throwable) {
                            Toast.makeText(CreateClient.this, "Save failed!", Toast.LENGTH_SHORT).show();
                        }
                    });
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

}