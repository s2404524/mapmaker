function submitSearch() {
    let rawInput = $('#activities').val();

    //Properly format the activities
    let input = rawInput.trim()
        .replace(/;/, '\\;')  //Escape semicolons with a backslash
        .replace(/\s+/, ';'); //Replace whitespace with semicolons

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = () => {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            let json = JSON.parse(xhttp.responseText);

            let resultsDiv = $('#results');
            resultsDiv.empty(); //Clear any previous results

            for (let map of json) {
                let resID = `sr-${map.id}`; //Map.id is unique, so this will be too
                resultsDiv.append(`<div id='${resID}' class='hidden'></div>`); //Append div to place map info in, hidden by default

                let thisDiv = $(`#${resID}`);

                //Append map information
                thisDiv.append(`<b>${map.name}</b>`);
                thisDiv.append(`<p>${map.description}</p>`);

                //Make the new div visible
                thisDiv.removeClass('hidden');
            }
        }
    };

    xhttp.open('GET', '/rest/maps/search?a=' + encodeURIComponent(input), true);
    xhttp.send();

    return false; //Cancel original submit
}