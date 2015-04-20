package com.example.maxi.moneycontroler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Maxi on 18/04/2015.
 */
public class MyExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    public LayoutInflater inflater;
    private HashMap<String, List<RegistroVO>> registroVOMap;
    private List<String> registros;

    public MyExpandableListAdapter(Context context, HashMap<String, List<RegistroVO>> registroVOMap,
                                   List<String> registros) {
        this.context = context;
        this.registroVOMap = registroVOMap;
        this.registros = registros;
    }

    @Override
    public int getGroupCount() {
        return registros.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return registroVOMap.get(registros.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return registros.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return registroVOMap.get(registros.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        TextView labelCategoria, labelCantidad;
        if (convertView == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.init_row_list_1, null);
        }

        labelCategoria = (TextView) convertView.findViewById(R.id.initRow1TxtCategoria);
        labelCantidad = (TextView) convertView.findViewById(R.id.initRow1TxtCount);

        labelCategoria.setText(registros.get(groupPosition));
        Integer cantidad = getChildrenCount(groupPosition);
        labelCantidad.setText(cantidad.toString());

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final RegistroVO registroVO = (RegistroVO) getChild(groupPosition, childPosition);
        TextView labelFecha, labelMonto, labelFijo;
        String debitado, fijo;
        DateFormat dt = new SimpleDateFormat("dd/MM/yyyy");

        if (convertView == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.init_row_list_2, parent, false);
        }

        labelFecha = (TextView) convertView.findViewById(R.id.initRow2TxtFecha);
        labelMonto = (TextView) convertView.findViewById(R.id.initRow2TxtMonto);
        labelFijo = (TextView) convertView.findViewById(R.id.initRow2TxtFijo);

        debitado = registroVO.isDebitado() ? "- $ " : "+ $ ";
        fijo = registroVO.getCategoria().isFijo() ? "Si" : "No";

        labelFecha.setText(dt.format(registroVO.getFecha()));
        labelMonto.setText(debitado + Double.toString(registroVO.getMonto()));
        labelFijo.setText(fijo);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
