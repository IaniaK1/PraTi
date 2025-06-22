function nomesOrdenadosPorPreco(produtos) {
    const ordenados = produtos.slice().sort((a, b) => a.preco - b.preco);
    return ordenados.map(produto => produto.nome);
}

const produtos = [
    { nome: 'Produto A', preco: 30 },
    { nome: 'Produto B', preco: 20 },
    { nome: 'Produto C', preco: 50 },
    { nome: 'Produto D', preco: 10 }
];

console.log(nomesOrdenadosPorPreco(produtos));