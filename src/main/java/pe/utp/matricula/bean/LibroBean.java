package pe.utp.matricula.bean;

import jakarta.annotation.PostConstruct;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ViewScoped;
import jakarta.faces.context.FacesContext;
import pe.utp.matricula.model.Libro;
import pe.utp.matricula.util.GestorGoogleBook;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "LibroBean")
@ViewScoped
public class LibroBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String terminoBusqueda;
    private String tipoBusqueda;
    private List<Libro> librosEncontrados;

    private final GestorGoogleBook api;

    public LibroBean() {
        this.api = new GestorGoogleBook();
        this.librosEncontrados = new ArrayList<>();
        this.tipoBusqueda = "titulo";
    }


    @PostConstruct
    public void inicializar() {
        try {
            this.librosEncontrados = api.obtenerLibrosPorDefecto();

            if (this.librosEncontrados == null) {
                this.librosEncontrados = new ArrayList<>();
            }

        } catch (Exception e) {
            e.printStackTrace();
            this.librosEncontrados = new ArrayList<>();
        }
    }

    public void ejecutarBusqueda() {
        if (terminoBusqueda == null || terminoBusqueda.trim().isBlank()) {
            inicializar();
            return;
        }

        switch (tipoBusqueda) {
            case "titulo":
                this.librosEncontrados = api.obtenerLibrosPorTitulo(terminoBusqueda);
                break;
            case "autor":
                this.librosEncontrados = api.obtenerLibrosPorAutor(terminoBusqueda);
                break;
            case "categoria":
                this.librosEncontrados = api.obtenerLibrosPorCategoria(terminoBusqueda);
                break;
            default:
                this.librosEncontrados = api.obtenerLibrosPorTitulo(terminoBusqueda);
        }
    }

    public String verDetalle(Libro libroSeleccionado) {
        FacesContext.getCurrentInstance()
                .getExternalContext()
                .getFlash()
                .put("libroSeleccionado", libroSeleccionado);

        return "DetalleLibro?faces-redirect=true";
    }

    public List<Libro> getLibrosEncontrados() {
        return librosEncontrados;
    }

    public void setLibrosEncontrados(List<Libro> librosEncontrados) {
        this.librosEncontrados = librosEncontrados;
    }

    public String getTerminoBusqueda() {
        return terminoBusqueda;
    }

    public void setTerminoBusqueda(String terminoBusqueda) {
        this.terminoBusqueda = terminoBusqueda;
    }

    public String getTipoBusqueda() {
        return tipoBusqueda;
    }

    public void setTipoBusqueda(String tipoBusqueda) {
        this.tipoBusqueda = tipoBusqueda;
    }
}
