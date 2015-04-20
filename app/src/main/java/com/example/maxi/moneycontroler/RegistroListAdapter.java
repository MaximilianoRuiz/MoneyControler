package com.example.maxi.moneycontroler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Maxi on 15/03/2015.
 */
public class RegistroListAdapter extends ArrayAdapter<String> {

    private Context context;
    private List<String> meses;
    private List<Date> años;

    public RegistroListAdapter(Context context, List<String> meses, List<Date> años) {
        super(context, R.layout.registro_row_list, android.R.id.text1, meses);
        this.context = context;
        this.meses = meses;
        this.años = años;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.registro_row_list, parent, false);

        TextView labelMes, labelAño;
        DateFormat dt = new SimpleDateFormat("yyyy");

        labelMes = (TextView) row.findViewById(R.id.registroeTxtMes);
        labelAño = (TextView) row.findViewById(R.id.registroeTxtAño);

        labelMes.setText(meses.get(position));
        labelAño.setText(dt.format(años.get(position)));

        return row;
    }
}
