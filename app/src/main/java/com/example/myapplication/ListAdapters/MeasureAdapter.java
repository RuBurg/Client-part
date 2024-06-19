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

import com.example.myapplication.ListClasses.ListClients;
import com.example.myapplication.ListClasses.ListMeasure;
import com.example.myapplication.R;

import java.util.List;
//Обработчик события удаления элемента списка
public class MeasureAdapter extends RecyclerView.Adapter<MeasureAdapter.MeasureAdapterViewHolder>{

    Context context;
    List<ListMeasure> ListMeasure;

    public MeasureAdapter(Context context,  List<ListMeasure> listMeasure) {
        this.context = context;
        ListMeasure = listMeasure;
    }

    @NonNull
    @Override
    public MeasureAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View categoryItems = LayoutInflater.from(context).inflate(R.layout.list_measure, parent, false);
        return new MeasureAdapter.MeasureAdapterViewHolder(categoryItems);
    }

    @Override
    public void onBindViewHolder(@NonNull MeasureAdapterViewHolder holder, int position) {

        holder.DateMeasure.setText(ListMeasure.get(position).getDate().toString());
        holder.Hip.setText(Double.toString(ListMeasure.get(position).getWeight()));
        holder.Weight.setText(Double.toString(ListMeasure.get(position).getWeight()));
        holder.Arm.setText(Double.toString(ListMeasure.get(position).getWeight()));
        holder.Chest.setText(Double.toString(ListMeasure.get(position).getWeight()));
        holder.Waist.setText(Double.toString(ListMeasure.get(position).getWeight()));

    }

    @Override
    public int getItemCount() {return ListMeasure.size();}

    public static  final class  MeasureAdapterViewHolder extends RecyclerView.ViewHolder{

        TextView DateMeasure;
        TextView Hip;
        TextView Weight;
        TextView Arm;
        TextView Chest;
        TextView Waist;
        public MeasureAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            DateMeasure = itemView.findViewById(R.id.DateMeasure);
            Hip = itemView.findViewById(R.id.Hip);
            Weight = itemView.findViewById(R.id.Weight);
            Arm = itemView.findViewById(R.id.Arm);
            Chest = itemView.findViewById(R.id.Chest);
            Waist = itemView.findViewById(R.id.Waist);
        }
    }

}
