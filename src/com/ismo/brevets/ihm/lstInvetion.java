package com.ismo.brevets.ihm;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTable;

import com.modelstable.Modelinvention;

import javax.swing.JScrollPane;

public class lstInvetion extends JInternalFrame {
	private JTable table;
	Modelinvention model;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lstInvetion frame = new lstInvetion();
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
	public lstInvetion() {
		setBounds(100, 100, 597, 505);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 571, 453);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		model=new Modelinvention();
		table.setModel(model);
	}

}
