package com.hhq.recyclerviewfragmentflexible;

import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FragmentThem.GiaoTiep {
    private RecyclerView recyclerView;
    private SinhVienAdapter sinhVienAdapter;
    private List<SinhVien> list = new ArrayList<>();
    private static String KEY_MA = "ma";
    private static String KEY_TEN = "ten";
    RelativeLayout relativeLayout;
    Button btAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);

        btAdd = findViewById(R.id.btAdd);
        relativeLayout = findViewById(R.id.fragment);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);


        sinhVienAdapter = new SinhVienAdapter(this,list);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(sinhVienAdapter);

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.setVisibility(View.GONE);

                relativeLayout.setVisibility(View.VISIBLE);
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment,new FragmentThem()).commit();
                btAdd.setVisibility(View.GONE);
            }
        });
        if (getResources().getConfiguration().orientation==Configuration.ORIENTATION_LANDSCAPE){
            relativeLayout.setVisibility(View.VISIBLE);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment,new FragmentThem()).commit();
        }
        if (savedInstanceState != null){
            ArrayList<Integer> ma = new ArrayList<>();
            ma = savedInstanceState.getIntegerArrayList(KEY_MA);
            ArrayList<String> ten = new ArrayList<>();
            ten = savedInstanceState.getStringArrayList(KEY_TEN);
            for (int i=0;i<ma.size();i++){
                SinhVien sv = new SinhVien(ma.get(i),ten.get(i));
                list.add(sv);
                sinhVienAdapter.notifyDataSetChanged();
            }
        }

    }

    @Override
    public void ThemSinhVien(int ma, String ten) {
        if (getResources().getConfiguration().orientation==Configuration.ORIENTATION_PORTRAIT){
            btAdd.setVisibility(View.VISIBLE);
            relativeLayout.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
        SinhVien sv = new SinhVien(ma,ten);
        list.add(sv);
        sinhVienAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        ArrayList<Integer> ma = new ArrayList<>();
        ArrayList<String> ten = new ArrayList<>();
        for (SinhVien a: list
             ) {
            ma.add(a.getMa());
            ten.add(a.getTen());
        }
        outState.putIntegerArrayList(KEY_MA,ma);
        outState.putStringArrayList(KEY_TEN,ten);
        super.onSaveInstanceState(outState);
    }
}
