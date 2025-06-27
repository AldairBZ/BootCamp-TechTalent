// ========== AUTENTICACIÓN FRONTEND PARA Login.html ==========
const authTabs = document.querySelectorAll('.auth-tab');
const authTabContents = document.querySelectorAll('.auth-tab-content');
let currentUser = JSON.parse(localStorage.getItem('ic_user')) || null;

function showAuthTab(tab = 'login') {
  authTabs.forEach(btn => btn.classList.remove('active'));
  authTabContents.forEach(content => content.classList.remove('active'));
  document.querySelector(`.auth-tab[data-tab="${tab}"]`).classList.add('active');
  document.getElementById(`auth-${tab}`).classList.add('active');
}
authTabs.forEach(tabBtn => {
  tabBtn.addEventListener('click', () => showAuthTab(tabBtn.dataset.tab));
});
// Mostrar/ocultar contraseña
Array.from(document.querySelectorAll('.toggle-password')).forEach(btn => {
  btn.addEventListener('click', () => {
    const input = document.getElementById(btn.dataset.target);
    if(input.type === 'password') { input.type = 'text'; btn.innerHTML = '<i class="fas fa-eye-slash"></i>'; }
    else { input.type = 'password'; btn.innerHTML = '<i class="fas fa-eye"></i>'; }
  });
});
// Hash simple (SHA-256) para contraseñas
async function hashPassword(password) {
  const encoder = new TextEncoder();
  const data = encoder.encode(password);
  const hashBuffer = await crypto.subtle.digest('SHA-256', data);
  return Array.from(new Uint8Array(hashBuffer)).map(b => b.toString(16).padStart(2, '0')).join('');
}
// Login
const loginForm = document.getElementById('loginForm');
const loginFeedback = document.getElementById('loginFeedback');
if(loginForm) {
  loginForm.addEventListener('submit', async (e) => {
    e.preventDefault();
    const email = loginForm.querySelector('input[type="email"]').value.trim();
    const password = loginForm.querySelector('input[type="password"]').value;
    const users = JSON.parse(localStorage.getItem('ic_users')) || [];
    const hash = await hashPassword(password);
    const user = users.find(u => u.email === email && u.password === hash);
    if(user) {
      currentUser = { name: user.name, email: user.email, avatar: user.avatar };
      localStorage.setItem('ic_user', JSON.stringify(currentUser));
      loginFeedback.textContent = '¡Bienvenido de nuevo, ' + user.name + '!';
      setTimeout(()=>{
        // Redirección tras login
        const params = new URLSearchParams(window.location.search);
        const redirect = params.get('redirect') || 'Home.html';
        window.location.href = redirect;
      }, 1200);
    } else {
      loginFeedback.textContent = 'Correo o contraseña incorrectos.';
    }
  });
}
// Registro
const registerForm = document.getElementById('registerForm');
const registerFeedback = document.getElementById('registerFeedback');
if(registerForm) {
  registerForm.addEventListener('submit', async (e) => {
    e.preventDefault();
    const name = registerForm.querySelector('input[type="text"]').value.trim();
    const email = registerForm.querySelector('input[type="email"]').value.trim();
    const password = registerForm.querySelector('input[type="password"]').value;
    const users = JSON.parse(localStorage.getItem('ic_users')) || [];
    if(users.find(u => u.email === email)) {
      registerFeedback.textContent = 'Este correo ya está registrado.';
      return;
    }
    const hash = await hashPassword(password);
    const avatar = 'https://ui-avatars.com/api/?name=' + encodeURIComponent(name) + '&background=E63946&color=fff&rounded=true&size=64';
    users.push({ name, email, password: hash, avatar });
    localStorage.setItem('ic_users', JSON.stringify(users));
    registerFeedback.textContent = '¡Registro exitoso! Ahora puedes iniciar sesión.';
    setTimeout(()=>{showAuthTab('login');registerFeedback.textContent='';}, 1200);
  });
}
// Social login simulado
Array.from(document.querySelectorAll('.btn-social.google')).forEach(btn => {
  btn.addEventListener('click', () => {
    currentUser = { name: 'Google User', email: 'google@demo.com', avatar: 'IMG/taza.png' };
    localStorage.setItem('ic_user', JSON.stringify(currentUser));
    const params = new URLSearchParams(window.location.search);
    const redirect = params.get('redirect') || 'Home.html';
    window.location.href = redirect;
  });
});
Array.from(document.querySelectorAll('.btn-social.facebook')).forEach(btn => {
  btn.addEventListener('click', () => {
    currentUser = { name: 'Facebook User', email: 'facebook@demo.com', avatar: 'IMG/camisa1.png' };
    localStorage.setItem('ic_user', JSON.stringify(currentUser));
    const params = new URLSearchParams(window.location.search);
    const redirect = params.get('redirect') || 'Home.html';
    window.location.href = redirect;
  });
});
// Recuperar contraseña (simulado)
const forgotForm = document.getElementById('forgotForm');
const forgotFeedback = document.getElementById('forgotFeedback');
if(forgotForm) {
  forgotForm.addEventListener('submit', (e) => {
    e.preventDefault();
    const email = forgotForm.querySelector('input[type="email"]').value.trim();
    const users = JSON.parse(localStorage.getItem('ic_users')) || [];
    if(users.find(u => u.email === email)) {
      forgotFeedback.textContent = 'Te hemos enviado un enlace de recuperación (simulado).';
    } else {
      forgotFeedback.textContent = 'No existe ninguna cuenta con ese correo.';
    }
  });
} 