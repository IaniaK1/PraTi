const prompt = require('prompt-sync')();

let lado_a = prompt("Digite o valor do lado A do triângulo: ");
let lado_b = prompt("Digite o valor do lado B do triângulo: ");
let lado_c = prompt("Digite o valor do lado C do triângulo: ");
lado_a = parseFloat(lado_a);
lado_b = parseFloat(lado_b);
lado_c = parseFloat(lado_c);

if (isNaN(lado_a) || isNaN(lado_b) || isNaN(lado_c)) {
    console.log("Por favor, insira valores numéricos válidos para os lados do triângulo.");
} else if (lado_a <= 0 || lado_b <= 0 || lado_c <= 0) {
    console.log("Os lados do triângulo devem ser maiores que zero.");
} else if (lado_a + lado_b <= lado_c || lado_a + lado_c <= lado_b || lado_b + lado_c <= lado_a) {
    console.log("Os lados informados não formam um triângulo.");
} else {
    if (lado_a === lado_b && lado_b === lado_c) {
        console.log("O triângulo é equilátero.");
    } else if (lado_a === lado_b || lado_a === lado_c || lado_b === lado_c) {
        console.log("O triângulo é isósceles.");
    } else {
        console.log("O triângulo é escaleno.");
    }
}
