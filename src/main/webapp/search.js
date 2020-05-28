function submitSearch() {
    //Properly format the search params
    let input = $('#search').val().trim()
        .replace(/;/, '\\;')  //Escape semicolons with a backslash
        .replace(/\s+/, ';'); //Replace whitespace with semicolons

    let xhttp = new XMLHttpRequest();

    $('#sr-before-search').remove();

    xhttp.onreadystatechange = () => {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            let json = JSON.parse(xhttp.responseText);

            let table = $('#result-table');
            table.removeClass('hidden');
            table.empty(); //Clear any previous results

            for (let map of json) { //TODO fix appending stuff
                //Check if more results can fit
                if (!table.find(':last-child').length > 0 || table.find(':last-child:last-child').length >= 4) {
                    table.append('<tr></tr>');
                }

                let resultDiv = $('#sr-example').clone()

                let resID = `sr-${map.id}`;  //Map.id is unique, so this will be too
                resultDiv.prop('id', resID); //Set the ID

                resultDiv.find('.sr-name').text(map.name);
                resultDiv.find('.sr-desc').text(map.description);

                resultDiv.removeClass('hidden'); //Make the div visible

                let td = document.createElement('td');
                td.appendChild(resultDiv);
                table.find(':last-child')[0].append(td);
            }
        }
    };

    xhttp.open('GET', '/rest/maps/search?a=' + encodeURIComponent(input), true);
    xhttp.send();
}