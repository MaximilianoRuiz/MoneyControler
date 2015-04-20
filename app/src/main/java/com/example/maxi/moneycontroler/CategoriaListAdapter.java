package com.example.maxi.moneycontroler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Maxi on 15/03/2015.
 */
public class CategoriaListAdapter extends ArrayAdapter<CategoriaVO> {

    private Context context;
    private List<CategoriaVO> categorias;

    public CategoriaListAdapter(Context context, List<CategoriaVO> categoria) {
        super(context, R.layout.categoria_row_list, android.R.id.text1, categoria);
        this.context = context;
        this.categorias = categoria;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.categoria_row_list, parent, false);

        TextView labelCategoria, labelMonto;
        String monto;

        labelCategoria = (TextView) row.findViewById(R.id.categoriaTxtNombre);
        labelMonto = (TextView) row.findViewById(R.id.categoriaTxtMonto);

        labelCategoria.setText(categorias.get(position).getCategoria());

        monto = categorias.get(position).isFijo() ? "$" + categorias.get(position).getMonto() : "";

        labelMonto.setText(monto);

        return row;
    }
}
