function debounce(fn, delay) {
    let timeoutId;
    return function(){ 
        if (timeoutId) {
            clearTimeout(timeoutId);
        }

        timeoutId = setTimeout(() => {
            fn();
        }, delay);
    }
};

function mostrarMensagem() {
    console.log("Funcao executada!");
}

const debouncedMostrarMensagem = debounce(mostrarMensagem, 2000);

debouncedMostrarMensagem();
debouncedMostrarMensagem();
debouncedMostrarMensagem();
