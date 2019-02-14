package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import aktorer.Admansatt;
import aktorer.Ansatt;
import aktorer.Elev;
import aktorer.Fagansatt;
import medlemmer.Enhet;
import medlemmer.Kull;
import aktorer.Person;

import java.util.ArrayList;
import javax.swing.JTabbedPane;
import javax.swing.JList;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.event.ListSelectionListener;

import org.omg.Messaging.SyncScopeHelper;

import FilBehandling.FilSkriver;

import javax.swing.event.ListSelectionEvent;
/**
 * 
 * @author Lali
 *
 */
public class MainFrame extends JFrame implements Serializable{
	private static final long serialVersionUID = 8453602394676916825L;
	private JPanel contentPane;
	private JTextField startaarTF;
	private JTextField fNavnTF;
	private JTextField eNavnTF;
	private JTextField idTF;
	private JTextField navnTF;
	private JTextField enhetIdTF;
	private JTextField fagfNavnTF;
	private JTextField fageNavnTF;
	private JTextField fagidTF;
	private JTextField admfNavnTF;
	private JTextField admeNavnTF;
	private JTextField admidTF;
	private JList kullListe;
	private JList elevListe;
	private JList fagListe;
	private JList admListe;
	private JComboBox ansvarligCB;
	private JComboBox kullCB;
	private JComboBox enhetCB;
	private JList enhetListe;
	private JButton btnElevLagre;
	private JButton elevReg;
	private JButton fagansattReg;
	private JButton fagLagre;
	private JButton admLagre;
	private JButton admReg;
	private JButton kullLagre;
	private JButton kullReg;
	private JButton enhetReg;
	private JButton enhetLagre;
	private JButton btnGgg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 659, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 633, 301);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setBounds(10, 11, 613, 279);
		panel.add(tabbedPane);
		
		JPanel elevTab = new JPanel();
		tabbedPane.addTab("Elev", null, elevTab, null);
		elevTab.setLayout(null);
		
		JLabel lblFornavn = new JLabel("Fornavn");
		lblFornavn.setBounds(10, 11, 46, 14);
		elevTab.add(lblFornavn);
		
		JLabel lblEtternavn = new JLabel("Etternavn");
		lblEtternavn.setBounds(10, 40, 59, 14);
		elevTab.add(lblEtternavn);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(10, 69, 46, 14);
		elevTab.add(lblId);
		
		JLabel lblKull = new JLabel("Kull");
		lblKull.setBounds(10, 105, 46, 14);
		elevTab.add(lblKull);
		
		JLabel lblNewLabel_1 = new JLabel("Enhet");
		lblNewLabel_1.setBounds(10, 138, 46, 14);
		elevTab.add(lblNewLabel_1);
		
		fNavnTF = new JTextField();
		fNavnTF.setBounds(78, 8, 86, 20);
		elevTab.add(fNavnTF);
		fNavnTF.setColumns(10);
		
		eNavnTF = new JTextField();
		eNavnTF.setBounds(78, 37, 86, 20);
		elevTab.add(eNavnTF);
		eNavnTF.setColumns(10);
		
		idTF = new JTextField();
		idTF.setBounds(78, 66, 86, 20);
		elevTab.add(idTF);
		idTF.setColumns(10);
		
		kullCB = new JComboBox();
		kullCB.setBounds(78, 102, 86, 20);
		elevTab.add(kullCB);
		
		enhetCB = new JComboBox();
		enhetCB.setBounds(78, 135, 86, 20);
		elevTab.add(enhetCB);
		
		elevReg = new JButton("Registrer");
		elevReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String fNavn = fNavnTF.getText();
				String eNavn = eNavnTF.getText();
				String id = idTF.getText();
				Kull kull = (Kull) kullCB.getSelectedItem();
			    Elev e1 = new Elev(fNavn, eNavn, id, kull);
			    clearText();
			    leggTil();
				ArrayList<Object> liste = new ArrayList<>();
				for (Object o : Elev.personer){
					if (o instanceof Elev){
						liste.add(o);
					}
					else{}
				}
				skrivTilElevDB((Elev) e1, "Elev");
				}
		});
		elevReg.setBounds(75, 182, 89, 23);
		elevTab.add(elevReg);
		
		elevListe = new JList();
		elevListe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Elev e1 = (Elev) elevListe.getSelectedValue();
				fNavnTF.setText(e1.getfNavn());
				eNavnTF.setText(e1.geteNavn());
				idTF.setText(e1.getId());
				kullCB.setSelectedItem(e1.getKull());
				enhetCB.setSelectedItem(e1.getEnhet());
				btnElevLagre.setEnabled(true);
				elevReg.setEnabled(false);
			}
		});
		elevListe.setBounds(197, 10, 241, 253);
		elevTab.add(elevListe);
		
		btnElevLagre = new JButton("Lagre");
		btnElevLagre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Elev e2 = (Elev) elevListe.getSelectedValue();
				e2.setfNavn(fNavnTF.getText());
				e2.seteNavn(eNavnTF.getText());
				e2.setId(idTF.getText());
				e2.setKull((Kull) kullCB.getSelectedItem());
				e2.setEnhet((Enhet) enhetCB.getSelectedItem());
				clearText();
				btnElevLagre.setEnabled(false);
				elevReg.setEnabled(true);
				leggTil();
				ArrayList<Object> liste = new ArrayList<>();
				for (Object o : Elev.personer){
					if (o instanceof Elev){
						liste.add(o);
					}
					else {}
				}
				oppdatereDB(e2,"Elev");
			}
		});
		btnElevLagre.setEnabled(false);
		btnElevLagre.setBounds(75, 216, 89, 23);
		elevTab.add(btnElevLagre);
		
		
		JPanel fagansattTab = new JPanel();
		tabbedPane.addTab("Fagansatt", null, fagansattTab, null);
		fagansattTab.setLayout(null);
		
		JLabel lblFornavn_1 = new JLabel("Fornavn");
		lblFornavn_1.setBounds(10, 11, 46, 14);
		fagansattTab.add(lblFornavn_1);
		
		JLabel lblEtternavn_1 = new JLabel("Etternavn");
		lblEtternavn_1.setBounds(10, 36, 60, 14);
		fagansattTab.add(lblEtternavn_1);
		
		JLabel lblId_1 = new JLabel("ID");
		lblId_1.setBounds(10, 61, 46, 14);
		fagansattTab.add(lblId_1);
		
		fagfNavnTF = new JTextField();
		fagfNavnTF.setBounds(77, 8, 86, 20);
		fagansattTab.add(fagfNavnTF);
		fagfNavnTF.setColumns(10);
		
		fageNavnTF = new JTextField();
		fageNavnTF.setBounds(77, 33, 86, 20);
		fagansattTab.add(fageNavnTF);
		fageNavnTF.setColumns(10);
		
		fagidTF = new JTextField();
		fagidTF.setBounds(77, 58, 86, 20);
		fagansattTab.add(fagidTF);
		fagidTF.setColumns(10);
		
		fagansattReg = new JButton("Registrer");
		fagansattReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String fagfNavn = fagfNavnTF.getText();
				String fageNavn = fageNavnTF.getText();
				String fagid = fagidTF.getText();
				
				Fagansatt fag1 = new Fagansatt(fagfNavn, fageNavn, fagid);
				clearText();
				leggTil();
				ArrayList<Object> liste = new ArrayList<>();
				for (Object o : Fagansatt.personer){
					if (o instanceof Fagansatt){
						liste.add(o);
						}
					else{}
				}
				skrivTilAnsattDB(fag1 , "Fagansatt");
			}
		});
		fagansattReg.setBounds(74, 167, 89, 23);
		fagansattTab.add(fagansattReg);
		
		fagListe = new JList();
		fagListe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Fagansatt fag1 = (Fagansatt) fagListe.getSelectedValue();
				fagfNavnTF.setText(fag1.getfNavn());
				fageNavnTF.setText(fag1.geteNavn());
				fagidTF.setText(fag1.getId());
				fagansattReg.setEnabled(false);
				fagLagre.setEnabled(true);
			}
		});
		fagListe.setBounds(202, 10, 222, 252);
		fagansattTab.add(fagListe);
		
		fagLagre = new JButton("Lagre");
		fagLagre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fagansatt fag2 = (Fagansatt) fagListe.getSelectedValue();
				fag2.setfNavn(fagfNavnTF.getText());
				fag2.seteNavn(fageNavnTF.getText());
				fag2.setId(fagidTF.getText());
				fagLagre.setEnabled(false);
				fagansattReg.setEnabled(true);
				clearText();
				leggTil();
				ArrayList<Object> liste = new ArrayList<>();
				for (Object o : Fagansatt.personer){
					if (o instanceof Fagansatt){
						liste.add(o);
					}
					else{}
				}
			}
		});
		fagLagre.setEnabled(false);
		fagLagre.setBounds(74, 197, 89, 23);
		fagansattTab.add(fagLagre);
		
		JPanel admansattTab = new JPanel();
		admansattTab.setLayout(null);
		tabbedPane.addTab("Admansatt", null, admansattTab, null);
		
		JLabel label_5 = new JLabel("Fornavn");
		label_5.setBounds(10, 11, 46, 14);
		admansattTab.add(label_5);
		
		JLabel label_6 = new JLabel("Etternavn");
		label_6.setBounds(10, 36, 60, 14);
		admansattTab.add(label_6);
		
		JLabel label_7 = new JLabel("ID");
		label_7.setBounds(10, 65, 46, 14);
		admansattTab.add(label_7);
		
		admfNavnTF = new JTextField();
		admfNavnTF.setColumns(10);
		admfNavnTF.setBounds(77, 8, 86, 20);
		admansattTab.add(admfNavnTF);
		
		admeNavnTF = new JTextField();
		admeNavnTF.setColumns(10);
		admeNavnTF.setBounds(77, 33, 86, 20);
		admansattTab.add(admeNavnTF);
		
		admidTF = new JTextField();
		admidTF.setColumns(10);
		admidTF.setBounds(77, 62, 86, 20);
		admansattTab.add(admidTF);
		
		admReg = new JButton("Registrer");
		admReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String admfNavn = admfNavnTF.getText();
				String admeNavn = admeNavnTF.getText();
				String admid = admidTF.getText();
				
				Admansatt adm1 = new Admansatt(admfNavn, admeNavn, admid);
				leggTil();
				clearText();
				ArrayList<Object> liste = new ArrayList<>();
				for (Object o : Admansatt.personer){
					if (o instanceof Admansatt){
						liste.add(o);
					}
					else {}
				}
				skrivTilAnsattDB(adm1 , "Admansatt");
			}
		});
		admReg.setBounds(74, 167, 89, 23);
		admansattTab.add(admReg);
		
		admListe = new JList();
		admListe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Admansatt adm1 = (Admansatt) admListe.getSelectedValue();
				admfNavnTF.setText(adm1.getfNavn());
				admeNavnTF.setText(adm1.geteNavn());
				admidTF.setText(adm1.getId());
				admLagre.setEnabled(true);
				admReg.setEnabled(false);
				admidTF.setEditable(false);
			}
		});
		admListe.setBounds(188, 10, 216, 235);
		admansattTab.add(admListe);
		
		admLagre = new JButton("Lagre");
		admLagre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admansatt adm2 = (Admansatt) admListe.getSelectedValue();
				adm2.setfNavn(admfNavnTF.getText());
				adm2.seteNavn(admeNavnTF.getText());
				adm2.setId(admidTF.getText());
				clearText();
				admReg.setEnabled(true);
				admLagre.setEnabled(false);
				admidTF.setEditable(true);
				leggTil();
				ArrayList<Object> liste = new ArrayList<>();
				for (Object o : Admansatt.personer){
					if (o instanceof Admansatt){
						liste.add(o);
					}
					else{}
				}
			}
		});
		admLagre.setEnabled(false);
		admLagre.setBounds(74, 201, 89, 23);
		admansattTab.add(admLagre);
		
		JPanel kullTab = new JPanel();
		tabbedPane.addTab("Kull", null, kullTab, null);
		kullTab.setLayout(null);
		
		JLabel lblStartr = new JLabel("Start\u00E5r");
		lblStartr.setBounds(10, 11, 46, 14);
		kullTab.add(lblStartr);
		
		
		startaarTF = new JTextField();
		startaarTF.setBounds(77, 8, 86, 20);
		kullTab.add(startaarTF);
		startaarTF.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ansvarlig");
		lblNewLabel.setBounds(10, 50, 46, 14);
		kullTab.add(lblNewLabel);
		
		ansvarligCB = new JComboBox();
		ansvarligCB.setBounds(77, 47, 86, 20);
		kullTab.add(ansvarligCB);
		
		kullReg = new JButton("Registrer");
		kullReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String startaar = startaarTF.getText();
				
				Kull kull1 = new Kull(startaar, (Fagansatt)ansvarligCB.getSelectedItem());
				leggTilKull();
				ArrayList<Object> liste = new ArrayList<>();
				for (Object o : Kull.kull){
					liste.add(o);
				}
				skrivTilKullDB(kull1 , "Kull");
				
			}
		});
		kullReg.setBounds(74, 97, 89, 23);
		kullTab.add(kullReg);
		
		kullListe = new JList();
		kullListe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			Kull k1 = (Kull) kullListe.getSelectedValue();
			startaarTF.setText(k1.getStartaar());
			ansvarligCB.setSelectedItem(k1.getAnsvarlig());
			kullLagre.setEnabled(true);
			kullReg.setEnabled(false);
			
			}
		});
		kullListe.setBounds(240, 11, 222, 252);
		kullTab.add(kullListe);
		
		kullLagre = new JButton("Lagre");
		kullLagre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Kull k2 = (Kull) kullListe.getSelectedValue();
				k2.setAnsvarlig((Fagansatt) ansvarligCB.getSelectedItem());
				k2.setStartaar(startaarTF.getText());
				kullLagre.setEnabled(false);
				kullReg.setEnabled(true);
				clearText();
				leggTilKull();
				ArrayList<Object> liste = new ArrayList<>();
				for (Object o : Kull.kull){
					liste.add(o);
				}
			}
		});
		kullLagre.setEnabled(false);
		kullLagre.setBounds(77, 131, 89, 23);
		kullTab.add(kullLagre);
		
		JPanel enhetTab = new JPanel();
		tabbedPane.addTab("Enhet", null, enhetTab, null);
		enhetTab.setLayout(null);
		
		JLabel lblNavn = new JLabel("Navn");
		lblNavn.setBounds(10, 11, 46, 14);
		enhetTab.add(lblNavn);
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setBounds(10, 48, 46, 14);
		enhetTab.add(lblNewLabel_2);
		
		navnTF = new JTextField();
		navnTF.setBounds(49, 8, 86, 20);
		enhetTab.add(navnTF);
		navnTF.setColumns(10);
		
		enhetIdTF = new JTextField();
		enhetIdTF.setBounds(49, 45, 86, 20);
		enhetTab.add(enhetIdTF);
		enhetIdTF.setColumns(10);
		
		enhetReg = new JButton("Registrer");
		enhetReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String navn = navnTF.getText();
				String enhetId = enhetIdTF.getText();
				
				Enhet enhet1 = new Enhet(navn, enhetId);
				clearText();
				leggTilEnhetCB();
				ArrayList<Object> liste = new ArrayList<>();
				for (Object o : Enhet.enheter){
					liste.add(o);
				}
				skrivTilEnhetDB(enhet1, "enhet");
				
			}

		});
		enhetReg.setBounds(46, 96, 89, 23);
		enhetTab.add(enhetReg);
		
		enhetListe = new JList();
		enhetListe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Enhet e1 = (Enhet) enhetListe.getSelectedValue();
				navnTF.setText(e1.getNavn());
				enhetIdTF.setText(e1.getId());
				enhetReg.setEnabled(false);
				enhetLagre.setEnabled(true);
				
			}
		});
		enhetListe.setBounds(239, 11, 223, 252);
		enhetTab.add(enhetListe);
		
		enhetLagre = new JButton("Lagre");
		enhetLagre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Enhet e2 = (Enhet) enhetListe.getSelectedValue();
				e2.setId(enhetIdTF.getText());
				e2.setNavn(navnTF.getText());
				enhetLagre.setEnabled(false);
				enhetReg.setEnabled(true);
				clearText();
				leggTilEnhetCB();
				ArrayList<Object> liste = new ArrayList<>();
				for (Object o : Enhet.enheter){
					liste.add(o);
				}
				
			}
		});
		enhetLagre.setEnabled(false);
		enhetLagre.setBounds(46, 130, 89, 23);
		enhetTab.add(enhetLagre);
		
		oppstartDB();
	}
	
	/**
	 *  Metode som legger til Kull i Combobox for regstrerng av Elever samt å legge de til JListen over Kull.
	 */

	protected void leggTilKull() {
		DefaultComboBoxModel<Kull> leggTilKullCB = new DefaultComboBoxModel<>();
		for(Kull k: Kull.kull){
			leggTilKullCB.addElement(k);
		}
		kullCB.setModel(leggTilKullCB);
		DefaultListModel<Kull> kullModell = new DefaultListModel<>();
		for (Kull k: Kull.kull){
			kullModell.addElement(k);
			kullListe.setModel(kullModell);
		}
		
	}
	/**
	 *  Metode som legger til Enheter i Combobox for regstrerng av Elever samt å legge de til JListen over Enheter.
	 */
	protected void leggTilEnhetCB() {
		DefaultComboBoxModel<Enhet> leggTilEnhetCB = new DefaultComboBoxModel<>();
		for(Enhet e: Enhet.enheter){
			leggTilEnhetCB.addElement(e);
		}
		enhetCB.setModel(leggTilEnhetCB);
		DefaultListModel<Enhet> enhetModell = new DefaultListModel<>();
		for (Enhet e: Enhet.enheter){
			enhetModell.addElement(e);
			enhetListe.setModel(enhetModell);
			
		}
	}
	/**
	 * Metode som legger til alle Personer i sine respektive lister.
	 */
	 protected void leggTil() {
	 DefaultListModel<Person> elevModell = new DefaultListModel<>();
	 DefaultListModel<Person> fagModell = new DefaultListModel<>();
	 DefaultListModel<Person> admModell = new DefaultListModel<>();
	 DefaultComboBoxModel<Fagansatt> leggTilFagCB = new DefaultComboBoxModel<>();
	 for (Person p: Person.personer){
		 if(p instanceof Elev){
			 elevModell.addElement(p);
			 elevListe.setModel(elevModell);
		 
		 }
		 else if (p instanceof Fagansatt){
			 fagModell.addElement(p);
			 fagListe.setModel(fagModell);
			 leggTilFagCB.addElement((Fagansatt) p);
			 ansvarligCB.setModel(leggTilFagCB);
			 
		 }
		 else if(p instanceof Admansatt){
			 admModell.addElement(p);
			 admListe.setModel(admModell);
		 }
	 }
	}
	 /**
	  * Metode som fjerner text fra alle textbokser.
	  */
	protected void clearText() {
		startaarTF.setText("");
		fNavnTF.setText("");
		eNavnTF.setText("");
		idTF.setText("");
		navnTF.setText("");
		enhetIdTF.setText("");
		fagfNavnTF.setText("");
		fageNavnTF.setText("");
		fagidTF.setText("");
		admfNavnTF.setText("");
		admeNavnTF.setText("");
		admidTF.setText("");
	}
	/**
	 * Metode som forandrer linjer i databasen etter å ha redigert de i gui.
	 * 
	 * @param obj - Hvilket object som skal forandres
	 * @param tabell - Hvilket tabellnavn som skal skrives till
	 */
	protected void oppdatereDB(Object obj, String tabell){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oving8","root","");
			Statement stat = con.createStatement();
			if (obj instanceof Elev){
				Elev elev =  (Elev) obj;
				stat.executeUpdate("update " + tabell + " set fornavn = '" + elev.getfNavn() + "', etternavn = '" + elev.geteNavn() + "', Kull_startaar = '"+ elev.getKull().getStartaar() + "' where Person_ID = " + elev.getId());
			}
			else if (obj instanceof Admansatt){
				Admansatt adm =  (Admansatt) obj;
				stat.executeUpdate("update " + tabell + " set fornavn = '" + adm.getfNavn() + "', etternavn = '" + adm.geteNavn() + "' where Person_ID = " + adm.getId());
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * Metode som skriver Elever til databasen oving8
	 * 
	 * @param obj - Definerer hvilket objekt som skal skrives til databasen.
	 * @param tabell - String som definerer hvilket tabellnavn det skal skrives til.
	 */
	protected void skrivTilElevDB(Object obj, String tabell){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oving8", "root","");
			 
			Statement stat = con.createStatement();
			Elev elev = (Elev) obj;
			stat.executeUpdate("INSERT INTO " + tabell + " VALUES ('" + elev.getId() + "','" + elev.getfNavn() + "','" + elev.geteNavn() + "','" + elev.getKull().getStartaar() + "',NULL)");
			
			
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Metode som skriver Kull til databasen oving8
	 * 
	 * @param obj - Definerer hvilket objekt som skal skrives til databasen.
	 * @param tabell - String som definerer hvilket tabellnavn det skal skrives til.
	 */
	protected void skrivTilKullDB(Object obj, String tabell){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oving8", "root","");
			 
			Statement stat = con.createStatement();
			Kull kull = (Kull) obj;
			stat.executeUpdate("INSERT INTO " + tabell + " VALUES ('" + kull.getStartaar() + "','" + kull.getAnsvarlig().getId() + "')");
			
			
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Metode som skriver Ansatte av typen Fagansatt eller Admansatt til databasen oving8
	 * 
	 * @param obj - Definerer hvilket objekt som skal skrives til databasen.
	 * @param tabell - String som definerer hvilket tabellnavn det skal skrives til.
	 */
	protected void skrivTilAnsattDB(Object obj, String tabell){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oving8", "root","");
			 
			Statement stat = con.createStatement();
			
		if(obj instanceof Fagansatt){
			Ansatt ansatt = (Fagansatt) obj;
			stat.executeUpdate("INSERT INTO " + tabell + " VALUES ('" + ansatt.getId() + "','" + ansatt.getfNavn() + "','" + ansatt.geteNavn() + "')");
			
		}
		
		else if ( obj instanceof Admansatt){
			Ansatt ansatt = (Admansatt) obj;
			stat.executeUpdate("INSERT INTO " + tabell + " VALUES ('" + ansatt.getId() + "','" + ansatt.getfNavn() + "','" + ansatt.geteNavn() + "')");
			
			
		}
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Metode som skriver Enheter til databasen oving8
	 * 
	 * @param obj - Definerer hvilket objekt som skal skrives til databasen.
	 * @param tabell - String som definerer hvilket tabellnavn det skal skrives til.
	 */
	protected void skrivTilEnhetDB(Object obj, String tabell){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oving8", "root","");
			 
			Statement stat = con.createStatement();
			Enhet enhet = (Enhet) obj;
			stat.executeUpdate("INSERT INTO " + tabell + " VALUES ('" + enhet.getId() + "','" + enhet.getNavn() + "')");
			
		
		

		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Metode som henter alle radene i hele oving8 og lager objekter av disse.
	 * 
	 */
	protected void oppstartDB(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oving8","root","");
			Statement stat = con.createStatement();
			ResultSet resFag = stat.executeQuery("Select * from Fagansatt");
			
			while (resFag.next()){
				new Fagansatt(resFag.getString(2),resFag.getString(3),resFag.getString(1));
				
			}
			ResultSet resAdm = stat.executeQuery("select * from Admansatt");
			
			while (resAdm.next()){
				new Admansatt(resAdm.getString(2),resAdm.getString(3),resAdm.getString(1));
			}
			ResultSet resEnhet = stat.executeQuery("select * from enhet");
			while (resEnhet.next()){
				new Enhet(resEnhet.getString(2),resEnhet.getString(1));
			}
			
			ResultSet resKull = stat.executeQuery("select * from kull");
			while(resKull.next()){
				
				for(Person p: Person.personer){
				if (p.getId().equals( resKull.getString(2)))	{
					new Kull(resKull.getString(1),(Fagansatt) p);
				}
				}
			}
			
			ResultSet resElev = stat.executeQuery("select * from elev");
			while (resElev.next()){
				for (Kull k: Kull.kull){
					if (k.getStartaar().equals(resElev.getString(4))){
						new Elev(resElev.getString(2), resElev.getString(3),resElev.getString(1),k);
					}
				}
			}
			leggTil();
			leggTilKull();
			leggTilEnhetCB();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
