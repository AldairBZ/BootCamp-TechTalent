const insultos = [
  "Eres tan especial... como una piedra en el zapato.",
  "Mi idiota favorito desde 2003.",
  "Un amor... de los que uno se arrepiente.",
  "El más brillante... pero apagado.",
  "Sin ti estaría mejor, pero aburrido."
];

function insultoRandom() {
  const i = Math.floor(Math.random() * insultos.length);
  document.getElementById("frase-random").innerText = insultos[i];
}

function vistaPreviaInsulto() {
  let input = document.getElementById("insulto-input").value;
  document.getElementById("preview").innerText = input;
}

function resaltar(elemento) {
  elemento.style.backgroundColor = "#fcd5ce";
  elemento.style.borderColor = "#ff69b4";
}