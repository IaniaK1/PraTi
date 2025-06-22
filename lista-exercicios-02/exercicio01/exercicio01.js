function ehDataValida(dia, mes, ano) {
    if (ano < 1 || mes < 1 || mes > 12 || dia < 1 || dia > 31) {
      return false;
    }
    const diasNoMes = [31, (ehAnoBissexto(ano) ? 29 : 28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];

    if (dia > diasNoMes[mes - 1]) {
      return false;
    }

    return true;
}

function ehAnoBissexto(ano) {
    return (ano % 4 === 0 && ano % 100 !== 0) || (ano % 400 === 0);
}

console.log(ehDataValida(29, 2, 2020));
console.log(ehDataValida(31, 4, 2021));
