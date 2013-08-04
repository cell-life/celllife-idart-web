
$(document).ready ->
    $('li:has(ul) > a').attr("data-toggle", "dropdown")
    $('li:has(ul) > a').addClass("data-toggle")
