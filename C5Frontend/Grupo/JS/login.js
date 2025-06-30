// Lógica de autenticación mejorada para Login.html
document.addEventListener('DOMContentLoaded', () => {

    const tabs = document.querySelectorAll('.auth-tab');
    const forms = document.querySelectorAll('.auth-form');
    const togglePassword = document.querySelector('.toggle-password');
    const loginForm = document.getElementById('login-form');
    const registerForm = document.getElementById('register-form');

    // Cambiar entre pestañas
    tabs.forEach(tab => {
        tab.addEventListener('click', () => {
            tabs.forEach(item => item.classList.remove('active'));
            forms.forEach(form => form.classList.remove('active'));
            tab.classList.add('active');
            document.getElementById(tab.dataset.form).classList.add('active');
        });
    });

    // Lógica para mostrar/ocultar contraseña
    if (togglePassword) {
        togglePassword.addEventListener('click', function () {
            this.classList.toggle('active');
            const passwordInput = this.previousElementSibling;
            if (passwordInput.type === 'password') {
                passwordInput.type = 'text';
                this.innerHTML = '<i class="fas fa-eye-slash"></i>';
            } else {
                passwordInput.type = 'password';
                this.innerHTML = '<i class="fas fa-eye"></i>';
            }
        });
    }

    // Lógica de Registro (simulada)
    if (registerForm) {
        registerForm.addEventListener('submit', (e) => {
            e.preventDefault();
            alert('¡Registro exitoso! (simulado). Ahora puedes iniciar sesión.');
            // Aquí iría la lógica para guardar el usuario
        });
    }

    // Lógica de Login (simulada)
    if (loginForm) {
        loginForm.addEventListener('submit', (e) => {
            e.preventDefault();
            alert('¡Has iniciado sesión correctamente! (simulado).');
            // Aquí iría la lógica para verificar el usuario
            // window.location.href = 'Home.html'; // Redirigir a la home
        });
    }
}); 