package com.example.maxi.moneycontroler;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Ahorro extends Fragment {

    private ListView listView;
    private List<RegistroVO> registroVOs;
    private TextView txtTotal;

    public static Fragment newInstance(Context context) {
        Ahorro f = new Ahorro();

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.activity_ahorro, null);

        initList();

        listView = (ListView) view.findViewById(R.id.listaAhorro);
        listView.setAdapter(new AhorroListAdapter(getActivity(), registroVOs));

        txtTotal = (TextView) view.findViewById(R.id.txtTotal);

        txtTotal.setText(total());

        return view;
    }

    private void initList(){
        registroVOs = new ArrayList<>();
        CategoriaVO categoriaVO = new CategoriaVO(0, "Expensas", 1024.5, true);

        registroVOs.add(new RegistroVO(0, 1000.0, new Date(), categoriaVO, true));
        registroVOs.add(new RegistroVO(1, 2030.0, new Date(), categoriaVO, false));
        registroVOs.add(new RegistroVO(2, 1200.0, new Date(), categoriaVO, false));
        registroVOs.add(new RegistroVO(3, 1400.0, new Date(), categoriaVO, true));
    }

    private String total(){
        String total;
        double sum, rest, dif;
        sum = rest = 0.0;

        for(RegistroVO registroVO : registroVOs){
            if(registroVO.isDebitado()) {
                rest = rest + registroVO.getMonto();
            }else{
                sum = sum + registroVO.getMonto();
            }
        }

        dif = sum - rest;
        total = dif > 0.0 ? "+ $" : "- $";
        total = total + Double.toString(dif);

        return total;
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
