(function() {
  $(document).ready(function() {
    $('li:has(ul) > a').attr("data-toggle", "dropdown");
    return $('li:has(ul) > a').addClass("data-toggle");
  });

}).call(this);
