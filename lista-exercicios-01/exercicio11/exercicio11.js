const prompt = require('prompt-sync')();

let soma = 0;

for (i = 1; i <= 5; i++) {
    let num = prompt(`Digite o ${i}º número: `);
    soma = soma + parseInt(num);
}
console.log(`A soma dos números é: ${soma}`);
