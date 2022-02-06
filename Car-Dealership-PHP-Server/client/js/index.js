$(document).ready(function () {
    displayCategories()
    filterCars()

    document.querySelector("#add-car-button").addEventListener("click", async () => {
        startingUrl = window.location.href

        const body = {
            brandId: document.querySelector("#brandId_add").value,
            model: document.querySelector("#model_add").value,
            productionYear: document.querySelector("#productionYear_add").value,
            enginePower: document.querySelector("#enginePower_add").value,
            fuel: document.querySelector("#fuel_add").value,
            color: document.querySelector("#color_add").value,
            price: document.querySelector("#price_add").value
        }
        try {
            const config = {
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(body)
            }
            const response = await fetch('../server/add_car.php', config)
            if (response.ok) {
                console.log("ok!")
            } else {
                console.log("not ok!")
            }
        } catch (error) {
            console.log("error!")
        }

        redirectTo(startingUrl)
    });

    document.querySelector("#remove-car-button").addEventListener("click", async () => {
        startingUrl = window.location.href

        const body = {
            carId: document.querySelector("#removed-car-id").value
        }
        try {
            const config = {
                method: 'DELETE',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(body)
            }
            const response = await fetch('../server/remove_car.php', config)
            if (response.ok) {
                console.log("ok!")
            } else {
                console.log("not ok!")
            }
        } catch (error) {
            console.log("error!")
        }

        redirectTo(startingUrl)
    });

    document.querySelector("#update-car-button").addEventListener("click", async () => {
        startingUrl = window.location.href

        const body = {
            carId: document.querySelector("#carId_update").value,
            brandId: document.querySelector("#brandId_update").value,
            model: document.querySelector("#model_update").value,
            productionYear: document.querySelector("#productionYear_update").value,
            enginePower: document.querySelector("#enginePower_update").value,
            fuel: document.querySelector("#fuel_update").value,
            color: document.querySelector("#color_update").value,
            price: document.querySelector("#price_update").value
        }
        try {
            const config = {
                method: 'PUT',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(body)
            }
            const response = await fetch('../server/update_car.php', config)
            if (response.ok) {
                console.log("ok!")
            } else {
                console.log("not ok!")
            }
        } catch (error) {
            console.log("error!")
        }

        redirectTo(startingUrl)
    });
})

function displayCategories() {
    $.get("../server/brands.php", {}, function (data) {
        let entries = data.split(";")
        let brand_panel = $("#brands")[0]
        for (let i = 0; i < entries.length - 1; i++) {
            let entry = entries[i]
            let brand = entry.split(",")
            let id = brand[0]
            let brand_name = brand[1]
            brand_panel.innerHTML += `<h3>${id}. ${brand_name} </h3><button onclick=filter(${id})>Filter</button><br>`
        }
    });
}

function filter(id) {
    redirectTo(window.location.pathname + "?filter=" + id)
}

function displayCars(entries) {
	$('#last_filter').html(`Last filter: ${Cookies.get('filter')}`)

    let car_panel = $("#cars")[0]
    for (let i = 0; i < entries.length - 1; i++) {
        let entry = entries[i].split(",")
        let id = entry[0]
        entry = entry.slice(2)
        let car_details = `id: ${id}, model: ${entry[0]}, production year: ${entry[1]}, engine capacity: ${entry[2]}l, 
        fuel: ${entry[3]}, color: ${entry[4]}, price: ${entry[5]}$`
        car_panel.innerHTML += "<h3>" + car_details + "</h3><br>"
    }
}

function filterCars() {
    let filter = getUrlParameter("filter")
    filter = filter === false ? 0 : parseInt(filter)

    $.get("../server/cars.php?filter=" + filter, {}, function (data) {
        let entries = data.split(";")
        displayCars(entries)
        document.querySelector("#remove-filter-button").addEventListener("click", async () => {
            window.location.href = `index.html`;
        });
        Cookies.set('filter', filter)
    });
}