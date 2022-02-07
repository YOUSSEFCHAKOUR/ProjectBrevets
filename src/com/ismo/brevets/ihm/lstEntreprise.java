package com.ismo.brevets.ihm;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTable;

import com.modelstable.ModelEntreprise;

import javax.swing.JScrollPane;

public class lstEntreprise extends JInternalFrame {
	private JTable table;
	ModelEntreprise model;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lstEntreprise frame = new lstEntreprise();
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
	public lstEntreprise() {
		setBounds(100, 100, 594, 492);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 578, 440);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		model=new ModelEntreprise();
		table.setModel(model);

	}

}
