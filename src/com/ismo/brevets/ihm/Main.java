package com.ismo.brevets.ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;
	
	 JDesktopPane desktopPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setTitle("Gestion des brevets");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 442);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnInventeur = new JMenu("Inventeurs");
		menuBar.add(mnInventeur);
		
		JMenuItem mntmListeDesInventeurs = new JMenuItem("Liste des inventeurs");
		mntmListeDesInventeurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			lstInventeur lstiv=new lstInventeur();
			desktopPane.add(lstiv);
			lstiv.setVisible(true);
			}
		});
		mnInventeur.add(mntmListeDesInventeurs);
		
		JMenu mnInventions = new JMenu("Inventions");
		menuBar.add(mnInventions);
		
		JMenuItem mntmListeDesInventions = new JMenuItem("Liste des inventions");
		mntmListeDesInventions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			lstInvetion lsti=new lstInvetion();
			desktopPane.add(lsti);
			lsti.setVisible(true);
			}
		});
		mnInventions.add(mntmListeDesInventions);
		
		JMenu mnEntreprises = new JMenu("Entreprises");
		menuBar.add(mnEntreprises);
		
		JMenuItem mntmListeDesEntreprises = new JMenuItem("Liste des entreprises");
		mntmListeDesEntreprises.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
			lstEntreprise l=new lstEntreprise();
			desktopPane.add(l);
			l.setVisible(true);
			}
		});
		mnEntreprises.add(mntmListeDesEntreprises);
		
		JMenu mnBrevets = new JMenu("Brevets");
		menuBar.add(mnBrevets);
		
		JMenuItem mntmListeDesBrevets = new JMenuItem("Liste des brevets");
		mntmListeDesBrevets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			lstBrevets e=new lstBrevets();
			desktopPane.add(e);
			 e.setVisible(true);
			}
		});
		mnBrevets.add(mntmListeDesBrevets);
		
		JMenu mnReporting = new JMenu("Reporting");
		menuBar.add(mnReporting);
		
		JMenuItem mntmListeDesInventeurs_1 = new JMenuItem("Liste des inventeurs");
		mntmListeDesInventeurs_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Test3();
			}
		});
		mnReporting.add(mntmListeDesInventeurs_1);
		
		JMenuItem mntmListeDesInventions_1 = new JMenuItem("Liste des inventions");
		mntmListeDesInventions_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Test2();
			}
		});
		mnReporting.add(mntmListeDesInventions_1);
		
		JMenuItem mntmListeDesEntreprises_1 = new JMenuItem("Liste des entreprises");
		mntmListeDesEntreprises_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Test4();
			}
		});
		mnReporting.add(mntmListeDesEntreprises_1);
		
		JMenuItem mntmListeDesBrevets_1 = new JMenuItem("Liste des brevets");
		mntmListeDesBrevets_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Test();
			}
		});
		mnReporting.add(mntmListeDesBrevets_1);
		
		JMenu mnGraphes = new JMenu("Graphes");
		menuBar.add(mnGraphes);
		
		JMenuItem mntmInventeurParEntreprise = new JMenuItem("Inventeur par entreprise");
		mntmInventeurParEntreprise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			TestGraphe1();
			}
		});
		mnGraphes.add(mntmInventeurParEntreprise);
		
		JMenuItem mntmInventionParDomaine = new JMenuItem("Invention par domaine");
		mntmInventionParDomaine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TestGraphe2();
			}
		});
		mnGraphes.add(mntmInventionParDomaine);
		
		JMenu mnAPropos = new JMenu("A propos");
		menuBar.add(mnAPropos);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
	}

	public void Test() {

		Connection conn = null; // database connection
        try {
            Class.forName("com.mysql.jdbc.Driver");
           /* conn = DriverManager.getConnection(
                  "jdbc:mysql://localhost/dbbrevets",
                    "root", "");*/
            conn=DriverManager.getConnection("jdbc:mysql://localhost/dbbrevets","root","");
           
            JasperPrint print = JasperFillManager.fillReport("Blank_A4_1.jasper", null, conn);
            JRViewer viewer = new JRViewer(print);
            viewer.setOpaque(true);
            
            JFrame frame = new JFrame("Jasper report");

            frame.getContentPane().add(viewer);
            frame.setSize(new Dimension(750, 650));
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
		}
	public void Test2() {

		Connection conn = null; // database connection
        try {
            Class.forName("com.mysql.jdbc.Driver");
           /* conn = DriverManager.getConnection(
                  "jdbc:mysql://localhost/dbbrevets",
                    "root", "");*/
            conn=DriverManager.getConnection("jdbc:mysql://localhost/dbbrevets","root","");
           
            JasperPrint print = JasperFillManager.fillReport("ReportInvention.jasper", null, conn);
            JRViewer viewer = new JRViewer(print);
            viewer.setOpaque(true);
            
            JFrame frame = new JFrame("Jasper report");

            frame.getContentPane().add(viewer);
            frame.setSize(new Dimension(750, 650));
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
		}
	public void Test3() {

		Connection conn = null; // database connection
        try {
            Class.forName("com.mysql.jdbc.Driver");
           /* conn = DriverManager.getConnection(
                  "jdbc:mysql://localhost/dbbrevets",
                    "root", "");*/
            conn=DriverManager.getConnection("jdbc:mysql://localhost/dbbrevets","root","");
           
            JasperPrint print = JasperFillManager.fillReport("ReportInventeur.jasper", null, conn);
            JRViewer viewer = new JRViewer(print);
            viewer.setOpaque(true);
            
            JFrame frame = new JFrame("Jasper report");

            frame.getContentPane().add(viewer);
            frame.setSize(new Dimension(750, 650));
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
		}
	public void Test4() {

		Connection conn = null; // database connection
        try {
            Class.forName("com.mysql.jdbc.Driver");
           /* conn = DriverManager.getConnection(
                  "jdbc:mysql://localhost/dbbrevets",
                    "root", "");*/
            conn=DriverManager.getConnection("jdbc:mysql://localhost/dbbrevets","root","");
           
            JasperPrint print = JasperFillManager.fillReport("ReportEntreprise.jasper", null, conn);
            JRViewer viewer = new JRViewer(print);
            viewer.setOpaque(true);
            
            JFrame frame = new JFrame("Jasper report");

            frame.getContentPane().add(viewer);
            frame.setSize(new Dimension(750, 650));
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
		}
	public void TestGraphe1() {

		Connection conn = null; // database connection
        try {
            Class.forName("com.mysql.jdbc.Driver");
           /* conn = DriverManager.getConnection(
                  "jdbc:mysql://localhost/dbbrevets",
                    "root", "");*/
            conn=DriverManager.getConnection("jdbc:mysql://localhost/dbbrevets","root","");
           
            JasperPrint print = JasperFillManager.fillReport("graphique.jasper", null, conn);
            JRViewer viewer = new JRViewer(print);
            viewer.setOpaque(true);
            
            JFrame frame = new JFrame("Jasper report");

            frame.getContentPane().add(viewer);
            frame.setSize(new Dimension(750, 650));
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
		}
	public void TestGraphe2() {

		Connection conn = null; // database connection
        try {
            Class.forName("com.mysql.jdbc.Driver");
           /* conn = DriverManager.getConnection(
                  "jdbc:mysql://localhost/dbbrevets",
                    "root", "");*/
            conn=DriverManager.getConnection("jdbc:mysql://localhost/dbbrevets","root","");
           
            JasperPrint print = JasperFillManager.fillReport("graphique2.jasper", null, conn);
            JRViewer viewer = new JRViewer(print);
            viewer.setOpaque(true);
            
            JFrame frame = new JFrame("Jasper report");

            frame.getContentPane().add(viewer);
            frame.setSize(new Dimension(750, 650));
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
		}
	}
