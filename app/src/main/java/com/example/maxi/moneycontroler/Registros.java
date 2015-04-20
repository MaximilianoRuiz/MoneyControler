package com.example.maxi.moneycontroler;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class Registros extends Fragment {

    private ListView listView;
    private List<String> meses;
    private List<Date> años;

    public static Fragment newInstance(Context context) {
        Registros f = new Registros();

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.activity_registros, null);

        listView = (ListView) view.findViewById(R.id.listaRegistros);

        initialList();

        listView.setAdapter(new RegistroListAdapter(getActivity(), meses, años));

        return view;
    }

    private void initialList(){
        meses = new ArrayList<>();
        años = new ArrayList<>();

        meses.add("Abril");
        meses.add("Marzo");
        meses.add("Febrero");
        meses.add("Enero");


        años.add(Calendar.getInstance().getTime());
        años.add(Calendar.getInstance().getTime());
        años.add(Calendar.getInstance().getTime());
        años.add(Calendar.getInstance().getTime());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
