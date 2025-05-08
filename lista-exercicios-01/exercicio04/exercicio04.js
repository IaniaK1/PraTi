const prompt = require('prompt-sync')();

let opcao;

do {
    console.log("\nMenu Interativo:");
    console.log("1. Dizer Olá");
    console.log("2. Mostrar a data atual");
    console.log("3. Sair");
    
    opcao = parseInt(prompt("Escolha uma opção (1, 2 ou 3): "), 10);

    switch (opcao) {
        case 1:
            console.log("Olá +PraTi! Espero que você esteja tendo um ótimo dia!");
            break;
        case 2:
            console.log(`A data atual é: ${new Date().toLocaleString()}`);
            break;
        case 3:
            console.log("Até logo!");
            break;
        default:
            console.log("Opção inválida. Por favor, escolha 1, 2 ou 3.");
    }
} while (opcao !== 3);