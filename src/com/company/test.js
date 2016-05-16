function getQuote()
{

    var arr = [];
    $.ajax({
        url : "http://api.forismatic.com/api/1.0/?method=getQuote&lang=en&format=json",
        method: "GET",
        dataType: "json",
        success: function(response) {
            var r = JSON.parse(response);
            arr[0] = r.quoteText;
            arr[1] = r.quoteAuthor;
        }

    });

    return arr;
}

getQuote();