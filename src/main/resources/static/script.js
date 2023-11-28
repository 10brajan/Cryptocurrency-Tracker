document.getElementById('loadDefaultData').addEventListener('click', () => {
    fetch('/currency')
        .then(response => response.json())
        .then(data => displayData(data));
});

document.getElementById('customCurrencyForm').addEventListener('submit', (event) => {
    event.preventDefault();
    const symbols = document.getElementById('symbols').value;
    fetch(`/currency?symbols=${symbols}`)
        .then(response => response.json())
        .then(data => displayData(data));
});

function displayData(data) {
    const container = document.getElementById('dataContainer');
    container.innerHTML = '';

    if (data.error) {
        const errorDiv = document.createElement('div');
        errorDiv.className = 'error-message';
        errorDiv.innerText = "Nie można znaleźć informacji o podanych kryptowalutach.";
        container.appendChild(errorDiv);
    } else {
        Object.entries(data.cryptocurrencies).forEach(([symbol, price]) => {
            const currencyDiv = document.createElement('div');
            currencyDiv.className = 'cryptocurrency';
            currencyDiv.innerHTML = `
                <div class="symbol">${symbol}</div>
                <div class="price">${price.toFixed(2)}</div>
            `;
            container.appendChild(currencyDiv);
        });
    }
}


