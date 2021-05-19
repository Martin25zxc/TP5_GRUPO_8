package tp5;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;

public abstract class PanelPeliculasBase extends JPanel  {
	
	private static final long serialVersionUID = 4385854926267790509L;
	
	private DefaultListModel<Pelicula> listModel;
	
	public void setDefaultListModel(DefaultListModel<Pelicula> listModel)
	{
		this.listModel = listModel;
	}
}
