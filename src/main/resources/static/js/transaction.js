function openForm(id) {
    $.ajax({
        type: "get",
        url: `/transaction/create/${id}`,
        dataType: "html",
        success: function (transactionForm) {
            $('#myModal').modal('show');
            $('.modal-title').html("Transaction Form");
            $('.modal-body').html(transactionForm);
        }
    });
}


function deleteForm(orderHeaderId, orderDetailId) {
    $.ajax({
        type: "get",
        url: `/transaction/deleteForm/${orderHeaderId}/${orderDetailId}`,
        contentType: `html`,
        success: function (transactionForm) {
            $('#myModal').modal('show');
            $('.modal-title').html("Transaction Form");
            $('.modal-body').html(transactionForm);
        }
    });
}

function deleteVariant(orderHeaderId, orderDetailId) {
    $.ajax({
        type: "get",
        url: `/transaction/delete/${orderHeaderId}/${orderDetailId}`,
        contentType: `html`,
        success: function (response) {
            location.reload();
        }
    });
}

let selectedVariants = [];

function getSelectedVariants() {
    const hiddenInput = document.getElementById('selectedVariantIds');
    hiddenInput.value = selectedVariants.join(',');
}


