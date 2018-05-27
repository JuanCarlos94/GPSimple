package com.seminario.juancarlos.gpsimple.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by juancarlos on 26/05/18.
 */

public class PercursoConstrutor extends SQLiteOpenHelper {

    public static final String TEXT_TYPE = " TEXT";
    public static final String REAL_TYPE = " REAL";
    public static final String COMMA_SEP = ",";
    public static final String SQL_CREATE_PERCURSO = "CREATE TABLE "
            + PercursoContract.PercursoEntry.TABLE_NAME + " (" + PercursoContract.PercursoEntry._ID
            + " INTEGER PRIMARY KEY,"
            + PercursoContract.PercursoEntry.COLUMN_NAME_ORIGEM + TEXT_TYPE + COMMA_SEP
            + PercursoContract.PercursoEntry.COLUMN_NAME_DESTINO + TEXT_TYPE + COMMA_SEP
            + PercursoContract.PercursoEntry.COLUMN_NAME_LATITUDE_ORIGEM + REAL_TYPE + COMMA_SEP
            + PercursoContract.PercursoEntry.COLUMN_NAME_LONGITUDE_ORIGEM + REAL_TYPE + COMMA_SEP
            + PercursoContract.PercursoEntry.COLUMN_NAME_LATITUDE_DESTINO + REAL_TYPE + COMMA_SEP
            + PercursoContract.PercursoEntry.COLUMN_NAME_LONGITUDE_DESTINO + REAL_TYPE + COMMA_SEP
            + PercursoContract.PercursoEntry.COLUMN_NAME_DISTANCIA + REAL_TYPE
            + " )";

    public static final String SQL_DELETE_PERCURSOS =
            "DROP TABLE IF EXISTS " + PercursoContract.PercursoEntry.TABLE_NAME;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "gpsimple.db";

    public PercursoConstrutor(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_PERCURSO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_PERCURSOS);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db,oldVersion,newVersion);
    }
}
