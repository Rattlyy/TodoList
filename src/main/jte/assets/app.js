// Dark-light mode
window.addEventListener('DOMContentLoaded', () => {
    let body = document.body;
    if (window.matchMedia) {
        if (window.matchMedia('(prefers-color-scheme: dark)').matches) {
            body.classList.add("p-dark-mode")
            body.classList.add("dark")
            console.log("dark")
        } else {
            body.classList.add("default")
            console.log("white")
        }
    } else {
        body.classList.add("default")
    }
});

function complete(id) {
    fetch('todos/' + id + "?done=true", {
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