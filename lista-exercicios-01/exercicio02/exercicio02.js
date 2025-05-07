const prompt = require('prompt-sync')();

let idade = prompt("Digite a idade da pessoa a ser categorizada: ");
idade = parseInt(idade, 10);

if (isNaN(idade) || idade < 0) {
    console.log("Por favor, insira uma idade válida.");
}

let categoria = "";

if (idade >= 0 && idade <= 12) {
    categoria = "Criança";
}
else if (idade >= 13 && idade <= 17) {
    categoria = "Adolescente";
}
else if (idade >= 18 && idade <= 59) {
    categoria = "Adulta";
}
else if (idade >= 60) {
    categoria = "Idosa";
}
else {
    console.log("Idade inválida. Por favor, insira uma idade não negativa.");
}

console.log(`A pessoa de ${idade} anos é classificada como: ${categoria}`);