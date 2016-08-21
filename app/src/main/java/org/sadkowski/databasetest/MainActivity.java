package org.sadkowski.databasetest;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TableController dbHelper=null;
    TextView tv;
    Button button3;
    EditText et;

    /*@Override
    protected void onResume() {
    super.onResume();
        refresh();
    }
*/
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        tv = (TextView)findViewById(R.id.textView);
        Button button2 = (Button) findViewById(R.id.button2);

        button3 = (Button)findViewById(R.id.button3);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper = new TableController(getApplicationContext());
                dbHelper.onDelete();
                dbHelper.close();
                //refresh(dbHelper);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                int number=0;
                try{
                    number=Integer.parseInt(et.getText().toString());}
                catch(NumberFormatException e){
                 ;
                }
                dbHelper = new TableController(getApplicationContext());
                List<Point3D> points = new ArrayList<Point3D>(100);
                for(int i=0;i<number;i++) {
                    points.add(new Point3D(3, 4, 5, 6540921 + i));
                }
                dbHelper.onInsert(points);
                //refresh(dbHelper);
                }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refresh();
            }
        });
    et = (EditText) findViewById(R.id.editText);

    }

    public void refresh(){
        refresh(null);
    }

    public void refresh(TableController dbHelper){
        if(dbHelper==null)
            dbHelper = new TableController(getApplicationContext());
        Cursor c = dbHelper.getValues();
        StringBuilder sb = new StringBuilder(" ");
        List<Point3D> pomiary = new ArrayList<Point3D>();

        // if(c != null && c.moveToFirst()) {
        while (c.moveToNext()) {
            //String nr = c.getString(0);
            Point3D p = new Point3D();
            p.setId(Integer.parseInt(c.getString(c.getColumnIndex(DbHelper.NR_COLNAME))));
            p.setX(c.getInt(c.getColumnIndex(DbHelper.X_COLNAME)));
            p.setY(c.getInt(c.getColumnIndex(DbHelper.Y_COLNAME)));
            p.setZ(c.getInt(c.getColumnIndex(DbHelper.Z_COLNAME)));
            p.setTelefon(c.getInt(c.getColumnIndex(DbHelper.TELEFON_COLNAME)));
            pomiary.add(p);
        }
        // }
        for (Point3D p : pomiary) {
            sb.append(p.getId() + ". " + p.getX() + "," + p.getY() + "," + p.getZ() + "," + p.getTelefon() + "\n");
        }

        tv.setText(sb.toString() + "\n");
        dbHelper.close();
    }
}
