package com.example.myapplicationvalorant;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fragment3 extends Fragment {

    private RecyclerView recyclerView;
    private List<String> list;
    private Context context;
    private adapter adapter;
    List<Map<String,Object>> list1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.activity_recycleview, container, false);


        context = getContext();

        recyclerView = view.findViewById(R.id.recycleview);

        int[] name={R.drawable.g1,R.drawable.g2,R.drawable.g3,R.drawable.g4};
        String[] price={"1590","2580","1590","1690"};
        String[] config={"奇点 正义","紫金爪刀","破败军械 幻影","塑水宗 狂徒"};

        list1=new ArrayList<>() ;
        for(int i=0;i<name.length;i++){
            Map<String,Object> map=new HashMap<>();
            map.put("name",name[i]);
            map.put("price",price[i]);
            map.put("config",config[i]);
            list1.add(map);
        }


        adapter = new adapter(context,list1);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(manager);
        return view;

    }

}