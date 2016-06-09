package com.example.marquinho.myapplication.model;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Marquinho on 21/04/2016.
 */
public class Video {

    private String name;
    private String path; // caminho
    private String format;
    private String dateCreated;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }


    @Override
    public String toString() {
        return "Video{" +
                "name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", format='" + format + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                '}';
    }

    public static ArrayList<Video> getVideoPath(Activity activity) {
        Uri uri;
        ArrayList<Video> listOfAllVideo = new ArrayList<Video>();
        Cursor cursor;


        int column_index_data, column_index_folder_name,column_index_title, column_index_data_created ;

        String pathOfVideo = null;
        uri = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI;

        String[] projection = { MediaStore.MediaColumns.DATA,
                MediaStore.Video.Media.BUCKET_DISPLAY_NAME,MediaStore.MediaColumns.TITLE, MediaStore.MediaColumns.DATE_ADDED };

        cursor = activity.getContentResolver().query(uri, projection, null,
                null, null);

        assert cursor != null;
        column_index_data = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
        column_index_title = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.TITLE);
        column_index_data_created = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATE_ADDED);

        column_index_folder_name = cursor
                .getColumnIndexOrThrow(MediaStore.Video.Media.BUCKET_DISPLAY_NAME);
        while (cursor.moveToNext()) {

            Video video = new Video();
            video.setPath(cursor.getString(column_index_data));
            video.setName(cursor.getString(column_index_title));
            video.setDateCreated(cursor.getString(column_index_data_created));

//            pathOfVideo = cursor.getString(column_index_data);
//            Log.i("video", pathOfVideo);
            Log.i("list of all Video", video.toString());
            listOfAllVideo.add(video);
        }
        return listOfAllVideo;
    }
}
