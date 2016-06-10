(function() {

    // Just a basic sorting function to sort the table, nothing overly complex
    var sortTable = function() {
        var rows = $('#form-test tbody  tr').get();
        $('#form-test tbody tr').remove();
        rows.sort(function(a, b) {

            var A = Number(a.children[1].children[0].value);
            var B = Number(b.children[1].children[0].value);
            if (A < B) {
                return -1;
            }

            if (A > B) {
                return 1;
            }

            return 0;

        });

        var $tbody = $('#form-test tbody')

        $.each(rows, function(index, row) {
            $tbody.append(row);
        });
    }

    // Submit button functionality. Sorts the table (because the endpoint needs
    // the denominations to be submitted low to high, then submits the data to the
    // endpoint. If the endpoint returns a response, builds up a simple response table)
    $("#submit-button").click(function() {
        sortTable();
        var coinNames = $('input[name="coinNames"]').map(function() {
            return $(this).val();
        }).get().join();

        var coinValues = $('input[name="coinValues"]').map(function() {
            return $(this).val();
        }).get().join();

        var amount = $('input[name="coinAmount"]').val();

        $.ajax({
            url: "/change",
            method: "POST",
            data: {
                "coinNames": coinNames,
                "coinValues": coinValues,
                "totalAmount": amount
            }

        }).then(
            function(response) {
                var $div = $('<table>');
                $.each(response, function(index, combo) {
                    var $tr = $('<tr>');
                    var $tdOne = $('<td>');
                    $tdOne.text("#" + (index+1)); // So it starts at 1
                    $tr.append($tdOne);
                    $.each(combo, function(index, denom) {
                        var $td = $('<td>');
                        $td.text(denom.number + " of the coin name: " + denom.name);
                        $tr.append($td);
                    })
                    $div.append($tr);
                })
                $('html').append($div);
                console.log(response);
            },
            function(error) {
                alert("Sorry, an error has occured. Please make sure all fields are filled in. Do not incude dollar signs")
            }
        );
    });
})();
