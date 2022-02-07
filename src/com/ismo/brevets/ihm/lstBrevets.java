package com.ismo.brevets.ihm;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTable;

import com.ismo.brevets.dao.DAO;
import com.ismo.brevets.dao.DaoFactory;
import com.ismo.brevets.dao.IDAO;
import com.ismo.brevets.metier.IMetier;
import com.ismo.brevets.models.Brevet;
import com.modelstable.ModelBrevet;
import javax.swing.JScrollPane;

public class lstBrevets extends JInternalFrame {
	private JTable table;
	ModelBrevet model;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lstBrevets frame = new lstBrevets();
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
	public lstBrevets() {
		setBounds(100, 100, 774, 473);
		getContentPane().setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 33, 578, 383);
		getContentPane().add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		
		model=new ModelBrevet();
		table.setModel(model);

	}
}
