package com.example.myapplication.ListAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.ListClasses.ListCompetition;
import com.example.myapplication.R;

import java.util.List;

public class CompetitionAdapter  extends RecyclerView.Adapter<CompetitionAdapter.CompetitionAdapterViewHolder>{

    Context context;
    List<ListCompetition> ListCompetition;

    public CompetitionAdapter(Context context,  List<ListCompetition> listCompetition) {
        this.context = context;
        ListCompetition = listCompetition;
    }

    @NonNull
    @Override
    public CompetitionAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View categoryItems = LayoutInflater.from(context).inflate(R.layout.list_competition, parent, false);
        return new CompetitionAdapter.CompetitionAdapterViewHolder(categoryItems);
    }

    @Override
    public void onBindViewHolder(@NonNull CompetitionAdapter.CompetitionAdapterViewHolder holder, int position) {
        holder.CompetClientName.setText(ListCompetition.get(position).getClientNameCompet());
        holder.CompetClienSName.setText(ListCompetition.get(position).getClientSNameCompet());

    }

    @Override
    public int getItemCount() {
        return ListCompetition.size();
    }

    public static final class CompetitionAdapterViewHolder extends RecyclerView.ViewHolder{

        TextView CompetClientName;
        TextView CompetClienSName;

        public CompetitionAdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            CompetClientName = itemView.findViewById(R.id.CompetClientName);
            CompetClienSName = itemView.findViewById(R.id.CompetClienSName);
        }
    }
}
