package cz.uhk.fim.heightmanager.gui;

import cz.uhk.fim.heightmanager.model.HeightItem;
import cz.uhk.fim.heightmanager.model.HeightList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private JTable table;
    private HeightTable model;
    private HeightList heightList;
    private HeightItem item;
    private static final String VALIDATION_TYPE = "VALIDATION_TYPE";
    private static final String NOT_NUM_TYPE = "NOT_NUM_TYPE";
    private static final String IO_LOAD_TYPE = "IO_LOAD_TYPE";
    private static final String IO_SAVE_TYPE = "IO_SAVE_TYPE";
    private JLabel lblErrorMessage;


    public MainFrame(){
        init();
    }

    private void init() {
        setTitle("Height Manager");
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        model = new HeightTable();
        heightList = new HeightList();
        heightList.addItem(new HeightItem("Karel","Patočka",200,null));
        model.setList(heightList);

        initContentUI();
    }

    private void initContentUI() {
        JPanel controlPanel = new JPanel(new BorderLayout());
        JPanel buttons = new JPanel(new FlowLayout());

        //horní itemy
        JButton btnAdd = new JButton("Add");
        JButton btnEdit = new JButton("Edit");
        JButton btnRemove = new JButton("Remove");
        JButton btnSave = new JButton("Save");

        lblErrorMessage = new JLabel();
        lblErrorMessage.setBackground(Color.RED);
        lblErrorMessage.setOpaque(true);
        lblErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);

        //pridani hornich itemů
        controlPanel.add(buttons);
        buttons.add(btnAdd);
        buttons.add(btnEdit);
        buttons.add(btnRemove);
        buttons.add(btnSave);

        //pridani horniho panelu
        add(controlPanel, BorderLayout.NORTH);

        //tabulka

        table = new JTable();
        table.setModel(model);
        add(new JScrollPane(table),BorderLayout.CENTER);

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (table.getSelectedRow()!=-1){
                    initAddDialog(table);
                }
            }
        });
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initAddDialog(null);
            }
        });
        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                heightList.removeItem(table.getSelectedRow());
                model.setList(heightList);
            }
        });
    }

    private void initAddDialog(JTable table) {
        //vytvor dialog
        JDialog dlgAdd = new JDialog();
        dlgAdd.setVisible(true);
        dlgAdd.setSize(260, 215);
        dlgAdd.setLocationRelativeTo(null);
        dlgAdd.setTitle("Add Height");
        dlgAdd.setLayout(new BorderLayout());
        //pridej itemy
        JTextField txtName = new JTextField();
        JLabel lblName = new JLabel("Jméno:");
        JTextField txtSurName = new JTextField();
        JLabel lblSurName = new JLabel("Příjmení:");
        JTextField txtHeight = new JTextField();
        JLabel lblHeight = new JLabel("Výška:");

        if (table!=null){
           txtName.setText((String) table.getValueAt(table.getSelectedRow(),0));
           txtSurName.setText((String) table.getValueAt(table.getSelectedRow(),1));
           txtHeight.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),3)));
        }

        JButton btnOK = new JButton("Přidej");
        JButton btnCancel = new JButton("Zruš");

        JPanel pnlFields = new JPanel();
        pnlFields.setLayout(new GridLayout(6,1));
        pnlFields.setBorder(BorderFactory.createEmptyBorder(5,30,0,30));
        dlgAdd.add(pnlFields,BorderLayout.NORTH);
        pnlFields.add(lblName);
        pnlFields.add(txtName);
        pnlFields.add(lblSurName);
        pnlFields.add(txtSurName);
        pnlFields.add(lblHeight);
        pnlFields.add(txtHeight);
        JPanel pnlBtns = new JPanel();
        dlgAdd.add(pnlBtns,BorderLayout.CENTER);
        pnlBtns.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pnlBtns.setBorder(BorderFactory.createEmptyBorder(0,0,0,25));
        pnlBtns.add(btnOK);
        pnlBtns.add(btnCancel);

        dlgAdd.add(lblErrorMessage,BorderLayout.SOUTH);
        lblErrorMessage.setVisible(false);

        //listenery
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isHeight(txtHeight.getText())&&validateInput(txtName.getText())&&validateInput(txtSurName.getText())){
                    item = new HeightItem(txtName.getText(),txtSurName.getText(),Double.parseDouble(txtHeight.getText()),null);
                    heightList.addItem(item);
                    model.setList(heightList);
                    dlgAdd.dispose();
                }
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dlgAdd.dispose();
            }
        });
    }

    private boolean validateInput(String text) {
        lblErrorMessage.setVisible(false);
        if (text.trim().isEmpty()) {
            showErrorMessage(VALIDATION_TYPE);
            return false;
        }
        return true;
    }

    private boolean isHeight(String txtHeight) {
        lblErrorMessage.setVisible(false);
        if (!txtHeight.matches("-?\\d+(\\.\\d+)?")) {
            showErrorMessage(NOT_NUM_TYPE);
            return false;
        }
        return true;
    }

    private void showErrorMessage(String type) {
        String message;
        switch (type) {
            case VALIDATION_TYPE:
                message = "Chyba! Pole nesmí být prázdné!";
                break;
            case NOT_NUM_TYPE:
                message = "Chyba! Nezadal/a jsi číslo!";
                break;
            case IO_LOAD_TYPE:
                message = "Chyba při načítání souboru.";
                break;
            case IO_SAVE_TYPE:
                message = "Chyba při ukládání souboru.";
                break;
            default:
                message = "Bůh ví, co se stalo.";
                break;
        }
        lblErrorMessage.setText(message);
        lblErrorMessage.setVisible(true);
    }

}
