package pe.utp.matricula.model;

import java.time.LocalDate;
import java.util.List;

public class Libro {
    private String isbn;
    private String img;
    private String titulo;
    private List<String> autores;
    private String editorial;
    private LocalDate fecPublicacion;
    private String lenguaje;
    private List<String> categoria;
    private String descripcion;
    private double precio;
    private String tipoMoneda;
    private String linkLectura;

    public Libro() {
    }

    public Libro(DatosLibro data) {
        if ( data != null && data.infoVolumen() != null ) {
            DatosLibro.InfoVolumen ivol = data.infoVolumen();
            this.titulo = ivol.titulo();
            this.autores = ivol.autores();
            this.editorial = ivol.editorial();
            this.lenguaje = ivol.lenguaje();
            this.categoria = ivol.categoria();
            this.descripcion = ivol.descripcion();

            if (ivol.imagenes() != null && ivol.imagenes().img() != null) {
                this.img = ivol.imagenes().img().replace("http:", "https:");
            }

            if (ivol.fecPublicacion() != null) {
                try {
                    String fechaLimpia = (ivol.fecPublicacion() + "-01-01").substring(0, 10);
                    this.fecPublicacion = LocalDate.parse(fechaLimpia);
                } catch (Exception e) {
                    this.fecPublicacion = null;
                }
            }

            if (ivol.identificadores() != null) {
                for (DatosLibro.Identificador id : ivol.identificadores()) {
                    if ("ISBN_13".equals(id.tipo())) {
                        this.isbn = id.identificador();
                        break;
                    }
                }
            }

            if (data != null && data.infoVenta() != null && data.infoVenta().precio() != null) {
                this.precio = data.infoVenta().precio().monto() != null ? data.infoVenta().precio().monto() : 0.0;
                this.tipoMoneda = data.infoVenta().precio().tipoMoneda();
            } else {
                this.precio = 0.0;
            }

            if (data != null && data.infoAcceso() != null) {
                this.linkLectura = data.infoAcceso().linkLectura();
            }
        }
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<String> getAutores() {
        return autores;
    }

    public void setAutores(List<String> autores) {
        this.autores = autores;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public LocalDate getFecPublicacion() {
        return fecPublicacion;
    }

    public void setFecPublicacion(LocalDate fecPublicacion) {
        this.fecPublicacion = fecPublicacion;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public List<String> getCategoria() {
        return categoria;
    }

    public void setCategoria(List<String> categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTipoMoneda() {
        return tipoMoneda;
    }

    public void setTipoMoneda(String tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    public String getLinkLectura() {
        return linkLectura;
    }

    public void setLinkLectura(String linkLectura) {
        this.linkLectura = linkLectura;
    }
}
