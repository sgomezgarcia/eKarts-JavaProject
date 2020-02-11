function getClients() {
    fetch('./listClients.json')
        .then(result => result.json())
        .then(data => {
            console.log(data);
            printClients(data)
        });
}
function printClients(clients){
    let content = document.getElementById("table-body");
    content.innerHTML = "";
    console.log(clients);
    for (let client of clients){
        content.innerHTML += `
                        <tr>
                                    <td>${client.id}</td>
                                    <td>${client.name} ${client.surname}</td>
                                    <td> ${client.balance} €</td>
                                    <td>
                                        <a href="/e_karting_war_exploded/client?action=edit&idClient=${client.id}"
                                           class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"></i> Editar
                                        </a>
                                    </td>
                                </tr>
                    `
    }
}