package com.example.marquinho.myapplication;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;


public class MainActivity extends AppCompatActivity {

    ImageButton btLigacao;
    ImageButton btImagem;
    ImageButton btMsg;
    ImageButton btDocumento;
    ImageButton btVideo;
    ImageButton btAudio;
    ImageButton btWeb;
    ImageButton btCntato;
    FloatingActionButton fab = null;


    private ArrayAdapter<String> myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
        fab.setVisibility(View.GONE);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /* Chamadas dos botões na tela principal */
    public void chamaLigacao(View v){ startActivity(new Intent(this, LigacaoActivity.class)); }
    public void chamaImagem(View v){ startActivity(new Intent(this, ImagemActivity.class)); }
    public void chamaMSG(View v){ startActivity(new Intent(this, MSGActivity.class)); }
    public void chamaDocumento(View v){ startActivity(new Intent(this, DocumentoActivity.class)); }
    public void chamaVideo(View v){ startActivity(new Intent(this, VideoActivity.class)); }
    public void chamaWeb(View v){ startActivity(new Intent(this, WebActivity.class)); }
    public void chamaAudio(View v){ startActivity(new Intent(this, AudioActivity.class)); }
    public void chamaContato(View v){ startActivity(new Intent(this, ContatoActivity.class)); }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, LigacaoActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }









    public void setListAdapter(ArrayAdapter<String> listAdapter) {
        this.setListAdapter(listAdapter);
    }
}
