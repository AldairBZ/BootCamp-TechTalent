document.addEventListener('DOMContentLoaded', () => {
  // Toggle menú móvil
  const mobileMenuBtn = document.getElementById('mobileMenuBtn');
  const navMenu = document.getElementById('navMenu');

  if (mobileMenuBtn && navMenu) {
    mobileMenuBtn.addEventListener('click', () => {
      navMenu.classList.toggle('show');
    });
  }
  
  // Dropdown toggle para menú "Sobre"
  const dropdownToggle = document.getElementById('nav-dropdown-toggle');
  if(dropdownToggle) {
    dropdownToggle.addEventListener('click', (event) => {
      event.preventDefault();
      const dropdown = event.currentTarget.nextElementSibling;
      if (dropdown) {
        dropdown.classList.toggle('open');
      }
    });
  }

  // Scroll to Top button
  const scrollToTopBtn = document.getElementById('scrollToTop');

  if (scrollToTopBtn) {
    window.addEventListener('scroll', () => {
      if (window.scrollY > 300) {
        scrollToTopBtn.classList.add('show');
      } else {
        scrollToTopBtn.classList.remove('show');
      }
    });

    scrollToTopBtn.addEventListener('click', () => {
      window.scrollTo({ top: 0, behavior: 'smooth' });
    });
  }
  
  // Scroll to sections
  const exploreProductsBtn = document.getElementById('explore-products-btn');
  const viewTestimonialsBtn = document.getElementById('view-testimonials-btn');

  function scrollToSection(selector) {
    const section = document.querySelector(selector);
    if (section) {
      section.scrollIntoView({ behavior: 'smooth' });
    }
  }

  if(exploreProductsBtn) {
    exploreProductsBtn.addEventListener('click', () => scrollToSection('#products'));
  }
  
  if(viewTestimonialsBtn) {
    viewTestimonialsBtn.addEventListener('click', () => scrollToSection('#testimonials'));
  }


  // Carrito
  const cartIconBtn = document.getElementById('cart-icon-btn');
  if(cartIconBtn) {
    cartIconBtn.addEventListener('click', goToCart);
  }

  const addToCartButtons = document.querySelectorAll('.add-to-cart-btn');
  addToCartButtons.forEach(button => {
    button.addEventListener('click', (event) => {
        const productElement = event.currentTarget;
        const producto = {
            id: productElement.dataset.productId,
            tipo: productElement.dataset.productType,
            texto: productElement.dataset.productText,
        };
        agregarAlCarrito(producto);
    });
  });

  const quickViewButtons = document.querySelectorAll('.quick-view-btn');
  quickViewButtons.forEach(button => {
    button.addEventListener('click', (event) => {
        const product = event.currentTarget.dataset.product;
        quickView(product);
    });
  });

  // Testimonials Slider
  const testimonials = document.querySelectorAll('.testimonial-card');
  const dots = document.querySelectorAll('.testimonial-dots .dot');
  const prevBtn = document.getElementById('prev-testimonial-btn');
  const nextBtn = document.getElementById('next-testimonial-btn');
  let currentTestimonial = 0;

  function showTestimonial(index) {
    testimonials.forEach((card, i) => {
        card.classList.remove('active');
        dots[i].classList.remove('active');
        if (i === index) {
            card.classList.add('active');
            dots[i].classList.add('active');
        }
    });
  }

  function nextTestimonial() {
    currentTestimonial = (currentTestimonial + 1) % testimonials.length;
    showTestimonial(currentTestimonial);
  }

  function prevTestimonial() {
    currentTestimonial = (currentTestimonial - 1 + testimonials.length) % testimonials.length;
    showTestimonial(currentTestimonial);
  }
  
  if(nextBtn) {
    nextBtn.addEventListener('click', nextTestimonial);
  }
  if(prevBtn) {
    prevBtn.addEventListener('click', prevTestimonial);
  }

  dots.forEach(dot => {
    dot.addEventListener('click', (event) => {
        const slideIndex = parseInt(event.currentTarget.dataset.slideTo);
        showTestimonial(slideIndex);
        currentTestimonial = slideIndex;
    });
  });

  // Newsletter
  const newsletterForm = document.getElementById('newsletter-form');
  if(newsletterForm) {
    newsletterForm.addEventListener('submit', subscribeNewsletter);
  }

  // MODAL de selección de producto a personalizar
  const btnPersonalizaModal = document.getElementById('btn-personaliza-modal');
  const modalPersonaliza = document.getElementById('modal-personaliza');
  const closeModalPersonaliza = document.getElementById('close-modal-personaliza');
  const selectTaza = document.getElementById('select-taza');
  const selectPolo = document.getElementById('select-polo');
  const personalizadorTaza = document.getElementById('personalizador-taza');
  const personalizadorPolo = document.getElementById('personalizador-polo');
  const volverCatalogoTaza = document.getElementById('volver-catalogo-taza');
  const volverCatalogoPolo = document.getElementById('volver-catalogo-polo');
  const catalogoProductos = document.getElementById('catalogo-productos');

  function ocultarPersonalizadores() {
    if (personalizadorTaza) personalizadorTaza.style.display = 'none';
    if (personalizadorPolo) personalizadorPolo.style.display = 'none';
  }

  if (btnPersonalizaModal && modalPersonaliza) {
    btnPersonalizaModal.addEventListener('click', () => {
      modalPersonaliza.style.display = 'flex';
    });
  }
  if (closeModalPersonaliza && modalPersonaliza) {
    closeModalPersonaliza.addEventListener('click', () => {
      modalPersonaliza.style.display = 'none';
    });
  }
  if (selectTaza) {
    selectTaza.addEventListener('click', () => {
      modalPersonaliza.style.display = 'none';
      if (catalogoProductos) catalogoProductos.style.display = 'none';
      ocultarPersonalizadores();
      if (personalizadorTaza) personalizadorTaza.style.display = 'block';
    });
  }
  if (selectPolo) {
    selectPolo.addEventListener('click', () => {
      modalPersonaliza.style.display = 'none';
      if (catalogoProductos) catalogoProductos.style.display = 'none';
      ocultarPersonalizadores();
      if (personalizadorPolo) personalizadorPolo.style.display = 'block';
    });
  }
  if (volverCatalogoTaza) {
    volverCatalogoTaza.addEventListener('click', () => {
      ocultarPersonalizadores();
      if (catalogoProductos) catalogoProductos.style.display = 'block';
    });
  }
  if (volverCatalogoPolo) {
    volverCatalogoPolo.addEventListener('click', () => {
      ocultarPersonalizadores();
      if (catalogoProductos) catalogoProductos.style.display = 'block';
    });
  }

  // Al añadir al carrito, volver al catálogo
  const btnCarritoTaza = document.getElementById('btnCarritoTaza');
  if (btnCarritoTaza) {
    btnCarritoTaza.addEventListener('click', () => {
      setTimeout(() => {
        ocultarPersonalizadores();
        if (catalogoProductos) catalogoProductos.style.display = 'block';
      }, 300);
    });
  }
  const btnCarritoPolo = document.getElementById('btnCarritoCamisa');
  if (btnCarritoPolo) {
    btnCarritoPolo.addEventListener('click', () => {
      setTimeout(() => {
        ocultarPersonalizadores();
        if (catalogoProductos) catalogoProductos.style.display = 'block';
      }, 300);
    });
  }

  // Personalizador de Taza
  setupPersonalizador({
    inputTextoId: 'inputTexto',
    textoPreviewId: 'textoPersonalizado',
    tamanioInputId: 'tamanioFuente',
    tamanioPreviewId: 'previewTamanio',
    colorInputId: 'inputColor',
    fuenteSelectId: 'fuente',
    estiloSelectId: 'estilo',
    btnAplicarId: 'btnAplicar',
    btnAgregarCarritoId: 'btnCarritoTaza',
    tipoProducto: 'Taza',
    stickersSelector: '.galeria-de-stickers button',
    previewContainerSelector: '.producto-preview'
  });

  // Personalizador de Polo/Camisa
  setupPersonalizador({
    inputTextoId: 'inputTextoCustom',
    textoPreviewId: 'textoDiseñado',
    tamanioInputId: 'tamanioFuenteCustom',
    tamanioPreviewId: 'previewTamanioCustom',
    colorInputId: 'inputColorCustom',
    fuenteSelectId: 'fuenteCustom',
    estiloSelectId: 'estiloCustom',
    btnAplicarId: 'btnAplicarCamisa',
    btnAgregarCarritoId: 'btnCarritoCamisa',
    tipoProducto: 'Polo',
    stickersSelector: '.sticker-galeria button',
    previewContainerSelector: '.preview-producto'
  });

  // Añadir al carrito desde el catálogo
  document.querySelectorAll('.add-to-cart-btn').forEach(btn => {
    btn.addEventListener('click', function() {
      const nombre = this.getAttribute('data-product-nombre');
      const tipo = this.getAttribute('data-product-tipo');
      const precio = this.getAttribute('data-product-precio');
      const img = this.getAttribute('data-product-img');
      const producto = {
        nombre,
        tipo,
        precio,
        img
      };
      // Añadir al carrito en localStorage
      let carrito = JSON.parse(localStorage.getItem('carrito')) || [];
      carrito.push(producto);
      localStorage.setItem('carrito', JSON.stringify(carrito));
      actualizarCarritoContador();
      // Aviso intuitivo
      alert(`¡${nombre} añadido al carrito!`);
    });
  });
});


