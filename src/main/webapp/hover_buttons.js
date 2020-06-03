function onEnter(caller) {
    $(caller).children('button').removeClass('hidden');
}

function onLeave(caller) {
    $(caller).children('button').addClass('hidden');
}