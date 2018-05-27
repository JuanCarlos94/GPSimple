package com.seminario.juancarlos.gpsimple;

import android.app.IntentService;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.maps.model.LatLng;
import com.seminario.juancarlos.gpsimple.dao.PercursoDao;
import com.seminario.juancarlos.gpsimple.model.Percurso;

import java.util.List;

public class ListRotasActivity extends AppCompatActivity {

    ListView listRotas;

    PercursoDao percursoDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_rotas);

        listRotas = (ListView) findViewById(R.id.ltRotas);

        percursoDao = new PercursoDao(this);

        List<String> rotas = percursoDao.listAll();
        final List<Percurso> percursos = percursoDao.listAllPercursos();
        Log.e("Teste",percursos.get(0).getOrigem());

        if(rotas != null) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, rotas);
            listRotas.setAdapter(adapter);
        }

        listRotas.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MapsActivity.listPoints.clear();
                MapsActivity.listPoints.add(new LatLng(percursos.get(position).getLatOrigem(),percursos.get(position).getLongOrigem()));
                MapsActivity.listPoints.add(new LatLng(percursos.get(position).getLatDestino(),percursos.get(position).getLongDestino()));
                Intent intent = new Intent(ListRotasActivity.this,MapsActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ListRotasActivity.this,MapsActivity.class);
        startActivity(intent);
        finish();
    }
}
