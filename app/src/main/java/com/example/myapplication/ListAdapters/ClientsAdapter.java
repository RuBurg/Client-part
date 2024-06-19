package com.example.myapplication.ListAdapters;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Client;
import com.example.myapplication.ListClasses.ListClients;
import com.example.myapplication.R;
import com.example.myapplication.Training;

import java.util.List;

//Обработчик события удаления элемента списка
public class ClientsAdapter  extends RecyclerView.Adapter<ClientsAdapter.ClientsAdapterViewHolder> {

    Context context;
    List<ListClients> ClientsList;

    public ClientsAdapter(Context context, List<ListClients> clientsList) {
        this.context = context;
        ClientsList = clientsList;
    }

    @NonNull
    @Override
    public ClientsAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View categoryItems = LayoutInflater.from(context).inflate(R.layout.list_clients, parent, false);
        return new ClientsAdapterViewHolder(categoryItems);
    }

    @Override
    public void onBindViewHolder(@NonNull ClientsAdapterViewHolder holder, int position) {

        holder.ClientListName.setText(ClientsList.get(position).getClientName());
        holder.ClientListSName.setText(ClientsList.get(position).getClientSName());

        holder.itemView.setOnClickListener (new View.OnClickListener() {
        @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Client.class);

                intent.putExtra("ClientName",ClientsList.get(position).getClientName());
                intent.putExtra("ClientSName",ClientsList.get(position).getClientSName());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ClientsList.size();
    }

    public static final class ClientsAdapterViewHolder extends RecyclerView.ViewHolder{

        TextView ClientListName;
        TextView ClientListSName;

        public ClientsAdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            ClientListName = itemView.findViewById(R.id.ClientListName);
            ClientListSName = itemView.findViewById(R.id.ClientListSName);

        }
    }
}
