const prompt = require('prompt-sync')();

let soma = 0;
let cont = 0;

while (true) {
    let numero = prompt("Digite um número decimal [0 Para finalizar]: ");
    numero = parseFloat(numero);

    if (isNaN(numero)) {
        console.log("Por favor, insira um número válido.");
        continue;
    }

    if (numero === 0) {
        break;
    }

    soma += numero;
    cont++;
}

if (cont > 0) {
    let media = soma / cont;
    console.log(`A média dos números digitados é: ${media}`);
} else {
    console.log("Nenhum número foi digitado.");
}