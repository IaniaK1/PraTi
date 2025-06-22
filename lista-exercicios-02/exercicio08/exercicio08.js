const vendas = [
  { cliente: "Rock", total: 100 }, 
  { cliente: "Joao", total: 200 }, 
  { cliente: "Rock", total: 50 }, 
  { cliente: "Louisy", total: 300 }, 
  { cliente: "Joao", total: 150 }, 
];

const totaisPorCliente = vendas.reduce((acumulador, venda) => {
    if (!acumulador[venda.cliente]) {
        acumulador[venda.cliente] = 0;
    }
    acumulador[venda.cliente] += venda.total;
    return acumulador;
}, {});

console.log(totaisPorCliente);
