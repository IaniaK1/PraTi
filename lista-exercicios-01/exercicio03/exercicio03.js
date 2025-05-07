const prompt = require('prompt-sync')();

let nota = prompt("Digite a nota do aluno: ");
nota = parseFloat(nota, 10);

if (isNaN(nota) || nota < 0 || nota > 10) {
    console.log("Por favor, insira uma nota válida entre 0 e 10.");
}

if (nota >= 0 && nota < 4) {
    console.log("Reprovado");
}
else if (nota >= 4 && nota < 7) {
    console.log("Recuperação");
}
else if (nota >= 7 && nota <= 10) {
    console.log("Aprovado");
}