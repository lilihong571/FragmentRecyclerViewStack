package com.llh.recyclerviewonclick;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.llh.recyclerviewonclick.Fragment.FragmentSong;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //创建FragmentSong实例
        Fragment fragment = new FragmentSong();
        //创建碎片管理者
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //添加碎片
        fragmentTransaction.add(R.id.frame_main,fragment,"pre");
        fragmentTransaction.commit();
    }
}
