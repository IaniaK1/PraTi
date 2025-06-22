const prompt = require('prompt-sync')();

const numeroAleatorio = Math.floor(Math.random() * 100) + 1;

let numeroUsuario = parseInt(prompt("Digite um número entre 1 e 100: "));
cont = 1;

while (numeroUsuario !== numeroAleatorio) {
    if (isNaN(numeroUsuario) || numeroUsuario < 1 || numeroUsuario > 100) {
        console.log("Por favor, insira um número válido entre 1 e 100.");
    } else if (numeroUsuario < numeroAleatorio) {
        console.log("O número é maior que o que você digitou. Tente novamente.");
    } else {
        console.log("O número é menor que o que você digitou. Tente novamente.");
    }
    
    numeroUsuario = parseInt(prompt("Digite um número entre 1 e 100: "));
    cont++;
}

console.log(`Parabéns! Você acertou o número ${numeroAleatorio} em ${cont} tentativas.`);
console.log("Fim do jogo!");
