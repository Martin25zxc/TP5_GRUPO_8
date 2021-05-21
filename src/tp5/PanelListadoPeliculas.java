package tp5;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.TreeSet;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class PanelListadoPeliculas extends PanelPeliculasBase {
	
	private static final long serialVersionUID = -3742015603731421288L;
	private JScrollPane scrollPane;
	private JList<Pelicula> jList;
	
	public PanelListadoPeliculas() 
	{
		super();
		dibujarControles();
	}
	
	public void dibujarControles() {
		
			Font fuenteComun = new Font("Segoe UI", Font.PLAIN, 18);
				
			GridBagLayout gridBagLayout = new GridBagLayout();
			gridBagLayout.columnWidths = new int[]{0, 30, 0, 0, 0, 30, 0};
			gridBagLayout.rowHeights = new int[]{30, 0, 0, 0, 0, 71, 30, 0};
			gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
			gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			setLayout(gridBagLayout);
			
			scrollPane = new JScrollPane();
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.gridheight = 4;
			gbc_scrollPane.gridwidth = 3;
			gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.gridx = 2;
			gbc_scrollPane.gridy = 2;
			add(scrollPane, gbc_scrollPane);
			
			jList = new JList<Pelicula>();
			jList.setFont(fuenteComun);
			scrollPane.setViewportView(jList);
			
			JLabel lblListado = new JLabel("Peliculas");
			lblListado.setFont(fuenteComun);
			GridBagConstraints gbc_lblListado = new GridBagConstraints();
			gbc_lblListado.anchor = GridBagConstraints.WEST;
			gbc_lblListado.insets = new Insets(0, 0, 5, 5);
			gbc_lblListado.gridx = 1;
			gbc_lblListado.gridy = 5;
			add(lblListado, gbc_lblListado);
	}
	
	@Override
	public void setDefaultListModel(DefaultListModel<Pelicula> listModel)
	{
		TreeSet<Pelicula> peliculasOrdenadas = new TreeSet<Pelicula>();
		super.setDefaultListModel(listModel);
		
		for(int i = 0; i < listModel.size(); i++)
			peliculasOrdenadas.add(listModel.elementAt(i));
		
		DefaultListModel<Pelicula> modelOrdenado = new DefaultListModel<Pelicula>();
		
		for(Pelicula pelicula : peliculasOrdenadas)
			modelOrdenado.addElement(pelicula);
		
		jList.setModel(modelOrdenado);
	}
	
}
