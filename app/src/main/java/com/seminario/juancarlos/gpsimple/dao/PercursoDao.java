package com.seminario.juancarlos.gpsimple.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.seminario.juancarlos.gpsimple.model.Percurso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by juancarlos on 26/05/18.
 */

public class PercursoDao {
    private Context context;
    private PercursoConstrutor percursoConstrutor;

    public PercursoDao(Context context){
        this.context = context;
        percursoConstrutor = new PercursoConstrutor(context);
    }

    public long inserir(String origem, String destino, Double latitudeOrigem, Double longitudeOrigem,
                        Double latitudeDestino, Double longitudeDestino, float distancia){
        SQLiteDatabase sqLiteDatabase = percursoConstrutor.getWritableDatabase();
        if(sqLiteDatabase == null){
            return 0;
        }
        ContentValues values = new ContentValues();
        values.put(PercursoContract.PercursoEntry.COLUMN_NAME_ORIGEM,origem);
        values.put(PercursoContract.PercursoEntry.COLUMN_NAME_DESTINO,destino);
        values.put(PercursoContract.PercursoEntry.COLUMN_NAME_LATITUDE_ORIGEM,latitudeOrigem);
        values.put(PercursoContract.PercursoEntry.COLUMN_NAME_LONGITUDE_ORIGEM,longitudeOrigem);
        values.put(PercursoContract.PercursoEntry.COLUMN_NAME_LATITUDE_DESTINO,latitudeDestino);
        values.put(PercursoContract.PercursoEntry.COLUMN_NAME_LONGITUDE_DESTINO,longitudeDestino);
        values.put(PercursoContract.PercursoEntry.COLUMN_NAME_DISTANCIA,distancia);

        long newRowId = sqLiteDatabase.insert(PercursoContract.PercursoEntry.TABLE_NAME,null,values);

        return newRowId;
    }

    public List<String> listAll(){
        List<String> valores = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = percursoConstrutor.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + PercursoContract.PercursoEntry.TABLE_NAME,null);

        if(cursor.moveToFirst()){
            do{
                valores.add(cursor.getString(0) + " - " + cursor.getString(1) + " => " + cursor.getString(2) + "\n"
                + "Distância: " + String.format("%.2f",cursor.getDouble(7) / 1000) + " km");
            } while (cursor.moveToNext());
        }
        return valores;
    }

    public List<Percurso> listAllPercursos(){
        List<Percurso> valores = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = percursoConstrutor.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + PercursoContract.PercursoEntry.TABLE_NAME,null);

        if(cursor.moveToFirst()){
            do{
                Percurso percurso = new Percurso();
                percurso.setOrigem(cursor.getString(1));
                percurso.setDestino(cursor.getString(2));
                percurso.setLatOrigem(cursor.getDouble(3));
                percurso.setLongOrigem(cursor.getDouble(4));
                percurso.setLatDestino(cursor.getDouble(5));
                percurso.setLongDestino(cursor.getDouble(6));
                percurso.setDistancia(cursor.getDouble(7));

                valores.add(percurso);
            } while (cursor.moveToNext());
        }
        return valores;
    }
}
