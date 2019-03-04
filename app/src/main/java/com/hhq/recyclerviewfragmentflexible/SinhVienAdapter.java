package com.hhq.recyclerviewfragmentflexible;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SinhVienAdapter extends RecyclerView.Adapter<SinhVienAdapter.ViewHolder> {
    private Context context;
    private List<SinhVien> sinhVienList;

    public SinhVienAdapter(Context context, List<SinhVien> sinhVienList) {
        this.context = context;
        this.sinhVienList = sinhVienList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.sinh_vien,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        SinhVien sv = sinhVienList.get(i);
        viewHolder.avt.setImageResource(R.mipmap.ic_launcher);
        viewHolder.ten.setText(sv.getTen());
    }

    @Override
    public int getItemCount() {
        return sinhVienList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView ten;
        ImageView avt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ten = itemView.findViewById(R.id.tvTen);
            avt = itemView.findViewById(R.id.ivAvt);
        }
    }
}
