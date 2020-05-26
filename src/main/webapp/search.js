function submitSearch() {
    let rawInput = $('#activities').val();

    let input = rawInput
        .replace(/;/, '\\;')
        .replace(/\s+/, ';');

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = () => {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            let json = JSON.parse(xhttp.responseText);
        }
    };

    xhttp.open('GET', '/rest/maps/search', true);
    xhttp.send(input);
}