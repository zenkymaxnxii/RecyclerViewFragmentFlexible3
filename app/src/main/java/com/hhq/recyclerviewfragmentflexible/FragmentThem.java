package com.hhq.recyclerviewfragmentflexible;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class FragmentThem extends Fragment {

    public interface GiaoTiep{
        void ThemSinhVien(int ma,String ten);
    }
    GiaoTiep giaoTiep;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_them,container,false);
        view.findViewById(R.id.btAddData).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText ma = view.findViewById(R.id.edtMa);
                EditText ten = view.findViewById(R.id.edtTen);
                giaoTiep.ThemSinhVien(Integer.parseInt(ma.getText().toString()),ten.getText().toString());
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        giaoTiep = (GiaoTiep) getContext();
    }
}
