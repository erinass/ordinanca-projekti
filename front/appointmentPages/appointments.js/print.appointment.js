document.addEventListener("DOMContentLoaded", function () {
    const pacient = document.getElementById('pacient');

    async function loadData(){
        console.log(window.location.search);
        const pacientId = window.location.search.split("=")[1].trim();
        const apiPacienti = new ApiPacienti();

        const data = await apiPacienti.findById(pacientId);

        console.log(data);

        if(!data.status || data.status === 200)
            pacient.innerHTML =  `
            <p><b>Name: </b> <i>${data.name}</i></p>
            <p><b>Age: </b> <i>${data.age}</i></p>
            <p><b>City: </b> <i>${data.city}</i></p>
            <p><b>Email: </b> <i>${data.email}</i></p>`;
    else
        alert(data.message)


}

loadData(); 

    });