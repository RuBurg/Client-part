package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.ListAdapters.ClientsAdapter;
import com.example.myapplication.ListAdapters.MeasureAdapter;
import com.example.myapplication.ListClasses.ListMeasure;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Measure extends AppCompatActivity {
    RecyclerView MeasureListRecycler;

    MeasureAdapter MeasureAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_measure);

        List<ListMeasure> ListMeasure = new ArrayList<>();
        ListMeasure.add(new ListMeasure(1, LocalDate.of(2024, 1, 22), 56,25,40, 66, 40));
        ListMeasure.add(new ListMeasure(1, LocalDate.of(2024, 1, 28), 55,24,39, 65, 39));
        ListMeasure.add(new ListMeasure(1, LocalDate.of(2024, 2, 8), 55,24,40, 64, 38));
        ListMeasure.add(new ListMeasure(1, LocalDate.of(2024, 3, 15), 53,23,39, 63, 37));

        setMeasureListRecycler(ListMeasure);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void setMeasureListRecycler(List<ListMeasure> listMeasure) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        MeasureListRecycler = findViewById(R.id.ListMeasure);
        MeasureListRecycler.setLayoutManager(layoutManager);

        MeasureAdapter = new MeasureAdapter(this, listMeasure);

        MeasureListRecycler.setAdapter(MeasureAdapter);
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

    public void btnAdd (View v){
        MeasureDialog();
    }

    public void MeasureDialog () {
        AlertDialog.Builder builder = new AlertDialog.Builder(Measure.this);

        final LinearLayout layoutMeasure = getLinearLayout();

        builder.setTitle("Изменить данные")
                .setCancelable(false)
                .setView(layoutMeasure)

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
        final LinearLayout layoutMeasure = new LinearLayout(this);
        layoutMeasure.setOrientation(LinearLayout.VERTICAL);

        final EditText inputDate = new EditText(this);
        final EditText inputWeight = new EditText(this);
        final EditText inputArm = new EditText(this);
        final EditText inputChest = new EditText(this);
        final EditText inputWaist = new EditText(this);
        final EditText inputHip = new EditText(this);

        inputDate.setHint("Дата");
        inputDate.setInputType(InputType.TYPE_DATETIME_VARIATION_DATE);
        inputWeight.setHint("Вес");
        inputArm.setHint("Обхват руки");
        inputChest.setHint("Обхват груди");
        inputWaist.setHint("Обхват талии");
        inputHip.setHint("Обхват бедра");

        layoutMeasure.addView(inputDate);
        layoutMeasure.addView(inputWeight);
        layoutMeasure.addView(inputArm);
        layoutMeasure.addView(inputChest);
        layoutMeasure.addView(inputWaist);
        layoutMeasure.addView(inputHip);
        return layoutMeasure;
    }
}