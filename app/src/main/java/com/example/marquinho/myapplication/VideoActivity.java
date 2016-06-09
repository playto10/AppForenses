package com.example.marquinho.myapplication;

import android.app.Activity;
import android.content.CursorLoader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.marquinho.myapplication.model.Imagem;
import com.example.marquinho.myapplication.model.Video;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class VideoActivity extends AppCompatActivity {
    public ListView listViewVideos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listViewVideos = (ListView)findViewById(R.id.listView);//
        listViewVideos.setAdapter(new AdapterVideo(this, Video.getVideoPath(this)));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

       // getVideoPath(this);
    }
//    String[] projection = { MediaStore.Video.Media._ID};
//    Cursor cursor = new CursorLoader(onContextItemSelected(), MediaStore.Video.Media.EXTERNAL_CONTENT_URI, projection,
//            null, // Return all rows
//            null, null).loadInBackground();


//    public static ArrayList<String> getVideoPath(Activity activity) {
//        Uri uri;
//        ArrayList<String> listOfAllVideo = new ArrayList<String>();
//        Cursor cursor;
//        int column_index_data, column_index_folder_name;
//        String pathOfVideo = null;
//        uri = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
//
//        String[] projection = { MediaStore.MediaColumns.DATA,
//                MediaStore.Video.Media.BUCKET_DISPLAY_NAME };
//
//        cursor = activity.getContentResolver().query(uri, projection, null,
//                null, null);
//
//        assert cursor != null;
//        column_index_data = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
//        column_index_folder_name = cursor
//                .getColumnIndexOrThrow(MediaStore.Video.Media.BUCKET_DISPLAY_NAME);
//        while (cursor.moveToNext()) {
//            pathOfVideo = cursor.getString(column_index_data);
//            Log.i("video", pathOfVideo);
//            listOfAllVideo.add(pathOfVideo);
//        }
//        return listOfAllVideo;
//    }

}
