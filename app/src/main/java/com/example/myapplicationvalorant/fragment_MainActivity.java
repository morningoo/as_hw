package com.example.myapplicationvalorant;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class fragment_MainActivity extends AppCompatActivity implements View.OnClickListener{
    Fragment fragment1,fragment2,fragment3,fragment4;
    LinearLayout layout1,layout2,layout3,layout4;
    FragmentManager manager;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fragment_main);

        // 初始化布局和Fragment
        layout1 = findViewById(R.id.bottom_LinearLayout1);
        layout2 = findViewById(R.id.bottom_LinearLayout2);
        layout3 = findViewById(R.id.bottom_LinearLayout3);
        layout4 = findViewById(R.id.bottom_LinearLayout4);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();

        manager = getSupportFragmentManager();

        // 设置点击监听器
        layout1.setOnClickListener(this);
        layout2.setOnClickListener(this);
        layout3.setOnClickListener(this);
        layout4.setOnClickListener(this);

        // 初始化Fragment
        initial();

        // 显示第一个Fragment
        showFragment(fragment1);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void initial() {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.framelayout, fragment1);
        transaction.add(R.id.framelayout, fragment2);
        transaction.add(R.id.framelayout, fragment3);
        transaction.add(R.id.framelayout, fragment4);
        transaction.commit();
    }

    private void showFragment(Fragment fragment) {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.hide(fragment1);
        transaction.hide(fragment2);
        transaction.hide(fragment3);
        transaction.hide(fragment4);
        transaction.show(fragment);
        transaction.commit();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bottom_LinearLayout1:
                showFragment(fragment1);
                break;
            case R.id.bottom_LinearLayout2:
                showFragment(fragment2);
                break;
            case R.id.bottom_LinearLayout3:
                showFragment(fragment3);
                break;
            case R.id.bottom_LinearLayout4:
                showFragment(fragment4);
                break;
        }
    }
}
