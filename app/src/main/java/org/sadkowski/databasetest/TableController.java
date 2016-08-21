package org.sadkowski.databasetest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.List;

/**
 * Created by sadko on 05.07.2016.
 */
public class TableController extends DbHelper {
    public TableController(Context context) {
        super(context);
    }

    public void onDelete(){
        SQLiteDatabase db = getWritableDatabase();
        int delete = db.delete(TABLENAME, "", null);
    }

    public void onInsert(List<Point3D> point3Ds){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        Log.d("ERROR","Zapisywanie");
        try {
            db.beginTransaction();
            for (Point3D point : point3Ds) {
                values.put(X_COLNAME, point.getX());
                values.put(Y_COLNAME, point.getY());
                values.put(Z_COLNAME, point.getY());
                values.put(TELEFON_COLNAME, "605400462");
                db.insertOrThrow(TABLENAME, null, values);
            }
            db.setTransactionSuccessful();
            db.endTransaction();
        }
        catch (Exception e){
            Log.d("ERROR","Blad w czasie zapisywania");
        }
        finally {
            db.close();
        }
    }
    public boolean onInsert(int x,int y, int z){
        ContentValues values = new ContentValues();
        SQLiteDatabase db = getWritableDatabase();
        values.put(X_COLNAME,x);
        values.put(Y_COLNAME,y);
        values.put(Z_COLNAME,z);
        values.put(TELEFON_COLNAME,"605400462");
        boolean createSuccessful = db.insertOrThrow(TABLENAME,null,values) > 0;
        db.close();
        return createSuccessful;
    }

    public int count() {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT * FROM "+TABLENAME;
        int recordCount = db.rawQuery(sql, null).getCount();
        db.close();
        return recordCount;
    }

    public Cursor getValues(){
        String[] columns={NR_COLNAME,X_COLNAME, Y_COLNAME ,Z_COLNAME,TELEFON_COLNAME};
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query(TABLENAME, columns,null,null,null,null,null);
        return c;
    }
}