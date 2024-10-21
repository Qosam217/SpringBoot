function openForm() {
    $.ajax({
        type: "get",
        url: "/product/form",
        contentType: "html",
        success: function (productForm) {
            $('#myModal').modal('show');
            $('.modal-title').html("product Form");
            $('.modal-body').html(productForm);
        }
    });
}

function editForm(id) {
    $.ajax({
        type: "get",
        url: `/product/edit/${id}`,
        contentType: `html`,
        success: function (productForm) {
            $('#myModal').modal('show');
            $('.modal-title').html("product Form");
            $('.modal-body').html(productForm);
        }
    });
}

function deleteForm(id) {
    $.ajax({
        type: "get",
        url: `/product/deleteForm/${id}`,
        contentType: `html`,
        success: function (productForm) {
            $('#myModal').modal('show');
            $('.modal-title').html("Product Form");
            $('.modal-body').html(productForm);
        }
    });
}

function deleteProduct(id) {
    $.ajax({
        type: "get",
        url: `/product/delete/${id}`,
        contentType: `html`,
        success: function (response) {
            location.reload();
        }
    });
}
function reverseCheckboxValue() {
    const checkbox = document.getElementById("productActive");
    checkbox.checked = !checkbox.checked;  // Reverse the checkbox value
}