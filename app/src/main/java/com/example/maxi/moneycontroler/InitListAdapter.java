package com.example.maxi.moneycontroler;

import android.content.Context;
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
public class InitListAdapter extends ArrayAdapter<RegistroVO> {

    private Context context;
    private List<RegistroVO> registroVOs;

    public InitListAdapter(Context context, List<RegistroVO> registroVOs) {
        super(context, R.layout.init_row_list_2, android.R.id.text1, registroVOs);
        this.context = context;
        this.registroVOs = registroVOs;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.init_row_list_2, parent, false);

        String fecha, monto, fijo;
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");

        TextView laberlFecha = (TextView) row.findViewById(R.id.initRow2TxtFecha);
        TextView labelMonto = (TextView) row.findViewById(R.id.initRow2TxtMonto);
        TextView labelFijo = (TextView) row.findViewById(R.id.initRow2TxtFijo);

        fecha = dateFormat.format(registroVOs.get(position).getFecha());
        monto = Double.toString(registroVOs.get(position).getMonto());
        fijo = registroVOs.get(position).isDebitado() ? "SI" : "NO";

        laberlFecha.setText(fecha);
        labelMonto.setText("$ " + monto);
        labelFijo.setText(fijo);

        return row;
    }
}
