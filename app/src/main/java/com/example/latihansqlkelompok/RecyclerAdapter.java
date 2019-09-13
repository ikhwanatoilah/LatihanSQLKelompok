package com.example.latihansqlkelompok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends
        RecyclerView.Adapter<RecyclerAdapter.UserViewHolder> {
    Context context;
    OnUserClickListener listener;
    List<Data> listPersonInfo;
    public RecyclerAdapter(Context context, List<Data> listPersonInfo, OnUserClickListener listener) {
        this.context=context;
        this.listPersonInfo=listPersonInfo;
        this.listener=listener;
    }
    public	interface OnUserClickListener{

        void onUserClick(Data currentPerson, String action);
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=
                LayoutInflater.from(parent.getContext()).inflate(R.layout.list_data,parent,false); UserViewHolder userViewHolder=new UserViewHolder(view);
        return userViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        final Data currentPerson=listPersonInfo.get(position);
        holder.nama.setText(currentPerson.getNama());
    }

    @Override
    public int getItemCount() {
        return listPersonInfo.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        TextView nama;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.nama);
        }
    }
}
