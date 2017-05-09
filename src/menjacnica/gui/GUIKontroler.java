package menjacnica.gui;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class GUIKontroler {
	private static MenjacnicaGUI menjacnica;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					menjacnica = new MenjacnicaGUI();
					menjacnica.setVisible(true);
					menjacnica.addWindowListener(new WindowAdapter() {
						
						@Override
						public void windowClosing(WindowEvent e){
							ugasi();
						}
					});
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		});
	}
	
	public static void ugasi() {
		int a = JOptionPane.showConfirmDialog(menjacnica, "Da li ste sigurni da zelite da izadjete?", "Paznja!",
				JOptionPane.YES_NO_CANCEL_OPTION);
		if (a == JOptionPane.YES_OPTION)
			System.exit(0);

	}
	
	public static String izaberiFajl() {
		String fajl = "";
		try {
			JFileChooser fc = new JFileChooser();
			int odluka = fc.showOpenDialog(menjacnica);
			if (odluka == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				fajl = file.getAbsolutePath();
			} else {
				return null;
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(menjacnica, ex.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
		}

		return fajl;

	}
	
	public static void autor() {
		JOptionPane.showMessageDialog(menjacnica, "Autor: Danilovic Milos",
				"Informacije o autoru", JOptionPane.INFORMATION_MESSAGE);

	}
	
	public static String sacuvajFajl() {
		String s = "";
		try {
			JFileChooser jf = new JFileChooser();
			int fajl = jf.showSaveDialog(menjacnica);
			if (fajl == JFileChooser.APPROVE_OPTION) {
				File file = jf.getSelectedFile();
				s = file.getAbsolutePath();
			} else {
				return null;
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(menjacnica, ex.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
		}
		return s;
	}
	
	public static void dodajKursK(String str) {
		menjacnica.dodajKursM(str);

	}
}
