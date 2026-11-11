# 📚 Biblioteca Virtual

Una aplicación web desarrollada en **JavaServer Faces (JSF)** que funciona como una biblioteca virtual interactiva. Permite a los usuarios buscar, explorar y leer información detallada sobre una vasta colección de libros consumiendo en tiempo real la **API de Google Books**.

---

## Características Principales

*   **Búsqueda Avanzada:** Encuentra libros por título, autor o categoría utilizando la potencia de la API de Google Books.
*   **Visualización de Detalles:** Accede a la información completa de cada libro (sinopsis, fecha de publicación, autores, portada, etc.).
*   **Lectura y Exploración:** Interfaz intuitiva para navegar entre los resultados de búsqueda y descubrir nuevas lecturas.
*   **Diseño Responsivo:** Interfaz de usuario amigable y adaptable, construida sobre el ecosistema de JSF.

---

## 🛠️ Tecnologías Utilizadas

*   **Backend:** Java (JDK 11+)
*   **Framework Frontend/Web:** JSF (JavaServer Faces)
*   **Gestor de Dependencias:** Maven
*   **Integración de APIs:** [Google Books API](https://developers.google.com/books)
*   **Servidor de Aplicaciones:** Compatible con Apache Tomcat, GlassFish o WildFly.

---

## 📋 Requisitos Previos

Antes de ejecutar este proyecto localmente, asegúrate de tener instalado lo siguiente:

*   [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/downloads/) (Versión 11 o superior recomendada).
*   [Apache Maven](https://maven.apache.org/download.cgi) para la gestión de dependencias.
*   Un servidor de aplicaciones Java EE / Jakarta EE (ej. Apache Tomcat 9+).
*   Una **Clave de API** (API Key) de Google Cloud Platform habilitada para la API de Google Books.

---

## ⚙️ Instalación y Configuración

Sigue estos pasos para desplegar el proyecto en tu entorno local:

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/tu-usuario/tu-repositorio.git
   cd tu-repositorio
   ```

2. **Configurar la API Key de Google Books**
   Deberás configurar tu clave de acceso para que las peticiones a la API funcionen correctamente.
   Dirígete a la clase encargada de la conexión (ej. `GestorGoogleBook.java` o tu archivo de propiedades) y reemplaza la variable `API_KEY` con tu clave real.
   > **Nota:** Por motivos de seguridad, asegúrate de que el archivo que contiene la API Key privada esté incluido en tu `.gitignore`.

3. **Construir el proyecto con Maven**
   ```bash
   mvn clean install
   ```

4. **Desplegar en el Servidor**
    * Despliega el archivo `.war` generado en la carpeta `target/` en tu servidor de aplicaciones preferido.
    * Alternativamente, si usas un IDE como IntelliJ IDEA o Eclipse, puedes configurar un servidor de ejecución local apuntando directamente al proyecto.

5. **Acceder a la aplicación**
   Abre tu navegador web y dirígete a:
   `http://localhost:8080/tu-nombre-de-contexto`

---

## 📂 Estructura del Proyecto

```text
├── src/
│   ├── main/
│   │   ├── java/pe/utp/matricula/       # Código fuente Java (Beans, Servicios, Utilidades)
│   │   ├── webapp/                      # Archivos JSF (.xhtml), CSS, JS e imágenes
│   │   └── resources/                   # Archivos de configuración (persistence.xml, propiedades)
├── target/                              # Archivos compilados y empaquetados (.war)
├── pom.xml                              # Configuración de Maven y dependencias
└── README.md                            # Documentación del proyecto
```

---

## 🤝 Contribución

Las contribuciones son bienvenidas. Si deseas mejorar la biblioteca virtual, por favor haz un *fork* del repositorio, crea una nueva rama con tus características o correcciones, y envía un *Pull Request*.

## 📄 Licencia

Este proyecto está bajo la Licencia [MIT](LICENSE). Eres libre de utilizar, modificar y distribuir este software.