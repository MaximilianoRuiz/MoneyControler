package com.example.maxi.moneycontroler;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;


public class Init extends Fragment {

    private List<RegistroVO> registroVOs;
    private ExpandableListView expandableListView;
    private List<String> categorias;
    private HashMap<String, List<RegistroVO>> stringListHashMap;

    public static Fragment newInstance(Context context) {
        Init f = new Init();

        return f;
    }

    @Override
     public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.activity_init, null);

        expandableListView = (ExpandableListView) view.findViewById(R.id.initList);

        initialList();

        MyExpandableListAdapter adapter2 = new MyExpandableListAdapter(getActivity(), stringListHashMap, categorias);
        expandableListView.setAdapter(adapter2);
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(getActivity(), groupPosition + " - " + childPosition, Toast.LENGTH_LONG).show();
                return false;
            }
        });

        return view;
    }

    private void initialList(){
        categorias = new ArrayList<>();
        registroVOs = new ArrayList<>();
        stringListHashMap = new HashMap<>();

        CategoriaVO categoriaVO1 = new CategoriaVO(0, "Expensas", 300, true);
        CategoriaVO categoriaVO2 = new CategoriaVO(0, "Expensas", 300, false);

        RegistroVO registroVO = new RegistroVO(0, 100.2, Calendar.getInstance().getTime(), categoriaVO1, true);
        registroVOs.add(registroVO);
        categorias.add("categoria 1");

        RegistroVO registroV1 = new RegistroVO(1, 110.2, Calendar.getInstance().getTime(), categoriaVO2, true);
        registroVOs.add(registroV1);
        categorias.add("categoria 2");

        RegistroVO registroV2 = new RegistroVO(2, 120.2, Calendar.getInstance().getTime(), categoriaVO1, false);
        registroVOs.add(registroV2);
        categorias.add("categoria 3");

        for(String str : categorias){
            stringListHashMap.put(str, registroVOs);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);
    }
}


