package com.example.latihansqlkelompok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.UserViewHolder> {
    Context context;
    OnUserClickListener listener;

    List<Data> listData;
    public RecyclerviewAdapter(Context context, List<Data> listDataInfo, OnUserClickListener listener) {
        this.context=context;
        this.listData = listDataInfo;
        this.listener=listener;
    }

    public interface OnUserClickListener{
        void onUserClick(Data currentMahasiwa);

    }
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.contain_daftar_nama,parent,false);
        UserViewHolder userViewHolder=new UserViewHolder(view);

        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, final int position) {
        final Data currentOrang = listData.get (position);
        holder.nama.setText (currentOrang.getNama ());


        holder.crdv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onUserClick(currentOrang);
            }
        });


    }

    @Override
    public int getItemCount() {
        return listData.size();

    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        CardView crdv;
        TextView nama;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            crdv = itemView.findViewById (R.id.card);
            nama = itemView.findViewById (R.id.nama);
        }
    }


}
