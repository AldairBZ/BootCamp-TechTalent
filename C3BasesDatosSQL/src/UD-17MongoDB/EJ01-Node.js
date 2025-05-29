// ---------------------------------------------------------------------------------------------------------

// 1.- Crear la base de datos
const mongoose = require('mongoose');

mongoose.connect('mongodb://localhost:27017/tiendainfo', {
    useNewUrlParser: true,
    useUnifiedTopology: true
}).then(() => console.log("Conectado a MongoDB"))
.catch(err => console.error(err));

//----------------------------------------------------------------------------------------------------------

// 2.- Crear la colección fabricantes e insertar datos
const fabricanteSchema = new mongoose.Schema({
    Codigo: Number,
    Nombre: String
});

const Fabricante = mongoose.model("Fabricante", fabricanteSchema);

// ---------------------------------------------------------------------------------------------------------

// 3.- Insertar datos
Fabricante.insertMany([
    { Codigo: 1, Nombre: "Intel" },
    { Codigo: 2, Nombre: "AMD" },
    { Codigo: 3, Nombre: "NVIDIA" },
    { Codigo: 4, Nombre: "Samsung" },
    { Codigo: 5, Nombre: "Sony" },
    { Codigo: 6, Nombre: "LG" },
    { Codigo: 7, Nombre: "Corsair" },
    { Codigo: 8, Nombre: "Seagate" },
    { Codigo: 9, Nombre: "Western Digital" },
    { Codigo: 10, Nombre: "Apple" }
]).then(() => console.log("Fabricantes insertados"));

// ---------------------------------------------------------------------------------------------------------

// 4.- Crear la colección articulos e insertar datos
const articuloSchema = new mongoose.Schema({
    Codigo: Number,
    Nombre: String,
    Precio: Number,
    Fabricante: Number
});

const Articulo = mongoose.model("Articulo", articuloSchema);

Articulo.insertMany([
    { Codigo: 1, Nombre: "Procesador i7", Precio: 300, Fabricante: 1 },
    { Codigo: 2, Nombre: "Tarjeta Gráfica RTX 3060", Precio: 500, Fabricante: 3 },
    { Codigo: 3, Nombre: "Memoria RAM 16GB", Precio: 120, Fabricante: 2 },
    { Codigo: 4, Nombre: "SSD 1TB", Precio: 150, Fabricante: 8 },
    { Codigo: 5, Nombre: "Monitor 27” 4K", Precio: 700, Fabricante: 5 },
    { Codigo: 6, Nombre: "Teclado mecánico", Precio: 100, Fabricante: 7 },
    { Codigo: 7, Nombre: "Mouse gaming", Precio: 80, Fabricante: 7 },
    { Codigo: 8, Nombre: "Auriculares inalámbricos", Precio: 200, Fabricante: 6 },
    { Codigo: 9, Nombre: "Disco duro externo 2TB", Precio: 130, Fabricante: 9 },
    { Codigo: 10, Nombre: "Smartphone", Precio: 1000, Fabricante: 10 }
]).then(() => console.log("Artículos insertados"));

// ---------------------------------------------------------------------------------------------------------

// 5.- Verificar los datos
Fabricante.find().then(data => console.log(data));
Articulo.find().then(data => console.log(data));

// ---------------------------------------------------------------------------------------------------------