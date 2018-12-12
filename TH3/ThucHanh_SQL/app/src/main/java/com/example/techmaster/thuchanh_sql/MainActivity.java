package com.example.techmaster.thuchanh_sql;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ListView ListAndroid;
    Button buttonAdd;
    Button buttonEdit;
    Button buttonDeleteDatabase;
    EditText editTextName;
    EditText editTextPhone;
    List<Contact> contacts;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListAndroid = findViewById(R.id.Contract);
        buttonAdd = findViewById(R.id.Add);
        buttonEdit = findViewById(R.id.Edit);
        buttonEdit.setVisibility(View.GONE);
        buttonDeleteDatabase = findViewById(R.id.delete_database);
        editTextName = findViewById(R.id.Name);
        editTextPhone = findViewById(R.id.Phone);


        final DatabaseHandler db = new DatabaseHandler(this);
        db.deleteContactAll();

        /**
         * CRUD Operations
         * */
        // Inserting Contacts
        db.addContact(new Contact("Ravi", "9100000000"));
        db.addContact(new Contact("Srinivas", "9199999999"));
        db.addContact(new Contact("Tommy", "9522222222"));
        db.addContact(new Contact("Karthik", "9533333333"));
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.addContact(new Contact(String.valueOf(editTextName.getText()),
                        String.valueOf(editTextPhone.getText())));
                ShowData(db);

            }
        });


        ListAndroid.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                final Contact editData;
                editData = db.getContact(Integer.valueOf(contacts.get(i).getID()));

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Bạn đang Chọn \n" + String.valueOf(editData.getName()) + '\n' + String.valueOf(editData.getPhoneNumber()));
                builder.setPositiveButton("Xóa Thông Tin Contact", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        buttonAdd.setVisibility(View.VISIBLE);
                        buttonEdit.setVisibility(View.GONE);
                        db.deleteContact(editData);
                        ShowData(db);
                    }
                });
                builder.setNegativeButton("Sửa Thông tin Contact", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        buttonAdd.setVisibility(View.GONE);
                        buttonEdit.setVisibility(View.VISIBLE);
                        editTextName.setText(String.valueOf(editData.getName()));
                        editTextPhone.setText(String.valueOf(editData.getPhoneNumber()));

                        buttonEdit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                buttonAdd.setVisibility(View.VISIBLE);
                                buttonEdit.setVisibility(View.GONE);

                                editData.setName(String.valueOf(editTextName.getText()));
                                editData.setPhoneNumber(String.valueOf(editTextPhone.getText()));
                                db.updateContact(editData);
                                ShowData(db);
                            }
                        });
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();

                return false;
            }
        });

        buttonDeleteDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.deleteContactAll();
                ShowData(db);
            }
        });

        // Reading all contacts

        }

        public void ShowData(DatabaseHandler db){
            contacts = db.getAllContacts();
            List<String> abs = new ArrayList<String>();

            for (Contact cn : contacts) {
                // Writing Contacts to log
                String log = String.valueOf(cn.getID()) +"  Name: " + cn.getName() +'\n'+ "Phone: " + cn.getPhoneNumber();
                abs.add(log);
            }
            ArrayAdapter<String> user = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, abs);
            user.notifyDataSetChanged();
            ListAndroid.setAdapter(user);
        }
    }