package com.example.maxi.moneycontroler;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Maxi on 15/03/2015.
 */
public class AhorroListAdapter extends ArrayAdapter<RegistroVO> {

    private Context context;
    private List<RegistroVO> registroVOs;

    public AhorroListAdapter(Context context, List<RegistroVO> registroVOs) {
        super(context, R.layout.ahorro_row_list, android.R.id.text1, registroVOs);
        this.context = context;
        this.registroVOs = registroVOs;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.ahorro_row_list, parent, false);

        TextView labelMes, labelMonto;
        DateFormat dt = new SimpleDateFormat("MM");
        Boolean debitado = registroVOs.get(position).isDebitado();

        labelMes = (TextView) row.findViewById(R.id.ahorroTxtMes);
        labelMonto = (TextView) row.findViewById(R.id.ahorroTxtMonto);

        String mes = dt.format(registroVOs.get(position).getFecha());
        labelMes.setText(obtenerMes(mes));

        String monto =  debitado ? "-" : "+";
        monto = monto + "$ " + registroVOs.get(position).getMonto();
        labelMonto.setText(monto);
        if(debitado){
            labelMonto.setTextColor(Color.RED);
        } else{
            labelMonto.setTextColor(Color.GREEN);
        }
        return row;
    }

    private String obtenerMes(String mes){

        switch (mes){
            case "01":
                return "Enero";
            case "02":
                return "Febrero";
            case "03":
                return "Marzo";
            case "04":
                return "Abril";
            case "05":
                return "Mayo";
            case "06":
                return "Junio";
            case "07":
                return "Julio";
            case "08":
                return "Agosto";
            case "09":
                return "Septiembre";
            case "10":
                return "Octubre";
            case "11":
                return "Noviembre";
            case "12":
                return "Diciembre";
            default:
                return "Error de Mes";
        }
    }
}
