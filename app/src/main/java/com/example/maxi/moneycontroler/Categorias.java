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
import java.util.List;


public class Categorias extends Fragment {

    private ListView listView;
    private List<CategoriaVO> categoriaVOs;

    public static Fragment newInstance(Context context) {
        Categorias f = new Categorias();

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.activity_categorias, null);

        initialList();

        listView = (ListView) view.findViewById(R.id.listaCategorias);
        listView.setAdapter(new CategoriaListAdapter(getActivity(), categoriaVOs));

        return view;
    }

    private void initialList(){
        categoriaVOs = new ArrayList<>();

        categoriaVOs.add(new CategoriaVO(0, "Expensas", 1024.5, true));
        categoriaVOs.add(new CategoriaVO(1, "Renta", 2750.0, true));
        categoriaVOs.add(new CategoriaVO(2, "Sueldo", 7050.0, true));
        categoriaVOs.add(new CategoriaVO(3, "Almuerzo", 700.5, false));
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
