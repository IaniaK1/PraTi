const prompt = require('prompt-sync')();

let texto = prompt("Digite um texto: ");

let palavras = texto.split(" ");

let unicas = [];

for (let i = 0; i < palavras.length; i++) {
    let palavra = palavras[i].toLowerCase().replace(/[.,!?;:]/g, "").trim();

    if (unicas.indexOf(palavra) === -1) {
        unicas.push(palavra);
    }
}

console.log("Palavras únicas:", unicas.join(", "));
