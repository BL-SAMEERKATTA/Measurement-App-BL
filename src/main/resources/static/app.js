const BASE_URL = 'http://localhost:8080';

async function calculate(operation) {
    showError('');

    const value1 = parseFloat(document.getElementById('value1').value);
    const value2 = parseFloat(document.getElementById('value2').value);
    const unit1 = document.getElementById('unit1').value;
    const unit2 = document.getElementById('unit2').value;

    if (isNaN(value1) || isNaN(value2)) {
        showError('Please enter valid numbers!');
        return;
    }

    const body = [
        { value: value1, unit: unit1 },
        { value: value2, unit: unit2 }
    ];

    try {
        const response = await fetch(`${BASE_URL}/quantity/${operation}`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(body)
        });

        if (!response.ok) throw new Error(`Server error: ${response.status}`);

        const result = await response.json();
        displayResult(operation, result);

    } catch (error) {
        showError(`Error: ${error.message}`);
    }
}

function displayResult(operation, result) {
    const resultBox = document.getElementById('result');
    if (operation === 'compare') {
        resultBox.textContent = result ? '✅ Both quantities are EQUAL' : '❌ Not EQUAL';
    } else if (operation === 'divide') {
        resultBox.textContent = `Result: ${result}`;
    } else {
        resultBox.textContent = `Result: ${result.value} ${result.unit}`;
    }
}

function showError(message) {
    const errorBox = document.getElementById('error');
    if (message) {
        errorBox.textContent = message;
        errorBox.style.display = 'block';
    } else {
        errorBox.style.display = 'none';
    }
}
