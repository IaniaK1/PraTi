const prompt = require('prompt-sync')();

let numero = prompt('Digite um número: ');

for (let i = 1; i <= 10; i++) {
    let resultado = numero * i;
    console.log(`${numero} x ${i} = ${resultado}`);
}