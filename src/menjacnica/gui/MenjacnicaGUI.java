package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenjacnicaGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;

	private JMenu mnFile;
	private JMenu mnHelp;
	private JMenuItem mntmOpen;
	private JMenuItem mntmSave;
	private JMenuItem mntmExit;
	private JMenuItem mntmAbout;
	private JPanel eastPanel;
	private JButton btnDodajKurs;
	private JButton btnIzbrisiKurs;
	private JButton btnIzvrsiIzmenu;
	private JPanel southPanel;
	private JScrollPane scrollPane;
	private JTextArea textArea_1;
	private JPanel centerPanel;
	private JScrollPane scrollPane_1;
	private JMenuItem mntmDodajKurs;
	private JMenuItem mntmIzbrisiKurs;
	private JMenuItem mntmIzvrsiIzmenu;

	private JPopupMenu popupMenu;
	private JPanel eastPanel_1;
	private JMenuBar menuBar_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenjacnicaGUI frame = new MenjacnicaGUI();
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
	public MenjacnicaGUI() {

		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(MenjacnicaGUI.class.getResource("/1494372037_folder-project.png")));

		setTitle("Menjacnica");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 650, 434);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getEastPanel_1(), BorderLayout.EAST);
		contentPane.add(getSouthPanel(), BorderLayout.SOUTH);
		contentPane.add(getCenterPanel(), BorderLayout.CENTER);
		

	}

	private JMenuBar getMenuBar_1() {
		if (menuBar_1 == null) {
			menuBar_1 = new JMenuBar();
			menuBar_1.add(getMnFile());
			menuBar_1.add(getMnHelp());
		}
		return menuBar_1;
	}

	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.add(getMntmAbout());
		}
		return mnHelp;
	}

	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
			mntmAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.autor();
				}
			});
		}
		return mntmAbout;
	}

	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.add(getMntmOpen());
			mnFile.add(getMntmSave());
			mnFile.add(getMntmExit());
		}
		return mnFile;
	}

	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.ugasi();
				}
			});
			mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_MASK));
		}
		return mntmExit;
	}

	private JMenuItem getMntmSave() {
		if (mntmSave == null) {
			mntmSave = new JMenuItem("Save");
			mntmSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String fajl = GUIKontroler.sacuvajFajl();
					if (fajl != null) {
						String s = "Sacuvan fajl: " + fajl;
						textArea_1.append(s + "\n");
					}
				}
			});
			mntmSave.setIcon(
					new ImageIcon(MenjacnicaGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
			mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		}

		return mntmSave;
	}
	
	

	private JMenuItem getMntmOpen() {
		if (mntmOpen == null) {
			mntmOpen = new JMenuItem("Open");
			mntmOpen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String fajl = GUIKontroler.izaberiFajl();
					if (fajl != null) {
						String s = "Fajl koji je ucitan : " + fajl;
						textArea_1.append(s);
					}
				}
			});
			mntmOpen.setIcon(
					new ImageIcon(MenjacnicaGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/file.gif")));
			mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		}

		return mntmOpen;
	}

	private JPanel getCenterPanel() {
		if (centerPanel == null) {
			centerPanel = new JPanel();
			centerPanel.setLayout(new BorderLayout(0, 0));
			centerPanel.add(getScrollPane_1(), BorderLayout.CENTER);
		}
		return centerPanel;
	}

	private Component getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setViewportView(getTable());
		}
		return scrollPane_1;
	}

	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setMaximumSize(new Dimension(20000, 20000));
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			table.setPreferredScrollableViewportSize(new Dimension(450, 500));
			table.setModel(new DefaultTableModel(
					new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
							{ null, null, null, null, null, null }, { null, null, null, null, null, null },
							{ null, null, null, null, null, null }, { null, null, null, null, null, null },
							{ null, null, null, null, null, null }, { null, null, null, null, null, null },
							{ null, null, null, null, null, null }, { null, null, null, null, null, null }, },
					new String[] { "Sifra", "Skraceni naziv", "Prodajni", "Srednji", "Kupovni", "Naziv" }));
			addPopup(table, getPopupMenu());
			table.getColumnModel().getColumn(1).setPreferredWidth(90);
		}
		return table;
	}

	private JPopupMenu getPopupMenu() {
		if (popupMenu == null) {
			popupMenu = new JPopupMenu();
			popupMenu.add(getMntmDodajKurs());
			popupMenu.add(getMntmIzbrisiKurs());
			popupMenu.add(getMntmIzvrsiIzmenu());
		}
		return popupMenu;
	}

	private JMenuItem getMntmIzvrsiIzmenu() {
		if (mntmIzvrsiIzmenu == null) {
			mntmIzvrsiIzmenu = new JMenuItem("Izvrsi zamenu");
			mntmIzvrsiIzmenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					IzvrsiZamenuGUI izvrsiZamenu = new IzvrsiZamenuGUI();
					izvrsiZamenu.setVisible(true);
				}
			});
			
		}
		return mntmIzvrsiIzmenu;
	}

	private JMenuItem getMntmIzbrisiKurs() {
		if (mntmIzbrisiKurs == null) {
			mntmIzbrisiKurs = new JMenuItem("Obrisi kurs");
			mntmIzbrisiKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ObrisiKursGUI obrisiKurs = new ObrisiKursGUI();
					obrisiKurs.setVisible(true);
				}
			});
			
		}
		return mntmIzbrisiKurs;
	}

	private JMenuItem getMntmDodajKurs() {
		if (mntmDodajKurs == null) {
			mntmDodajKurs = new JMenuItem("Dodaj kurs");
			mntmDodajKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DodajKursGUI dodajKurs = new DodajKursGUI();
					dodajKurs.setVisible(true);
				}
			});
			
		}
		return mntmDodajKurs;
	}

	private JPanel getSouthPanel() {
		if (southPanel == null) {
			southPanel = new JPanel();
			southPanel.setBorder(new TitledBorder(null, "Status", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			southPanel.setPreferredSize(new Dimension(400, 50));
			southPanel.setLayout(new BorderLayout(0, 0));
			southPanel.add(getScrollPane(), BorderLayout.CENTER);
		}
		return southPanel;
	}

	private Component getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}

	private Component getTextArea() {
		if (textArea_1 == null) {
			textArea_1 = new JTextArea();
			textArea_1.setWrapStyleWord(true);
		}
		return textArea_1;
	}

	public JPanel getEastPanel_1() {
		if (eastPanel_1 == null) {
			eastPanel_1 = new JPanel();
			eastPanel_1.setPreferredSize(new Dimension(130, 100));
			contentPane.add(eastPanel_1, BorderLayout.EAST);
			eastPanel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			eastPanel_1.add(getBtnDodajKurs());
			eastPanel_1.add(getBtnIzbrisiKurs());
			eastPanel_1.add(getBtnIzvrsiZamenu());
		}
		return eastPanel_1;
	}

	private Component getBtnIzvrsiZamenu() {
		if (btnIzvrsiIzmenu == null) {
			btnIzvrsiIzmenu = new JButton("Izvrsi izmenu");
			btnIzvrsiIzmenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					IzvrsiZamenuGUI izvrsiZamenu = new IzvrsiZamenuGUI();
					izvrsiZamenu.setVisible(true);
				}
			});
			btnIzvrsiIzmenu.setPreferredSize(new Dimension(110, 25));

		}
		return btnIzvrsiIzmenu;
	}

	private Component getBtnIzbrisiKurs() {
		if (btnIzbrisiKurs == null) {
			btnIzbrisiKurs = new JButton("Izbrisi kurs");
			btnIzbrisiKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ObrisiKursGUI obrisiKurs = new ObrisiKursGUI();
					obrisiKurs.setVisible(true);
				}
			});
			btnIzbrisiKurs.setPreferredSize(new Dimension(110, 25));

		}
		return btnIzbrisiKurs;
	}

	private Component getBtnDodajKurs() {
		if (btnDodajKurs == null) {
			btnDodajKurs = new JButton("Dodaj kurs");
			btnDodajKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DodajKursGUI dodajKurs = new DodajKursGUI();
					dodajKurs.setVisible(true);
				}
			});
			btnDodajKurs.setPreferredSize(new Dimension(110, 25));
		}

		return btnDodajKurs;
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	public void dodajKursM(String kurs) {
		textArea_1.append(kurs + "\n");
	}
	
	public void izbrisiKursM(String kurs){
		textArea_1.append(kurs + "\n");
	}
	public void zameniKursM(String kurs){
		textArea_1.append(kurs + "\n");
	}
}
