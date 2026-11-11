package pe.utp.matricula.util;

import pe.utp.matricula.model.Libro;
import pe.utp.matricula.model.RespuestaGoogleBook;
import pe.utp.matricula.service.ConsumoApi;
import pe.utp.matricula.service.ConvertirDatos;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class GestorGoogleBookEjemplo {
    private ConsumoApi api = new ConsumoApi();
    private ConvertirDatos convertirDatos = new ConvertirDatos();
    private final String URL_BASE = "https://www.googleapis.com/books/v1/volumes?q=";
    private final String API_KEY = "&key=tu_api_key";
    private final String MAXIMO_LIBROS = "&maxResults=10";



    //este metodo hace que cuando el ususario ingrese un espacio entre las palabras se concatene con un "+" para evitar errores en la busqueda
    public String modifyName(String data) {
        var modifiedName = URLEncoder.encode(data, StandardCharsets.UTF_8);

        return modifiedName;
    }

    public List<Libro> obtenerLibrosPorDefecto() {
        String busquedaGeneral = "a";

        String terminoFormateado = modifyName(busquedaGeneral);

        String url = URL_BASE + terminoFormateado + MAXIMO_LIBROS + API_KEY;

        var json = api.getData(url);

        RespuestaGoogleBook respuesta = convertirDatos.obtenerDatos(json, RespuestaGoogleBook.class);

        if (respuesta != null && respuesta.items() != null) {
            return respuesta.items().stream()
                    .map(Libro::new)
                    .toList();
        }

        return new ArrayList<>();
    }

    //Obtener libros por titulo
    public List<Libro> obtenerLibrosPorTitulo(String titulo) {
        String tituloFormateado = modifyName(titulo);

        String url = URL_BASE + "intitle:" + tituloFormateado + MAXIMO_LIBROS + API_KEY;

        var json = api.getData(url);

        RespuestaGoogleBook respuesta = convertirDatos.obtenerDatos(json, RespuestaGoogleBook.class);

        if (respuesta != null && respuesta.items() != null) {
            return respuesta.items().stream()
                    .map(Libro::new)
                    .toList();
        }

        return new ArrayList<>();
    }

    //Obtener libros por categorias
    public List<Libro> obtenerLibrosPorCategoria(String categoria) {
        String  categoriaFormateado = modifyName(categoria);

        String url = URL_BASE + "subject:"  + categoriaFormateado + MAXIMO_LIBROS + API_KEY;

        var json = api.getData(url);

        RespuestaGoogleBook respuesta = convertirDatos.obtenerDatos(json, RespuestaGoogleBook.class);

        if (respuesta != null && respuesta.items() != null) {
            return respuesta.items().stream()
                    .map(Libro::new)
                    .toList();
        }

        return new ArrayList<>();
    }

    //Obtener libros por autor
    public List<Libro> obtenerLibrosPorAutor(String autor) {
        String autorFormateado = modifyName(autor);

        String url = URL_BASE + "inauthor:" + autorFormateado + MAXIMO_LIBROS + API_KEY;

        var json = api.getData(url);

        RespuestaGoogleBook respuesta = convertirDatos.obtenerDatos(json, RespuestaGoogleBook.class);

        if (respuesta != null && respuesta.items() != null) {
            return respuesta.items().stream()
                    .map(Libro::new)
                    .toList();
        }

        return new ArrayList<>();
    }
}
