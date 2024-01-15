document.addEventListener("DOMContentLoaded", function () {
    
    const report = document.getElementById('report');
    const btnDeleteReport = document.getElementById('btnDeleteReport');

    async function loadData(){
        console.log(window.location.search);
        const reportId = window.location.search.split("=")[1].trim();
        const apiReport = new ApiReport();

        const data = await apiReport.findById(reportId);

        console.log(data);

        if(!data.status || data.status === 200){
            report.innerHTML =  `
            <p><b>Pacient: </b> <i>${data.pacient}</i></p>
            <p><b>Anamnesis: </b> <i>${data.anamnesis}</i></p>
            <p><b>Therapy: </b> <i>${data.therapy}</i></p>
            <p><b>Disease: </b> <i>${data.disease}</i></p>
            <p><b>Description: </b> <i>${data.description}</i></p>`;
            btnDeleteReport.style.display='block';
        } else
            alert(data.message)
    }
    loadData();

    async function deleteData(){
        const apiReport = new ApiReport();
        const reportId = window.location.search.split("=")[1].trim();
        if(reportId){
            if(confirm("Are you sure that you want to delete this report: "+reportId)){
                const response = await apiReport.deleteById(reportId);
                if(!response){
                    window.location.href ="report.list.html";
                }
            }
        }

    }

    btnDeleteReport.addEventListener('click',function (){
        deleteData();
    })


    });