package com.seminario.juancarlos.gpsimple.dao;

import android.provider.BaseColumns;

/**
 * Created by juancarlos on 26/05/18.
 */

public final class PercursoContract {
    public PercursoContract(){}

    public static class PercursoEntry implements BaseColumns {
        public static String TABLE_NAME = "percurso";
        public static String COLUMN_NAME_ORIGEM = "origem";
        public static String COLUMN_NAME_DESTINO = "destino";
        public static String COLUMN_NAME_LATITUDE_ORIGEM = "latitude_origem";
        public static String COLUMN_NAME_LONGITUDE_ORIGEM = "longitude_origem";
        public static String COLUMN_NAME_LATITUDE_DESTINO = "latitude_destino";
        public static String COLUMN_NAME_LONGITUDE_DESTINO = "longitude_destino";
        public static String COLUMN_NAME_DISTANCIA = "distancia";
    }
}
