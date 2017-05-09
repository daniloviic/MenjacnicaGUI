package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class ObrisiKursGUI extends JFrame {

	private JPanel contentPane;
	private JButton btnObrisi;
	private JButton btnOdustani;
	private JTextField txtSifra;
	private JTextField txtNaziv;
	private JTextField txtProdajniKurs;
	private JTextField txtKupovniKurs;
	private JTextField txtSrednjiKurs;
	private JTextField txtSkraceniNaziv;
	private JCheckBox chckbxZaistaObrisiKurs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ObrisiKursGUI frame = new ObrisiKursGUI();
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
	public ObrisiKursGUI() {
		setResizable(false);
		setTitle("Obrisi kurs");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblSifra = new JLabel("Sifra");
		lblSifra.setBounds(27, 11, 46, 14);
		contentPane.add(lblSifra);
		contentPane.add(getChckbxZaistaObrisi());

		txtSifra = new JTextField();
		txtSifra.setEditable(false);
		txtSifra.setBounds(25, 30, 86, 20);
		contentPane.add(txtSifra);
		txtSifra.setColumns(10);

		JLabel lblNaziv = new JLabel("Naziv");
		lblNaziv.setBounds(274, 11, 46, 14);
		contentPane.add(lblNaziv);

		txtNaziv = new JTextField();
		txtNaziv.setEditable(false);
		txtNaziv.setBounds(278, 30, 86, 20);
		contentPane.add(txtNaziv);
		txtNaziv.setColumns(10);

		JLabel lblProdajniKurs = new JLabel("Prodajni kurs");
		lblProdajniKurs.setBounds(27, 73, 84, 14);
		contentPane.add(lblProdajniKurs);

		txtProdajniKurs = new JTextField();
		txtProdajniKurs.setEditable(false);
		txtProdajniKurs.setBounds(25, 98, 86, 20);
		contentPane.add(txtProdajniKurs);
		txtProdajniKurs.setColumns(10);

		JLabel lblKuponviKurs = new JLabel("Kuponvi kurs");
		lblKuponviKurs.setBounds(274, 73, 89, 14);
		contentPane.add(lblKuponviKurs);

		txtKupovniKurs = new JTextField();
		txtKupovniKurs.setEditable(false);
		txtKupovniKurs.setBounds(274, 98, 86, 20);
		contentPane.add(txtKupovniKurs);
		txtKupovniKurs.setColumns(10);

		JLabel lblSrednjiKurs = new JLabel("Srednji kurs");
		lblSrednjiKurs.setBounds(27, 146, 84, 14);
		contentPane.add(lblSrednjiKurs);

		txtSrednjiKurs = new JTextField();
		txtSrednjiKurs.setEditable(false);
		txtSrednjiKurs.setBounds(27, 171, 86, 20);
		contentPane.add(txtSrednjiKurs);
		txtSrednjiKurs.setColumns(10);

		JLabel lblSkraceniNaziv = new JLabel("Skraceni naziv");
		lblSkraceniNaziv.setBounds(275, 150, 89, 14);
		contentPane.add(lblSkraceniNaziv);

		txtSkraceniNaziv = new JTextField();
		txtSkraceniNaziv.setEditable(false);
		txtSkraceniNaziv.setBounds(278, 171, 86, 20);
		contentPane.add(txtSkraceniNaziv);
		txtSkraceniNaziv.setColumns(10);

		contentPane.add(getBtnOdustani());
		contentPane.add(getBtnObrisi());

	}

	public JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnOdustani.setBounds(274, 227, 103, 23);
		}
		return btnOdustani;
	}

	public JButton getBtnObrisi() {
		if (btnObrisi == null) {
			btnObrisi = new JButton("Obrisi");
			btnObrisi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String kurs = "Kurs je obrisan : < Sifra: ";
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
					kurs += " >";
					GUIKontroler.izbrisiKursK(kurs);
					dispose();
				}
			});
			btnObrisi.setEnabled(false);
			btnObrisi.setBounds(27, 227, 115, 23);
		}
		return btnObrisi;
	}

	private JCheckBox getChckbxZaistaObrisi() {
		if (chckbxZaistaObrisiKurs == null) {
			chckbxZaistaObrisiKurs = new JCheckBox("Zaista obrisi");
			chckbxZaistaObrisiKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (chckbxZaistaObrisiKurs.isSelected()) {
						btnObrisi.setEnabled(true);
						txtSifra.setEditable(true);
						txtNaziv.setEditable(true);
						txtProdajniKurs.setEditable(true);
						txtKupovniKurs.setEditable(true);
						txtSrednjiKurs.setEditable(true);
						txtSkraceniNaziv.setEditable(true);

					} else {
						btnObrisi.setEnabled(false);
						txtSifra.setEditable(false);
						txtNaziv.setEditable(false);
						txtProdajniKurs.setEditable(false);
						txtKupovniKurs.setEditable(false);
						txtSrednjiKurs.setEditable(false);
						txtSkraceniNaziv.setEditable(false);
					}
				}
			});
			chckbxZaistaObrisiKurs.setBounds(27, 197, 97, 23);

		}
		return chckbxZaistaObrisiKurs;
	}
}
