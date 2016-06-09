package com.example.marquinho.myapplication.model;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Marquinho on 13/04/2016.
 */
public class Imagem {

    private String name;
    private String path;
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
        return "Imagem{" +
                "name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", format='" + format + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                '}';
    }

    public static ArrayList<Imagem> getImagesPath(Activity activity) {
        Uri uri;
        ArrayList<Imagem> listOfAllImages = new ArrayList<Imagem>();
        Cursor cursor;

        int column_index_data, column_index_folder_name, column_index_title, column_index_data_created ;

        String pathOfImage = null;
        uri = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

        String[] projection = { MediaStore.MediaColumns.DATA,
                MediaStore.Images.Media.BUCKET_DISPLAY_NAME, MediaStore.MediaColumns.TITLE, MediaStore.MediaColumns.DATE_ADDED};

        cursor = activity.getContentResolver().query(uri, projection, null,
                null, null);

        assert cursor != null;
        column_index_data = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
        column_index_title = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.TITLE);
        column_index_data_created = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATE_ADDED);

        column_index_folder_name = cursor
                .getColumnIndexOrThrow(MediaStore.Images.Media.BUCKET_DISPLAY_NAME);
        while (cursor.moveToNext()) {

            Imagem imagem = new Imagem();
            imagem.setPath(cursor.getString(column_index_data));
            imagem.setName(cursor.getString(column_index_title));
            imagem.setDateCreated(cursor.getString(column_index_data_created));

            Log.i("list of all imagens", imagem.toString());

            listOfAllImages.add(imagem);
        }
        return listOfAllImages;
    }
}
