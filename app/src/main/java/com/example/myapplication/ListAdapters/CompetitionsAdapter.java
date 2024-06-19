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

import com.example.myapplication.Competition;
import com.example.myapplication.ListClasses.ListCompetitions;
import com.example.myapplication.R;
import com.example.myapplication.Training;

import java.util.List;
//Обработчик события удаления элемента списка
public class CompetitionsAdapter extends RecyclerView.Adapter<CompetitionsAdapter.CompetitionsAdapterViewHolder> {

    Context context;
    List<ListCompetitions> ListCompetitions;

    public CompetitionsAdapter(Context context, List<com.example.myapplication.ListClasses.ListCompetitions> listCompetitions) {
        this.context = context;
        ListCompetitions = listCompetitions;
    }

    @NonNull
    @Override
    public CompetitionsAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View categoryItems = LayoutInflater.from(context).inflate(R.layout.list_competitions, parent, false);
        return new CompetitionsAdapter.CompetitionsAdapterViewHolder(categoryItems);
    }

    @Override
    public void onBindViewHolder(@NonNull CompetitionsAdapterViewHolder holder, int position) {
        holder.CompetName.setText(ListCompetitions.get(position).getCompetName());
        holder.date.setText(ListCompetitions.get(position).getDate().toString());

        holder.itemView.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Competition.class);

                intent.putExtra("NameOfCompetition",ListCompetitions.get(position).getCompetName());
                intent.putExtra("CompetAddress",ListCompetitions.get(position).getDate().toString());
                intent.putExtra("CompetDate",ListCompetitions.get(position).getDate().toString());
                intent.putExtra("ListOFClients",ListCompetitions.get(position).getDate().toString());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ListCompetitions.size();
    }

    public static final class CompetitionsAdapterViewHolder extends RecyclerView.ViewHolder{

        TextView CompetName;
        TextView date;

        public CompetitionsAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            CompetName = itemView.findViewById(R.id.CompetitionsName);
            date = itemView.findViewById(R.id.DateOfCompetitions);
        }
    }
}
