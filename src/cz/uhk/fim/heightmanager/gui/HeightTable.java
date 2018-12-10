package cz.uhk.fim.heightmanager.gui;

import cz.uhk.fim.heightmanager.model.HeightItem;
import cz.uhk.fim.heightmanager.model.HeightList;

import javax.swing.table.AbstractTableModel;
import java.util.Date;

public class HeightTable extends AbstractTableModel {
    private HeightList heightList;

    public void setList(HeightList heightList) {
        this.heightList = heightList;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return heightList.getItemCount();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        HeightItem item = heightList.getItemByIndex(rowIndex);
        switch (columnIndex) {
            case 0:
                return item.getJmeno();
            case 1:
                return item.getPrijmeni();
            case 2:
                return item.getDatumZapisu();
            case 3:
                return item.getVyska();
            case 4:
                return item.isDostacuje();
            default:
                return "?";
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        HeightItem item = heightList.getItemByIndex(rowIndex);
        switch (columnIndex) {
            case 0:
                item.setJmeno((String) aValue);
                break;
            case 1:
                item.setDostacuje((Boolean) aValue);
                break;
            default:
                break;
        }
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Jméno";
            case 1:
                return "Příjmení";
            case 2:
                return "Datum a čas";
            case 3:
                return "Výška";
            case 4:
                return "Dostačující";
            default:
                return "?";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return Date.class;
            case 3:
                return Double.class;
            case 4:
                return Boolean.class;
            default:
                return Object.class;
        }
    }

}
