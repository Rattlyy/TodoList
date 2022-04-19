const api = "http://localhost:8080/"

function complete(id) {
    fetch('todos/' + id + "?done=1", {
        method: 'PATCH',
        headers: {
            'Content-type': 'application/json; charset=UTF-8',
        },
    }).then(() => window.location.reload());
}

function remove(id) {
    fetch('todos/' + id, {
        method: 'DELETE',
        headers: {
            'Content-type': 'application/json; charset=UTF-8',
        },
    }).then(() => window.location.reload());
}

function add() {
    let value = document.getElementById("insert").value
    fetch("todos/?value=" + value, {
        method: 'POST',
        headers: {
            'Content-type': 'application/json; charset=UTF-8',
        },
    }).then(() => window.location.reload());
}