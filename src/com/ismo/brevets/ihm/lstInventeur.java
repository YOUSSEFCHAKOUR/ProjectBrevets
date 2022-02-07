package com.ismo.brevets.ihm;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTable;

import com.modelstable.Modelinventeur;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;

public class lstInventeur extends JInternalFrame {
	private JTable table;
	Modelinventeur model;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lstInventeur frame = new lstInventeur();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public lstInventeur() {
		setBounds(100, 100, 599, 516);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 573, 464);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		model=new Modelinventeur();
		table.setModel(model);
	}

}
