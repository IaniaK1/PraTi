const prompt = require('prompt-sync')();

let numero1 = Number(prompt('Digite o primeiro número: '));
let numero2 = Number(prompt('Digite o segundo número: '));

if (numero1 > numero2) {
    console.log(`Os numeros em ordem crescente: ${numero2}, ${numero1}`);
} else if (numero1 < numero2) {
    console.log(`Os numeros em ordem crescente: ${numero1}, ${numero2}`);
} else {
    console.log('Os números são iguais.');
}