function onEnter(caller) {
    $(caller).parent().children('button').removeClass('hidden');
}

function onLeave(caller) {
    $(caller).parent().children('button').addClass('hidden');
}