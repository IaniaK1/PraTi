function paresParaObjeto(pares) {
  const objeto = {};
  for (let i = 0; i < pares.length; i++) {
    const [chave, valor] = pares[i];
    objeto[chave] = valor;
    }
    return objeto;
}

function objetoParaPares(objeto) {
    const pares = [];
    for (let chave in objeto) {
        if (objeto.hasOwnProperty(chave)) {
            pares.push([chave, objeto[chave]]);
        }
    }
    return pares;
}

const pares = [['nome', 'João'], ['idade', 30], ['cidade', 'São Paulo']];
const objeto = paresParaObjeto(pares);
console.log("Objeto:", objeto);

const paresConvertidos = objetoParaPares(objeto);
console.log("Pares convertidos:", paresConvertidos);
