// Lógica para el carrito de compras
document.addEventListener('DOMContentLoaded', () => {
    const cartItemsContainer = document.getElementById('cart-items');
    const cartSummary = document.querySelector('.cart-summary');
    const emptyCartView = document.querySelector('.empty-cart');

    // Datos de ejemplo
    const sampleCart = [
        {
            id: 1,
            name: 'Taza "No eres tú, soy yo"',
            price: 12.99,
            quantity: 1,
            image: 'IMG/taza1.png'
        }
    ];

    function renderCart(cart) {
        if (!cart || cart.length === 0) {
            emptyCartView.style.display = 'block';
            cartSummary.style.display = 'none';
            cartItemsContainer.innerHTML = ''; // Limpiar por si acaso
            cartItemsContainer.appendChild(emptyCartView);
        } else {
            emptyCartView.style.display = 'none';
            cartSummary.style.display = 'block';
            
            const table = document.createElement('table');
            table.classList.add('cart-table');
            table.innerHTML = `
                <thead>
                    <tr>
                        <th>Producto</th>
                        <th>Cantidad</th>
                        <th>Precio</th>
                        <th>Total</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    ${cart.map(item => `
                        <tr data-product-id="${item.id}">
                            <td>
                                <div class="product-item">
                                    <img src="${item.image}" alt="${item.name}">
                                    <div class="product-details">
                                        <h4>${item.name}</h4>
                                    </div>
                                </div>
                            </td>
                            <td><input type="number" class="quantity-input" value="${item.quantity}" min="1"></td>
                            <td>${item.price.toFixed(2)}€</td>
                            <td>${(item.price * item.quantity).toFixed(2)}€</td>
                            <td><button class="remove-item-btn"><i class="fas fa-trash"></i></button></td>
                        </tr>
                    `).join('')}
                </tbody>
            `;
            cartItemsContainer.innerHTML = '';
            cartItemsContainer.appendChild(table);

            // Añadir listeners a los botones de eliminar
            document.querySelectorAll('.remove-item-btn').forEach(button => {
                button.addEventListener('click', (event) => {
                    const row = event.target.closest('tr');
                    const productId = parseInt(row.dataset.productId); // Necesitaremos un data-attribute
                    
                    // Filtrar el carrito para eliminar el producto
                    sampleCart = sampleCart.filter(item => item.id !== productId);
                    
                    // Volver a renderizar el carrito con los datos actualizados
                    renderCart(sampleCart);
                });
            });

            // Actualizar totales
            updateTotals(cart);
        }
    }

    function updateTotals(cart) {
        const subtotal = cart.reduce((sum, item) => sum + (item.price * item.quantity), 0);
        document.getElementById('cart-subtotal').textContent = `${subtotal.toFixed(2)}€`;
        document.getElementById('cart-total').textContent = `${subtotal.toFixed(2)}€`; // Asumiendo envío gratis
    }

    // Renderizar el carrito de ejemplo
    // Para probar el carrito vacío, cambia `sampleCart` a `[]`
    renderCart(sampleCart);
}); 