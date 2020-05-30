function submitSearch() {
    //Properly format the search params
    let input = $('#searchbar').val().trim()
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

            for (let map of json) {
                let resultDiv = $('#sr-example').clone()

                let resID = `sr-${map.id}`;  //Map.id is unique, so this will be too
                resultDiv.prop('id', resID); //Set the ID

                resultDiv.find('.sr-name').text(map.name);
                resultDiv.find('.sr-desc').text(map.description);

                table.append(resultDiv);

                resultDiv.removeClass('hidden'); //Make the div visible
            }
        }
    };

    xhttp.open('GET', '/rest/maps/search?a=' + encodeURIComponent(input), true);
    xhttp.send();
}