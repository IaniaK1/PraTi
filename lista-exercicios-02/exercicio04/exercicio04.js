function fatorial(n) {
    if (n < 0) {
        throw new Error("n deve ser não negativo");
    }
    if (n == 0) {
        return 1;
    }
    return n * fatorial(n - 1);
}

console.log(fatorial(4));
console.log(fatorial(0));
