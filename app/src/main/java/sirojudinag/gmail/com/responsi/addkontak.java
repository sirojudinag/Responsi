package sirojudinag.gmail.com.responsi;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class addkontak extends AppCompatActivity {
    MySQLHelper dbHelper;
    private EditText ed_num;
    private EditText ed_name;
    protected Cursor cursor;
    private int id = -1;
    protected ListAdapter adapter;
    protected ListView numberList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addkontak);
        this.ed_num = (EditText) this.findViewById(R.id.editText_num);
        this.ed_name = (EditText) this.findViewById(R.id.editText_name);
        this.numberList = (ListView) this.findViewById(R.id.ListView01);
        dbHelper = new MySQLHelper(this);
    }
    //tambah data
    private void addData(String num, String name) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        try {
            db.execSQL("insert into " + MySQLHelper.TABLE +
                    " values(null,'" + num + "','" + name + "')");
        } catch (Exception e) {
            ed_num.setText(e.toString());
        }
        Toast.makeText(getApplicationContext(), "Tersimpan", Toast.LENGTH_SHORT).show();
        //kembali ke menu utama
        Intent utama = new Intent(addkontak.this,MainActivity.class);
        startActivity(utama);
    }

    public void but_inClick(View v) {
        addData(ed_num.getText().toString(), ed_name.getText().toString());
    }
}
