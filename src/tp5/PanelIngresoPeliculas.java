package tp5;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javax.swing.JComboBox;

public class PanelIngresoPeliculas extends PanelPeliculasBase {

	private static final long serialVersionUID = 3912970067230039293L;
	private JTextField txtNombre;
	private JButton btnAceptar;
	private JLabel lblGenero;
	private JLabel lblId_proximoID;
	private JComboBox<Categoria> cbGenero;
	private ArrayList<Categoria> categoriasASeleccionar;
	private final Categoria opcionSeleccionar = new Categoria("Seleccione un genero");
	
	public PanelIngresoPeliculas() 
	{
		super();
		categoriasASeleccionar = new ArrayList<Categoria>();
		categoriasASeleccionar.add(new Categoria("Terror"));
		categoriasASeleccionar.add(new Categoria("Accion"));
		categoriasASeleccionar.add(new Categoria("Suspenso"));
		categoriasASeleccionar.add(new Categoria("Romantica"));
		dibujarControles();
	}
	public void dibujarControles() {
		
		Font fuenteComun = new Font("Segoe UI", Font.PLAIN, 18);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 0, 0, 0, 30, 0};
		gridBagLayout.rowHeights = new int[]{30, 0, 0, 0, 0, 0, 30, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblId = new JLabel("Id");
		lblId.setFont(fuenteComun);
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.WEST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 1;
		gbc_lblId.gridy = 2;
		add(lblId, gbc_lblId);
		
		lblId_proximoID = new JLabel("0");
		lblId_proximoID.setText(Integer.toString(Pelicula.devuelveProximoId()));
		lblId_proximoID.setFont(fuenteComun);
		GridBagConstraints gbc_lblId_proximoID = new GridBagConstraints();
		gbc_lblId_proximoID.anchor = GridBagConstraints.WEST;
		gbc_lblId_proximoID.insets = new Insets(0, 0, 5, 5);
		gbc_lblId_proximoID.gridx = 3;
		gbc_lblId_proximoID.gridy = 2;
		add(lblId_proximoID, gbc_lblId_proximoID);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(fuenteComun);
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.WEST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 3;
		add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(fuenteComun);
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.anchor = GridBagConstraints.WEST;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 3;
		gbc_txtNombre.gridy = 3;
		add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		lblGenero = new JLabel("Genero");
		lblGenero.setVerticalAlignment(SwingConstants.BOTTOM);
		lblGenero.setFont(fuenteComun);
		GridBagConstraints gbc_lblGenero = new GridBagConstraints();
		gbc_lblGenero.anchor = GridBagConstraints.WEST;
		gbc_lblGenero.insets = new Insets(0, 0, 5, 5);
		gbc_lblGenero.gridx = 1;
		gbc_lblGenero.gridy = 4;
		add(lblGenero, gbc_lblGenero);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Agregar(); 
			}
		});
		
		cbGenero = new JComboBox<Categoria>();
		cbGenero.addItem(opcionSeleccionar);
		categoriasASeleccionar.forEach(genero -> cbGenero.addItem(genero));
		
		GridBagConstraints gbc_cbGenero = new GridBagConstraints();
		gbc_cbGenero.anchor = GridBagConstraints.WEST;
		gbc_cbGenero.insets = new Insets(0, 0, 5, 5);
		gbc_cbGenero.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbGenero.gridx = 3;
		gbc_cbGenero.gridy = 4;
		add(cbGenero, gbc_cbGenero);
		
		btnAceptar.setFont(fuenteComun);
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAceptar.gridx = 1;
		gbc_btnAceptar.gridy = 5;
		add(btnAceptar, gbc_btnAceptar);
	}
	
	private boolean ExisteEnModel(String nombre, Categoria categoria){
		boolean exist = false;
		int i = 0;
		while(!exist && i < listModel.size()){
			
			Pelicula p = listModel.elementAt(i++);
			exist =(p.getNombre().equals(nombre) && p.getCategoria().getNombre().equals(categoria.getNombre()));
		}
		
		return exist;
	}
	
	private void Agregar() {
		String mensaje = "";
		String nombreIngresado = txtNombre.getText();
		Categoria categoriaSeleccionada = ((Categoria)this.cbGenero.getSelectedItem());
		
		if(nombreIngresado.isEmpty() )
		{
			mensaje += "Se debe completar el campo Nombre. ";
		}

		if(categoriaSeleccionada == opcionSeleccionar )
		{
			mensaje += "Se debe seleccionar una opcion valida";
		}
		
		if(mensaje.length() == 0 && ExisteEnModel(nombreIngresado, categoriaSeleccionada))
		{
			mensaje += "Ya se encuentra una pelicula cargada con ese nombre y categoria.";
		}
		
		if(mensaje.length() == 0){
			Pelicula pelicula = new Pelicula(nombreIngresado, categoriaSeleccionada);
			listModel.addElement(pelicula);
			
			cbGenero.setSelectedItem(opcionSeleccionar);
			txtNombre.setText("");
			lblId_proximoID.setText(Integer.toString(Pelicula.devuelveProximoId()));
			mensaje = "La pelicula se agrego correctamente.";
			
			JLabel label = new JLabel(mensaje);
			JOptionPane.showMessageDialog(null,label);
		}
		else{
			JLabel label = new JLabel(mensaje);
			JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.ERROR_MESSAGE);
		}
	}
}

