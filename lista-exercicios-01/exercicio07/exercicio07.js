const prompt = require('prompt-sync')();

let macas = Number(prompt('Quantas maçãs você comprou? '));
let preco_maca = 0.30;
let preco_total;
if (macas < 12) {
    preco_total = macas * preco_maca;
} else {
    preco_maca = 0.25;
    preco_total = macas * preco_maca;
}
console.log(`O preço total é R$ ${preco_total.toFixed(2)}`);
