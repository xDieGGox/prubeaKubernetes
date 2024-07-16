package universidades.universidades.business;

import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import universidades.universidades.dao.UniversidadDAO;

@Singleton
@Startup
public class GestionDatos {
	
	@Inject
	private UniversidadDAO daoUniversidad;

}
