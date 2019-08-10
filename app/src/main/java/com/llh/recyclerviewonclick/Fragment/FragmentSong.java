package com.llh.recyclerviewonclick.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.llh.recyclerviewonclick.MainActivity;
import com.llh.recyclerviewonclick.R;
import com.llh.recyclerviewonclick.Song;
import com.llh.recyclerviewonclick.SongAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名:    RecyclerViewOnClick
 * 包名:      com.llh.recyclerviewonclick.Fragment
 * 文件名:    FragmentSong
 * 创建者:    LLH
 * 创建时间:  2019/8/9 10:43
 * 描述:      TODO
 */
public class FragmentSong extends Fragment {
    //声明控件
    private RecyclerView recyclerViewSong;
    private List<Song> songList;
//    测试控件
    public TextView textDisplay;
    public  String text = "";
    //存下当前的position
    public static int indexPosition = 0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_song,container,false);
        recyclerViewSong = (RecyclerView)view.findViewById(R.id.rv_song);
        //创建线性布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(container.getContext());
        recyclerViewSong.setLayoutManager(layoutManager);
        if(songList==null){
            //初始化链表
            songList = new ArrayList<>();
        }
        //给链表添加值
        addSongList();
        //创建是适配器
        SongAdapter songAdapter = new SongAdapter(songList,container.getContext());
        //设置适配器
        recyclerViewSong.setAdapter(songAdapter);
        //        测试代码
        textDisplay = view.findViewById(R.id.tv_display_course);
        if(text!="" && FragmentCourse.btnConfirmInPress){
            FragmentCourse.btnConfirmInPress = false;
            textDisplay.setText(text);
            //给当前链表的当前位置，设置文本内容
            songList.get(indexPosition).setSongName(text);
        }
        return view;
    }
    private void addSongList() {
        for (int i=0; i<10; i++){
            //创建Song对象
            Song song = new Song(R.drawable.ic_account_circle_black_24dp,"你若成风","许嵩");
            //添加到链表
            songList.add(song);
        }
    }
//    //手动保存数据
//
//    @Override
//    public void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putString("text",text);
//    }
    //手动恢复数据

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        text = savedInstanceState.getString("text");
//    }
}
//问题：选好之后内容返回到第一个碎片了，但第二次去选的另一栏的时候，内容会被覆盖

//当text里面存了值之后，你点击另外一栏，不选东西，再返回，会把这个值显示在当前点击的栏目的展示框里
