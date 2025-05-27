// 1.- TODO ESTO PARA HACERLO POR MONGO SHELL
// 2.- Crear la colección despachos e insertar datos
// 3.- MONGO SHELL

db.despachos.insertMany([
    { "Numero": 101, "Capacidad": 3 },
    { "Numero": 102, "Capacidad": 4 },
    { "Numero": 103, "Capacidad": 5 },
    { "Numero": 104, "Capacidad": 2 },
    { "Numero": 105, "Capacidad": 3 },
    { "Numero": 106, "Capacidad": 4 },
    { "Numero": 107, "Capacidad": 6 },
    { "Numero": 108, "Capacidad": 2 },
    { "Numero": 109, "Capacidad": 4 },
    { "Numero": 110, "Capacidad": 3 }
]);

// 4.- Crear la colección directores e insertar datos
// 5.- MONGO SHELL

db.directores.insertMany([
    { "DNI": "12345678", "NomApels": "Luis García", "DNIJefe": "98765432", "Despacho": 101 },
    { "DNI": "87654321", "NomApels": "Ana Rodríguez", "DNIJefe": "12345678", "Despacho": 102 },
    { "DNI": "56789012", "NomApels": "Carlos Pérez", "DNIJefe": "87654321", "Despacho": 103 },
    { "DNI": "98765432", "NomApels": "María López", "DNIJefe": null, "Despacho": 104 },
    { "DNI": "34567890", "NomApels": "Javier Fernández", "DNIJefe": "56789012", "Despacho": 105 },
    { "DNI": "23456789", "NomApels": "Paula Martínez", "DNIJefe": "34567890", "Despacho": 106 },
    { "DNI": "67890123", "NomApels": "Sergio Ramírez", "DNIJefe": "23456789", "Despacho": 107 },
    { "DNI": "45678901", "NomApels": "Beatriz Gómez", "DNIJefe": "67890123", "Despacho": 108 },
    { "DNI": "78901234", "NomApels": "Manuel Torres", "DNIJefe": "45678901", "Despacho": 109 },
    { "DNI": "90123456", "NomApels": "Carmen Vázquez", "DNIJefe": "78901234", "Despacho": 110 }
]);

// Verificar los datos
// Para ver los datos en Mongo Shell

db.despachos.find().pretty()
db.directores.find().pretty()