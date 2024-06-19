package com.example.myapplication.ListAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.ListClasses.ListTraining;
import com.example.myapplication.R;

import java.util.List;
public class TrainingAdapter extends RecyclerView.Adapter<TrainingAdapter.TrainingAdapterViewHolder> {

    Context context;
    List<ListTraining> ListTraining;

    public TrainingAdapter(Context context, List<ListTraining> listTraining) {
        this.context = context;
        ListTraining = listTraining;
    }

    @NonNull
    @Override
    public TrainingAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View categoryItems = LayoutInflater.from(context).inflate(R.layout.list_training, parent, false);
        return new TrainingAdapter.TrainingAdapterViewHolder(categoryItems);
    }

    @Override
    public void onBindViewHolder(@NonNull TrainingAdapterViewHolder holder, int position) {
        holder.ExeName.setText(ListTraining.get(position).getExeName());
        holder.ExeLink.setText(ListTraining.get(position).getExeLink());
    }

    @Override
    public int getItemCount() {
        return ListTraining.size();
    }

    public static final class TrainingAdapterViewHolder extends RecyclerView.ViewHolder{

        TextView ExeName;
        TextView ExeLink;
        public TrainingAdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            ExeName = itemView.findViewById(R.id.ExeName);
            ExeLink = itemView.findViewById(R.id.ExeLink);

        }
    }

}