// Carrito básico con almacenamiento local y contador
// Estas funciones se quedan fuera para poder ser usadas por otras paginas si es necesario
let carrito = JSON.parse(localStorage.getItem('carrito')) || [];

function actualizarCarritoContador() {
  const cartCount = document.getElementById('cartCount');
  if (cartCount) {
    cartCount.textContent = carrito.length;
  }
}

function agregarAlCarrito(producto) {
  carrito.push(producto);
  localStorage.setItem('carrito', JSON.stringify(carrito));
  actualizarCarritoContador();
  alert(`Añadido al carrito: ${producto.tipo}${producto.texto ? ' - "' + producto.texto + '"' : ''}`);
}

// Llama para actualizar en la carga inicial de la página
document.addEventListener('DOMContentLoaded', actualizarCarritoContador);


// Funciones para ir al carrito (puedes redirigir a tu página carrito)
function goToCart() {
  // window.location.href = 'Carrito.html';
  alert('Funcionalidad de carrito aún en desarrollo. Redirigiendo a la página del carrito.');
  window.location.href = 'Carrito.html';
}

// Opcional: Funciones para pruebas o futuros desarrollos
function quickView(product) {
  alert('Vista rápida de ' + product + ' - funcionalidad en desarrollo');
}

function subscribeNewsletter(event) {
  event.preventDefault();
  const email = event.target.querySelector('input[type="email"]').value;
  alert(`Gracias por suscribirte con ${email}! Recibirás insultos cariñosos pronto.`);
  event.target.reset();
}


