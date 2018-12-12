package com.example.techmaster.thuchanh_sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contactsManager";
    private static final String TABLE_CONTACTS = "contacts";

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PH_NO = "phone_number";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS + "("
                                                            + KEY_ID + " INTEGER PRIMARY KEY,"
                                                            + KEY_NAME + " TEXT,"
                                                            + KEY_PH_NO + " TEXT" + ")";
        sqLiteDatabase.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Drop older table if existed
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        // Create tables again
        onCreate(sqLiteDatabase);

    }

    // Adding new contact
    public void addContact(Contact contact) {
        SQLiteDatabase sqLiteDatabase;
        sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_NAME, contact.getName());
        contentValues.put(KEY_PH_NO, contact.getPhoneNumber());
        sqLiteDatabase.insert(TABLE_CONTACTS, null, contentValues);
    }

//    // Getting single contact
    public Contact getContact(int id) {
        Cursor cursor;
        SQLiteDatabase sqLiteDatabase;
        sqLiteDatabase = getReadableDatabase();
        Contact person;
        //String sql = "SELECT " + KEY_NAME + "," + KEY_PH_NO + " FROM " + TABLE_CONTACTS + " WHERE " + KEY_ID + " = " + String.valueOf(id)
        cursor = sqLiteDatabase.query(TABLE_CONTACTS, new String[]{KEY_NAME, KEY_PH_NO},KEY_ID + "=" + String.valueOf(id), null, null, null, null);
        cursor.moveToNext();
        person = new Contact(cursor.getString(cursor.getColumnIndex(KEY_NAME)), cursor.getString(cursor.getColumnIndex(KEY_PH_NO)));
        person.setId(String.valueOf(id));
        return  person;
    }

    // Getting All Contacts
    public List<Contact> getAllContacts() {
        Cursor cursor;
        SQLiteDatabase sqLiteDatabase = getReadableDatabase(); //??????
        cursor = sqLiteDatabase.query(TABLE_CONTACTS, new String[]{KEY_ID, KEY_NAME, KEY_PH_NO}, null, null, null, null, null);

        List<Contact> users = new ArrayList<>();
        Contact person;
        while (cursor.moveToNext()) {
            person = new Contact(cursor.getString(cursor.getColumnIndex(KEY_NAME)), cursor.getString(cursor.getColumnIndex(KEY_PH_NO)));
            person.setId(cursor.getString(cursor.getColumnIndex(KEY_ID)));
            users.add(person);
        }
        return users;
    }

//    // Updating single contact
    public int updateContact(Contact contact) {
        ContentValues contentValues;
        contentValues = new ContentValues();
        contentValues.put(KEY_NAME, contact.getName());
        contentValues.put(KEY_PH_NO,contact.getPhoneNumber());
        SQLiteDatabase sqLiteDatabase;
        sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.update(TABLE_CONTACTS, contentValues, KEY_ID + "=" + String.valueOf(contact.getID()), null);
        return 1;
    }
//
//    // Deleting single contact
    public void deleteContact(Contact contact) {
        SQLiteDatabase sqLiteDatabase;
        sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete(TABLE_CONTACTS, KEY_ID + "=" + String.valueOf(contact.getID()),null);
    }

    public void deleteContactAll(){
        SQLiteDatabase sqLiteDatabase;
        sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete(TABLE_CONTACTS, null,null);
    }

}
