const prompt = require('prompt-sync')();

let peso = prompt("Digite o seu peso em kg: ");
peso = parseFloat(peso);

let altura = prompt("Digite a sua altura em metros: ");
altura = parseFloat(altura);

if (isNaN(peso) || isNaN(altura) || peso <= 0 || altura <= 0) {
    console.log("Dados inválidos. Por favor, insira valores numéricos positivos.");
} else {
    let IMC = peso / (altura * altura);
    let classificacao = "";

    if (IMC < 18.5) {
        classificacao = "Abaixo do peso";
    } else if (IMC >= 18.5 && IMC < 25) {
        classificacao = "Peso normal";
    } else if (IMC >= 25 && IMC < 30) {
        classificacao = "Sobrepeso";
    } else {
        classificacao = "Obesidade";
    }

    console.log(`Seu IMC é: ${IMC.toFixed(2)}`);
    console.log(`Classificação: ${classificacao}`);
}
