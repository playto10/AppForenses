package com.example.marquinho.myapplication;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.marquinho.myapplication.model.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marquinho on 26/04/2016.
 */
//2016//04//
 public class AdapterContact extends ArrayAdapter {

    private Context context;
    private List<String> lista;

    public AdapterContact(Context context, List<String>lista){
        super(context, 0, lista);
        this.context=context;
        this.lista=lista;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        String contactPosicao = this.lista.get(position);

        convertView = LayoutInflater.from(this.context).inflate(R.layout.layout_list_contact, null);

       QuickContactBadge contactsContract = (QuickContactBadge) convertView.findViewById(R.id.ContactBadge);
       //contactsContract.assignContactUri();
        //ContactsContract.set(String.valueOf(buscaVideo(videoPosicao)));
        // videoView.setVideoPath(buscaVideo(videoPosicao));


        TextView textViewDescricao = (TextView) convertView.findViewById(R.id.descricao);
        textViewDescricao.setText(contactPosicao);
        textViewDescricao.setText(lista.get(position));

        return convertView;

    }



}
