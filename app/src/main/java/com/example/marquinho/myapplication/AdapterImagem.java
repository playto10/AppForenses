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
import android.widget.TextView;

import com.example.marquinho.myapplication.model.Imagem;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Marquinho on 13/04/2016.
 */
public class AdapterImagem extends BaseAdapter {
    private Context context;
    private ArrayList<Imagem>lista;

    public AdapterImagem(Context context, ArrayList<Imagem>lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

            Imagem imagemItem = this.lista.get(position);

            convertView = LayoutInflater.from(this.context).inflate(R.layout.layout_list_imagens, null);

            ImageView imageView = (ImageView) convertView.findViewById(R.id.imagemItem);
            imageView.setImageBitmap(buscaImagem(imagemItem.getPath()));

            TextView textViewDescricao = (TextView) convertView.findViewById(R.id.descricao);
            textViewDescricao.setText(imagemItem.getName());

            //TextView textViewData = (TextView) convertView.findViewById((R.id.data));
            //// textViewData.setText(imagemPosicao);

            return convertView;

    }
    
    public Bitmap buscaImagem(String path){
        File imgFile = new  File(path);

        if(imgFile.exists()) {

            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 2; //try to decrease decoded image
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            return Bitmap.createScaledBitmap(myBitmap, 100, 100, true);
        }
        return null;
    }
}
