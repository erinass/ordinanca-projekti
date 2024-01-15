document.addEventListener("DOMContentLoaded", function () {
    
    const pacient = document.getElementById('pacient');
    const btnDeletePacient = document.getElementById('btnDeletePacient');

    async function loadData(){
        console.log(window.location.search);
        const pacientId = window.location.search.split("=")[1].trim();
        const apiPacienti = new ApiPacienti();

        const data = await apiPacienti.findById(pacientId);

        console.log(data);

        if(!data.status || data.status === 200){
            pacient.innerHTML =  `
            <p><b>Name: </b> <i>${data.name}</i></p>
            <p><b>Age: </b> <i>${data.age}</i></p>
            <p><b>City: </b> <i>${data.city}</i></p>
            <p><b>Email: </b> <i>${data.email}</i></p>`;
        btnDeletePacient.style.display='block';
        } else
            alert(data.message)
    }
    loadData();

    async function deleteData(){
        const apiPacienti = new ApiPacienti();
        const pacientId = window.location.search.split("=")[1].trim();
        if(pacientId){
            if(confirm("Are you sure that you want to delete this pacient: "+pacientId)){
                const response = await apiPacienti.deleteById(pacientId);
                if(!response){
                    window.location.href ="../index.html";
                }
            }
        }

    }

    btnDeletePacient.addEventListener('click',function (){
        deleteData();
    })


    });