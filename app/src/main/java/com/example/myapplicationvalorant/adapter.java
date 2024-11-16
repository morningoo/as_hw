package com.example.myapplicationvalorant;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Map;


public class adapter extends RecyclerView.Adapter<adapter.myviewholder>{

    private List<Map<String,Object>>list;
    private Context context;
    private View inflater;

    ActivityResultLauncher<Intent> launcher;

    public adapter(Context context, List<Map<String,Object>>
            list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public myviewholder onCreateViewHolder( ViewGroup viewGroup, int i) {
        inflater = LayoutInflater.from(context).inflate(R.layout.layout_item,viewGroup,false);
        myviewholder myviewholder =new myviewholder(inflater);
        return myviewholder;
    }

    @Override
    public void onBindViewHolder( myviewholder myviewholder, int j) {
        Map<String,Object> currentItem = list.get(j);
        myviewholder.imageView.setImageResource((Integer)currentItem.get("name"));//Integer强制转换成int
        String str1=list.get(j).get("price").toString();
        String str2=list.get(j).get("config").toString();
        myviewholder.textView1.setText(str1);
        myviewholder.textView2.setText(str2);

        myviewholder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,Activity_shop_detail.class);
                context.startActivity(intent);
            }
        });


        myviewholder.imageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, Activity_shop_detail.class);
                intent.putExtra("price",str1);
                intent.putExtra("config",str2);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class myviewholder extends RecyclerView.ViewHolder{
        TextView textView1,textView2;
        ImageView imageView;
        public myviewholder( View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView6);
            textView1 = itemView.findViewById(R.id.textView5);
            textView2 = itemView.findViewById(R.id.textView6);
        }
    }
}
