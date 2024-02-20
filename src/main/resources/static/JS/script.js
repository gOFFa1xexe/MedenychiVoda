function validateInput(form) {
    var quantityInput = form.querySelector('input[name="quantity"]');
    var quantity = parseFloat(quantityInput.value);
    if (quantity === 0) {
        alert("Значення повинно бути більше 0!");
        return false;
    }
    return true;
}

function validateForm() {
    var address = document.getElementById("address").value;
    var city = document.getElementById("city").value;
    var customerNumber = document.getElementById("customerNumber").value;

    if (address == "" || city == "" || customerNumber == "") {
        alert("Будь ласка, заповніть всі обов'язкові поля.");
        return false;
    }
}
let orderItemsCount = 1;

function addOrderItem() {

    orderItemsCount++;

    const orderItemContainerHtml = `
                    <div class="orderItemContainer">
                        <div class="orderItem">
                          <h3>Пакет ${orderItemsCount}</h3>
                            <label for="packageCapacity${orderItemsCount}">Місткість:</label>
                            <select id="packageCapacity${orderItemsCount}" name="packageCapacity" required>
                                <option value="HALF_LITER">0.5 Літра</option>
                                <option value="ONE_AND_A_HALF_LITER">1.5 Літра</option>
                                <option value="FIVE_LITER">5 Літрів</option>
                            </select>
                            <label for="carbonationLevel${orderItemsCount}">Газованість:</label>
                            <select id="carbonationLevel${orderItemsCount}" name="carbonationLevel" required>
                                <option value="STRONG">Сильногазована</option>
                                <option value="LIGHT">Слабогазована</option>
                                <option value="NONE">Негазована</option>
                            </select>
                            <label for="packageQuantity${orderItemsCount}">Кількість:</label>
                            <input type="number" id="packageQuantity${orderItemsCount}" name="packageQuantity" required oninput="validity.valid||(value='');" min="1">
                            <button type="button" onclick="removePackage(this.parentNode)">Видалити</button>
                        </div>
                    </div>
                `;
    document.getElementById('orderItemsContainer').insertAdjacentHTML('beforeend', orderItemContainerHtml);
}
function createOrder(event) {
    event.preventDefault();
    const order = {
        address: document.getElementById('address').value,
        city: document.getElementById('city').value,
        customerNumber: document.getElementById('customerNumber').value,
        orderItems: []
    };

    for (let i = 1; i <= orderItemsCount; i++) {

        const packageCapacity = document.getElementById(`packageCapacity${i}`).value;
        const carbonationLevel = document.getElementById(`carbonationLevel${i}`).value;
        const packageQuantity = document.getElementById(`packageQuantity${i}`).value;

        const orderItem = {
            packageCapacity: packageCapacity,
            carbonationLevel: carbonationLevel,
            packageQuantity: parseInt(packageQuantity)
        };

        order.orderItems.push(orderItem);
    }

    fetch('/orders/create-order', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(order)
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Bad Request');
            }
            return response.text();
        })
        .then(data => {
            alert(data);
        })
        .catch(error => {
            alert('Помилка: ' + error.message);
        });
}

function removePackage(packageDiv) {
    packageDiv.remove();

    var containers = document.querySelectorAll('.orderItemContainer');
    containers.forEach((container, index) => {
        var packageNumber = index + 1;
        var heading = container.querySelector('h3');
        if (heading) {
            heading.innerText = 'Пакет ' + packageNumber;
        }
        container.querySelectorAll('select, input').forEach(input => {
            var id = input.getAttribute('id');
            var newName = input.getAttribute('name').replace(/\d+/, packageNumber);
            var newId = id.replace(/\d+/, packageNumber);
            input.setAttribute('id', newId);
            input.setAttribute('name', newName);
        });
    });
    orderItemsCount--
}