# CasoBQ
Se pide desarrollar una demo que incluya algunas de las funcionalidades de la API de Evernote, listadas abajo.

Para desarrollar este ejemplo se ha partido del código de ejemplo del SDK de Evernote para Android, aprovechando las
partes ya implementadas y usando la API para las no implementadas.

Requisito 1. Exista una pantalla inicial de login, donde el usuario pueda introducir sus credenciales para 
tener acceso a su cuenta Evernote. (https://evernote.com/)

>> Se ha reducido la complejidad (de cara al usuario) del proceso de loggin. Yo no hay una actividad dedicada a obtener
autorización para usar la librería de Evernote (LoginActivity.java), si no que este proceso sucede en background, y se 
pide directamente al usuario que introduzca las credenciales de su cuenta de Evernote.
Si el usuario se ha logueado con antelación, este proceso es evitado.

Requisito 2. Una vez introducidos los credenciales, se mostrarán en pantalla todas las notas creadas por el usuario.

>> Las notas se muestran sobre la actividad MainActivity, a través del fragment NoteListFragment.

Requisito 3. Dicha pantalla tendrá un menú desplegable con dos opciones, una de ellas ordenará la lista por el título 
de la nota y la otra por fecha de creación o modificación.

>> Al pulsar el botón del menú aparecen dos nuevas opciones: Ordenar alfabéticamente y ordenar por fecha de creación. 
La implementación de los métodos que permiten ordenarlas ha sido desarrollada en la Actividad MainActivity.
Los métodos sortNotesByTitle() y sortNotesByDate(), y estos crean un nuevo fragment para mostrar las notas utilizando los
parámetros solicitados.

Requisito 4. Al hacer tap sobre una nota, se accederá al contenido de la misma. (No es necesario que las notas sean editables)

>> El fragment

Requisito 5. Existirá un botón para “añadir nota” que permitirá crear una nota (con título y cuerpo) y posteriormente 
guardarla.

>> Se usa el botón fab, que lanza el DialogFragment CreateNoteDialogFragment. En este diálogo se ha implementado código para
evitar que se puedan crear notas sin títulos.

Requisito 6.  Al crear una nota, se podrá elegir entre crearla mediante el teclado o bien escribir sobre la pantalla; 
donde un OCR convertirá la escritura en tipografía de computadora.

>> Se ha añadido un DialogFragment (CreateNoteOptions) que ofrece la posibilidad de elegir cómo se creará la nota (teclado
o pantalla)
Por el momento, sólo está implementada la opción del teclado.
