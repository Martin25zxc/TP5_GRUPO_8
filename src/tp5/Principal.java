package tp5;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Principal extends JFrame {

	private static final long serialVersionUID = 6650411408176771737L;
	private final Font defaultFont; 
	private JPanel contentPane;
	private static DefaultListModel<Pelicula> listModel;

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					//INSTANCIO EL LISTMODEL
					listModel = new DefaultListModel<Pelicula>();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	
	public Principal() {

		setTitle("Programa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		defaultFont = new Font("Segoe UI", Font.PLAIN, 18);
				
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("Películas");
		menu.setFont(defaultFont);
		menuBar.add(menu);
		
		JMenuItem menuItemAgregar = new JMenuItem("Agregar");
		menuItemAgregar.setFont(defaultFont);
		menuItemAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbrirPanel(new PanelIngresoPeliculas());
			}
		});
		menu.add(menuItemAgregar);
		
		JMenuItem menuItemListado = new JMenuItem("Listar");
		menuItemListado.setFont(defaultFont);
		menuItemListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbrirPanel(new PanelListadoPeliculas());
			}
		});
		menu.add(menuItemListado);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	private void AbrirPanel(PanelPeliculasBase panel ) {
		contentPane.removeAll();
		panel.setDefaultListModel(listModel);
		contentPane.add(panel);
		contentPane.repaint();
		contentPane.revalidate();
	}

}
