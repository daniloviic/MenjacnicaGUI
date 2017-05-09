package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;

public class IzvrsiZamenuGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtKupovniKurs;
	private JTextField txtProdajniKurs;
	private JTextField txtIznos;
	private JButton btnOdustani;
	
	
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnIzvrsiIzmenu;
	private JRadioButton rdbtnKupovina;
	private JRadioButton rdbtnProdaja;
	private JComboBox comboBox;
	private JSlider slider;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IzvrsiZamenuGUI frame = new IzvrsiZamenuGUI();
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
	public IzvrsiZamenuGUI() {
		setResizable(false);
		setTitle("Izvrsi zamenu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKupovniKurs = new JLabel("Kupovni kurs");
		lblKupovniKurs.setBounds(10, 11, 78, 14);
		contentPane.add(lblKupovniKurs);
		
		txtKupovniKurs = new JTextField();
		txtKupovniKurs.setEditable(false);
		txtKupovniKurs.setBounds(10, 36, 86, 20);
		contentPane.add(txtKupovniKurs);
		txtKupovniKurs.setColumns(10);
		
		JLabel lblProdajniKurs = new JLabel("Prodajni kurs");
		lblProdajniKurs.setBounds(355, 11, 77, 14);
		contentPane.add(lblProdajniKurs);
		
		txtProdajniKurs = new JTextField();
		txtProdajniKurs.setEditable(false);
		txtProdajniKurs.setBounds(346, 36, 86, 20);
		contentPane.add(txtProdajniKurs);
		txtProdajniKurs.setColumns(10);
		
		JLabel lblValuta = new JLabel("Valuta");
		lblValuta.setBounds(191, 11, 46, 14);
		contentPane.add(lblValuta);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"EUR", "USD", "CHF"}));
		comboBox.setBounds(180, 36, 78, 20);
		contentPane.add(comboBox);
		
		JLabel lblIznos = new JLabel("Iznos");
		lblIznos.setBounds(10, 98, 46, 14);
		contentPane.add(lblIznos);
		
		txtIznos = new JTextField();
		txtIznos.setBounds(10, 123, 86, 20);
		contentPane.add(txtIznos);
		txtIznos.setColumns(10);
		
		JLabel lblVrstaTransakcije = new JLabel("Vrsta transakcije");
		lblVrstaTransakcije.setBounds(283, 84, 99, 14);
		contentPane.add(lblVrstaTransakcije);
		
		rdbtnKupovina = new JRadioButton("Kupovina");
		buttonGroup.add(rdbtnKupovina);
		rdbtnKupovina.setBounds(273, 98, 109, 23);
		contentPane.add(rdbtnKupovina);
		
		rdbtnProdaja = new JRadioButton("Prodaja");
		buttonGroup.add(rdbtnProdaja);
		rdbtnProdaja.setBounds(273, 122, 109, 23);
		contentPane.add(rdbtnProdaja);
		
		
		contentPane.add(getBtnOdustani());
		
		btnIzvrsiIzmenu = new JButton("Izvrsi izmenu");
		btnIzvrsiIzmenu.setBounds(10, 222, 109, 23);
		contentPane.add(getBtnIzvrsiIzmenu());
		
		contentPane.add(getSlider());
		
		
	}
	
	public JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnOdustani.setBounds(282, 222, 89, 23);
		}
		return btnOdustani;
	}
	public JButton getBtnIzvrsiIzmenu() {
		if (btnIzvrsiIzmenu == null) {
			btnIzvrsiIzmenu = new JButton("Izvrsi zamenu");
			btnIzvrsiIzmenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String kurs = "Izmena : ( Valuta: ";
					kurs += comboBox.getSelectedItem().toString();
					kurs += " Iznos: ";
					kurs += txtIznos.getText();
					kurs += " Vrsta transakcije: ";
					if (rdbtnKupovina.isSelected()) {
						kurs += " Kupovina ";
						kurs += " Po kursu: ";
						kurs += txtKupovniKurs.getText();
					} else {
						kurs += " Prodaja ";
						kurs += " Po kursu: ";
						kurs += txtProdajniKurs.getText();
					}

					GUIKontroler.zameniKursK(kurs);
					dispose();
				}
			});
			
			btnIzvrsiIzmenu.setBounds(39, 208, 144, 23);
		}
		return btnIzvrsiIzmenu;
	}
	private JSlider getSlider() {
		if (slider == null) {
			slider = new JSlider();
			slider.addChangeListener(new ChangeListener() {
				
				@Override
				public void stateChanged(ChangeEvent e) {
					txtIznos.setText("" + slider.getValue());
				}
			});
			
			slider.setPaintLabels(true);
			slider.setPaintTicks(true);
			slider.setMinorTickSpacing(5);
			slider.setMajorTickSpacing(10);
			slider.setSnapToTicks(true);
			slider.setBounds(29, 147, 324, 45);
		}
		return slider;
	}
}
