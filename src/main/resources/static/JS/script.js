
    function validateInput(form) {
    var quantityInput = form.querySelector('input[name="quantity"]');
    var quantity = parseFloat(quantityInput.value);
    if (quantity === 0) {
    alert("Значення повинно бути більше 0!");
    return false;
}
    return true;
}
