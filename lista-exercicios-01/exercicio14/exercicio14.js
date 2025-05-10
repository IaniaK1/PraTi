const prompt = require('prompt-sync')();

let numero = prompt("Digite um número inteiro não negativo para calcular o fatorial: ");
numero = parseInt(numero, 10);

if (isNaN(numero) || numero < 0) {
    console.log("Por favor, insira um número inteiro não negativo.");
} else {
    let fatorial = 1;

    for (let i = 1; i <= numero; i++) {
        fatorial *= i;
    }

    console.log(`O fatorial de ${numero} é: ${fatorial}`);
}