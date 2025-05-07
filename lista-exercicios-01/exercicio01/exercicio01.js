const prompt = require('prompt-sync')();

let numero = prompt("Digite um número para verificar se ele é par ou impar: ");
numero = parseInt(numero, 10);

if (isNaN(numero)) {
    console.log("Por favor, insira um número inteiro válido.");
} else {
    if (numero % 2 === 0) {
        console.log("O número é par.");
    } else {
        console.log("O número é ímpar.");
    }
}
