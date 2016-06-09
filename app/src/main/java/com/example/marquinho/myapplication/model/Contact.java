package com.example.marquinho.myapplication.model;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.Toast;

import com.example.marquinho.myapplication.MainActivity;
import com.example.marquinho.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marquinho on 26/04/2016.
 */
public class Contact {
    private final Context mAppContext;
    private List<String> listaContatos;
    private Loader<Cursor> loaderCursor;
    private static final int CONTACTS_LOADER_ID = 1;

    public Contact(Context mAppContext) {
        this.mAppContext = mAppContext;
        this.loaderCursor = contactsLoader();

        this.loaderCursor.startLoading();
//        contactsFromCursor(loaderCursor);
    }


    private Loader<Cursor> contactsLoader () {
        Uri contactsUri = ContactsContract.Contacts.CONTENT_URI; // The content URI of the phone contacts

        String[] projection = {                                  // The columns to return for each row
                ContactsContract.Contacts.DISPLAY_NAME
        };

        String selection = null;                                 //Selection criteria
        String[] selectionArgs = {};                             //Selection criteria
        String sortOrder = null;                                 //The sort order for the returned rows

        return new CursorLoader(
                mAppContext,
                contactsUri,
                projection,
                selection,
                selectionArgs,
                sortOrder);
    }

    private List<String> contactsFromCursor (Cursor cursor){
        List<String> contacts = new ArrayList<>();

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();

            do {
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                contacts.add(name);
            } while (cursor.moveToNext());
        }

        return contacts;
    }


    public List<String> getListaContatos() {
        return listaContatos;
    }
}
