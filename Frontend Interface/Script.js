const url_data = "http://localhost:8080/apiSound/melodies";

function validateForm(form) {
    var inputs = form.querySelectorAll("input, textarea");
    for (let i = 0; i < inputs.length; i++) {
        if (!inputs[i].value) {
            return false;
        }
    }
    return true;
}

window.postSound = function (e) {
    e.preventDefault();

    var form = document.querySelector("#soundForm");

    if (!validateForm(form)) {
        Swal.fire({
            icon: "error",
            title: "Oops...",
            text: "Campos incompletos en el formulario"
        });
        return;
    }

    var elements = form.elements;
    var btn = document.querySelector("#btnSubmit");
    btn.setAttribute("disabled", true);

    var obj = {};
    for (let i = 0; i < elements.length; i++) {
        var element = elements[i];
        if (element.name) {
            obj[element.name] = element.value;
        }
    }

    fetch(url_data, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(obj),
    })
    .then(response => {
        if (response.ok) {
            Swal.fire({
                icon: "success",
                title: "OK!",
                text: "El elemento fue insertado exitosamente"
            });
            btn.removeAttribute('disabled');
            form.reset();
            loadSounds();  
        } else {
            throw new Error("Fallo al insertar el elemnto");
        }
    })
    .catch(error => {
        Swal.fire({
            icon: "error",
            title: "Oops...",
            text: "Hubo problemas al tratar de insertar el elemento"
        });
        btn.removeAttribute('disabled');
    });

    return false;
}

window.deleteSound = function (id) {
    fetch(`${url_data}?id=${id}`, {
        method: "DELETE",
        headers: {
            "Content-Type": "application/json",
        },
    })
    .then(response => {
        if (response.ok) {
            Swal.fire({
                title: "Borrado exitosamente!",
                icon: "success",
                allowOutsideClick: false
            }).then(() => {
                loadSounds();
            });
        } else {
            throw new Error('Failed to delete data');
        }
    })
    .catch(error => {
        console.error('Error deleting data:', error);  // Añadir más información sobre el error
        Swal.fire("Error!", "", "error");
    });
};

document.addEventListener("DOMContentLoaded", (event) => {
    loadSounds();
});

function loadSounds() {
    fetch(url_data)
        .then(response => response.json())
        .then(data => {
            var soundList = document.querySelector("#soundList");
            soundList.innerHTML = ""; 
            data.forEach(data => {
                var card = document.createElement("div");
                card.className = "card";
                card.innerHTML = `
                    <img src="${data.images}" alt="${data.title}">
                    <h3>${data.title}</h3>
                    <p>genre: ${data.genre}</p>
                    <p>duration: ${data.duration}</p>
                    <button onclick='deleteSound(${data.id})'>Eliminar</button>
                `;
                soundList.appendChild(card);
            });
        })
        .catch(error => {
            console.error("Error loading data:", error);
            Swal.fire({
                icon: "error",
                title: "Error",
                text: "Hubo un problema al cargar la lista de data."
            });
        });
}