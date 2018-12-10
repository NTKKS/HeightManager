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
        heightList.addItem(new HeightItem("Karel","Patočka",200));
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

        //pridani hornich itemů
        controlPanel.add(buttons);
        buttons.add(btnAdd, BorderLayout.CENTER);
        buttons.add(btnEdit, BorderLayout.CENTER);
        buttons.add(btnRemove, BorderLayout.CENTER);
        buttons.add(btnSave, BorderLayout.CENTER);

        //pridani horniho panelu
        add(controlPanel, BorderLayout.NORTH);

        //tabulka

        table = new JTable();
        table.setModel(model);
        add(new JScrollPane(table),BorderLayout.SOUTH);

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initAddDialog();
            }
        });
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initAddDialog();
            }
        });
        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void initAddDialog() {
        //vytvor dialog
        JDialog dlgAdd = new JDialog();
        dlgAdd.setVisible(true);
        dlgAdd.setSize(260, 200);
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

        //listenery
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dlgAdd.dispose();
            }
        });
    }

}
