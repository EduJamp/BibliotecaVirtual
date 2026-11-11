package pe.utp.matricula.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(
        @JsonProperty("volumeInfo") InfoVolumen infoVolumen,
        @JsonProperty("saleInfo") InfoVenta infoVenta,
        @JsonProperty("accessInfo") InfoAcceso infoAcceso
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record InfoVolumen(
            @JsonProperty("title") String titulo,
            @JsonProperty("authors") List<String> autores,
            @JsonProperty("publisher") String editorial,
            @JsonProperty("publishedDate") String fecPublicacion,
            @JsonProperty("description") String descripcion,
            @JsonProperty("language") String lenguaje,
            @JsonProperty("categories") List<String> categoria,
            @JsonProperty("imageLinks") Imagenes imagenes,
            @JsonProperty("industryIdentifiers") List<Identificador> identificadores
    ) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Imagenes(
            @JsonProperty("thumbnail") String img
    ) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Identificador(
            @JsonProperty("type") String tipo,
            @JsonProperty("identifier") String identificador
    ) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record InfoVenta(
            @JsonProperty("listPrice") Precio precio
    ) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Precio(
            @JsonProperty("amount") Double monto,
            @JsonProperty("currencyCode") String tipoMoneda
    ) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record InfoAcceso(
            @JsonProperty("webReaderLink") String linkLectura
    ) {}
}
