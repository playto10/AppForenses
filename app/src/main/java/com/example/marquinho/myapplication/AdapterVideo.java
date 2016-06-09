package com.example.marquinho.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.marquinho.myapplication.model.Video;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Marquinho on 21/04/2016.
 */
public class AdapterVideo extends BaseAdapter {
    private Context context;
    private ArrayList<Video> lista;

    public AdapterVideo(Context context, ArrayList<Video>lista){

        this.context=context;
        this.lista=lista;

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //String videoPosicao = this.lista.get(position);
        Video videoItem = this.lista.get(position);

        convertView = LayoutInflater.from(this.context).inflate(R.layout.layout_list_video, null);

       // MOKVideoView mokvideo =  ( MOKVideoView ) getView . FindViewById ( R.Id. MOKVideo );

         VideoView videoView = (VideoView) convertView.findViewById(R.id.videoView);
      //  VideoView videoView = (VideoView) convertView.findViewById(R.id.videoItem);

        videoView.setVideoPath(videoItem.getPath());
       // videoView.setVideoPath(buscaVideo(videoPosicao));

        MediaController mc = new MediaController(context);
        videoView.setMediaController(mc);
        videoView.start();

        if(videoView.getDuration() >= 2){
            videoView.seekTo(2);
        }else{
            videoView.seekTo(videoView.getDuration());
        }

        videoView.pause();

        TextView textViewDescricao = (TextView) convertView.findViewById(R.id.descricao);
        textViewDescricao.setText(videoItem.getName());

//        textViewDescricao.setText(videoPosicao);


//        String s[] = videoPosicao.split("/");
//        videoPosicao = s[s.length-1];
//
//        textViewDescricao.setText(videoPosicao);

        //TextView textViewData = (TextView) convertView.findViewById((R.id.data));
        //// textViewData.setText(imagemPosicao);

        return convertView;

    }

}
