package pe.utp.matricula.service;

public interface IConvertirDatos {
    //metodo para obtener los datos, pero se usa genericos para garantizar la escalabilidada de la app
    <T> T obtenerDatos(String json, Class<T> clase);
}
