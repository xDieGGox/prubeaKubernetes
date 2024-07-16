package universidades.universidades.business;

import java.util.List;

import io.opentracing.Scope;
import io.opentracing.Span;
import io.opentracing.Tracer;
import io.opentracing.util.GlobalTracer;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import universidades.universidades.dao.UniversidadDAO;
import universidades.universidades.model.Universidad;

@Stateless
public class GestionUniversidades {
	
	@Inject
	private UniversidadDAO daoUniversidad;
	
	private final Tracer tracer = GlobalTracer.get();
	
	public void guardarUniversidads(Universidad universidad){
		
		Span span = tracer.buildSpan("guardarUniversidads").start();
        try (Scope scope = tracer.scopeManager().activate(span)) {
            Universidad cli = daoUniversidad.read(universidad.getCodigo_universidad());
            if (cli != null) {
                daoUniversidad.update(universidad);
            } else {
                daoUniversidad.insert(universidad);
            }
        } catch (Exception e) {
            span.log(e.getMessage());
            throw e;
        } finally {
            span.finish();
        }
		
	}
	
	public void actualizarUniversidad(Universidad universidad) throws Exception {
		Span span = tracer.buildSpan("actualizarUniversidad").start();
        try (Scope scope = tracer.scopeManager().activate(span)) {
            Universidad cli = daoUniversidad.read(universidad.getCodigo_universidad());
            if (cli != null) {
                daoUniversidad.update(universidad);
            } else {
                throw new Exception("Universidad no existe");
            }
        } catch (Exception e) {
            span.log(e.getMessage());
            throw e;
        } finally {
            span.finish();
        }
	}
	
	
	public void borrarUniversidad(int codigo) {
		
		Span span = tracer.buildSpan("borrarUniversidad").start();
        try (Scope scope = tracer.scopeManager().activate(span)) {
            daoUniversidad.remove(codigo);
        } catch (Exception e) {
            span.log(e.getMessage());
            throw e;
        } finally {
            span.finish();
        }
	}
	
	public List<Universidad> getUniversidads(){
		Span span = tracer.buildSpan("getUniversidads").start();
        try (Scope scope = tracer.scopeManager().activate(span)) {
            return daoUniversidad.getAll();
        } catch (Exception e) {
            span.log(e.getMessage());
            throw e;
        } finally {
            span.finish();
        }
	}

}
