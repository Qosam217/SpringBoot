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



function getSelectedVariants() {
    console.log("123");
    let selectedVariants = [];
    const checkboxes = document.querySelectorAll('input[type="checkbox"]:checked');
    checkboxes.forEach((check) => {
        selectedVariants.push(check);
    })
    console.log(selectedVariants);
}


