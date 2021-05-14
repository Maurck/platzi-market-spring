# Dependencias
1. pgAdmin
2. IntelliJ IDEA IDE
# Instrucciones
1. Ejecutar las consultas sql de los archivos BD/schema y DB/data en pgAdmin para crear y poblar la base de datos
2. Agregar el plugin MapStruct al IDE desde el siguiente link: https://plugins.jetbrains.com/plugin/10036-mapstruct-support
3. Abrir el proyecto con el archivo build.gradle desde el IDE
4. Correr el proyecto
# Rutas
Productos
1. Obtener productos: GET http://localhost:5000/platzi-market/api/products/all
2. Obtener producto por id: GET http://localhost:5000/platzi-market/api/products/{id}
3. Guardar producto: POST http://localhost:5000/platzi-market/api/products
Ejemplo de Body: 
{
        "name": "Palta",
        "categoryId": 1,
        "price": 20.0,
        "stock": 100,
        "active": true
 }
 4. Borrar producto: DELETE http://localhost:5000/platzi-market/api/products/{id}
Compras
1. Obtener compras: GET http://localhost:5000/platzi-market/api/purchases/all
2. Obtener compra por id: GET http://localhost:5000/platzi-market/api/purchases/{id}
3. Obtener compra por id del cliente: GET http://localhost:5000/platzi-market/api/purchases/client/{id}
4. Guardar compra: POST http://localhost:5000/platzi-market/api/purchases
Ejemplo de body:
{
    "clientId": "4546221",
    "date": "1992-08-10T17:30:00",
    "paymentMethod": "E",
    "comment": "",
    "state": "P",
    "items": []
}
5.Borrar compra: DELETE http://localhost:5000/platzi-market/api/purchases/{id}
 # Estado del proyecto
 1. En desarrollo
 # Caracteristicas futuras
 1. Dockerización
 2. UPDATE PRODUCT
