// Gestión del carrito usando localStorage
class Carrito {
    constructor() {
        this.items = JSON.parse(localStorage.getItem('carritoItems')) || [];
        this.actualizarUI();
    }

    // Añadir un producto al carrito
    añadirProducto(id, nombre, precio, imagen) {
        const productoExistente = this.items.find(item => item.id === id);
        
        if (productoExistente) {
            productoExistente.cantidad++;
        } else {
            this.items.push({
                id: id,
                nombre: nombre,
                precio: precio,
                imagen: imagen,
                cantidad: 1
            });
        }
        
        this.guardar();
        this.actualizarUI();
        this.mostrarNotificacion('¡Producto añadido!');
    }

    // Eliminar un producto del carrito
    eliminarProducto(id) {
        this.items = this.items.filter(item => item.id !== id);
        this.guardar();
        this.actualizarUI();
        this.mostrarNotificacion('Producto eliminado');
    }

    // Cambiar la cantidad de un producto
    cambiarCantidad(id, nuevaCantidad) {
        const producto = this.items.find(item => item.id === id);
        if (producto) {
            if (nuevaCantidad < 1) {
                this.eliminarProducto(id);
                return;
            }
            producto.cantidad = nuevaCantidad;
            this.guardar();
            this.actualizarUI();
        }
    }

    // Guardar el carrito en localStorage
    guardar() {
        localStorage.setItem('carritoItems', JSON.stringify(this.items));
    }

    // Calcular el total del carrito
    calcularTotal() {
        return this.items.reduce((total, item) => total + (item.precio * item.cantidad), 0);
    }

    // Actualizar la interfaz del carrito
    actualizarUI() {
        const contenedorCarrito = document.getElementById('cart-items');
        const subtotalElement = document.getElementById('subtotal');
        const totalElement = document.getElementById('total');
        
        if (!contenedorCarrito) return;

        // Si el carrito está vacío
        if (this.items.length === 0) {
            contenedorCarrito.innerHTML = `
                <div class="empty-cart">
                    <i class="fas fa-shopping-cart"></i>
                    <h3>Tu carrito está vacío</h3>
                    <p>¡Añade algunos productos!</p>
                    <a href="Producto.html" class="btn-primary">Ver Productos</a>
                </div>
            `;
            if (subtotalElement) subtotalElement.textContent = '0.00€';
            if (totalElement) totalElement.textContent = '0.00€';
            return;
        }

        // Mostrar productos en el carrito
        contenedorCarrito.innerHTML = this.items.map(item => `
            <div class="cart-item">
                <img src="${item.imagen}" alt="${item.nombre}">
                <div class="item-details">
                    <h3>${item.nombre}</h3>
                    <p>${item.precio.toFixed(2)}€</p>
                </div>
                <div class="item-quantity">
                    <button onclick="carrito.cambiarCantidad(${item.id}, ${item.cantidad - 1})">-</button>
                    <span>${item.cantidad}</span>
                    <button onclick="carrito.cambiarCantidad(${item.id}, ${item.cantidad + 1})">+</button>
                </div>
                <button class="remove-btn" onclick="carrito.eliminarProducto(${item.id})">
                    <i class="fas fa-trash"></i>
                </button>
            </div>
        `).join('');

        // Actualizar totales
        const total = this.calcularTotal();
        if (subtotalElement) subtotalElement.textContent = `${total.toFixed(2)}€`;
        if (totalElement) totalElement.textContent = `${total.toFixed(2)}€`;
    }

    // Mostrar notificación
    mostrarNotificacion(mensaje) {
        const notificacion = document.createElement('div');
        notificacion.className = 'notificacion';
        notificacion.textContent = mensaje;
        document.body.appendChild(notificacion);

        setTimeout(() => {
            notificacion.classList.add('mostrar');
            setTimeout(() => {
                notificacion.classList.remove('mostrar');
                setTimeout(() => notificacion.remove(), 300);
            }, 2000);
        }, 100);
    }

    // Vaciar el carrito
    vaciar() {
        this.items = [];
        this.guardar();
        this.actualizarUI();
        this.mostrarNotificacion('Carrito vaciado');
    }
}

// Inicializar el carrito
const carrito = new Carrito();

// Event Listeners
document.addEventListener('DOMContentLoaded', () => {
    // Actualizar contador del carrito en el navbar
    const contadorCarrito = document.querySelector('.cart-count');
    if (contadorCarrito) {
        contadorCarrito.textContent = carrito.items.length;
    }
});

// Función para añadir al carrito desde la página de productos
function addToCart(productoId) {
    carrito.añadirProducto(productoId);
} 