package com.llh.recyclerviewonclick;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.llh.recyclerviewonclick.Fragment.FragmentCourse;
import com.llh.recyclerviewonclick.Fragment.FragmentSong;

import java.util.List;

/**
 * 项目名:    RecyclerViewOnClick
 * 包名:      com.llh.recyclerviewonclick
 * 文件名:    SongAdapter
 * 创建者:    LLH
 * 创建时间:  2019/8/9 9:57
 * 描述:      TODO
 */
public class SongAdapter extends RecyclerView.Adapter<SongAdapter.InnerViewHolder> {
    //创建一个链表
    private List<Song> songList;
    private Context context;
    //构造函数
    public SongAdapter(List<Song> songList, Context context){
        this.songList = songList;
        this.context = context;
    }
    //内部类
    static class InnerViewHolder extends RecyclerView.ViewHolder{
        //注册点击事件
        View songView;//用来保存最外层布局的实例
        //一个头像，一个歌名，一个歌手，一个跳转图片
        ImageView iv_header;
        TextView tv_songName;
        TextView tv_singer;
        ImageView iv_shift;
        //构造函数
        public InnerViewHolder(View view){
            super(view);
            //注册点击事件
            songView = view;
            //绑定布局中的控件
            iv_header = view.findViewById(R.id.iv_header);
            tv_songName = view.findViewById(R.id.tv_songName);
            tv_singer = view.findViewById(R.id.tv_singer);
            iv_shift = view.findViewById(R.id.iv_shift);
        }
    }
    @NonNull
    @Override
    public InnerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //绑定布局，并返回内部类的对象
        View view = LayoutInflater.from(context).inflate(R.layout.item_song,viewGroup,false);
        final InnerViewHolder innerViewHolder = new InnerViewHolder(view);//把view传过去，就可以绑定里面的控件了
        //为最外层布局注册点击事件
        innerViewHolder.songView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = innerViewHolder.getAdapterPosition();//先获取了用户点击的position
                Song song = songList.get(position);//通过position拿到相应的Fruit实例
                Toast.makeText(context,"你点击了view:   "+song.getSongName(),Toast.LENGTH_SHORT).show();
            }
        });
        //为里面的tv_shift注册点击事件
        innerViewHolder.iv_shift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = innerViewHolder.getAdapterPosition();
                Song song = songList.get(position);
                //Toast.makeText(context,"你点击了tv_shift"+(position+1),Toast.LENGTH_SHORT).show();
                FragmentSong.indexPosition = position;
                //切换碎片
                Fragment fragment = new FragmentCourse();
                FragmentManager fragmentManager = ((MainActivity)context).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_main,fragment,"next");
                fragmentTransaction.addToBackStack("pre");
                fragmentTransaction.commit();
            }
        });
        return innerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull InnerViewHolder innerViewHolder, int i) {
        //给里面的控件赋值
        Song song = songList.get(i);
        innerViewHolder.iv_header.setImageResource(song.getHeaderId());
        innerViewHolder.tv_songName.setText(song.getSongName());
        innerViewHolder.tv_singer.setText(song.getSinger());
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

}
