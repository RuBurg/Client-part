package com.example.myapplication.ListAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.ListClasses.ListClientsAdd;
import com.example.myapplication.R;

import java.util.List;

public class ClientsAddAdapter extends RecyclerView.Adapter<ClientsAddAdapter.ClientsAddAdapterViewHolder> {

    Context context;
    List<ListClientsAdd> ListClientsAdd;

    public ClientsAddAdapter(Context context, List<com.example.myapplication.ListClasses.ListClientsAdd> listClientsAdd) {
        this.context = context;
        ListClientsAdd = listClientsAdd;
    }

    @NonNull
    @Override
    public ClientsAddAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View categoryItems = LayoutInflater.from(context).inflate(R.layout.list_clients_add, parent, false);
        return new ClientsAddAdapterViewHolder(categoryItems);
    }

    @Override
    public void onBindViewHolder(@NonNull ClientsAddAdapterViewHolder holder, int position) {
        holder.ClientNameCheck.setText(ListClientsAdd.get(position).getClientNameCheck());
        holder.ClientSNameCheck.setText(ListClientsAdd.get(position).getClientSNameCheck());
    }

    @Override
    public int getItemCount() {
        return ListClientsAdd.size();
    }

    public static final class ClientsAddAdapterViewHolder extends RecyclerView.ViewHolder {

        TextView ClientNameCheck;
        TextView ClientSNameCheck;

        public ClientsAddAdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            ClientNameCheck = itemView.findViewById(R.id.ClientAddListName);
            ClientSNameCheck = itemView.findViewById(R.id.ClientAddListSName);

        }
    }

}
