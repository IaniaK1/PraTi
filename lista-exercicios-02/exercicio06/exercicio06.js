function memoize(fn) {
    const cache = {};
    
    return function(...args) {
        const key = JSON.stringify(args);
        if (cache[key]) {
            return cache[key];
        } else {
            const result = fn(...args);
            cache[key] = result;
            return result;
        }
    };
}

function soma(a, b) {
    return a + b;
}

const memoizedSoma = memoize(soma);

console.log(memoizedSoma(2, 3));
console.log(memoizedSoma(2, 3));
console.log(memoizedSoma(4, 5));
