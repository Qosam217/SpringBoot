function openForm() {
    $.ajax({
        type: "get",
        url: "/variant/form",
        contentType: "html",
        success: function (variantForm) {
            $('#myModal').modal('show');
            $('.modal-title').html("Variant Form");
            $('.modal-body').html(variantForm);
        }
    });
}

function editForm(id) {
    $.ajax({
        type: "get",
        url: `/variant/edit/${id}`,
        contentType: `html`,
        success: function (variantForm) {
            $('#myModal').modal('show');
            $('.modal-title').html("variant Form");
            $('.modal-body').html(variantForm);
        }
    });
}

function deleteForm(id) {
    $.ajax({
        type: "get",
        url: `/variant/deleteForm/${id}`,
        contentType: `html`,
        success: function (variantForm) {
            $('#myModal').modal('show');
            $('.modal-title').html("variant Form");
            $('.modal-body').html(variantForm);
        }
    });
}

function deleteVariant(id) {
    $.ajax({
        type: "get",
        url: `/variant/delete/${id}`,
        contentType: `html`,
        success: function (response) {
            location.reload();
        }
    });
}

function reverseCheckboxValue() {
    const checkbox = document.getElementById("variantActive");
    checkbox.checked = !checkbox.checked;  // Reverse the checkbox value
}

function updateProduct(categoryId){
    $.ajax({
        type: "GET",
        url: `/variant/products-by-category/${categoryId}`,
        success: function(products) {
            const productSelect = document.getElementById("selectProduct");
            productSelect.innerHTML = '<option selected disabled value="0">Select Product</option>';

            products.forEach(product => {
                const newOption = document.createElement("option");
                newOption.value = product.id;
                newOption.text = product.name;
                productSelect.appendChild(newOption);
            });
        },
        error: function(error) {
            console.error('Error fetching products:', error);
        }
    });

}
