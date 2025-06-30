// Script para el formulario de contacto (opcional, pero recomendado)
document.addEventListener('DOMContentLoaded', () => {
    const contactForm = document.getElementById('contacto-form');
    if (contactForm) {
        contactForm.addEventListener('submit', function(event) {
            event.preventDefault();
            const form = event.target;
            const feedback = document.getElementById('form-mensaje');
            feedback.textContent = 'Gracias por tu mensaje, adorable criatura. Te responderemos pronto (si nos apetece).';
            feedback.style.display = 'block';
            feedback.style.color = 'var(--rojo)';
            form.reset();

            setTimeout(() => {
                feedback.style.display = 'none';
            }, 5000);
        });
    }
}); 