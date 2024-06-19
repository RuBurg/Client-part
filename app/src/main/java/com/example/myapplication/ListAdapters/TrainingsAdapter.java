package com.example.myapplication.ListAdapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Competitions;
import com.example.myapplication.ListClasses.ListTrainings;
import com.example.myapplication.R;
import com.example.myapplication.Training;

import java.util.List;
//Обработчик события удаления элемента списка
public class TrainingsAdapter extends RecyclerView.Adapter<TrainingsAdapter.TrainingsAdapterViewHolder>{

    Context context;
    List<ListTrainings> ListTrainings;

    public TrainingsAdapter(Context context, List<com.example.myapplication.ListClasses.ListTrainings> listTrainings) {
        this.context = context;
        ListTrainings = listTrainings;
    }

    @NonNull
    @Override
    public TrainingsAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View categoryItems = LayoutInflater.from(context).inflate(R.layout.list_trainings, parent, false);
        return new TrainingsAdapter.TrainingsAdapterViewHolder(categoryItems);
    }

    @Override
    public void onBindViewHolder(@NonNull TrainingsAdapterViewHolder holder, int position) {
        holder.CleintNameTrainings.setText(ListTrainings.get(position).getClientName());
        holder.CleintSNameTrainings.setText(ListTrainings.get(position).getClientSName());
        holder.DateTrainings.setText(ListTrainings.get(position).getDate().toString());

        holder.itemView.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Training.class);

                intent.putExtra("ClientNameTrain",ListTrainings.get(position).getClientName());
                intent.putExtra("ClientSNameTrain",ListTrainings.get(position).getClientSName());
                intent.putExtra("DateTrain",ListTrainings.get(position).getDate().toString());
                intent.putExtra("ListOfExe",ListTrainings.get(position).getDate().toString());//Передача списка упражненеий на тренировку

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ListTrainings.size();
    }

    public static final class TrainingsAdapterViewHolder extends RecyclerView.ViewHolder{

        TextView CleintNameTrainings;
        TextView CleintSNameTrainings;

        TextView DateTrainings;
        public TrainingsAdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            CleintNameTrainings = itemView.findViewById(R.id.CleintNameTrainings);
            CleintSNameTrainings = itemView.findViewById(R.id.CleintSNameTrainings);
            DateTrainings = itemView.findViewById(R.id.DateTrainings);

        }

    }

}
