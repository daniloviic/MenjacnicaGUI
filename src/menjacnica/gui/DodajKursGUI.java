package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DodajKursGUI extends JFrame {

	private JPanel contentPane;
	private JButton btnDodaj;
	private JButton btnOdustani;
	private JTextField txtSifra;
	private JTextField txtNaziv;
	private JTextField txtProdajniKurs;
	private JTextField txtKupovniKurs;
	private JTextField txtSrednjiKurs;
	private JTextField txtSkraceniNaziv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodajKursGUI frame = new DodajKursGUI();
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
	public DodajKursGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Dodaj kurs");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnDodaj());
		contentPane.add(getBtnOdustani());
		
		JLabel lblSifra = new JLabel("Sifra");
		lblSifra.setBounds(27, 11, 46, 14);
		contentPane.add(lblSifra);
		
		txtSifra = new JTextField();
		txtSifra.setBounds(25, 30, 86, 20);
		contentPane.add(txtSifra);
		txtSifra.setColumns(10);
		
		JLabel lblNaziv = new JLabel("Naziv");
		lblNaziv.setBounds(274, 11, 46, 14);
		contentPane.add(lblNaziv);
		
		txtNaziv = new JTextField();
		txtNaziv.setBounds(278, 30, 86, 20);
		contentPane.add(txtNaziv);
		txtNaziv.setColumns(10);
		
		JLabel lblProdajniKurs = new JLabel("Prodajni kurs");
		lblProdajniKurs.setBounds(27, 94, 84, 14);
		contentPane.add(lblProdajniKurs);
		
		txtProdajniKurs = new JTextField();
		txtProdajniKurs.setBounds(25, 119, 86, 20);
		contentPane.add(txtProdajniKurs);
		txtProdajniKurs.setColumns(10);
		
		JLabel lblKuponviKurs = new JLabel("Kuponvi kurs");
		lblKuponviKurs.setBounds(278, 94, 89, 14);
		contentPane.add(lblKuponviKurs);
		
		txtKupovniKurs = new JTextField();
		txtKupovniKurs.setBounds(278, 119, 86, 20);
		contentPane.add(txtKupovniKurs);
		txtKupovniKurs.setColumns(10);
		
		JLabel lblSrednjiKurs = new JLabel("Srednji kurs");
		lblSrednjiKurs.setBounds(27, 162, 84, 14);
		contentPane.add(lblSrednjiKurs);
		
		txtSrednjiKurs = new JTextField();
		txtSrednjiKurs.setBounds(27, 187, 86, 20);
		contentPane.add(txtSrednjiKurs);
		txtSrednjiKurs.setColumns(10);
		
		JLabel lblSkraceniNaziv = new JLabel("Skraceni naziv");
		lblSkraceniNaziv.setBounds(278, 162, 89, 14);
		contentPane.add(lblSkraceniNaziv);
		
		txtSkraceniNaziv = new JTextField();
		txtSkraceniNaziv.setBounds(278, 187, 86, 20);
		contentPane.add(txtSkraceniNaziv);
		txtSkraceniNaziv.setColumns(10);
	}

	public JButton getBtnDodaj() {
		if(btnDodaj==null){
			btnDodaj = new JButton("Dodaj");
			btnDodaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String kurs = "Kurs <Sifra: ";
					kurs += txtSifra.getText();
					kurs += " Naziv: ";
					kurs += txtNaziv.getText();
					kurs += " Prodajni: ";
					kurs += txtProdajniKurs.getText();
					kurs += " Srednji: ";
					kurs += txtSrednjiKurs.getText();
					kurs += " Kupovni: ";
					kurs += txtKupovniKurs.getText();
					kurs += " Skraceni naziv: ";
					kurs += txtSkraceniNaziv.getText();
					kurs += ">";
					GUIKontroler.dodajKursK(kurs);
					dispose();
					
				}
			});
			btnDodaj.setBounds(27, 223, 113, 23);
		}
		return btnDodaj;
	}
	public JButton getBtnOdustani() {
		if(btnOdustani==null){
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnOdustani.setBounds(278, 223, 103, 23);
		}
		return btnOdustani;
	}
}