// El personalizador se queda fuera porque probablemente se usa en Producto.html
// y necesita su propia lógica de inicialización.
function setupPersonalizador(config) {
  const {
    inputTextoId,
    textoPreviewId,
    tamanioInputId,
    tamanioPreviewId,
    colorInputId,
    fuenteSelectId,
    estiloSelectId,
    btnAplicarId,
    btnAgregarCarritoId,
    tipoProducto,
    stickersSelector,
    previewContainerSelector
  } = config;

  const inputTexto = document.getElementById(inputTextoId);
  const textoPreview = document.getElementById(textoPreviewId);
  const tamanioInput = document.getElementById(tamanioInputId);
  const tamanioPreview = document.getElementById(tamanioPreviewId);
  const colorInput = document.getElementById(colorInputId);
  const fuenteSelect = document.getElementById(fuenteSelectId);
  const estiloSelect = document.getElementById(estiloSelectId);
  const btnAplicar = document.getElementById(btnAplicarId);
  const btnAgregarCarrito = document.getElementById(btnAgregarCarritoId);
  const stickers = document.querySelectorAll(stickersSelector);
  const previewContainer = previewContainerSelector ? document.querySelector(previewContainerSelector) : textoPreview?.parentElement;

  if (
    !inputTexto || !textoPreview || !tamanioInput || !tamanioPreview ||
    !colorInput || !fuenteSelect || !estiloSelect || !btnAplicar || !btnAgregarCarrito || !previewContainer
  ) return;

  // Inicializar posición y estilos del texto
  textoPreview.style.position = 'absolute';
  if (!textoPreview.style.left) textoPreview.style.left = '50px';
  if (!textoPreview.style.top) textoPreview.style.top = '50px';
  textoPreview.style.cursor = 'grab';
  textoPreview.style.userSelect = 'none';

  // Actualiza tamaño fuente en preview en tiempo real
  tamanioInput.addEventListener('input', () => {
    tamanioPreview.textContent = `${tamanioInput.value}px`;
    textoPreview.style.fontSize = `${tamanioInput.value}px`;
  });

  // Cambia color en tiempo real
  colorInput.addEventListener('input', () => {
    textoPreview.style.color = colorInput.value;
  });

  // Cambia fuente en tiempo real
  fuenteSelect.addEventListener('change', () => {
    textoPreview.style.fontFamily = fuenteSelect.value;
  });

  // Cambia estilo en tiempo real
  estiloSelect.addEventListener('change', () => {
    textoPreview.style.fontStyle = estiloSelect.value.includes('italic') ? 'italic' : 'normal';
    textoPreview.style.fontWeight = estiloSelect.value.includes('bold') ? 'bold' : 'normal';
  });

  // Aplica texto y estilos al hacer clic en aplicar
  btnAplicar.addEventListener('click', () => {
    textoPreview.textContent = inputTexto.value || 'Tu texto aquí';
    textoPreview.style.fontSize = `${tamanioInput.value}px`;
    textoPreview.style.color = colorInput.value;
    textoPreview.style.fontFamily = fuenteSelect.value;
    textoPreview.style.fontStyle = estiloSelect.value.includes('italic') ? 'italic' : 'normal';
    textoPreview.style.fontWeight = estiloSelect.value.includes('bold') ? 'bold' : 'normal';
  });

  // Drag & drop para el texto personalizado
  let isDraggingText = false, offsetXText = 0, offsetYText = 0;
  textoPreview.addEventListener('mousedown', function (e) {
    isDraggingText = true;
    const rect = textoPreview.getBoundingClientRect();
    offsetXText = e.clientX - rect.left;
    offsetYText = e.clientY - rect.top;
    textoPreview.style.cursor = 'grabbing';
  });
  document.addEventListener('mousemove', function (e) {
    if (isDraggingText) {
      const contRect = previewContainer.getBoundingClientRect();
      let left = e.clientX - contRect.left - offsetXText;
      let top = e.clientY - contRect.top - offsetYText;
      textoPreview.style.left = `${left}px`;
      textoPreview.style.top = `${top}px`;
    }
  });
  document.addEventListener('mouseup', function () {
    isDraggingText = false;
    textoPreview.style.cursor = 'grab';
  });

  // Añadir stickers/emojis (drag & drop y doble clic para eliminar)
  stickers.forEach(button => {
    button.addEventListener('click', () => {
      const stickerSrc = button.getAttribute('data-sticker');
      if (stickerSrc) {
        const sticker = document.createElement('img');
        sticker.src = stickerSrc;
        sticker.className = 'sticker';
        sticker.style.position = 'absolute';
        sticker.style.left = '50px';
        sticker.style.top = '50px';
        sticker.style.width = '60px';
        sticker.style.cursor = 'grab';
        previewContainer.appendChild(sticker);

        // Drag & drop para stickers
        let isDraggingSticker = false, offsetXSticker = 0, offsetYSticker = 0;
        sticker.addEventListener('mousedown', function (e) {
          isDraggingSticker = true;
          const rect = sticker.getBoundingClientRect();
          offsetXSticker = e.clientX - rect.left;
          offsetYSticker = e.clientY - rect.top;
          sticker.style.cursor = 'grabbing';
        });
        document.addEventListener('mousemove', function (e) {
          if (isDraggingSticker) {
            const contRect = previewContainer.getBoundingClientRect();
            let left = e.clientX - contRect.left - offsetXSticker;
            let top = e.clientY - contRect.top - offsetYSticker;
            sticker.style.left = `${left}px`;
            sticker.style.top = `${top}px`;
          }
        });
        document.addEventListener('mouseup', function () {
          isDraggingSticker = false;
          sticker.style.cursor = 'grab';
        });
        // Doble clic para eliminar
        sticker.addEventListener('dblclick', () => {
          sticker.remove();
        });
      }
    });
  });

  // Agregar al carrito con detalles del producto
  btnAgregarCarrito.addEventListener('click', () => {
    const productoPersonalizado = {
      tipo: tipoProducto,
      texto: inputTexto.value,
      tamanioFuente: tamanioInput.value,
      color: colorInput.value,
      fuente: fuenteSelect.value,
      estilo: estiloSelect.value,
    };
    agregarAlCarrito(productoPersonalizado);
  });
} 