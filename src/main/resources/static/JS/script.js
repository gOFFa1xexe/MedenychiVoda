document.addEventListener("DOMContentLoaded", function() {
    var forms = document.querySelectorAll("form");

    forms.forEach(function(form) {
        form.addEventListener("submit", function(event) {
            var quantityInput = form.querySelector("input[name='quantity']");
            var quantityValue = parseInt(quantityInput.value);

            if (quantityValue === 0) {
                alert("Кількість повинна бути більше 0");
                event.preventDefault();
            }
        });
    });
});
