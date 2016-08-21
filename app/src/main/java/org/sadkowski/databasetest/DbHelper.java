package org.sadkowski.databasetest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.util.List;

/**
 * Created by sadko on 13.04.2016.
 */
public class DbHelper extends SQLiteOpenHelper{
    protected static final int DATABASE_VERSION = 1;
    protected static final String DBNAME = "db.pomiar";
    protected static final String NR_COLNAME = "nr";
    protected static final String X_COLNAME = "x";
    protected static final String Y_COLNAME = "y";
    protected static final String Z_COLNAME = "z";
    protected static final String TELEFON_COLNAME = "telefon";
    public final String TABLENAME = "telefony";
    public DbHelper(Context context) {
        super(context, DBNAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("create table "+ TABLENAME +"("+
            NR_COLNAME+" integer primary key autoincrement,"+
            X_COLNAME+" text,"+
            Y_COLNAME+" text,"+
            Z_COLNAME+" text,"+
            TELEFON_COLNAME+" text);"+
            "");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS "+TABLENAME;
        db.execSQL(sql);
        onCreate(db);
    }
}